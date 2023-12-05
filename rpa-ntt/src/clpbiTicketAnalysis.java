import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class clpbiTicketAnalysis {
	
	public String sys_create_on="";
	public String ticketcreated;
	public String ticketcreatednonalert;
	public String ticketwipnonalert;
	public String ticketclosednonalert;
	public String ticketcancellednonalert="";
	public String ticketp1nonalert="";
	public String ticketp2nonalert="";
	public String ticketp3nonalert="";
	public String ticketp1wipnonalert="";
	public String ticketp1closednonalert="";
	public String ticketp1cancellednonalert="";
	public String ticketp2wipnonalert="";
	public String ticketp2closednonalert="";
	public String ticketp2cancellednonalert="";
	public String ticketp3wipnonalert="";
	public String ticketp3closednonalert="";
	public String ticketp3cancellednonalert="";
	public String closedticketp1nonalert="";
	public String closedticketp2nonalert="";
	public String losedticketp3nonalert="";
	public String FCRPW="";
	public String FCRPWBase="";
	public String FCROthers="";
	public String FCROthersBase="";
	
	
	
	public static String dbName="capitaland";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";




	public String getSys_create_on() {
		return sys_create_on;
	}

	public void setSys_create_on(String sys_create_on) {
		this.sys_create_on = sys_create_on;
	}

	public String getTicketcreated() {
		return ticketcreated;
	}

	public void setTicketcreated(String ticketcreated) {
		this.ticketcreated = ticketcreated;
	}

	public String getTicketcreatednonalert() {
		return ticketcreatednonalert;
	}

	public void setTicketcreatednonalert(String ticketcreatednonalert) {
		this.ticketcreatednonalert = ticketcreatednonalert;
	}

	public String getTicketwipnonalert() {
		return ticketwipnonalert;
	}

	public void setTicketwipnonalert(String ticketwipnonalert) {
		this.ticketwipnonalert = ticketwipnonalert;
	}

	public String getTicketclosednonalert() {
		return ticketclosednonalert;
	}

	public void setTicketclosednonalert(String ticketclosednonalert) {
		this.ticketclosednonalert = ticketclosednonalert;
	}

	public String getTicketcancellednonalert() {
		return ticketcancellednonalert;
	}

	public void setTicketcancellednonalert(String ticketcancellednonalert) {
		this.ticketcancellednonalert = ticketcancellednonalert;
	}

	public String getTicketp1nonalert() {
		return ticketp1nonalert;
	}
	
	

	public String getTicketp2nonalert() {
		return ticketp2nonalert;
	}

	public void setTicketp2nonalert(String ticketp2nonalert) {
		this.ticketp2nonalert = ticketp2nonalert;
	}

	public String getTicketp3nonalert() {
		return ticketp3nonalert;
	}

	public void setTicketp3nonalert(String ticketp3nonalert) {
		this.ticketp3nonalert = ticketp3nonalert;
	}

	public void setTicketp1nonalert(String ticketp1nonalert) {
		this.ticketp1nonalert = ticketp1nonalert;
	}

	public String getTicketp1wipnonalert() {
		return ticketp1wipnonalert;
	}

	public void setTicketp1wipnonalert(String ticketp1wipnonalert) {
		this.ticketp1wipnonalert = ticketp1wipnonalert;
	}

	public String getTicketp1closednonalert() {
		return ticketp1closednonalert;
	}

	public void setTicketp1closednonalert(String ticketp1closednonalert) {
		this.ticketp1closednonalert = ticketp1closednonalert;
	}

	public String getTicketp1cancellednonalert() {
		return ticketp1cancellednonalert;
	}

	public void setTicketp1cancellednonalert(String ticketp1cancellednonalert) {
		this.ticketp1cancellednonalert = ticketp1cancellednonalert;
	}

	public String getTicketp2wipnonalert() {
		return ticketp2wipnonalert;
	}

	public void setTicketp2wipnonalert(String ticketp2wipnonalert) {
		this.ticketp2wipnonalert = ticketp2wipnonalert;
	}

	public String getTicketp2closednonalert() {
		return ticketp2closednonalert;
	}

	public void setTicketp2closednonalert(String ticketp2closednonalert) {
		this.ticketp2closednonalert = ticketp2closednonalert;
	}

	public String getTicketp2cancellednonalert() {
		return ticketp2cancellednonalert;
	}

	public void setTicketp2cancellednonalert(String ticketp2cancellednonalert) {
		this.ticketp2cancellednonalert = ticketp2cancellednonalert;
	}

	public String getTicketp3wipnonalert() {
		return ticketp3wipnonalert;
	}

	public void setTicketp3wipnonalert(String ticketp3wipnonalert) {
		this.ticketp3wipnonalert = ticketp3wipnonalert;
	}

	public String getTicketp3closednonalert() {
		return ticketp3closednonalert;
	}

	public void setTicketp3closednonalert(String ticketp3closednonalert) {
		this.ticketp3closednonalert = ticketp3closednonalert;
	}

	public String getTicketp3cancellednonalert() {
		return ticketp3cancellednonalert;
	}

	public void setTicketp3cancellednonalert(String ticketp3cancellednonalert) {
		this.ticketp3cancellednonalert = ticketp3cancellednonalert;
	}

	public String getClosedticketp1nonalert() {
		return closedticketp1nonalert;
	}

	public void setClosedticketp1nonalert(String closedticketp1nonalert) {
		this.closedticketp1nonalert = closedticketp1nonalert;
	}

	public String getClosedticketp2nonalert() {
		return closedticketp2nonalert;
	}

	public void setClosedticketp2nonalert(String closedticketp2nonalert) {
		this.closedticketp2nonalert = closedticketp2nonalert;
	}

	public String getLosedticketp3nonalert() {
		return losedticketp3nonalert;
	}

	public void setLosedticketp3nonalert(String losedticketp3nonalert) {
		this.losedticketp3nonalert = losedticketp3nonalert;
	}

	public String getFCRPW() {
		return FCRPW;
	}

	public void setFCRPW(String fCRPW) {
		FCRPW = fCRPW;
	}

	public String getFCRPWBase() {
		return FCRPWBase;
	}

	public void setFCRPWBase(String fCRPWBase) {
		FCRPWBase = fCRPWBase;
	}

	public String getFCROthers() {
		return FCROthers;
	}

	public void setFCROthers(String fCROthers) {
		FCROthers = fCROthers;
	}

	public String getFCROthersBase() {
		return FCROthersBase;
	}

	public void setFCROthersBase(String fCROthersBase) {
		FCROthersBase = fCROthersBase;
	}

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		clpbiTicketAnalysis.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		clpbiTicketAnalysis.dbpassword = dbpassword;
	}


	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		clpbiTicketAnalysis.dbName = dbName;
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
  
  
  public boolean getData(String sDate) {
		boolean rslt=false;
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	   
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select * from `pbiTicketAnalysis` where `sys_create_on`=\"" + sDate + "\"";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      if (rs.next()) {    	  
	    	  this.setSys_create_on(rs.getString("sys_create_on"));
	    	  this.setTicketcreated(rs.getString("ticketcreated"));
	    	  this.setTicketcreatednonalert(rs.getString("ticketcreatednonalert"));
	    	  this.setTicketwipnonalert(rs.getString("ticketwipnonalert"));
	    	  this.setTicketclosednonalert(rs.getString("ticketclosednonalert"));
	    	  this.setTicketcancellednonalert(rs.getString("ticketcancellednonalert"));
	    	  this.setTicketp1nonalert(rs.getString("ticketp1nonalert"));
	    	  this.setTicketp2nonalert(rs.getString("ticketp2nonalert"));
	    	  this.setTicketp3nonalert(rs.getString("ticketp3nonalert"));
	    	  this.setTicketp1wipnonalert(rs.getString("ticketp1wipnonalert"));
	    	  this.setTicketp1closednonalert(rs.getString("ticketp1closednonalert"));
	    	  this.setTicketp1cancellednonalert(rs.getString("ticketp1cancellednonalert"));
	    	  this.setTicketp2wipnonalert(rs.getString("ticketp2wipnonalert"));
	    	  this.setTicketp2closednonalert(rs.getString("ticketp2closednonalert"));
	    	  this.setTicketp2cancellednonalert(rs.getString("ticketp2cancellednonalert"));
	    	  this.setTicketp3wipnonalert(rs.getString("ticketp3wipnonalert"));
	    	  this.setTicketp3closednonalert(rs.getString("ticketp3closednonalert"));
	    	  this.setTicketp3cancellednonalert(rs.getString("ticketp3cancellednonalert"));
	    	  this.setClosedticketp1nonalert(rs.getString("closedticketp1nonalert"));
	    	  this.setClosedticketp2nonalert(rs.getString("closedticketp2nonalert"));
	    	  this.setLosedticketp3nonalert(rs.getString("closedticketp3nonalert"));
	    	  this.setFCRPW(rs.getString("FCRPW"));
	    	  this.setFCRPWBase(rs.getString("FCRPWBase"));
	    	  this.setFCROthers(rs.getString("FCROthers"));
	    	  this.setFCROthersBase(rs.getString("FCROthersBase"));
	        rslt=true;
	      } else {
	        
	      } 
	      rs.close();
	      st.close();
	      conn.close();
	      
	    } catch (Exception e) {
	    	rslt=false;
	      System.out.println("ERROR: getData:" + sQuery);
	      System.out.println("ERROR: getData:" + e.getMessage());
	      System.out.println("ERROR: getData: SQL: " + sStmt);
	     
	      
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
