package gengfo.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DerbyTest {
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public DerbyTest() throws Exception {
		try {

			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			connect = DriverManager
					.getConnection("jdbc:derby://localhost/c:/temp/db/FAQ/db;create=true");
			PreparedStatement statement = connect
					.prepareStatement("SELECT * from todo");

			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				String user = resultSet.getString("id");
				String summary = resultSet.getString("summary");
				System.out.println("User: " + user);
				System.out.println("summary: " + summary);
			}
			
			System.out.println("Done");
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) throws Exception {
		DerbyTest dao = new DerbyTest();
	}

}
