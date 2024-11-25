package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Bookstore");
		
		EntityManager em;
		em = emf.createEntityManager();
		
		//bookDisplay()
		System.out.println("La listes Des Livres de la table book :");
		
		Query q = em.createQuery("from Book",Book.class);
		List<Book> books = new ArrayList<>();
		books = q.getResultList();
		for(Book book : books) {
			System.out.println("----------------------\n BOOK "+ book.getBook_id()
								+"\n----------------------\nTitle: "+book.getTitle()
								+"\nAuthor: "+book.getAuthor()+"\nPrice: "
								+ book.getPrice() +" DH");
		}
		 
		
		//bookAdd()
		System.out.println("Insert a new book Into our table:\n----------------------\n");
		
		em.getTransaction().begin();	
			Book myBook = new Book(6,"something","not me", 40);
			em.persist(myBook);
		em.getTransaction().commit();
		
		//findBook(String kw)
				System.out.println("Find");
				Query qu;
				String kw = "not";
				String req = "SELECT book_id FROM Book b WHERE b.title like :k or b.author like :k ";
				qu=em.createQuery(req);
				qu.setParameter("k", "%"+kw+"%");
				List<Long> bookIds = qu.getResultList();  
				Book book = em.find(Book.class, bookIds.get(0));  
				System.out.println(book);
				
		//bookUpdate()
		System.out.println("Update");
		em.getTransaction().begin();
			book.setPrice(400);
			em.merge(book);
			System.out.println(book); 
		em.getTransaction().commit();

		//bookDelete()
		System.out.println("Delete");
		em.getTransaction().begin();
			em.remove(book);
		em.getTransaction().commit();
		
	}

}
