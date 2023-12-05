import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class clAnalysis {
	public String id="";
	public String date="";
	public String category="";
	public String text="";
	public String createdon="";
	public String updatedon="";
	
	
	
	public static String dbName="capitaland";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		clAnalysis.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		clAnalysis.dbpassword = dbpassword;
	}


	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		clAnalysis.dbName = dbName;
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
  
  /*
  public boolean dbLoadData() {
	boolean rslt=true;
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    String sStmt="";
    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
    PreparedStatement preparedStmt = null;
    try {
     if (getNumber().length()>8) {
      String sSelect = "Select `number` from `cl_sc_task` where `number`=\"" + getNumber() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {    	  
    	  sQuery = "UPDATE `cl_sc_task` SET `dbUpdatedOn`=?,`correlation_id`=?,`priority`=?,`state`=?,`sys_created_on`=?,`closed_at`=?,`sys_updated_on`=?,`due_date`=?,`work_start`=?,`work_end`=?,`calendar_duration`=?,`request.number`=?,`request.opened_by`=?,`assignment_group`=?,`assigned_to`=?,`request_item.sla_due`=?,`sys_class_name`=?,`sys_created_by`=?,`sys_updated_by`=?,"
    	  		+ "`closed_by`=?,`short_description`=?,`description`=? "
          		+ " WHERE `number`=?";
          preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
          preparedStmt.setTimestamp(1,updatedAt);
          preparedStmt.setString(2,getCorrelation_id());
          preparedStmt.setString(3,getPriority());
          preparedStmt.setString(4,getState());
          preparedStmt.setString(5,setSalesForceDateTimeFormat(getSys_created_on()));
          preparedStmt.setString(6,setSalesForceDateTimeFormat(getClosed_at()));
          preparedStmt.setString(7,setSalesForceDateTimeFormat(getSys_updated_on()));
          preparedStmt.setString(8,setSalesForceDateTimeFormat(getDue_date()));
          preparedStmt.setString(9,setSalesForceDateTimeFormat(getWork_start()));
          preparedStmt.setString(10,setSalesForceDateTimeFormat(getWork_end()));
          preparedStmt.setInt(11,getIntValue(getCalendar_duration()));
          preparedStmt.setString(12,getRequest_number());
          preparedStmt.setString(13,getRequest_opened_by());
          preparedStmt.setString(14,getAssignment_group());
          preparedStmt.setString(15,getAssigned_to());
          preparedStmt.setString(16,getRequest_item_sla_due());
          preparedStmt.setString(17,getSys_class_name());
          preparedStmt.setString(18,getSys_created_by());
          preparedStmt.setString(19,getSys_updated_by());
          preparedStmt.setString(20,getClosed_by());
          preparedStmt.setString(21,getShort_description());
          preparedStmt.setString(22,getDescription());
          preparedStmt.setString(23,getNumber());
          sStmt= preparedStmt.toString();
          preparedStmt.execute();
          preparedStmt.executeUpdate();
          preparedStmt.close();     
        
      } else {
        sQuery = "INSERT INTO `cl_sc_task`(`number`, `correlation_id`, `priority`, `state`, `sys_created_on`, `closed_at`, `sys_updated_on`, `due_date`, `work_start`, `work_end`, `calendar_duration`, `request.number`, `request.opened_by`, `assignment_group`, `assigned_to`, "
        		+ "`request_item.sla_due`, `sys_class_name`, `sys_created_by`, `sys_updated_by`, `closed_by`, `short_description`, `description`, `dbCreatedOn`, `dbUpdatedOn`) "
        		+ " VALUES "
        		+ "(?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"     	
        		+ "?,?,?,?"
        		+ ")";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        
        preparedStmt.setString(1,getNumber());
        preparedStmt.setString(2,getCorrelation_id());
        preparedStmt.setString(3,getPriority());
        preparedStmt.setString(4,getState());
        preparedStmt.setString(5,setSalesForceDateTimeFormat(getSys_created_on()));
        preparedStmt.setString(6,setSalesForceDateTimeFormat(getClosed_at()));
        preparedStmt.setString(7,setSalesForceDateTimeFormat(getSys_updated_on()));
        preparedStmt.setString(8,setSalesForceDateTimeFormat(getDue_date()));
        preparedStmt.setString(9,setSalesForceDateTimeFormat(getWork_start()));
        preparedStmt.setString(10,setSalesForceDateTimeFormat(getWork_end()));
        preparedStmt.setInt(11,getIntValue(getCalendar_duration()));
        preparedStmt.setString(12,getRequest_number());
        preparedStmt.setString(13,getRequest_opened_by());
        preparedStmt.setString(14,getAssignment_group());
        preparedStmt.setString(15,getAssigned_to());
        preparedStmt.setString(16,getRequest_item_sla_due());
        preparedStmt.setString(17,getSys_class_name());
        preparedStmt.setString(18,getSys_created_by());
        preparedStmt.setString(19,getSys_updated_by());
        preparedStmt.setString(20,getClosed_by());
        preparedStmt.setString(21,getShort_description());
        preparedStmt.setString(22,getDescription());
        preparedStmt.setTimestamp(23,updatedAt);
        preparedStmt.setTimestamp(24,updatedAt);
        
        
        
        sStmt= preparedStmt.toString();
        preparedStmt.executeUpdate();
        preparedStmt.close();        
      } 
      rs.close();
      st.close();
      conn.close();
     }
    } catch (Exception e) {
    	rslt=false;
      System.out.println("ERROR: dbLoadData:" + sQuery);
      System.out.println("ERROR: dbLoadData:" + e.getMessage());
      System.out.println("ERROR: dbLoadData: SQL: " + sStmt);
      setShort_description("");      
      setDescription("");
      
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
  */
  
  
  
  public boolean dbLoadData() {
		boolean rslt=true;
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select `id` from `analysis` where `date`=\"" + getDate() + "\" and `category`=\""+getCategory()+"\" ";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      if (rs.next()) {    	  
	    	  sQuery = "UPDATE `analysis` SET `updatedon`=?, `category`=?,`text`=? "
	          		+ " WHERE `id`=?";
	          preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
	          preparedStmt.setTimestamp(1,updatedAt);
	          preparedStmt.setString(2,getCategory());
	          preparedStmt.setString(3,getText());
	          preparedStmt.setInt(4,rs.getInt("id"));
	          sStmt= preparedStmt.toString();
	          preparedStmt.execute();
	          preparedStmt.executeUpdate();
	          preparedStmt.close();     
	        
	      } else {
	        sQuery = "INSERT INTO `analysis`(`date`, `category`, `text`, `createdon`, `updatedon`)	"        		
	        		+ " VALUES ( "	
	        		+ "?,?,?,?,?"
	        		+ ")";
	        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
	        preparedStmt.setString(1,getDate());
	        preparedStmt.setString(2,getCategory());
	        preparedStmt.setString(3,getText());
	          
	      
	        
	        preparedStmt.setTimestamp(4,updatedAt);
	        preparedStmt.setTimestamp(5,updatedAt);
	        
	        
	        
	        sStmt= preparedStmt.toString();
	        preparedStmt.executeUpdate();
	        preparedStmt.close();        
	      } 
	      rs.close();
	      st.close();
	      conn.close();
	    
	    } catch (Exception e) {
	    	rslt=false;
	      System.out.println("ERROR: dbLoadData:" + sQuery);
	      System.out.println("ERROR: dbLoadData:" + e.getMessage());
	      System.out.println("ERROR: dbLoadData: SQL: " + sStmt);
	     
	      
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
  
  public String getText(String sDate, String sCategory) {
		String rslt="";
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	   
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select `text` from `analysis` where `category`=\"" + sCategory + "\" and `date` = \""+sDate+"\" order by id desc";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      if (rs.next()) {    	  
	    	
	        rslt= rs.getString(1);
	      } else {
	        
	      } 
	      rs.close();
	      st.close();
	      conn.close();
	    
	    } catch (Exception e) {
	    	rslt="";
	      System.out.println("ERROR: getTemplate:" + sQuery);
	      System.out.println("ERROR: getTemplate:" + e.getMessage());
	      System.out.println("ERROR: getTemplate: SQL: " + sStmt);
	     
	      
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
