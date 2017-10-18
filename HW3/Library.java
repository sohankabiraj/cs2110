//Sohan Kabiraj (sk5gb) 
// Help from: https://stackoverflow.com/questions/7103064/java-calculate-the-number-of-days-between-two-dates


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.table.TableStringConverter;

public class Library {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	private ArrayList<Book> libraryBooks = new ArrayList<Book>();
	private ArrayList<Person> patrons = new ArrayList<Person>();
	private String name; 
	private int numBooks = getNumBooks();
	private int numPeople; 
	private String currentDate; 
	
	public Library(String name) {
		this.name = name;
		this.libraryBooks = new ArrayList<Book>();
		this.patrons = new ArrayList<Person>();
	}

	public ArrayList<Book> getLibraryBooks() {
		return libraryBooks;
	}

	public void setLibraryBooks(ArrayList<Book> libraryBooks) {
		this.libraryBooks = libraryBooks;
		this.numBooks=libraryBooks.size();
	}

	public ArrayList<Person> getPatrons() {
		return patrons;
	}

	public void setPatrons(ArrayList<Person> patrons) {
		this.patrons = patrons;
		this.numPeople = patrons.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public int getNumBooks() {
		int numBooks = 0; 
		for(Book books : libraryBooks) {
			if(!books.isCheckedOut()) {
				numBooks = numBooks + 1; 
			}
		}
		this.numBooks = numBooks;
		return this.numBooks;
	}

	public int getNumPeople() {
		return numPeople;
	}
	
	
	public int checkNumCopies(String title, String author) {
		int counter = 0; 
		for(int i = 0; i < libraryBooks.size(); i++) {
			if(libraryBooks.get(i).getTitle() == title && libraryBooks.get(i).getAuthor() == author) {
				counter++;
			}
		}
		return counter; 
	}
	
	public int totalNumBooks() {
		return libraryBooks.size();
	}
	
	public boolean checkOut(Person p, Book b, String dueDate) {
		for (Book books : this.libraryBooks) {
			if (patrons.contains(p) && this.libraryBooks.contains(b) && books.equals(b) && !books.isCheckedOut()) {
				books.setCheckedOut(true);
				books.setDueDate(dueDate);
				b.setCheckedOut(true);
				b.setDueDate(dueDate);
				p.addBook(b);
				return true;
			}
		}
		return false; 
	}
	
	public ArrayList<Book> booksDueOnDate(String date){
		ArrayList<Book> dueBooks = new ArrayList<Book>();
		for (int i = 0; i < libraryBooks.size(); i++) {
			if (libraryBooks.get(i).getDueDate().equals(date)) {
				dueBooks.add(libraryBooks.get(i));
			}
		}
		return dueBooks;
	}
	
	public double lateFee(Person p) {
		double total = 0;
		try {
			for (Book book1 : p.getCheckedOut()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
				java.util.Date dueNow = dateFormat.parse(book1.getDueDate());
				java.util.Date currentTime = dateFormat.parse(this.currentDate);
				
				long milliSeconds = currentTime.getTime() - dueNow.getTime();
				double days = (double) TimeUnit.DAYS.convert(milliSeconds, TimeUnit.MILLISECONDS);
				System.out.println(days);
				double latefee = book1.getBookValue() * 0.01 * days;
				
				if (days > 0) {
					total += latefee;
				}
			}
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
		double correctFormat = Math.round(total*100.0)/100.0;
		System.out.println(correctFormat);
		return correctFormat;
	}


}
