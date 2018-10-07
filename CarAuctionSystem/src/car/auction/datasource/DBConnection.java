package car.auction.datasource;

import java.sql.*;

public class DBConnection {
		
	/* DB INFO:
	private static String host = "ec2-50-17-194-186.compute-1.amazonaws.com";
	private static String user = "vpsevylwsefnhm";
	private static String password = "ac3586f78e635d23107a8f69103a06c436a389a91fa6a790a57062faac0e8f07";
	private static String dbname = "d68u8u994pjdf9";
	private static String port = "5432";
	*/
	
	//private static final String DB_CONNECTION = System.getenv().get("JDBC_DATABASE_URL");
	//private static final String DB_USER = System.getenv().get("JDBC_DATABASE_USERNAME");
	//private static final String DB_PASSWORD = System.getenv().get("JDBC_DATABASE_PASSWORD");
	private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/carauction;create=true";
	private static final String DB_USER = "user";
	private static final String DB_PASSWORD = "123";

	public static Connection dbConnection;

	// prepare for the operation
    public static PreparedStatement prepare(String stm) {
		 
		PreparedStatement preparedStatement = null;
		try {	
	
	       	dbConnection = getDBConnection();
	       	dbConnection.setAutoCommit(false);

			preparedStatement = dbConnection.prepareStatement(stm, Statement.RETURN_GENERATED_KEYS);

			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		
		}

		return preparedStatement;
	}
    
    // get connection
	private static Connection getDBConnection() {

		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());

			Connection dbConnection = DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		System.out.println("Connection problem");
		return null;

	}

	// prepare operation
    public static PreparedStatement prepare(String stm, int returnGeneratedKeys) {
        PreparedStatement preparedStatement = null;
        try {

            Connection dbConnection = getDBConnection();

            preparedStatement = dbConnection.prepareStatement(stm, returnGeneratedKeys);


        } catch (SQLException e) {

            System.out.println(e.getMessage());


        }

        return preparedStatement;
    }
}