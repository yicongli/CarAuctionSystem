package car.auction.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import car.auction.domain.Seller;

public class SellerMapper {
	
	private static final String updateStatementString =
            "UPDATE APP.users " +
                    "  set username = ?, password = ?, address = ?" +
                    "  where id = 1";
	
	public void update(Seller s) {
        PreparedStatement updateStatement = null;
        try {
            updateStatement = DBConnection.prepare(updateStatementString);
            updateStatement.setString(1, s.getUsername());
            updateStatement.setString(2, s.getPassword());
            updateStatement.setString(3, s.getAddress());

            updateStatement.execute();

        } catch (Exception e) {

        }
    }
	
	public static Seller load(ResultSet rs) throws SQLException {
		int idArg = rs.getInt(1);
		String usernameArg = rs.getString(2);
        String passwordArg = rs.getString(3);
        String addressArg = rs.getString(4);
        Seller result = new Seller(idArg, usernameArg, passwordArg, addressArg);
        
        return result;
    }

}
