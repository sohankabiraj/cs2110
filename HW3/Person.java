import java.util.ArrayList;

// Sohan Kabiraj (sk5gb) 
//Homework 3

public class Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	private String name;
	private final int libraryCardNum;
	private ArrayList<Book> checkedOut;
	private String address; 
	
	public Person(String name, String address, int libraryCardNum){
		this.name = name;
		this.setAddress(address);
		this.libraryCardNum = libraryCardNum;
		this.checkedOut = new ArrayList<Book>();
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLibraryCardNum() {
		return libraryCardNum;
	}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<Book> getCheckedOut(){
		return checkedOut; 
	}

	public String setName(String name){
		return this.name = name;
	}
	
	public boolean addBook(Book b){
		if (checkedOut.contains(b)){
			return false;
		}
		else{
			checkedOut.add(b);
			return true;
		}
	}
	
	public boolean hasRead(Book b){
		if (checkedOut.contains(b)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean forgetBook(Book b){
		if (checkedOut.contains(b)){
			checkedOut.remove(b);
			return true;
		}
		else{
			return false;
		}
	}
	
	public int numBooksRead(){
		return checkedOut.size();
	}
	
	public boolean equals(Object o){
		if (o instanceof Person){
			Person p = (Person) o;
			return (this.libraryCardNum == p.libraryCardNum);
		}
		else{
			return false; 
		}
	}
	
	public String toString(){
		return "Name: " + this.name + "\nAddress: " + this.address + "\nID: " + this.libraryCardNum + "\nBooks read: " + "\n" + checkedOut;
	}
	
	public static ArrayList<Book> commonBooks(Person a, Person b){
		ArrayList<Book> common = new ArrayList<Book>();
		
		for(Book book1 : a.checkedOut) {
			for(Book book2 : b.checkedOut) {
				if(book2.equals(book1)) {
					common.add(book2);
				}
			}
		}
		return common; 
	}
	
	public static double similarity(Person a, Person b){
		double commonReads = (double) commonBooks(a, b).size();
		
		if(commonReads == 0){
			return 0.0d; 
		}
		else{
			if(a.checkedOut.size() < b.checkedOut.size()){
				return (double) commonReads / a.checkedOut.size();
			}
			else{
				return (double) commonReads / b.checkedOut.size();
			}
		}
	}
}
