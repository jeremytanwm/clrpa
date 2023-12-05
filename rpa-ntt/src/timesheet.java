import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class timesheet {
  public String getTid() {
    return this.tid;
  }
  
  public void setTid(String tid) {
    this.tid = tid;
  }
  
  public String getIdtimesheet() {
    return this.idtimesheet;
  }
  
  public void setIdtimesheet(String idtimesheet) {
    this.idtimesheet = idtimesheet;
  }
  
  public String getIdemployee() {
    return this.idemployee;
  }
  
  public void setIdemployee(String idemployee) {
    this.idemployee = idemployee;
  }
  
  public String getIdproject() {
    return this.idproject;
  }
  
  public void setIdproject(String idproject) {
    this.idproject = idproject;
  }
  
  public String getIdtask() {
    return this.idtask;
  }
  
  public void setIdtask(String idtask) {
    this.idtask = idtask;
  }
  
  public String getProjectname() {
    return this.projectname;
  }
  
  public void setProjectname(String projectname) {
    this.projectname = projectname;
  }
  
  public String getTaskname() {
    return this.taskname;
  }
  
  public void setTaskname(String taskname) {
    this.taskname = taskname;
  }
  
  public String getClockdate() {
    return this.clockdate;
  }
  
  public void setClockdate(String clockdate) {
    this.clockdate = clockdate;
  }
  
  public String getBillable() {
    return this.billable;
  }
  
  public void setBillable(String billable) {
    this.billable = billable;
  }
  
  public String getHours() {
    return this.hours;
  }
  
  public void setHours(String hours) {
    this.hours = hours;
  }
  
  public String getHourstype() {
    return this.hourstype;
  }
  
  public void setHourstype(String hourstype) {
    this.hourstype = hourstype;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  private String tid = "";
  
  private String idtimesheet = "";
  
  private String idemployee = "";
  
  private String idproject = "";
  
  private String idtask = "";
  
  private String projectname = "";
  
  private String taskname = "";
  
  private String clockdate = "";
  
  private String billable = "";
  
  private String hours = "";
  
  private String hourstype = "";
  
  private String status = "";
  
  private String description = "";
  
  private String hourscost = "";
  
  private String FMonth = "";
  
  public String getFMonth() {
    return this.FMonth;
  }
  
  public void setFMonth(String fMonth) {
    this.FMonth = fMonth;
  }
  
  public String getTotalcost() {
    return this.totalcost;
  }
  
  public void setTotalcost(String totalcost) {
    this.totalcost = totalcost;
  }
  
  public String getHourscost() {
    return this.hourscost;
  }
  
  public void setHourscost(String hourscost) {
    this.hourscost = hourscost;
  }
  
  private String totalcost = "";
  
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String dbName="c1ppms";
  
  private String setMysqDate(String sDate) {
    String temp = null;
    try {
      String[] s = sDate.split("/");
      if (s[0].length() == 1)
        s[0] = "0" + s[0]; 
      if (s[1].length() == 1)
        s[1] = "0" + s[1]; 
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
    return temp;
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
  
  public void dbInsertTimeSheet() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    try {
      Statement st = (Statement)conn.createStatement();
      String sClockDate = setMysqDate(getClockdate());
      String supdate = "INSERT INTO `timesheet`(`idtimesheet`, `idemployee`, `idproject`, `idtask`, `projectname`, `taskname`, `clockdate`, `billable`, `hours`, `hourstype`, `status`, `description`, `FMonth`, `FWeek`) VALUES (\"" + 
        
        this.idtimesheet + "\",\"" + this.idemployee + "\",\"" + this.idproject + "\",\"" + this.idtask + "\"," + 
        "\"" + this.projectname + "\",\"" + this.taskname + "\",\"" + sClockDate + "\",\"" + this.billable + "\"," + this.hours + ",\"" + this.hourstype + "\",\"" + this.status + "\",\"" + this.description + "\",\"" + getFMonth(sClockDate) + "\"" + 
        ", \"" + getFWeekStart(sClockDate) + "\")";
      System.out.println(supdate);
      st.execute(supdate);
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
  }
  
  public static String getFMonth(String sDate) {
    String rslt = "";
    LocalDate ld = LocalDate.parse(sDate);
    int day = ld.getDayOfMonth();
    if (day >= 26)
      ld = ld.plusDays(10L); 
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
    rslt = String.valueOf(formatter.format(ld)) + "-01";
    return rslt;
  }
  
  public static String getFWeekStart(String sDate) {
    String rslt = "";
    LocalDate ld = LocalDate.parse(sDate);
    LocalDate ldlast = ld;
    if (ld.getDayOfWeek() != DayOfWeek.MONDAY)
      ldlast = ld.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)); 
    if (ld.getDayOfMonth() > 25) {
      String sMonth = (new StringBuilder(String.valueOf(ldlast.getMonthValue()))).toString();
      if (sMonth.length() == 1)
        sMonth = "0" + sMonth; 
      if (ldlast.getDayOfMonth() < 26)
        ldlast = LocalDate.parse(String.valueOf(ldlast.getYear()) + "-" + sMonth + "-" + "26"); 
    } 
    if (ldlast.getDayOfWeek() == DayOfWeek.MONDAY)
      if (ldlast.getDayOfMonth() == 28) {
        ldlast = ldlast.minusDays(2L);
      } else if (ldlast.getDayOfMonth() == 27) {
        ldlast = ldlast.minusDays(1L);
      }  
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    rslt = formatter.format(ldlast);
    return rslt;
  }
  
  public static String getFWeekTargetHours(String sDate) {
    String rslt = "";
    LocalDate ld = LocalDate.parse(sDate);
    LocalDate ldlast = ld;
    LocalDate ldFriday = ld;
    int iWorkingDay = 5;
    if (ld.getDayOfWeek() != DayOfWeek.MONDAY)
      ldlast = ld.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)); 
    if (ld.getDayOfMonth() > 25) {
      String sMonth = (new StringBuilder(String.valueOf(ldlast.getMonthValue()))).toString();
      if (sMonth.length() == 1)
        sMonth = "0" + sMonth; 
      if (ldlast.getDayOfMonth() < 26)
        ldlast = LocalDate.parse(String.valueOf(ldlast.getYear()) + "-" + sMonth + "-" + "26"); 
    } 
    ldFriday = ldlast.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
    if (ldlast.getDayOfWeek() == DayOfWeek.FRIDAY) {
      iWorkingDay = 1;
    } else {
      if (ldlast.getDayOfMonth() < 26 && 
        ldFriday.getDayOfMonth() > 25) {
        String sMonth = (new StringBuilder(String.valueOf(ldFriday.getMonthValue()))).toString();
        if (sMonth.length() == 1)
          sMonth = "0" + sMonth; 
        if (ldFriday.getDayOfMonth() > 25)
          ldFriday = LocalDate.parse(String.valueOf(ldFriday.getYear()) + "-" + sMonth + "-" + "25"); 
      } 
      Period period = Period.between(ldlast, ldFriday);
      iWorkingDay = period.getDays() + 1;
    } 
    System.out.println("Number of working day=" + iWorkingDay + ":" + ldFriday.getDayOfMonth() + "...." + ldlast.getDayOfMonth());
    if (iWorkingDay > 5)
      iWorkingDay = 5; 
    rslt = (new StringBuilder(String.valueOf(iWorkingDay * 8))).toString();
    return rslt;
  }
  
  public static void main(String[] args) {
    timesheet t = new timesheet();
    t.dbUpdateFWeek();
  }
  
  public void dbRefreshTimeSheet() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sSQL = "";
    try {
      Statement st = (Statement)conn.createStatement();
      Float sCost = Float.valueOf(0.0F);
      Float sTotalCost = Float.valueOf(0.0F);
      try {
        String sgetHourssql = "Select `hourlycost` from `employee` where `idemployee`=\"" + this.idemployee + "\"";
        ResultSet rs1 = (ResultSet)st.executeQuery(sgetHourssql);
        if (rs1.next())
          sCost = Float.valueOf(rs1.getFloat(1)); 
        rs1.close();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      } 
      setHourscost(Float.toString(sCost));
      setTotalcost((new StringBuilder(String.valueOf(sCost.floatValue() * Float.valueOf(getHours()).floatValue()))).toString());
      String sSelect = "Select `idtimesheet` from `timesheet` where `idtimesheet`=\"" + this.idtimesheet + "\"";
      if (this.projectname.contains("Non-project time")) {
        if (this.taskname.contains("Administration") || this.taskname.contains("After Hours Support") || this.taskname.contains("ConductTraining") || this.taskname.contains("Improvement"))
          this.billable = "2"; 
        if (this.taskname.toLowerCase().contains("presales") || this.taskname.toLowerCase().contains("pre-sales") || this.taskname.toLowerCase().contains("pre sales"))
          this.billable = "3"; 
        if (this.taskname.toLowerCase().contains("attend training"))
          this.billable = "4"; 
        if (this.taskname.toLowerCase().contains("annual leave"))
          this.billable = "5"; 
        if (this.taskname.toLowerCase().contains("hospitalisation"))
          this.billable = "6"; 
        if (this.taskname.toLowerCase().contains("others"))
          this.billable = "7"; 
      } 
      if (this.billable == "1") {
        String sBillableStatus = "";
        String sProjectType = "";
        try {
          String sgetbillable = "Select `billable`, `projecttype` from `projecthealth` where `idproject`=\"" + this.idproject + "\"";
          ResultSet rs2 = (ResultSet)st.executeQuery(sgetbillable);
          if (rs2.next()) {
            sBillableStatus = rs2.getString(1);
            sProjectType = rs2.getString(2);
            if (sBillableStatus.length() > 0)
              sBillableStatus = sBillableStatus.trim(); 
            if (sBillableStatus.equals("Yes")) {
              this.billable = "1";
              task dbt = new task();
              String sBillable = task.getTaskBillable(getIdtask());
              if (sBillable.contains("No")) {
                this.billable = "9";
                System.out.println("Non-billable TASK from Billable Project detected: " + this.idproject + " : " + this.projectname + " - " + getIdtask());
              } 
            } else {
              System.out.println("Non-billable project detected: " + this.idproject + " : " + this.projectname);
              this.billable = "9";
            } 
            if (sProjectType != null && 
              sProjectType.contains("Opportunity"))
              this.billable = "3"; 
          } 
          rs2.close();
        } catch (Exception e) {
          System.out.println(e.getMessage());
        } 
      } 
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      this.description = this.description.replace("'", "''");
      PreparedStatement preparedStmt = null;
      String sClockDate = setMysqDate(this.clockdate);
      if (rs.next()) {
        sSQL = "UPDATE  `timesheet` set  `idemployee`=?, `idproject`=?, `idtask`=?, `projectname`=?, `taskname`=?, `clockdate`=?, `billable`=?, `hours`=?, `hourstype`=?, `status`=?, `hourscost`=?, `totalcost`=?, `FMonth`=?,  `description`=?, `FWeek`=?, `FWeekHours`=?, updateon=NOW() where `idtimesheet`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sSQL);
        preparedStmt.setString(1, this.idemployee);
        preparedStmt.setString(2, this.idproject);
        preparedStmt.setString(3, this.idtask);
        preparedStmt.setString(4, this.projectname);
        preparedStmt.setString(5, this.taskname);
        preparedStmt.setString(6, sClockDate);
        preparedStmt.setInt(7, getIntValue(this.billable));
        preparedStmt.setFloat(8, getFloatValue(this.hours).floatValue());
        preparedStmt.setString(9, this.hourstype);
        preparedStmt.setString(10, this.status);
        preparedStmt.setFloat(11, getFloatValue(this.hourscost).floatValue());
        preparedStmt.setFloat(12, getFloatValue(this.totalcost).floatValue());
        preparedStmt.setString(13, getFMonth(sClockDate));
        preparedStmt.setString(14, this.description);
        preparedStmt.setString(15, getFWeekStart(sClockDate));
        preparedStmt.setString(16, getFWeekTargetHours(sClockDate));
        preparedStmt.setString(17, this.idtimesheet);
        preparedStmt.execute();
      } else {
        sSQL = "INSERT INTO `timesheet`(`idtimesheet`, `idemployee`, `idproject`, `idtask`, `projectname`, `taskname`, `clockdate`, `billable`, `hours`, `hourstype`, `status`, `description`,`hourscost`,`totalcost`, `FMonth`, `FWeek`, `FWeekHours`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sSQL);
        preparedStmt.setString(1, this.idtimesheet);
        preparedStmt.setString(2, this.idemployee);
        preparedStmt.setString(3, this.idproject);
        preparedStmt.setString(4, this.idtask);
        preparedStmt.setString(5, this.projectname);
        preparedStmt.setString(6, this.taskname);
        preparedStmt.setString(7, sClockDate);
        preparedStmt.setInt(8, getIntValue(this.billable));
        preparedStmt.setFloat(9, getFloatValue(this.hours).floatValue());
        preparedStmt.setString(10, this.hourstype);
        preparedStmt.setString(11, this.status);
        preparedStmt.setString(12, this.description);
        preparedStmt.setFloat(13, getFloatValue(this.hourscost).floatValue());
        preparedStmt.setFloat(14, getFloatValue(this.totalcost).floatValue());
        preparedStmt.setString(15, getFMonth(sClockDate));
        preparedStmt.setString(16, getFWeekStart(sClockDate));
        preparedStmt.setString(17, getFWeekTargetHours(sClockDate));
        preparedStmt.execute();
      } 
      rs.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println("ERROR: Timesheet: " + sSQL);
      System.out.println(ex.getMessage());
    } 
  }
  
  public void dbRefreshProject() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    try {
      Statement st1 = (Statement)conn.createStatement();
      String sIDProject = "";
      String sProjectName = "";
      try {
        String sgetHourssql = "Select `idproject`, `projectname` from `timesheet` where length(`idproject`) >2 group by `idproject`, `projectname`";
        ResultSet rs1 = (ResultSet)st1.executeQuery(sgetHourssql);
        while (rs1.next()) {
          sIDProject = rs1.getString(1);
          sProjectName = rs1.getString(2);
          String sSelect = "Select `idproject` from `projecthealth` where `idproject`=\"" + sIDProject + "\"";
          Statement st = (Statement)conn.createStatement();
          ResultSet rs = (ResultSet)st.executeQuery(sSelect);
          if (rs.next()) {
            String supdate = "UPDATE  `projecthealth` set  `projectname`=\"" + sProjectName + "\" where `idproject`=\"" + sIDProject + "\"";
            System.out.println(supdate);
            st.execute(supdate);
          } else {
            String sInsert = "INSERT INTO `projecthealth`(`idproject`, `projectname`) VALUES (\"" + sIDProject + "\",\"" + sProjectName + "\")";
            System.out.println(sInsert);
            st.execute(sInsert);
          } 
          rs.close();
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
  
  public void dbUpdateFWeek() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    try {
      Statement st1 = (Statement)conn.createStatement();
      String sIDProject = "";
      String sProjectName = "";
      try {
        String sgetHourssql = "Select `tid`, `clockdate` from `timesheet`";
        ResultSet rs1 = (ResultSet)st1.executeQuery(sgetHourssql);
        while (rs1.next()) {
          int iID = rs1.getInt(1);
          String sDate = rs1.getString(2);
          Statement st = (Statement)conn.createStatement();
          String supdate = "UPDATE  `timesheet` set  `Fweek`=\"" + getFWeekStart(sDate) + "\" where `tid`=" + iID;
          System.out.println(String.valueOf(sDate) + "-" + supdate);
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
  
  public void dbUpdateFWeekHour() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    try {
      Statement st1 = (Statement)conn.createStatement();
      String sIDProject = "";
      String sProjectName = "";
      try {
        String sgetHourssql = "Select `tid`, `clockdate` from `timesheet`";
        ResultSet rs1 = (ResultSet)st1.executeQuery(sgetHourssql);
        while (rs1.next()) {
          int iID = rs1.getInt(1);
          String sDate = rs1.getString(2);
          Statement st = (Statement)conn.createStatement();
          String supdate = "UPDATE  `timesheet` set  `FWeekHours`=" + getFWeekTargetHours(sDate) + " where `tid`=" + iID;
          System.out.println(String.valueOf(sDate) + "-" + supdate);
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
  
  public void dbCleanUp() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    try {
      Statement st = (Statement)conn.createStatement();
      String sUpdate = "";
      sUpdate = "UPDATE timesheet INNER JOIN employee ON timesheet.idemployee = employee.idemployee SET timesheet.hourscost = IF(ISNULL(employee.hourlycost), 0, employee.hourlycost)";
      System.out.println(sUpdate);
      st.execute(sUpdate);
      sUpdate = "UPDATE timesheet INNER JOIN employee ON timesheet.idemployee = employee.idemployee SET timesheet.totalcost = hours * IF(ISNULL(employee.hourlycost), 0, employee.hourlycost)";
      System.out.println(sUpdate);
      st.execute(sUpdate);
      sUpdate = "update timesheet inner join task on timesheet.idtask = task.idtask set timesheet.idproject=task.idproject where timesheet.projectname like 'TXR%'";
      System.out.println(sUpdate);
      st.execute(sUpdate);
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }
}