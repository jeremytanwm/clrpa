import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class dbSFDCNewOpportunity {
	
	
	public static String dbName="c1ppms"; //c1ppms
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";
	  
	 public  ArrayList<String> list = new ArrayList<String>();
	 private DatabaseManager db = null;
	 private   Connection conn = null;

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		dbSFDCNewOpportunity.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		dbSFDCNewOpportunity.dbpassword = dbpassword;
	}


  
	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		dbSFDCNewOpportunity.dbName = dbName;
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
  public dbSFDCNewOpportunity() {
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
    
   
    String sID=list.get(0)+list.get(6);
    
    sID=sID.replaceAll("['\"\\\\]", "");
    
    try {
    	
    	if (conn==null) {
    		conn = (Connection)db.getConnection();
    	}
    	if (conn.isClosed()) {
    		conn = (Connection)db.getConnection();
    	}
    	
    	 String sSelect = "Select `ID` from `sfdcnew-opportunity` where `Record ID`='" + list.get(0)+ "'";
         Statement st = (Statement)conn.createStatement();
         ResultSet rs = (ResultSet)st.executeQuery(sSelect);
         if (rs.next()) {    	
        	  if (isDelete) {
        	  System.out.println("DELETE Record for Record ID= "+list.get(0));
        	//c1ppms to choonhong.lau
        	  sQuery = "DELETE FROM `c1ppms`.`sfdcnew-opportunity` WHERE "		        		
		        		+ "`Record ID`=? ";
		        		
		        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
		     
		
		        
		        preparedStmt.setString(1,list.get(0));
		        
		     
		        //preparedStmt.setTimestamp(23,updatedAt);
		        
		        sStmt= preparedStmt.toString();
		        preparedStmt.executeUpdate();
		        preparedStmt.close();        
		        //System.out.println("INSERT Record for ID= "+sID);
        	  } else {
        		  System.out.println("SKIP for Deletion. Record ID="+list.get(0));
        	  }
         } 
       //c1ppms to choonhong.lau
				        sQuery = "INSERT INTO `c1ppms`.`sfdcnew-opportunity`"
				        		+ "("
				        		+ "`Record ID`,"
				        		+ "`Opportunity ID`,"
				        		+ "`Legacy ID`,"
				        		+ "`Parent Account ID`,"
				        		+ "`Account ID`,"
				        		+ "`Prod - Record ID`,"
				        		+ "`Prod - Record ID Unique`,"
				        		+ "`Local Assigned Region`,"
				        		+ "`Product Name`,"
				        		+ "`Opportunity Name`,"
				        		+ "`Stage`,"
				        		+ "`Last Stage Change Date`,"
				        		+ "`Account Name`,"
				        		+ "`Opportunity Owner`,"
				        		+ "`Opportunity Owner: Manager`,"
				        		+ "`Forecast Category`,"
				        		+ "`Close Month`,"
				        		+ "`Created Date`,"
				        		+ "`Contract Type`,"
				        		+ "`Industry`,"
				        		+ "`Offering`,"
				        		+ "`Business Unit`,"
				        		+ "`Solution`,"
				        		+ "`Product Family`,"
				        		+ "`Service Category`,"
				        		+ "`Service Tower`,"
				        		+ "`Order Service Type`,"
				        		+ "`Amount Currency`,"
				        		+ "`Amount`,"
				        		+ "`Amount (converted) Currency`,"
				        		+ "`Amount (converted)`,"
				        		+ "`Contract Term (Months)`,"
				        		+ "`TCV (converted) Currency`,"
				        		+ "`TCV (converted)`,"
				        		+ "`TCV GP (converted) Currency`,"
				        		+ "`TCV GP (converted)`,"
				        		+ "`ACV (converted) Currency`,"
				        		+ "`ACV (converted)`,"
				        		+ "`ACV GP (converted) Currency`,"
				        		+ "`ACV GP (converted)`,"
				        		+ "`Probability (%)`,"
				        		+ "`Last Modified Date`,"
				        		+ "`Last Modified By`,"
				        		+ "`Manufacturer`,"
				        		+ "`GlobalVendor`,"
				        		+ "`LocalVendor`,"
				        		+ "`PrimaryCampaignSource`,"
				        		+ "`Description`,"
				        		+ "`ID`)"
				        		+ " VALUES "
				        		+ "(?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?"
				        		+ ")";
				        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
				     
				
				        for (int i=1; i<=list.size(); i++) {
				        	String sValue = list.get(i-1);
				        	
					        	switch (i) {
					        	case 12 :
					        		preparedStmt.setString(i,setSalesForceDateFormat(sValue));
					        		break;
					        	case 17 :
					        		preparedStmt.setString(i,setSalesForceDateFormat(sValue));
					        		break;
					        	case 18 :
					        		preparedStmt.setString(i,setSalesForceDateFormat(sValue));
					        		break;	
					        	case 42 :
					        		preparedStmt.setString(i,setSalesForceDateFormat(sValue));
					        		break;				        						        		
					        	default: 
					        		preparedStmt.setString(i,sValue);
					        		break;
					        	}
				        	
				        	
				        		
				        	
				        	
				        }
				        
				       
				        preparedStmt.setString(list.size()+1,sID);
				        
				     
				        //preparedStmt.setTimestamp(23,updatedAt);
				        
				        sStmt= preparedStmt.toString();
				        preparedStmt.executeUpdate();
				        preparedStmt.close();        
				        //System.out.println("INSERT Record for ID= "+sID);
      
          
  
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
