import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class task {
  public String id = "";
  
  public String idtaskemployee = "";
  
  public String idproject = "";
  
  public String idemployee = "";
  
  public String idtask = "";
  
  public String pstart = "";
  
  public String pend = "";
  
  public String pnumworkday = "";
  
  public String fstart = "";
  
  public String fend = "";
  
  public String fnumworkday = "";
  
  public String astart = "";
  
  public String aend = "";
  
  public String anumworkday = "";
  
  public String phour = "";
  
  public String fhour = "";
  
  public String ahour = "";
  
  public String rhour = "";
  
  public String lastupdate = "";
  
  public String createdon = "";
  
  public String taskname = "";
  
  public String thour = "";
  
  public String pcomplete = "";
  
  public String pavg = "0";
  
  public String favg = "0";
  
  public String aavg = "0";
  
  public String billable = "No";
  
  public String SOItem = "No";
  
  public String Completed = "No";
  
  public String projectstatus = "";
  
  public String projectname = "";
  
  public String ename = "";
  
  public String idpm = "";
  
  public String pmname = "";
  
  public String getPmname() {
    return this.pmname;
  }
  
  public void setPmname(String pmname) {
    this.pmname = pmname;
  }
  
  public String getProjectstatus() {
    return this.projectstatus;
  }
  
  public void setProjectstatus(String projectstatus) {
    this.projectstatus = projectstatus;
  }
  
  public String getProjectname() {
    return this.projectname;
  }
  
  public void setProjectname(String projectname) {
    this.projectname = projectname;
  }
  
  public String getEname() {
    return this.ename;
  }
  
  public void setEname(String ename) {
    this.ename = ename;
  }
  
  public String getBillable() {
    return this.billable;
  }
  
  public void setBillable(String billable) {
    this.billable = billable;
  }
  
  public String getSOItem() {
    return this.SOItem;
  }
  
  public void setSOItem(String sOItem) {
    this.SOItem = sOItem;
  }
  
  public String getCompleted() {
    return this.Completed;
  }
  
  public void setCompleted(String completed) {
    this.Completed = completed;
  }
  
  public String getIdpm() {
    return this.idpm;
  }
  
  public void setIdpm(String idpm) {
    this.idpm = idpm;
  }
  
  public String getIdproject() {
    return this.idproject;
  }
  
  public void setIdproject(String idproject) {
    this.idproject = idproject;
  }
  
  public String getPavg() {
    Float f = Float.valueOf("0");
    if (!this.phour.equals("0.00")) {
      try {
        f = Float.valueOf(Float.valueOf(this.phour).floatValue() / Float.valueOf(this.pnumworkday).floatValue());
        this.pavg = String.format("%.02f", new Object[] { f });
      } catch (Exception e) {
        this.pavg = "0";
      } 
    } else {
      this.pavg = "0";
    } 
    if (this.pavg.equals("Infinity"))
      this.pavg = "0"; 
    return this.pavg;
  }
  
  public void setPavg(String pavg) {
    this.pavg = pavg;
  }
  
  public String getFavg() {
    Float f = Float.valueOf("0");
    if (!this.fhour.equals("0.00")) {
      try {
        f = Float.valueOf(Float.valueOf(this.fhour).floatValue() / Float.valueOf(this.fnumworkday).floatValue());
        this.favg = String.format("%.02f", new Object[] { f });
      } catch (Exception e) {
        this.favg = "0";
      } 
    } else {
      this.favg = "0";
    } 
    if (this.fhour.equals("0"))
      this.favg = "0"; 
    if (this.favg.equals("Infinity"))
      this.favg = "0"; 
    return this.favg;
  }
  
  public void setFavg(String favg) {
    this.favg = favg;
  }
  
  public String getAavg() {
    Float f = Float.valueOf("0");
    if (!this.ahour.equals("0.00")) {
      try {
        f = Float.valueOf(Float.valueOf(this.ahour).floatValue() / Float.valueOf(this.anumworkday).floatValue());
        this.aavg = String.format("%.02f", new Object[] { f });
      } catch (Exception e) {
        this.aavg = "0";
      } 
    } else {
      this.aavg = "0";
    } 
    if (this.ahour.equals("0"))
      this.aavg = "0"; 
    if (this.aavg.equals("Infinity"))
      this.aavg = "0"; 
    return this.aavg;
  }
  
  public void setAavg(String aavg) {
    this.aavg = aavg;
  }
  
  public String getThour() {
    return this.thour;
  }
  
  public void setThour(String thour) {
    this.thour = thour;
  }
  
  public String getPcomplete() {
    return this.pcomplete;
  }
  
  public void setPcomplete(String pcomplete) {
    this.pcomplete = pcomplete;
  }
  
  public String getTaskname() {
    return this.taskname;
  }
  
  public void setTaskname(String taskname) {
    this.taskname = taskname;
  }
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getIdtaskemployee() {
    return this.idtaskemployee;
  }
  
  public void setIdtaskemployee(String idtaskemployee) {
    this.idtaskemployee = idtaskemployee;
  }
  
  public String getIdemployee() {
    return this.idemployee;
  }
  
  public void setIdemployee(String idemployee) {
    this.idemployee = idemployee;
  }
  
  public String getIdtask() {
    return this.idtask;
  }
  
  public void setIdtask(String idtask) {
    this.idtask = idtask;
  }
  
  public String getPstart() {
    return this.pstart;
  }
  
  public void setPstart(String pstart) {
    this.pstart = setMysqDate(pstart);
  }
  
  public String getPend() {
    return this.pend;
  }
  
  public void setPend(String pend) {
    this.pend = setMysqDate(pend);
  }
  
  public String getPnumworkday() {
    long rslt = getNumberOfWeekDays(getPstart(), getPend());
    this.pnumworkday = (new StringBuilder(String.valueOf(rslt))).toString();
    return this.pnumworkday;
  }
  
  public void setPnumworkday(String pnumworkday) {
    this.pnumworkday = pnumworkday;
  }
  
  public String getFstart() {
    return this.fstart;
  }
  
  public void setFstart(String fstart) {
    this.fstart = setMysqDate(fstart);
  }
  
  public String getFend() {
    return this.fend;
  }
  
  public void setFend(String fend) {
    this.fend = setMysqDate(fend);
  }
  
  public String getFnumworkday() {
    long rslt = getNumberOfWeekDays(getFstart(), getFend());
    this.fnumworkday = (new StringBuilder(String.valueOf(rslt))).toString();
    return this.fnumworkday;
  }
  
  public void setFnumworkday(String fnumworkday) {
    this.fnumworkday = fnumworkday;
  }
  
  public String getAstart() {
    return this.astart;
  }
  
  public void setAstart(String astart) {
    this.astart = setMysqDate(astart);
  }
  
  public String getAend() {
    return this.aend;
  }
  
  public void setAend(String aend) {
    this.aend = setMysqDate(aend);
  }
  
  public String getAnumworkday() {
    long rslt = getNumberOfWeekDays(getAstart(), getAend());
    this.anumworkday = (new StringBuilder(String.valueOf(rslt))).toString();
    return this.anumworkday;
  }
  
  public void setAnumworkday(String anumworkday) {
    this.anumworkday = anumworkday;
  }
  
  public String getPhour() {
    this.phour = this.phour.replaceAll(",", "");
    return this.phour;
  }
  
  public void setPhour(String phour) {
    this.phour = phour;
  }
  
  public String getFhour() {
    this.fhour = this.fhour.replaceAll(",", "");
    return this.fhour;
  }
  
  public void setFhour(String fhour) {
    this.fhour = fhour;
  }
  
  public String getAhour() {
    this.ahour = this.ahour.replaceAll(",", "");
    return this.ahour;
  }
  
  public void setAhour(String ahour) {
    this.ahour = ahour;
  }
  
  public String getRhour() {
    this.rhour = this.rhour.replaceAll(",", "");
    return this.rhour;
  }
  
  public void setRhour(String rhour) {
    this.rhour = rhour;
  }
  
  public String getLastupdate() {
    return this.lastupdate;
  }
  
  public void setLastupdate(String lastupdate) {
    this.lastupdate = lastupdate;
  }
  
  public String getCreatedon() {
    return this.createdon;
  }
  
  public void setCreatedon(String createdon) {
    this.createdon = createdon;
  }
  
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  public static String dbName="c1ppms";
  public static long getNumberOfWeekDays(String sStart, String sEnd) {
    long rslt = 0L;
    try {
      LocalDate ldStart = LocalDate.parse(sStart);
      LocalDate ldEnd = LocalDate.parse(sEnd);
      rslt = calcWeekDays1(ldStart, ldEnd);
    } catch (Exception e) {
      System.out.println("Error getNumberOfWeekDays: " + e.getLocalizedMessage());
    } 
    return rslt;
  }
  
  public static long calcWeekDays1(LocalDate start, LocalDate end) {
    DayOfWeek startW = start.getDayOfWeek();
    DayOfWeek endW = end.getDayOfWeek();
    long days = ChronoUnit.DAYS.between(start, end);
    long daysWithoutWeekends = days - 2L * (days + startW.getValue()) / 7L;
    return daysWithoutWeekends + ((startW == DayOfWeek.SUNDAY) ? 1L : 0L) + ((endW == DayOfWeek.SUNDAY) ? 1L : 0L);
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
    //  temp = "9999-12-31"; 
    if (temp.equals(""))
      temp = "9999-12-31"; 
    if (temp.isEmpty())
      temp = "9999-12-31"; 
    return temp;
  }
  
  public static String getTaskBillable(String sTaskID) {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `billable` from `task` where `idtask`='" + sTaskID + "'";
    String rslt = "";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      if (rs.next())
        rslt = rs.getString(1); 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return rslt;
  }
  
  public static boolean isViewUpdated(String sTaskID) {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT `SOitem` from `task` where `idtask`='" + sTaskID + "'";
    boolean rslt = false;
    String srslt = "";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      if (rs.next()) {
        srslt = rs.getString(1);
        if (!srslt.contains("NA"))
          rslt = true; 
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return rslt;
  }
  
  public void dbLoadTask() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    PreparedStatement preparedStmt = null;
    try {
      String sSelect = "Select `id` from `task` where `idtask`=\"" + getIdtask() + "\" and `idemployee`=\"" + getIdemployee() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {
        sQuery = "UPDATE `task` SET `idpm`=?,`idproject`=?,`idemployee`=?,`idtask`=?,`taskname`=?,`pstart`=?,`pend`=?,`pnumworkday`=?,`fstart`=?,`fend`=?,`fnumworkday`=?,`astart`=?,`aend`=?,`anumworkday`=?,`phour`=?,`fhour`=?,`ahour`=?,`rhour`=?,`thour`=?,`pcomplete`=?,`Pavg`=?,`favg`=?,`aavg`=?,`lastupdate`=NOW() WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdpm());
        preparedStmt.setString(2, getIdproject());
        preparedStmt.setString(3, getIdemployee());
        preparedStmt.setString(4, getIdtask());
        preparedStmt.setString(5, getTaskname());
        preparedStmt.setString(6, getPstart());
        preparedStmt.setString(7, getPend());
        preparedStmt.setInt(8, getIntValue(getPnumworkday()));
        preparedStmt.setString(9, getFstart());
        preparedStmt.setString(10, getFend());
        preparedStmt.setInt(11, getIntValue(getFnumworkday()));
        preparedStmt.setString(12, getAstart());
        preparedStmt.setString(13, getAend());
        preparedStmt.setInt(14, getIntValue(getAnumworkday()));
        preparedStmt.setFloat(15, getFloatValue(getPhour()).floatValue());
        preparedStmt.setFloat(16, getFloatValue(getFhour()).floatValue());
        preparedStmt.setFloat(17, getFloatValue(getAhour()).floatValue());
        preparedStmt.setFloat(18, getFloatValue(getRhour()).floatValue());
        preparedStmt.setFloat(19, getFloatValue(getThour()).floatValue());
        preparedStmt.setString(20, getPcomplete());
        preparedStmt.setFloat(21, getFloatValue(getPavg()).floatValue());
        preparedStmt.setFloat(22, getFloatValue(getFavg()).floatValue());
        preparedStmt.setFloat(23, getFloatValue(getAavg()).floatValue());
        preparedStmt.setInt(24, getIntValue((new StringBuilder(String.valueOf(rs.getInt(1)))).toString()));
        preparedStmt.execute();
      } else {
        sQuery = "INSERT INTO `task`(`idpm`,`idproject`, `idemployee`, `idtask`, `taskname`, `pstart`, `pend`, `pnumworkday`, `fstart`, `fend`, `fnumworkday`, `astart`, `aend`, `anumworkday`, `phour`, `fhour`, `ahour`, `rhour`, `thour`, `pcomplete`,`pavg`,`favg`,`aavg`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdpm());
        preparedStmt.setString(2, getIdproject());
        preparedStmt.setString(3, getIdemployee());
        preparedStmt.setString(4, getIdtask());
        preparedStmt.setString(5, getTaskname());
        preparedStmt.setString(6, getPstart());
        preparedStmt.setString(7, getPend());
        preparedStmt.setInt(8, getIntValue(getPnumworkday()));
        preparedStmt.setString(9, getFstart());
        preparedStmt.setString(10, getFend());
        preparedStmt.setInt(11, getIntValue(getFnumworkday()));
        preparedStmt.setString(12, getAstart());
        preparedStmt.setString(13, getAend());
        preparedStmt.setInt(14, getIntValue(getAnumworkday()));
        preparedStmt.setFloat(15, getFloatValue(getPhour()).floatValue());
        preparedStmt.setFloat(16, getFloatValue(getFhour()).floatValue());
        preparedStmt.setFloat(17, getFloatValue(getAhour()).floatValue());
        preparedStmt.setFloat(18, getFloatValue(getRhour()).floatValue());
        preparedStmt.setFloat(19, getFloatValue(getThour()).floatValue());
        preparedStmt.setString(20, getPcomplete());
        preparedStmt.setFloat(21, getFloatValue(getPavg()).floatValue());
        preparedStmt.setFloat(22, getFloatValue(getFavg()).floatValue());
        preparedStmt.setFloat(23, getFloatValue(getAavg()).floatValue());
        preparedStmt.execute();
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR: LOAD TASK:" + sQuery);
      System.out.println("ERROR: LOAD TASK:" + e.getMessage());
    } 
  }
  
  public void dbLoadTaskTXR() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    PreparedStatement preparedStmt = null;
    try {
      String sSelect = "Select `id` from `task` where `idtask`=\"" + getIdtask() + "\" and `idemployee`=\"" + getIdemployee() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {
        sQuery = "UPDATE `task` SET `idpm`=?,`idproject`=?,`idemployee`=?,`idtask`=?,`taskname`=?,`pstart`=?,`pend`=?,\t`phour`=?, `completed`=?,`projectstatus`=?,`ename`=?,`pmname`=?,`lastupdate`=NOW() WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdpm());
        preparedStmt.setString(2, getIdproject());
        preparedStmt.setString(3, getIdemployee());
        preparedStmt.setString(4, getIdtask());
        preparedStmt.setString(5, getTaskname());
        preparedStmt.setString(6, getPstart());
        preparedStmt.setString(7, getPend());
        preparedStmt.setFloat(8, getFloatValue(getPhour()).floatValue());
        preparedStmt.setString(9, getCompleted());
        preparedStmt.setString(10, getProjectstatus());
        preparedStmt.setString(11, getEname());
        preparedStmt.setString(12, getPmname());
        preparedStmt.setInt(13, getIntValue((new StringBuilder(String.valueOf(rs.getInt(1)))).toString()));
        preparedStmt.execute();
        System.out.println("SUCCESS: INSERT LOAD TASK TXR:" + sQuery);
      } else {
        sQuery = "INSERT INTO `task`(`idpm`,`idproject`, `idemployee`, `idtask`, `taskname`, `pstart`, `pend`,  `phour`,`completed`,`projectstatus`,`ename`,`pmname`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdpm());
        preparedStmt.setString(2, getIdproject());
        preparedStmt.setString(3, getIdemployee());
        preparedStmt.setString(4, getIdtask());
        preparedStmt.setString(5, getTaskname());
        preparedStmt.setString(6, getPstart());
        preparedStmt.setString(7, getPend());
        preparedStmt.setFloat(8, getFloatValue(getPhour()).floatValue());
        preparedStmt.setString(9, getCompleted());
        preparedStmt.setString(10, getProjectstatus());
        preparedStmt.setString(11, getEname());
        preparedStmt.setString(12, getPmname());
        preparedStmt.execute();
        System.out.println("SUCCESS: UPDATE LOAD TASK TXR:" + sQuery);
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR: LOAD TASK:" + sQuery);
      System.out.println("ERROR: LOAD TASK:" + e.getMessage());
    } 
  }
  
  public void dbUpdateTaskTXR() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    PreparedStatement preparedStmt = null;
    try {
      String sSelect = "Select `id` from `task` where `idtask`=\"" + getIdtask() + "\" and `ename`=\"" + getEname() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {
        sQuery = "UPDATE `task` SET `phour`=?, `ahour`=?,`lastupdate`=NOW() WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setFloat(1, getFloatValue(getPhour()).floatValue());
        preparedStmt.setFloat(2, getFloatValue(getAhour()).floatValue());
        preparedStmt.setInt(3, getIntValue((new StringBuilder(String.valueOf(rs.getInt(1)))).toString()));
        preparedStmt.execute();
      } else {
        System.out.println("FAIL: NOT FOUND :" + sSelect);
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR: UPDATE TASK:" + sQuery);
      System.out.println("ERROR: UPDATE TASK:" + e.getMessage());
    } 
  }
  
  public void dbUpdateProfileTask() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    PreparedStatement preparedStmt = null;
    try {
      String sSelect = "Select `id` from `task` where `idtask`=\"" + getIdtask() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {
        sQuery = "UPDATE `task` SET `billable`=?,`soitem`=?,`completed`=?,`taskname`=?,`idproject`=?,`lastupdate`=NOW() WHERE `idtask`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getBillable());
        preparedStmt.setString(2, getSOItem());
        preparedStmt.setString(3, getCompleted());
        preparedStmt.setString(4, getTaskname());
        preparedStmt.setString(5, getIdproject());
        preparedStmt.setString(6, getIdtask());
        preparedStmt.execute();
      } else {
        ppms.viewProjectDetails(getIdproject());
        ppms.reportProgressByProject(getIdproject());
        sQuery = "UPDATE `task` SET `billable`=?,`soitem`=?,`completed`=?,`taskname`=?,`idproject`=?,`lastupdate`=NOW() WHERE `idtask`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getBillable());
        preparedStmt.setString(2, getSOItem());
        preparedStmt.setString(3, getCompleted());
        preparedStmt.setString(4, getTaskname());
        preparedStmt.setString(5, getIdproject());
        preparedStmt.setString(6, getIdtask());
        preparedStmt.execute();
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR: UPDATE PROFILE TASK:" + sQuery);
      System.out.println("ERROR: UPDATE PROFILE TASK:" + e.getMessage());
    } 
  }
  
  public void dbCleanUp() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    try {
      Statement st = (Statement)conn.createStatement();
      String sUpdate = "";
      sUpdate = "UPDATE task INNER JOIN employee ON task.idemployee = employee.idemployee SET task.pcost = phour * IF(ISNULL(employee.hourlycost), 0, employee.hourlycost)";
      System.out.println(sUpdate);
      st.execute(sUpdate);
      sUpdate = "UPDATE task INNER JOIN employee ON task.idemployee = employee.idemployee SET task.acost = ahour * IF(ISNULL(employee.hourlycost), 0, employee.hourlycost)";
      System.out.println(sUpdate);
      st.execute(sUpdate);
      sUpdate = "UPDATE task INNER JOIN employee ON task.idpm = employee.idemployee SET task.pmname = IF(ISNULL(employee.ename), \"\", employee.ename)";
      System.out.println(sUpdate);
      st.execute(sUpdate);
      sUpdate = "UPDATE task INNER JOIN employee ON task.idemployee = employee.idemployee SET task.ename = IF(ISNULL(employee.ename),\"\", employee.ename)";
      System.out.println(sUpdate);
      st.execute(sUpdate);
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }
}


/* Location:              D:\Rpa\rpappms\!\task.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */