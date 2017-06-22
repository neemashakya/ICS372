/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 * Modified by Matt Carlson, Jamison Czech, Slava Makharovich, Prashant Shrestha
 */
import java.util.*;
import java.text.*;
import java.io.*;
/**
 * 
 * This class implements the user interface for the Theater project.
 * The commands are encoded as integers using a number of
 * static final variables. A number of utility methods exist to
 * make it easier to parse the input.
 *
 */
public class UserInterface {
  private static UserInterface userInterface;
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Theater theater;
  private static final int EXIT = 0;
  private static final int ADD_CLIENT = 1;
  private static final int REMOVE_CLIENT = 2;
  private static final int LIST_CLIENTS = 3;
  private static final int ADD_CUSTOMER = 4;
  private static final int REMOVE_CUSTOMER = 5;
  private static final int ADD_CARD = 6;
  private static final int REMOVE_CARD = 7;
  private static final int LIST_CUSTOMERS = 8;
  private static final int ADD_SHOW = 9;
  private static final int LIST_SHOWS = 10;
  private static final int SAVE = 11;
  private static final int RETRIEVE = 12;
  private static final int HELP = 13;
  
  /**
   * Made private for singleton pattern.
   * Conditionally looks for any saved data. Otherwise, it gets
   * a singleton Theater object.
   */
  private UserInterface() {
    if (yesOrNo("Look for saved data and  use it?")) {
      retrieve();
    } else {
      theater = Theater.instance();
    }
  }
  /**
   * Supports the singleton pattern
   * 
   * @return the singleton object
   */
  public static UserInterface instance() {
    if (userInterface == null) {
      return userInterface = new UserInterface();
    } else {
      return userInterface;
    }
  }
  /**
   * Gets a token after prompting
   * 
   * @param prompt - whatever the user wants as prompt
   * @return - the token from the keyboard
   * 
   */
  public String getToken(String prompt) {
    do {
      try {
        System.out.println(prompt);
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
        if (tokenizer.hasMoreTokens()) {
          return tokenizer.nextToken();
        }
      } catch (IOException ioe) {
        System.exit(0);
      }
    } while (true);
  }
  /**
   * Queries for a yes or no and returns true for yes and false for no
   * 
   * @param prompt The string to be prepended to the yes/no prompt
   * @return true for yes and false for no
   * 
   */
  private boolean yesOrNo(String prompt) {
    String more = getToken(prompt + " (Y|y)[es] or anything else for no");
    if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
      return false;
    }
    return true;
  }
  /**
   * Converts the string to a number
   * @param prompt the string for prompting
   * @return the integer corresponding to the string
   * 
   */
  public int getNumber(String prompt) {
    do {
      try {
        String item = getToken(prompt);
        Integer number = Integer.valueOf(item);
        return number.intValue();
      } catch (NumberFormatException nfe) {
        System.out.println("Please input a number ");
      }
    } while (true);
  }
  /**
   * Prompts for a date and gets a date object
   * @param prompt the prompt
   * @return the data as a Calendar object
   */
  public Calendar getDate(String prompt) {
    do {
      try {
        Calendar date = new GregorianCalendar();
        String item = getToken(prompt);
        DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
        date.setTime(dateFormat.parse(item));
        return date;
      } catch (Exception fe) {
        System.out.println("Please input a date as mm/dd/yy");
      }
    } while (true);
  }
  /**
   * Prompts for a command from the keyboard
   * 
   * @return a valid command
   * 
   */
  public int getCommand() {
    do {
      try {
        int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
        if (value >= EXIT && value <= HELP) {
          return value;
        }
      } catch (NumberFormatException nfe) {
        System.out.println("Enter a number");
      }
    } while (true);
  }
  /**
   * Displays the help screen
   * 
   */
  public void help() {
    System.out.println("Enter a number between 0 and 12 as explained below:");
    System.out.println(EXIT + " to Exit\n");
    System.out.println(ADD_CLIENT + " to add a member");
    System.out.println(REMOVE_CLIENT + " to  add books");
    System.out.println(LIST_CLIENTS + " to  issue books to a  member");
    System.out.println(ADD_CUSTOMER + " to  return books ");
    System.out.println(REMOVE_CUSTOMER + " to  renew books ");
    System.out.println(ADD_CARD + " to  remove books");
    System.out.println(REMOVE_CARD + " to  place a hold on a book");
    System.out.println(LIST_CUSTOMERS + " to  remove a hold on a book");
    System.out.println(ADD_SHOW + " to  process holds");
    System.out.println(LIST_SHOWS + " to  print transactions");
    System.out.println(SAVE + " to  save data");
    System.out.println(RETRIEVE + " to  retrieve");
    System.out.println(HELP + " for help");
  }
  /**
   * Method to be called for adding a client.
   * Prompts the user for the appropriate values and
   * uses the appropriate Theater method for adding the client.
   *  
   */
  public void addClient() {
    String name = getToken("Enter member name");
    String address = getToken("Enter address");
    String phone = getToken("Enter phone");
    Client result;
    result = theater.addClient(name, address, phone);
    if (result == null) {
      System.out.println("Could not add client");
    }
    System.out.println(result);
  }
  
  /**
   * Method to be called for removing a client.
   * Prompts the user for the appropriate value and
   * uses the appropriate Theater method for removing the client if possible.
   *  
   */
  public void removeClient() {
	  int result;
	  do {
		  String clientID = getToken("Enter client id");
		  result = theater.removeClient(clientID);
		  
		  switch (result) {
		  case Theater.CLIENT_NOT_FOUND:
			  System.out.println("No such client");
			  break;
		  case Theater.CLIENT_HAS_SHOW:
			  System.out.println("Client cannot be removed. Client has a scheduled show.");
			  break;
		  case Theater.CLIENT_REMOVED:
			  System.out.println("Client was successfully removed");
			  break;
		  }
		  if (!yesOrNo("Remove more clients?")) {
		        break;
	      }
	  } while (true);
  }
  
  /**
   * Method to be called for displaying clients.
   * Prompts the user for the appropriate values and
   * uses the appropriate Theater method for displaying clients.
   *  
   */
  public void getClients() {
    Iterator result;
    
    result = theater.getClients();
    if (result == null) {
      System.out.println("No clients have been added");
    } 
    else {
      while(result.hasNext()) {
        Client client = (Client) result.next();
        System.out.println(client.toString() + "\n");
      }
      System.out.println("\n  There are no more clients \n" );
    }
  }
  
  
  /**
   * Method to be called for adding a customer.
   * Prompts the user for the appropriate values and
   * uses the appropriate Theater method for adding the customer.
   *  
   */
  public void addCustomer() {
    Customer result;
    do {
      String name = getToken("Enter name");
      String address = getToken("Enter address");
      String phoneNumber = getToken("Enter phone number");
      // needs to call card validation method
      String cardNumber = getToken("Enter credit card number");
      // needs to call expiration validation method
      String expiration = getToken("Enter expiration date");
  
      result = theater.addCustomer(name, address, phoneNumber, cardNumber, expiration);
      if (result != null) {
        System.out.println(result);
      } else {
        System.out.println("Customer could not be added");
      }
      if (!yesOrNo("Add more customers?")) {
        break;
      }
    } while (true);
  }
  
  
  /**
   * Method to be called for issuing books.
   * Prompts the user for the appropriate values and
   * uses the appropriate Library method for issuing books.
   *  
   */
  public void issueBooks() {
    Book result;
    String memberID = getToken("Enter member id");
    if (library.searchMembership(memberID) == null) {
      System.out.println("No such member");
      return;
    }
    do {
      String bookID = getToken("Enter book id");
      result = library.issueBook(memberID, bookID);
      if (result != null){
        System.out.println(result.getTitle()+ "   " +  result.getDueDate());
      } else {
          System.out.println("Book could not be issued");
      }
      if (!yesOrNo("Issue more books?")) {
        break;
      }
    } while (true);
  }
  /**
   * Method to be called for renewing books.
   * Prompts the user for the appropriate values and
   * uses the appropriate Library method for renewing books.
   *  
   */
  public void renewBooks() {
    Book result;
    String memberID = getToken("Enter member id");
    if (library.searchMembership(memberID) == null) {
      System.out.println("No such member");
      return;
    }
    Iterator issuedBooks = library.getBooks(memberID);
    while (issuedBooks.hasNext()){
      Book book = (Book)(issuedBooks.next());
      if (yesOrNo(book.getTitle())) {
        result = library.renewBook(book.getId(), memberID);
        if (result != null){
          System.out.println(result.getTitle()+ "   " + result.getDueDate());
        } else {
          System.out.println("Book is not renewable");
        }
      }
    }
  }
  /**
   * Method to be called for returning books.
   * Prompts the user for the appropriate values and
   * uses the appropriate Library method for returning books.
   *  
   */
  public void returnBooks() {
    int result;
    do {
      String bookID = getToken("Enter book id");
      result = library.returnBook(bookID);
      switch(result) {
        case Library.BOOK_NOT_FOUND:
          System.out.println("No such Book in Library");
          break;
        case Library.BOOK_NOT_ISSUED:
          System.out.println(" Book  was not checked out");
          break;
        case Library.BOOK_HAS_HOLD:
          System.out.println("Book has a hold");
          break;
        case Library.OPERATION_FAILED:
          System.out.println("Book could not be returned");
          break;
        case Library.OPERATION_COMPLETED:
          System.out.println(" Book has been returned");
          break;
        default:
          System.out.println("An error has occurred");
      }
      if (!yesOrNo("Return more books?")) {
        break;
      }
    } while (true);
  }
  /**
   * Method to be called for removing books.
   * Prompts the user for the appropriate values and
   * uses the appropriate Library method for removing books.
   *  
   */
  public void removeBooks() {
    int result;
    do {
      String bookID = getToken("Enter book id");
      result = library.removeBook(bookID);
      switch(result){
        case Library.BOOK_NOT_FOUND:
          System.out.println("No such Book in Library");
          break;
        case Library.BOOK_ISSUED:
          System.out.println(" Book is currently checked out");
          break;
        case Library.BOOK_HAS_HOLD:
          System.out.println("Book has a hold");
          break;
        case Library.OPERATION_FAILED:
          System.out.println("Book could not be removed");
          break;
        case Library.OPERATION_COMPLETED:
          System.out.println(" Book has been removed");
          break;
        default:
          System.out.println("An error has occurred");
      }
      if (!yesOrNo("Remove more books?")) {
        break;
      }
    } while (true);
  }
  /**
   * Method to be called for placing a hold.
   * Prompts the user for the appropriate values and
   * uses the appropriate Library method for placing a hold.
   *  
   */
  public void placeHold() {
    String memberID = getToken("Enter member id");
    String bookID = getToken("Enter book id");
    int duration = getNumber("Enter duration of hold");
    int result = library.placeHold(memberID, bookID, duration);
    switch(result){
      case Library.BOOK_NOT_FOUND:
        System.out.println("No such Book in Library");
        break;
      case Library.BOOK_NOT_ISSUED:
        System.out.println(" Book is not checked out");
        break;
      case Library.NO_SUCH_MEMBER:
        System.out.println("Not a valid member ID");
        break;
      case Library.HOLD_PLACED:
        System.out.println("A hold has been placed");
        break;
      default:
        System.out.println("An error has occurred");
    }
  }
  /**
   * Method to be called for removing a holds.
   * Prompts the user for the appropriate values and
   * uses the appropriate Library method for removing a hold.
   *  
   */
  public void removeHold() {
    String memberID = getToken("Enter member id");
    String bookID = getToken("Enter book id");
    int result = library.removeHold(memberID, bookID);
    switch(result){
      case Library.BOOK_NOT_FOUND:
        System.out.println("No such Book in Library");
        break;
      case Library.NO_SUCH_MEMBER:
        System.out.println("Not a valid member ID");
        break;
      case Library.OPERATION_COMPLETED:
        System.out.println("The hold has been removed");
        break;
      default:
        System.out.println("An error has occurred");
    }
  }
  /**
   * Method to be called for processing books.
   * Prompts the user for the appropriate values and
   * uses the appropriate Library method for processing books.
   *  
   */
  public void processHolds() {
    Member result;
    do {
      String bookID = getToken("Enter book id");
      result = library.processHold(bookID);
      if (result != null) {
        System.out.println(result);
      } else {
        System.out.println("No valid holds left");
      }
      if (!yesOrNo("Process more books?")) {
        break;
      }
    } while (true);
  }
  /**
   * Method to be called for displaying transactions.
   * Prompts the user for the appropriate values and
   * uses the appropriate Library method for displaying transactions.
   *  
   */
  public void getTransactions() {
    Iterator result;
    String memberID = getToken("Enter member id");
    Calendar date  = getDate("Please enter the date for which you want records as mm/dd/yy");
    result = library.getTransactions(memberID,date);
    if (result == null) {
      System.out.println("Invalid Member ID");
    } else {
      while(result.hasNext()) {
        Transaction transaction = (Transaction) result.next();
        System.out.println(transaction.getType() + "   "   + transaction.getTitle() + "\n");
      }
      System.out.println("\n  There are no more transactions \n" );
    }
  }
  /**
   * Method to be called for saving the Library object.
   * Uses the appropriate Library method for saving.
   *  
   */
  private void save() {
    if (library.save()) {
      System.out.println(" The library has been successfully saved in the file LibraryData \n" );
    } else {
      System.out.println(" There has been an error in saving \n" );
    }
  }
  /**
   * Method to be called for retrieving saved data.
   * Uses the appropriate Library method for retrieval.
   *  
   */
  private void retrieve() {
    try {
      Library tempLibrary = Library.retrieve();
      if (tempLibrary != null) {
        System.out.println(" The library has been successfully retrieved from the file LibraryData \n" );
        library = tempLibrary;
      } else {
        System.out.println("File doesnt exist; creating new library" );
        library = Library.instance();
      }
    } catch(Exception cnfe) {
      cnfe.printStackTrace();
    }
  }
  /**
   * Orchestrates the whole process.
   * Calls the appropriate method for the different functionalties.
   *  
   */
  public void process() {
    int command;
    help();
    while ((command = getCommand()) != EXIT) {
      switch (command) {
        case ADD_CLIENT:        addClient();
                                break;
        case REMOVE_CLIENT:     removeClient();
                                break;
        case LIST_CLIENTS:       issueBooks();
                                break;
        case ADD_CUSTOMER:      returnBooks();
                                break;
        case ADD_CARD:      removeBooks();
                                break;
        case REMOVE_CUSTOMER:       renewBooks();
                                break;
        case REMOVE_CARD:        placeHold();
                                break;
        case LIST_CUSTOMERS:       removeHold();
                                break;
        case ADD_SHOW:      processHolds();
                                break;
        case LIST_SHOWS:  getTransactions();
                                break;
        case SAVE:              save();
                                break;
        case RETRIEVE:          retrieve();
                                break;
        case HELP:              help();
                                break;
      }
    }
  }
  /**
   * The method to start the application. Simply calls process().
   * @param args not used
   */
  public static void main(String[] args) {
    UserInterface.instance().process();
  }
}
