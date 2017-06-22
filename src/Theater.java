import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Theater implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static final int CLIENT_NOT_FOUND  = 1;
	public static final int CLIENT_HAS_SHOW  = 2;
	public static final int CLIENT_REMOVED  = 3;
//	public static final int BOOK_ISSUED  = 4;
//	public static final int HOLD_PLACED  = 5;
//	public static final int NO_HOLD_FOUND  = 6;
//	public static final int OPERATION_COMPLETED= 7;
//	public static final int OPERATION_FAILED= 8;
//	public static final int NO_SUCH_MEMBER = 9;
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
	
}
