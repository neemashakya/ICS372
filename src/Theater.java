import java.io.*;
import java.util.*;


public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int CLIENT_NOT_FOUND = 1;
    public static final int CLIENT_HAS_SHOW = 2;
    public static final int CLIENT_REMOVED = 3;
    public static final int CUSTOMER_NOT_FOUND = 4;
    public static final int CUSTOMER_REMOVED = 5;
    public static final int DUPLICATE_CARD = 6;
    public static final int CARD_ADDED = 7;
    public static final int CARD_NOT_FOUND = 8;
    public static final int CARD_REMOVED = 9;
    public static final int ONLY_CARD = 10;
    public static final int DATE_NOT_OPEN = 11;
    public static final int SHOW_ADDED = 12;
    private ClientList clientList;
    private CustomerList customerList;
    private ShowList showList;
    private CardList cardList;

    private static Theater theater;
    private List cards = new LinkedList();
     private List client = new LinkedList();
    /*
     * Private constructor to create singleton
     *
     *
     */
    private Theater() {
        cardList = CardList.instance();
        clientList = ClientList.instance();
        showList = ShowList.instance();
        customerList = CustomerList.instance();
    }

    /**
     * Theater singleton
     *
     * @return the Theater singleton object
     * <CODE></CODE>
     */
    public static Theater instance() {
        return theater == null ? (theater = new Theater()) : theater;
    }

    /**
     * @param name    <CODE>String Name</CODE>
     * @param address <CODE>String address</CODE>
     * @param phone   <CODE>String phone</CODE>
     * @return
     */
    public Client addClient(String name, String address, String phone) {
        Client client = new Client(name, address, phone);
        if (clientList.insertClient(client)) {
            return (client);
        }
        return null;
    }


    /**
     * @param clientID <CODE>String clientID</CODE>
     * @return <b>Postcondition:</b>
     * returns a message to the user indicating the
     * return value of a client
     */
    public int removeClient(String clientID) {
        Client client = clientList.search(clientID);
        if (client == null) {
            return (CLIENT_NOT_FOUND);
        }else {
            clientList.removeClient(clientID);
            return (CLIENT_REMOVED);
        }
    }


    public Iterator getClients() {

       return clientList.getClients();

    }

    /**
     * @param name
     * @param address
     * @param phoneNumber
     * @param cardNumber
     * @param expiration
     * @return
     */

    public Customer addCustomer(String name, String address, String phoneNumber,
                                String cardNumber, String expiration) {
        CreditCard card = cardList.search(cardNumber);
        if (card == null) {
            String customerID;
            Customer customer = new Customer(name, address, phoneNumber);
            customerID = customer.getCustomerID();
            CreditCard newCard = new CreditCard(customerID, cardNumber, expiration);
            if (cardList.insertCard(newCard)) {
                if (customer.insertCard(newCard)) {
                    customerList.insertCustomer(customer);
                    return customer;
                } else {
                    cardList.removeCard(cardNumber);
                    return null;
                }
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * @param customerID
     * @return
     */
    public int removeCustomer(String customerID) {
        Customer customer = customerList.search(customerID);
        if (!(customer == null)) {
            for (Iterator iterator = customer.getCustomerCard(); iterator.hasNext(); ) {
                CreditCard creditCard = (CreditCard) iterator.next();
                cardList.removeCard(creditCard.getCardNumber());
            }
            customerList.removeCustomer(customerID);
            return CUSTOMER_REMOVED;
        }
        return CUSTOMER_NOT_FOUND;
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

    /**
     * Serializes the Theater object
     *
     * @return true iff the data could be saved
     */
    public static boolean save() {
        try {
            FileOutputStream file = new FileOutputStream("TheaterData");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(theater);
            output.writeObject(CreateIdServer.instance());
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
    }


    /**
     * Retrieves a deserialized version of the theater from disk
     * @return
     *   a Library object
     */
    public static Theater retrieve() {
        try {
            FileInputStream file = new FileInputStream("TheaterData");
            ObjectInputStream input = new ObjectInputStream(file);
            input.readObject();
            CreateIdServer.retrieve(input);
            return theater;
        } catch(IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch(ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            return null;
        }
    }

    /**
     * Writes the object to the output stream
     *
     * @param output <code>ObjectOutputStream output</code>
     *               the stream to be written to
     */
    private void writeObject(ObjectOutputStream output) {
        try {
            output.defaultWriteObject();
            output.writeObject(theater);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    /**
     * Reads the object from a given stream
     *
     * @param input the stream to be read
     */
    private void readObject(ObjectInputStream input) {
        try {
            input.defaultReadObject();
            if (theater == null) {
                theater = (Theater) input.readObject();
            } else {
                input.readObject();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
