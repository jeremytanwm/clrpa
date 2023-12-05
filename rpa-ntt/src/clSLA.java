import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class clSLA {
	public String u_contract="";
	public String sla_name="";
	public String task="";
	public String task_sys_class_name="";
	public String task_u_contract="";
	public String task_state="";
	public String task_company="";
	public String sla_type="";
	public String u_current_stage="";
	public String u_escalation="";
	public String task_priority="";
	public String task_sys_updated_on="";
	public String task_sys_created_on="";
	public String has_breached="";
	public String percentage="";
	public String start_time="";
	public String end_time="";
	public String time_left="";
	public String pause_duration="";
	public String planned_end_time="";
	public String duration="";
	public String pause_time="";
	public String original_breach_time="";
	public String business_percentage="";
	public String business_time_left="";
	public String business_duration="";
	public String business_pause_duration="";
	public String u_breach_reason_code="";
	public String u_breach_comments="";
	public String active="";
	public String u_name="";
	public String sys_updated_on="";
	public String sys_updated_by="";
	
	
	public static String dbName="capitaland";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";


	  
	  public clSLA(String tmpDBName) {
		  dbName=tmpDBName;
		  
	  }
	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		clSLA.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		clSLA.dbpassword = dbpassword;
	}


  

  
  public String getU_contract() {
		return u_contract;
	}

	public void setU_contract(String u_contract) {
		this.u_contract = u_contract;
	}

	public String getSla_name() {
		return sla_name;
	}

	public void setSla_name(String sla_name) {
		this.sla_name = sla_name;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getTask_sys_class_name() {
		return task_sys_class_name;
	}

	public void setTask_sys_class_name(String task_sys_class_name) {
		this.task_sys_class_name = task_sys_class_name;
	}

	public String getTask_u_contract() {
		return task_u_contract;
	}

	public void setTask_u_contract(String task_u_contract) {
		this.task_u_contract = task_u_contract;
	}

	public String getTask_state() {
		return task_state;
	}

	public void setTask_state(String task_state) {
		this.task_state = task_state;
	}

	public String getTask_company() {
		return task_company;
	}

	public void setTask_company(String task_company) {
		this.task_company = task_company;
	}

	public String getSla_type() {
		return sla_type;
	}

	public void setSla_type(String sla_type) {
		this.sla_type = sla_type;
	}

	public String getU_current_stage() {
		return u_current_stage;
	}

	public void setU_current_stage(String u_current_stage) {
		this.u_current_stage = u_current_stage;
	}

	public String getU_escalation() {
		return u_escalation;
	}

	public void setU_escalation(String u_escalation) {
		this.u_escalation = u_escalation;
	}

	public String getTask_priority() {
		return task_priority;
	}

	public void setTask_priority(String task_priority) {
		this.task_priority = task_priority;
	}

	public String getTask_sys_updated_on() {
		return task_sys_updated_on;
	}

	public void setTask_sys_updated_on(String task_sys_updated_on) {
		this.task_sys_updated_on = task_sys_updated_on;
	}

	public String getTask_sys_created_on() {
		return task_sys_created_on;
	}

	public void setTask_sys_created_on(String task_sys_created_on) {
		this.task_sys_created_on = task_sys_created_on;
	}

	public String getHas_breached() {
		return has_breached;
	}

	public void setHas_breached(String has_breached) {
		this.has_breached = has_breached;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getTime_left() {
		return time_left;
	}

	public void setTime_left(String time_left) {
		this.time_left = time_left;
	}

	public String getPause_duration() {
		return pause_duration;
	}

	public void setPause_duration(String pause_duration) {
		this.pause_duration = pause_duration;
	}

	public String getPlanned_end_time() {
		return planned_end_time;
	}

	public void setPlanned_end_time(String planned_end_time) {
		this.planned_end_time = planned_end_time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPause_time() {
		return pause_time;
	}

	public void setPause_time(String pause_time) {
		this.pause_time = pause_time;
	}

	public String getOriginal_breach_time() {
		return original_breach_time;
	}

	public void setOriginal_breach_time(String original_breach_time) {
		this.original_breach_time = original_breach_time;
	}

	public String getBusiness_percentage() {
		return business_percentage;
	}

	public void setBusiness_percentage(String business_percentage) {
		this.business_percentage = business_percentage;
	}

	public String getBusiness_time_left() {
		return business_time_left;
	}

	public void setBusiness_time_left(String business_time_left) {
		this.business_time_left = business_time_left;
	}

	public String getBusiness_duration() {
		return business_duration;
	}

	public void setBusiness_duration(String business_duration) {
		this.business_duration = business_duration;
	}

	public String getBusiness_pause_duration() {
		return business_pause_duration;
	}

	public void setBusiness_pause_duration(String business_pause_duration) {
		this.business_pause_duration = business_pause_duration;
	}

	public String getU_breach_reason_code() {
		return u_breach_reason_code;
	}

	public void setU_breach_reason_code(String u_breach_reason_code) {
		this.u_breach_reason_code = u_breach_reason_code;
	}

	public String getU_breach_comments() {
		return u_breach_comments;
	}

	public void setU_breach_comments(String u_breach_comments) {
		this.u_breach_comments = u_breach_comments;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getSys_updated_on() {
		return sys_updated_on;
	}

	public void setSys_updated_on(String sys_updated_on) {
		this.sys_updated_on = sys_updated_on;
	}

	public String getSys_updated_by() {
		return sys_updated_by;
	}

	public void setSys_updated_by(String sys_updated_by) {
		this.sys_updated_by = sys_updated_by;
	}

	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		clSLA.dbName = dbName;
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
  
  public boolean dbLoadSLA() {
	boolean rslt=true;
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    String sStmt="";
    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
    PreparedStatement preparedStmt = null;
    try {
     if (getU_name().length()>12) {
      String sSelect = "Select `u_name` from `sla` where `u_name`=\"" + getU_name() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {    	  
    	  sQuery = "UPDATE `sla` SET `u_contract`=?, "
    	  		+ "`sla.name`=?,"
    	  		+ "`task`=?,"
    	  		+ "`task.sys_class_name`=?,"
    	  		+ "`task.u_contract`=?,"
    	  		+ "`task.state`=?,"
    	  		+ "`task.company`=?,"
    	  		+ "`sla.type`=?,"
    	  		+ "`u_current_stage`=?,"
    	  		+ "`u_escalation`=?,"
    	  		+ "`task.priority`=?,"
    	  		+ "`task.sys_updated_on`=?,"
    	  		+ "`task.sys_created_on`=?,"
    	  		+ "`has_breached`=?,"
    	  		+ "`percentage`=?,"
    	  		+ "`start_time`=?,"
    	  		+ "`end_time`=?,"
    	  		+ "`time_left`=?,"
    	  		+ "`pause_duration`=?,"
    	  		+ "`planned_end_time`=?,"
    	  		+ "`duration`=?,"
    	  		+ "`pause_time`=?,"
    	  		+ "`original_breach_time`=?,"
    	  		+ "`business_percentage`=?,"
    	  		+ "`business_time_left`=?,"
    	  		+ "`business_duration`=?,"
    	  		+ "`business_pause_duration`=?,"
    	  		+ "`u_breach_reason_code`=?,"
    	  		+ "`u_breach_comments`=?,"
    	  		+ "`active`=?,"    	  		
    	  		+ "`sys_updated_on`=?,"
    	  		+ "`sys_updated_by`=?,"    	  		
    	  		+ "`dbUpdatedOn`=? "
          		+ " WHERE `u_name`=?";
          preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
          preparedStmt.setString(1,getU_contract());
          preparedStmt.setString(2,getSla_name());
          preparedStmt.setString(3,getTask());
          preparedStmt.setString(4,getTask_sys_class_name());
          preparedStmt.setString(5,getTask_u_contract());
          preparedStmt.setString(6,getTask_state());
          preparedStmt.setString(7,getTask_company());
          preparedStmt.setString(8,getSla_type());
          preparedStmt.setString(9,getU_current_stage());
          preparedStmt.setString(10,getU_escalation());
          preparedStmt.setString(11,getTask_priority());
          preparedStmt.setString(12,setSalesForceDateTimeFormat(getTask_sys_updated_on()));//datetime
          preparedStmt.setString(13,setSalesForceDateTimeFormat(getTask_sys_created_on()));//datetime
          preparedStmt.setString(14,getHas_breached());
          preparedStmt.setFloat(15,getFloatValue(getPercentage()));//float
          preparedStmt.setString(16,setSalesForceDateTimeFormat(getStart_time()));//datetime
          preparedStmt.setString(17,setSalesForceDateTimeFormat(getEnd_time()));//datetime
          preparedStmt.setInt(18,getIntValue(getTime_left()));//int
          preparedStmt.setInt(19,getIntValue(getPause_duration()));//int
          preparedStmt.setString(20,setSalesForceDateTimeFormat(getPlanned_end_time()));//datetime
          preparedStmt.setInt(21,getIntValue(getDuration()));//int
          preparedStmt.setInt(22,getIntValue(getPause_time()));//int
          preparedStmt.setString(23,getOriginal_breach_time());
          preparedStmt.setFloat(24,getFloatValue(getBusiness_percentage()));//float
          preparedStmt.setInt(25,getIntValue(getBusiness_time_left()));//int
          preparedStmt.setInt(26,getIntValue(getBusiness_duration()));//int
          preparedStmt.setInt(27,getIntValue(getBusiness_pause_duration()));//int
          preparedStmt.setString(28,getU_breach_reason_code());
          preparedStmt.setString(29,getU_breach_comments());
          preparedStmt.setString(30,getActive());          
          preparedStmt.setString(31,setSalesForceDateTimeFormat(getSys_updated_on()));//datetime
          preparedStmt.setString(32,getSys_updated_by());
          preparedStmt.setTimestamp(33,updatedAt);
          preparedStmt.setString(34,getU_name());
          sStmt= preparedStmt.toString();
          preparedStmt.execute();
          preparedStmt.executeUpdate();
          preparedStmt.close();     
        
      } else {
        sQuery = "INSERT INTO `sla`(`u_contract`, `sla.name`, `task`, `task.sys_class_name`, `task.u_contract`, "
        		+ "`task.state`, `task.company`, `sla.type`, `u_current_stage`, `u_escalation`, `task.priority`,"
        		+ "`task.sys_updated_on`, `task.sys_created_on`, `has_breached`, `percentage`, `start_time`, `end_time`,"
        		+ " `time_left`, `pause_duration`, `planned_end_time`, `duration`, `pause_time`, `original_breach_time`,"
        		+ " `business_percentage`, `business_time_left`, `business_duration`, `business_pause_duration`, "
        		+ "`u_breach_reason_code`, `u_breach_comments`, `active`, `u_name`, `sys_updated_on`, `sys_updated_by`,"
        		+ " `dbCreatedOn`, `dbUpdatedOn`) VALUES"
        		+ "(?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"        	
        		+ "?,?,?,?,?"
        		+ ")";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        
        preparedStmt.setString(1,getU_contract());
        preparedStmt.setString(2,getSla_name());
        preparedStmt.setString(3,getTask());
        preparedStmt.setString(4,getTask_sys_class_name());
        preparedStmt.setString(5,getTask_u_contract());
        preparedStmt.setString(6,getTask_state());
        preparedStmt.setString(7,getTask_company());
        preparedStmt.setString(8,getSla_type());
        preparedStmt.setString(9,getU_current_stage());
        preparedStmt.setString(10,getU_escalation());
        preparedStmt.setString(11,getTask_priority());
        preparedStmt.setString(12,setSalesForceDateTimeFormat(getTask_sys_updated_on()));//datetime
        preparedStmt.setString(13,setSalesForceDateTimeFormat(getTask_sys_created_on()));//datetime
        preparedStmt.setString(14,getHas_breached());
        preparedStmt.setFloat(15,getFloatValue(getPercentage()));//float
        preparedStmt.setString(16,setSalesForceDateTimeFormat(getStart_time()));//datetime
        preparedStmt.setString(17,setSalesForceDateTimeFormat(getEnd_time()));//datetime
        preparedStmt.setInt(18,getIntValue(getTime_left()));//int
        preparedStmt.setInt(19,getIntValue(getPause_duration()));//int
        preparedStmt.setString(20,setSalesForceDateTimeFormat(getPlanned_end_time()));//datetime
        preparedStmt.setInt(21,getIntValue(getDuration()));//int
        preparedStmt.setInt(22,getIntValue(getPause_time()));//int
        preparedStmt.setString(23,getOriginal_breach_time());
        preparedStmt.setFloat(24,getFloatValue(getBusiness_percentage()));//float
        preparedStmt.setInt(25,getIntValue(getBusiness_time_left()));//int
        preparedStmt.setInt(26,getIntValue(getBusiness_duration()));//int
        preparedStmt.setInt(27,getIntValue(getBusiness_pause_duration()));//int
        preparedStmt.setString(28,getU_breach_reason_code());
        preparedStmt.setString(29,getU_breach_comments());
        preparedStmt.setString(30,getActive());
        preparedStmt.setString(31,getU_name());
        preparedStmt.setString(32,setSalesForceDateTimeFormat(getSys_updated_on()));//datetime
        preparedStmt.setString(33,getSys_updated_by());
        preparedStmt.setTimestamp(34,updatedAt);
        preparedStmt.setTimestamp(35,updatedAt);
        
        
        
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
      System.out.println("ERROR: dbLoadSLA:" + sQuery);
      System.out.println("ERROR: dbLoadSLA:" + e.getMessage());
      System.out.println("ERROR: dbLoadSLA: SQL: " + sStmt);
      
      
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
