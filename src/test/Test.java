package test;
import java.util.List;
import javax.persistence.*;

import entity.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bd");
        EntityManager em = emf.createEntityManager();
        
        try {/*
            em.getTransaction().begin();
            
            Client client1 = new Client("el idrissi","nohaila","0605123188","agadir");
            em.persist(client1);
            
            Client client2 = new Client("nom","Prenom","0605123188","adresse");
            em.persist(client2);

            Commande Cmd1= new Commande("11/4/24",client1);
            em.persist(Cmd1);
            
            Commande Cmd2= new Commande("11/3/24",client2);
            em.persist(Cmd2);
            
            Utilisateur utilisateur1 = new Utilisateur("utilisateur1","premon1","chef");
            em.persist(utilisateur1);
            Utilisateur utilisateur2 = new Utilisateur("utilisateur2","premon2","coach");
            em.persist(utilisateur2);
            
            Facture facture1 = new Facture("01/01/2024", 599.99, utilisateur1); 
            em.persist(facture1);

            Facture facture2 = new Facture("15/02/2024", 1299.49, utilisateur2); 
            em.persist(facture2);
            
            
            Article article1 = new Article("Laptop", "Silver", 899.99, 50);       
            em.persist(article1);

            Article article2 = new Article("Office Chair", "Black", 149.99, 200); 
            em.persist(article2);
            
            Concerner_tab cons_t=new Concerner_tab(Cmd1.getNumcom(),facture1.getNumfact(),article1.getCodeart());
            Concerner concerne1=new Concerner(cons_t,6000);
            em.persist(concerne1);
            Concerner_tab cons_t1=new Concerner_tab(Cmd2.getNumcom(),facture2.getNumfact(),article2.getCodeart());
            Concerner concerne2=new Concerner(cons_t1,9000);
            em.persist(concerne2);
            em.getTransaction().commit();*/
            
            System.out.println("Récupération des clients de la base de données :");
            displayClient(em);

            System.out.println("\n\nRécupération des articles de la base de données :");
            displayArticle(em);

            System.out.println("\n\nRécupération des commandes de la base de données :");
            displayCommande(em);

            System.out.println("\n\nRécupération des factures de la base de données :");
            displayFacture(em);

            System.out.println("\n\nRécupération des utilisateurs de la base de données :");
            displayUtilisateur(em);

            System.out.println("\n\nRécupération des relations concerner de la base de données :");
            displayConcerner(em);


        }catch(Exception e) {
        	e.printStackTrace();}
        
        finally {
            em.close();
            emf.close();
        }
	}
	
	public static void displayClient(EntityManager em) {
		List<Client> clients = em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        for (Client client : clients) {
            System.out.println("ID: " + client.getNumCl() + 
                               ", Name: " + client.getNomCl() + 
                               ", Surname: " + client.getPrenomCl() + 
                               ", Phone: " + client.getTelCl() + 
                               ", Address: " + client.getAdresseCl());
        }
	}
	
	public static void displayArticle(EntityManager em) {
		List<Article> Articles = em.createQuery("SELECT a FROM Article a", Article.class).
				getResultList();
        for (Article Article : Articles) {
            System.out.println("ID: " + Article.getCodeart() + 
                               ", Description Article : " + Article.getDesart() + 
                               ", Coleur: " + Article.getCouleur() + 
                               ", Prix Article: " +Article.getPuart()+ 
                               ", Quantité de stock: " + Article.getQtestock());
        }
	}
	
	 public static void displayCommande(EntityManager em) {
	        List<Commande> commandes = em.createQuery("SELECT cmd FROM Commande cmd",
	        		Commande.class).getResultList();
	        for (Commande commande : commandes) {
	            System.out.println("Commande ID: " + commande.getNumcom() +
	                               ", Date: " + commande.getDateCom() +
	                               ", Client ID: " + (commande.getClient() != null ? 
	                            		   commande.getClient().getNumCl() : "None"));
	        }
	    }

	    public static void displayFacture(EntityManager em) {
	        List<Facture> factures = em.createQuery("SELECT f FROM Facture f", Facture.class).
	        		getResultList();
	        for (Facture facture : factures) {
	            System.out.println("Facture ID: " + facture.getNumfact() +
	                               ", Date: " + facture.getDatefact() +
	                               ", Amount: " + facture.getMontant() +
	                               ", Utilisateur ID: " + (facture.getUtilisateur() != null ?
	                            		   facture.getUtilisateur().getCodeut() : "None"));
	        }
	    }

	    public static void displayUtilisateur(EntityManager em) {
	        List<Utilisateur> utilisateurs = em.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class).getResultList();
	        for (Utilisateur utilisateur : utilisateurs) {
	            System.out.println("Utilisateur ID: " + utilisateur.getCodeut() +
	                               ", Name: " + utilisateur.getNomut() +
	                               ", Surname: " + utilisateur.getPrenomut() +
	                               ", Function: " + utilisateur.getFonction());
	        }
	    }

	    public static void displayConcerner(EntityManager em) {
	        List<Concerner> concernerList = em.createQuery("SELECT c FROM Concerner c",
	        		Concerner.class).getResultList();
	        for (Concerner concerner : concernerList) {
	            System.out.println("Commande ID: " + concerner.getCon().getNumcom() +
	                               ", Facture ID: " + concerner.getCon().getNumfact() +
	                               ", Article ID: " + concerner.getCon().getCodeart() +
	                               ", Quantity: " + concerner.getQtecom());
	        }

	    }

}

