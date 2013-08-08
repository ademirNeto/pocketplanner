package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.User;

@Resource("userDAO")
public class UserDAO implements DAOInterface{
	
	@EnityManager
	EntityManager manager;
	
	@Override
	public Object insert(Object user) {
        	AuxEntityManager aux = new AuxEntityManager ();
            EntityManager em = aux.getEntityManager();
            try{
            	em.getTransaction().begin();
            	em.persist(user);
            	em.getTransaction().commit();
            	return user;
            }catch (Exception e) {
            	em.getTransaction().rollback();
            	return null;
            }
        }
       

		@Override
		public Object update(Object object) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public Object search(Object object) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public User searchByEmail(String email) {
			AuxEntityManager aux = new AuxEntityManager ();
            EntityManager em = aux.getEntityManager();
            User user = null;
            try {
            Query query = em.createQuery("select u from br.com.model.User u where u.email = :email");
			query.setParameter("email", email);
			user = query.getSingleResult();
            } finally {
            em.close();
            }
            return user;
           }


		@Override
		public Boolean remove(Object object) {
			// TODO Auto-generated method stub
			return null;
		}
        
}
