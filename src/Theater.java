import java.util.LinkedList;
import java.util.List;

public class Theater {
	
	private static final long serialVersionUID = 1L;
	private static Theater theater;
	private List cards = new LinkedList();

	/*
	 * Private constructor to create singleton
	 */
	private Theater() {
	}

	/**
	 * Theater singleton
	 * @return the Theater singleton object
	 */
	public static Theater instance() {
		if (theater == null) {
			return (theater = new Theater());
		} 
		else {
			return theater;
		}
	}
}
