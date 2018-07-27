package by.htp.library.main;

import java.util.Scanner;

import by.htp.library.dao.LibrarianDaoDB;
import by.htp.library.dao.ReaderDaoDB;
import by.htp.library.entity.Reader;

public class MainApp {

	public static void showMenuReader() {
		System.out.println("If you want to see catalog Enter 1\n"  
						 + "If you want to see info about any book Enter 2\n"
						 + "If you want to exit Enter Q \n" 
						 + "Do your choise, please\n");
	}

	public static void showMenuLibrarian() {
		System.out.println("If you want to add reader Enter 1\n" 
						 + "If you want to add book Enter 2\n"
				         + "If you want to manage book Enter 3 \n"
						 + "If you want to exit Enter Q \n"
				         + "Do your choise, please\n");
	}

	public static void main(String[] args) {
		String name = "";
		int id=0;
		while (!(name.equals("L") | name.equals("R"))) {
			try {

				Scanner in = new Scanner(System.in);
				System.out.println("Hello! Are you librarian or reader? If librarian enter L, if reader enter R");
				name = in.nextLine();
				if ((name.equalsIgnoreCase("R"))) {
					System.out.println("Hello, Reader. Please, log in");
					id = in.nextInt();
					System.out.println("Enter your pass, please");
					String pass = in.next();
					ReaderDaoDB rddb = new ReaderDaoDB();
					if (rddb.authorize(id, pass)) {

						showMenuReader();
						while (!(in.nextLine().equalsIgnoreCase("Q"))) {

							switch (in.nextInt()) {

							case 1:
								rddb.seeCatalog();
								showMenuReader();
								break;
							case 2:
								System.out.println(
										"Please, input the book_number, \n " + "and I'll show you the BOOK_INFO :) ");
								int idBook = in.nextInt();
								System.out.println(rddb.read(idBook).toString_book_info());
								showMenuReader();
								break;
							}
						}
					}
					} else if ((name.equalsIgnoreCase("L"))) {
						
						String passLib;
						LibrarianDaoDB librarian = new LibrarianDaoDB();
						System.out.println("Hello, Librarian. Please, log in");
						int idLib = in.nextInt();
						System.out.println("Please, enter your pass\n");
					
						 if(in.hasNextLine());
						 passLib =in.nextLine();
						 if (librarian.authorize(idLib, passLib)) {
							showMenuLibrarian();
							while (!(in.nextLine().equalsIgnoreCase("Q"))) {

								switch (in.nextInt()) {

								case 1:
									librarian.addReader();
									showMenuLibrarian();
									break;
								case 2:
									librarian.addBook();
									showMenuLibrarian();
									break;
								case 3:
									librarian.manageBook();
									showMenuLibrarian();
									break;
							
								}
							}

						} 
						}else {
							throw new Exception("You should enter 'L' or 'R' ");
					}
				}
			 catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		}
		
		System.out.println("Bye!!!");

	}
}
