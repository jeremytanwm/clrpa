import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class clTicket3P {
	
	public String id ="";
	public String number ="";
	public String tpnumber ="";
	public String tpvendorname ="";
	public String status ="";
	public String last_user ="";
	public String last_remarks ="";
	public String last_query ="";
	public String last_update ="";
	public String dbCreatedOn ="";
	public String dbUpdatedOn ="";
	public boolean isInserted= false;
	
	public static String dbName="capitaland";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";


	  
	  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTpnumber() {
		return tpnumber;
	}
	public void setTpnumber(String tpnumber) {
		this.tpnumber = tpnumber;
	}
	public String getTpvendorname() {
		return tpvendorname;
	}
	public void setTpvendorname(String tpvendorname) {
		this.tpvendorname = tpvendorname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLast_user() {
		return last_user;
	}
	public void setLast_user(String last_user) {
		this.last_user = last_user;
	}
	public String getLast_remarks() {
		return last_remarks;
	}
	public void setLast_remarks(String last_remarks) {
		this.last_remarks = last_remarks;
	}
	public String getLast_query() {
		return last_query;
	}
	public void setLast_query(String last_query) {
		this.last_query = last_query;
	}
	public String getLast_update() {
		return last_update;
	}
	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	public String getDbCreatedOn() {
		return dbCreatedOn;
	}
	public void setDbCreatedOn(String dbCreatedOn) {
		this.dbCreatedOn = dbCreatedOn;
	}
	public String getDbUpdatedOn() {
		return dbUpdatedOn;
	}
	public void setDbUpdatedOn(String dbUpdatedOn) {
		this.dbUpdatedOn = dbUpdatedOn;
	}
	public clTicket3P(String tmpDBName) {
		  dbName=tmpDBName;
		  
	  }
	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		clTicket3P.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		clTicket3P.dbpassword = dbpassword;
	}


  


	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		clTicket3P.dbName = dbName;
	}

public int getIntValue(String str) {
    int irslt = 0;
    try {
      if (str.isEmpty())
        str = "0"; 
      irslt = Integer.parseInt(str);
    } catch (Exception e) {
      irslt = 0;
    } 
    return irslt;
  }
  
  public Float getFloatValue(String str) {
    Float frslt = null;
    try {
      if (str.isEmpty())
        str = "0"; 
      frslt = Float.valueOf(str);
    } catch (Exception e) {
      frslt = Float.valueOf("0");
    } 
    return frslt;
  }
  
  private String setSalesForceTimeFormat(String sTime) {
	  if (sTime!=null) {
		  if (sTime.equals("")) {
			  sTime="00:00:00";
		  }
	  } else sTime="00:00:00";
	  return sTime;
  }
  
  
  
  
  private String setSalesForceDateTimeFormat(String sDateTime) {
    String temp = null;
    String sDate="";
    String sTime="00:00:00";
    try {
    	
    	sDateTime=sDateTime.trim();
    	
    String[] sD= sDateTime.split(" ");
    if (sD!=null) {
    	if (sD.length==2) {
    		sDate=sD[0];
    		sTime=sD[1];
    	}
    }
    	
      sDate = sDate.trim();
    } catch (Exception e) {
      sDate = "";
    } 
    if (sDate.equals("")) {
      temp = "0000-00-00";
    } else {
      try {
        String[] s = sDate.split("-");
        
        if (s!=null) {
        	temp = "0000-00-00";
        	if (s.length>2) {
			        String sMonth = s[1];
			        if (sMonth!=null) {
			        	switch (sMonth) {
			        	case "Jan" : sMonth="01"; break;
			        	case "Feb" : sMonth="02"; break;
			        	case "Mar" : sMonth="03"; break;
			        	case "Apr" : sMonth="04"; break;
			        	case "May" : sMonth="05"; break;
			        	case "Jun" : sMonth="06"; break;
			        	case "Jul" : sMonth="07"; break;
			        	case "Aug" : sMonth="08"; break;
			        	case "Sep" : sMonth="09"; break;
			        	case "Oct" : sMonth="10"; break;
			        	case "Nov" : sMonth="11"; break;
			        	case "Dec" : sMonth="12"; break;    	
			        	
			        	}
			        }
			        
			        
			        
			        String sDay = s[0];
			        if (sDay.length() == 1)
			          sDay = "0" + sDay; 
			      
			       
			          temp = String.valueOf(s[2]) + "-" + sMonth + "-" + sDay;
        	}
        }
      
      } catch (Exception e) {
    	  temp = "0000-00-00";
      } 
    } 
    if (temp == null)
    	 temp = "0000-00-00";
    if (temp.equals(""))
    	 temp = "0000-00-00"; 
    if (temp.isEmpty())
    	 temp = "0000-00-00";
    return temp+" "+sTime;
  }
  
  public boolean dbLoad() {
	boolean rslt=true;
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    String sStmt="";
    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
    PreparedStatement preparedStmt = null;
    try {
     if (getTpnumber().length()>5) {
      String sSelect = "Select `id` from `ticket_3p` where `tpnumber`=\"" + getTpnumber() + "\" AND `last_update`=\""+getLast_update()+"\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {    	  
    	  sQuery = "UPDATE `ticket_3p` SET `last_query`=?, `dbUpdatedOn`=? "    	  		
          		+ " WHERE `id`=?";
          preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
          preparedStmt.setTimestamp(1,updatedAt);
          preparedStmt.setTimestamp(2,updatedAt);  
          preparedStmt.setInt(3,rs.getInt(1));           
          sStmt= preparedStmt.toString();
          preparedStmt.execute();
          preparedStmt.executeUpdate();
          preparedStmt.close();     
          isInserted=false;
      } else {
        sQuery = "INSERT INTO `ticket_3p`(`number`, `tpnumber`, `tpvendorname`, `status`, `last_user`, "
        		+ "`last_remarks`, `last_query`, `last_update`) VALUES"
        		+ "(?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);        
        preparedStmt.setString(1,getNumber());
        preparedStmt.setString(2,getTpnumber());
        preparedStmt.setString(3,getTpvendorname());
        preparedStmt.setString(4,getStatus());
        preparedStmt.setString(5,getLast_user());
        preparedStmt.setString(6,getLast_remarks());
        preparedStmt.setTimestamp(7,updatedAt);
        preparedStmt.setString(8,getLast_update());
        sStmt= preparedStmt.toString();
        preparedStmt.executeUpdate();
        preparedStmt.close();      
        isInserted=true;
      } 
      rs.close();
      st.close();
      conn.close();
     }
    } catch (Exception e) {
    	rslt=false;
      System.out.println("ERROR: dbLoad:" + sQuery);
      System.out.println("ERROR: dbLoad:" + e.getMessage());
      System.out.println("ERROR: dbLoad: SQL: " + sStmt);
      
      
      try {
		conn.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      
      
    } finally {
    	try {
    		if (!conn.isClosed()) {
    			System.out.println("closing connection");
    			conn.close();
    			System.out.println("connection closed");
    		}
    		
    	 } catch (Exception e) {
    		 
    	 }
    }
    
    return rslt;
  }
  
  public static void dbCleanUp() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    try {
      Statement st = (Statement)conn.createStatement();
      String sUpdate = "";
      sUpdate = "UPDATE contract inner join projecthealth on contract.idcontract=projecthealth.idcontract SET contract.idproject = projecthealth.idproject";
      System.out.println(sUpdate);
      st.execute(sUpdate);
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }
}
