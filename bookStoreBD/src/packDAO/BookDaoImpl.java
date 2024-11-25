package packDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDaoImpl implements BookDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BookDaoImpl() {}
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		try {
			String queryString = "INSERT INTO book(book_id, title, author, price) VALUES(?,?,?,?)";
			conn = getConnection();
			pstmt = conn.prepareStatement(queryString);
			pstmt.setLong(1, book.getBook_id());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setFloat(4, book.getPrice());
			pstmt.executeUpdate();

			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
		
			}
		}
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		try {
			String queryString = "UPDATE book SET title=?, author=?, price=? WHERE book_id=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(queryString);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setFloat(3, book.getPrice());
			pstmt.setLong(4, book.getBook_id());
			pstmt.executeUpdate();
			System.out.println("Table Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn!= null)
					conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteBook(Long book_id) {
		// TODO Auto-generated method stub
		try {
			String queryString = "DELETE FROM book WHERE book_id=?";
			conn = getConnection();
			pstmt = conn.prepareStatement(queryString);
			pstmt.setLong(1, book_id);
			pstmt.executeUpdate();
			System.out.println("Data deleted Successfully");
			} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
	        try { 
	        	String query = "SELECT * FROM book";
	        
	        	conn = getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(query);
	            ResultSet rs = pstmt.executeQuery();
	            
	            while (rs.next()) {
	            	System.out.println("BOOK "+ rs.getString("book_id"));
	            	System.out.println("---------------------------------------");
	            	System.out.println("Title: " + rs.getString("title"));
	            	System.out.println("Author: " + rs.getString("author"));
	            	System.out.println("Price: " + rs.getFloat("price") + " DH");
	            	System.out.println("---------------------------------------");
	            	
	            }
	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        finally {
	        	try {
	        		if (rs != null)
	        			rs.close();
	        		if (pstmt != null)
	        			pstmt.close();
	        		if (conn != null)
	        			conn.close();
	        	} catch (SQLException e) {
	        		e.printStackTrace();
	        	} catch (Exception e) {
	        		e.printStackTrace();
	        	}
	        }
	        
	}

	@Override
	public Book findBook(String kw) {
		// TODO Auto-generated method stub
		try {
			String queryString = "SELECT * FROM book WHERE title LIKE ? OR author LIKE ?";
			conn = getConnection();
			pstmt = conn.prepareStatement(queryString);
			pstmt.setString(1, "%"+kw+"%");
			pstmt.setString(2, "%"+kw+"%");
			rs=pstmt.executeQuery();
			
			Book book =new Book();
			
			if(rs.next()) {
				book.setBook_id(rs.getLong("book_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getFloat("price"));
			}else {
				System.out.println("No result found :)");
			}
			return book;
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn!= null)
					conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
