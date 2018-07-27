package by.htp.library.entity;

public class Librarian {
	
	private int id;
	private String name;
	private String surname;
	private String pass;
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Librarian(int id, String name, String surname, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
