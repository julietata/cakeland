
public class TransactionDetail {

	private String transactionId;
	private String cakeId;
	private int Quantity;
	
	public TransactionDetail(String transactionId, String cakeId, int quantity) {
		super();
		this.transactionId = transactionId;
		this.cakeId = cakeId;
		Quantity = quantity;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCakeId() {
		return cakeId;
	}

	public void setCakeId(String cakeId) {
		this.cakeId = cakeId;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
