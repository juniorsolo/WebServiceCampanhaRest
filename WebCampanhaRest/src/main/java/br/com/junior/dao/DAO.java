package br.com.junior.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> {

	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	/**
	 * Recebe algum tipo e persist
	 * @param t
	 */
	public void adiciona(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(t);

		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Remove um objeto
	 * @param t
	 */
	public void remove(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.remove(em.merge(t));
		
		em.getTransaction().commit();
		em.close();
	}

	/**
	 *  Atualiza objeto
	 * @param t
	 */
	public void atualiza(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.merge(t);
		
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 *  Busca por ID
	 * @param id
	 * @return
	 */
	public T buscaPorId(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		T instancia = em.find(classe, id);
		em.close();
		return instancia;
	}
	
	/**
	 *  Lista todos 
	 * @return List<Type>
	 */
	public List<T> listaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		em.close();
		return lista;
	}
}
