package br.com.junior.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.junior.dao.JPAUtil;

public class PopulaBanco {

	public static void main(String[] args) {
		 EntityManager em = new JPAUtil().getEntityManager();
		 
		 em.getTransaction().begin();
		 
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
		 
		 
		 campanhas.forEach( c -> em.persist(c));
		 
		 em.getTransaction().commit();
		 em.close();

	}
	
}
