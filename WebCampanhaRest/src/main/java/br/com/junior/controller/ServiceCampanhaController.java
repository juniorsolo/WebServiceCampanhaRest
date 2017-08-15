package br.com.junior.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.junior.dao.CampanhaRepository;
import br.com.junior.entity.CampanhaEntity;
import br.com.junior.http.Campanha;

@Path("/service")
public class ServiceCampanhaController {
		
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/todascampanhas")
	public List<Campanha> todasCampanhas(){
		List<CampanhaEntity> campanhasDAO = new ArrayList<>();
		List<Campanha> campanhaJSON = new ArrayList<>();
		CampanhaRepository repo = new CampanhaRepository();
		
		campanhasDAO = repo.listaTodos();
		
		campanhasDAO.forEach( c -> campanhaJSON.add( new Campanha(c.getId(),c.getNome() , c.getDataVigencia() )));
		
		return campanhaJSON;
	}
}
