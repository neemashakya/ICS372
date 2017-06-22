import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Theater implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static final int CLIENT_NOT_FOUND  = 1;
	public static final int CLIENT_HAS_SHOW  = 2;
	public static final int CLIENT_REMOVED  = 3;
	public static final int CUSTOMER_NOT_FOUND  = 4;
	public static final int CUSTOMER_REMOVED  = 5;
	public static final int DUPLICATE_CARD = 6;
	public static final int CARD_ADDED= 7;
	public static final int CARD_NOT_FOUND= 8;
	public static final int CARD_REMOVED = 9;
	public static final int ONLY_CARD = 10;
	public static final int DATE_NOT_OPEN = 11;
	public static final int SHOW_ADDED = 12;
	private ClientList clientList;
	private CustomerList customerList;
	private ShowList showList;
	
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

	public Client addClient(String name, String address, String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	public int removeClient(String clientID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterator getClients() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer addCustomer(String name, String address, String phoneNumber,
			String cardNumber, String expiration) {
		// TODO Auto-generated method stub
		return null;
	}

	public int removeCustomer(String customerID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addCreditCard(String customerID, String cardNumber,
			String expiration) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeCard(String cardNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterator getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public int addShow(String clientID, String showName, Calendar startDate,
			Calendar endDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Iterator getShows() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	public static Theater retrieve() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
