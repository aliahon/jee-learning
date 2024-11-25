package test;

import javax.persistence.*;

import ecole.*;

public class MappingTest1 {
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("myDB");
		
		EntityManager em = emf.createEntityManager();
		System.out.println("heeeeeeeere");
		em.getTransaction().begin();
			Departement dep=new Departement("GINFO","GénieInformatique");
			em.persist(dep);
			Enseignant ens=new Enseignant("Aimad", "QAZDAR",dep);
			em.persist(ens);
		em.getTransaction().commit();
		System.out.println("htal hn aeverything okkk");
	}
	
}
