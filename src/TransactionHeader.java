
public class TransactionHeader {

	private String transactionId;
	private String userId;
	private String transactionDate;
	private String pickUpDate;
	
	public TransactionHeader(String transactionId, String userId, String transactionDate, String pickUpDate) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.transactionDate = transactionDate;
		this.pickUpDate = pickUpDate;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getPickUpDate() {
		return pickUpDate;
	}

	public void setPickUpDate(String pickUpDate) {
		this.pickUpDate = pickUpDate;
	}
}
