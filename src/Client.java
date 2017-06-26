import java.io.Serializable;

/**
 * This class creates a Client and assigns a unique ID to the Client upon creation
 * @author Matt Carlson, Jamison Czech, Slava Makharovich, Prashant Shrestha 
 */

public class Client implements Serializable{
  
    // Unique identifier assigned to a new client
    private static long ID = 1L;
    private String name;
    private String address;
    private String phoneNumber;
    private String clientID;
    private double balance;
    private static final String CLIENT_ID_STRING = "CL-";
    /**
     * Creates a new Client assigning a unique ID and default balance
     * @param name
     * @param address
     * @param phoneNumber
     */
    public Client(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = 0;
        //this.clientID = Long.toString(ID);
        clientID =  CLIENT_ID_STRING + (  CreateIdServer.instance().getId());
        ID++;
    }

    /**
     * Gets client's name
     * @return
     * <b>PostCondition:</b>
     *   Returns a string of the client's name.
     */
    public String getName() {
        return name;
    }


    /**
     *
     * @return
     * <b>PostCondition:</b>
     *   Returns the Client's current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets client's address
     * @return a string of the client's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets client's phone number
     * @return a string of the client's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get the client's ID number
     * @return a long of the client's ID number
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * String representing a client
     * @return a string representing a client
     */
    @Override
    public String toString() {
        return "Client ID: " + getClientID() + " Name: " + getName() + " Address: "
                + getAddress() + " Phone number: " + getPhoneNumber()+ " Balance: "
                + balance;




    }

}
