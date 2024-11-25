package packJDBC;

public class Book {
	
	private String title;
	private String author;
	private float price;
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public float getPrice() {
		return price;
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
		return "THE BOOK \n"+ "---------------------------------------\n"
				+ "Title: " + title
				+ "\nAuthor: "+ author
				+ "\nPrice: "+price ;
	}
}
