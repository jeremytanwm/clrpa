import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class contract {
  public String id = "";
  
  public String idcontract = "";
  
  public String idclient = "";
  
  public String idproject = "";
  
  public String idpm = "";
  
  public String contractnumber = "";
  
  public String clientname = "";
  
  public String status = "";
  
  public String billingoffice = "";
  
  public String billable = "";
  
  public String createdby = "";
  
  public String createdon = "";
  
  public String updatedby = "";
  
  public String updatedon = "";
  
  public String contractservicevalue = "";
  
  public String revenueRecognized = "";
  
  public String costRecognized = "";
  
  public String plannedCost = "";
  
  public String closeddate = "";
  
  public String currency = "";
  
  public String getIdpm() {
    return this.idpm;
  }
  
  public void setIdpm(String idpm) {
    this.idpm = idpm;
  }
  
  public String getCurrency() {
    return this.currency;
  }
  
  public void setCurrency(String currency) {
    this.currency = currency;
  }
	
	public static String dbName="c1ppms";
	
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public String getContractservicevalue() {
    if (!this.contractservicevalue.isEmpty())
      this.contractservicevalue = this.contractservicevalue.replaceAll(",", ""); 
    return this.contractservicevalue;
  }
  
  public void setContractservicevalue(String contractservicevalue) {
    this.contractservicevalue = contractservicevalue;
  }
  
  public String getRevenueRecognized() {
    if (!this.revenueRecognized.isEmpty())
      this.revenueRecognized = this.revenueRecognized.replaceAll(",", ""); 
    return this.revenueRecognized;
  }
  
  public void setRevenueRecognized(String revenueRecognized) {
    this.revenueRecognized = revenueRecognized;
  }
  
  public String getCostRecognized() {
    if (!this.costRecognized.isEmpty())
      this.costRecognized = this.costRecognized.replaceAll(",", ""); 
    return this.costRecognized;
  }
  
  public void setCostRecognized(String costRecognized) {
    this.costRecognized = costRecognized;
  }
  
  public String getPlannedCost() {
    if (!this.plannedCost.isEmpty())
      this.plannedCost = this.plannedCost.replaceAll(",", ""); 
    return this.plannedCost;
  }
  
  public void setPlannedCost(String plannedCost) {
    this.plannedCost = plannedCost;
  }
  
  public String getCloseddate() {
    return this.closeddate;
  }
  
  public void setCloseddate(String closeddate) {
    this.closeddate = closeddate;
  }
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getIdcontract() {
    return this.idcontract;
  }
  
  public void setIdcontract(String idcontract) {
    this.idcontract = idcontract;
  }
  
  public String getIdclient() {
    return this.idclient;
  }
  
  public void setIdclient(String idclient) {
    this.idclient = idclient;
  }
  
  public String getIdproject() {
    return this.idproject;
  }
  
  public void setIdproject(String idproject) {
    this.idproject = idproject;
  }
  
  public String getContractnumber() {
    return this.contractnumber;
  }
  
  public void setContractnumber(String contractnumber) {
    this.contractnumber = contractnumber;
  }
  
  public String getClientname() {
    return this.clientname;
  }
  
  public void setClientname(String clientname) {
    this.clientname = clientname;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
  
  public String getBillingoffice() {
    return this.billingoffice;
  }
  
  public void setBillingoffice(String billingoffice) {
    this.billingoffice = billingoffice;
  }
  
  public String getBillable() {
    return this.billable;
  }
  
  public void setBillable(String billable) {
    this.billable = billable;
  }
  
  public String getCreatedby() {
    return this.createdby;
  }
  
  public void setCreatedby(String createdby) {
    this.createdby = createdby;
  }
  
  public String getCreatedon() {
    return this.createdon;
  }
  
  public void setCreatedon(String createdon) {
    this.createdon = createdon;
  }
  
  public String getUpdatedby() {
    return this.updatedby;
  }
  
  public void setUpdatedby(String updatedby) {
    this.updatedby = updatedby;
  }
  
  public String getUpdatedon() {
    return this.updatedon;
  }
  
  public void setUpdatedon(String updatedon) {
    this.updatedon = updatedon;
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
   
    if (temp.equals(""))
      temp = "9999-12-31"; 
    if (temp.isEmpty())
      temp = "9999-12-31"; 
    return temp;
  }
  
  public void dbLoadContract() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    PreparedStatement preparedStmt = null;
    try {
      String sSelect = "Select `id` from `contract` where `idcontract`=\"" + getIdcontract() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {
        sQuery = "UPDATE `contract` SET `idcontract`=?,`idclient`=?,`idproject`=?,`contractnumber`=?,`clientname`=?,`status`=?,`billingoffice`=?,`billable`=?,`createdby`=?,`createdon`=?,`updatedby`=?,`updatedon`=? WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdcontract());
        preparedStmt.setString(2, getIdclient());
        preparedStmt.setString(3, getIdproject());
        preparedStmt.setString(4, getContractnumber());
        preparedStmt.setString(5, getClientname());
        preparedStmt.setString(6, getStatus());
        preparedStmt.setString(7, getBillingoffice());
        preparedStmt.setString(8, getBillable());
        preparedStmt.setString(9, getCreatedby());
        preparedStmt.setString(10, setMysqDate(getCreatedon()));
        preparedStmt.setString(11, getUpdatedby());
        preparedStmt.setString(12, setMysqDate(getUpdatedon()));
        preparedStmt.setInt(13, getIntValue((new StringBuilder(String.valueOf(rs.getInt(1)))).toString()));
        preparedStmt.execute();
      } else {
        sQuery = "INSERT INTO `contract`( `idcontract`,`idclient`,`idproject`,`contractnumber`,`clientname`,`status`,`billingoffice`,`billable`,`createdby`,`createdon`,`updatedby`,`updatedon`)VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdcontract());
        preparedStmt.setString(2, getIdclient());
        preparedStmt.setString(3, getIdproject());
        preparedStmt.setString(4, getContractnumber());
        preparedStmt.setString(5, getClientname());
        preparedStmt.setString(6, getStatus());
        preparedStmt.setString(7, getBillingoffice());
        preparedStmt.setString(8, getBillable());
        preparedStmt.setString(9, getCreatedby());
        preparedStmt.setString(10, setMysqDate(getCreatedon()));
        preparedStmt.setString(11, getUpdatedby());
        preparedStmt.setString(12, setMysqDate(getUpdatedon()));
        preparedStmt.execute();
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR: LOAD Contract:" + sQuery);
      System.out.println("ERROR: LOAD Contract:" + e.getMessage());
    } 
  }
  
  public void dbUpdateContract() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    PreparedStatement preparedStmt = null;
    try {
      String sSelect = "Select `id` from `contract` where `idcontract`=\"" + getIdcontract() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {
        sQuery = "UPDATE `contract` SET `status`=?,`contractservicevalue`=?,`RevenueRecognized`=?,`CostRecognized`=?,`PlannedCost`=?,`idproject`=?, `currency`=?, `idpm`=?,`closeddate`=? WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getStatus());
        preparedStmt.setFloat(2, getFloatValue(getContractservicevalue()).floatValue());
        preparedStmt.setFloat(3, getFloatValue(getRevenueRecognized()).floatValue());
        preparedStmt.setFloat(4, getFloatValue(getCostRecognized()).floatValue());
        preparedStmt.setFloat(5, getFloatValue(getPlannedCost()).floatValue());
        preparedStmt.setString(6, getIdproject());
        preparedStmt.setString(7, getCurrency());
        preparedStmt.setString(8, getIdpm());
        preparedStmt.setString(9, setMysqDate(getCloseddate()));
        preparedStmt.setInt(10, getIntValue((new StringBuilder(String.valueOf(rs.getInt(1)))).toString()));
        preparedStmt.execute();
        System.out.println("OK: Update Contract:" + preparedStmt.toString());
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR: Update Contract:" + sQuery);
      System.out.println("ERROR: Update Contract:" + e.getMessage());
    } 
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


/* Location:              D:\Rpa\rpappms\!\contract.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */