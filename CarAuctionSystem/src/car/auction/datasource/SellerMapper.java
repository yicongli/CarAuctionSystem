package car.auction.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import car.auction.domain.Seller;

public class SellerMapper {
	
	private static final String getAddressSellerStatement = "SELECT address FROM APP.seller";
	private static final String getLoginInfoSellerStatement = "SELECT username, password FROM APP.seller";
	
	private static final String updateStatementString =
            "UPDATE APP.users " +
                    "  set username = ?, password = ?, address = ?" +
                    "  where id = 1";
	
	public static void update(Seller s) {
        PreparedStatement updateStatement = null;
        try {
            updateStatement = DBConnection.prepare(updateStatementString);
            updateStatement.setString(1, s.getUsername());
            updateStatement.setString(2, s.getPassword());
            updateStatement.setString(3, s.getAddress());

            updateStatement.execute();

        } catch (Exception e) {
        	System.out.println("update error: " + e.getMessage());
    		// TODO handle the error situation
        }
    }
	
	
	public static List<Seller> getLoginInfoSeller() {
		List<Seller> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = DBConnection.prepare(getLoginInfoSellerStatement);

			  ResultSet rs = stmt.executeQuery();
			  while (rs.next()) {
				  Seller seller = new Seller (rs.getString(1), rs.getString(2));
				  
				  result.add(seller);
			  }

		} catch (SQLException e) {
			System.out.println("load error: " + e.getMessage());
    		// TODO handle the error situation
		}
		return result;

	}
	
	public static String getAddressSeller() {
		String result = null;
		
		try {
			PreparedStatement stmt = DBConnection.prepare(getAddressSellerStatement);

			  ResultSet rs = stmt.executeQuery();
			  while (rs.next()) {
				  result = rs.getString(1);
			  }

		} catch (SQLException e) {
			System.out.println("load address error: " + e.getMessage());
    		// TODO handle the error situation
		}
		return result;

	}

}
