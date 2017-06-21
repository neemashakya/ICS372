import java.util.Calendar;

public class Show {
	
	private String showName;
	private String clientID;
	private Calendar startDate;
	private Calendar endDate;
	
	public Show(String showName, String clientID, Calendar startDate, Calendar endDate) {
		this.showName = showName;
		this.clientID = clientID;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getShowName() {
		return showName;
	}

	public String getClientID() {
		return clientID;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}
	
	@Override
	public String toString() {
		return "Show: " + showName + " Client ID: " + clientID
				+ " Start Date: " + startDate + " End Date " + endDate;
	}
}
