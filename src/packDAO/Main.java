package packDAO;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		BookDaoImpl b = new BookDaoImpl();
		//Afficher tous les enregistrements de la table book
		b.displayAll();
		
		//Insérer un nouveau book
		System.out.println("You have to enter the info about the book you wanna add.\n");
		System.out.println("enter the title :");
		String title = sc.nextLine();
		
		System.out.println("enter the author :");
		String author= sc.nextLine();
		
		System.out.println("enter the price :");
		float price = sc.nextFloat();
		Book maBook = new Book(5,title, author, price);
		b.addBook(maBook);
		
		//Afficher le nouveau book ajouté
		System.out.println(b.findBook("noha"));
		
		//Modifier le prix de ce book
		System.out.println("enter the updeted price for the book named "+ maBook.getTitle()+ " :");
		float updatedPrice = sc.nextFloat();
		maBook.setPrice(updatedPrice);
		b.updateBook(maBook);
		System.out.println(b.findBook("noha"));
		//Supprimer un book
		System.out.println("Do you want to delete the book named"+ maBook.getTitle()+ " ? Yes/No");
		String ans = sc.next();
		if(ans.equals("Yes")) b.deleteBook(maBook.getBook_id());
		sc.close();
	}

}
