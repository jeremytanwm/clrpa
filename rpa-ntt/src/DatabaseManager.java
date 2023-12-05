import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
  private Connection connection;
  
  private Statement statement;
  
  private String gUrl="";
  private String gUsername="";
  private String gPassword="";
  
  public Connection getConnection() {
	  if (this.connection==null) {
		  try {
			this.connection= DriverManager.getConnection(gUrl, gUsername, gPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  } else {
		  try {
			if (this.connection.isClosed()) {
				  this.connection=null;
				  try {
						this.connection= DriverManager.getConnection(gUrl, gUsername, gPassword);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
    return this.connection;
  }
  
  public void setConnection(Connection connection) {
    this.connection = connection;
  }
  
  public Statement getStatement() {
    return this.statement;
  }
  
  public void setStatement(Statement statement) {
    this.statement = statement;
  }
  
  public DatabaseManager(String username, String password, String sDatabase) {
    //String url = "jdbc:mysql://dutabot.com:3306/"+sDatabase+"?autoReconnect=true";
	  
   // String url = "jdbc:mysql://dutabot.com:3306/"+sDatabase+"?useUnicode=yes&characterEncoding=UTF-8";
	  String url = "jdbc:mariadb://4.194.63.192:3306/"+sDatabase+"?useUnicode=yes&characterEncoding=UTF-8";
    gUrl=url;
	  gUsername=username;
	  gPassword=password;
    try {
      //Class.forName("java.sql.Driver");
    	Class.forName("org.mariadb.jdbc.Driver");
    } catch (Exception e) {
      System.out.println("Failed to load JDBC/ODBC driver.");
      return;
    } 
    try {
      this.connection = DriverManager.getConnection(url, username, password);
      this.statement = this.connection.createStatement();
    } catch (SQLException exception) {
      System.out.println("\n*** SQLException caught ***\n");
      while (exception != null) {
        System.out.println("SQLState:   " + exception.getSQLState());
        System.out.println("Message:    " + exception.getMessage());
        System.out.println("Error code: " + exception.getErrorCode());
        exception = exception.getNextException();
        System.out.println("");
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Rpa\rpappms\!\DatabaseManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */