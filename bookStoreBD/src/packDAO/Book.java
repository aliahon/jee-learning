package packDAO;

public class Book {
	
	private long book_id;
	private String title;
	private String author;
	private float price;
	
	public Book() {
		
	}
	public Book(long id, String t, String a, float p) {
		book_id = id;
		title= t;
		author = a;
		price = p;
	}
	
	public long getBook_id() {
		return book_id;
	}
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public float getPrice() {
		return price;
	}
	public void setBook_id(long id) {
		book_id = id;
	}
	public void setTitle(String t) {
		title=t;
	}
	public void setAuthor(String a) {
		author =a;
	}
	public void setPrice(float p) {
		price=p;
	}
	
	public String toString() {
		return "---------------------------------------\n"
				+ "Title: " + title
				+ "\nAuthor: "+ author
				+ "\nPrice: "+price ;
	}
}
