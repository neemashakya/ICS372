import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The collection class for Client objects
 * 
 * @author Matt Carlson, Jamison Czech, Slava Makharovich, Prashant Shrestha
 */

public class ClientList implements Serializable {

	private static ClientList clientList;
	private List clients = new LinkedList();

	/*
	 * Private constructor to create singleton
	 */
	private ClientList() {
	}

	/**
	 * ClientList singleton
	 * @return the ClientList singleton object
	 */
	public static ClientList instance() {
		if (clientList == null) {
			return (clientList = new ClientList());
		} 
		else {
			return ClientList;
		}
	}
	

	/**
	 * Adds a Client to the collection
	 * @param client
	 * @return a boolean indicating successful addition to collection
	 */
	public boolean insertClient(Client client) {
		clients.add(client);
		return true;
	}
	
	/**
	 * searches for a client in the collection
	 * @param clientID
	 * @return a Client if found or null if not found
	 */
	public Customer search(String clientID) {
	    for (Iterator iterator = clients.iterator(); iterator.hasNext(); ) {
	      Client client = (Client) iterator.next();
	      if (client.getClientID(.equals(clientID)) {
	        return client;
	      }
	    }
	    return null;
    }
	
	 
	/**
	 * removes a client with the given clientID from the collection
	 * @param clientID
	 * @return true if Client exists in the collection, or false otherwise
	 */
	public boolean removeClient(String clientID) {
		Client client = search(clientID);
		if (client == null) {
			return false;
		}
		else {
			return clients.remove(clientID);
		}
	}
	
	/**
	 * String of the client
	 */
	@Override
	public String toString() {
		return clients.toString();
	}

}
