
public class Cart {

	private String userId;
	private String cakeId;
	private int Quantity;
	
	public Cart(String userId, String cakeId, int quantity) {
		super();
		this.userId = userId;
		this.cakeId = cakeId;
		Quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
