package ma.irisi.microservice.model.service.facad;

import java.util.Date;
import java.util.List;
import java.util.Map;

import ma.irisi.microservice.beans.Commande;


public interface I_CommandeService {
 public int deleteById(Long id);
 public int save(Commande produit);
 public int update(Commande produit);
 public List<Commande> getAll();
 public Commande findById(Long id);
 public Commande findByReference(String reference);
 public Commande findByRef(String reference);

}
