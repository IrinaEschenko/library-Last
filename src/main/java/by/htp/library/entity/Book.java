package by.htp.library.entity;

public class Book {
	
	private int id;
	private String title;
	private String author;
	private int copies;
	private String aboutBook;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public String getAboutBook() {
		return aboutBook;
	}

	public void setAboutBook(String aboutBook) {
		this.aboutBook = aboutBook;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Book() {
		super();
	
	}

	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", copies=" + copies + ", aboutBook="
				+ aboutBook + "]";
	}
	public String toString_catalog() {
		return "Book [id=" + id + ", title=" + title + "]\n";
	}
	public String toString_book_info() {
		return "Book [id=" + id + ", title=" + title + ",author=" + author + ", aboutBook= "
				+ aboutBook + "]\n";
	}
	public Book(int id, String title, String author, int copies, String aboutBook) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.copies = copies;
		this.aboutBook = aboutBook;
	}


}
	