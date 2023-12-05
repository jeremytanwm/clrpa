import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class opportunity {
  public String id = "";
  
  public String idrecord = "";
  
  public String idopportunity = "";
  
  public String name = "";
  
  public String description = "";
  
  public String nextstep = "";
  
  public String type = "";
  
  public String recordtype = "";
  
  public String source = "";
  
  public String partner = "";
  
  public String currency = "";
  
  public String score = "";
  
  public String probability = "";
  
  public String amount = "";
  
  public String amountusd = "";
  
  public String forecast = "";
  
  public String stage = "";
  
  public String laststagechange = "";
  
  public String createon = "";
  
  public String closeon = "";
  
  public String updateon = "";
  
  public String idcreateby = "";
  
  public String createby = "";
  
  public String idaccount = "";
  
  public String accountname = "";
  
  public String industry = "";
  
  public String subindustry = "";
  
  public String idparentaccount = "";
  
  public String parentaccount = "";
  
  public String region = "";
  
  public String salesregion = "";
  
  public String salesteam = "";
  
  public String cyclephase = "";
  
  public String wonreason = "";
  
  public String wondescription = "";
  
  public String wonamount = "";
  
  public String wonamountusd = "";
  
  public String solutionstructure = "";
  
  public String solutionscope = "";
  
  public String buildcomplexity = "";
  
  public String geographic = "";
  
  public String model = "";
  
  public String techrevenueusd = "";
  
  public String techgp = "";
  
  public String msrevenueusd = "";
  
  public String msgp = "";
  
  public String csrevenueusd = "";
  
  public String csgp = "";
  
  public String ssrevenueusd = "";
  
  public String ssgp = "";
  
  public String tsrevenueusd = "";
  
  public String tsgp = "";
  
  public String totalgpusd = "";
  
  public String techbgp = "";
  
  public String msbgp = "";
  
  public String csbgp = "";
  
  public String ssbgp = "";
  
  public String tsbgp = "";
  
  public String totalbgp = "";
  
  public String collaboration = "";
  
  public String collaborationpartner = "";
  
  public String engagementtype = "";
  
  public String prime = "";
  
  public String discovery = "";
  
  public String globalcompetitor = "";
  
  public String globalcompetitorlost = "";
  
  public String othercompetitor = "";
  
  public String othercompetitorlost = "";
  
  public String createdon = "";
  
  public String updatedon = "";
  
  public String accountowner = "";
  
  public String accountowneralias = "";
  
  public String lastmodifyby = "";
  
  public String lastmodifybyalias = "";
  
  public String getAccountowner() {
    return this.accountowner;
  }
  
  public void setAccountowner(String accountowner) {
    this.accountowner = accountowner;
  }
  
  public String getAccountowneralias() {
    return this.accountowneralias;
  }
  
  public void setAccountowneralias(String accountowneralias) {
    this.accountowneralias = accountowneralias;
  }
  
  public String getLastmodifyby() {
    return this.lastmodifyby;
  }
  
  public void setLastmodifyby(String lastmodifyby) {
    this.lastmodifyby = lastmodifyby;
  }
  
  public String getLastmodifybyalias() {
    return this.lastmodifybyalias;
  }
  
  public void setLastmodifybyalias(String lastmodifybyalias) {
    this.lastmodifybyalias = lastmodifybyalias;
  }
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getIdrecord() {
    return this.idrecord;
  }
  
  public void setIdrecord(String idrecord) {
    this.idrecord = idrecord;
  }
  
  public String getIdopportunity() {
    return this.idopportunity;
  }
  
  public void setIdopportunity(String idopportunity) {
    this.idopportunity = idopportunity;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public String getNextstep() {
    return this.nextstep;
  }
  
  public void setNextstep(String nextstep) {
    this.nextstep = nextstep;
  }
  
  public String getType() {
    return this.type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public String getRecordtype() {
    return this.recordtype;
  }
  
  public void setRecordtype(String recordtype) {
    this.recordtype = recordtype;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public void setSource(String source) {
    this.source = source;
  }
  
  public String getPartner() {
    return this.partner;
  }
  
  public void setPartner(String partner) {
    this.partner = partner;
  }
  
  public String getCurrency() {
    return this.currency;
  }
  
  public void setCurrency(String currency) {
    this.currency = currency;
  }
  
  public String getScore() {
    return this.score;
  }
  
  public void setScore(String score) {
    this.score = score;
  }
  
  public String getProbability() {
    return this.probability;
  }
  
  public void setProbability(String probability) {
    this.probability = probability;
  }
  
  public String getAmount() {
    return this.amount;
  }
  
  public void setAmount(String amount) {
    this.amount = amount;
  }
  
  public String getAmountusd() {
    return this.amountusd;
  }
  
  public void setAmountusd(String amountusd) {
    this.amountusd = amountusd;
  }
  
  public String getForecast() {
    return this.forecast;
  }
  
  public void setForecast(String forecast) {
    this.forecast = forecast;
  }
  
  public String getStage() {
    return this.stage;
  }
  
  public void setStage(String stage) {
    this.stage = stage;
  }
  
  public String getLaststagechange() {
    return this.laststagechange;
  }
  
  public void setLaststagechange(String laststagechange) {
    this.laststagechange = laststagechange;
  }
  
  public String getCreateon() {
    return this.createon;
  }
  
  public void setCreateon(String createon) {
    this.createon = createon;
  }
  
  public String getCloseon() {
    return this.closeon;
  }
  
  public void setCloseon(String closeon) {
    this.closeon = closeon;
  }
  
  public String getUpdateon() {
    return this.updateon;
  }
  
  public void setUpdateon(String updateon) {
    this.updateon = updateon;
  }
  
  public String getIdcreateby() {
    return this.idcreateby;
  }
  
  public void setIdcreateby(String idcreateby) {
    this.idcreateby = idcreateby;
  }
  
  public String getCreateby() {
    return this.createby;
  }
  
  public void setCreateby(String createby) {
    this.createby = createby;
  }
  
  public String getIdaccount() {
    return this.idaccount;
  }
  
  public void setIdaccount(String idaccount) {
    this.idaccount = idaccount;
  }
  
  public String getAccountname() {
    return this.accountname;
  }
  
  public void setAccountname(String accountname) {
    this.accountname = accountname;
  }
  
  public String getIndustry() {
    return this.industry;
  }
  
  public void setIndustry(String industry) {
    this.industry = industry;
  }
  
  public String getSubindustry() {
    return this.subindustry;
  }
  
  public void setSubindustry(String subindustry) {
    this.subindustry = subindustry;
  }
  
  public String getIdparentaccount() {
    return this.idparentaccount;
  }
  
  public void setIdparentaccount(String idparentaccount) {
    this.idparentaccount = idparentaccount;
  }
  
  public String getParentaccount() {
    return this.parentaccount;
  }
  
  public void setParentaccount(String parentaccount) {
    this.parentaccount = parentaccount;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public void setRegion(String region) {
    this.region = region;
  }
  
  public String getSalesregion() {
    return this.salesregion;
  }
  
  public void setSalesregion(String salesregion) {
    this.salesregion = salesregion;
  }
  
  public String getSalesteam() {
    return this.salesteam;
  }
  
  public void setSalesteam(String salesteam) {
    this.salesteam = salesteam;
  }
  
  public String getCyclephase() {
    return this.cyclephase;
  }
  
  public void setCyclephase(String cyclephase) {
    this.cyclephase = cyclephase;
  }
  
  public String getWonreason() {
    return this.wonreason;
  }
  
  public void setWonreason(String wonreason) {
    this.wonreason = wonreason;
  }
  
  public String getWondescription() {
    return this.wondescription;
  }
  
  public void setWondescription(String wondescription) {
    this.wondescription = wondescription;
  }
  
  public String getWonamount() {
    return this.wonamount;
  }
  
  public void setWonamount(String wonamount) {
    this.wonamount = wonamount;
  }
  
  public String getWonamountusd() {
    return this.wonamountusd;
  }
  
  public void setWonamountusd(String wonamountusd) {
    this.wonamountusd = wonamountusd;
  }
  
  public String getSolutionstructure() {
    return this.solutionstructure;
  }
  
  public void setSolutionstructure(String solutionstructure) {
    this.solutionstructure = solutionstructure;
  }
  
  public String getSolutionscope() {
    return this.solutionscope;
  }
  
  public void setSolutionscope(String solutionscope) {
    this.solutionscope = solutionscope;
  }
  
  public String getGeographic() {
    return this.geographic;
  }
  
  public void setGeographic(String geographic) {
    this.geographic = geographic;
  }
  
  public String getModel() {
    return this.model;
  }
  
  public void setModel(String model) {
    this.model = model;
  }
  
  public String getTechrevenueusd() {
    return this.techrevenueusd;
  }
  
  public void setTechrevenueusd(String techrevenueusd) {
    this.techrevenueusd = techrevenueusd;
  }
  
  public String getTechgp() {
    return this.techgp;
  }
  
  public void setTechgp(String techgp) {
    this.techgp = techgp;
  }
  
  public String getMsrevenueusd() {
    return this.msrevenueusd;
  }
  
  public void setMsrevenueusd(String msrevenueusd) {
    this.msrevenueusd = msrevenueusd;
  }
  
  public String getMsgp() {
    return this.msgp;
  }
  
  public void setMsgp(String msgp) {
    this.msgp = msgp;
  }
  
  public String getCsrevenueusd() {
    return this.csrevenueusd;
  }
  
  public void setCsrevenueusd(String csrevenueusd) {
    this.csrevenueusd = csrevenueusd;
  }
  
  public String getCsgp() {
    return this.csgp;
  }
  
  public void setCsgp(String csgp) {
    this.csgp = csgp;
  }
  
  public String getSsrevenueusd() {
    return this.ssrevenueusd;
  }
  
  public void setSsrevenueusd(String ssrevenueusd) {
    this.ssrevenueusd = ssrevenueusd;
  }
  
  public String getSsgp() {
    return this.ssgp;
  }
  
  public void setSsgp(String ssgp) {
    this.ssgp = ssgp;
  }
  
  public String getTsrevenueusd() {
    return this.tsrevenueusd;
  }
  
  public void setTsrevenueusd(String tsrevenueusd) {
    this.tsrevenueusd = tsrevenueusd;
  }
  
  public String getTsgp() {
    return this.tsgp;
  }
  
  public void setTsgp(String tsgp) {
    this.tsgp = tsgp;
  }
  
  public String getTotalgpusd() {
    return this.totalgpusd;
  }
  
  public void setTotalgpusd(String totalgpusd) {
    this.totalgpusd = totalgpusd;
  }
  
  public String getTechbgp() {
    return this.techbgp;
  }
  
  public void setTechbgp(String techbgp) {
    this.techbgp = techbgp;
  }
  
  public String getMsbgp() {
    return this.msbgp;
  }
  
  public void setMsbgp(String msbgp) {
    this.msbgp = msbgp;
  }
  
  public String getCsbgp() {
    return this.csbgp;
  }
  
  public void setCsbgp(String csbgp) {
    this.csbgp = csbgp;
  }
  
  public String getSsbgp() {
    return this.ssbgp;
  }
  
  public void setSsbgp(String ssbgp) {
    this.ssbgp = ssbgp;
  }
  
  public String getTsbgp() {
    return this.tsbgp;
  }
  
  public void setTsbgp(String tsbgp) {
    this.tsbgp = tsbgp;
  }
  
  public String getTotalbgp() {
    return this.totalbgp;
  }
  
  public void setTotalbgp(String totalbgp) {
    this.totalbgp = totalbgp;
  }
  
  public String getCollaboration() {
    return this.collaboration;
  }
  
  public void setCollaboration(String collaboration) {
    this.collaboration = collaboration;
  }
  
  public String getCollaborationpartner() {
    return this.collaborationpartner;
  }
  
  public void setCollaborationpartner(String collaborationpartner) {
    this.collaborationpartner = collaborationpartner;
  }
  
  public String getEngagementtype() {
    return this.engagementtype;
  }
  
  public void setEngagementtype(String engagementtype) {
    this.engagementtype = engagementtype;
  }
  
  public String getPrime() {
    return this.prime;
  }
  
  public void setPrime(String prime) {
    this.prime = prime;
  }
  
  public String getDiscovery() {
    return this.discovery;
  }
  
  public void setDiscovery(String discovery) {
    this.discovery = discovery;
  }
  
  public String getGlobalcompetitor() {
    return this.globalcompetitor;
  }
  
  public void setGlobalcompetitor(String globalcompetitor) {
    this.globalcompetitor = globalcompetitor;
  }
  
  public String getGlobalcompetitorlost() {
    return this.globalcompetitorlost;
  }
  
  public void setGlobalcompetitorlost(String globalcompetitorlost) {
    this.globalcompetitorlost = globalcompetitorlost;
  }
  
  public String getOthercompetitor() {
    return this.othercompetitor;
  }
  
  public void setOthercompetitor(String othercompetitor) {
    this.othercompetitor = othercompetitor;
  }
  
  public String getOthercompetitorlost() {
    return this.othercompetitorlost;
  }
  
  public void setOthercompetitorlost(String othercompetitorlost) {
    this.othercompetitorlost = othercompetitorlost;
  }
  
  public String getCreatedon() {
    return this.createdon;
  }
  
  public void setCreatedon(String createdon) {
    this.createdon = createdon;
  }
  
  public String getUpdatedon() {
    return this.updatedon;
  }
  
  public void setUpdatedon(String updatedon) {
    this.updatedon = updatedon;
  }
  
  public String getBuildcomplexity() {
    return this.buildcomplexity;
  }
  
  public void setBuildcomplexity(String buildcomplexity) {
    this.buildcomplexity = buildcomplexity;
  }
  
  public static String getDbusername() {
    return dbusername;
  }
  
  public static void setDbusername(String dbusername) {
    opportunity.dbusername = dbusername;
  }
  
  public static String getDbpassword() {
    return dbpassword;
  }
  
  public static void setDbpassword(String dbpassword) {
    opportunity.dbpassword = dbpassword;
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
        String sMonth = s[0];
        if (sMonth.length() == 1)
          sMonth = "0" + sMonth; 
        String sDay = s[1];
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
    String query = "SELECT `id` from `opportunity` where `idrecord`=\"" + sIDRecord + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String id = "";
      int i = 1;
      if (rs.next()) {
        id = (new StringBuilder(String.valueOf(rs.getInt("id")))).toString();
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
  
  public void dbUpdateOpportunity() {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    PreparedStatement preparedStmt = null;
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      String sID = queryIDRecord(getIdrecord());
      setId(sID);
      if (sID.isEmpty()) {
        sQuery = "INSERT INTO `opportunity`(`idrecord`, `idopportunity`, `name`, `description`, `nextstep`, `type`, `recordtype`, `source`, `partner`, `currency`, `score`, `probability`, `amount`, `amountusd`, `forecast`, `stage`, `laststagechange`, `createon`, `closeon`, `updateon`, `idcreateby`, `createby`, `idaccount`, `accountname`, `industry`, `subindustry`, `idparentaccount`, `parentaccount`, `region`, `salesregion`, `salesteam`, `cyclephase`, `wonreason`, `wondescription`, `wonamount`, `wonamountusd`, `solutionstructure`, `solutionscope`, `geographic`, `model`, `techrevenueusd`, `techgp`, `msrevenueusd`, `msgp`, `csrevenueusd`, `csgp`, `ssrevenueusd`, `ssgp`, `tsrevenueusd`, `tsgp`, `totalgpusd`, `techbgp`, `msbgp`, `csbgp`, `ssbgp`, `tsbgp`, `totalbgp`, `collaboration`, `collaborationpartner`, `engagementtype`, `prime`, `discovery`, `globalcompetitor`, `globalcompetitorlost`, `othercompetitor`, `othercompetitorlost`, `createdon`, `updatedon`, `buildcomplexity`,`accountowner`,`accountowneralias`,`lastmodifyby`,`lastmodifybyalias`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdrecord());
        preparedStmt.setString(2, getIdopportunity());
        preparedStmt.setString(3, getName());
        preparedStmt.setString(4, getDescription());
        preparedStmt.setString(5, getNextstep());
        preparedStmt.setString(6, getType());
        preparedStmt.setString(7, getRecordtype());
        preparedStmt.setString(8, getSource());
        preparedStmt.setString(9, getPartner());
        preparedStmt.setString(10, getCurrency());
        preparedStmt.setFloat(11, getFloatValue(getScore()).floatValue());
        preparedStmt.setFloat(12, getFloatValue(getProbability()).floatValue());
        preparedStmt.setFloat(13, getFloatValue(getAmount()).floatValue());
        preparedStmt.setFloat(14, getFloatValue(getAmountusd()).floatValue());
        preparedStmt.setString(15, getForecast());
        preparedStmt.setString(16, getStage());
        preparedStmt.setString(17, setMysqDate(getLaststagechange()));
        preparedStmt.setString(18, setMysqDate(getCreateon()));
        preparedStmt.setString(19, setMysqDate(getCloseon()));
        preparedStmt.setString(20, setMysqDate(getUpdateon()));
        preparedStmt.setString(21, getIdcreateby());
        preparedStmt.setString(22, getCreateby());
        preparedStmt.setString(23, getIdaccount());
        preparedStmt.setString(24, getAccountname());
        preparedStmt.setString(25, getIndustry());
        preparedStmt.setString(26, getSubindustry());
        preparedStmt.setString(27, getIdparentaccount());
        preparedStmt.setString(28, getParentaccount());
        preparedStmt.setString(29, getRegion());
        preparedStmt.setString(30, getSalesregion());
        preparedStmt.setString(31, getSalesteam());
        preparedStmt.setString(32, getCyclephase());
        preparedStmt.setString(33, getWonreason());
        preparedStmt.setString(34, getWondescription());
        preparedStmt.setFloat(35, getFloatValue(getWonamount()).floatValue());
        preparedStmt.setFloat(36, getFloatValue(getWonamountusd()).floatValue());
        preparedStmt.setString(37, getSolutionstructure());
        preparedStmt.setString(38, getSolutionscope());
        preparedStmt.setString(39, getGeographic());
        preparedStmt.setString(40, getModel());
        preparedStmt.setFloat(41, getFloatValue(getTechrevenueusd()).floatValue());
        preparedStmt.setFloat(42, getFloatValue(getTechgp()).floatValue());
        preparedStmt.setFloat(43, getFloatValue(getMsrevenueusd()).floatValue());
        preparedStmt.setFloat(44, getFloatValue(getMsgp()).floatValue());
        preparedStmt.setFloat(45, getFloatValue(getCsrevenueusd()).floatValue());
        preparedStmt.setFloat(46, getFloatValue(getCsgp()).floatValue());
        preparedStmt.setFloat(47, getFloatValue(getSsrevenueusd()).floatValue());
        preparedStmt.setFloat(48, getFloatValue(getSsgp()).floatValue());
        preparedStmt.setFloat(49, getFloatValue(getTsrevenueusd()).floatValue());
        preparedStmt.setFloat(50, getFloatValue(getTsgp()).floatValue());
        preparedStmt.setFloat(51, getFloatValue(getTotalgpusd()).floatValue());
        preparedStmt.setFloat(52, getFloatValue(getTechbgp()).floatValue());
        preparedStmt.setFloat(53, getFloatValue(getMsbgp()).floatValue());
        preparedStmt.setFloat(54, getFloatValue(getCsbgp()).floatValue());
        preparedStmt.setFloat(55, getFloatValue(getSsbgp()).floatValue());
        preparedStmt.setFloat(56, getFloatValue(getTsbgp()).floatValue());
        preparedStmt.setFloat(57, getFloatValue(getTotalbgp()).floatValue());
        preparedStmt.setString(58, getCollaboration());
        preparedStmt.setString(59, getCollaborationpartner());
        preparedStmt.setString(60, getEngagementtype());
        preparedStmt.setString(61, getPrime());
        preparedStmt.setString(62, getDiscovery());
        preparedStmt.setString(63, getGlobalcompetitor());
        preparedStmt.setString(64, getGlobalcompetitorlost());
        preparedStmt.setString(65, getOthercompetitor());
        preparedStmt.setString(66, getOthercompetitorlost());
        preparedStmt.setTimestamp(67, updatedAt);
        preparedStmt.setTimestamp(68, updatedAt);
        preparedStmt.setString(69, getBuildcomplexity());
        preparedStmt.setString(70, getAccountowner());
        preparedStmt.setString(71, getAccountowneralias());
        preparedStmt.setString(72, getLastmodifyby());
        preparedStmt.setString(73, getLastmodifybyalias());
        System.out.println(preparedStmt.toString());
        preparedStmt.execute();
        preparedStmt.close();
      } else {
        sQuery = "UPDATE `opportunity` SET `idrecord`=?,`idopportunity`=?,`name`=?,`description`=?,`nextstep`=?,`type`=?,`recordtype`=?,`source`=?,`partner`=?,`currency`=?,`score`=?,`probability`=?,`amount`=?,`amountusd`=?,`forecast`=?,`stage`=?,`laststagechange`=?,`createon`=?,`closeon`=?,`updateon`=?,`idcreateby`=?,`createby`=?,`idaccount`=?,`accountname`=?,`industry`=?,`subindustry`=?,`idparentaccount`=?,`parentaccount`=?,`region`=?,`salesregion`=?,`salesteam`=?,`cyclephase`=?,`wonreason`=?,`wondescription`=?,`wonamount`=?,`wonamountusd`=?,`solutionstructure`=?,`solutionscope`=?,`geographic`=?,`model`=?,`techrevenueusd`=?,`techgp`=?,`msrevenueusd`=?,`msgp`=?,`csrevenueusd`=?,`csgp`=?,`ssrevenueusd`=?,`ssgp`=?,`tsrevenueusd`=?,`tsgp`=?,`totalgpusd`=?,`techbgp`=?,`msbgp`=?,`csbgp`=?,`ssbgp`=?,`tsbgp`=?,`totalbgp`=?,`collaboration`=?,`collaborationpartner`=?,`engagementtype`=?,`prime`=?,`discovery`=?,`globalcompetitor`=?,`globalcompetitorlost`=?,`othercompetitor`=?,`othercompetitorlost`=?,`updatedon`=?, `buildcomplexity`=?, `accountowner`=?,`accountowneralias`=?,`lastmodifyby`=?,`lastmodifybyalias`=?  WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1, getIdrecord());
        preparedStmt.setString(2, getIdopportunity());
        preparedStmt.setString(3, getName());
        preparedStmt.setString(4, getDescription());
        preparedStmt.setString(5, getNextstep());
        preparedStmt.setString(6, getType());
        preparedStmt.setString(7, getRecordtype());
        preparedStmt.setString(8, getSource());
        preparedStmt.setString(9, getPartner());
        preparedStmt.setString(10, getCurrency());
        preparedStmt.setFloat(11, getFloatValue(getScore()).floatValue());
        preparedStmt.setFloat(12, getFloatValue(getProbability()).floatValue());
        preparedStmt.setFloat(13, getFloatValue(getAmount()).floatValue());
        preparedStmt.setFloat(14, getFloatValue(getAmountusd()).floatValue());
        preparedStmt.setString(15, getForecast());
        preparedStmt.setString(16, getStage());
        preparedStmt.setString(17, setMysqDate(getLaststagechange()));
        preparedStmt.setString(18, setMysqDate(getCreateon()));
        preparedStmt.setString(19, setMysqDate(getCloseon()));
        preparedStmt.setString(20, setMysqDate(getUpdateon()));
        preparedStmt.setString(21, getIdcreateby());
        preparedStmt.setString(22, getCreateby());
        preparedStmt.setString(23, getIdaccount());
        preparedStmt.setString(24, getAccountname());
        preparedStmt.setString(25, getIndustry());
        preparedStmt.setString(26, getSubindustry());
        preparedStmt.setString(27, getIdparentaccount());
        preparedStmt.setString(28, getParentaccount());
        preparedStmt.setString(29, getRegion());
        preparedStmt.setString(30, getSalesregion());
        preparedStmt.setString(31, getSalesteam());
        preparedStmt.setString(32, getCyclephase());
        preparedStmt.setString(33, getWonreason());
        preparedStmt.setString(34, getWondescription());
        preparedStmt.setFloat(35, getFloatValue(getWonamount()).floatValue());
        preparedStmt.setFloat(36, getFloatValue(getWonamountusd()).floatValue());
        preparedStmt.setString(37, getSolutionstructure());
        preparedStmt.setString(38, getSolutionscope());
        preparedStmt.setString(39, getGeographic());
        preparedStmt.setString(40, getModel());
        preparedStmt.setFloat(41, getFloatValue(getTechrevenueusd()).floatValue());
        preparedStmt.setFloat(42, getFloatValue(getTechgp()).floatValue());
        preparedStmt.setFloat(43, getFloatValue(getMsrevenueusd()).floatValue());
        preparedStmt.setFloat(44, getFloatValue(getMsgp()).floatValue());
        preparedStmt.setFloat(45, getFloatValue(getCsrevenueusd()).floatValue());
        preparedStmt.setFloat(46, getFloatValue(getCsgp()).floatValue());
        preparedStmt.setFloat(47, getFloatValue(getSsrevenueusd()).floatValue());
        preparedStmt.setFloat(48, getFloatValue(getSsgp()).floatValue());
        preparedStmt.setFloat(49, getFloatValue(getTsrevenueusd()).floatValue());
        preparedStmt.setFloat(50, getFloatValue(getTsgp()).floatValue());
        preparedStmt.setFloat(51, getFloatValue(getTotalgpusd()).floatValue());
        preparedStmt.setFloat(52, getFloatValue(getTechbgp()).floatValue());
        preparedStmt.setFloat(53, getFloatValue(getMsbgp()).floatValue());
        preparedStmt.setFloat(54, getFloatValue(getCsbgp()).floatValue());
        preparedStmt.setFloat(55, getFloatValue(getSsbgp()).floatValue());
        preparedStmt.setFloat(56, getFloatValue(getTsbgp()).floatValue());
        preparedStmt.setFloat(57, getFloatValue(getTotalbgp()).floatValue());
        preparedStmt.setString(58, getCollaboration());
        preparedStmt.setString(59, getCollaborationpartner());
        preparedStmt.setString(60, getEngagementtype());
        preparedStmt.setString(61, getPrime());
        preparedStmt.setString(62, getDiscovery());
        preparedStmt.setString(63, getGlobalcompetitor());
        preparedStmt.setString(64, getGlobalcompetitorlost());
        preparedStmt.setString(65, getOthercompetitor());
        preparedStmt.setString(66, getOthercompetitorlost());
        preparedStmt.setTimestamp(67, updatedAt);
        preparedStmt.setString(68, getBuildcomplexity());
        preparedStmt.setString(69, getAccountowner());
        preparedStmt.setString(70, getAccountowneralias());
        preparedStmt.setString(71, getLastmodifyby());
        preparedStmt.setString(72, getLastmodifybyalias());
        preparedStmt.setInt(73, getIntValue(sID));
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


/* Location:              D:\Rpa\rpappms\!\opportunity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */