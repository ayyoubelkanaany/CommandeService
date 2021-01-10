package ma.irisi.microservice.model.ws;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.irisi.microservice.beans.Commande;
import ma.irisi.microservice.model.service.Impl.CommandeService;


@RestController
@CrossOrigin(value = "http://localhost:4200")
public class CommandeRest {
	@Autowired
	private CommandeService commandeService;
	@RequestMapping(value = "/Commandes/ref/{ref}",method = RequestMethod.GET)
	public Commande findByRef(@PathVariable String ref) {
		return commandeService.findByRef(ref);
	}

	@RequestMapping(value = "/Commandes",method = RequestMethod.POST)
	public int save(@RequestBody Commande commande) {
		return commandeService.save(commande);
	}
	
	@RequestMapping(value = "/Commandes/id/{id}",method = RequestMethod.DELETE)
	public int deleteById(@PathVariable Long id) {
		return commandeService.deleteById(id);
	}
	@RequestMapping(value = "/Commandes",method = RequestMethod.PUT)
	public int update(@RequestBody Commande commande) {
		return commandeService.update(commande);
	}
	@RequestMapping(value = "/Commandes",method = RequestMethod.GET)
	public List<Commande> getAll() {
		return commandeService.getAll();
	}
	@RequestMapping(value = "/Commandes/id/{id}",method = RequestMethod.GET)
	public Commande findById(@PathVariable Long id) {
		return commandeService.findById(id);
	}
	@RequestMapping(value = "/Commandes/reference/{reference}",method = RequestMethod.GET)
	public Commande findByReference(@PathVariable String reference) {
		return commandeService.findByReference(reference);
	}
	
}
