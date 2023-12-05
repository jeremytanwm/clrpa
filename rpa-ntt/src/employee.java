import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class employee {
  public String getIdemployee() {
    return this.idemployee;
  }
  
  public void setIdemployee(String idemployee) {
    this.idemployee = idemployee;
  }
  
  public String getEid() {
    return this.eid;
  }
  
  public void setEid(String eid) {
    this.eid = eid;
  }
  
  public String getEname() {
    return this.ename;
  }
  
  public void setEname(String ename) {
    if (!ename.isEmpty())
      ename = ename.replaceAll("\\(online\\)", ""); 
    this.ename = ename;
  }
  
  public String getEmail() {
    return this.email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getLicensetype() {
    return this.licensetype;
  }
  
  public void setLicensetype(String licensetype) {
    this.licensetype = licensetype;
  }
  
  public String getState() {
    return this.state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public String getCountry() {
    return this.country;
  }
  
  public void setCountry(String country) {
    this.country = country;
  }
  
  public String getWorkgroup() {
    return this.workgroup;
  }
  
  public void setWorkgroup(String workgroup) {
    this.workgroup = workgroup;
  }
  
  public String getReportsto() {
    return this.reportsto;
  }
  
  public void setReportsto(String reportsto) {
    this.reportsto = reportsto;
  }
  
  public String getBillingoffice() {
    return this.billingoffice;
  }
  
  public void setBillingoffice(String billingoffice) {
    this.billingoffice = billingoffice;
  }
  
  public String getBillingrole() {
    return this.billingrole;
  }
  
  public void setBillingrole(String billingrole) {
    this.billingrole = billingrole;
  }
  
  public String getDdjfrole() {
    return this.ddjfrole;
  }
  
  public void setDdjfrole(String ddjfrole) {
    this.ddjfrole = ddjfrole;
  }
  
  public String getSapactioncode() {
    return this.sapactioncode;
  }
  
  public void setSapactioncode(String sapactioncode) {
    this.sapactioncode = sapactioncode;
  }
  
  public String getSapenddate() {
    return this.sapenddate;
  }
  
  public void setSapenddate(String sapenddate) {
    this.sapenddate = sapenddate;
  }
  
  public String getDdjffamily() {
    return this.ddjffamily;
  }
  
  public void setDdjffamily(String ddjffamily) {
    this.ddjffamily = ddjffamily;
  }
  
  public String getOvertimeactivitytype() {
    return this.overtimeactivitytype;
  }
  
  public void setOvertimeactivitytype(String overtimeactivitytype) {
    this.overtimeactivitytype = overtimeactivitytype;
  }
  
  public String getDoubletimeactivitytype() {
    return this.doubletimeactivitytype;
  }
  
  public void setDoubletimeactivitytype(String doubletimeactivitytype) {
    this.doubletimeactivitytype = doubletimeactivitytype;
  }
  
  public String getBillablehours() {
    return this.billablehours;
  }
  
  public void setBillablehours(String billablehours) {
    if (billablehours == null)
      billablehours = "0"; 
    if (billablehours.equals(""))
      billablehours = "0"; 
    if (billablehours.isEmpty())
      billablehours = "0"; 
    try {
      int i = Integer.parseInt(billablehours);
    } catch (Exception e) {
      billablehours = "0";
    } 
    this.billablehours = billablehours;
  }
  
  public String getStandardhours() {
    return this.standardhours;
  }
  
  public void setStandardhours(String standardhours) {
    if (standardhours == null)
      standardhours = "0"; 
    if (standardhours.equals(""))
      standardhours = "0"; 
    if (standardhours.isEmpty())
      standardhours = "0"; 
    try {
      int i = Integer.parseInt(standardhours);
    } catch (Exception e) {
      standardhours = "0";
    } 
    this.standardhours = standardhours;
  }
  
  public String getActivitytype() {
    return this.activitytype;
  }
  
  public void setActivitytype(String activitytype) {
    this.activitytype = activitytype;
  }
  
  public String getEffectivedate() {
    return this.effectivedate;
  }
  
  public void setEffectivedate(String effectivedate) {
    this.effectivedate = effectivedate;
  }
  
  public String getSapemployeeid() {
    return this.sapemployeeid;
  }
  
  public void setSapemployeeid(String sapemployeeid) {
    this.sapemployeeid = sapemployeeid;
  }
  
  public String getSapstartdate() {
    return this.sapstartdate;
  }
  
  public void setSapstartdate(String sapstartdate) {
    this.sapstartdate = sapstartdate;
  }
  
  private String idemployee = "";
  
  private String eid = "";
  
  private String ename = "";
  
  private String email = "";
  
  private String licensetype = "";
  
  private String state = "";
  
  private String country = "";
  
  private String workgroup = "";
  
  private String reportsto = "";
  
  private String reporttoid = "";
  
  public String getReporttoid() {
    return this.reporttoid;
  }
  
  public void setReporttoid(String reporttoid) {
    this.reporttoid = reporttoid;
  }
  
  private String billingoffice = "";
  
  private String billingrole = "";
  
  private String ddjfrole = "";
  
  private String sapactioncode = "";
  
  private String sapenddate = "";
  
  private String ddjffamily = "";
  
  private String overtimeactivitytype = "";
  
  private String doubletimeactivitytype = "";
  
  private String billablehours = "";
  
  private String standardhours = "";
  
  private String activitytype = "";
  
  private String effectivedate = "";
  
  private String sapemployeeid = "";
  
  private String sapstartdate = "";
  
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
	public static String dbName="c1ppms";
	
  public static void main(String[] args) {
    String s = "B,P,S";
    String[] aHealth = s.split(",");
    if (aHealth.length > 0)
      for (int i = 0; i < aHealth.length; i++)
        System.out.println(aHealth[i]);  
  }
  
  public static void employeeUpdateLongName() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    Connection conn2 = (Connection)db.getConnection();
    Connection conn3 = (Connection)db.getConnection();
    String query = "SELECT * from workday";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String id = "";
      int i = 1;
      while (rs.next()) {
        id = (new StringBuilder(String.valueOf(rs.getInt("id")))).toString();
        Statement st2 = (Statement)conn2.createStatement();
        String sEmployeName = "";
        String sManagerName = "";
        String query2 = "SELECT * from employee where LOWER(`ename`) like '%" + rs.getString("employeename").toLowerCase() + "%'";
        String query2a = "SELECT * from employee where LOWER(`ename`) like '%" + rs.getString("managername").toLowerCase() + "%'";
        ResultSet rs2 = (ResultSet)st2.executeQuery(query2);
        if (rs2.next())
          sEmployeName = rs2.getString("ename"); 
        rs2 = (ResultSet)st2.executeQuery(query2a);
        if (rs2.next())
          sManagerName = rs2.getString("ename"); 
        Statement st3 = (Statement)conn3.createStatement();
        String query3 = "";
        String sFilter = "";
        if (!sEmployeName.isEmpty())
          sFilter = "`employeename`=\"" + sEmployeName + "\""; 
        if (!sManagerName.isEmpty()) {
          if (!sFilter.isEmpty())
            sFilter = String.valueOf(sFilter) + ","; 
          sFilter = String.valueOf(sFilter) + "`managername`=\"" + sManagerName + "\" ";
        } 
        if (!sFilter.isEmpty()) {
          query3 = "update workday set " + sFilter + " where `id`=" + id;
          st3.execute(query3);
          st3.close();
          System.out.println(String.valueOf(rs.getString("employeename").toLowerCase()) + ":" + query3);
        } 
        st2.close();
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
  }
  
  public static void employeeRateRefresh() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    Connection conn2 = (Connection)db.getConnection();
    Connection conn3 = (Connection)db.getConnection();
    String query = "SELECT * from employee";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String eid = "";
      int i = 1;
      while (rs.next()) {
        eid = (new StringBuilder(String.valueOf(rs.getInt("eid")))).toString();
        Statement st2 = (Statement)conn2.createStatement();
        String query2 = "SELECT * from ratecard where LOWER(ename)='" + rs.getString("ename").toLowerCase() + "'";
        ResultSet rs2 = (ResultSet)st2.executeQuery(query2);
        while (rs2.next()) {
          Statement st3 = (Statement)conn3.createStatement();
          String query3 = "update employee set `hourlycost`='" + rs2.getString("hourlycost") + "', `dailycost`='" + rs2.getString("dailycost") + "' where `eid`=" + eid;
          st3.execute(query3);
          st3.close();
          System.out.println(String.valueOf(rs.getString("ename").toLowerCase()) + ":" + query3);
        } 
        rs2.close();
        st2.close();
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
  }
  
  public static String queryIDEmployee(String sEmployeeName) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT * from employee where `ename`=\"" + sEmployeeName + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String idemployee = "";
      int i = 1;
      if (rs.next()) {
        idemployee = rs.getString("idemployee");
        sRslt = idemployee;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return sRslt;
  }
  
  public static String queryIDEmployeeByEmail(String sEmail) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `idemployee` from `employee` where `email`=\"" + sEmail + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      if (rs.next())
        sRslt = rs.getString("idemployee"); 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return sRslt;
  }
  
  public static String queryEnameByEmail(String sEmail) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `ename` from `employee` where `email`=\"" + sEmail + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      if (rs.next())
        sRslt = rs.getString("ename"); 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return sRslt;
  }
  
  public static void updateEmployeeByEmail(String sEmail, String sMobile, String sReportToID, String sReportsTo) {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    PreparedStatement preparedStmt = null;
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      sQuery = "UPDATE `employee` SET `mobilenumber`=?,`reporttoid`=?,`reportsto`=?, `updatedon`=?  WHERE `email`=?";
      preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
      preparedStmt.setString(1, sMobile);
      preparedStmt.setString(2, sReportToID);
      preparedStmt.setString(3, sReportsTo);
      preparedStmt.setTimestamp(4, updatedAt);
      preparedStmt.setString(5, sEmail);
      System.out.println(preparedStmt.toString());
      preparedStmt.execute();
      preparedStmt.close();
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
  
  public void dbUpdateEmployee() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    if (this.billablehours.length() == 0)
      this.billablehours = "0"; 
    if (this.standardhours.length() == 0)
      this.standardhours = "0"; 
    if (this.sapenddate.length() == 0)
      this.sapenddate = "2099-12-31"; 
    if (this.effectivedate.length() == 0)
      this.effectivedate = "1900-01-01"; 
    if (this.sapstartdate.length() == 0)
      this.sapstartdate = "1900-01-01"; 
    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
    try {
      Statement st2 = (Statement)conn.createStatement();
      if (!this.eid.contentEquals("0")) {
        sQuery = "UPDATE `employee` SET `idemployee`=\"" + 
          this.idemployee + "\",`ename`=\"" + this.ename + "\",`email`=\"" + this.email + "\"," + 
          "`licensetype`=\"" + this.licensetype + "\",`state`=\"" + this.state + "\",`country`=\"" + this.country + "\"," + 
          "`workgroup`=\"" + this.workgroup + "\",`billingoffice`=\"" + this.billingoffice + "\"," + 
          "`billingrole`=\"" + this.billingrole + "\",`ddjfrole`=\"" + this.ddjfrole + "\",`sapactioncode`=\"" + this.sapactioncode + "\"," + 
          "`sapenddate`=\"" + this.sapenddate + "\",`ddjffamily`=\"" + this.ddjffamily + "\",`overtimeactivitytype`=\"" + this.overtimeactivitytype + "\"," + 
          "`doubletimeactivitytype`=\"" + this.doubletimeactivitytype + "\",`billablehours`=" + this.billablehours + ",`standardhours`=" + this.standardhours + "," + 
          "`activitytype`=\"" + this.activitytype + "\",`effectivedate`=\"" + this.effectivedate + "\",`sapemployeeid`=\"" + this.sapemployeeid + "\"," + 
          "`sapstartdate`=\"" + this.sapstartdate + "\", `updatedon`='" + updatedAt + "' WHERE `eid`=" + this.eid;
      } else {
        sQuery = "INSERT INTO `employee` (`idemployee`,`ename`,`email`,`licensetype`,`state`,`country`,`workgroup`,`reportsto`,`reporttoid`,`billingoffice`,`billingrole`,`ddjfrole`,`sapactioncode`,`sapenddate`,`ddjffamily`,`overtimeactivitytype`,`doubletimeactivitytype`,`billablehours`,`standardhours`,`activitytype`,`effectivedate`,`sapemployeeid`,`sapstartdate`) VALUES ( \"" + 
          
          this.idemployee + "\",\"" + this.ename + "\",\"" + this.email + "\"," + 
          "\"" + this.licensetype + "\",\"" + this.state + "\",\"" + this.country + "\"," + 
          "\"" + this.workgroup + "\",\"" + this.reportsto + "\",\"" + this.reporttoid + "\",\"" + this.billingoffice + "\"," + 
          "\"" + this.billingrole + "\",\"" + this.ddjfrole + "\",\"" + this.sapactioncode + "\"," + 
          "\"" + this.sapenddate + "\",\"" + this.ddjffamily + "\",\"" + this.overtimeactivitytype + "\"," + 
          "\"" + this.doubletimeactivitytype + "\"," + this.billablehours + "," + this.standardhours + "," + 
          "\"" + this.activitytype + "\",\"" + this.effectivedate + "\",\"" + this.sapemployeeid + "\"," + 
          "\"" + this.sapstartdate + "\")";
      } 
      st2.execute(sQuery);
      st2.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(sQuery);
      System.out.println(ex.getMessage());
    } 
  }
  
  public String queryEID(String sIDEMployee) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT eid from employee where `idemployee`=\"" + sIDEMployee + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String idemployee = "";
      int i = 1;
      if (rs.next()) {
        idemployee = (new StringBuilder(String.valueOf(rs.getInt("eid")))).toString();
        sRslt = idemployee;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return sRslt;
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
        String sDay = s[0];
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
  
  public void setEmployee(String jSoupString) {
    Document doc = null;
    doc = Jsoup.parse(jSoupString);
    Elements links = null;
    setEname(doc.select("h1#Master_IdPageHeaderTitle").text());
    setLicensetype(doc.select("div#ResourceType").select("span").text());
    setState(doc.select("div#ResourceProvince").select("span").text());
    setCountry(doc.select("div#ResourceCountry").select("span").text());
    setEmail(doc.select("div#ResourceEmail").select("a").text());
    setWorkgroup(doc.select("div#ResourceWorkgroup").select("span").text());
    setReportsto(doc.select("div#ResourceReportsTo").select("a").text());
    String sRLink = doc.select("div#ResourceReportsTo").select("a").attr("href");
    if (!sRLink.isEmpty()) {
      int index = sRLink.indexOf("u={");
      String sUser = sRLink.substring(index + 3, index + 39);
      setReporttoid(sUser);
      System.out.println("EmployeeID=" + sUser);
    } 
    links = doc.select("div.udfRow");
    int i = 0;
    for (Element link : links) {
      String label = link.select("div.udfLblVw").text();
      String value = link.select("div.udfCtrlVw").text();
      try {
        if (label.indexOf("Billing Office") > -1) {
          setBillingoffice(value);
        } else if (label.indexOf("BIlling Role") > -1) {
          setBillingrole(value);
        } else if (label.indexOf("DDJF Role") > -1) {
          setDdjfrole(value);
        } else if (label.indexOf("SAP Action Code") > -1) {
          setSapactioncode(value);
        } else if (label.indexOf("SAP End Date") > -1) {
          setSapenddate(setMysqDate(value));
        } else if (label.indexOf("DDJF Family") > -1) {
          setDdjffamily(value);
        } else if (label.indexOf("Overtime Activity Type") > -1) {
          setOvertimeactivitytype(value);
        } else if (label.indexOf("Doubletime Activity Type") > -1) {
          setDoubletimeactivitytype(value);
        } else if (label.indexOf("Billable Hour") > -1) {
          setBillablehours(value);
        } else if (label.indexOf("Standard Hours") > -1) {
          setStandardhours(value);
        } else if (label.indexOf("Activity Type") > -1) {
          setActivitytype(value);
        } else if (label.indexOf("Effective Date") > -1) {
          setEffectivedate(setMysqDate(value));
        } else if (label.indexOf("SAP Employee ID") > -1) {
          setSapemployeeid(value);
        } else if (label.indexOf("SAP Start Date") > -1) {
          setSapstartdate(setMysqDate(value));
        } 
      } catch (Exception exception) {}
      i++;
    } 
  }
  
  public static void dbCleanUp() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    try {
      Statement st = (Statement)conn.createStatement();
      String sUpdate = "";
      sUpdate = "update `employee` as A inner join `billingcard` as B on A.billingrole=B.billingrole set A.hourlycost=B.reg";
      System.out.println(sUpdate);
      st.execute(sUpdate);
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }
}


/* Location:              D:\Rpa\rpappms\!\employee.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */