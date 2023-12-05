import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class rpaTicket {
	
	
	public static String dbName="capitaland";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";
	  
	 public  ArrayList<String> list = new ArrayList<String>();
	 private DatabaseManager db = null;
	 private   Connection conn = null;
	 
	 
	 public rpaTicket(String tmpDBName) {
		 dbName=tmpDBName;
		  db = new DatabaseManager(dbusername, dbpassword, dbName);
		     conn = (Connection)db.getConnection();
	 }

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		rpaTicket.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		rpaTicket.dbpassword = dbpassword;
	}


  
	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		rpaTicket.dbName = dbName;
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
  public rpaTicket() {
	  db = new DatabaseManager(dbusername, dbpassword, dbName);
	     conn = (Connection)db.getConnection();
  }
  
  public void close() {
	    try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  private String printIDString(String sTemp) {
	  String rslt="";
	  if (sTemp==null) {
		  
	  } else {
		  rslt="-"+sTemp;
	  }
	  
	  return rslt;
	  
  }
  public boolean Load() {
	boolean rslt=true;
   
    String sQuery = "";
    String sStmt="";
    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
    PreparedStatement preparedStmt = null;
   
 
    
    String sID=list.get(0);
    
    sID=sID.replaceAll("['\"\\\\]", "");
    
    try {
    	
    	if (conn==null) {
    		conn = (Connection)db.getConnection();
    	}
    	if (conn.isClosed()) {
    		conn = (Connection)db.getConnection();
    	}
    	
    	  String sSelect = "Select `number` from `rpaTicket` where `number`='" + sID+ "'";
          Statement st = (Statement)conn.createStatement();
          ResultSet rs = (ResultSet)st.executeQuery(sSelect);
          if (rs.next()) {    	  
        	          	  
        	  sQuery = "UPDATE `capitaland`.`rpaTicket` SET "
		        		+ "`dbUpdatedOn`=?, "	        				        		
						+ "`cl_number`=?, "
						+ "`cl_task_number`=?, "
						+ "`cl_requestor`=?, "
						+ "`cl_assigneegroup`=?, "
						+ "`cl_assginedto`=?, "
						+ "`cl_status`=?, "
						+ "`cl_statusint`=?, "
						+ "`cl_lastupdate`=?, "
						+ "`cl_laststatechange`=?, "
						+ "`cl_history`=? "		
						
		        		+ " WHERE `number`=? ";
		        		
		        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
		        
		       
		        for (int i=1; i<12; i++) {
		        	String sValue = list.get(i-1);
		        	switch (i) {
		        	case 1:
		        		preparedStmt.setTimestamp(i,updatedAt);
		        		break;
		        	case 8 : //Int
		        		preparedStmt.setInt(i,getIntValue(sValue));//Int
		        		break;				        			
		        	
		        	
		        	
		        	default: 
		        		preparedStmt.setString(i,sValue);
		        		break;
		        	}
		        	
		        }
		        
		       
		     
		        
		       
		        preparedStmt.setString(12,sID);
		        
		        
		        
		        sStmt= preparedStmt.toString();
		        preparedStmt.executeUpdate();
		        preparedStmt.close();        
		        
          } else {
     
				        sQuery = "INSERT INTO `capitaland`.`rpaTicket` "
								+"(`number`, "
								+ "`cl_number`, "
								+ "`cl_task_number`, "
								+ "`cl_requestor`, "
								+ "`cl_assigneegroup`, "
								+ "`cl_assginedto`, "
								+ "`cl_status`, "
								+ "`cl_statusint`, "
								+ "`cl_lastupdate`, "
								+ "`cl_laststatechange`, "
								+ "`cl_history`, "
								+ "`dbCreatedOn`, "
								+ "`dbUpdatedOn`)"
				        		+ "VALUES"
				        		+ "(?,?,?,?,?,?,?,?,?,?,"				        						        		     	
				        		+ "?,?,?"
				        		+ ")";
				        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
				        
				        for (int i=1; i<12; i++) {
				        	String sValue = list.get(i-1);
				        	switch (i) {
				        	case 8: //Int
				        		preparedStmt.setInt(i,getIntValue(sValue));//Int
				        		break;				        			
				        	
				       
				        	
				        	
				        	default: 
				        		preparedStmt.setString(i,sValue);
				        		break;
				        	}
				        	
				        }
				        
				       
				        preparedStmt.setTimestamp(12,updatedAt);
				        preparedStmt.setTimestamp(13,updatedAt);
				        
				        
				        
				        sStmt= preparedStmt.toString();
				        preparedStmt.executeUpdate();
				        preparedStmt.close();        
				        //System.out.println("INSERT Record for ID= "+sID);
      
          }
  
     st.close();
     rs.close();
      list.clear();
   
    } catch (Exception e) {
    	rslt=false;
      System.out.println("ERROR: Load:" + sStmt);
      System.out.println("ERROR: Load:" + e.getMessage());
      System.out.println("ERROR: Load: SQL: " + sStmt);
      
      
 
      
    } finally {
    	
    }
    
    return rslt;
  }
  
}
