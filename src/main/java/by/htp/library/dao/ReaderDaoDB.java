package by.htp.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import by.htp.library.entity.Book;
import by.htp.library.entity.Reader;

public class ReaderDaoDB implements ReaderDao {
	private static final String SQL_SELECT_BOOK = "SELECT * FROM book where id_book = ?";
	private static final String SQL_SELECT_ALL_BOOKS = "SELECT * FROM book ";
	private static final String SQL_SELECT_READER = "SELECT name FROM READER WHERE id_reader =? and pass = ?";

	public boolean authorize(int id, String pass) {
		// TODO Auto-generated method stub
		Connection conn = connect();
		Reader reader = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_SELECT_READER);
			ps.setInt(1, id);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				reader = new Reader();

				reader.setName(rs.getString("name"));
				System.out.println("Hello, " + reader.getName());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			closeConnection(conn);
		}
		return true;
	}

	public void seeCatalog() {
		Connection conn = connect();
		Book book = null;
		List<Book> list = new ArrayList();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_SELECT_ALL_BOOKS);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book = new Book();

				book.setId(rs.getInt("id_book"));
				book.setTitle(rs.getString("title"));
				list.add(book);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			closeConnection(conn);
		}

		printCatalog(list);
	}

	public void printCatalog(List <Book> list) {
	
		Iterator<Book> iterator = list.iterator();
		while(iterator.hasNext())
		System.out.println(iterator.next().toString_catalog());
		
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

	public Book read(int id) {
		Connection conn = connect();
		Book book = null;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL_SELECT_BOOK);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				book = new Book();

				book.setId(rs.getInt("id_book"));
				book.setTitle(rs.getString("title"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			closeConnection(conn);
		}
		// Statement st = con.createStatement();
		return book;
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

	public boolean authorize(Reader reader) {
		// TODO Auto-generated method stub
		return false;
	}

}
