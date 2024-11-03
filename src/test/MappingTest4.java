package test;
import javax.persistence.*;
import ecole.*;
public class MappingTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("myDB"); 
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Coordonnees crd=new Coordonnees("ENSA-agadir", "Agadir", 
		"0525008800",
		"a.rabii@edu.uiz.ac.ma");
		Etudiant etd1=new Etudiant(3322,"Ahmed", "RABII",crd);
		em.persist(etd1);
		em.getTransaction().commit();

	}

}
