
public class ShowCart {

	private String cakeName;
	private String cakeSize;
	private String cakeShape;
	private String cakeId;
	private String userId;
	private int price;
	private int quantity;
	
	public ShowCart(String cakeName, String cakeSize, String cakeShape, String cakeId, String userId, int price,
			int quantity) {
		super();
		this.cakeName = cakeName;
		this.cakeSize = cakeSize;
		this.cakeShape = cakeShape;
		this.cakeId = cakeId;
		this.userId = userId;
		this.price = price;
		this.quantity = quantity;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public String getCakeSize() {
		return cakeSize;
	}

	public void setCakeSize(String cakeSize) {
		this.cakeSize = cakeSize;
	}

	public String getCakeShape() {
		return cakeShape;
	}

	public void setCakeShape(String cakeShape) {
		this.cakeShape = cakeShape;
	}

	public String getCakeId() {
		return cakeId;
	}

	public void setCakeId(String cakeId) {
		this.cakeId = cakeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
