import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class dbSFDCNewOpportunityTeam {
	
	
	public static String dbName="c1ppms";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";
	  
	 public  ArrayList<String> list = new ArrayList<String>();
	 private DatabaseManager db = null;
	 private   Connection conn = null;

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		dbSFDCNewOpportunityTeam.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		dbSFDCNewOpportunityTeam.dbpassword = dbpassword;
	}


  
	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		dbSFDCNewOpportunityTeam.dbName = dbName;
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
  
  private String setSalesForceDateFormat(String sDateOri) {
	    String temp = null;
	    String sDate="";
	    
	    try {
	    	
	  
	    	
	      sDate = sDateOri.trim();
	    } catch (Exception e) {
	      sDate = "";
	    } 
	    if (sDate.equals("")) {
	      temp = "0000-00-00";
	    } else {
	      try {
	        String[] s = sDate.split("/");
	        
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
				        	
				        	 if (sMonth.length() == 1)
				        		 sMonth = "0" + sMonth; 
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
	    return temp;
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
  public dbSFDCNewOpportunityTeam() {
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
  public boolean Load(boolean isDelete) {
	boolean rslt=true;
   
    String sQuery = "";
    String sStmt="";
    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
    PreparedStatement preparedStmt = null;
    

    
    try {
    	
    	if (conn==null) {
    		conn = (Connection)db.getConnection();
    	}
    	if (conn.isClosed()) {
    		conn = (Connection)db.getConnection();
    	}
    	
    	 String sSelect = "Select `Record ID` from `sfdcnew-opportunity-team` where `Record ID`='" + list.get(0)+ "'";
         Statement st = (Statement)conn.createStatement();
         ResultSet rs = (ResultSet)st.executeQuery(sSelect);
         if (rs.next()) {    	
        	 if (isDelete) {
           	  System.out.println("DELETE Record for Opportunity ID= "+list.get(1));
           	  sQuery = "DELETE FROM `c1ppms`.`sfdcnew-opportunity-team` WHERE "		        		
   		        		+ "`Opportunity ID`=? ";
   		        		
   		        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
   		     
   		
   		        
   		        preparedStmt.setString(1,list.get(1));
   		        
   		     
   		        //preparedStmt.setTimestamp(23,updatedAt);
   		        
   		        sStmt= preparedStmt.toString();
   		        preparedStmt.executeUpdate();
   		        preparedStmt.close();        
   		        //System.out.println("INSERT Record for ID= "+sID);
           	  } else {
           		  System.out.println("SKIP for Deletion. Opportunity ID="+list.get(1));
           	  }
        	 
        	 /*
        	 sQuery = "UPDATE `c1ppms`.`sfdcnew-opportunity-team` SET "
		        		+ "`Opportunity ID`=?,"		        	
		        		+ "`Opportunity Name`=?,"
		        		+ "`Opportunity Team Member ID`=?,"
		        		+ "`Team Member Name`=?,"
		        		+ "`Team Role`=?,"
		        		+ "`Sales Region`=?,"
		        		+ "`dbUpdatedOn`=? "		        		
		        		
		        		   	  		
               		    + " WHERE `Record ID`=?";
               preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
               preparedStmt.setString(1,list.get(1));
               preparedStmt.setString(2,list.get(2));
               preparedStmt.setString(3,list.get(3)); 
               preparedStmt.setString(4,list.get(4)); 
               preparedStmt.setString(5,list.get(5));
               preparedStmt.setString(6,list.get(6));
               preparedStmt.setTimestamp(7,updatedAt);
               preparedStmt.setString(8,list.get(0));
               sStmt= preparedStmt.toString();
               preparedStmt.execute();
               preparedStmt.executeUpdate();
               preparedStmt.close();
               
                 */
         } 
     
				        sQuery = "INSERT INTO `c1ppms`.`sfdcnew-opportunity-team`"
				        		+ "("
				        		+ "`Record ID`,"
				        		+ "`Opportunity ID`,"
				        	
				        		+ "`Opportunity Name`,"
				        		+ "`Opportunity Team Member ID`,"
				        		+ "`Team Member Name`,"
				        		+ "`Team Role`,"
				        		+ "`Sales Region`"				        		
				        		+ ")"
				        		+ " VALUES "
				        		+ "(?,?,?,?,?,?,?)"
				        		;
				        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
				     
				
				        for (int i=1; i<=list.size(); i++) {
				        	String sValue = list.get(i-1);
				        	
					        	switch (i) {
					        	        						        		
					        	default: 
					        		preparedStmt.setString(i,sValue);
					        		break;
					        	}
				        	
				        	
				        		
				        	
				        	
				        }
				        
				       
				      
				        
				     
				        //preparedStmt.setTimestamp(23,updatedAt);
				        
				        sStmt= preparedStmt.toString();
				        preparedStmt.executeUpdate();
				        preparedStmt.close();        
				        //System.out.println("INSERT Record for ID= "+list.get(0));
      
         
  
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
  
  
  public boolean delete(String sYearMonth, String sCompanyCode, String sPCCode) {
		boolean rslt=true;
	   
	    String sQuery = "";
	    String sStmt="";
	    
	    PreparedStatement preparedStmt = null;
	    
	   
	    
	    
	    try {
		     
		      sQuery = "delete from  `sap-finance-actual` where `Year/month` = ? and `CompanyCode` =? and `PCMenu`=?";
		      preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);		      
	          
	          preparedStmt.setString(1,sYearMonth);
	          preparedStmt.setString(2,sCompanyCode);
	          preparedStmt.setString(3,sPCCode);
	          
	          sStmt= preparedStmt.toString();
	          preparedStmt.execute();
	          preparedStmt.executeUpdate();
	          preparedStmt.close();   
		        
		        
		      
		      conn.close();
		     
		    } catch (Exception e) {
		    	
		      System.out.println("ERROR: deleteTicket:" + sQuery);
		      System.out.println("ERROR: deleteTicket:" + e.getMessage());
		      System.out.println("ERROR: deleteTicket: SQL: " + sStmt);
		        
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
}
