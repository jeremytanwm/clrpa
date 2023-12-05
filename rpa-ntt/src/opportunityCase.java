import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class opportunityCase {
	public String	parentidcase	="";
	public String	parentcase	="";
	public String	idcase	="";
	public String	idopportunity	="";
	public String	opportunityowner	="";
	public String	casenumber	="";
	public String	caseowner	="";
	public String	caseidowner	="";
	public String	subject	="";
	public String	description	="";
	public String	closeremark	="";
	public String	status	="";
	public String	priority	="";
	public String	duedate	="";
	public String	age	="";
	public String	contactname	="";
	public String	contactemail	="";
	public String	createdon	="";
	public String	createdby	="";
	public String	createdid	="";
	public String	updatedon	="";
	public String	updatedby	="";
	public String	updatedid	="";
	public String	closedon	="";  
  
	
  public String getOpportunityowner() {
		return opportunityowner;
	}

	public void setOpportunityowner(String opportunityowner) {
		this.opportunityowner = opportunityowner;
	}

public String getCaseidowner() {
		return caseidowner;
	}

	public void setCaseidowner(String caseidowner) {
		this.caseidowner = caseidowner;
	}

	public String getCreatedid() {
		return createdid;
	}

	public void setCreatedid(String createdid) {
		this.createdid = createdid;
	}

	public String getUpdatedid() {
		return updatedid;
	}

	public void setUpdatedid(String updatedid) {
		this.updatedid = updatedid;
	}

public String getDescription() {
		return description;
	}

	public void setDescription(String desription) {
		this.description = desription;
	}

	public String getCloseremark() {
		return closeremark;
	}

	public void setCloseremark(String closeremark) {
		this.closeremark = closeremark;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

public String getParentidcase() {
		return parentidcase;
	}

	public void setParentidcase(String parentidcase) {
		this.parentidcase = parentidcase;
	}

	public String getParentcase() {
		return parentcase;
	}

	public void setParentcase(String parentcase) {
		this.parentcase = parentcase;
	}

	public String getIdcase() {
		return idcase;
	}

	public void setIdcase(String idcase) {
		this.idcase = idcase;
	}

	public String getIdopportunity() {
		return idopportunity;
	}

	public void setIdopportunity(String idopportunity) {
		this.idopportunity = idopportunity;
	}

	public String getCasenumber() {
		return casenumber;
	}

	public void setCasenumber(String casenumber) {
		this.casenumber = casenumber;
	}

	public String getCaseowner() {
		return caseowner;
	}

	public void setCaseowner(String caseowner) {
		this.caseowner = caseowner;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	public String getContactemail() {
		return contactemail;
	}

	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public String getClosedon() {
		return closedon;
	}

	public void setClosedon(String closedon) {
		this.closedon = closedon;
	}

public static String getDbusername() {
    return dbusername;
  }
  
  public static void setDbusername(String dbusername) {
    opportunityCase.dbusername = dbusername;
  }
  
  public static String getDbpassword() {
    return dbpassword;
  }
  
  public static void setDbpassword(String dbpassword) {
    opportunityCase.dbpassword = dbpassword;
  }
  
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
	public static String dbName="c1ppms";
  
  public static void main(String[] args) {}
  
  private String setMysqDate(String sDate) {
    String temp = null;
    try {
      sDate = sDate.trim();
    } catch (Exception e) {
      sDate = "";
    } 
    if (sDate.equals("")) {
      temp = "9999-12-31";
    } else {
      try {
        String[] s = sDate.split("/");
        String sMonth = s[1];
        if (sMonth.length() == 1)
          sMonth = "0" + sMonth; 
        String sDay = s[0];
        if (sDay.length() == 1)
          sDay = "0" + sDay; 
        int iMonth = 0;
        try {
          iMonth = Integer.parseInt(sMonth);
        } catch (Exception exception) {}
        if (iMonth <= 12) {
          temp = String.valueOf(s[2]) + "-" + sMonth + "-" + sDay;
        } else {
          temp = String.valueOf(s[2]) + "-" + sDay + "-" + sMonth;
        } 
      } catch (Exception e) {
        temp = "9999-12-31";
      } 
    } 
    //if (temp == null)
     // temp = "9999-12-31"; 
    if (temp.equals(""))
      temp = "9999-12-31"; 
    if (temp.isEmpty())
      temp = "9999-12-31"; 
    return temp;
  }
  
  public Float getFloatValue(String str) {
    Float frslt = null;
    try {
      if (str.isEmpty()) {
        str = "0";
      } else {
        str = str.replaceAll(",", "");
        str = str.replaceAll("\\p{Alpha}", "");
        str = str.replaceAll("\\%", "");
      } 
      frslt = Float.valueOf(str);
    } catch (Exception e) {
      frslt = Float.valueOf("0");
    } 
    return frslt;
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
  
  public static String queryIDRecord(String sIDRecord) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `idcase` from `opportunity-case` where `idcase`=\"" + sIDRecord + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String id = "";
      int i = 1;
      if (rs.next()) {
        id = rs.getString("idcase");
        sRslt = id;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return sRslt;
  }
  
  
  public static void dbUpdateIdOpportunity() {
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    try {
	      Statement st1 = (Statement)conn.createStatement();	      
	      try {
	        String sgetHourssql = "SELECT `idcase`, `idopportunity` FROM c1ppms.`opportunity-case` where length(`idopportunity`)>5";
	        ResultSet rs1 = (ResultSet)st1.executeQuery(sgetHourssql);
	        while (rs1.next()) {
	          String sIDCase = rs1.getString(1);
	          String sIdOpportunity = rs1.getString(2);
	          Statement st = (Statement)conn.createStatement();
	          String supdate = "UPDATE  `opportunity-case` set  `idopportunity`='" + sIdOpportunity + "' where `parentidcase`='" + sIDCase+"'";	          
	          System.out.println(supdate);
	          st.execute(supdate);
	          st.close();
	        } 
	        rs1.close();
	        st1.close();
	        conn.close();
	      } catch (Exception e) {
	        System.out.println(e.getMessage());
	      } 
	    } catch (SQLException ex) {
	      System.out.println(ex.getMessage());
	    } 
	  }
  
  public void dbUpdateOpportunityCase() {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    PreparedStatement preparedStmt = null;
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      String sID = queryIDRecord(getIdcase());
      
      if (sID.isEmpty()) {
        sQuery = "INSERT INTO `opportunity-case`(`parentidcase`, `parentcase`, `idcase`, `idopportunity`,"
        		+ " `casenumber`, `caseowner`, `subject`, `description`, `closeremark`,`status`, `priority`, "
        		+ "`duedate`,`age`,`contactname`, `contactemail`, "
        		+ "`createdon`, `createdby`, `updatedon`, `updatedby`, `closedon`,`caseidowner`,`createdid`,`updatedid`,`opportunityowner`)"
        		+ " VALUES (?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getParentidcase());
        preparedStmt.setString(2, getParentcase());
        preparedStmt.setString(3, getIdcase());
        preparedStmt.setString(4, getIdopportunity());
        preparedStmt.setString(5, getCasenumber());
        preparedStmt.setString(6, getCaseowner());
        preparedStmt.setString(7, getSubject());
        preparedStmt.setString(8, getDescription());
        preparedStmt.setString(9, getCloseremark());
        preparedStmt.setString(10, getStatus());
        preparedStmt.setString(11, getPriority());
        preparedStmt.setString(12, setMysqDate(getDuedate()));
        preparedStmt.setString(13, getAge());
        preparedStmt.setString(14, getContactname());
        preparedStmt.setString(15, getContactemail());
        preparedStmt.setString(16, setMysqDate(getCreatedon()));
        preparedStmt.setString(17, getCreatedby());        
        preparedStmt.setString(18, setMysqDate(getUpdatedon()));
        preparedStmt.setString(19, getUpdatedby());        
        preparedStmt.setString(20, setMysqDate(getClosedon()));
        preparedStmt.setString(21, getCaseidowner());
        preparedStmt.setString(22, getCreatedid());
        preparedStmt.setString(23, getUpdatedid());
        preparedStmt.setString(24, getOpportunityowner());
        System.out.println(preparedStmt.toString());
        preparedStmt.execute();
        preparedStmt.close();
      } else {
        sQuery = "UPDATE `opportunity-case` SET `parentidcase`=?,`parentcase`=?,`idopportunity`=?,"
        		+ "`casenumber`=?,`caseowner`=?,`subject`=?,`description`=?, `closeremark`=?,`status`=?,`priority`=?,"
        		+ "`duedate`=?,`age`=?,`contactname`=?,`contactemail`=?,"
        		+ "`createdon`=?,`createdby`=?,`updatedon`=?,`updatedby`=?,`closedon`=?,`caseidowner`=?,`createdid`=?,`updatedid`=?, `opportunityowner`=?  "
        		+ " WHERE `idcase`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getParentidcase());
        preparedStmt.setString(2, getParentcase());        
        preparedStmt.setString(3, getIdopportunity());
        preparedStmt.setString(4, getCasenumber());
        preparedStmt.setString(5, getCaseowner());
        preparedStmt.setString(6, getSubject());
        preparedStmt.setString(7, getDescription());
        preparedStmt.setString(8, getCloseremark());
        preparedStmt.setString(9, getStatus());
        preparedStmt.setString(10, getPriority());
        preparedStmt.setString(11, setMysqDate(getDuedate()));
        preparedStmt.setString(12, getAge());
        preparedStmt.setString(13, getContactname());
        preparedStmt.setString(14, getContactemail());
        preparedStmt.setString(15, setMysqDate(getCreatedon()));
        preparedStmt.setString(16, getCreatedby());        
        preparedStmt.setString(17, setMysqDate(getUpdatedon()));
        preparedStmt.setString(18, getUpdatedby());        
        preparedStmt.setString(19, setMysqDate(getClosedon()));
        preparedStmt.setString(20, getCaseidowner());
        preparedStmt.setString(21, getCreatedid());
        preparedStmt.setString(22, getUpdatedid());
        preparedStmt.setString(23, getOpportunityowner());
        preparedStmt.setString(24, getIdcase());
        System.out.println(preparedStmt.toString());
        preparedStmt.execute();
        preparedStmt.close();
      } 
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR:" + sQuery);
      System.out.println("ERROR:" + preparedStmt.toString());
      System.out.println("ERROR:" + e.getMessage());
      try {
        conn.close();
      } catch (SQLException e1) {
        e1.printStackTrace();
      } 
    } 
  }
}
