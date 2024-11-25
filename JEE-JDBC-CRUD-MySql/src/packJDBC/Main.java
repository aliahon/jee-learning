package packJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {

    //9
    public static Connection biblioConnect() {
    	Connection conn =null;
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "root", "");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Erreur : Impossible de charger le driver de la base de données.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur : Impossible d'établir la connexion à la base de données.");
            }
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur : Impossible de fermer la connexion à la base de données.");
            }
        }
    }
    //10
    public static void bookDisplay(){
        String query = "SELECT title, author, price FROM book";

        try (Connection conn = biblioConnect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            int i=1;
            while (rs.next()) {
            	System.out.println("BOOK "+ i);
            	System.out.println("---------------------------------------");
            	System.out.println("Title: " + rs.getString("title"));
            	System.out.println("Author: " + rs.getString("author"));
            	System.out.println("Price: " + rs.getFloat("price") + " DH");
            	System.out.println("---------------------------------------");
            	i++;
            }
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    //11 findBook by id
    public static Book bookFind(int id){
    	Book book = new Book();
        String query = "SELECT title, author, price FROM book WHERE book_id=?";

        try (Connection conn = biblioConnect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
        	pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
            	book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getFloat("price"));
            }
            closeConnection(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
    //12
    
    public static void bookAdd(String t, String a, float p){
        String query = "INSERT INTO book (book_id,title, author, price) VALUES(null,?, ?, ?)";

        try (Connection conn = biblioConnect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
        	pstmt.setString(1, t);
        	pstmt.setString(2, a);
        	pstmt.setFloat(3, p);
            pstmt.execute();
            System.out.println("Book added successfuly!");
            
            closeConnection(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  //13
    public static void bookUpdate(int id, String t, String a, float p){
        String query = "UPDATE book SET title=?, author=?, price=? WHERE book_id = ?";

        try (Connection conn = biblioConnect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
        	pstmt.setString(1, t);
        	pstmt.setString(2, a);
        	pstmt.setFloat(3, p);
        	pstmt.setInt(4, id);
        	
            pstmt.execute();
            System.out.println("Book updated successfuly!");
            
            closeConnection(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
  //14
    public static void bookDelete(int id){
        String query = "DELETE FROM book WHERE book_id = ?";

        try (Connection conn = biblioConnect();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
        	pstmt.setInt(1, id);
        	
            pstmt.execute();
            System.out.println("Book deleted successfuly!");
            
            closeConnection(conn);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		/*
		//Afficher tous les enregistrements de la table book
		bookDisplay();
		
		//Insérer un nouveau book
		System.out.println("You have to enter the info about the book you wanna add.\n");
		System.out.println("enter the title :");
		String title = sc.nextLine();
		
		System.out.println("enter the author :");
		String author= sc.nextLine();
		
		System.out.println("enter the price :");
		float price = sc.nextFloat();
		
		bookAdd(title,author,price);
		*/
		//Afficher le nouveau book ajouté
		System.out.println("Please! Enter the code (id) of the book you want to display.");
		int id = sc.nextInt();
		
		Book b = bookFind(id);
		/*
		System.out.println(b.toString());
		
		//Modifier le prix de ce book
		System.out.println("enter the updeted price for the book named "+ b.getTitle()+ " :");
		float updatedPrice = sc.nextFloat();
		
		bookUpdate(id, b.getTitle(), b.getAuthor(), updatedPrice);
		*/
		//Supprimer ce book
		System.out.println("Do you want to delete the book named"+ b.getTitle()+ " ? Yes/No");
		String ans = sc.next();
		if(ans.equals("Yes")) bookDelete(id);
		
		sc.close();
	}
}
