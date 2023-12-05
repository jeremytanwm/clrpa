import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class clChangeTask {
	public String number="";
	public String change_request="";
	public String correlation_id="";
	public String active="";
	public String activity_due="";
	public String additional_assignee_list="";
	public String approval="";
	public String approval_history="";
	public String approval_set="";
	public String assigned_to="";
	public String assignment_group="";
	public String business_duration="";
	public String work_start="";
	public String work_end="";
	public String sys_created_on="";
	public String closed_at="";
	public String sys_updated_on="";
	public String sys_created_by="";
	public String priority="";
	public String change_request_start_date="";
	public String change_request_end_date="";
	public String change_request_priority="";
	public String change_request_requested_by_date="";
	public String change_request_u_request_by_end_date="";
	public String change_request_risk="";
	public String change_request_state="";
	public String dbCreatedOn="";
	public String dbUpdatedOn="";

	
	
	public static String dbName="capitaland";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";



	

public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getChange_request() {
		return change_request;
	}

	public void setChange_request(String change_request) {
		this.change_request = change_request;
	}

	public String getCorrelation_id() {
		return correlation_id;
	}

	public void setCorrelation_id(String correlation_id) {
		this.correlation_id = correlation_id;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getActivity_due() {
		return activity_due;
	}

	public void setActivity_due(String activity_due) {
		this.activity_due = activity_due;
	}

	public String getAdditional_assignee_list() {
		return additional_assignee_list;
	}

	public void setAdditional_assignee_list(String additional_assignee_list) {
		this.additional_assignee_list = additional_assignee_list;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getApproval_history() {
		return approval_history;
	}

	public void setApproval_history(String approval_history) {
		this.approval_history = approval_history;
	}

	public String getApproval_set() {
		return approval_set;
	}

	public void setApproval_set(String approval_set) {
		this.approval_set = approval_set;
	}

	public String getAssigned_to() {
		return assigned_to;
	}

	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}

	public String getAssignment_group() {
		return assignment_group;
	}

	public void setAssignment_group(String assignment_group) {
		this.assignment_group = assignment_group;
	}

	public String getBusiness_duration() {
		return business_duration;
	}

	public void setBusiness_duration(String business_duration) {
		this.business_duration = business_duration;
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

	public String getSys_created_by() {
		return sys_created_by;
	}

	public void setSys_created_by(String sys_created_by) {
		this.sys_created_by = sys_created_by;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getChange_request_start_date() {
		return change_request_start_date;
	}

	public void setChange_request_start_date(String change_request_start_date) {
		this.change_request_start_date = change_request_start_date;
	}

	public String getChange_request_end_date() {
		return change_request_end_date;
	}

	public void setChange_request_end_date(String change_request_end_date) {
		this.change_request_end_date = change_request_end_date;
	}

	public String getChange_request_priority() {
		return change_request_priority;
	}

	public void setChange_request_priority(String change_request_priority) {
		this.change_request_priority = change_request_priority;
	}

	public String getChange_request_requested_by_date() {
		return change_request_requested_by_date;
	}

	public void setChange_request_requested_by_date(String change_request_requested_by_date) {
		this.change_request_requested_by_date = change_request_requested_by_date;
	}

	public String getChange_request_u_request_by_end_date() {
		return change_request_u_request_by_end_date;
	}

	public void setChange_request_u_request_by_end_date(String change_request_u_request_by_end_date) {
		this.change_request_u_request_by_end_date = change_request_u_request_by_end_date;
	}

	public String getChange_request_risk() {
		return change_request_risk;
	}

	public void setChange_request_risk(String change_request_risk) {
		this.change_request_risk = change_request_risk;
	}

	public String getChange_request_state() {
		return change_request_state;
	}

	public void setChange_request_state(String change_request_state) {
		this.change_request_state = change_request_state;
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

	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		clChangeTask.dbName = dbName;
	}

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		clChangeTask.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		clChangeTask.dbpassword = dbpassword;
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
      String sSelect = "Select `number` from `cl_change_task` where `number`=\"" + getNumber() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {    	  
    	  sQuery = "UPDATE `cl_change_task` SET `dbUpdatedOn`=?,`change_request`=?,`correlation_id`=?,`active`=?,`activity_due`=?,"
    	  		+ "`additional_assignee_list`=?,`approval`=?,`approval_history`=?,`approval_set`=?,`assigned_to`=?,`assignment_group`=?,"
    	  		+ "`business_duration`=?,`work_start`=?,`work_end`=?,`sys_created_on`=?,`closed_at`=?,`sys_updated_on`=?,`sys_created_by`=?,"
    	  		+ "`priority`=?,`change_request.start_date`=?,`change_request.end_date`=?,`change_request.priority`=?,"
    	  		+ "`change_request.requested_by_date`=?,`change_request.u_request_by_end_date`=?,`change_request.risk`=?,"
    	  		+ "`change_request.state`=?  "
          		+ " WHERE `number`=?";
          preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
          
          preparedStmt.setTimestamp(1,updatedAt);
          preparedStmt.setString(2,getChange_request());
          preparedStmt.setString(3,getCorrelation_id());
          preparedStmt.setString(4,getActive());
          preparedStmt.setString(5,getActivity_due());
          preparedStmt.setString(6,getAdditional_assignee_list());
          preparedStmt.setString(7,getApproval());
          preparedStmt.setString(8,getApproval_history());
          preparedStmt.setString(9,getApproval_set());
          preparedStmt.setString(10,getAssigned_to());
          preparedStmt.setString(11,getAssignment_group());
          preparedStmt.setInt(12,getIntValue(getBusiness_duration()));
          preparedStmt.setString(13,setSalesForceDateTimeFormat(getWork_start()));
          preparedStmt.setString(14,setSalesForceDateTimeFormat(getWork_end()));
          preparedStmt.setString(15,setSalesForceDateTimeFormat(getSys_created_on()));
          preparedStmt.setString(16,setSalesForceDateTimeFormat(getClosed_at()));
          preparedStmt.setString(17,setSalesForceDateTimeFormat(getSys_updated_on()));
          preparedStmt.setString(18,getSys_created_by());
          preparedStmt.setString(19,getPriority());
          preparedStmt.setString(20,setSalesForceDateTimeFormat(getChange_request_start_date()));
          preparedStmt.setString(21,setSalesForceDateTimeFormat(getChange_request_end_date()));
          preparedStmt.setString(22,getChange_request_priority());
          preparedStmt.setString(23,setSalesForceDateTimeFormat(getChange_request_requested_by_date()));
          preparedStmt.setString(24,setSalesForceDateTimeFormat(getChange_request_u_request_by_end_date()));
          preparedStmt.setString(25,getChange_request_risk());
          preparedStmt.setString(26,getChange_request_state());
          preparedStmt.setString(27,getNumber());
          
          sStmt= preparedStmt.toString();
          preparedStmt.execute();
          preparedStmt.executeUpdate();
          preparedStmt.close();     
        
      } else {
        sQuery = "INSERT INTO `cl_change_task`(`number`, `change_request`, `correlation_id`, `active`, `activity_due`, "
        		+ "`additional_assignee_list`, `approval`, `approval_history`, `approval_set`, `assigned_to`, `assignment_group`,"
        		+ " `business_duration`, `work_start`, `work_end`, `sys_created_on`, `closed_at`, `sys_updated_on`, `sys_created_by`,"
        		+ " `priority`, `change_request.start_date`, `change_request.end_date`, `change_request.priority`, `change_request.requested_by_date`,"
        		+ " `change_request.u_request_by_end_date`, `change_request.risk`, `change_request.state`, `dbCreatedOn`, `dbUpdatedOn`) "
        		+ "VALUES "
        		+ "(?,?,?,?,?,?,?,?,?,?,"        		
        		+ "?,?,?,?,?,?,?,?,?,?,"     	
        		+ "?,?,?,?,?,?,?,?"
        		+ ")";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        
        preparedStmt.setString(1,getNumber());
        preparedStmt.setString(2,getChange_request());
        preparedStmt.setString(3,getCorrelation_id());
        preparedStmt.setString(4,getActive());
        preparedStmt.setString(5,getActivity_due());
        preparedStmt.setString(6,getAdditional_assignee_list());
        preparedStmt.setString(7,getApproval());
        preparedStmt.setString(8,getApproval_history());
        preparedStmt.setString(9,getApproval_set());
        preparedStmt.setString(10,getAssigned_to());
        preparedStmt.setString(11,getAssignment_group());
        preparedStmt.setInt(12,getIntValue(getBusiness_duration()));
        preparedStmt.setString(13,setSalesForceDateTimeFormat(getWork_start()));
        preparedStmt.setString(14,setSalesForceDateTimeFormat(getWork_end()));
        preparedStmt.setString(15,setSalesForceDateTimeFormat(getSys_created_on()));
        preparedStmt.setString(16,setSalesForceDateTimeFormat(getClosed_at()));
        preparedStmt.setString(17,setSalesForceDateTimeFormat(getSys_updated_on()));
        preparedStmt.setString(18,getSys_created_by());
        preparedStmt.setString(19,getPriority());
        preparedStmt.setString(20,setSalesForceDateTimeFormat(getChange_request_start_date()));
        preparedStmt.setString(21,setSalesForceDateTimeFormat(getChange_request_end_date()));
        preparedStmt.setString(22,getChange_request_priority());
        preparedStmt.setString(23,setSalesForceDateTimeFormat(getChange_request_requested_by_date()));
        preparedStmt.setString(24,setSalesForceDateTimeFormat(getChange_request_u_request_by_end_date()));
        preparedStmt.setString(25,getChange_request_risk());
        preparedStmt.setString(26,getChange_request_state());
        preparedStmt.setTimestamp(27,updatedAt);
        preparedStmt.setTimestamp(28,updatedAt);
        
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
