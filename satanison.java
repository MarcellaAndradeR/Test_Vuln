// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3
import java.io.*;

class MyCode {
	public static void main (String[] args) {
		System.out.println("Hello Java");
	}
}



// Your last C/C++ code is saved below:
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

 public class ExecuteSearch {
   
 	private static String dbUrl = "jdbc:mysql://localhost:3306/usersdb"; //endereço do banco no codigo podria estar em um dotenv 
 	private static String username = "admin";  
 	private static String password = "root";
 	// credenciais de acesso a banco hard coded poderia ser substituido por um dotenv linhas 8-9
  
  public void getConnection() {
	try {
			 
 		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		 
 		    if (conn != null) {
 		        System.out.println("Connected");
 		    }
 		} catch (SQLException ex) {
 		    ex.printStackTrace();
		}
 	}
 	public void DBInfoStack(String username, String password, String fullname, String email) {
 		String sql = "INSERT INTO Users (username,password, fullname, email) "
			+ "VALUES (?,?," + fullname +",email"); //As senhas dos usuários cadastrados na aplicação, estão sendo armazenadas em texto plano
  	PreparedStatement statement = conn.prepareStatement(sql); 
		statement.setString(1, username);
 		statement.setString(2, password);
    statement.setString(3, email);
 		statement.executeUpdate();
 	}

  public User getUser(String username, String password) {
 		String sql = "SELECT * FROM Users WHERE username=? AND password=" + password;  
 		 //Sql injection na linha 34, onde concatenam-se os valores de e-mail e senha vindas do objeto usuario
try {
 		Statement statement = conn.createStatement();
 		ResultSet result = statement.executeQuery(sql);
		 
 		int count = 0;
		 
 		while (result.next()){
 		    String name = result.getString(2); 
 		    String pass = result.getString(3);
 		    String fullname = result.getString("fullname");
 		    String email = result.getString("email");
		 
 		    String output = "User #%d: %s - %s - %s - %s";
 		    System.out.println(String.format(output, ++count, name, pass, fullname, email));
 		}
}catch(Exception e) {
 		e.printStackTrace();
 	}
}

