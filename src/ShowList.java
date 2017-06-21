import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The collection class for Show objects
 * 
 * @author Matt Carlson, Jamison Czech, Slava Makharovich, Prashant Shrestha
 */

public class ShowList implements Serializable {

	private static ShowList showList;
	private List show = new LinkedList();

	/*
	 * Private constructor to create singleton
	 */
	private ClientList() {
	}

	/**
	 * ShowList singleton
	 * @return the ShowList singleton object
	 */
	public static ShowList instance() {
		if (showtList == null) {
			return (showtList = new ShowList());
		} 
		else {
			return ShowList;
		}
	}
	

	/**
	 * Adds a Show to the collection
	 * @param show
	 * @return a boolean indicating successful addition to collection
	 */
	public boolean insertClient(Show show) {
		show.add(show);
		return true;
	}
	
	/**
	 * searches for a show in the collection
	 * @param showName
	 * @return a show if found or null if not found
	 */
	public Show search(String showName) {
	    for (Iterator iterator = show.iterator(); iterator.hasNext(); ) {
	      Show show = (Show) iterator.next();
	      if (show.getShowName().equals(showName)) {
	        return show;
	      }
	    }
	    return null;
	  }
	 
	/**
	 * removes a show with the given showName from the collection
	 * @param showName
	 * @return true if Show exists in the collection, or false otherwise
	 */
	public boolean removeClient(String showName) {
		Show show = search(showName);
		if (show == null) {
			return show;
		}
		else {
			return show.remove(showName);
		}
	}
	
	/**
	 * String of the show
	 */
	@Override
	public String toString() {
		return show.toString();
	}

}
