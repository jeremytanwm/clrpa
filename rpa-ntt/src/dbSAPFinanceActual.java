import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * @author sidhi
 *
 */
public class dbSAPFinanceActual {
	
	
	public static String dbName="c1ppms";
	public static String dbusername = "dbadmin";
	  
	  public static String dbpassword = "neqe37";
	  
      private static HashMap<String, Integer> map = new HashMap<String, Integer>();
	  
	  public String YearMonth = "";
		public String ClearingDocument = "";
		public String DocumentNumber = "";
		public String Account = "";
		public String PurchasingDocument = "";
		public String ProfitCenter = "";
		public String CostCenter = "";
		public String CustomerName = "";
		public String VendorName = "";
		public String Tradingpartner = "";
		public String TaxCode = "";
		public String Text = "";
		public String DocumentDate = "";
		public String PostingDate = "";
		public String Documentcurrency = "";
		public String Amountindoccurr = "";
		public String LocalCurrency = "";
		public String AmountinLC = "";
		public String UserName = "";
		public String PCCode= "";
		public String CompanyCode = "";
	  
		  public  int iYearMonth = -1;
					public  int iClearingDocument = -1;
					public  int iDocumentNumber = -1;
					public  int iAccount = -1;
					public  int iPurchasingDocument = -1;
					public  int iProfitCenter = -1;
					public  int iCostCenter = -1;
					public  int iCustomerName = -1;
					public  int iVendorName = -1;
					public  int iTradingpartner = -1;
					public  int iTaxCode = -1;
					public  int iText = -1;
					public  int iDocumentDate = -1;
					public  int iPostingDate = -1;
					public  int iDocumentcurrency = -1;
					public  int iAmountindoccurr = -1;
					public  int iLocalCurrency = -1;
					public  int iAmountinLC = -1;
					public  int iUserName = -1;
		
		
	 public String getPCCode() {
						return PCCode;
					}

					public void setPCCode(String pCCode) {
						PCCode = pCCode;
					}

	public static HashMap<String, Integer> getMap() {
						return map;
					}

					public static void setMap(HashMap<String, Integer> map) {
						dbSAPFinanceActual.map = map;
					}

					public String getCompanyCode() {
						return CompanyCode;
					}

					public void setCompanyCode(String companyCode) {
						CompanyCode = companyCode;
					}

	public int getiYearMonth() {
						return iYearMonth;
					}

					public void setiYearMonth(int iYearMonth) {
						this.iYearMonth = iYearMonth;
					}

					public int getiClearingDocument() {
						return iClearingDocument;
					}

					public void setiClearingDocument(int iClearingDocument) {
						this.iClearingDocument = iClearingDocument;
					}

					public int getiDocumentNumber() {
						return iDocumentNumber;
					}

					public void setiDocumentNumber(int iDocumentNumber) {
						this.iDocumentNumber = iDocumentNumber;
					}

					public int getiAccount() {
						return iAccount;
					}

					public void setiAccount(int iAccount) {
						this.iAccount = iAccount;
					}

					public int getiPurchasingDocument() {
						return iPurchasingDocument;
					}

					public void setiPurchasingDocument(int iPurchasingDocument) {
						this.iPurchasingDocument = iPurchasingDocument;
					}

					public int getiProfitCenter() {
						return iProfitCenter;
					}

					public void setiProfitCenter(int iProfitCenter) {
						this.iProfitCenter = iProfitCenter;
					}

					public int getiCostCenter() {
						return iCostCenter;
					}

					public void setiCostCenter(int iCostCenter) {
						this.iCostCenter = iCostCenter;
					}

					public int getiCustomerName() {
						return iCustomerName;
					}

					public void setiCustomerName(int iCustomerName) {
						this.iCustomerName = iCustomerName;
					}

					public int getiVendorName() {
						return iVendorName;
					}

					public void setiVendorName(int iVendorName) {
						this.iVendorName = iVendorName;
					}

					public int getiTradingpartner() {
						return iTradingpartner;
					}

					public void setiTradingpartner(int iTradingpartner) {
						this.iTradingpartner = iTradingpartner;
					}

					public int getiTaxCode() {
						return iTaxCode;
					}

					public void setiTaxCode(int iTaxCode) {
						this.iTaxCode = iTaxCode;
					}

					public int getiText() {
						return iText;
					}

					public void setiText(int iText) {
						this.iText = iText;
					}

					public int getiDocumentDate() {
						return iDocumentDate;
					}

					public void setiDocumentDate(int iDocumentDate) {
						this.iDocumentDate = iDocumentDate;
					}

					public int getiPostingDate() {
						return iPostingDate;
					}

					public void setiPostingDate(int iPostingDate) {
						this.iPostingDate = iPostingDate;
					}

					public int getiDocumentcurrency() {
						return iDocumentcurrency;
					}

					public void setiDocumentcurrency(int iDocumentcurrency) {
						this.iDocumentcurrency = iDocumentcurrency;
					}

					public int getiAmountindoccurr() {
						return iAmountindoccurr;
					}

					public void setiAmountindoccurr(int iAmountindoccurr) {
						this.iAmountindoccurr = iAmountindoccurr;
					}

					public int getiLocalCurrency() {
						return iLocalCurrency;
					}

					public void setiLocalCurrency(int iLocalCurrency) {
						this.iLocalCurrency = iLocalCurrency;
					}

					public int getiAmountinLC() {
						return iAmountinLC;
					}

					public void setiAmountinLC(int iAmountinLC) {
						this.iAmountinLC = iAmountinLC;
					}

					public int getiUserName() {
						return iUserName;
					}

					public void setiUserName(int iUserName) {
						this.iUserName = iUserName;
					}

	public String getYearMonth() {
			return YearMonth;
		}

		public void setYearMonth(String yearMonth) {
			YearMonth = yearMonth;
		}

		public String getClearingDocument() {
			return ClearingDocument;
		}

		public void setClearingDocument(String clearingDocument) {
			ClearingDocument = clearingDocument;
		}

		public String getDocumentNumber() {
			return DocumentNumber;
		}

		public void setDocumentNumber(String documentNumber) {
			DocumentNumber = documentNumber;
		}

		public String getAccount() {
			return Account;
		}

		public void setAccount(String account) {
			Account = account;
		}

		public String getPurchasingDocument() {
			return PurchasingDocument;
		}

		public void setPurchasingDocument(String purchasingDocument) {
			PurchasingDocument = purchasingDocument;
		}

		public String getProfitCenter() {
			return ProfitCenter;
		}

		public void setProfitCenter(String profitCenter) {
			ProfitCenter = profitCenter;
		}

		public String getCostCenter() {
			return CostCenter;
		}

		public void setCostCenter(String costCenter) {
			CostCenter = costCenter;
		}

		public String getCustomerName() {
			return CustomerName;
		}

		public void setCustomerName(String customerName) {
			CustomerName = customerName;
		}

		public String getVendorName() {
			return VendorName;
		}

		public void setVendorName(String vendorName) {
			VendorName = vendorName;
		}

		public String getTradingpartner() {
			return Tradingpartner;
		}

		public void setTradingpartner(String tradingpartner) {
			Tradingpartner = tradingpartner;
		}

		public String getTaxCode() {
			return TaxCode;
		}

		public void setTaxCode(String taxCode) {
			TaxCode = taxCode;
		}

		public String getText() {
			return Text;
		}

		public void setText(String text) {
			Text = text;
		}

		public String getDocumentDate() {
			return DocumentDate;
		}

		public void setDocumentDate(String documentDate) {
			DocumentDate = documentDate;
		}

		public String getPostingDate() {
			return PostingDate;
		}

		public void setPostingDate(String postingDate) {
			PostingDate = postingDate;
		}

		public String getDocumentcurrency() {
			return Documentcurrency;
		}

		public void setDocumentcurrency(String documentcurrency) {
			Documentcurrency = documentcurrency;
		}

		public String getAmountindoccurr() {
			return Amountindoccurr;
		}

		public void setAmountindoccurr(String amountindoccurr) {
			Amountindoccurr = amountindoccurr;
		}

		public String getLocalCurrency() {
			return LocalCurrency;
		}

		public void setLocalCurrency(String localCurrency) {
			LocalCurrency = localCurrency;
		}

		public String getAmountinLC() {
			return AmountinLC;
		}

		public void setAmountinLC(String amountinLC) {
			AmountinLC = amountinLC;
		}

		public String getUserName() {
			return UserName;
		}

		public void setUserName(String userName) {
			UserName = userName;
		}

		public ArrayList<String> getList() {
			return list;
		}

		public void setList(ArrayList<String> list) {
			this.list = list;
		}

		public DatabaseManager getDb() {
			return db;
		}

		public void setDb(DatabaseManager db) {
			this.db = db;
		}

		public Connection getConn() {
			return conn;
		}

		public void setConn(Connection conn) {
			this.conn = conn;
		}


	public  ArrayList<String> list = new ArrayList<String>();
	 private DatabaseManager db = null;
	 private   Connection conn = null;

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		dbSAPFinanceActual.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		dbSAPFinanceActual.dbpassword = dbpassword;
	}


  
	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		dbSAPFinanceActual.dbName = dbName;
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
  public dbSAPFinanceActual() {
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
  
  public boolean initIndex(HashMap<String, Integer> imap) {
	  map=imap;
	  boolean rslt=true;
	    
	    //load the elements
	    
	  	iYearMonth = map.getOrDefault("Year/month", -1);
	    
	    iClearingDocument =  map.getOrDefault("Clearing Document", -1);
	    		 iDocumentNumber =  map.getOrDefault("Document Number", -1);
	    		 iAccount =  map.getOrDefault("Account", -1);
	    		 iPurchasingDocument =  map.getOrDefault("Purchasing Document", -1);
	    		 iProfitCenter =  map.getOrDefault("Profit Center", -1);
	    		 iCostCenter =  map.getOrDefault("Cost Center", -1);
	    		 iCustomerName = map.getOrDefault("Customer Name", -1);
	    		 iVendorName =  map.getOrDefault("Vendor Name", -1);
	    		 iTradingpartner =  map.getOrDefault("Trading partner", -1);
	    		 iTaxCode =  map.getOrDefault("Tax Code", -1);
	    		 iText =  map.getOrDefault("Text", -1);
	    		 iDocumentDate = map.getOrDefault("Document Date", -1);
	    		 iPostingDate =  map.getOrDefault("Posting Date", -1);
	    		 iDocumentcurrency =  map.getOrDefault("Document Currency", -1);
	    		 iAmountindoccurr =  map.getOrDefault("Amount in doc. curr.", -1);
	    		 iLocalCurrency =  map.getOrDefault("local Currency", -1);
	    		 iAmountinLC =  map.getOrDefault("Amount in local currency", -1);
	    		 iUserName =  map.getOrDefault("User Name", -1);
	    		 
	    return rslt;
	    		 
  }
  
  public boolean initValue() {
	
	  boolean rslt=true;
	    
	  for (int i=0; i<list.size();i++) {
	    //load the elements
		if (i==iYearMonth)  YearMonth= list.get(i);
		if (i==iClearingDocument)  ClearingDocument= list.get(i);
		if (i==iDocumentNumber)  DocumentNumber= list.get(i);
		if (i==iAccount)  Account= list.get(i);
		if (i==iPurchasingDocument)  PurchasingDocument= list.get(i);
		if (i==iProfitCenter)  ProfitCenter= list.get(i);
		if (i==iCostCenter)  CostCenter= list.get(i);
		if (i==iCustomerName)  CustomerName= list.get(i);
		if (i==iVendorName)  VendorName= list.get(i);
		if (i==iTradingpartner)  Tradingpartner= list.get(i);
		if (i==iTaxCode)  TaxCode= list.get(i);
		if (i==iText)  Text= list.get(i);
		if (i==iDocumentDate)  DocumentDate= list.get(i);
		if (i==iPostingDate)  PostingDate= list.get(i);
		if (i==iDocumentcurrency)  Documentcurrency= list.get(i);
		if (i==iAmountindoccurr)  Amountindoccurr= list.get(i);
		if (i==iLocalCurrency)  LocalCurrency= list.get(i);
		if (i==iAmountinLC)  AmountinLC= list.get(i);
		if (i==iUserName) UserName= list.get(i);
	  }
	    return rslt;
	    		 
  }
  public boolean Load() {
	boolean rslt=true;
   
    String sQuery = "";
    String sStmt="";
    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
    PreparedStatement preparedStmt = null;
    
    initValue();
    

    //ID = yearmonth + documentnumber + account+ profitcenter + costcenter + documentdate + postingdate + amountindocurr
    String sID= this.YearMonth + printIDString(this.DocumentNumber) + printIDString(this.Account)
    + printIDString(this.ProfitCenter) + printIDString(this.CostCenter)
    + printIDString(this.DocumentDate) + printIDString(this.PostingDate)
    + printIDString(this.Amountindoccurr);
   /*
    String sID=list.get(1)+printIDString(list.get(3))+printIDString(list.get(4))
    +printIDString(list.get(6))+printIDString(list.get(7))
    +printIDString(list.get(13))+printIDString(list.get(14))+printIDString(list.get(16));
    */
    sID=sID.replaceAll("['\"\\\\]", "");
    
    try {
    	
    	if (conn==null) {
    		conn = (Connection)db.getConnection();
    	}
    	if (conn.isClosed()) {
    		conn = (Connection)db.getConnection();
    	}
    	
    	 // String sSelect = "Select `id` from `sap-finance-actual` where `id`='" + sID+ "'";
         Statement st = (Statement)conn.createStatement();
        
         // if (rs.next()) {    	  
        //	  System.out.println("Duplicate Record for ID= "+sID);
         // } else {
     
				        sQuery = "INSERT INTO `sap-finance-actual`(`CreatedOn`,"
				        		+ "`Year/month`,"
				        		+ "`Clearing Document`,"
				        		+ "`Document Number`,"
				        		+ "`Account`,"
				        		+ "`Purchasing Document`,"
				        		+ "`Profit Center`,"
				        		+ "`Cost Center`,"
				        		+ "`Customer Name`,"
				        		+ "`Vendor Name`,"
				        		+ "`Trading partner`,"
				        		+ "`Tax Code`,"
				        		+ "`Text`,"
				        		+ "`Document Date`,"
				        		+ "`Posting Date`,"
				        		+ "`Document currency`,"
				        		+ "`Amount in doc. curr.`,"
				        		+ "`Local Currency`,"
				        		+ "`Amount in LC`,"
				        		+ "`User Name`,"
				        		+ "`CompanyCode`,"
				        		+ "`PCMenu`,"
				        		+ "`UpdatedOn`)"
				        		+ " VALUES "
				        		+ "(?,?,?,?,?,?,?,?,?,?,"
				        		+ "?,?,?,?,?,?,?,?,?,?,"
				        		
				        		+ "?,?,?"
				        		+ ")";
				        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
				        preparedStmt.setTimestamp(1,updatedAt);
				        preparedStmt.setString(2,this.getYearMonth());
				        preparedStmt.setString(3,this.getClearingDocument());
				        preparedStmt.setString(4,this.getDocumentNumber());
				        preparedStmt.setString(5,this.getAccount());
				        preparedStmt.setString(6,this.getPurchasingDocument());
				        preparedStmt.setString(7,this.getProfitCenter());
				        preparedStmt.setString(8,this.getCostCenter());
				        preparedStmt.setString(9,this.getCustomerName());
				        preparedStmt.setString(10,this.getVendorName());
				        preparedStmt.setString(11,this.getTradingpartner());
				        preparedStmt.setString(12,this.getTaxCode());
				        preparedStmt.setString(13,this.getText());
				        preparedStmt.setString(14,this.getDocumentDate());
				        preparedStmt.setString(15,this.getPostingDate());
				        preparedStmt.setString(16,this.getDocumentcurrency());
				        preparedStmt.setFloat(17,getFloatValue(this.getAmountindoccurr()));
				        preparedStmt.setString(18,this.getLocalCurrency());
				        preparedStmt.setFloat(19,getFloatValue(this.getAmountinLC()));
				        preparedStmt.setString(20,this.getUserName());
				        preparedStmt.setString(21,this.getCompanyCode());
				        preparedStmt.setString(22,this.getPCCode());
				        preparedStmt.setTimestamp(23,updatedAt);
				        
				        /*
				
				        for (int i=1; i<=list.size(); i++) {
				        	String sValue = list.get(i-1);
				        	
					        	switch (i) {
					        	case 1 :
					        		//preparedStmt.setString(i,sID);
					        		preparedStmt.setTimestamp(i,updatedAt);
					        		break;
					        	case 17 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//Float
					        		break;
					        	case 19 : //Float
					        		preparedStmt.setFloat(i,getFloatValue(sValue));//Float
					        		break;
					        		
					        	default: 
					        		preparedStmt.setString(i,sValue);
					        		break;
					        	}
				        	
				        	
				        		
				        	
				        	
				        }
				        
				       
				        //preparedStmt.setString(list.size(),sID);
				        
				     
				        preparedStmt.setTimestamp(23,updatedAt);
				        
				        */
				        
				        sStmt= preparedStmt.toString();
				        preparedStmt.executeUpdate();
				        preparedStmt.close();        
				        //System.out.println("INSERT Record for ID= "+sID);
      
          //}
  
     st.close();
  
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
