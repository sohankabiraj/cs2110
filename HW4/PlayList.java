import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Sohan Kabiraj (sk5gb) 
 * This is the PlayList class for the assignment 
 */
public class PlayList implements Playable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * instance variables for the class that are needed 
	 */
	
	private String name; 
	private ArrayList<Playable> playableList = new ArrayList<Playable>();
	
	/**
	 * this is the first constructor that names an empty playlist as "Untitled" since it has no name given 
	 */
	
	public PlayList() {
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>();
	}
	
	/**
	 * second constructor that sets the name of an empty playlist
	 */
	
	public PlayList(String newName) {
		this.name = newName; 
		this.playableList = new ArrayList<Playable>();
	}

	/**
	 * getters and setters for the instance variables 
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}
	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	} 
	
	/**
	 * toString method for displaying which songs are in the playlist 
	 */
	
	public String toString() {
		String playing = this.name + "\n";
		for (Playable songs : playableList) {
			playing = playing + "\n" + songs.toString();
		}
		return playing; 
	}
	
	/**
	 * loads and adds songs to a playlist 
	 */
	
	public boolean loadSongs(String fileName) {
		File theFile = new File(fileName);
		Scanner theInput = null; 
		
		try {
			theInput = new Scanner(theFile);
			while(theInput.hasNextLine()) {
				String theTitle = theInput.nextLine();
				theTitle = theTitle.trim();
				String theArtist = theInput.nextLine();
				theArtist = theArtist.trim();
				String lengthSong = theInput.nextLine();
				lengthSong = lengthSong.trim();
				int minutes = Integer.parseInt(lengthSong.substring(0, lengthSong.indexOf(":")));
				int seconds = Integer.parseInt(lengthSong.substring(lengthSong.indexOf(":") + 1));
				if (seconds >= 60) {
					minutes += seconds / 60;
					seconds = seconds % 60; 
				}
				Song aSong = new Song(theArtist, theTitle, minutes, seconds);
				this.addSong(aSong);
				theInput.nextLine();
			}
			theInput.close();
			return true;
		}
		catch(FileNotFoundException exception){
			exception.printStackTrace();
		}
		return false; 
	}
	
	
	/**
	 * removes all of the playable elements in the playlist 
	 */
	
	public boolean clear() {
		if (this.playableList.size() > 0) {
			playableList.clear();
			return true; 
		}
		else {
			return false; 
		}
	}
	
	/**
	 * addSong adds a song to the end of the playlist 
	 */
	
	public boolean addSong(Song s) {
		playableList.add((Playable) s);
		return true; 
	}
	
	/**
	 * removePlayable removes the given element which is a song or playlist from the main playlist and then returns it 
	 */
	
	public Playable removePlayable(int index) {
		if (playableList.size() == 0) {
			return null; 
		}
		else {
			Playable theItem = playableList.get(index);
			playableList.remove(index);
			return theItem;
		}
	}
	
	/**
	 * removes every occurance of the song or playlist from the main playlist and then returns it 
	 */
	
	public Playable removePlayable(Playable p) {
		for (Playable item : playableList) {
			if(item.equals(p)) {
				playableList.remove(p);
			}
		}
		return p; 
	}
	
	/**
	 * this returns the index of the Playable  
	 */
	
	public Playable getPlayable(int index) {
		if (index >= 0 && index < playableList.size()) {
			return playableList.get(index);
		}
		return null; 
	}
	
	/**
	 * this method adds a new playlist to the end of the playable list and returns true; if there are two with the same name then it does not add and returns false 
	 */
	
	public boolean addPlayList(PlayList pl) {
		boolean isDone = false; 
		if(this.playableList.contains(pl) == true) {
			isDone = false; 
		}
		else {
			this.playableList.add(pl);
			isDone = true; 
		}
		return isDone;
	}

	/**
	 * plays the playlist in order  
	 */
	
	public void play() {
		for (Playable items : playableList) {
			items.play();
		}
	}
	
	/**
	 * gets the play time in seconds for the playlist 
	 */
	
	public int getPlayTimeSeconds() {
		int totalTime = 0; 
		for (Playable items : playableList) {
			if(items instanceof Playable) {
				totalTime += items.getPlayTimeSeconds();
			}
		}
		return totalTime;
	}

	/**
	 * returns the number of songs in the playlist 
	 */
	
	public int numberOfSongs() {
		int total = 0; 
		for (Object object : this.playableList) {
			if (object instanceof PlayList) {
				PlayList newObject = (PlayList) object;
				int numSongs = newObject.playableList.size();
				total += numSongs;
			}
			else {
				total += 1; 
			}
		}
		return total; 
	}
	
	/**
	 * writing another class that implements the comparator in order to sort it 
	 */

	private class CmprName implements Comparator<Playable>{

		/**
		 * returns the value of the compareTo method 
		 */
		public int compare(Playable o1, Playable o2) {
			return (o1.getName().compareTo(o2.getName()));
		}
		
	}
	
	/**
	 * sorts the items by ascending order; 
	 */
	
	public void sortByName() {
		Collections.sort(playableList, new CmprName());
	}
	
	/**
	 * class that implements the compartor in order for me to sort by time 
	 */
	
	public class CmprTime implements Comparator<Playable>{
		/**
		 * returns the value of the compareTo method given the times 
		 */
		
		public int compare(Playable o1, Playable o2) {
			if (o1.getPlayTimeSeconds() > o2.getPlayTimeSeconds()) {
				return 1; 
			}
			if (o1.getPlayTimeSeconds() < o2.getPlayTimeSeconds()) {
				return -1; 
			}
			else {
				return 0; 
			}
		}
	}
	
	/**
	 * method sorts all the songs or playlists based on the total time in seconds in ascending order 
	 */
	
	public void sortByTime() {
		Collections.sort(playableList, new CmprTime());
	}
}
