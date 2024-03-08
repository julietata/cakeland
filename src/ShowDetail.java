
public class ShowDetail {

	private String cakeName;
	private String cakeSize;
	private String cakeShape;
	private int price;
	private int qty;
	private int subtotal;
	
	public ShowDetail(String cakeName, String cakeSize, String cakeShape, int price, int qty, int subtotal) {
		super();
		this.cakeName = cakeName;
		this.cakeSize = cakeSize;
		this.cakeShape = cakeShape;
		this.price = price;
		this.qty = qty;
		this.subtotal = subtotal;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
}
