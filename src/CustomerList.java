import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class creates a Show for a client holding a show name, clientID, and
 * start and end date for the show. creation
 * 
 * @author Matt Carlson, Jamison Czech, Slava Makharovich, Prashant Shrestha
 */

public class CustomerList implements Serializable {

	private static CustomerList customerList;
	private List customers = new LinkedList();

	/*
	 * Private constructor to create singleton
	 */
	private CustomerList() {
	}

	/**
	 * CustomerList singleton
	 * @return the CustomerList singleton object
	 */
	public static CustomerList instance() {
		if (customerList == null) {
			return (customerList = new CustomerList());
		} 
		else {
			return customerList;
		}
	}
	

	/**
	 * Adds a Customer to the collection
	 * @param customer
	 * @return a boolean indicating successful addition to collection
	 */
	public boolean insertCustomer(Customer customer) {
		customers.add(customer);
		return true;
	}
	
	/**
	 * searches for a customer in the collection
	 * @param customer
	 * @return a Customer if found or null if not found
	 */
	public Customer search(String customerID) {
	    for (Iterator iterator = customers.iterator(); iterator.hasNext(); ) {
	      Customer customer = (Customer) iterator.next();
	      if (customer.getCustomerID(.equals(customerID)) {
	        return customer;
	      }
	    }
	    return null;
	  }
	
	
	
	
	
	
	
	 
	/**
	 * removes a customer with the given customerID from the collection
	 * @param customerID
	 * @return true if Customer exists in the collection, or false otherwise
	 */
	public boolean removeCustomer(String customerID) {
		Customer customer = search(customerID);
		if (customer == null) {
			return false;
		}
		else {
			return customers.remove(customerID);
		}
	}
	
	/**
	 * String of the customer
	 */
	@Override
	public String toString() {
		return customers.toString();
	}

}
