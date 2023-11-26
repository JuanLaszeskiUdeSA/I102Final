package pharma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class PharmacyTest {

  @Test public void testNewPharmacyIsEmpty() {
    assertTrue( new Pharmacy().medication( "fever" ).isEmpty() );
  }

  @Test public void testMedicationForASymptomContainsARegisteredDrug() {
    pharma = pharmaWithParacetamol();

    assertFalse( pharma.medication( "fever" ).isEmpty() );
    assertTrue( pharma.medication( "fever" ).contains( "paracetamol" ) );
  }

  @Test public void testMedicationForAnotherSymptomContainsARegisteredDrug() {
    assertTrue( pharmaWithParacetamol().medication( "headache" ).contains( "paracetamol" ) );
  }

  @Test public void testRegisterAnotherDrugDoesNotModifyPreviousMedication() {
    pharma = pharmaWithParacetamolAndIbuprofeno();

    assertTrue( pharma.medication( "fever" ).contains( "paracetamol" ) );
  }

  @Test public void testMedicationForSeveralSymptomAndDrugs() {
    pharma = pharmaWithParacetamolAndIbuprofeno();

    assertTrue( pharma.medication( "headache" ).contains( "paracetamol" ) );
    assertTrue( pharma.medication( "headache" ).contains( "ibuprofeno" ) );
  }

  @Test public void testSafeMedicationForASymptom() {
    Pharmacy pharma = pharmaWithParacetamolAndIbuprofeno();

    assertFalse( pharma.safeMedicationFor( "headache", "stomachache" ).contains( "ibuprofeno" ) );
  }


  @Test public void testReplaceADrugInMedication() {
    Pharmacy pharma = pharmaWithParacetamolAndClonacho();

    assertFalse( pharma.medication( "headache" ).contains( "clonacho" ) );
    pharma.replacement( "paracetamol", "clonacho" );
    assertTrue( pharma.medication( "headache" ).contains( "clonacho" ) );

  }

  @Test public void testReplaceADrugInSafeMedication() {
    Pharmacy pharma = pharmaWithParacetamolAndClonacho();

    assertFalse( pharma.safeMedicationFor( "headache", "fever" ).contains( "clonacho" ) );
    pharma.replacement( "paracetamol", "clonacho" );
    assertTrue( pharma.safeMedicationFor( "headache", "fever" ).contains( "clonacho" ) );

  }

  @Test public void testCannotRegisterADrugTwice() {
    Pharmacy pharma = pharmaWithParacetamol();

    assertThrowsLike( () -> pharma.register( paracetamol() ), Pharmacy.drogaYaRegistrada );
  }

  @Test public void testCannotReplaceNotRegisteredDrug() {
    Pharmacy pharma = new Pharmacy();

    assertThrowsLike( () -> pharma.replacement( "paracetamol", "clonacho" ),
            Pharmacy.noSePuedeReemplazar + "paracetamol" );
  }

  @Test public void testPharmacyReplaceADrugWithAnotherNotRegisteredDrug() {
    Pharmacy pharma = pharmaWithParacetamol();

    assertThrowsLike( () -> pharma.replacement( "paracetamol", "clonacho" ),
            "clonacho" + Pharmacy.noPuedeSerReemplazo );
  }

  @Test public void testReplaceSeveralDrugsInSafeAndMedication() {
    Pharmacy pharma = pharmaWithParacetamolAndIbuprofeno();
    pharma.register(clonacho());
    pharma.replacement( "paracetamol", "clonacho" );

    assertEquals( 3, pharma.medication( "headache" ).size() );
    assertEquals( 2, pharma.safeMedicationFor( "headache", "stomachache" ).size() );
  }

  @Test public void testReplaceADrugWithCollateral() {
    Pharmacy pharma = pharmaWithParacetamolIbuprofenoAndClonacho();
    pharma.replacement( "paracetamol", "clonacho" );

    assertEquals( 2, pharma.medication( "fever" ).size() );
    assertEquals( 1, pharma.safeMedicationFor( "fever", "heartburn" ).size() );
  }

  @Test public void testReplaceADrugForAnotherWithCollateral() {
    Pharmacy pharma = pharmaWithParacetamolIbuprofenoAndClonacho();
    pharma.replacement( "paracetamol", "clonacho" );

    assertEquals( 2, pharma.medication( "fever" ).size() );
    assertEquals( 1, pharma.safeMedicationFor( "fever", "insomnia" ).size() );
  }

  private Pharmacy pharma;
  private Drug paracetamol() {return new Drug("paracetamol").releaves("fever", "headache").collateral("heartburn");}
  private Drug clonacho() {return new Drug("clonacho").releaves("anxiety").collateral("testophobia", "insomnia");}

  private Pharmacy pharmaWithParacetamol() {
    Pharmacy pharma = new Pharmacy();
    pharma.register(paracetamol());
    return pharma;
  }
  private Pharmacy pharmaWithParacetamolAndIbuprofeno() {
    Pharmacy pharma = pharmaWithParacetamol();
    pharma.register(new Drug("ibuprofeno").releaves("headache").collateral("stomachache"));
    return pharma;
  }
  private Pharmacy pharmaWithParacetamolAndClonacho(){
    Pharmacy pharma = pharmaWithParacetamol();
    pharma.register(clonacho());
    return pharma;
  }
  private Pharmacy pharmaWithParacetamolIbuprofenoAndClonacho(){
    Pharmacy pharma = pharmaWithParacetamolAndIbuprofeno();
    pharma.register(clonacho());
    return pharma;
  }

  private void assertThrowsLike( Executable executable, String message ) {
    assertEquals( message, assertThrows( Exception.class, executable ).getMessage() );
  }
}