package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

	public static Connection creeConnexion() throws SQLException {
		String url ="jdbc:mysql://localhost/rmi"; //"jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/behr41u_RMI";
		url += "?serverTimezone=Europe/Paris";
		String login = "root";//"behr41u_appli";
		String pwd = "";//"antoine"; 
		Connection maConnexion = null;
		try { 
			maConnexion = DriverManager.getConnection(url, login, pwd);
			} catch (SQLException sqle) {
				System.out.println("Erreur connexion" + sqle.getMessage());
			}
		return maConnexion;
	}
	
	
}

