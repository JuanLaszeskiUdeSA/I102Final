package pharma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class Pharmacy {
  public static String noSePuedeReemplazar = "No se puede reemplazar: ";
  public static String noPuedeSerReemplazo = " no puede ser reemplazo";
  public static String drogaYaRegistrada = "Droga ya registrada";
  private List<Drug> drugs = new ArrayList<>();
  private Map<String, String> replacements = new HashMap<>();

  public List<String> medication( String symptoms ) {
    //listOfMedication = map nameD (filter (\drug -> healD drug symptoms) drugs)
    List<String> listOfMedication = drugs.stream()
        .filter( (drug) -> drug.heals( symptoms ) )
        .map( (drug) -> drug.name())
        .collect( Collectors.toList() );

    
    Set<String> keys = replacements.keySet();
    //listOfMedication = listOfMedication ++ (map (\(key) -> key ´elem´ map fst replacements) (filter (\key -> (elem) key listOfMedication) keys))
    listOfMedication.addAll(keys.stream()
        .filter( (key) -> listOfMedication.contains(key) )
        .map( (key) -> replacements.get(key) )
        .collect( Collectors.toList() ));
    return listOfMedication;
  }

  public void register( Drug heal ) {
    //drugExists = any (\drug -> (nameD drug) == (nameD heal)) drugs
    boolean drugExists = drugs.stream()
        .anyMatch( (drug) -> drug.name().equals(heal.name()) );

    if (drugExists) {
        throw new RuntimeException(drogaYaRegistrada);
    } else {
        drugs.add(heal);
    }
  }

  public List<String> safeMedicationFor( String symptoms, String prevalence ) {
    //candidates = filter (\drug -> healD drug symptoms) drugs
    List<Drug> candidates = drugs.stream()
        .filter( (drug) -> drug.heals( symptoms) )
        .collect( Collectors.toList() );

    //candidateNames = map nameD candidates
    List<String> candidateNames = candidates.stream()
        .map( (drug) -> drug.name() )
        .collect( Collectors.toList() );
    
    // listOfSafeMedicationFor = map nameD (filter (\drug -> not (aggravateD drug prevalence) ) candidates )
    List<String> listOfSafeMedicationFor = candidates.stream()
        .filter( (drug) -> !drug.aggravate( prevalence ) )
        .map( (drug) -> drug.name() )
        .collect( Collectors.toList() );

    /*ListOfSafeMedicationFor = listOfSafeMedicationFor ++
      (map (\(key) -> getKey replacements)
      (filter (entry -> not(nameD (snd entry replacements) agravateD prevalence)
      (filter (\entry -> (elem) entry map fst(candidateNames)) (entrySet replacements))))*/

    listOfSafeMedicationFor.addAll(replacements.entrySet().stream()
        .filter( (entry) -> candidateNames.contains(entry.getKey()) )
        .filter( (entry) -> !drugNamed(entry.getValue()).aggravate(prevalence) )
        .map( (entry) -> entry.getValue() )
        .collect( Collectors.toList() ));

    return listOfSafeMedicationFor;
  }

  public void replacement( String aDrug, String anotherDrug ) {
    //filter(\drug -> nameD drug == aDrug) drugs
    if ( !drugs.stream().anyMatch( (any) -> any.name().equals( aDrug ) ) )
      throw new RuntimeException( noSePuedeReemplazar + aDrug );

    if ( !drugs.stream().anyMatch( (any) -> any.name().equals( anotherDrug ) ) )
      throw new RuntimeException( anotherDrug + noPuedeSerReemplazo );
    
    replacements.put( aDrug, anotherDrug );
  }

  public Drug drugNamed( String aDrugName ) {
    //filter (\drug -> nameD drug == aDrugName) drugs
    return drugs.stream()
        .filter( (drug) -> drug.name().equals(aDrugName) )
        .findFirst()
        .orElseThrow( () -> new NoSuchElementException() );
  }
}
  

