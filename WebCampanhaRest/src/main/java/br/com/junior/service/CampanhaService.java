package br.com.junior.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import br.com.junior.entity.CampanhaEntity;

@Local
@Stateless
public class CampanhaService {
	
	

	public List<CampanhaEntity> getCampanhas(){
		Integer idCont = 0;
		
		List<CampanhaEntity> campanhas = new ArrayList<>();
		LocalDate dataAtual = LocalDate.now();
		
		CampanhaEntity c1 = new CampanhaEntity();
		c1.setId(idCont++);
		c1.setNome("Campanha One");
		c1.setDataInicio(dataAtual.minusDays(3));
		c1.setDataVigencia(dataAtual);
		
		CampanhaEntity c2 = new CampanhaEntity();
		c2.setId(idCont++);
		c2.setNome("Campanha Two");
		c2.setDataInicio(dataAtual.minusDays(2));
		c2.setDataVigencia(dataAtual.plus(1, null));
		
		CampanhaEntity c3 = new CampanhaEntity();
		c3.setId(idCont++);
		c3.setNome("Campanha Two vencida");
		c3.setDataInicio(dataAtual.minusDays(4));
		c3.setDataVigencia(dataAtual.minusDays(1));
		
		
		campanhas.add(c1);
		campanhas.add(c2);
		campanhas.add(c3);
		
		
		return campanhas;
	}
}
