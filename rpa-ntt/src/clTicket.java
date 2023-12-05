import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class clTicket {
	public String number ="";
	public String u_major_task ="";
	public String contact_type ="";
	public String u_ext_ref_no_calc ="";
	public String sys_created_on ="";
	public String closed_at ="";
	public String u_contract ="";
	public String u_vip ="";
	public String u_caller ="";
	public String u_caller_email ="";
	public String u_requested_for ="";
	public String u_requested_for_email ="";
	public String company ="";
	public String u_product ="";
	public String u_product_cmdb_ci_class ="";
	public String u_product_u_erp_reference ="";
	public String u_product_u_part_number ="";
	public String u_product_name ="";
	public String u_classification ="";
	public String u_classification_u_classification_0 ="";
	public String u_classification_u_classification_1 ="";
	public String u_classification_u_classification_2 ="";
	public String u_classification_u_classification_path ="";
	public String priority ="";
	public String u_next_step ="";
	public String u_next_step_displayed ="";
	public String state ="";
	public String incident_state ="";
	public String short_description ="";
	public String u_owner_group ="";
	public String u_owner_group_email ="";
	public String u_owner ="";
	public String u_owner_email ="";
	public String u_responsible_owner_group ="";
	public String u_responsible_owner_group_email ="";
	public String u_responsible_owner ="";
	public String getU_owner_group_email() {
		return u_owner_group_email;
	}

	public void setU_owner_group_email(String u_owner_group_email) {
		this.u_owner_group_email = u_owner_group_email;
	}

	public String getU_owner_email() {
		return u_owner_email;
	}

	public void setU_owner_email(String u_owner_email) {
		this.u_owner_email = u_owner_email;
	}

	public String u_responsible_owner_email ="";
	public String assignment_group ="";
	public String assignment_group_email ="";
	public String assigned_to ="";
	public String assigned_to_email ="";
	public String u_accepted ="";
	public String u_effort ="";
	public String calendar_stc ="";
	public String sys_updated_on ="";
	public String sys_updated_by ="";
	public String sys_created_by ="";
	public String opened_by ="";
	public String u_breach_code ="";
	public String u_breached ="";
	public String sys_class_name ="";
	public String comments ="";
	public String u_breach_caused_by ="";
	public String u_breach_comments ="";
	public String business_duration ="";
	public String sla_due ="";
	public String u_task_delay_comments ="";
	public String calendar_duration ="";
	public String u_estimated_duration ="";
	public String u_resolved_by ="";
	public String u_group_reassign_count ="";
	public String u_assignee_reassign_count ="";
	public String u_technology_u_name ="";
	public String u_auto_close_milestone ="";
	public String sys_mod_count ="";
	public String u_resolution_code ="";
	public String u_task_resolution_code ="";
	public String u_task_rootcause ="";
	public String u_task_rootcause_u_classification_0 ="";
	public String u_task_rootcause_u_classification_1 ="";
	public String u_task_rootcause_u_classification_2 ="";
	public String u_task_rootcause_u_classification_path ="";
	public String u_root_cause_comments ="";
	public String u_sip_information ="";
	public String close_notes ="";
	public String u_auto_close_acceptance ="";
	public String u_client_closure_comment ="";
	public String work_notes ="";
	
	
	
	//Additional
	public String idMHIS ="";
	public String idCapitaLand ="";
	
	public String dbCreatedOn ="";
	public String dbUpdatedOn =""; 
	
	//P1
	public String P1A ="";
	public String P1R ="";
	//P2
	public String P2A ="";
	public String P2R ="";	
	//P3
	public String P3A ="";
	public String P3R ="";
	//P4
	public String P4A ="";
	public String P4R =""; 
	
	
	public static String dbName="capitaland";
	
	
	
	
public String getU_responsible_owner_group_email() {
		return u_responsible_owner_group_email;
	}

	public void setU_responsible_owner_group_email(String u_responsible_owner_group_email) {
		this.u_responsible_owner_group_email = u_responsible_owner_group_email;
	}

	public String getU_responsible_owner_email() {
		return u_responsible_owner_email;
	}

	public void setU_responsible_owner_email(String u_responsible_owner_email) {
		this.u_responsible_owner_email = u_responsible_owner_email;
	}

	public String getAssignment_group_email() {
		return assignment_group_email;
	}

	public void setAssignment_group_email(String assignment_group_email) {
		this.assignment_group_email = assignment_group_email;
	}

	public String getAssigned_to_email() {
		return assigned_to_email;
	}

	public void setAssigned_to_email(String assigned_to_email) {
		this.assigned_to_email = assigned_to_email;
	}

	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		clTicket.dbName = dbName;
	}

public clTicket(String tmpDBName) {
	dbName=tmpDBName;
}
  
  public String getDbCreatedOn() {
		return dbCreatedOn;
	}

	public void setDbCreatedOn(String dbCreatedOn) {
		this.dbCreatedOn = dbCreatedOn;
	}

	public String getDbUpdatedOn() {
		return dbUpdatedOn;
	}

	public void setDbUpdatedOn(String dbUpdatedOn) {
		this.dbUpdatedOn = dbUpdatedOn;
	}

public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getU_major_task() {
		return u_major_task;
	}

	public void setU_major_task(String u_major_task) {
		this.u_major_task = u_major_task;
	}

	public String getContact_type() {
		return contact_type;
	}

	public void setContact_type(String contact_type) {
		this.contact_type = contact_type;
	}

	public String getU_ext_ref_no_calc() {
		return u_ext_ref_no_calc;
	}

	public void setU_ext_ref_no_calc(String u_ext_ref_no_calc) {
		this.u_ext_ref_no_calc = u_ext_ref_no_calc;
	}

	public String getSys_created_on() {
		return sys_created_on;
	}

	public void setSys_created_on(String sys_created_on) {
		this.sys_created_on = sys_created_on;
	}

	public String getClosed_at() {
		return closed_at;
	}

	public void setClosed_at(String closed_at) {
		this.closed_at = closed_at;
	}

	public String getU_contract() {
		return u_contract;
	}

	public void setU_contract(String u_contract) {
		this.u_contract = u_contract;
	}

	public String getU_vip() {
		return u_vip;
	}

	public void setU_vip(String u_vip) {
		this.u_vip = u_vip;
	}

	public String getU_caller() {
		return u_caller;
	}

	public void setU_caller(String u_caller) {
		this.u_caller = u_caller;
	}

	public String getU_caller_email() {
		return u_caller_email;
	}

	public void setU_caller_email(String u_caller_email) {
		this.u_caller_email = u_caller_email;
	}

	public String getU_requested_for() {
		return u_requested_for;
	}

	public void setU_requested_for(String u_requested_for) {
		this.u_requested_for = u_requested_for;
	}

	public String getU_requested_for_email() {
		return u_requested_for_email;
	}

	public void setU_requested_for_email(String u_requested_for_email) {
		this.u_requested_for_email = u_requested_for_email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getU_product() {
		return u_product;
	}

	public void setU_product(String u_product) {
		this.u_product = u_product;
	}

	public String getU_product_cmdb_ci_class() {
		return u_product_cmdb_ci_class;
	}

	public void setU_product_cmdb_ci_class(String u_product_cmdb_ci_class) {
		this.u_product_cmdb_ci_class = u_product_cmdb_ci_class;
	}

	public String getU_product_u_erp_reference() {
		return u_product_u_erp_reference;
	}

	public void setU_product_u_erp_reference(String u_product_u_erp_reference) {
		this.u_product_u_erp_reference = u_product_u_erp_reference;
	}

	public String getU_product_u_part_number() {
		return u_product_u_part_number;
	}

	public void setU_product_u_part_number(String u_product_u_part_number) {
		this.u_product_u_part_number = u_product_u_part_number;
	}

	public String getU_product_name() {
		return u_product_name;
	}

	public void setU_product_name(String u_product_name) {
		this.u_product_name = u_product_name;
	}

	public String getU_classification() {
		return u_classification;
	}

	public void setU_classification(String u_classification) {
		this.u_classification = u_classification;
	}

	public String getU_classification_u_classification_0() {
		return u_classification_u_classification_0;
	}

	public void setU_classification_u_classification_0(String u_classification_u_classification_0) {
		this.u_classification_u_classification_0 = u_classification_u_classification_0;
	}

	public String getU_classification_u_classification_1() {
		return u_classification_u_classification_1;
	}

	public void setU_classification_u_classification_1(String u_classification_u_classification_1) {
		this.u_classification_u_classification_1 = u_classification_u_classification_1;
	}

	public String getU_classification_u_classification_2() {
		return u_classification_u_classification_2;
	}

	public void setU_classification_u_classification_2(String u_classification_u_classification_2) {
		this.u_classification_u_classification_2 = u_classification_u_classification_2;
	}

	public String getU_classification_u_classification_path() {
		return u_classification_u_classification_path;
	}

	public void setU_classification_u_classification_path(String u_classification_u_classification_path) {
		this.u_classification_u_classification_path = u_classification_u_classification_path;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getU_next_step() {
		return u_next_step;
	}

	public void setU_next_step(String u_next_step) {
		this.u_next_step = u_next_step;
	}

	public String getU_next_step_displayed() {
		return u_next_step_displayed;
	}

	public void setU_next_step_displayed(String u_next_step_displayed) {
		this.u_next_step_displayed = u_next_step_displayed;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIncident_state() {
		return incident_state;
	}

	public void setIncident_state(String incident_state) {
		this.incident_state = incident_state;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getU_owner_group() {
		return u_owner_group;
	}

	public void setU_owner_group(String u_owner_group) {
		this.u_owner_group = u_owner_group;
	}

	public String getU_owner() {
		return u_owner;
	}

	public void setU_owner(String u_owner) {
		this.u_owner = u_owner;
	}

	public String getU_responsible_owner_group() {
		return u_responsible_owner_group;
	}

	public void setU_responsible_owner_group(String u_responsible_owner_group) {
		this.u_responsible_owner_group = u_responsible_owner_group;
	}

	public String getU_responsible_owner() {
		return u_responsible_owner;
	}

	public void setU_responsible_owner(String u_responsible_owner) {
		this.u_responsible_owner = u_responsible_owner;
	}

	public String getAssignment_group() {
		return assignment_group;
	}

	public void setAssignment_group(String assignment_group) {
		this.assignment_group = assignment_group;
	}

	public String getAssigned_to() {
		return assigned_to;
	}

	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}

	public String getU_accepted() {
		return u_accepted;
	}

	public void setU_accepted(String u_accepted) {
		this.u_accepted = u_accepted;
	}

	public String getU_effort() {
		return u_effort;
	}

	public void setU_effort(String u_effort) {
		this.u_effort = u_effort;
	}

	public String getCalendar_stc() {
		return calendar_stc;
	}

	public void setCalendar_stc(String calendar_stc) {
		this.calendar_stc = calendar_stc;
	}

	public String getSys_updated_on() {
		return sys_updated_on;
	}

	public void setSys_updated_on(String sys_updated_on) {
		this.sys_updated_on = sys_updated_on;
	}

	public String getSys_updated_by() {
		return sys_updated_by;
	}

	public void setSys_updated_by(String sys_updated_by) {
		this.sys_updated_by = sys_updated_by;
	}

	public String getSys_created_by() {
		return sys_created_by;
	}

	public void setSys_created_by(String sys_created_by) {
		this.sys_created_by = sys_created_by;
	}

	public String getOpened_by() {
		return opened_by;
	}

	public void setOpened_by(String opened_by) {
		this.opened_by = opened_by;
	}

	public String getU_breach_code() {
		return u_breach_code;
	}

	public void setU_breach_code(String u_breach_code) {
		this.u_breach_code = u_breach_code;
	}

	public String getU_breached() {
		return u_breached;
	}

	public void setU_breached(String u_breached) {
		this.u_breached = u_breached;
	}

	public String getSys_class_name() {
		return sys_class_name;
	}

	public void setSys_class_name(String sys_class_name) {
		this.sys_class_name = sys_class_name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getU_breach_caused_by() {
		return u_breach_caused_by;
	}

	public void setU_breach_caused_by(String u_breach_caused_by) {
		this.u_breach_caused_by = u_breach_caused_by;
	}

	public String getU_breach_comments() {
		return u_breach_comments;
	}

	public void setU_breach_comments(String u_breach_comments) {
		this.u_breach_comments = u_breach_comments;
	}

	public String getBusiness_duration() {
		return business_duration;
	}

	public void setBusiness_duration(String business_duration) {
		this.business_duration = business_duration;
	}

	public String getSla_due() {
		return sla_due;
	}

	public void setSla_due(String sla_due) {
		this.sla_due = sla_due;
	}

	public String getU_task_delay_comments() {
		return u_task_delay_comments;
	}

	public void setU_task_delay_comments(String u_task_delay_comments) {
		this.u_task_delay_comments = u_task_delay_comments;
	}

	public String getCalendar_duration() {
		return calendar_duration;
	}

	public void setCalendar_duration(String calendar_duration) {
		this.calendar_duration = calendar_duration;
	}

	public String getU_estimated_duration() {
		return u_estimated_duration;
	}

	public void setU_estimated_duration(String u_estimated_duration) {
		this.u_estimated_duration = u_estimated_duration;
	}

	public String getU_resolved_by() {
		return u_resolved_by;
	}

	public void setU_resolved_by(String u_resolved_by) {
		this.u_resolved_by = u_resolved_by;
	}

	public String getU_group_reassign_count() {
		return u_group_reassign_count;
	}

	public void setU_group_reassign_count(String u_group_reassign_count) {
		this.u_group_reassign_count = u_group_reassign_count;
	}

	public String getU_assignee_reassign_count() {
		return u_assignee_reassign_count;
	}

	public void setU_assignee_reassign_count(String u_assignee_reassign_count) {
		this.u_assignee_reassign_count = u_assignee_reassign_count;
	}

	public String getU_technology_u_name() {
		return u_technology_u_name;
	}

	public void setU_technology_u_name(String u_technology_u_name) {
		this.u_technology_u_name = u_technology_u_name;
	}

	public String getU_auto_close_milestone() {
		return u_auto_close_milestone;
	}

	public void setU_auto_close_milestone(String u_auto_close_milestone) {
		this.u_auto_close_milestone = u_auto_close_milestone;
	}

	public String getSys_mod_count() {
		return sys_mod_count;
	}

	public void setSys_mod_count(String sys_mod_count) {
		this.sys_mod_count = sys_mod_count;
	}

	public String getU_resolution_code() {
		return u_resolution_code;
	}

	public void setU_resolution_code(String u_resolution_code) {
		this.u_resolution_code = u_resolution_code;
	}

	public String getU_task_resolution_code() {
		return u_task_resolution_code;
	}

	public void setU_task_resolution_code(String u_task_resolution_code) {
		this.u_task_resolution_code = u_task_resolution_code;
	}

	public String getU_task_rootcause() {
		return u_task_rootcause;
	}

	public void setU_task_rootcause(String u_task_rootcause) {
		this.u_task_rootcause = u_task_rootcause;
	}

	public String getU_task_rootcause_u_classification_0() {
		return u_task_rootcause_u_classification_0;
	}

	public void setU_task_rootcause_u_classification_0(String u_task_rootcause_u_classification_0) {
		this.u_task_rootcause_u_classification_0 = u_task_rootcause_u_classification_0;
	}

	public String getU_task_rootcause_u_classification_1() {
		return u_task_rootcause_u_classification_1;
	}

	public void setU_task_rootcause_u_classification_1(String u_task_rootcause_u_classification_1) {
		this.u_task_rootcause_u_classification_1 = u_task_rootcause_u_classification_1;
	}

	public String getU_task_rootcause_u_classification_2() {
		return u_task_rootcause_u_classification_2;
	}

	public void setU_task_rootcause_u_classification_2(String u_task_rootcause_u_classification_2) {
		this.u_task_rootcause_u_classification_2 = u_task_rootcause_u_classification_2;
	}

	public String getU_task_rootcause_u_classification_path() {
		return u_task_rootcause_u_classification_path;
	}

	public void setU_task_rootcause_u_classification_path(String u_task_rootcause_u_classification_path) {
		this.u_task_rootcause_u_classification_path = u_task_rootcause_u_classification_path;
	}

	public String getU_root_cause_comments() {
		return u_root_cause_comments;
	}

	public void setU_root_cause_comments(String u_root_cause_comments) {
		this.u_root_cause_comments = u_root_cause_comments;
	}

	public String getU_sip_information() {
		return u_sip_information;
	}

	public void setU_sip_information(String u_sip_information) {
		this.u_sip_information = u_sip_information;
	}

	public String getClose_notes() {
		return close_notes;
	}

	public void setClose_notes(String close_notes) {
		this.close_notes = close_notes;
	}

	public String getU_auto_close_acceptance() {
		return u_auto_close_acceptance;
	}

	public void setU_auto_close_acceptance(String u_auto_close_acceptance) {
		this.u_auto_close_acceptance = u_auto_close_acceptance;
	}

	public String getU_client_closure_comment() {
		return u_client_closure_comment;
	}

	public void setU_client_closure_comment(String u_client_closure_comment) {
		this.u_client_closure_comment = u_client_closure_comment;
	}

	public String getWork_notes() {
		return work_notes;
	}

	public void setWork_notes(String work_notes) {
		this.work_notes = work_notes;
	}

	public String getIdMHIS() {
		return idMHIS;
	}

	public void setIdMHIS(String idMHIS) {
		this.idMHIS = idMHIS;
	}

	public String getIdCapitaLand() {
		return idCapitaLand;
	}

	public void setIdCapitaLand(String idCapitaLand) {
		this.idCapitaLand = idCapitaLand;
	}

	public String getP1A() {
		return P1A;
	}

	public void setP1A(String p1a) {
		P1A = p1a;
	}

	public String getP1R() {
		return P1R;
	}

	public void setP1R(String p1r) {
		P1R = p1r;
	}

	public String getP2A() {
		return P2A;
	}

	public void setP2A(String p2a) {
		P2A = p2a;
	}

	public String getP2R() {
		return P2R;
	}

	public void setP2R(String p2r) {
		P2R = p2r;
	}

	public String getP3A() {
		return P3A;
	}

	public void setP3A(String p3a) {
		P3A = p3a;
	}

	public String getP3R() {
		return P3R;
	}

	public void setP3R(String p3r) {
		P3R = p3r;
	}

	public String getP4A() {
		return P4A;
	}

	public void setP4A(String p4a) {
		P4A = p4a;
	}

	public String getP4R() {
		return P4R;
	}

	public void setP4R(String p4r) {
		P4R = p4r;
	}

	public static String getDbusername() {
		return dbusername;
	}

	public static void setDbusername(String dbusername) {
		clTicket.dbusername = dbusername;
	}

	public static String getDbpassword() {
		return dbpassword;
	}

	public static void setDbpassword(String dbpassword) {
		clTicket.dbpassword = dbpassword;
	}

public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String getDate(int iDays, String sPattern) {
	  ZonedDateTime yesterday = null;
	 
	  
	  yesterday = ZonedDateTime.now().with(ChronoField.NANO_OF_DAY, 0).plusDays(iDays);
		
		   //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
		 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(sPattern);
		  String dateEndStr = dateTimeFormatter.format(yesterday);
		  return dateEndStr;
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
  
  

	public static String convertDate(String sDate, String sFormat) {
		String rslt="";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterDest = new SimpleDateFormat(sFormat);
      

      try {

          Date date = formatter.parse(sDate);
          
          rslt=formatterDest.format(date);
      } catch (ParseException e) {
          e.printStackTrace();
      }
      return rslt;
	}
	
  public boolean dbLoadTicket() {
	boolean rslt=true;
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sQuery = "";
    String sStmt="";
    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
    PreparedStatement preparedStmt = null;
    try {
     if (getNumber().length()==12) {
      String sSelect = "Select `number` from `ticket` where `number`=\"" + getNumber() + "\"";
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
      if (rs.next()) {
        sQuery = "UPDATE `ticket` SET "
        		+ "`dbUpdatedOn`=?,"
        		+ "`u_major_task`=?,"
        		+ "`contact_type`=?,"
        		+ "`u_ext_ref_no_calc`=?,"
        		+ "`sys_created_on`=?,"
        		+ "`closed_at`=?,"
        		+ "`u_contract`=?,"
        		+ "`u_vip`=?,"
        		+ "`u_caller`=?,"
        		+ "`u_caller.email`=?,"
        		+ "`u_requested_for`=?,"
        		+ "`u_requested_for.email`=?,"
        		+ "`company`=?,"
        		+ "`u_product`=?,"
        		+ "`u_product.cmdb_ci_class`=?,"
        		+ "`u_product.u_erp_reference`=?,"
        		+ "`u_product.u_part_number`=?,"
        		+ "`u_product.name`=?,"
        		+ "`u_classification`=?,"
        		+ "`u_classification.u_classification_0`=?,"
        		+ "`u_classification.u_classification_1`=?,"
        		+ "`u_classification.u_classification_2`=?,"
        		+ "`u_classification.u_classification_path`=?,"
        		+ "`priority`=?,"
        		+ "`u_next_step`=?,"
        		+ "`u_next_step_displayed`=?,"
        		+ "`state`=?,"
        		+ "`incident_state`=?,"
        		+ "`short_description`=?,"
        		+ "`u_owner_group`=?,"
        		+ "`u_owner`=?,"
        		+ "`u_responsible_owner_group`=?,"
        		+ "`u_responsible_owner`=?,"
        		+ "`assignment_group`=?,"
        		+ "`assigned_to`=?,"
        		+ "`u_accepted`=?,"
        		+ "`u_effort`=?,"
        		+ "`calendar_stc`=?,"
        		+ "`sys_updated_on`=?,"
        		+ "`sys_updated_by`=?,"
        		+ "`sys_created_by`=?,"
        		+ "`opened_by`=?,"
        		+ "`u_breach_code`=?,"
        		+ "`u_breached`=?,"
        		+ "`sys_class_name`=?,"
        		+ "`comments`=?,"
        		+ "`u_breach_caused_by`=?,"
        		+ "`u_breach_comments`=?,"
        		+ "`business_duration`=?,"
        		+ "`sla_due`=?,"
        		+ "`u_task_delay_comments`=?,"
        		+ "`calendar_duration`=?,"
        		+ "`u_estimated_duration`=?,"
        		+ "`u_resolved_by`=?,"
        		+ "`u_group_reassign_count`=?,"
        		+ "`u_assignee_reassign_count`=?,"
        		+ "`u_technology.u_name`=?,"
        		+ "`u_auto_close_milestone`=?,"
        		+ "`sys_mod_count`=?,"
        		+ "`u_resolution_code`=?,"
        		+ "`u_task_resolution_code`=?,"
        		+ "`u_task_rootcause`=?,"
        		+ "`u_task_rootcause.u_classification_0`=?,"
        		+ "`u_task_rootcause.u_classification_1`=?,"
        		+ "`u_task_rootcause.u_classification_2`=?,"
        		+ "`u_task_rootcause.u_classification_path`=?,"
        		+ "`u_root_cause_comments`=?,"
        		+ "`u_sip_information`=?,"
        		+ "`close_notes`=?,"
        		+ "`u_auto_close_acceptance`=?,"
        		+ "`u_client_closure_comment`=?,"
        		+ "`work_notes`=?,"
        		+ "`idMHIS`=?,"
        		+ "`idCapitaLand`=?, "
        		+ "`u_owner_group_email`=?,"
        		+ "`u_owner_email`=?,"
        		+ "`u_responsible_owner_group_email`=?,"
        		+ "`u_responsible_owner_email`=?,"
        		+ "`assignment_group_email`=?,"
        		+ "`assigned_to_email`=? "
        		+ " WHERE `number`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1,updatedAt);
        preparedStmt.setString(2,getU_major_task());
        preparedStmt.setString(3,getContact_type());
        preparedStmt.setString(4,getU_ext_ref_no_calc());
        preparedStmt.setString(5,setSalesForceDateTimeFormat(getSys_created_on())); //datetime
        preparedStmt.setString(6,setSalesForceDateTimeFormat(getClosed_at())); //datetime
        preparedStmt.setString(7,getU_contract());
        preparedStmt.setString(8,getU_vip());
        preparedStmt.setString(9,getU_caller());
        preparedStmt.setString(10,getU_caller_email());
        preparedStmt.setString(11,getU_requested_for());
        preparedStmt.setString(12,getU_requested_for_email());
        preparedStmt.setString(13,getCompany());
        preparedStmt.setString(14,getU_product());
        preparedStmt.setString(15,getU_product_cmdb_ci_class());
        preparedStmt.setString(16,getU_product_u_erp_reference());
        preparedStmt.setString(17,getU_product_u_part_number());
        preparedStmt.setString(18,getU_product_name());
        preparedStmt.setString(19,getU_classification());
        preparedStmt.setString(20,getU_classification_u_classification_0());
        preparedStmt.setString(21,getU_classification_u_classification_1());
        preparedStmt.setString(22,getU_classification_u_classification_2());
        preparedStmt.setString(23,getU_classification_u_classification_path());
        preparedStmt.setString(24,getPriority());
        preparedStmt.setString(25,getU_next_step());
        preparedStmt.setString(26,getU_next_step_displayed());
        preparedStmt.setString(27,getState());
        preparedStmt.setString(28,getIncident_state());
        preparedStmt.setString(29,getShort_description());
        preparedStmt.setString(30,getU_owner_group());
        preparedStmt.setString(31,getU_owner());
        preparedStmt.setString(32,getU_responsible_owner_group());
        preparedStmt.setString(33,getU_responsible_owner());
        preparedStmt.setString(34,getAssignment_group());
        preparedStmt.setString(35,getAssigned_to());
        preparedStmt.setString(36,getU_accepted());
        preparedStmt.setString(37,getU_effort());
        preparedStmt.setString(38,setSalesForceDateTimeFormat(getCalendar_stc())); //datetime
        preparedStmt.setString(39,setSalesForceDateTimeFormat(getSys_updated_on()));//datetime
        preparedStmt.setString(40,getSys_updated_by());
        preparedStmt.setString(41,getSys_created_by());
        preparedStmt.setString(42,getOpened_by());
        preparedStmt.setString(43,getU_breach_code());
        preparedStmt.setString(44,getU_breached());
        preparedStmt.setString(45,getSys_class_name());
        preparedStmt.setString(46,getComments());
        preparedStmt.setString(47,getU_breach_caused_by());
        preparedStmt.setString(48,getU_breach_comments());
        preparedStmt.setInt(49,getIntValue(getBusiness_duration()));//int
        preparedStmt.setString(50,getSla_due());
        preparedStmt.setString(51,getU_task_delay_comments());
        preparedStmt.setInt(52,getIntValue(getCalendar_duration()));//int
        preparedStmt.setInt(53,getIntValue(getU_estimated_duration()));//int
        preparedStmt.setString(54,getU_resolved_by());
        preparedStmt.setInt(55,getIntValue(getU_group_reassign_count()));//int
        preparedStmt.setInt(56,getIntValue(getU_assignee_reassign_count()));//int
        preparedStmt.setString(57,getU_technology_u_name());
        preparedStmt.setString(58,setSalesForceDateTimeFormat(getU_auto_close_milestone()));
        preparedStmt.setInt(59,getIntValue(getSys_mod_count()));//int
        preparedStmt.setString(60,getU_resolution_code());
        preparedStmt.setString(61,getU_task_resolution_code());
        preparedStmt.setString(62,getU_task_rootcause());
        preparedStmt.setString(63,getU_task_rootcause_u_classification_0());
        preparedStmt.setString(64,getU_task_rootcause_u_classification_1());
        preparedStmt.setString(65,getU_task_rootcause_u_classification_2());
        preparedStmt.setString(66,getU_task_rootcause_u_classification_path());
        preparedStmt.setString(67,getU_root_cause_comments());
        preparedStmt.setString(68,getU_sip_information());
        preparedStmt.setString(69,getClose_notes());
        preparedStmt.setString(70,getU_auto_close_acceptance());
        preparedStmt.setString(71,getU_client_closure_comment());
        preparedStmt.setString(72,getWork_notes());
        preparedStmt.setString(73,getIdMHIS());
        preparedStmt.setString(74,getIdCapitaLand());
        
        
        
        preparedStmt.setString(75,getU_owner_group_email());
        preparedStmt.setString(76,getU_owner_email());
        preparedStmt.setString(77,getU_responsible_owner_group_email());
        preparedStmt.setString(78,getU_responsible_owner_email());
        preparedStmt.setString(79,getAssignment_group_email());
        preparedStmt.setString(80,getAssigned_to_email());
        
        preparedStmt.setString(81,getNumber());   
        sStmt= preparedStmt.toString();
        preparedStmt.execute();
        preparedStmt.executeUpdate();
        preparedStmt.close();     
      } else {
        sQuery = "INSERT INTO `ticket`(`number`, `u_major_task`, `contact_type`, `u_ext_ref_no_calc`, `sys_created_on`, `closed_at`, `u_contract`, "
        		+ "`u_vip`, `u_caller`, `u_caller.email`, `u_requested_for`, `u_requested_for.email`, `company`, "
        		+ "`u_product`, `u_product.cmdb_ci_class`, `u_product.u_erp_reference`, `u_product.u_part_number`, "
        		+ "`u_product.name`, `u_classification`, `u_classification.u_classification_0`, "
        		+ "`u_classification.u_classification_1`, `u_classification.u_classification_2`,"
        		+ " `u_classification.u_classification_path`, `priority`, `u_next_step`, `u_next_step_displayed`, `state`,"
        		+ " `incident_state`, `short_description`, `u_owner_group`, `u_owner`, `u_responsible_owner_group`,"
        		+ " `u_responsible_owner`, `assignment_group`, `assigned_to`, `u_accepted`, `u_effort`, `calendar_stc`,"
        		+ " `sys_updated_on`, `sys_updated_by`, `sys_created_by`, `opened_by`, `u_breach_code`, `u_breached`,"
        		+ " `sys_class_name`, `comments`, `u_breach_caused_by`, `u_breach_comments`, `business_duration`, `sla_due`, "
        		+ "`u_task_delay_comments`, `calendar_duration`, `u_estimated_duration`, `u_resolved_by`, `u_group_reassign_count`,"
        		+ " `u_assignee_reassign_count`, `u_technology.u_name`, `u_auto_close_milestone`, `sys_mod_count`, `u_resolution_code`, "
        		+ "`u_task_resolution_code`, `u_task_rootcause`, `u_task_rootcause.u_classification_0`, "
        		+ "`u_task_rootcause.u_classification_1`, `u_task_rootcause.u_classification_2`, `u_task_rootcause.u_classification_path`,"
        		+ " `u_root_cause_comments`, `u_sip_information`, `close_notes`, `u_auto_close_acceptance`, `u_client_closure_comment`,"
        		+ " `work_notes`, `idMHIS`, `idCapitaLand`, "
        		+ "`P1A`, `P1R`, `P2A`, `P2R`, `P3A`, `P3R`, `P4A`, `P4R`,`dbCreatedOn`, `dbUpdatedOn`,"
        		+ "`u_owner_group_email`,`u_owner_email`,`u_responsible_owner_group_email`,`u_responsible_owner_email`,`assignment_group_email`,`assigned_to_email` "
        		+ ") VALUES"
        		+ "(?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?,"
        		+ "?,?,?,?,?,?,?,?,?,?"
        		+ ")";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setString(1,getNumber());
        preparedStmt.setString(2,getU_major_task());
        preparedStmt.setString(3,getContact_type());
        preparedStmt.setString(4,getU_ext_ref_no_calc());
        preparedStmt.setString(5,setSalesForceDateTimeFormat(getSys_created_on())); //datetime
        preparedStmt.setString(6,setSalesForceDateTimeFormat(getClosed_at())); //datetime
        preparedStmt.setString(7,getU_contract());
        preparedStmt.setString(8,getU_vip());
        preparedStmt.setString(9,getU_caller());
        preparedStmt.setString(10,getU_caller_email());
        preparedStmt.setString(11,getU_requested_for());
        preparedStmt.setString(12,getU_requested_for_email());
        preparedStmt.setString(13,getCompany());
        preparedStmt.setString(14,getU_product());
        preparedStmt.setString(15,getU_product_cmdb_ci_class());
        preparedStmt.setString(16,getU_product_u_erp_reference());
        preparedStmt.setString(17,getU_product_u_part_number());
        preparedStmt.setString(18,getU_product_name());
        preparedStmt.setString(19,getU_classification());
        preparedStmt.setString(20,getU_classification_u_classification_0());
        preparedStmt.setString(21,getU_classification_u_classification_1());
        preparedStmt.setString(22,getU_classification_u_classification_2());
        preparedStmt.setString(23,getU_classification_u_classification_path());
        preparedStmt.setString(24,getPriority());
        preparedStmt.setString(25,getU_next_step());
        preparedStmt.setString(26,getU_next_step_displayed());
        preparedStmt.setString(27,getState());
        preparedStmt.setString(28,getIncident_state());
        preparedStmt.setString(29,getShort_description());
        preparedStmt.setString(30,getU_owner_group());
        preparedStmt.setString(31,getU_owner());
        preparedStmt.setString(32,getU_responsible_owner_group());
        preparedStmt.setString(33,getU_responsible_owner());
        preparedStmt.setString(34,getAssignment_group());
        preparedStmt.setString(35,getAssigned_to());
        preparedStmt.setString(36,getU_accepted());
        preparedStmt.setString(37,getU_effort());
        preparedStmt.setString(38,setSalesForceDateTimeFormat(getCalendar_stc())); //datetime
        preparedStmt.setString(39,setSalesForceDateTimeFormat(getSys_updated_on()));//datetime
        preparedStmt.setString(40,getSys_updated_by());
        preparedStmt.setString(41,getSys_created_by());
        preparedStmt.setString(42,getOpened_by());
        preparedStmt.setString(43,getU_breach_code());
        preparedStmt.setString(44,getU_breached());
        preparedStmt.setString(45,getSys_class_name());
        preparedStmt.setString(46,getComments());
        preparedStmt.setString(47,getU_breach_caused_by());
        preparedStmt.setString(48,getU_breach_comments());
        preparedStmt.setInt(49,getIntValue(getBusiness_duration()));//int
        preparedStmt.setString(50,getSla_due());
        preparedStmt.setString(51,getU_task_delay_comments());
        preparedStmt.setInt(52,getIntValue(getCalendar_duration()));//int
        preparedStmt.setInt(53,getIntValue(getU_estimated_duration()));//int
        preparedStmt.setString(54,getU_resolved_by());
        preparedStmt.setInt(55,getIntValue(getU_group_reassign_count()));//int
        preparedStmt.setInt(56,getIntValue(getU_assignee_reassign_count()));//int
        preparedStmt.setString(57,getU_technology_u_name());
        preparedStmt.setString(58,setSalesForceDateTimeFormat(getU_auto_close_milestone()));
        preparedStmt.setInt(59,getIntValue(getSys_mod_count()));//int
        preparedStmt.setString(60,getU_resolution_code());
        preparedStmt.setString(61,getU_task_resolution_code());
        preparedStmt.setString(62,getU_task_rootcause());
        preparedStmt.setString(63,getU_task_rootcause_u_classification_0());
        preparedStmt.setString(64,getU_task_rootcause_u_classification_1());
        preparedStmt.setString(65,getU_task_rootcause_u_classification_2());
        preparedStmt.setString(66,getU_task_rootcause_u_classification_path());
        preparedStmt.setString(67,getU_root_cause_comments());
        preparedStmt.setString(68,getU_sip_information());
        preparedStmt.setString(69,getClose_notes());
        preparedStmt.setString(70,getU_auto_close_acceptance());
        preparedStmt.setString(71,getU_client_closure_comment());
        preparedStmt.setString(72,getWork_notes());
        preparedStmt.setString(73,getIdMHIS());
        preparedStmt.setString(74,getIdCapitaLand());
        preparedStmt.setString(75,setSalesForceTimeFormat(getP1A()));
        preparedStmt.setString(76,setSalesForceTimeFormat(getP1R()));
        preparedStmt.setString(77,setSalesForceTimeFormat(getP2A()));
        preparedStmt.setString(78,setSalesForceTimeFormat(getP2R()));
        preparedStmt.setString(79,setSalesForceTimeFormat(getP3A()));
        preparedStmt.setString(80,setSalesForceTimeFormat(getP3R()));
        preparedStmt.setString(81,setSalesForceTimeFormat(getP4A()));
        preparedStmt.setString(82,setSalesForceTimeFormat(getP4R()));
        preparedStmt.setTimestamp(83,updatedAt);
        preparedStmt.setTimestamp(84,updatedAt);
        
        preparedStmt.setString(85,getU_owner_group_email());
        preparedStmt.setString(86,getU_owner_email());
        preparedStmt.setString(87,getU_responsible_owner_group_email());
        preparedStmt.setString(88,getU_responsible_owner_email());
        preparedStmt.setString(89,getAssignment_group_email());
        preparedStmt.setString(90,getAssigned_to_email());
        
        
        sStmt= preparedStmt.toString();
        preparedStmt.executeUpdate();
        preparedStmt.close();        
      } 
      rs.close();
      st.close();
      conn.close();
     }
    } catch (Exception e) {
    	rslt=false;
      System.out.println("ERROR: dbLoadTicket:" + sQuery);
      System.out.println("ERROR: dbLoadTicket:" + e.getMessage());
      System.out.println("ERROR: dbLoadTicket: SQL: " + sStmt);
      setShort_description("");      
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
  
  public static void main(String[] args) {
	  
	  clTicket cl= new clTicket("capitaland");
	  convertDate("2021-03-21","dd MMM yyyy");
	  System.out.println(cl.getTemplateClose("2021-03-21",""));
	  
  }
  
  public String getTemplatePriority(String sDate, String sPriority) {
		String rslt="";
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select count(`number`) as `total`, `assignmentGroup` from `pbiTicket` where `AlertTicket`=\"FALSE\" and `sys_created_on`=\"" + sDate + "\" and `priority`=\""+sPriority+"\" group by `sys_created_on`,`priority`,`assignmentGroup` limit 10";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      int i=0;
	      int iTotal=0;
	      String sDetail="";
	      String sTicket=" ticket";
	      while (rs.next()) {
	    	  if (i>0) {
	    		  sDetail=sDetail+", ";
	    	  }
	    	  
	          if (rs.getInt("total")>1) {
	        	  sTicket=" tickets";
	          } else {
	        	  sTicket=" ticket";
	          }
	    	  sDetail=sDetail+rs.getInt("total")+sTicket+" linked to "+ rs.getString("assignmentGroup");
	    	  iTotal=iTotal+rs.getInt("total");
	          i++;
	      } 
	      
	      if (iTotal>0) {
        	  rslt=rslt+"There ";
        	  if (iTotal==1) {
        		  rslt=rslt+"is ";
        	  } else rslt=rslt+"are ";
        	  rslt=rslt+iTotal+ " ticket";
        	  if (iTotal==1) {
        		  rslt=rslt+" ";
        	  } else rslt=rslt+"s ";
        	  rslt=rslt+ "as "+sPriority+": "+sDetail;
          }
	      
	      rs.close();
	      st.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	rslt="";
	      System.out.println("ERROR: getTemplatePriority:" + sQuery);
	      System.out.println("ERROR: getTemplatePriority:" + e.getMessage());
	      System.out.println("ERROR: getTemplatePriority: SQL: " + sStmt);
	      setShort_description("");      
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
	    
	    if (rslt.length()>0) rslt+=". ";
	    return rslt;
	  }
  
  public String getTemplateBusinessService(String sDate) {
		String rslt="";
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select count(`number`) as `total`, `u_classification.u_classification_0` from `pbiTicket` where `AlertTicket`=\"FALSE\" and `sys_created_on`=\"" + sDate + "\"  group by `sys_created_on`,`u_classification.u_classification_0` order by `total` desc";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      int i=0;
	      int iTotal=0;
	      String sDetail="";
	      String sTicket=" ticket";
	      while (rs.next()) {
	    	 
	    	  
	          if (rs.getInt("total")>1) {
	        	  sTicket=" tickets";
	          } else {
	        	  sTicket=" ticket";
	          }
	          if (i<10) {
	        	  if (i>0) {
		    		  sDetail=sDetail+", ";
		    	  }
	        	  sDetail=sDetail+rs.getInt("total")+sTicket+" linked to "+ rs.getString("u_classification.u_classification_0");
	          }
	    	  iTotal=iTotal+rs.getInt("total");
	          i++;
	      } 
	      
	      if (iTotal>0) {
	    
	      	  rslt=rslt+ sDetail;
	      }
	      
	      rs.close();
	      st.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	rslt="";
	      System.out.println("ERROR: getTemplateBusinessService:" + sQuery);
	      System.out.println("ERROR: getTemplateBusinessService:" + e.getMessage());
	      System.out.println("ERROR: getTemplateBusinessService: SQL: " + sStmt);
	      setShort_description("");      
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
	    
	    if (rslt.length()>0) rslt+=". ";
	    return rslt;
	  }
  
  

  public String getTemplateOpen(String sDate, String sTemplate) {
		String rslt="";
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select count(`number`) as `total`, `state` from `pbiTicket` where `AlertTicket`=\"FALSE\" and `stateGroup`=\"Open\" and `sys_created_on`<=\"" + sDate + "\"  group by `state` order by `total` desc";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      int i=0;
	      int iTotal=0;
	      String sDetail="";
	      String sTicket=" ticket";
	      String wipticket="0";
	      String resolvedticket="0";
	      String clientactionticket="0";
	      String externalproviderticket="0";
	      while (rs.next()) {
	    	  String tempStr="";
	    	  
	          if (rs.getInt("total")>1) {
	        	  sTicket=" tickets";
	          } else {
	        	  sTicket=" ticket";
	          }
	    	  sDetail=rs.getInt("total")+sTicket;
	    	  
	    	  String sState=rs.getString("state");
	    	  
	    	  if (sState.equals("Resolved")) {
	    		  resolvedticket=sDetail;
	    	  } else if (sState.equals("External provider action")) {
	    		  externalproviderticket=sDetail;
	    	  } else if (sState.equals("Client action")) {
	    		  clientactionticket=sDetail;
	    	  }
	    	  
	    	  iTotal=iTotal+rs.getInt("total");
	          i++;
	      } 
	      
	      if (iTotal>1) {
        	  sTicket=" tickets";
          } else {
        	  sTicket=" ticket";
          }
	      
	      wipticket=iTotal +sTicket;
	      
	      
	      /*
	      [wipticket] tickets still open. Ticket�s assignee needs to close [resolvedticket] resolved ticket, 
	      and follow-up with requestor for [clientactionticket] tickets pending for client action. 
	      There are [externalproviderticket] tickets still at external provider to provide the action.
	      */
	      
	     	sTemplate=sTemplate.replaceAll("\\[wipticket\\]", wipticket);
	     	sTemplate=sTemplate.replaceAll("\\[resolvedticket\\]", resolvedticket);
	     	sTemplate=sTemplate.replaceAll("\\[clientactionticket\\]", clientactionticket);
	     	sTemplate=sTemplate.replaceAll("\\[externalproviderticket\\]", externalproviderticket);
	     	
	     	rslt=sTemplate;
	     	
	     	
	     	//Get Top Open Business Unit for Work In progress & Active
	     	sSelect = "Select count(`number`) as `total`, `u_classification.u_classification_0` from `pbiTicket` where `AlertTicket`=\"FALSE\" and `stateGroup`=\"Open\" and (`state`='Work in progress' OR `state`='Active' ) group by `u_classification.u_classification_0` order by `total` desc";
		      
		      rs = (ResultSet)st.executeQuery(sSelect);
		      i=0;
		      iTotal=0;
		      sDetail="";
		      sTicket=" ticket";
		      
		      while (rs.next()) {
		    	  
		    	 
		    	  
		          if (rs.getInt("total")>1) {
		        	  sTicket=" tickets";
		          } else {
		        	  sTicket=" ticket";
		          }
		    	  
		          if (i<10) {
		        	  if (i>0) {
			    		  sDetail=sDetail+"<br />";
			    	  }
			    	  String sBussinessService=rs.getString("u_classification.u_classification_0");
			    	  if (sBussinessService.length()<3) {
			    		  sBussinessService="Others (Missing Business Services)";
			    	  }
			    	  sDetail=sDetail+sBussinessService+ ". "+rs.getInt("total")+sTicket+"";
		          }
		    	  iTotal=iTotal+rs.getInt("total");
		          i++;
		      } 
		      
		      if (iTotal>1) {
	        	  sTicket=" tickets";
	          } else {
	        	  sTicket=" ticket";
	          }
		      
		      wipticket=iTotal +sTicket;
		      
		      
		      sDetail="<br /><br /><b>Work in Progress</b>: "+wipticket+".<br />Top-10 Business Service:<br />"+sDetail;
		      
		      rslt=rslt+sDetail;
		      
		      
		      
		      
		    //Get Top Open Business Unit for Soft Closure : resolved, review, restored, deferred action
		     	sSelect = "Select count(`number`) as `total`, `u_classification.u_classification_0` from `pbiTicket` where `AlertTicket`=\"FALSE\" and  (`state`='Resolved' OR `state`='Review' OR `state`='Restored' ) group by `u_classification.u_classification_0` order by `total` desc";
			      
			      rs = (ResultSet)st.executeQuery(sSelect);
			      i=0;
			      iTotal=0;
			      sDetail="";
			      sTicket=" ticket";
			      
			      while (rs.next()) {
			    	  
			    	 
			    	  
			          if (rs.getInt("total")>1) {
			        	  sTicket=" tickets";
			          } else {
			        	  sTicket=" ticket";
			          }
			    	  
			          if (i<10) {
			        	  if (i>0) {
				    		  sDetail=sDetail+"<br />";
				    	  }
				    	  String sBussinessService=rs.getString("u_classification.u_classification_0");
				    	  if (sBussinessService.length()<3) {
				    		  sBussinessService="Others (Missing Business Services)";
				    	  }
				    	  sDetail=sDetail+sBussinessService+ ". "+rs.getInt("total")+sTicket+"";
			          }
			    	  iTotal=iTotal+rs.getInt("total");
			          i++;
			      } 
			      
			      if (iTotal>1) {
		        	  sTicket=" tickets";
		          } else {
		        	  sTicket=" ticket";
		          }
			      
			      wipticket=iTotal +sTicket;
			      
			      
			      sDetail="<br /><br /><b>Pending for Closure (resolved, review, restored)</b>: "+wipticket+".<br />Top-10 Business Service:<br />"+sDetail;
			      
			      rslt=rslt+sDetail;
			      
	     	
			      //
			      //Get Top Open Business Unit for Soft Closure : external provider action, client action
			     	sSelect = "Select count(`number`) as `total`, `u_classification.u_classification_0` from `pbiTicket` where `AlertTicket`=\"FALSE\" and  (`state`='External provider action' OR `state`='Client action') group by `u_classification.u_classification_0` order by `total` desc";
				      
				      rs = (ResultSet)st.executeQuery(sSelect);
				      i=0;
				      iTotal=0;
				      sDetail="";
				      sTicket=" ticket";
				      
				      while (rs.next()) {
				    	  
				    	 
				    	  
				          if (rs.getInt("total")>1) {
				        	  sTicket=" tickets";
				          } else {
				        	  sTicket=" ticket";
				          }
				    	  
				          if (i<10) {
				        	  if (i>0) {
					    		  sDetail=sDetail+"<br />";
					    	  }
					    	  String sBussinessService=rs.getString("u_classification.u_classification_0");
					    	  if (sBussinessService.length()<3) {
					    		  sBussinessService="Others (Missing Business Services)";
					    	  }
					    	  sDetail=sDetail+sBussinessService+ ". "+rs.getInt("total")+sTicket+"";
				          }
				    	  iTotal=iTotal+rs.getInt("total");
				          i++;
				      } 
				      
				      if (iTotal>1) {
			        	  sTicket=" tickets";
			          } else {
			        	  sTicket=" ticket";
			          }
				      
				      wipticket=iTotal +sTicket;
				      
				      
				      sDetail="<br /><br /><b>Pending for User or Vendors (external provider action, client action)</b>: "+wipticket+".<br />Top-10 Business Service:<br />"+sDetail;
				      
				      rslt=rslt+sDetail;
			      
	      rs.close();
	      st.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	rslt="";
	      System.out.println("ERROR: getTemplateOpen:" + sQuery);
	      System.out.println("ERROR: getTemplateOpen:" + e.getMessage());
	      System.out.println("ERROR: getTemplateOpen: SQL: " + sStmt);
	      setShort_description("");      
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
	    
	    if (rslt.length()>0) rslt+=". ";
	    return rslt;
	  }
  
  
  public String getTemplateClose(String sDate, String sTemplate) {
		String rslt="";
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select count(`number`) as `total`, `assignmentGroup` from `pbiTicket` where `AlertTicket`=\"FALSE\" and `stateGroup`<>\"Open\" and `closed_at`=\"" + sDate + "\"  group by `assignmentGroup` order by `total` desc";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      int i=0;
	      int iTotal=0;
	      String sDetail="";
	      String sTicket=" ticket";
	     
	      while (rs.next()) {
	    	  String tempStr="";
	    	  
	          if (rs.getInt("total")>1) {
	        	  sTicket=" tickets";
	          } else {
	        	  sTicket=" ticket";
	          }
	    	  	    	  
	    	  sDetail=sDetail+rs.getInt("total")+sTicket+" closed by "+ rs.getString("assignmentGroup")+". ";	    	 
	    	  
	    	  iTotal=iTotal+rs.getInt("total");
	          i++;
	      } 
	      
	      if (iTotal>0) {
	      	  rslt=rslt+"There ";
	      	  if (iTotal==1) {
	      		  rslt=rslt+"is ";
	      	  } else rslt=rslt+"are ";
	      	  rslt=rslt+iTotal+ " ticket";
	      	  if (iTotal==1) {
	      		  rslt=rslt+" ";
	      	  } else rslt=rslt+"s closed.";
	      	  rslt=rslt+ " "+sDetail;
	      }
	      
	    
	      //get Date
	      sSelect = "Select count(`number`) as `total`, `sys_created_on` from `pbiTicket` where `AlertTicket`=\"FALSE\" and `stateGroup`<>\"Open\" and `closed_at`=\"" + sDate + "\"  group by `assignmentGroup` order by `total` desc";
	      rs = (ResultSet)st.executeQuery(sSelect);
	      sDetail="";
	      i=0;iTotal=0;
	      while (rs.next()) {
	    	  String tempStr="";
	    	  if (i>0) {
	    		  sDetail=sDetail+", ";
	    	  }
	    	  
	    	  
	          if (rs.getInt("total")>1) {
	        	  sTicket=" tickets were";
	          } else {
	        	  sTicket=" ticket was";
	          }
	    	  	    	  
	    	  sDetail=sDetail+rs.getInt("total")+sTicket+" created on "+ convertDate(rs.getString("sys_created_on"),"dd MMM yyyy")+"";	    	 
	    	  
	    	  iTotal=iTotal+rs.getInt("total");
	          i++;
	      } 
	      
	      if (iTotal>0) {
	      	  rslt=rslt+ "Closed ticket from creation date perspective: "+sDetail;
	      }
	      
	     	
	     	//rslt=sTemplate;
	     	
	      rs.close();
	      st.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	rslt="";
	      System.out.println("ERROR: getTemplateClose:" + sQuery);
	      System.out.println("ERROR: getTemplateClose:" + e.getMessage());
	      System.out.println("ERROR: getTemplateClose: SQL: " + sStmt);
	      setShort_description("");      
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
	    
	    if (rslt.length()>0) rslt+=". ";
	    return rslt;
	  }
  
  public class ReminderObject {
	  String email;
	  String requestor;
	  String content;
	  String finalnotes;
  }
  
  public static List<ReminderObject> ArrReminderObject=null;
  
  
  private String getURL(String tmpStr) {
	     String sChangeURL="https://capitaland.service-now.com/task.do?sysparm_query==number%3d";
	      String sIncidentURL="https://capitaland.service-now.com/incident.do?sysparm_query=number%3d";
	      
	  String rslt="";
	  if (tmpStr.startsWith("INC")) {
		  rslt="<a href=\""+sIncidentURL+tmpStr+"\">"+tmpStr+" </a>";
	  } else {
		  rslt="<a href=\""+sChangeURL+tmpStr+"\">"+tmpStr+" </a>";
	  }
	  
	  return rslt;
  }
  
  
  private String getURLNTT(String tmpStr) {
	     String sChangeURL="https://dimensiondataservices.service-now.com/task.do?sysparm_query==number%3d";
	      String sIncidentURL="https://dimensiondataservices.service-now.com/incident.do?sysparm_query=number%3d";
	      
	  String rslt="";
	  if (tmpStr.startsWith("ICM")) {
		  rslt="<a href=\""+sIncidentURL+tmpStr+"\">"+tmpStr+" </a>";
	  } else {
		  rslt="<a href=\""+sChangeURL+tmpStr+"\">"+tmpStr+" </a>";
	  }
	  
	  return rslt;
}
  
  private String getLastUpdate(String tmpStr) {
	  String rslt="";
	  if (tmpStr.equals("1")) {
		  rslt="yesterday";
	  } else {
		  rslt=tmpStr + " days ago";
	  }
	  
	  return rslt;
  }
  
  
  private String getReminderType(String tmpStr) {
	  String rslt="";
	  if (tmpStr.equals("1") || tmpStr.equals("6")) {
		  rslt="First";
	  }   if (tmpStr.equals("9") || tmpStr.equals("2")) {
		  rslt="Second";
	  }   if (tmpStr.equals("12") || tmpStr.equals("3")) {
		  rslt="Third";
	  }   if (tmpStr.equals("19") || tmpStr.equals("4")) {
		  rslt="<font color=\"red\">FINAL*</font>";
	  }
	  
	  return rslt;
  }
  
  private String getReminderTypeCA(String tmpStr) {
	  String rslt="";
	  if (tmpStr.equals("4")) {
		  rslt="First";
	  }   if (tmpStr.equals("6")) {
		  rslt="Second";
	  }   if (tmpStr.equals("8")) {
		  rslt="<font color=\"red\">FINAL*</font>";
	  }
	  
	  return rslt;
  }
  
  
  /*
   * 
   *  private String getReminderType(String tmpStr) {
	  String rslt="";
	  if (tmpStr.equals("1") || tmpStr.equals("6")) {
		  rslt="First";
	  }   if (tmpStr.equals("7") || tmpStr.equals("2")) {
		  rslt="Second";
	  }   if (tmpStr.equals("14") || tmpStr.equals("3")) {
		  rslt="Third";
	  }   if (tmpStr.equals("21") || tmpStr.equals("4")) {
		  rslt="<font color=\"red\">FINAL*</font>";
	  }
	  
	  return rslt;
  }
  
   */
  
  
  public void initReminderObjectCA() {
	  	ArrReminderObject =   new LinkedList<>();
	    
	    
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select * from `pbiReminderCA`";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      
	      String sFinalNotes="<p>\r\n"
	      		+ "<font class=\"alert\" color=\"red\" size=\"2\"><i>* Ticket will be automatically closed if there is no response after 5 days from the Final reminder. After ticket closure, you may submit a new ticket to follow up on the same request</i></font>\r\n"
	      		+ "</p>";
	      
	      String sRslt="";
	      String sTRTemplate="<tr style=\"color:#000\" bgcolor=\"black\">\r\n"
	    	  		+ "          <td style=\"text-align: center;\" bgcolor=\"white\"> [no]</td>\r\n"
	    	  		+ "		  <td  bgcolor=\"white\"><br /><b>[tickets]</b><br /><br />\r\n"
	    	  		+ "		  <font color=\"#aaa\">Short description:</font><br />\r\n"
	    	  		+ "		  [short_descriptions] \r\n"
	    	  		+ "		  <p><font color=\"#aaa\">Last update:</font> [cl_lastupdateOld]</p>		  \r\n"
	    	  		+ "		  </td>\r\n"
	    	  		+ "		  <td style=\"text-align: center;\" bgcolor=\"white\">[reminderType]</td>	       \r\n"
	    	  		+ "	    </tr><tr><td colspan=3 bgcolor=\"#0072BC\"></td></tr>";
	      while (rs.next()) {
	    	  ReminderObject tmpReminderObj = new ReminderObject();
	    	  tmpReminderObj.email= rs.getString("u_caller.email");
	    	  tmpReminderObj.requestor = rs.getString("cl_requestor");
	    	  int iTotal= rs.getInt(1);
	    	  String iTRTemplate=sTRTemplate;
	    	  String sNTTTickets= rs.getString("ntt_tickets");
	    	  String sTickets= rs.getString("tickets");
	    	  
	    	  String sCL_lastupdateOld= rs.getString("cl_lastupdateOld");
	    	  String sCL_laststatechangeindays= rs.getString("cl_laststatechangeindays");
	    	  String sShort_descriptions= rs.getString("short_descriptions");
	    	  String sAssigned_to_email= rs.getString("assigned_to_email");
	    	  boolean isFinal=false;
	    	  try {
	    	  if (iTotal>1) {
	    		  //repeat tr
	    		  String[] aTickets = sTickets.split(";");
	    		  String[] aNTTTickets = sNTTTickets.split(";");
	    		  String[] aCL_lastupdateOld = sCL_lastupdateOld.split(";");
	    		  String[] aCL_laststatechangeindays = sCL_laststatechangeindays.split(";");
	    		  String[] aShort_descriptions = sShort_descriptions.split("##");
	    		  String[] aAssigned_to_email = sAssigned_to_email.split(";");
	    		  iTRTemplate="";
	    		  for (int i=0;i<iTotal;i++ ) {
	    			  iTRTemplate=iTRTemplate+sTRTemplate;
	    			  iTRTemplate=  iTRTemplate.replaceAll("\\[no\\]",  (i+1)+"");
		    		  iTRTemplate=  iTRTemplate.replaceAll("\\[tickets\\]",  aTickets[i] + "/ "+ aNTTTickets[i]);
		    		  iTRTemplate=  iTRTemplate.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(aCL_lastupdateOld[i]));
		    		  iTRTemplate=  iTRTemplate.replaceAll("\\[reminderType\\]",  getReminderTypeCA(aCL_lastupdateOld[i]));
		    		  iTRTemplate=  iTRTemplate.replaceAll("\\[short_descriptions\\]",  aShort_descriptions[i]);
		    		  System.out.println("Ticket-CA: "+  aTickets[i]+";"+tmpReminderObj.email);
		    		  if (aCL_lastupdateOld[i].equals("8")) isFinal=true;
	    		  }
	    	  } else {
	    		  iTRTemplate=  iTRTemplate.replaceAll("\\[no\\]",  "1");
	    		  iTRTemplate=  iTRTemplate.replaceAll("\\[tickets\\]",  sTickets + "/ " + sNTTTickets);
	    		  iTRTemplate=  iTRTemplate.replaceAll("\\[short_descriptions\\]",  sShort_descriptions);
	    		  iTRTemplate=  iTRTemplate.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    		  iTRTemplate=  iTRTemplate.replaceAll("\\[reminderType\\]",  getReminderTypeCA(sCL_lastupdateOld));
	    		  System.out.println("Ticket-CA: "+  sTickets+";"+tmpReminderObj.email);
	    		  if (sCL_lastupdateOld.equals("8")) isFinal=true;
	    	  }
	    	  } catch (Exception e1) {
	    		  System.out.println("Error: "+ e1.getLocalizedMessage());
	    	  }
	    	  tmpReminderObj.content=iTRTemplate;
	    	  ArrReminderObject.add(tmpReminderObj);
	    	  if (isFinal) {
	    		  tmpReminderObj.finalnotes=sFinalNotes;
	    	  } else {
	    		  tmpReminderObj.finalnotes="";
	    	  }
	      } 
	      
	    
	      rs.close();
	      st.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	
	      System.out.println("ERROR: initReminderObjectCA:" + sQuery);
	      System.out.println("ERROR: initReminderObjectCA:" + e.getMessage());
	      System.out.println("ERROR: initReminderObjectCA: SQL: " + sStmt);
	      setShort_description("");      
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
	    
	    
	    
	  }

  public void initReminderObjectEPA() {
	  	ArrReminderObject =   new LinkedList<>();
	    
	    
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select * from `pbiReminderEPA`";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      
	      String sFinalNotes="<p>\r\n"
	      		+ "<font class=\"alert\" color=\"red\" size=\"2\"><i>* Ticket will be automatically closed if there is no response after 5 days from the Final reminder. After ticket closure, you may submit a new ticket to follow up on the same request</i></font>\r\n"
	      		+ "</p>";
	      
	      String sTableTemplate="<div>\r\n"
	      		+ "  <table class=\"ticketTable\" cellpadding=\"1\" cellspacing=\"1\" width=\"100%\" bgcolor=\"#0072BC\" style=\" color:#fff; font-family: Arial, Helvetica, sans-serif; font-size: 12px; vertical-align: top;\">\r\n"
	      		+ "\r\n"
	      		+ "<tr bgcolor=\"#0072BC\">\r\n"
	      		+ "          <td style=\"text-align: center;\" >No</td>\r\n"
	      		+ "		  <td>Ticket</td>\r\n"
	      		+ "		  <td style=\"text-align: center;\" >Reminder</td>	  \r\n"
	      		+ "      \r\n"
	      		+ "	    </tr>\r\n"
	      		+ "\r\n"
	      		+ "	[TICKETS]		\r\n"
	      		+ "\r\n"
	      		+ "	</table>\r\n"
	      		+ "</div>";
	      
	    
	      
	      String sRslt="";
	      String sTRTemplate="<tr style=\"color:#000\" bgcolor=\"black\">\r\n"
	    	  		+ "          <td style=\"text-align: center;\" bgcolor=\"white\"> [no]</td>\r\n"
	    	  		+ "		  <td  bgcolor=\"white\"><br /><b>[tickets]</b><br /><br />\r\n"
	    	  		+ "		  <font color=\"#aaa\">Short description:</font><br />\r\n"
	    	  		+ "		  [short_descriptions] \r\n"
	    	  		+ "		  <p><font color=\"#aaa\">Last update:</font> [cl_lastupdateOld]</p>		  \r\n"
	    	  		+ "		  </td>\r\n"
	    	  		+ "		  <td style=\"text-align: center;\" bgcolor=\"white\">[reminderType]</td>	       \r\n"
	    	  		+ "	    </tr><tr><td colspan=3 bgcolor=\"#0072BC\"></td></tr>";
	      
	 
	      while (rs.next()) {
	    	  String sTableTemplateFirst="<div><b>1st Reminder</b> (Pending for action - 4 day)</div>"+sTableTemplate;
		      String sTableTemplateSecond="<div><b>2nd Reminder</b> (Pending for action - 6 day)</div>"+sTableTemplate;
//		      String sTableTemplateThird="<div><b>3rd Reminder</b> (Pending for action - 12 day)</div>"+sTableTemplate;
		      String sTableTemplateFinal="<div><b>Final Reminder</b> (Pending for action - 8 day)</div>"+sTableTemplate;
	    	  ReminderObject tmpReminderObj = new ReminderObject();
	    	  tmpReminderObj.email= rs.getString("email_to");
	    	  tmpReminderObj.requestor =rs.getString("u_classification.u_classification_0");
	    	  int iTotal= rs.getInt(1);
	    	  String iTRTemplate=sTRTemplate;
	    	  String iTRTemplateFirst="";
	    	  String iTRTemplateSecond="";
	    	  String iTRTemplateThird="";
	    	  String iTRTemplateFinal="";
	    	  boolean isFirstReminder=false;
	    	  boolean isSecondReminder=false;
	    	  boolean isThirdReminder=false;
	    	  boolean isFinalReminder=false;
	    	  int iFirst=0;
	    	  int iSecond=0;
	    	  int iThird=0;
	    	  int iFinal=0;
	    	  
	    	  String sNTTTickets= rs.getString("ntt_tickets");
	    	  String sTickets= rs.getString("tickets");
	    	  
	    	  String sRequestor = rs.getString("cl_requestor");
	    	  String sCL_lastupdateOld= rs.getString("cl_lastupdateOld");
	    	  String sCL_laststatechangeindays= rs.getString("cl_laststatechangeindays");
	    	  String sShort_descriptions= rs.getString("short_descriptions");
	    	  String sAssigned_to_email= rs.getString("assigned_to_email");
	    	  boolean isFinal=false;
	    	  try {
	    	  if (iTotal>1) {
	    		  //repeat tr
	    		  String[] aTickets = sTickets.split(";");
	    		  
	    		  String[] aCL_lastupdateOld = sCL_lastupdateOld.split(";");
	    		  String[] aCL_laststatechangeindays = sCL_laststatechangeindays.split(";");
	    		  String[] aShort_descriptions = sShort_descriptions.split("##");
	    		  String[] aAssigned_to_email = sAssigned_to_email.split(";");
	    		  iTRTemplate="";
	    		  for (int i=0;i<iTotal;i++ ) {
	    			  
		    		  
	    			  System.out.println("Ticket-EPA: "+  aTickets[i]);
		    		  
		    		  
		    		  if (aCL_lastupdateOld[i].equals("4")) {
		    			  iTRTemplateFirst=iTRTemplateFirst+sTRTemplate;
		    			  iFirst++;
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[no\\]", iFirst+"");
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[tickets\\]",  getURL(aTickets[i]));
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[short_descriptions\\]",  aShort_descriptions[i]);
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(aCL_lastupdateOld[i]));
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[reminderType\\]",  getReminderTypeCA(aCL_lastupdateOld[i]));
		    			  isFirstReminder=true;
		    		  } else if (aCL_lastupdateOld[i].equals("6")) {
		    			  iTRTemplateSecond=iTRTemplateSecond+sTRTemplate;
		    			  iSecond++;
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[no\\]",  iSecond+"");
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[tickets\\]",  getURL(aTickets[i]));
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[short_descriptions\\]",  aShort_descriptions[i]);
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(aCL_lastupdateOld[i]));
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[reminderType\\]",  getReminderTypeCA(aCL_lastupdateOld[i]));
		    			  isSecondReminder=true;
//		    		  } else  if (aCL_lastupdateOld[i].equals("12")) {
//		    			  iTRTemplateThird=iTRTemplateThird+sTRTemplate;
//		    			  iThird++;
//		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[no\\]",  iThird+"");
//		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[tickets\\]",  getURL(aTickets[i]));
//		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[short_descriptions\\]",  aShort_descriptions[i]);
//		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(aCL_lastupdateOld[i]));
//		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[reminderType\\]",  getReminderTypeCA(aCL_lastupdateOld[i]));
//		    			  isThirdReminder=true;
		    		  } else  if (aCL_lastupdateOld[i].equals("8")) {
		    			  iTRTemplateFinal=iTRTemplateFinal+sTRTemplate;
		    			  iFinal++;
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[no\\]", iFinal+"");
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[tickets\\]",   getURL(aTickets[i]));
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[short_descriptions\\]",  aShort_descriptions[i]);
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(aCL_lastupdateOld[i]));
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[reminderType\\]",  getReminderTypeCA(aCL_lastupdateOld[i]));
		    			  isFinalReminder=true;
		    		  } 
		    		  
	    		  }
	    	  } else {
	    		  System.out.println("Ticket-EPA: "+  sTickets);
	    		  if (sCL_lastupdateOld.equals("1")|| sCL_lastupdateOld.equals("4")) {
	    			  iTRTemplateFirst=sTRTemplate;
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[no\\]",  "1");
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[tickets\\]",  getURL(sTickets));
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[short_descriptions\\]",  sShort_descriptions);
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[reminderType\\]",  getReminderTypeCA(sCL_lastupdateOld));
	    			  isFirstReminder=true;
	    		  } else  if (sCL_lastupdateOld.equals("6")) {
	    			  iTRTemplateSecond=sTRTemplate;
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[no\\]",  "1");
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[tickets\\]",  getURL(sTickets));
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[short_descriptions\\]",  sShort_descriptions);
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[reminderType\\]",  getReminderTypeCA(sCL_lastupdateOld));
	    			  isSecondReminder=true;
//	    		  } else  if (sCL_lastupdateOld.equals("12")) {
//	    			  iTRTemplateThird=sTRTemplate;
//	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[no\\]",  "1");
//	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[tickets\\]",  getURL(sTickets));
//	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[short_descriptions\\]",  sShort_descriptions);
//	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
//	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[reminderType\\]",  getReminderType(sCL_lastupdateOld));
//	    			  isThirdReminder=true;
	    		  } else  if (sCL_lastupdateOld.equals("8")) {
	    			  iTRTemplateFinal=sTRTemplate;
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[no\\]",  "1");
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[tickets\\]",  getURL(sTickets));
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[short_descriptions\\]",  sShort_descriptions);
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[reminderType\\]",  getReminderTypeCA(sCL_lastupdateOld));
	    			  isFinalReminder=true;
	    		  } 
	    		  
	    	  }
	    	  } catch (Exception e1) {
	    		  System.out.println("Error: "+ e1.getLocalizedMessage());
	    	  }
	    	  
	    	  tmpReminderObj.content="";
	    	  
	    	  if (isFinalReminder) {
	    		  sTableTemplateFinal=sTableTemplateFinal.replaceAll("\\[TICKETS\\]", iTRTemplateFinal);
	    		  tmpReminderObj.content=tmpReminderObj.content+sTableTemplateFinal;
	    	  }
	    	  
//	    	  if (isThirdReminder) {
//	    		  sTableTemplateThird=sTableTemplateThird.replaceAll("\\[TICKETS\\]", iTRTemplateThird);
//	    		  tmpReminderObj.content=tmpReminderObj.content+sTableTemplateThird;
//	    	  }
	    	  
	    	  if (isSecondReminder) {
	    		  sTableTemplateSecond=sTableTemplateSecond.replaceAll("\\[TICKETS\\]", iTRTemplateSecond);
	    		  tmpReminderObj.content=tmpReminderObj.content+sTableTemplateSecond;
	    	  }
	    	  
	    	  if (isFirstReminder) {
	    		  sTableTemplateFirst=sTableTemplateFirst.replaceAll("\\[TICKETS\\]", iTRTemplateFirst);
	    		  tmpReminderObj.content=tmpReminderObj.content+sTableTemplateFirst;
	    	  }
	    	  
	    	  ArrReminderObject.add(tmpReminderObj);
	    	  if (isFinal) {
	    		  tmpReminderObj.finalnotes=sFinalNotes;
	    	  } else {
	    		  tmpReminderObj.finalnotes="";
	    	  }
	      } 
	      
	    
	      rs.close();
	      st.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	
	      System.out.println("ERROR: initReminderObjectEPA:" + sQuery);
	      System.out.println("ERROR: initReminderObjectEPA:" + e.getMessage());
	      System.out.println("ERROR: initReminderObjectEPA: SQL: " + sStmt);
	      setShort_description("");      
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
	    
	    
	    
	  }

  public void initReminderObjectWIP() {
	  	ArrReminderObject =   new LinkedList<>();
	    
	    
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select * from `pbiReminderWIP`";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      
	      String sFinalNotes="<p>\r\n"
	      		+ "<font class=\"alert\" color=\"red\" size=\"2\"><i>* Ticket will be automatically closed if there is no response after 7 days from the Final reminder. After ticket closure, you may submit a new ticket to follow up on the same request</i></font>\r\n"
	      		+ "</p>";
	      
	      String sTableTemplate="<div>\r\n"
	      		+ "  <table class=\"ticketTable\" cellpadding=\"1\" cellspacing=\"1\" width=\"100%\" bgcolor=\"#0072BC\" style=\" color:#fff; font-family: Arial, Helvetica, sans-serif; font-size: 12px; vertical-align: top;\">\r\n"
	      		+ "\r\n"
	      		+ "<tr bgcolor=\"#0072BC\">\r\n"
	      		+ "          <td style=\"text-align: center;\" >No</td>\r\n"
	      		+ "		  <td>Ticket</td>\r\n"
	      		+ "		  <td style=\"text-align: center;\" >Reminder</td>	  \r\n"
	      		+ "      \r\n"
	      		+ "	    </tr>\r\n"
	      		+ "\r\n"
	      		+ "	[TICKETS]		\r\n"
	      		+ "\r\n"
	      		+ "	</table>\r\n"
	      		+ "</div>";
	      
	    
	      
	      String sRslt="";
	      String sTRTemplate="<tr style=\"color:#000\" bgcolor=\"black\">\r\n"
	    	  		+ "          <td style=\"text-align: center;\" bgcolor=\"white\"> [no]</td>\r\n"
	    	  		+ "		  <td  bgcolor=\"white\"><br /><b>[tickets]</b><br /><br />\r\n"
	    	  		+ "		  <font color=\"#aaa\">Short description:</font><br />\r\n"
	    	  		+ "		  [short_descriptions] \r\n"
	    	  		+ "		  <p><font color=\"#aaa\">Last update:</font> [cl_lastupdateOld]</p>		  \r\n"
	    	  		+ "		  </td>\r\n"
	    	  		+ "		  <td style=\"text-align: center;\" bgcolor=\"white\">[reminderType]</td>	       \r\n"
	    	  		+ "	    </tr><tr><td colspan=3 bgcolor=\"#0072BC\"></td></tr>";
	      
	 
	      while (rs.next()) {
	    	   String sTableTemplateFirst="<div><b>1st Reminder</b> (Pending for action - 1 day)</div>"+sTableTemplate;
	 	      String sTableTemplateSecond="<div><b>2nd Reminder</b> (Pending for action - 2 day)</div>"+sTableTemplate;
	 	      String sTableTemplateThird="<div><b>3rd Reminder</b> (Pending for action - 3 day)</div>"+sTableTemplate;
	 	      String sTableTemplateFinal="<div><b>Final Reminder</b> (Pending for action - 4 day)</div>"+sTableTemplate;
	    	  ReminderObject tmpReminderObj = new ReminderObject();
	    	  tmpReminderObj.email= rs.getString("assigned_to_email");
	    	  tmpReminderObj.requestor =rs.getString("assigned_to_email");
	    	  int iTotal= rs.getInt(1);
	    	  String iTRTemplate=sTRTemplate;
	    	  String iTRTemplateFirst="";
	    	  String iTRTemplateSecond="";
	    	  String iTRTemplateThird="";
	    	  String iTRTemplateFinal="";
	    	  boolean isFirstReminder=false;
	    	  boolean isSecondReminder=false;
	    	  boolean isThirdReminder=false;
	    	  boolean isFinalReminder=false;
	    	  int iFirst=0;
	    	  int iSecond=0;
	    	  int iThird=0;
	    	  int iFinal=0;
	    	  
	    	  String sNTTTickets= rs.getString("ntt_tickets");
	    	  String sTickets= rs.getString("tickets");
	    	  String sNTTAssignmentGroup = rs.getString("NTT_assignment_group");
	    	  String sRequestor = rs.getString("cl_requestor");
	    	  String sCL_lastupdateOld= rs.getString("cl_lastupdateOld");
	    	  String sCL_laststatechangeindays= rs.getString("cl_laststatechangeindays");
	    	  String sShort_descriptions= rs.getString("short_descriptions");
	    	  String sAssigned_to_email= rs.getString("assigned_to_email");
	    	  boolean isFinal=false;
	    	  try {
	    	  if (iTotal>1) {
	    		  //repeat tr
	    		  String[] aTickets = sTickets.split(";");
	    		  String[] aNTTTickets = sNTTTickets.split(";");
	    		  String[] aNTTAssignmentGroup =sNTTAssignmentGroup.split(";");
	    		  String[] aCL_lastupdateOld = sCL_lastupdateOld.split(";");
	    		  String[] aCL_laststatechangeindays = sCL_laststatechangeindays.split(";");
	    		  String[] aShort_descriptions = sShort_descriptions.split("##");
	    		  String[] aAssigned_to_email = sAssigned_to_email.split(";");
	    		  iTRTemplate="";
	    		  for (int i=0;i<iTotal;i++ ) {
	    			  sCL_lastupdateOld=aCL_lastupdateOld[i];
		    		  
		    		  
		    		  
		    		  
		    		  if (aCL_lastupdateOld[i].equals("1")) {
		    			  iTRTemplateFirst=iTRTemplateFirst+sTRTemplate;
		    			  iFirst++;
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[no\\]", iFirst+"");
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[tickets\\]",  getURLNTT(aNTTTickets[i]) + "/ "+ getURL(aTickets[i])+ "  "+aNTTAssignmentGroup[i]);
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[short_descriptions\\]",  aShort_descriptions[i]);
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(aCL_lastupdateOld[i]));
		    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[reminderType\\]",  getReminderType(aCL_lastupdateOld[i]));
		    			  isFirstReminder=true;
		    		  } else if (aCL_lastupdateOld[i].equals("2")) {
		    			  iTRTemplateSecond=iTRTemplateSecond+sTRTemplate;
		    			  iSecond++;
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[no\\]",  iSecond+"");
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[tickets\\]",  getURLNTT(aNTTTickets[i]) + "/ "+ getURL(aTickets[i])+ "  "+aNTTAssignmentGroup[i]);
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[short_descriptions\\]",  aShort_descriptions[i]);
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(aCL_lastupdateOld[i]));
		    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[reminderType\\]",  getReminderType(aCL_lastupdateOld[i]));
		    			  isSecondReminder=true;
		    		  } else  if (aCL_lastupdateOld[i].equals("3")) {
		    			  iTRTemplateThird=iTRTemplateThird+sTRTemplate;
		    			  iThird++;
		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[no\\]",  iThird+"");
		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[tickets\\]",  getURLNTT(aNTTTickets[i]) + "/ "+ getURL(aTickets[i])+ "  "+aNTTAssignmentGroup[i]);
		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[short_descriptions\\]",  aShort_descriptions[i]);
		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(aCL_lastupdateOld[i]));
		    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[reminderType\\]",  getReminderType(aCL_lastupdateOld[i]));
		    			  isThirdReminder=true;
		    		  } else  if (aCL_lastupdateOld[i].equals("4")) {
		    			  iTRTemplateFinal=iTRTemplateFinal+sTRTemplate;
		    			  iFinal++;
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[no\\]", iFinal+"");
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[tickets\\]",   getURLNTT(aNTTTickets[i]) + "/ "+ getURL(aTickets[i])+ "  "+aNTTAssignmentGroup[i]);
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[short_descriptions\\]",  aShort_descriptions[i]);
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(aCL_lastupdateOld[i]));
		    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[reminderType\\]",  getReminderType(aCL_lastupdateOld[i]));
		    			  isFinalReminder=true;
		    		  } 
		    		  
	    		  }
	    	  } else {
	    		  
	    		  if (sCL_lastupdateOld.equals("1")) {
	    			  iTRTemplateFirst=sTRTemplate;
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[no\\]",  "1");
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[tickets\\]",  getURLNTT(sNTTTickets) + "/ "+getURL(sTickets)+ "  "+sNTTAssignmentGroup);
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[short_descriptions\\]",  sShort_descriptions);
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[reminderType\\]",  getReminderType(sCL_lastupdateOld));
	    			  isFirstReminder=true;
	    		  } else  if (sCL_lastupdateOld.equals("2")) {
	    			  iTRTemplateSecond=sTRTemplate;
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[no\\]",  "1");
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[tickets\\]",  getURLNTT(sNTTTickets) + "/ "+getURL(sTickets)+ "  "+sNTTAssignmentGroup);
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[short_descriptions\\]",  sShort_descriptions);
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[reminderType\\]",  getReminderType(sCL_lastupdateOld));
	    			  isSecondReminder=true;
	    		  } else  if (sCL_lastupdateOld.equals("3")) {
	    			  iTRTemplateThird=sTRTemplate;
	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[no\\]",  "1");
	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[tickets\\]",  getURLNTT(sNTTTickets) + "/ "+getURL(sTickets)+ "  "+sNTTAssignmentGroup);
	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[short_descriptions\\]",  sShort_descriptions);
	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[reminderType\\]",  getReminderType(sCL_lastupdateOld));
	    			  isThirdReminder=true;
	    		  } else  if (sCL_lastupdateOld.equals("4")) {
	    			  iTRTemplateFinal=sTRTemplate;
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[no\\]",  "1");
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[tickets\\]",  getURLNTT(sNTTTickets) + "/ "+getURL(sTickets)+ "  "+sNTTAssignmentGroup);
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[short_descriptions\\]",  sShort_descriptions);
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[reminderType\\]",  getReminderType(sCL_lastupdateOld));
	    			  isFinalReminder=true;
	    		  } 
	    		  
	    	  }
	    	  } catch (Exception e1) {
	    		  System.out.println("Error: "+ e1.getLocalizedMessage());
	    		  if (sCL_lastupdateOld.equals("1")) {
	    			
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[short_descriptions\\]",  "");
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateFirst=  iTRTemplateFirst.replaceAll("\\[reminderType\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  isFirstReminder=true;
	    		  } else  if (sCL_lastupdateOld.equals("2")) {
	    			
	    			
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[short_descriptions\\]",  "");
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateSecond=  iTRTemplateSecond.replaceAll("\\[reminderType\\]", getLastUpdate(sCL_lastupdateOld));
	    			  isSecondReminder=true;
	    		  } else  if (sCL_lastupdateOld.equals("3")) {
	    			 
	    	
	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[short_descriptions\\]",  "");
	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateThird=  iTRTemplateThird.replaceAll("\\[reminderType\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  isThirdReminder=true;
	    		  } else  if (sCL_lastupdateOld.equals("4")) {
	    		
	    		
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[short_descriptions\\]",  "");
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[cl_lastupdateOld\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  iTRTemplateFinal=  iTRTemplateFinal.replaceAll("\\[reminderType\\]",  getLastUpdate(sCL_lastupdateOld));
	    			  isFinalReminder=true;
	    		  } 
	    	  }
	    	  
	    	  tmpReminderObj.content="";
	    	  
	    	  if (isFinalReminder) {
	    		  sTableTemplateFinal=sTableTemplateFinal.replaceAll("\\[TICKETS\\]", iTRTemplateFinal);
	    		  tmpReminderObj.content=tmpReminderObj.content+sTableTemplateFinal;
	    	  }
	    	  
	    	  if (isThirdReminder) {
	    		  sTableTemplateThird=sTableTemplateThird.replaceAll("\\[TICKETS\\]", iTRTemplateThird);
	    		  tmpReminderObj.content=tmpReminderObj.content+sTableTemplateThird;
	    	  }
	    	  
	    	  if (isSecondReminder) {
	    		  sTableTemplateSecond=sTableTemplateSecond.replaceAll("\\[TICKETS\\]", iTRTemplateSecond);
	    		  tmpReminderObj.content=tmpReminderObj.content+sTableTemplateSecond;
	    	  }
	    	  
	    	  if (isFirstReminder) {
	    		  sTableTemplateFirst=sTableTemplateFirst.replaceAll("\\[TICKETS\\]", iTRTemplateFirst);
	    		  tmpReminderObj.content=tmpReminderObj.content+sTableTemplateFirst;
	    	  }
	    	  
	    	  ArrReminderObject.add(tmpReminderObj);
	    	  if (isFinal) {
	    		  tmpReminderObj.finalnotes=sFinalNotes;
	    	  } else {
	    		  tmpReminderObj.finalnotes="";
	    	  }
	      } 
	      
	    
	      rs.close();
	      st.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	
	      System.out.println("ERROR: initReminderObjectWIP:" + sQuery);
	      System.out.println("ERROR: initReminderObjectWIP:" + e.getMessage());
	      System.out.println("ERROR: initReminderObjectWIP: SQL: " + sStmt);
	      setShort_description("");      
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
	    
	    
	    
	  }
  public String[] getEmailAddress() {
		String[] rslt=null;
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      String sSelect = "Select `email` from `user` where `status`=1 and `email` is not NULL";
	      Statement st = (Statement)conn.createStatement();
	      ResultSet rs = (ResultSet)st.executeQuery(sSelect);
	      int i=0;
	      int iTotal=0;
	      String sRslt="";
	      while (rs.next()) {
	    	  if (i>0) {
	    		  sRslt=sRslt+", ";
	    	  }
	    	  
	         
	    	  sRslt=sRslt+ rs.getString("email");
	    	  
	          i++;
	      } 
	      
	      rslt= sRslt.split(",");
	      rs.close();
	      st.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	
	      System.out.println("ERROR: getEmailAddress:" + sQuery);
	      System.out.println("ERROR: getEmailAddress:" + e.getMessage());
	      System.out.println("ERROR: getEmailAddress: SQL: " + sStmt);
	      setShort_description("");      
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
  
  
  public String[] getSoftCloseTicketList(String sTicketType) {
		String[] rslt=null;
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      sQuery = "Select `number`, IF("
	      		+ "    ("
	      		+ "        ("
	      		+ "           `short_description` LIKE 'SCOM Alert -%'"
	      		+ "        ) OR("
	      		+ "            `short_description` LIKE 'Backup Alert -%'"
	      		+ "        )"
	      		+ "    ),"
	      		+ "    'TRUE',"
	      		+ "    IF("
	      		+ "        ("
	      		+ "            `short_description` LIKE 'Monitoring Alert -%'"
	      		+ "        ),"
	      		+ "        'TRUE',"
	      		+ "        'FALSE'"
	      		+ "    )"
	      		+ ") AS `AlertTicket` from `ticket` where `state` in ('Resolved', 'Review') and `sys_class_name`=? order by `AlertTicket` asc";
	      
	      preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);		      
          
          preparedStmt.setString(1,sTicketType);
          
          sStmt= preparedStmt.toString();
          
          
	      ResultSet rs = (ResultSet)preparedStmt.executeQuery();
	      int i=0;
	      int iTotal=0;
	      String sRslt="";
	      while (rs.next()) {
	    	  if (i>0) {
	    		  sRslt=sRslt+",";
	    	  }
	    	  
	         
	    	  sRslt=sRslt+ rs.getString("number") + "|" + rs.getString("AlertTicket");
	    	  
	          i++;
	      } 
	      
	      rslt= sRslt.split(",");
	      rs.close();
	      preparedStmt.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	
	      System.out.println("ERROR: getSoftCloseTicketList:" + sQuery);
	      System.out.println("ERROR: getSoftCloseTicketList:" + e.getMessage());
	      System.out.println("ERROR: getSoftCloseTicketList: SQL: " + sStmt);
	      setShort_description("");      
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
  
  
  public String[] getDAMAlertTickets(String sTicketType) {
		String[] rslt=null;
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    
	    PreparedStatement preparedStmt = null;
	    try {
	     
	      sQuery = "Select `number`, 'TRUE' AS `AlertTicket` from `ticket` where `state`='Work in progress' and `short_description` LIKE '%DAM Monitoring Alert%'";
	      
	      preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);		      
        
       
        sStmt= preparedStmt.toString();
        
        
	      ResultSet rs = (ResultSet)preparedStmt.executeQuery();
	      int i=0;
	      int iTotal=0;
	      String sRslt="";
	      while (rs.next()) {
	    	  if (i>0) {
	    		  sRslt=sRslt+",";
	    	  }
	    	  
	         
	    	  sRslt=sRslt+ rs.getString("number") + "|" + rs.getString("AlertTicket");
	    	  
	          i++;
	      } 
	      
	      rslt= sRslt.split(",");
	      rs.close();
	      preparedStmt.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	
	      System.out.println("ERROR: getSoftCloseTicketList:" + sQuery);
	      System.out.println("ERROR: getSoftCloseTicketList:" + e.getMessage());
	      System.out.println("ERROR: getSoftCloseTicketList: SQL: " + sStmt);
	      setShort_description("");      
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

  
  public String[] getVendorTickets(String sPrefix) {
		String[] rslt=null;
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    String sTicketPattern1= sPrefix +"%";
	    String sTicketPattern2= "%, "+sPrefix +"%";
	    PreparedStatement preparedStmt = null;
	    try {
	     
	    	   sQuery = "Select `number`,`u_ext_ref_no_calc` from `ticket` WHERE "
	    	   		+ " (`u_ext_ref_no_calc` LIKE ? OR `u_ext_ref_no_calc` LIKE ? ) AND `state` NOT IN ('Closed', 'Cancelled', 'Resolved')";
	    	   
	      
	      
	      preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);		      
	      preparedStmt.setString(1,sTicketPattern1);
      preparedStmt.setString(2,sTicketPattern2);
      
      sStmt= preparedStmt.toString();
      
      
	      ResultSet rs = (ResultSet)preparedStmt.executeQuery();
	      int i=0;
	      int iTotal=0;
	      String sRslt="";
	      while (rs.next()) {
	    	  if (i>0) {
	    		  sRslt=sRslt+";";
	    	  }
	    	  
	         
	    	  sRslt=sRslt+ rs.getString("number") + "|" + rs.getString("u_ext_ref_no_calc");
	    	  
	          i++;
	      } 
	      
	      rslt= sRslt.split(";");
	      rs.close();
	      preparedStmt.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	
	      System.out.println("ERROR: getVendorTickets:" + sQuery);
	      System.out.println("ERROR: getVendorTickets:" + e.getMessage());
	      System.out.println("ERROR: getVendorTickets: SQL: " + sStmt);
	      setShort_description("");      
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


  public String[] getEPAACATicketList(String sTicketType, String sTicketState) {
		String[] rslt=null;
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    
	    PreparedStatement preparedStmt = null;
	    try {
	     
	    	   sQuery = "Select `number`, IF("
	   	      		+ "    ("
	   	      		+ "        ("
	   	      		+ "           `short_description` LIKE 'SCOM Alert %'"
	   	      		+ "        ) OR("
	   	      		+ "            `short_description` LIKE 'Backup Alert %'"
	   	      		+ "        )"
	   	      		+ "    ),"
	   	      		+ "    'TRUE',"
	   	      		+ "    IF("
	   	      		+ "        ("
	   	      		+ "            `short_description` LIKE 'Monitoring Alert %'"
	   	      		+ "        ),"
	   	      		+ "        'TRUE',"
	   	      		+ "        'FALSE'"
	   	      		+ "    )"
	   	      		+ ") AS `AlertTicket`,`u_ext_ref_no_calc` from `ticket` where `state`=? and `sys_class_name`=?";
	    	   
	      
	      
	      preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);		      
	      preparedStmt.setString(1,sTicketState);
        preparedStmt.setString(2,sTicketType);
        
        sStmt= preparedStmt.toString();
        
        
	      ResultSet rs = (ResultSet)preparedStmt.executeQuery();
	      int i=0;
	      int iTotal=0;
	      String sRslt="";
	      while (rs.next()) {
	    	  if (i>0) {
	    		  sRslt=sRslt+",";
	    	  }
	    	  
	         
	    	  sRslt=sRslt+ rs.getString("number") + "|" + rs.getString("AlertTicket") + "|" + rs.getString("u_ext_ref_no_calc");
	    	  
	          i++;
	      } 
	      
	      rslt= sRslt.split(",");
	      rs.close();
	      preparedStmt.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	
	      System.out.println("ERROR: getEPAACATicketList:" + sQuery);
	      System.out.println("ERROR: getEPAACATicketList:" + e.getMessage());
	      System.out.println("ERROR: getEPAACATicketList: SQL: " + sStmt);
	      setShort_description("");      
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

  
  public String[] getPBITicketAssignmentGroup() {
		String[] rslt=null;
	    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
	    Connection conn = (Connection)db.getConnection();
	    String sQuery = "";
	    String sStmt="";
	    
	    PreparedStatement preparedStmt = null;
	    try {
	     
	    	  // sQuery = "Select `assignment_group` from `pbiTicket` where `assignment_group` like 'KEPSIN-IM%' group by `assignment_group` ";
	    	   sQuery= "Select `assignment_group` from `pbiTicket` where `assignment_group`  LIKE 'KEPSIN-PM%' OR `assignment_group`  LIKE 'KISIN-IM%' OR `assignment_group`  LIKE 'KLLSIN-IM%' OR `assignment_group`  LIKE 'KOMSIN-CM%' OR `assignment_group`  LIKE 'KOMSIN-IM%' group by `assignment_group` order BY `assignment_group` ASC";
	      
	      
	      preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);		      

      
      sStmt= preparedStmt.toString();
      
      
	      ResultSet rs = (ResultSet)preparedStmt.executeQuery();
	      int i=0;
	      int iTotal=0;
	      String sRslt="";
	      while (rs.next()) {
	    	  if (i>0) {
	    		  sRslt=sRslt+",";
	    	  }
	    	  
	         
	    	  sRslt=sRslt+ rs.getString("assignment_group");
	    	  
	          i++;
	      } 
	      
	      rslt= sRslt.split(",");
	      rs.close();
	      preparedStmt.close();
	      conn.close();
	     
	    } catch (Exception e) {
	    	
	      System.out.println("ERROR: getPBITicketAssignmentGroup:" + sQuery);
	      System.out.println("ERROR: getPBITicketAssignmentGroup:" + e.getMessage());
	      System.out.println("ERROR: getPBITicketAssignmentGroup: SQL: " + sStmt);
	      setShort_description("");      
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
  
  public void updateParentTicket(String sCLTicketID, String sParentTicket) {
		if ((sCLTicketID!=null) && (sParentTicket!=null)){
			if (sCLTicketID.trim().length()>8) {
			    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
			    Connection conn = (Connection)db.getConnection();
			    String sQuery = "";
			    String sStmt="";
			    Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
			    PreparedStatement preparedStmt = null;
			    try {
			     
			      sQuery = "UPDATE `ticket` set `number_change`=? where `u_ext_ref_no_calc` like ? ESCAPE '!'";
			      preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);		      
		          
		          preparedStmt.setString(1,sParentTicket);
		          preparedStmt.setString(2,"%"+sCLTicketID+"%");
		          
		          sStmt= preparedStmt.toString();
		          preparedStmt.execute();
		          preparedStmt.executeUpdate();
		          preparedStmt.close();   
			        
			        
			      
			      conn.close();
			     
			    } catch (Exception e) {
			    	
			      System.out.println("ERROR: updateParentTicket:" + sQuery);
			      System.out.println("ERROR: updateParentTicket:" + e.getMessage());
			      System.out.println("ERROR: updateParentTicket: SQL: " + sStmt);
			      setShort_description("");      
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
		    
			}
	    
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