import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExecuteSearch {
   
  private static String dbUrl = "jdbc:mysql://localhost:3306/usersdb"; 
  private static String username = "admin";  
  private static String password = "root";
  
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
        + "VALUES (?,?," + fullname +",email");
    PreparedStatement statement = conn.prepareStatement(sql); 
    statement.setString(1, username);
    statement.setString(2, password);//password sendo tratada como string comum será salva em texto plano no banco de dados vide linha 24
    statement.setString(3, email);
    statement.executeUpdate();
  }

  public User getUser(String username, String password) {
    String sql = "SELECT * FROM Users WHERE username=? AND password=" + password;  //possivel sql injection
     
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
