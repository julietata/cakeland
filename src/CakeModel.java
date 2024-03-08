import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CakeModel {

public CakeModel() {}
	
	static Connector conn = Connector.getConnection();
	
	public static boolean deleteCake() {
		String query = "DELETE FROM cake WHERE CakeID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setString(1, ManageCake.deletedId);
			ps.execute();
		}
		catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static Vector<Cake> getCakeList(){
		Vector<Cake> cakes = new Vector();
		String query = "SELECT * FROM cake";
		ResultSet rs = conn.executeQuery(query);
		String id, name, shape, size;
		int price;
		try {
			while (rs.next()) {
				id = rs.getString("CakeID");
				name = rs.getString("CakeName");
				price = rs.getInt("CakePrice");
				shape = rs.getString("CakeShape");
				size = rs.getString("CakeSize");
				
				cakes.add(new Cake(id, name, price, size, shape));
			}
			return cakes;
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return cakes;
	}
	
	public static boolean InsertCake(String id, String name, int price, String size, String shape) {
		String query = "INSERT INTO cake VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setString(4, size);
			ps.setString(5, shape);
			ps.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
}
