package datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyerMapper {
	
	
	static BuyerMapper load(ResultSet rs) throws SQLException {
		int idArg = rs.getInt(1);
        String usernameArg = rs.getString(2);
        String passwordArg = rs.getString(3);
        String firstnameArg = rs.getString(4);
        String lastnameArg = rs.getString(5);
        String phonenoArg = rs.getString(6);
        Buyer result = new Buyer(idArg, usernameArg, passwordArg, firstnameArg, lastnameArg, phonenoArg);
        return result;
	}
	
	/*public static List<Buyer> findById(int id) {
		String sql ="SELECT * " +
		         " FROM APP.buyer " +
        		 " WHERE id = {0}";
		PreparedStatement sqlPrepared = DBConnection.prepare(sql, id);
	}*/
}
