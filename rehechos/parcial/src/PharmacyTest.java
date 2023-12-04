

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PharmacyTest {

  @BeforeEach
    public void setUp() {
        pharma = new Pharmacy();
        pharmaWithParacetamol = new Pharmacy();
        pharmaWithParacetamol.register( new Drug( "paracetamol" ).releaves( "fever", "headache" ) );
        pharmaWithIbuprofeno = new Pharmacy();
        pharmaWithIbuprofeno.register( new Drug( "ibuprofeno" ).releaves( "headache" ).collateral( "stomachache" ) );
        pharmaWithClonacho = new Pharmacy();
        pharmaWithClonacho.register( new Drug( "clonacho" ).releaves( "anxiety" ).collateral( "testophobia", "insomnia" ) );
        pharmaWithParacetamolAndIbuprofeno = new Pharmacy();
        pharmaWithParacetamolAndIbuprofeno.register( new Drug( "paracetamol" ).releaves( "fever", "headache" ) );
        pharmaWithParacetamolAndIbuprofeno.register( new Drug( "ibuprofeno" ).releaves( "headache" ).collateral( "stomachache" ) );
        pharmaWithParacetamolAndClonacho = new Pharmacy();
        pharmaWithParacetamolAndClonacho.register( new Drug( "paracetamol" ).releaves( "fever", "headache" ) );
        pharmaWithParacetamolAndClonacho.register( new Drug( "clonacho" ).releaves( "anxiety" ).collateral( "testophobia", "insomnia" ) );
        pharmaWithIbuprofenoAndClonacho = new Pharmacy();
        pharmaWithIbuprofenoAndClonacho.register( new Drug( "ibuprofeno" ).releaves( "headache" ).collateral( "stomachache" ) );
        pharmaWithIbuprofenoAndClonacho.register( new Drug( "clonacho" ).releaves( "anxiety" ).collateral( "testophobia", "insomnia" ) );
        pharmaWithParacetamolAndIbuprofenoAndClonacho = new Pharmacy();


    }
  
  @Test public void testNewPharmacy() {
    assertTrue(pharma.medication( "fever" ).isEmpty() );
  }
  
  @Test public void testPharmacyT1() {
    assertFalse( pharmaWithParacetamol.medication( "fever" ).isEmpty() );
    assertTrue( pharmaWithParacetamol.medication( "fever" ).contains( "paracetamol" ) );
  }

  @Test public void testPharmacyT3() {
    assertTrue( pharmaWithParacetamol.medication( "headache" ).contains( "paracetamol" ) );
  }
  
  @Test public void testPharmacyT2() {
    assertTrue( pharmaWithParacetamolAndIbuprofeno.medication( "fever" ).contains( "paracetamol" ) );
  }
  
  @Test public void testPharmacyT4() {
    assertTrue( pharmaWithParacetamolAndIbuprofeno.medication( "headache" ).contains( "paracetamol" ) );
    assertTrue( pharmaWithParacetamolAndIbuprofeno.medication( "headache" ).contains( "ibuprofeno" ) );
  }
  
  @Test public void testPharmacyT5() {
    Pharmacy pharma = new Pharmacy();
    assertFalse( pharmaWithParacetamolAndIbuprofeno.safeMedicationFor( "headache", "stomachache" ).contains( "ibuprofeno" ) );
  }
    
  
  @Test public void testPharmacyT6() {
    assertFalse( pharmaWithParacetamolAndClonacho.medication( "headache" ).contains( "clonacho" ) );
    pharmaWithParacetamolAndClonacho.replacement( "paracetamol", "clonacho" );
    assertTrue( pharmaWithParacetamolAndClonacho.medication( "headache" ).contains( "clonacho" ) );
    
  }

  @Test public void testPharmacyT6b() {
    assertFalse( pharmaWithParacetamolAndClonacho.safeMedicationFor( "headache", "fever" ).contains( "clonacho" ) );
    pharmaWithParacetamolAndClonacho.replacement( "paracetamol", "clonacho" );
    assertTrue( pharmaWithParacetamolAndClonacho.safeMedicationFor( "headache", "fever" ).contains( "clonacho" ) );
    
  }

  @Test public void testPharmacyT7() {
    Pharmacy pharma = new Pharmacy();
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache") );
    try {
      pharma.register( new Drug( "paracetamol" ).releaves( "headache") );
      fail( "Ouch" );
    } catch ( Exception e ) {
      assertEquals( "Droga ya registrada", e.getMessage() );
    }
  }

  @Test public void testPharmacyT8() {
    Pharmacy pharma = new Pharmacy();
    try {
      pharma.replacement( "paracetamol", "clonacho" );;
      fail( "Ouch" );
    } catch ( Exception e ) {
      assertEquals( "No se puede reemplazar: paracetamol", e.getMessage() );
    }
  }

  @Test public void testPharmacyT9() {
    Pharmacy pharma = new Pharmacy();
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache") );
    try {
      pharma.replacement( "paracetamol", "clonacho" );
      fail( "Ouch" );
    } catch ( Exception e ) {
      assertEquals( "clonacho no puede ser reemplazo", e.getMessage() );
    }

  }
  
  @Test public void testPharmacyT10() {
    Pharmacy pharma = new Pharmacy();
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache") );
    pharma.register( new Drug( "ibuprofeno" ).releaves( "headache" ).collateral( "stomachache") );
    pharma.register( new Drug( "clonacho" ).releaves( "anxiety" ).collateral( "testophobia", "insomnia") );
    
    pharma.replacement( "paracetamol", "clonacho" );
    
    assertEquals( 3, pharma.medication( "headache" ).size() );  
    assertEquals( 2, pharma.safeMedicationFor( "headache", "stomachache" ).size() );  
  }

  @Test public void testPharmacyT11() {
    Pharmacy pharma = new Pharmacy();
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache" ).collateral( "heartburn" ) );
    pharma.register( new Drug( "ibuprofeno" ).releaves( "headache" ).collateral( "stomachache") );
    pharma.register( new Drug( "clonacho" ).releaves( "anxiety" ).collateral( "testophobia", "insomnia") );
    
    pharma.replacement( "paracetamol", "clonacho" );
    
    assertEquals( 2, pharma.medication( "fever" ).size() );  
    assertEquals( 1, pharma.safeMedicationFor( "fever", "heartburn" ).size() );  
  }

  @Test public void testPharmacyT13() {
    Pharmacy pharma = new Pharmacy();
    pharma.register( new Drug( "paracetamol" ).releaves( "fever", "headache" ).collateral( "heartburn" ) );
    pharma.register( new Drug( "ibuprofeno" ).releaves( "headache" ).collateral( "stomachache") );
    pharma.register( new Drug( "clonacho" ).releaves( "anxiety" ).collateral( "testophobia", "insomnia") );
    
    pharma.replacement( "paracetamol", "clonacho" );
    
    assertEquals( 2, pharma.medication( "fever" ).size() );  
    assertEquals( 1, pharma.safeMedicationFor( "fever", "insomnia" ).size() );  
  }

  private Pharmacy pharma;
  private Pharmacy pharmaWithParacetamol;
  private Pharmacy pharmaWithIbuprofeno;
  private Pharmacy pharmaWithClonacho;
  private Pharmacy pharmaWithParacetamolAndIbuprofeno;
  private Pharmacy pharmaWithParacetamolAndClonacho;
  private Pharmacy pharmaWithIbuprofenoAndClonacho;
  private Pharmacy pharmaWithParacetamolAndIbuprofenoAndClonacho;

}
