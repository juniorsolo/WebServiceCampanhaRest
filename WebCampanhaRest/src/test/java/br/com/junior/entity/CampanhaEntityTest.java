package br.com.junior.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.junior.dao.DAO;
import junit.framework.TestCase;

public class CampanhaEntityTest extends TestCase{

	
	
	@Test
	public void testPersistCampanha() {
		
		 DAO<CampanhaEntity> dao = new DAO<>(CampanhaEntity.class);
		 
		 List<CampanhaEntity> campanhas = new ArrayList<>();
			LocalDate dataAtual = LocalDate.now();
			
			CampanhaEntity c1 = new CampanhaEntity();
			c1.setNome("Campanha One");
			c1.setDataInicio(dataAtual.minusDays(3));
			c1.setDataVigencia(dataAtual);
			
			CampanhaEntity c2 = new CampanhaEntity();
			c2.setNome("Campanha Two");
			c2.setDataInicio(dataAtual.minusDays(2));
			c2.setDataVigencia(dataAtual.plus(Period.ofDays(2)));
			
			CampanhaEntity c3 = new CampanhaEntity();
			c3.setNome("Campanha Two vencida");
			c3.setDataInicio(dataAtual.minusDays(4));
			c3.setDataVigencia(dataAtual.minusDays(1));
			
			
			campanhas.add(c1);
			campanhas.add(c2);
			campanhas.add(c3);
		 
		 
		 campanhas.forEach( c -> dao.adiciona(c));
		 
		 CampanhaEntity retorno = (CampanhaEntity) dao.buscaPorId(1);
		 
		 assertNotNull(retorno);
		 assertEquals("Campanha One", retorno.getNome());
		 
	

	}
	
}
