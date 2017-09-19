//Sohan Kabiraj (sk5gb) 
// Homework 2

public class Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String title;
	private String author; 
	
	public Book(String title, String author){
		this.title = title;
		this.author = author; 
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public boolean equals(Object o){
		if (o instanceof Book ){
			Book thisBook = (Book) o;
			return (this.title == thisBook.title) && (this.author == thisBook.author);
		}
		else{
			return false; 
		}
	}
	public String toString(){
		return "Title: " + this.title + "\nAuthor: " + this.author;  
	}

}
