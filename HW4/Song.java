
/**
 * @author Sohan Kabiraj (sk5gb) 
 *This is the Song class that implements the Playable interface 
 */

public class Song implements Playable, Comparable<Song> {
	public static void main(String[] args) {
		
	}
	
	/**
	 * All the instance variables needed 
	 */
	
	private String artist;
	private String title;
	private int minutes;
	private int seconds;
	
	/**
	 * This is the first constructor that takes in the artist name and title but sets the length of the song to 0 minutes and 0 seconds 
	 */
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title; 
		this.minutes = 0; 
		this.seconds = 0; 
	}
	
	/**
	 * This is the second constructor that takes in all the instance variables. 
	 */
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title; 
		this.minutes = minutes;
		this.seconds = seconds; 
	}
	
	/**
	 * This is the third constructor that only takes in a type Song 
	 */
	public Song(Song s) {
		s.artist = this.getArtist(); 
		s.minutes = this.getMinutes(); 
		s.seconds = this.getSeconds(); 
		s.title = this.getTitle(); 
	}
	
	/**
	 * this is the equals method that checks if two songs are equal if all the fields match 
	 */
	
	public boolean equals(Object o) {
		if (o instanceof Song) {
			Song firstSong = (Song) o;
			return (this.artist.equalsIgnoreCase(firstSong.artist) && this.title.equalsIgnoreCase(firstSong.title) && this.minutes == firstSong.minutes && this.seconds == firstSong.seconds);
		}
		else {
			return false; 
		}
	}
	
	/**
	 * This is the toString method to the Song class which outputs the song name and title in a string format
	 */
	
	public String toString() {
		return "{Song: title = " + title + " artist = " + artist + "}";
	}
	
	/**
	 * These are the getters and setters for all the fields 
	 * 
	 */
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	/**
	 * this is the play method which outputs what song is playing in a string format 
	 */
	
	public void play() {
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);
	}

	/**
	 * the getName method returns the title of the song 
	 */
	
	public String getName() {
		return this.title;
	}

	/**
	 * getPlayTimeSeconds returns the number of seconds in the song
	 */
	
	public int getPlayTimeSeconds() {
		return this.seconds + 60*this.minutes;
	}

	/**
	 * this returns the number of songs which is just 1 since there is only one 
	 */
	
	public int numberOfSongs() {
		return 1;
	}
	
	/**
	 * the compareTo method compares two songs and orders by the artist in ascending order. if the artists are the same then it will sort by the title. if both artist and title are the same then it doesnt matter 
	 */

	@Override
	public int compareTo(Song o) {
			if((this.artist.compareTo(o.artist) != 0)){
				return this.artist.compareTo(o.artist);
			}
			else {
				return this.title.compareTo(o.title);
			}
		}
}
