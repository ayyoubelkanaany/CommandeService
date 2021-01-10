package ma.irisi.microservice.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.irisi.microservice.beans.Commande;
@Repository
public interface CommandeRepository extends  CrudRepository<Commande, Long>{
	
    Commande findByReference(String reference);
}
