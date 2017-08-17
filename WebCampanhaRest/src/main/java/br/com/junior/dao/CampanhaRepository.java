package br.com.junior.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.junior.entity.CampanhaEntity;


public class CampanhaRepository extends DAO<CampanhaEntity> {
	
   public CampanhaRepository() {
		super(CampanhaEntity.class);
	
	}
	
   public List<CampanhaEntity> listaTodosVigentes() {
		CriteriaBuilder builder = new JPAUtil().getEntityManager().getCriteriaBuilder();
		CriteriaQuery<CampanhaEntity> criteria = builder.createQuery(CampanhaEntity.class);
		Root<CampanhaEntity> root = criteria.from(CampanhaEntity.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Path<LocalDate> pathDataFimVigencia = root.get("dataVigencia");
		
		LocalDate dataAtual = LocalDate.now();
		
		predicates.add(builder.greaterThanOrEqualTo(pathDataFimVigencia, dataAtual));
	
		criteria.select(root).where(builder.and( predicates.toArray( new Predicate[] {} )));
		return new JPAUtil().getEntityManager().createQuery(criteria).getResultList();
	}
	

}
