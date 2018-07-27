package by.htp.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import by.htp.library.entity.Book;
import by.htp.library.entity.Librarian;
import by.htp.library.entity.Reader;

public class LibrarianDaoDB implements LibrarianDao {
	private static final String SQL_ADD_BOOK = "INSERT INTO `libraryfinal`.`book` (`id_book`, `author`, `information`, `publisher`) VALUES (?, ?, ?, ?)";
	private static final String SQL_ADD_READER = "INSERT INTO `libraryfinal`.`reader` (`id_reader`, `name`, `surname`, `pass`) VALUES ('5', 'Viktory', 'Fifth', '12345678vf')";

	private static final String SQL_SELECT_ALL_BOOKS = "SELECT * FROM book ";
	private static final String SQL_SELECT_READER = "SELECT name FROM READER WHERE id_reader =? and pass = ?";
	private static final String SQL_SELECT_LIBRARIAN = "SELECT name FROM LIBRARIAN WHERE id_LIBRARIAN =? and pass = ?";

	@Override
	public boolean authorize(int id, String pass) {
		Connection conn = connect();
		Librarian librarian = null;
		if(id!=0 & pass!=null) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_SELECT_LIBRARIAN);
			ps.setInt(1, id);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				librarian = new Librarian();

				librarian.setName(rs.getString("name"));
				System.out.println("Hello, " + librarian.getName());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			closeConnection(conn);
		}
		} 
		else {
			System.out.println("You data is wrong! Try again!\n");
			return false;
		}return true;
	}
	private void closeConnection(Connection conn) {
		if (conn != null) {

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// }
		}
	}
	private Connection connect() {

		ResourceBundle rb = ResourceBundle.getBundle("db_config");
		String driver = rb.getString("db.driver");
		String url = rb.getString("db.url");
		String login = rb.getString("db.login");
		String pass = rb.getString("db.pass");
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, login, pass);

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public void seeCatalogReaders() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void giveBookReader(int bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBookReader(int bookId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addReader() {
		Connection conn = connect();
		Reader reader = null;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_ADD_READER);
			ResultSet rs = ps.executeQuery();
			System.out.println("You had added a new reader!!!");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			closeConnection(conn);
		}
		// Statement st = con.createStatement();
		
	}
	@Override
	public void addBook() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void manageBook() {
		// TODO Auto-generated method stub
		
	}

}
