//Sohan Kabiraj (sk5gb) 
// Homework 3

public class Book {

	public static void main(String[] args) {
		
	}
	
	private String title;
	private String author; 
	private String dueDate = ""; 
	private boolean checkedOut; 
	private final int bookId; 
	private double bookValue;
	
	
	public Book(String title, String author, int bookId, double bookValue){
		this.title = title;
		this.author = author; 
		this.bookId = bookId;
		this.bookValue = bookValue; 
		this.checkedOut = false; 
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public double getBookValue() {
		return bookValue;
	}

	public void setBookValue(double bookValue) {
		this.bookValue = bookValue;
	}

	public int getBookId() {
		return bookId;
	}

	public boolean equals(Object o){
		if (o instanceof Book ){
			Book thisBook = (Book) o;
			return (this.bookId == thisBook.bookId);
		}
		else{
			return false; 
		}
	}
	
	public String toString(){
		return "Title: " + this.title + "\nAuthor: " + this.author + "\nDue: " + this.dueDate + "\nChecked out? " + this.checkedOut + "\nBook ID: " + this.bookId + "\nValue: " + this.bookValue;  
	}

}
