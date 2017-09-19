import java.util.ArrayList;

// Sohan Kabiraj (sk5gb) 
//Homework 2

public class Person {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private String name;
	private int id;
	private ArrayList<Book> read = new ArrayList<Book>();
	
	public Person(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public ArrayList<Book> getRead(){
		return this.read; 
	}

	public String setName(String name){
		return this.name = name;
	}
	
	public boolean addBook(Book b){
		if (read.contains(b)){
			return false;
		}
		else{
			read.add(b);
			return true;
		}
	}
	
	public boolean hasRead(Book b){
		if (read.contains(b)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean forgetBook(Book b){
		if (read.contains(b)){
			read.remove(b);
			return true;
		}
		else{
			return false;
		}
	}
	
	public int numBooksRead(){
		return read.size();
	}
	
	public boolean equals(Object o){
		if (o instanceof Person){
			Person p = (Person) o;
			return (this.id == p.id);
		}
		else{
			return false; 
		}
	}
	
	public String toString(){
		return "Name: " + this.name + "\nID: " + this.id + "\nBooks read: " + "\n" + read;
	}
	
	public static ArrayList<Book> commonBooks(Person a, Person b){
		ArrayList<Book> common = new ArrayList<Book>();
		
		for(int i = 0; i < a.read.size(); i++){
			for(int j = 0; j < b.read.size(); i++){
				if(a.read.get(i) == b.read.get(j)){
					common.add(a.read.get(i));
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
			if(a.read.size() < b.read.size()){
				return (double) commonReads / a.read.size();
			}
			else{
				return (double) commonReads / b.read.size();
			}
		}
	}
}
