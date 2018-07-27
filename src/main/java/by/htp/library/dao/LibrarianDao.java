package by.htp.library.dao;

import by.htp.library.entity.Book;
import by.htp.library.entity.Librarian;
import by.htp.library.entity.Reader;

interface LibrarianDao {
	
	public boolean authorize(int id, String pass) ;
	
	   void seeCatalogReaders();
	   void addReader();
	   void addBook();
	   void manageBook();
	   void giveBookReader(int bookId);
	   void getBookReader(int bookId);
}
