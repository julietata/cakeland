import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

	public UserModel() {}
	
	static Connector conn = Connector.getConnection();
	
	public static boolean checkName(String name) {
		String query = "SELECT * FROM user WHERE Username=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		try {
			ps.setString(1, name);
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
	
	public static boolean checkPhone(String phone) {
		String query = "SELECT * FROM user WHERE UserPhoneNumber=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		try {
			ps.setString(1, phone);
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
	
	public static boolean checkId(String id) {
		String query = "SELECT * FROM user WHERE UserID=?";
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
	
	public static User checkLogin(String name, String password) {
		String query = "SELECT * FROM user WHERE Username=? AND UserPassword=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = null;
		try {
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new User(
						rs.getString("UserID"),
						rs.getString("Username"),
						rs.getString("UserEmail"),
						rs.getString("UserPassword"),
						rs.getString("UserGender"),
						rs.getString("UserDOB"),
						rs.getString("UserPhoneNumber"),
						rs.getString("UserAddress"),
						rs.getString("UserRole")
						);
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static boolean UpdateUser(String id, String name, String email, String pass, String gender, String dob, String phone, String address, String role) {
		String query = "UPDATE user SET Username=?, UserEmail=?, UserPassword=?, UserGender=?, UserDob=?, UserPhoneNumber=?, UserAddress=?, UserRole=? WHERE UserID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setString(4, gender);
			ps.setString(5, dob);
			ps.setString(6, phone);
			ps.setString(7, address);
			ps.setString(8, role);
			ps.setString(9, id);
			ps.execute();
		}
		catch(SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public static boolean InsertUser(String id, String name, String email, String pass, String gender, String dob, String phone, String address, String role) {
		String query = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		try {
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, pass);
			ps.setString(5, gender);
			ps.setString(6, dob);
			ps.setString(7, phone);
			ps.setString(8, address);
			ps.setString(9, role);
			ps.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
}
