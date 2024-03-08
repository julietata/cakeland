
public class Cake {

	private String cakeID;
	private String cakeName;
	private int cakePrice;
	private String cakeSize;
	private String cakeShape;
	
	public Cake(String cakeID, String cakeName, int cakePrice, String cakeSize, String cakeShape) {
		super();
		this.cakeID = cakeID;
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeSize = cakeSize;
		this.cakeShape = cakeShape;
	}
	
	public String getCakeID() {
		return cakeID;
	}
	public void setCakeID(String cakeID) {
		this.cakeID = cakeID;
	}
	public String getCakeName() {
		return cakeName;
	}
	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
	public int getCakePrice() {
		return cakePrice;
	}
	public void setCakePrice(int cakePrice) {
		this.cakePrice = cakePrice;
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
}
