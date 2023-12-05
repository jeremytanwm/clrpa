import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class clScTask {
	public String number="";
	public String correlation_id="";
	public String priority="";
	public String state="";
	public String sys_created_on="";
	public String closed_at="";
	public String sys_updated_on="";
	public String due_date="";
	public String work_start="";
	public String work_end="";
	public String calendar_duration="";
	public String request_number="";
	public String request_opened_by="";
	public String assignment_group="";
	public String assigned_to="";
	public String request_item_sla_due="";
	public String sys_class_name="";
	public String sys_created_by="";
	public String sys_updated_by="";
	public String closed_by="";
	public String short_description="";
	public String description="";
	public String dbCreatedOn="";
	public String dbUpdatedOn="";
	
	
	public static String dbName="capitaland";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";

	  public clScTask(String tmpDBName) {
		  dbName=tmpDBName;
	  }

	public String getRequest_number() {
		return request_number;
	}

	public void setRequest_number(String request_number) {
		this.request_number = request_number;
	}

	public String getRequest_opened_by() {
		return request_opened_by;
	}

	public void setRequest_opened_by(String request_opened_by) {
		this.request_opened_by = request_opened_by;
	}

	public String getRequest_item_sla_due() {
		return request_item_sla_due;
	}

	public void setRequest_item_sla_due(String request_item_sla_due) {
		this.request_item_sla_due = request_item_sla_due;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCorrelation_id() {
		return correlation_id;
	}

	public void setCorrelation_id(String correlation_id) {
		this.correlation_id = correlation_id;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSys_created_on() {
		return sys_created_on;
	}

	public void setSys_created_on(String sys_created_on) {
		this.sys_created_on = sys_created_on;
	}

	public String getClosed_at() {
		return closed_at;
	}

	public void setClosed_at(String closed_at) {
		this.closed_at = closed_at;
	}

	public String getSys_updated_on() {
		return sys_updated_on;
	}

	public void setSys_updated_on(String sys_updated_on) {
		this.sys_updated_on = sys_updated_on;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getWork_start() {
		return work_start;
	}

	public void setWork_start(String work_start) {
		this.work_start = work_start;
	}

	public String getWork_end() {
		return work_end;
	}

	public void setWork_end(String work_end) {
		this.work_end = work_end;
	}

	public String getCalendar_duration() {
		return calendar_duration;
	}

	public void setCalendar_duration(String calendar_duration) {
		this.calendar_duration = calendar_duration;
	}


	public String getAssignment_group() {
		return assignment_group;
	}

	public void setAssignment_group(String assignment_group) {
		this.assignment_group = assignment_group;
	}

	public String getAssigned_to() {
		return assigned_to;
	}

	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}


	public String getSys_class_name() {
		return sys_class_name;
	}

	public void setSys_class_name(String sys_class_name) {
		this.sys_class_name = sys_class_name;
	}

	public String getSys_created_by() {
		return sys_created_by;
	}

	public void setSys_created_by(String sys_created_by) {
		this.sys_created_by = sys_created_by;
	}

	public String getSys_updated_by() {
		return sys_updated_by;
	}

	public void setSys_updated_by(String sys_updated_by) {
		this.sys_updated_by = sys_updated_by;
	}

	public String getClosed_by() {
		return closed_by;
	}

	public void setClosed_by(String closed_by) {
		this.closed_by = closed_by;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		clScTask.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		clScTask.dbpassword = dbpassword;
	}


	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		clScTask.dbName = dbName;
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
