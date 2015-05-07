package epsi.dao;

// Generated 6 mai 2015 11:18:39 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;

import epsi.exception.PlatNotFoundException;
import epsi.model.Plat;
import epsi.model.User;

/**
 * Home object for domain model class Plat.
 * @see epsi.model.Plat
 * @author Hibernate Tools
 */
public class PlatHome {
	
	public PlatHome(){
	}

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Plat plat){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(plat);
		transaction.commit();
		
		//Close entity manager
		em.close();
		emf.close();
	}
	
	public void update(Plat plat){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
		
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.merge(plat);
		transaction.commit();
		
		//Close entity manager
		em.close();
		emf.close();
	}
	
	public void delete(Plat plat){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();
				
		//Get transaction
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
				
		em.remove(plat);
		transaction.commit();
				
		//Close entity manager
		em.close();
		emf.close();
	}

	public Plat findById(Long id_Produit) throws PlatNotFoundException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();

		try{
			Plat plat = (Plat) em.createQuery("Select p FROM Plat p WHERE p.idProduit=:id")
							.setParameter("id", id_Produit).getSingleResult();
			return plat;
			
		}catch(NoResultException ex){
			throw new PlatNotFoundException();
		}finally{
			em.close();
			emf.close();
		}		
	}
	@SuppressWarnings("unchecked")
	public List<Plat> find(){
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();

		List<Plat> plats = em.createQuery("SELECT p FROM Plat p").getResultList();
			
		//Close entity manager
		em.close();
		emf.close();
		return plats;
	}
	public Plat findByDesignation(String designation) throws PlatNotFoundException{
		// Get entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("musciPU");
		EntityManager em = emf.createEntityManager();

		try{
		Plat plat = (Plat) em.createQuery("Select p FROM Plat p WHERE p.designation=:designation")
							.setParameter("designation", designation).getSingleResult();
		return plat;	

		}catch(NoResultException e){
			throw new PlatNotFoundException();
		}finally{
			em.close();
			emf.close();
		}
	}

	
}
