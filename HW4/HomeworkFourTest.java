/**
 * Sohan Kabiraj (sk5gb) 
 */

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HomeworkFourTest {
	
	Song firstSong; 
	Song secondSong; 
	Song thirdSong;
	Song fourthSong; 
	PlayList firstPlayList; 
	PlayList secondPlayList; 
	PlayList thirdPlayList; 
	PlayList fourthPlayList; 
	
	@Before
	public void setUp() {
		firstSong = new Song("Artist1", "Title1", 1, 10);
		secondSong = new Song("Artist1", "Title1", 1, 10);
		thirdSong = new Song("Artist2", "Title2", 2, 30);
		fourthSong = new Song("Artist3", "Title3", 6, 56);
		
		firstPlayList = new PlayList("firstPlayList");
		secondPlayList = new PlayList("secondPlayList");
		thirdPlayList = new PlayList("thirdPlayList");
		fourthPlayList = new PlayList("fourthPlayList");
		
		firstPlayList.addSong(firstSong);
		firstPlayList.addSong(thirdSong);
		
		secondPlayList.addSong(thirdSong);
		secondPlayList.addSong(fourthSong);
		
		secondPlayList.addPlayList(firstPlayList);
		
	}
	
	@Test 
	public void testGetName() {
		assertEquals("Title1", firstSong.getName());
		assertEquals("Title1", secondSong.getName());
	}
	
	@Test 
	public void testNumberofSongs() {
		assertEquals(2, firstPlayList.numberOfSongs());
		assertEquals(4, secondPlayList.numberOfSongs());
	}
	
	@Test
	public void testGetPlayTime() {
		assertEquals(220, firstPlayList.getPlayTimeSeconds());
		assertEquals(786, secondPlayList.getPlayTimeSeconds());
	}
	
	@Test 
	public void testSortByName() {
		firstPlayList.sortByName();
		ArrayList<Playable> theExpected = new ArrayList<Playable>();
		theExpected.add(firstSong);
		theExpected.add(thirdSong); 
		assertEquals(theExpected, firstPlayList.getPlayableList()); 
	}
	
	@Test
	public void testSortByTime(){
		firstPlayList.sortByTime();
		secondPlayList.sortByTime();
		ArrayList<Playable> expected = new ArrayList<Playable>();
		expected.add(firstSong);
		expected.add(thirdSong);
		ArrayList<Playable> expected2 = new ArrayList<Playable>();
		expected2.add(thirdSong);
		expected2.add(firstPlayList); 
		expected2.add(fourthSong);
		assertEquals(expected2, secondPlayList.getPlayableList());
		assertEquals(expected, firstPlayList.getPlayableList());
	}

	@Test
	public void testCompareTo(){
		assertTrue(firstSong.compareTo(thirdSong) < 0);
		assertTrue(thirdSong.compareTo(fourthSong) < 0);
	}
	
	@Test
	public void testAddPlayList() {
		assertTrue(firstPlayList.addPlayList(secondPlayList));
		assertTrue(thirdPlayList.addPlayList(fourthPlayList));
	}
	
	
	@Test
	public void testRemovePlayable() {
		assertEquals(firstPlayList.removePlayable(firstSong), firstSong);
		assertEquals(secondPlayList.removePlayable(fourthSong), fourthSong);
	}
	
	@Test
	public void testLoadSongs() {
		PlayList playlist1 = new PlayList("Test Playlist");
		playlist1.loadSongs("HW4Text.txt");
		assertEquals(2, playlist1.numberOfSongs());
		assertEquals(2, playlist1.getPlayableList().size());
//		PlayList pl1 = new PlayList();
//		pl1.loadSongs("HWFourText.txt");
//		Song s1 = (Song) pl1.getPlayable(0);
//		Song s2 = (Song) pl1.getPlayable(1); 
//		
//		assertEquals(s1.getTitle(), "Rose Quartz");
//		assertEquals(s2.getTitle(), "Blue Pill");
//		assertEquals(s1.getArtist(), "Toro y Moi");
//		assertEquals(s2.getArtist(), "Metro Boomin");
//		assertEquals(s1.getMinutes(), 4);
//		assertEquals(s2.getMinutes(), 3);
//		assertEquals(s1.getSeconds(), 13);
//		assertEquals(s2.getSeconds(), 53);
	}
	
	
	@Test
	public void testAddSong() {
		firstPlayList.addSong(fourthSong);
		assertEquals(firstPlayList.numberOfSongs(), 3);
	}
	
	@Test 
	public void testAddSongSecond() {
		secondPlayList.addSong(fourthSong);
		assertEquals(5, secondPlayList.numberOfSongs());
	}
	
	@Test
	public void testClear() {
		assertEquals(false, firstPlayList.numberOfSongs() == 0);
		firstPlayList.clear(); 
		assertEquals(true, firstPlayList.numberOfSongs() == 0);
	}
	
	@Test
	public void testToString() {
		assertEquals(firstSong.toString(), "{Song: title = Title1 artist = Artist1}");
		assertEquals(thirdSong.toString(), "{Song: title = Title2 artist = Artist2}");
	}
	@Test
	public void testEquals() {
		assertTrue(secondSong.equals(firstSong));
		assertFalse(secondSong.equals(thirdSong));
	}
}
