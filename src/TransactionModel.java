import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TransactionModel {

	static Connector conn = Connector.getConnection();
	
	public static Vector<TransactionHeader> showHeader() {
		Vector<TransactionHeader> data = new Vector();
		String query = "SELECT * FROM transactionheader WHERE UserID = '" + Login.userLog.getUserID() + "'";
		ResultSet rs = conn.executeQuery(query);
		String transId, date, pickDate;
		try {
			while (rs.next()) {
				transId = rs.getString("TransactionID");
				date = rs.getString("TransactionDate");
				pickDate = rs.getString("PickUpDate");
				data.add(new TransactionHeader(transId, Login.userLog.getUserID(), date, pickDate));
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return data;
	}
	
	public static Vector<ShowDetail> showDetail(String id){
		String query = "SELECT * FROM transactiondetail JOIN cake ON cake.CakeID = transactiondetail.CakeID WHERE TransactionID = '" + id + "'";
		Vector<ShowDetail> data = new Vector();
		ResultSet rs = conn.executeQuery(query);
		String cakeName, cakeSize, cakeShape;
		int price, qty, subtotal;
		try {
			while (rs.next()) {
				cakeName = rs.getString("CakeName");
				cakeSize = rs.getString("CakeSize");
				cakeShape = rs.getString("CakeShape");
				price = rs.getInt("CakePrice");
				qty = rs.getInt("Quantity");
				subtotal = price * qty;
				data.add(new ShowDetail(cakeName, cakeSize, cakeShape, price, qty, subtotal));
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return data;
	}
	
	public static boolean insertTransHeader(String transId, String userId, String transDate, String pickUpDate) {
		String query = "INSERT INTO transactionheader VALUES (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setString(1, transId);
			ps.setString(2, userId);
			ps.setString(3, transDate);
			ps.setString(4, pickUpDate);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static boolean insertTransDetail(String transId, String cakeId, int qty) {
		String query = "INSERT INTO transactiondetail VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setString(1, transId);
			ps.setString(2, cakeId);
			ps.setInt(3, qty);
			ps.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static boolean deleteCheckOut() {
		String query = "DELETE FROM cart WHERE UserID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setString(1, Login.userLog.getUserID());
			ps.execute();
		}
		catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static boolean checkId(String id) {
		String query = "SELECT * FROM transactionheader WHERE TransactionID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		try {
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (!rs.next()) {
				return false;
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return true;
	}
	
	public static Vector<ShowCart> showCart() {
		String query = "SELECT * FROM cart JOIN cake ON cart.CakeID = cake.CakeID WHERE UserID=" + "'" + Login.userLog.getUserID() + "'";
		Vector<ShowCart> data = new Vector();
		ResultSet rs = conn.executeQuery(query);
		String cakeName, cakeSize, cakeShape, cakeId, userId;
		int price, quantity;
		try {
			while (rs.next()) {
				cakeName = rs.getString("CakeName");
				cakeSize = rs.getString("CakeSize");
				cakeShape = rs.getString("CakeShape");
				price = rs.getInt("CakePrice");
				quantity = rs.getInt("Quantity");
				cakeId = rs.getString("CakeID");
				userId = rs.getString("UserID");
				data.add(new ShowCart(cakeName, cakeSize, cakeShape, cakeId, userId, price, quantity));
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return data;
	}
	
	public static boolean updateCart(int quantity) {
		String query = "UPDATE cart SET Quantity = ? WHERE CakeID = ? AND UserID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setInt(1, quantity);
			ps.setString(2, ManageCart.selectId);
			ps.setString(3, Login.userLog.getUserID());
			ps.execute();
		}
		catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static boolean deleteCart() {
		String query = "DELETE FROM cart WHERE CakeID=? and UserID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setString(1, ManageCart.selectId);
			ps.setString(2, Login.userLog.getUserID());
			ps.execute();
		}
		catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static boolean insertCart(String userId, String cakeId, int quantity) {
		String query = "INSERT INTO cart VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setString(1, userId);
			ps.setString(2, cakeId);
			ps.setInt(3, quantity);
			ps.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static boolean checkCart() {
		String query = "SELECT * FROM cart WHERE UserID = '" + Login.userLog.getUserID() + "'";
		ResultSet rs = conn.executeQuery(query);
		try {
			while (rs.next()) {
				return true;
			}
		}
		catch (SQLException e) {
			return false;
		}
		return false;
	}
	
	public static boolean check(String cakeId) {
		String query = "SELECT * FROM cart WHERE UserID = '" + Login.userLog.getUserID() + "' AND CakeID = '" +  cakeId + "'";
		ResultSet rs = conn.executeQuery(query);
		try {
			while (rs.next()) {
				return false;
			}
		}
		catch(SQLException e) {
			return true;
		}
		return true;
	}
}
