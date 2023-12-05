import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class MysqlCon {
  public static void main(String[] args) {
    try {
      Class.forName("java.sql.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mysql://dutabot.com:3306/c1ppms", "c0ppms", "!12qwasZX");
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from employee");
      while (rs.next())
        System.out.println(String.valueOf(rs.getInt(1)) + "  " + rs.getString(2) + "  " + rs.getString(3)); 
      con.close();
    } catch (Exception e) {
      System.out.println(e);
    } 
  }
}
