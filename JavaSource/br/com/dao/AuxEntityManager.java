package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AuxEntityManager {

        private EntityManagerFactory emf; 

        public EntityManager getEntityManager(){

                return emf.createEntityManager();
        }
        public AuxEntityManager() {
                emf = Persistence.createEntityManagerFactory("pocketplanner");
        }
        
}
