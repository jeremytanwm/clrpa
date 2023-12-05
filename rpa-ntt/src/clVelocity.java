import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class clVelocity {
	
	
	public static String dbName="capitaland";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";
	  
	 public  ArrayList<String> list = new ArrayList<String>();
	 private DatabaseManager db = null;
	 private   Connection conn = null;
	 
	 
	 public clVelocity(String tmpDBName) {
		 dbName=tmpDBName;
		  db = new DatabaseManager(dbusername, dbpassword, dbName);
		     conn = (Connection)db.getConnection();
	 }

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		clVelocity.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		clVelocity.dbpassword = dbpassword;
	}


  
	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		clVelocity.dbName = dbName;
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
  public clVelocity() {
	  db = new DatabaseManager(dbusername, dbpassword, dbName);
	     conn = (Connection)db.getConnection();
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
        	          	  
        	  sQuery = "UPDATE `rpaTicket` SET "
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
     
				        sQuery = "INSERT INTO `rpaTicket` "
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
  
public void close() {
	if (conn!=null) {
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	if (db!=null) {
		db=null;
	}
	
	
}
  
  public boolean Load(String sDate, String sCreated, String sClosed, String sBurnRate, String sBacklog) {
		boolean rslt=true;
	   
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    
	    PreparedStatement preparedStmt = null;
	   
	 
	    
	    String sID=sDate;
	    
	    
	    
	    try {
	    	
	    	if (conn==null) {
	    		conn = (Connection)db.getConnection();
	    	}
	    	if (conn.isClosed()) {
	    		conn = (Connection)db.getConnection();
	    	}
	    	
	    	  String sSelect = "Select `sys_date` from `velocity` where `sys_date`=?";
	    	  preparedStmt = (PreparedStatement)conn.prepareStatement(sSelect);
	    	  preparedStmt.setString(1,sID);
	          ResultSet rs = (ResultSet)preparedStmt.executeQuery();
	          if (rs.next()) {    	  
	        	          	  
	        	  sQuery = "UPDATE `velocity` SET "
			        		+ "`dbUpdatedOn`=?, "	        				        		
							+ "`created`=?, "
							+ "`closed`=?, "
							+ "`burn_rate`=?, "
							+ "`backlog`=? "
							
			        		+ " WHERE `sys_date`=? ";
			        		
			        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
			        preparedStmt.setTimestamp(1,updatedAt);
			    	preparedStmt.setInt(2,getIntValue(sCreated));//Int
			    	preparedStmt.setInt(3,getIntValue(sClosed));//Int
			    	preparedStmt.setFloat(4,getFloatValue(sBurnRate));//Float
			    	preparedStmt.setInt(5,getIntValue(sBacklog));//Int
			        preparedStmt.setString(6,sID);
			        sStmt= preparedStmt.toString();
			        preparedStmt.executeUpdate();
			             
			        
	          } else {
	     
					        sQuery = "INSERT INTO `velocity` "
									+"(`sys_date`, "
									+ "`sys_day`, "
									+ "`created`, "
									+ "`closed`, "
									+ "`burn_rate`, "
									+ "`backlog`, "
									+ "`dbCreatedOn`, "
									+ "`dbUpdatedOn`)"
					        		+ "VALUES"
					        		+ "(?,?,?,?,?,?,?,?)";
					        		
					        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
					        
					        preparedStmt.setString(1,sDate);
					        preparedStmt.setString(2,LocalDate.parse(sDate).getDayOfWeek().toString().substring(0,3));
					    	preparedStmt.setInt(3,getIntValue(sCreated));//Int
					    	preparedStmt.setInt(4,getIntValue(sClosed));//Int
					    	preparedStmt.setFloat(5,getFloatValue(sBurnRate));//Float
					    	preparedStmt.setInt(6,getIntValue(sBacklog));//Int
					        
					       
					        preparedStmt.setTimestamp(7,updatedAt);
					        preparedStmt.setTimestamp(8,updatedAt);
					        
					        
					        
					        sStmt= preparedStmt.toString();
					        preparedStmt.executeUpdate();
					              
					        //System.out.println("INSERT Record for ID= "+sID);
	      
	          }
	  
	          preparedStmt.close();  
	          rs.close();
	     
	   
	    } catch (Exception e) {
	    	rslt=false;
	      System.out.println("ERROR: Load:" + sStmt);
	      System.out.println("ERROR: Load:" + e.getMessage());
	      System.out.println("ERROR: Load: SQL: " + sStmt);
	      
	      
	 
	      
	    } finally {
	    	
	    }
	    
	    return rslt;
	  }
	  
	  
  
  public boolean Load(String sDate, String sCreated, String sClosed, String sBurnRate, String sBacklog, String sAssignmentGroup) {
		boolean rslt=true;
	   
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    
	    PreparedStatement preparedStmt = null;
	   
	 
	    
	    String sID=sDate;
	    
	    
	    String sSelect ="";
	    try {
	    	
	    	if (conn==null) {
	    		conn = (Connection)db.getConnection();
	    	}
	    	if (conn.isClosed()) {
	    		conn = (Connection)db.getConnection();
	    	}
	    	
	    	sSelect = "Select `sys_date` from `velocity` where `sys_date`=? AND `assignment_group`=?";
	    	  preparedStmt = (PreparedStatement)conn.prepareStatement(sSelect);
	    	  preparedStmt.setString(1,sID);
	    	  preparedStmt.setString(2,sAssignmentGroup);
	          ResultSet rs = (ResultSet)preparedStmt.executeQuery();
	          if (rs.next()) {    	  
	        	          	  
	        	  sQuery = "UPDATE `velocity` SET "
			        		+ "`dbUpdatedOn`=?, "	        				        		
							+ "`created`=?, "
							+ "`closed`=?, "
							+ "`burn_rate`=?, "
							+ "`backlog`=? "							
			        		+ " WHERE `assignment_group`=? AND `sys_date`=? ";
			        		
			        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
			        preparedStmt.setTimestamp(1,updatedAt);
			    	preparedStmt.setInt(2,getIntValue(sCreated));//Int
			    	preparedStmt.setInt(3,getIntValue(sClosed));//Int
			    	preparedStmt.setFloat(4,getFloatValue(sBurnRate));//Float
			    	preparedStmt.setInt(5,getIntValue(sBacklog));//Int
			    	preparedStmt.setString(6,sAssignmentGroup);
			        preparedStmt.setString(7,sID);
			        sStmt= preparedStmt.toString();
			        preparedStmt.executeUpdate();
			             
			        
	          } else {
	     
					        sQuery = "INSERT INTO `velocity` "
									+"(`sys_date`, "
									+ "`sys_day`, "
									+ "`created`, "
									+ "`closed`, "
									+ "`burn_rate`, "
									+ "`backlog`, "
									+ "`assignment_group`, "
									+ "`dbCreatedOn`, "
									+ "`dbUpdatedOn`)"
					        		+ "VALUES"
					        		+ "(?,?,?,?,?,?,?,?,?)";
					        		
					        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
					        
					        preparedStmt.setString(1,sDate);
					        preparedStmt.setString(2,LocalDate.parse(sDate).getDayOfWeek().toString().substring(0,3));
					    	preparedStmt.setInt(3,getIntValue(sCreated));//Int
					    	preparedStmt.setInt(4,getIntValue(sClosed));//Int
					    	preparedStmt.setFloat(5,getFloatValue(sBurnRate));//Float
					    	preparedStmt.setInt(6,getIntValue(sBacklog));//Int
					    	preparedStmt.setString(7,sAssignmentGroup);
					       
					        preparedStmt.setTimestamp(8,updatedAt);
					        preparedStmt.setTimestamp(9,updatedAt);
					        
					        
					        
					        sStmt= preparedStmt.toString();
					        preparedStmt.executeUpdate();
					              
					        //System.out.println("INSERT Record for ID= "+sID);
	      
	          }
	  
	          preparedStmt.close();  
	          rs.close();
	     
	   
	    } catch (Exception e) {
	    	rslt=false;
	      System.out.println("ERROR: Load:" + sSelect);
	      System.out.println("ERROR: Load:" + e.getMessage());
	      System.out.println("ERROR: Load: SQL: " + sStmt);
	      
	      
	 
	      
	    } finally {
	    	
	    }
	    
	    return rslt;
	  }
	  
	  
  
  public int getData(String sMode, String sDate, String sAssignmentGroup) {
		int rslt=-1;
	   
	    
	    String sStmt="";
	    
	    PreparedStatement preparedStmt = null;
	   
	    
	    
	    String sSelect ="";
	    try {
	    	
	    	if (conn==null) {
	    		conn = (Connection)db.getConnection();
	    	}
	    	if (conn.isClosed()) {
	    		conn = (Connection)db.getConnection();
	    	}
	    	
	    	 sSelect  = "select count(`number`) from `pbiTicket` where DATE(`sys_created_on`)=? ## ";	    	  
	    	  if (sMode!=null) {
	    		  if (sMode.equals("closed")) {
	    			  sSelect = "select count(`number`) from `pbiTicket` where DATE(`closed_at`)=? ## "; 
	    		  } else if (sMode.equals("backlog")) {
	    			  sSelect = "select ((select count(`number`) from `pbiTicket` where DATE(`sys_created_on`)<=? ## ) - (select count(`number`) from `pbiTicket` where DATE(`closed_at`)<=? AND DATE(`closed_at`)>'0000-00-00' ## ) ) as `backlog`  from `pbiTicket` limit 1;"; 
	    		  } 
	    			  
	    			  
	    	  } else sMode="";
	    	  
	   
	    	  
	    	  if (sAssignmentGroup!=null) {
	    		  sSelect= sSelect.replace("##", " AND `assignment_group`=? ");
	    	  }
	    	  preparedStmt = (PreparedStatement)conn.prepareStatement(sSelect);
	    	  preparedStmt.setString(1, sDate);
	    	  if (sMode.equals("backlog")) {
	    		  preparedStmt.setString(2, sAssignmentGroup);
	    		  preparedStmt.setString(3, sDate);  
	    		  preparedStmt.setString(4, sAssignmentGroup);
	    	  } else {
	    		  preparedStmt.setString(2, sAssignmentGroup);
	    	  }
	    	  sStmt = preparedStmt.toString();
	          ResultSet rs = (ResultSet)preparedStmt.executeQuery();
	          if (rs.next()) {    	  	        	          	          
			        rslt=rs.getInt(1);
	          } else {
	          
	          }
	  
	          preparedStmt.close();
	          rs.close();
	     
	   
	    } catch (Exception e) {
	    	rslt=-1;
	      System.out.println("ERROR: Load:" + sSelect);
	      System.out.println("ERROR: Load:" + e.getMessage());
	      System.out.println("ERROR: Load: SQL: " + sSelect);
	      
	      
	 
	      
	    } finally {
	    	
	    }
	    
	    return rslt;
	  }
  
  
  public int getData(String sMode, String sDate) {
		int rslt=-1;
	   
	    
	    String sStmt="";
	    
	    PreparedStatement preparedStmt = null;
	   
	    
	    
	    
	    try {
	    	
	    	if (conn==null) {
	    		conn = (Connection)db.getConnection();
	    	}
	    	if (conn.isClosed()) {
	    		conn = (Connection)db.getConnection();
	    	}
	    	
	    	  String sSelect = "select count(`number`) from `ticket` where DATE(`sys_created_on`)=?";	    	  
	    	  if (sMode!=null) {
	    		  if (sMode.equals("closed")) {
	    			  sSelect = "select count(`number`) from `ticket` where DATE(`closed_at`)=?"; 
	    		  } else if (sMode.equals("backlog")) {
	    			  sSelect = "select ((select count(`number`) from `ticket` where DATE(`sys_created_on`)<=?) - (select count(`number`) from `ticket` where DATE(`closed_at`)<=? AND DATE(`closed_at`)>'0000-00-00') ) as `backlog`  from `ticket` limit 1;"; 
	    		  } 
	    			  
	    			  
	    	  } else sMode="";
	    	  preparedStmt = (PreparedStatement)conn.prepareStatement(sSelect);
	    	  preparedStmt.setString(1, sDate);
	    	  if (sMode.equals("backlog")) {
	    		  preparedStmt.setString(2, sDate);  
	    	  }
	    	  sStmt = preparedStmt.toString();
	          ResultSet rs = (ResultSet)preparedStmt.executeQuery();
	          if (rs.next()) {    	  	        	          	          
			        rslt=rs.getInt(1);
	          } else {
	          
	          }
	  
	          preparedStmt.close();
	          rs.close();
	     
	   
	    } catch (Exception e) {
	    	rslt=-1;
	      System.out.println("ERROR: Load:" + sStmt);
	      System.out.println("ERROR: Load:" + e.getMessage());
	      System.out.println("ERROR: Load: SQL: " + sStmt);
	      
	      
	 
	      
	    } finally {
	    	
	    }
	    
	    return rslt;
	  }
  
}
