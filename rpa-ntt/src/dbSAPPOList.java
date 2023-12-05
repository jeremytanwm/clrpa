import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class dbSAPPOList {
	
	
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
		dbSAPPOList.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		dbSAPPOList.dbpassword = dbpassword;
	}


  
	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		dbSAPPOList.dbName = dbName;
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
  public dbSAPPOList() {
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
    
    String sMatDesc=list.get(31);
    if (sMatDesc!=null) {
    	sMatDesc=sMatDesc.trim().replaceAll(" ", "");
    	if (sMatDesc.length()>20) {
    		sMatDesc=sMatDesc.substring(0,20);
    	}
    }
    
    String sID=list.get(0)+printIDString(list.get(1))+printIDString(list.get(13))+printIDString(list.get(35))
    +printIDString(list.get(4))+printIDString(list.get(14))+printIDString(list.get(15))
    +printIDString(list.get(18))+printIDString(list.get(32))+printIDString(list.get(190))+printIDString(list.get(39))
    +printIDString(list.get(74))+printIDString(list.get(136))+printIDString(list.get(137))
    +printIDString(sMatDesc);
    
    sID=sID.replaceAll("['\"\\\\]", "");
    
    try {
    	
    	if (conn==null) {
    		conn = (Connection)db.getConnection();
    	}
    	if (conn.isClosed()) {
    		conn = (Connection)db.getConnection();
    	}
    	
    	  String sSelect = "Select `id` from `sap-polist` where `id`='" + sID+ "'";
          Statement st = (Statement)conn.createStatement();
          ResultSet rs = (ResultSet)st.executeQuery(sSelect);
          if (rs.next()) {    	  
        	  System.out.println("Duplicate Record for ID= "+sID);
          } else {
     
				        sQuery = "INSERT INTO `sap-polist`(`Company Code`, `Vendor`, `Purchasing Org`, `Purch Group`, `Create Date`, `Created By`,"
				        		+ " `PO Currency`, `PO Exch`, `Collective No`, `Exch Ind`, `Document Type`, `Salesperson`, "
				        		+ "`Our Reference`, `Purchasing Doc`, `PO itm`, `Material`, `Ord Qty`, `UOM`, `Net.Frg`, `Net.Lcl`, "
				        		+ "`Net.Pr`, `Tax Code`, `Plant`, `GR Ind`, `IR Ind`, `Dlv compl`, `Final Inv IR`, `PO DelInd`, `Plant Desc`,"
				        		+ " `Plant Country`, `Acct Assgmt Cat`, `Mat Text`, `SD Document`, `Sales Doc Type`, `Sls Doc Type Desc`, `Sales Line`, "
				        		+ "`Contract start`, `Contract end`, `Installat date`, `Cust No`, `SO Ord Rsn`, `SO Order Rsn Desc`, `Country`, `City`,"
				        		+ " `Postal Code`, `Returns Item`, `PO Ord Rsn`, `Description`, `Project ID`, `PO Itm Cat`, `Manufacturer`, `Mfr Part Number`,"
				        		+ " `Group`, `Group Key Desc`, `Agreement Number`, `WBS Desc`, `G/L Acc Desc`, `Forward Cover Cntr`, `Smart Acc`, `Smart Sub`,"
				        		+ " `HSmart Acc`, `HSmart Sub`, `H Hold Acc`, `H Hold Sub`, `Deal ID`, `Shp.Cond.`, `Storage Loc.`, `Sloc Desc`, `Valuation Type`,"
				        		+ " `Valuation Class`, `Acct Ass Cat Desc`, `Mat Type Desc`, `Division`, `Division Desc`, `Confirmation`, `Grouping ID`, `Delivery date`,"
				        		+ " `Deferred Lock`, `Configuration`, `HV Qty`, `HV Ind`, `Vend Conf Seq Num`, `Confirm. Cat.`, `Vend Conf Del Date`,"
				        		+ " `Vend Conf Crte Date`, `Vend Conf Qty`, `Reference`, `GR Qty`, `GR Item Blk Qty`, `GR LclVal`, `GR FrgVal`, `Event Type`, "
				        		+ "`Movement type`, `GR Exch`, `GR CalcVal`, `GR Diff`, `Material Doc of GR B`, `IR Qty`, `IR LclVal`, `IR FrgVal`, `IR Exch`, "
				        		+ "`IR CalcVal`, `IR Diff`, `O/S Qty`, `O/S Lcl`, `O/S Frg`, `Vend Name`, `Cust Name`, `Mat Desc`, `Material Type`, `Material Group`,"
				        		+ " `Matl Grp Desc`, `Prod. Hierarchy`, `ProdH Desc`, `1st Del Date`, `Cust Cont Strt`, `Cust Cont End`, `Period`, `Cust Cont Net Value`,"
				        		+ " `Cust Cont Period Val`, `Cr Ctrl area Curr`, `PeriodDesc`, `PO Vend Val.St.Dt`, `PO Vend Val.End.Dt`, `PO Line Val.St.Dt`, "
				        		+ "`PO Line Val.End.Dt`, `Xeqln`, `G/L Account`, `Cost Center`, `Profit Center`, `WBS Element`, `Network`, `Asset`, `Service Order`,"
				        		+ " `Col: NO`, `Cust Curr`, `PR No`, `PR ItemNo`, `PR Vendor Val.St.dt`, `PR Vendor Val.End.dt`, `PR Curr`, `PR Itm Qty`, "
				        		+ "`PR Line Item Tot Val`, `PR Line Item Tot Val2`, `PR Vendor Contr.No`, `Local Curr`, `GR Foreign Curr`, `IR Curr`, `Vendor Cat`,"
				        		+ " `VendCatVal`, `Bee Score`, `Bee Rep`, `Bee Reg.Exp.dt`, `Black Own.ship`, `Black Own.ship val`, `Black Own Score`, "
				        		+ "`Black fem own.ship`, `Val add stat`, `Enterprise Dev`, `Enterprise Type`, `Enterprise Type Val`, `Turnover`, `Cr Check`, "
				        		+ "`SARS Check`, `Reg Check`, `Bank Check`, `Mngmt Ctrl Score`, `Emp Equity Score`, `Skills Dev Score`, `Pref Procure Score`,"
				        		+ " `Enterprise Dev Score`, `Socio Eco Dev Score`, `Technology Score`, `Quality Score`, `Response Score`, `Delivery Score`, "
				        		+ "`Cost Score`, `Environment Score`, `Release group`, `Release Strategy`, `Strategy Code`, `Release status`, `Rel/Blk`, `Rel Ind Desc`,"
				        		+ " `Rel Not Comp Eff`, `Release Strategy des`, `Inco Term1 - Hdr`, `Inco Term2 - Hdr`, `Inco Term1 - Itm`, `Inco Term2 - Itm`,"
				        		+ " `1st Rel by`, `2nd Rel by`, `3rd Rel by`, `Hdr Forward contract`, `Post Ind`, `Header Text`, `Stock Res. Number`, `Stock Expiry Date`,"
				        		+ " `id`)"
				        		+ " VALUES "
				        		+ "(?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"        	
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"//10
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?," //19
				        		+ "?,?,?,?,?,?,?,?," //8
				        		+ "?" //for ID
				        		+ ")";
				        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
				        int iAdditional=0;
				       
				        iAdditional=list.size()-198;
				        int j=0;
				        for (int i=1; i<=list.size(); i++) {
				        	String sValue = list.get(i-1);
				        	if (iAdditional==0) {
					        	switch (i) {
					        	
					        	case 15 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//Float
					        		break;
					        	case 17 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//Float
					        		break;
					        	case 19 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	
					        	case 20 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	
					        	case 21 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	
					        	case 50 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;
					        	case 88 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	
					        	case 90 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	
					        	case 91 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;		
					        	case 95 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	
					        	case 98 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	  
					        	case 99 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;		
					        	case 100 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;    
					        	case 102 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;		
					        	case 103 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;
					        	case 104 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	  
					        	case 105 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;		
					        	case 106 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;
					        	case 111 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	
					        	case 113 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	
					        	case 119 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;		
					        	case 120 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;     
					        	case 142 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;	
					        	case 143 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;		
					        	case 144 : //Float
					                preparedStmt.setFloat(i,getFloatValue(sValue));//float
					        		break;            		
					        	default: 
					        		preparedStmt.setString(i,sValue);
					        		break;
					        	}
				        	
				        	} else {
				        		j++;
				        		switch (i) {
					        	case 14:
					        		j--;
					        		break;
					        	case 16 : //Float
					        		preparedStmt.setFloat(j,getFloatValue(sValue));//Float
					        		break;
					        	case 18 : //Float
					        		preparedStmt.setFloat(j,getFloatValue(sValue));//Float
					        		break;
					        	case 20 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	
					        	case 21 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	
					        	case 22 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	
					        	case 51 : //Float
					        		preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;
					        	case 89 : //Float
					        		preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	
					        	case 91 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	
					        	case 92 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;		
					        	case 96 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	
					        	case 99 : //Float
					        		preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	  
					        	case 100 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;		
					        	case 101 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;    
					        	case 103 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;		
					        	case 104 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;
					        	case 105 : //Float
					        		preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	  
					        	case 106 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;		
					        	case 107 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;
					        	case 112 : //Float
					        		preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	
					        	case 114 : //Float
					        		preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	
					        	case 120 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;		
					        	case 121 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;     
					        	case 143 : //Float
					        		preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;	
					        	case 144 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;		
					        	case 145 : //Float
					                preparedStmt.setFloat(j,getFloatValue(sValue));//float
					        		break;            		
					        	default: 
					        		preparedStmt.setString(j,sValue);
					        		break;
					        	}
				        		
				        	}
				        	
				        }
				        
				       
				        preparedStmt.setString(list.size(),sID);
				        
				        
				        
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
