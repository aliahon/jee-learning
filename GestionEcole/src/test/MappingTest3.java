package test;
import javax.persistence.*;

import ecole.*;
public class MappingTest3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf
		=Persistence.createEntityManagerFactory("myDB"); 
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Noter note1=new Noter(2300, "JEE", 16.75);
		em.persist(note1);
		Noter note2=new Noter(5376, "JEE", 18.00);
		em.persist(note2);
		em.getTransaction().commit();
		}
}
