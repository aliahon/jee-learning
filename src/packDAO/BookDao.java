package packDAO;

public interface BookDao {
	
	public void addBook(Book book) ;
	public void updateBook(Book book);
	public void deleteBook(Long book_id) ;
	public void displayAll();
	public Book findBook(String kw);

}