package ma.irisi.microservice.model.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.hibernate.validator.cfg.defs.Mod10CheckDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import ma.irisi.microservice.beans.Commande;
import ma.irisi.microservice.model.dao.CommandeRepository;
import ma.irisi.microservice.model.service.facad.I_CommandeService;

@Service
public class CommandeService implements I_CommandeService{
	

	@Autowired
    private CommandeRepository commandeRepository;
	@Override
	public int save(Commande commande) {
		
		if(findByReference(commande.getReference()) !=null) {
			return -1;
		}
		if(commande.getId() == null) {
			commande.setDate(new Date());
			commandeRepository.save(commande);
			return 1;
		}
		else {
			Commande loadedcommande = this.findById(commande.getId());
			loadedcommande = commande;
			this.commandeRepository.save(loadedcommande);
			return 2;
		}
		
	}
	
	@Override
	public int deleteById(Long id) {
		if(id == null) {
			return -1;
		}
		else {
			this.commandeRepository.deleteById(id);
			return 1;
		}
		
	}

	@Override
	public int update(Commande commande) {
		Commande loadedCommande = this.findById(commande.getId());
		loadedCommande = commande;
		this.save(loadedCommande);
		return 2;
	}

	@Override
	public List<Commande> getAll() {
		return (List<Commande>)this.commandeRepository.findAll();
	}

	@Override
	public Commande findById(Long id) {
        if(id != null) {
        	if(this.commandeRepository.findById(id).isPresent()) {
        		Commande loadedCommande = this.commandeRepository.findById(id).get();
			return loadedCommande;
        	}
        	else {
            	return null;
            }
        }
        else {
        
            	return null;
        }
        
	}

	@Override
	public Commande findByReference(String reference) {
		List<Commande> cmd = this.getAll();
		Commande cmdReturned = null;
		if(reference != null && !cmd.isEmpty()) {
		  for(int i=0;i<cmd.size();i++) {
			  if(cmd.get(i) != null  ) {
				  if(cmd.get(i).getReference().equals(reference)){
					  cmdReturned = cmd.get(i);
				  }
				  
			  }
			  }
		  return cmdReturned;
		}
		else {
			
			return null;
		}	
	}

	@Override
	public Commande findByRef(String reference) {
		return this.commandeRepository.findByReference(reference);
	}


}
