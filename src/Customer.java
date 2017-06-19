
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class creates a Customer and assigns a unique ID to the Customer upon
 * creation
 * 
 * @author Matt Carlson, Jamison Czech, Slava Makharovich, Prashant Shrestha
 */
public class Customer {

	// Unique identifier assigned to a new customer
	private static long ID = 1L;

	private String name;
	private String address;
	private String phoneNumber;
	private long customerID;
	private double balance;
	private List customerCard = new LinkedList();

	/**
	 * Creates a new Customer assigning a unique ID and default balance
	 * 
	 * @param name
	 * @param address
	 * @param phoneNumber
	 */
	public Customer(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.customerID = ID;
		ID++;
	}

	// INCOMPLETE
	public void insertCard(CreditCard creditCard) {
		customerCard.add(creditCard);
	}

	// INCOMPLETE
	public void removeCard(CreditCard creditCard) {
		customerCard.remove(creditCard);
	}

	/**
	 * Getter for list of cards for a Customer
	 * 
	 * @return an iterator of a customer's credit cards
	 */
	public Iterator getCustomerCard() {
		return customerCard.listIterator();
	}

	/**
	 * Gets number of cards a customer has on file
	 * 
	 * @return an int of the number of cards a customer has on file
	 */
	public int cardCount() {
		return customerCard.size();
	}

	/**
	 * Gets customer's name
	 * 
	 * @return a string of the customer's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets customer's address
	 * 
	 * @return a string of the customer's address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Gets customer's phone number
	 * 
	 * @return a string of the customer's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Get the customer's ID number
	 * 
	 * @return a long of the customer's ID number
	 */
	public long getCustomerID() {
		return customerID;
	}

	/**
	 * String representing a customer
	 * 
	 * @return a string representing a customer
	 */
	@Override
	public String toString() {
		return "Customer ID: " + customerID + " Name: " + name + " Address: "
				+ address + " Phone number: " + phoneNumber;
	}

}
