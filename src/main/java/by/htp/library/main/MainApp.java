package by.htp.library.main;

import java.util.Scanner;

import by.htp.library.dao.ReaderDaoDB;
import by.htp.library.entity.Reader;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="";
		int id;
		while(!(name.equals("L") | name.equals("R"))) {
		try {
			
		Scanner in = new Scanner(System.in);
		System.out.println("Hello! Are you librarian or reader? If librarian enter L, if reader enter R");
		 name = in.nextLine();
		 if((name.equals("R")) ) {
				System.out.println("Hello, Reader. Please, log in");
				id = in.nextInt();
				System.out.println("Enter your pass, please");
				String pass = in.next();
				ReaderDaoDB rddb = new ReaderDaoDB();
				if(rddb.authorize(id, pass)) {
					System.out.println("If you want to see catalog Enter 1\n"
							+ "If you want to see info about any book Enter 2\n"
							+ "If you want to exit Enter Q \n"
							+ "Do your choise, please\n");
				}
				while(!(in.nextLine().equals("Q"))) {
					if(in.nextLine().equals("1")) {
						rddb.seeCatalog();
					}
					if(in.nextLine().equals("2")) {}
				}
				
		 
		 }else if((name.equals("L") ))
					System.out.println("Hello, Librarian. Please, log in");
				else{
		throw new Exception("You should enter 'L' or 'R' ");	
		}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
			
		}

	}
	
}