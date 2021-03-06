import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
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
	private List shows = new LinkedList();

	/*
	 * Private constructor to create singleton
	 */
	private ShowList() {
	}

	/**
	 * ShowList singleton
	 * @return the ShowList singleton object
	 */
	public static ShowList instance() {
		if (showList == null) {
			return (showList = new ShowList());
		} 
		else {
			return showList;
		}
	}
	

	/**
	 * Adds a Show to the collection
	 * @param newShow
	 * @return a boolean indicating successful addition to collection
	 */
	public boolean insertShow(Show newShow) {
		shows.add(newShow);
		return true;
	}
	
	/**
	 * searches for a show in the collection
	 * @param showName
	 * @return a show if found or null if not found
	 */
	public Show search(String showName) {
	    for (Iterator iterator = shows.iterator(); iterator.hasNext(); ) {
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
	public boolean removeShow(String showName) {
		Show showSearch = search(showName);
		if (showSearch == null) {
			return false;
		}
		else {
			return shows.remove(showName);
		}
	}
	
	
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public boolean checkDate(Calendar startDate, Calendar endDate){
		
		
		return true;
	}
	

	  /**
   * return a list of show
   */
  public void getShowList(){
      Iterator result = shows.iterator();
      System.out.println("The List of show: ");
      while(result.hasNext()) {
          System.out.println(result.next());
      }
  }
	
	/**
	 * write objects for serialization
	 * @param output stream
	 */
	private void writeObject(ObjectOutputStream output) {
	    try {
	      //output.defaultWriteObject();
	      output.writeObject(showList);
	    } 
	    catch(IOException ioe) {
	      System.out.println(ioe);
	    }
	  }
	
	  /**
	   * read serialized object
	   * @param input stream
	   */
	private void readObject(ObjectInputStream input) {
		try {
			if (showList != null) {
				return;
			} 
			else {
				//input.defaultReadObject();
				if (showList == null) {
					showList = (ShowList) input.readObject();
				} 
				else {
					input.readObject();
				}
			}
		} 
		catch(IOException ioe) {
			System.out.println("in ShowList readObject \n" + ioe);
		} 
		catch(ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
		}
	}
	
	/**
	 * String of the show
	 */
	@Override
	public String toString() {
		return shows.toString();
	}

}
