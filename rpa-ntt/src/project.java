import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class project {
  public String id = "";
  
  public String idproject = "";
  
  public String idpm = "";
  
  public String BillingOffice = "";
  
  public String ProjectID = "";
  
  public String WBSElement = "";
  
  public String projectname = "";
  
  public String ProjectStatus = "";
  
  public String ProjectClassification = "";
  
  public String ProjectType = "";
  
  public String Client = "";
  
  public String Billable = "";
  
  public String ProjectManagersHealthAssessment = "";
  
  public String SystemGeneratedHealthAssessment = "";
  
  public String SystemGeneratedMetrics = "";
  
  public String ProjectManager = "";
  
  public String SONumber = "";
  
  public String ProposedPhase = "";
  
  public String BaselinedEndDate = "";
  
  public String ProjectCreationDate = "";
  
  public String ProjectClosedDate = "";
  
  public String LateDays = "";
  
  public String completeeffort = "";
  
  public String ProjectDescription = "";
  
  public String ReleaseToSAP = "";
  
  public String IncludesConsulting = "";
  
  public String CompanyCodeCurrency = "";
  
  public String ContractServiceValue = "";
  
  public String ContractServiceValueUSD = "";
  
  public String Baseline0 = "";
  
  public String Baseline1 = "";
  
  public String EAC = "";
  
  public String TotalDeliverableMilestones = "";
  
  public String CompletedDeliverableMilestones = "";
  
  public String TotalPaymentMilestones = "";
  
  public String BehindSchedule = "";
  
  public String TotalChanges = "";
  
  public String ClosedChanges = "";
  
  public String EscalatedChanges = "";
  
  public String TotalRisks = "";
  
  public String ClosedRisks = "";
  
  public String EscalatedRisks = "";
  
  public String TotalIssues = "";
  
  public String ClosedIssues = "";
  
  public String EscalatedIssues = "";
  
  public String updateon = "";
  
  public String createdon = "";
  
  public String clientid = "";
  
  public String contractid = "";
  
  public String contractno = "";
  
  public String pmname = "";
  
  public String POCP = "";
  
  public String TotalMaterialCost = "";
  
  public String SAPPlannedRevenue = "";
  
  public String SAPPlannedRevenueUSD = "";
  
  public String SAPPlannedExternalCost = "";
  
  public String PlannedInternalCostB0 = "";
  
  public String PlannedInternalCostB1 = "";
  
  public String PlannedInternalCostA = "";
  
  public String YTDActualRevRec = "";
  
  public String YTDActualRevRecP = "";
  
  public String L = "0";
  
  public String B = "0";
  
  public String P = "0";
  
  public String D = "0";
  
  public String NB0 = "";
  
  public String NB1 = "";
  
  public String idcontract = "";
  
  public String ContractCreationDate = "";
  
  public String ContractClosedDate = "";
  
  public String idrequest = "";
  
  public String RequestCreationDate = "";
  
  public String RequestClosedDate = "";
  
  public String RequestFinishDate = "";
  
  public String WorkflowStatus = "";
  
  public String assignedresource = "";
  
  public String getAssignedresource() {
    return this.assignedresource;
  }
  
  public void setAssignedresource(String assignedresource) {
    this.assignedresource = assignedresource;
  }
  
  public String getRequestFinishDate() {
    return this.RequestFinishDate;
  }
  
  public void setRequestFinishDate(String requestFinishDate) {
    this.RequestFinishDate = requestFinishDate;
  }
  
  public String getIdcontract() {
    return this.idcontract;
  }
  
  public void setIdcontract(String idcontract) {
    this.idcontract = idcontract;
  }
  
  public String getContractCreationDate() {
    return this.ContractCreationDate;
  }
  
  public void setContractCreationDate(String contractCreationDate) {
    this.ContractCreationDate = contractCreationDate;
  }
  
  public String getIdrequest() {
    return this.idrequest;
  }
  
  public void setIdrequest(String idrequest) {
    this.idrequest = idrequest;
  }
  
  public String getRequestCreationDate() {
    return this.RequestCreationDate;
  }
  
  public void setRequestCreationDate(String requestCreationDate) {
    this.RequestCreationDate = requestCreationDate;
  }
  
  public String getRequestClosedDate() {
    return this.RequestClosedDate;
  }
  
  public void setRequestClosedDate(String requestClosedDate) {
    this.RequestClosedDate = requestClosedDate;
  }
  
  public String getWorkflowStatus() {
    return this.WorkflowStatus;
  }
  
  public void setWorkflowStatus(String workflowStatus) {
    this.WorkflowStatus = workflowStatus;
  }
  
  public String getClientid() {
    return this.clientid;
  }
  
  public void setClientid(String clientid) {
    this.clientid = clientid;
  }
  
  public String getContractid() {
    return this.contractid;
  }
  
  public void setContractid(String contractid) {
    this.contractid = contractid;
  }
  
  public String getContractno() {
    return this.contractno;
  }
  
  public void setContractno(String contactno) {
    this.contractno = contactno;
  }
  
  public String getPmname() {
    return this.pmname;
  }
  
  public void setPmname(String pmname) {
    this.pmname = pmname;
  }
  
  public String getPOCP() {
    return this.POCP;
  }
  
  public void setPOCP(String pOCP) {
    this.POCP = pOCP;
  }
  
  public String getTotalMaterialCost() {
    return this.TotalMaterialCost;
  }
  
  public void setTotalMaterialCost(String totalMaterialCost) {
    this.TotalMaterialCost = totalMaterialCost;
  }
  
  public String getSAPPlannedRevenue() {
    return this.SAPPlannedRevenue;
  }
  
  public void setSAPPlannedRevenue(String sAPPlannedRevenue) {
    this.SAPPlannedRevenue = sAPPlannedRevenue;
  }
  
  public String getSAPPlannedRevenueUSD() {
    return this.SAPPlannedRevenueUSD;
  }
  
  public void setSAPPlannedRevenueUSD(String sAPPlannedRevenueUSD) {
    this.SAPPlannedRevenueUSD = sAPPlannedRevenueUSD;
  }
  
  public String getSAPPlannedExternalCost() {
    return this.SAPPlannedExternalCost;
  }
  
  public void setSAPPlannedExternalCost(String sAPPlannedExternalCost) {
    this.SAPPlannedExternalCost = sAPPlannedExternalCost;
  }
  
  public String getPlannedInternalCostB0() {
    return this.PlannedInternalCostB0;
  }
  
  public void setPlannedInternalCostB0(String plannedInternalCostB0) {
    this.PlannedInternalCostB0 = plannedInternalCostB0;
  }
  
  public String getPlannedInternalCostB1() {
    return this.PlannedInternalCostB1;
  }
  
  public void setPlannedInternalCostB1(String plannedInternalCostB1) {
    this.PlannedInternalCostB1 = plannedInternalCostB1;
  }
  
  public String getPlannedInternalCostA() {
    return this.PlannedInternalCostA;
  }
  
  public void setPlannedInternalCostA(String plannedInternalCostA) {
    this.PlannedInternalCostA = plannedInternalCostA;
  }
  
  public String getYTDActualRevRec() {
    return this.YTDActualRevRec;
  }
  
  public void setYTDActualRevRec(String yTDActualRevRec) {
    this.YTDActualRevRec = yTDActualRevRec;
  }
  
  public String getYTDActualRevRecP() {
    return this.YTDActualRevRecP;
  }
  
  public void setYTDActualRevRecP(String yTDActualRevRecP) {
    this.YTDActualRevRecP = yTDActualRevRecP;
  }
  
  public String getActualExternalCosttoDate() {
    return this.ActualExternalCosttoDate;
  }
  
  public void setActualExternalCosttoDate(String actualExternalCosttoDate) {
    this.ActualExternalCosttoDate = actualExternalCosttoDate;
  }
  
  public String getActualInternalCosttoDate() {
    return this.ActualInternalCosttoDate;
  }
  
  public void setActualInternalCosttoDate(String actualInternalCosttoDate) {
    this.ActualInternalCosttoDate = actualInternalCosttoDate;
  }
  
  public String getTotalActualCosttoDate() {
    return this.TotalActualCosttoDate;
  }
  
  public void setTotalActualCosttoDate(String totalActualCosttoDate) {
    this.TotalActualCosttoDate = totalActualCosttoDate;
  }
  
  public String getTotalDerivedInternalCosttoDate() {
    return this.TotalDerivedInternalCosttoDate;
  }
  
  public void setTotalDerivedInternalCosttoDate(String totalDerivedInternalCosttoDate) {
    this.TotalDerivedInternalCosttoDate = totalDerivedInternalCosttoDate;
  }
  
  public String getTotalDerivedActualCosttoDate() {
    return this.TotalDerivedActualCosttoDate;
  }
  
  public void setTotalDerivedActualCosttoDate(String totalDerivedActualCosttoDate) {
    this.TotalDerivedActualCosttoDate = totalDerivedActualCosttoDate;
  }
  
  public String getSAPDerivedGMB0() {
    return this.SAPDerivedGMB0;
  }
  
  public void setSAPDerivedGMB0(String sAPDerivedGMB0) {
    this.SAPDerivedGMB0 = sAPDerivedGMB0;
  }
  
  public String getSAPDerivedGMUSDB0() {
    return this.SAPDerivedGMUSDB0;
  }
  
  public void setSAPDerivedGMUSDB0(String sAPDerivedGMUSDB0) {
    this.SAPDerivedGMUSDB0 = sAPDerivedGMUSDB0;
  }
  
  public String getSAPDerivedGMPB0() {
    return this.SAPDerivedGMPB0;
  }
  
  public void setSAPDerivedGMPB0(String sAPDerivedGMPB0) {
    this.SAPDerivedGMPB0 = sAPDerivedGMPB0;
  }
  
  public String getSAPDerivedGMB1() {
    return this.SAPDerivedGMB1;
  }
  
  public void setSAPDerivedGMB1(String sAPDerivedGMB1) {
    this.SAPDerivedGMB1 = sAPDerivedGMB1;
  }
  
  public String getSAPDerivedGMUSDB1() {
    return this.SAPDerivedGMUSDB1;
  }
  
  public void setSAPDerivedGMUSDB1(String sAPDerivedGMUSDB1) {
    this.SAPDerivedGMUSDB1 = sAPDerivedGMUSDB1;
  }
  
  public String getSAPDerivedGMPB1() {
    return this.SAPDerivedGMPB1;
  }
  
  public void setSAPDerivedGMPB1(String sAPDerivedGMPB1) {
    this.SAPDerivedGMPB1 = sAPDerivedGMPB1;
  }
  
  public String getTotalDerivedRemainingCost() {
    return this.TotalDerivedRemainingCost;
  }
  
  public void setTotalDerivedRemainingCost(String totalDerivedRemainingCost) {
    this.TotalDerivedRemainingCost = totalDerivedRemainingCost;
  }
  
  public String getTotalDerivedRemainingGP() {
    return this.TotalDerivedRemainingGP;
  }
  
  public void setTotalDerivedRemainingGP(String totalDerivedRemainingGP) {
    this.TotalDerivedRemainingGP = totalDerivedRemainingGP;
  }
  
  public String getTotalDerivedRemainingGPP() {
    return this.TotalDerivedRemainingGPP;
  }
  
  public void setTotalDerivedRemainingGPP(String totalDerivedRemainingGPP) {
    this.TotalDerivedRemainingGPP = totalDerivedRemainingGPP;
  }
  
  public String getTotalEstimatedGMatCompletion() {
    return this.TotalEstimatedGMatCompletion;
  }
  
  public void setTotalEstimatedGMatCompletion(String totalEstimatedGMatCompletion) {
    this.TotalEstimatedGMatCompletion = totalEstimatedGMatCompletion;
  }
  
  public String getTotalEstimatedGMatCompletionUSD() {
    return this.TotalEstimatedGMatCompletionUSD;
  }
  
  public void setTotalEstimatedGMatCompletionUSD(String totalEstimatedGMatCompletionUSD) {
    this.TotalEstimatedGMatCompletionUSD = totalEstimatedGMatCompletionUSD;
  }
  
  public String getTotalEstimatedGMatCompletionP() {
    return this.TotalEstimatedGMatCompletionP;
  }
  
  public void setTotalEstimatedGMatCompletionP(String totalEstimatedGMatCompletionP) {
    this.TotalEstimatedGMatCompletionP = totalEstimatedGMatCompletionP;
  }
  
  public String getProfitabilitywithintolerance() {
    return this.Profitabilitywithintolerance;
  }
  
  public void setProfitabilitywithintolerance(String profitabilitywithintolerance) {
    this.Profitabilitywithintolerance = profitabilitywithintolerance;
  }
  
  public String getReasonfornotonbudgetmainclassification() {
    return this.Reasonfornotonbudgetmainclassification;
  }
  
  public void setReasonfornotonbudgetmainclassification(String reasonfornotonbudgetmainclassification) {
    this.Reasonfornotonbudgetmainclassification = reasonfornotonbudgetmainclassification;
  }
  
  public String getReasonfornotonbudgetsubclassification() {
    return this.Reasonfornotonbudgetsubclassification;
  }
  
  public void setReasonfornotonbudgetsubclassification(String reasonfornotonbudgetsubclassification) {
    this.Reasonfornotonbudgetsubclassification = reasonfornotonbudgetsubclassification;
  }
  
  public String ActualExternalCosttoDate = "";
  
  public String ActualInternalCosttoDate = "";
  
  public String TotalActualCosttoDate = "";
  
  public String TotalDerivedInternalCosttoDate = "";
  
  public String TotalDerivedActualCosttoDate = "";
  
  public String SAPDerivedGMB0 = "";
  
  public String SAPDerivedGMUSDB0 = "";
  
  public String SAPDerivedGMPB0 = "";
  
  public String SAPDerivedGMB1 = "";
  
  public String SAPDerivedGMUSDB1 = "";
  
  public String SAPDerivedGMPB1 = "";
  
  public String TotalDerivedRemainingCost = "";
  
  public String TotalDerivedRemainingGP = "";
  
  public String TotalDerivedRemainingGPP = "";
  
  public String TotalEstimatedGMatCompletion = "";
  
  public String TotalEstimatedGMatCompletionUSD = "";
  
  public String TotalEstimatedGMatCompletionP = "";
  
  public String Profitabilitywithintolerance = "";
  
  public String Reasonfornotonbudgetmainclassification = "";
  
  public String Reasonfornotonbudgetsubclassification = "";
  
  public String getId() {
    return this.id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getIdproject() {
    return this.idproject;
  }
  
  public void setIdproject(String idproject) {
    this.idproject = idproject;
  }
  
  public String getIdpm() {
    return this.idpm;
  }
  
  public void setIdpm(String idpm) {
    this.idpm = idpm;
  }
  
  public String getProjectID() {
    return this.ProjectID;
  }
  
  public void setProjectID(String projectID) {
    this.ProjectID = projectID;
  }
  
  public String getWBSElement() {
    return this.WBSElement;
  }
  
  public void setWBSElement(String wBSElement) {
    this.WBSElement = wBSElement;
  }
  
  public String getProjectname() {
    return this.projectname;
  }
  
  public void setProjectname(String projectname) {
    this.projectname = projectname;
  }
  
  public String getProjectStatus() {
    return this.ProjectStatus;
  }
  
  public void setProjectStatus(String projectStatus) {
    this.ProjectStatus = projectStatus;
  }
  
  public String getProjectClassification() {
    return this.ProjectClassification;
  }
  
  public void setProjectClassification(String projectClassification) {
    this.ProjectClassification = projectClassification;
  }
  
  public String getProjectType() {
    return this.ProjectType;
  }
  
  public void setProjectType(String projectType) {
    this.ProjectType = projectType;
  }
  
  public String getClient() {
    return this.Client;
  }
  
  public void setClient(String client) {
    this.Client = client;
  }
  
  public String getBillable() {
    if (!this.Billable.isEmpty()) {
      if (this.Billable.equals("False"))
        this.Billable = "No"; 
      if (this.Billable.equals("True"))
        this.Billable = "Yes"; 
    } 
    return this.Billable;
  }
  
  public void setBillable(String billable) {
    this.Billable = billable;
  }
  
  public String getProjectManagersHealthAssessment() {
    return this.ProjectManagersHealthAssessment;
  }
  
  public void setProjectManagersHealthAssessment(String projectManagersHealthAssessment) {
    this.ProjectManagersHealthAssessment = projectManagersHealthAssessment;
  }
  
  public String getSystemGeneratedHealthAssessment() {
    return this.SystemGeneratedHealthAssessment;
  }
  
  public void setSystemGeneratedHealthAssessment(String systemGeneratedHealthAssessment) {
    this.SystemGeneratedHealthAssessment = systemGeneratedHealthAssessment;
  }
  
  public String getSystemGeneratedMetrics() {
    return this.SystemGeneratedMetrics;
  }
  
  public void setSystemGeneratedMetrics(String systemGeneratedMetrics) {
    this.SystemGeneratedMetrics = systemGeneratedMetrics;
  }
  
  public String getProjectManager() {
    return this.ProjectManager;
  }
  
  public void setProjectManager(String projectManager) {
    this.ProjectManager = projectManager;
  }
  
  public String getSONumber() {
    return this.SONumber;
  }
  
  public void setSONumber(String sONumber) {
    this.SONumber = sONumber;
  }
  
  public String getProposedPhase() {
    return this.ProposedPhase;
  }
  
  public void setProposedPhase(String proposedPhase) {
    this.ProposedPhase = proposedPhase;
  }
  
  public String getBaselinedEndDate() {
    return this.BaselinedEndDate;
  }
  
  public void setBaselinedEndDate(String baselinedEndDate) {
    this.BaselinedEndDate = setMysqDate(baselinedEndDate);
  }
  
  public String getProjectCreationDate() {
    return this.ProjectCreationDate;
  }
  
  public void setProjectCreationDate(String projectCreationDate) {
    this.ProjectCreationDate = setMysqDate(projectCreationDate);
  }
  
  public String getProjectClosedDate() {
    return this.ProjectClosedDate;
  }
  
  public void setProjectClosedDate(String projectClosedDate) {
    this.ProjectClosedDate = setMysqDate(projectClosedDate);
  }
  
  public String getContractClosedDate() {
    return this.ContractClosedDate;
  }
  
  public void setContractClosedDate(String contractClosedDate) {
    this.ContractClosedDate = setMysqDate(contractClosedDate);
  }
  
  public String getLateDays() {
    return this.LateDays;
  }
  
  public void setLateDays(String lateDays) {
    if (lateDays.isEmpty()) {
      lateDays = "0";
    } else {
      lateDays = lateDays.replaceAll(",", "");
    } 
    this.LateDays = lateDays;
  }
  
  public String getCompleteeffort() {
    return this.completeeffort;
  }
  
  public void setCompleteeffort(String completeeffort) {
    this.completeeffort = completeeffort;
  }
  
  public String getProjectDescription() {
    return this.ProjectDescription;
  }
  
  public void setProjectDescription(String projectDescription) {
    this.ProjectDescription = projectDescription;
  }
  
  public String getReleaseToSAP() {
    return this.ReleaseToSAP;
  }
  
  public void setReleaseToSAP(String releaseToSAP) {
    this.ReleaseToSAP = releaseToSAP;
  }
  
  public String getIncludesConsulting() {
    return this.IncludesConsulting;
  }
  
  public void setIncludesConsulting(String includesConsulting) {
    this.IncludesConsulting = includesConsulting;
  }
  
  public String getCompanyCodeCurrency() {
    return this.CompanyCodeCurrency;
  }
  
  public void setCompanyCodeCurrency(String companyCodeCurrency) {
    this.CompanyCodeCurrency = companyCodeCurrency;
  }
  
  public String getContractServiceValue() {
    return this.ContractServiceValue;
  }
  
  public void setContractServiceValue(String contractServiceValue) {
    this.ContractServiceValue = contractServiceValue;
  }
  
  public String getContractServiceValueUSD() {
    return this.ContractServiceValueUSD;
  }
  
  public void setContractServiceValueUSD(String contractServiceValueUSD) {
    this.ContractServiceValueUSD = contractServiceValueUSD;
  }
  
  public String getBaseline0() {
    return this.Baseline0;
  }
  
  public void setBaseline0(String baseline0) {
    if (!baseline0.isEmpty())
      baseline0 = baseline0.replaceAll("\\%", ""); 
    try {
      float b = Float.parseFloat(baseline0) * 100.0F;
      baseline0 = (new StringBuilder(String.valueOf(b))).toString();
    } catch (Exception exception) {}
    this.Baseline0 = baseline0;
  }
  
  public String getBaseline1() {
    return this.Baseline1;
  }
  
  public void setBaseline1(String baseline1) {
    if (!baseline1.isEmpty())
      baseline1 = baseline1.replaceAll("\\%", ""); 
    try {
      float b = Float.parseFloat(baseline1) * 100.0F;
      baseline1 = (new StringBuilder(String.valueOf(b))).toString();
    } catch (Exception exception) {}
    this.Baseline1 = baseline1;
  }
  
  public String getEAC() {
    return this.EAC;
  }
  
  public void setEAC(String eAC) {
    if (!eAC.isEmpty())
      eAC = eAC.replaceAll("\\%", ""); 
    try {
      float b = Float.parseFloat(eAC) * 100.0F;
      eAC = (new StringBuilder(String.valueOf(b))).toString();
    } catch (Exception exception) {}
    this.EAC = eAC;
  }
  
  public String getTotalDeliverableMilestones() {
    return this.TotalDeliverableMilestones;
  }
  
  public void setTotalDeliverableMilestones(String totalDeliverableMilestones) {
    this.TotalDeliverableMilestones = totalDeliverableMilestones;
  }
  
  public String getCompletedDeliverableMilestones() {
    return this.CompletedDeliverableMilestones;
  }
  
  public void setCompletedDeliverableMilestones(String completedDeliverableMilestones) {
    this.CompletedDeliverableMilestones = completedDeliverableMilestones;
  }
  
  public String getTotalPaymentMilestones() {
    return this.TotalPaymentMilestones;
  }
  
  public void setTotalPaymentMilestones(String totalPaymentMilestones) {
    this.TotalPaymentMilestones = totalPaymentMilestones;
  }
  
  public String getBehindSchedule() {
    return this.BehindSchedule;
  }
  
  public void setBehindSchedule(String behindSchedule) {
    this.BehindSchedule = behindSchedule;
  }
  
  public String getTotalChanges() {
    return this.TotalChanges;
  }
  
  public void setTotalChanges(String totalChanges) {
    this.TotalChanges = totalChanges;
  }
  
  public String getClosedChanges() {
    return this.ClosedChanges;
  }
  
  public void setClosedChanges(String closedChanges) {
    this.ClosedChanges = closedChanges;
  }
  
  public String getEscalatedChanges() {
    return this.EscalatedChanges;
  }
  
  public void setEscalatedChanges(String escalatedChanges) {
    this.EscalatedChanges = escalatedChanges;
  }
  
  public String getTotalRisks() {
    return this.TotalRisks;
  }
  
  public void setTotalRisks(String totalRisks) {
    this.TotalRisks = totalRisks;
  }
  
  public String getClosedRisks() {
    return this.ClosedRisks;
  }
  
  public void setClosedRisks(String closedRisks) {
    this.ClosedRisks = closedRisks;
  }
  
  public String getEscalatedRisks() {
    return this.EscalatedRisks;
  }
  
  public void setEscalatedRisks(String escalatedRisks) {
    this.EscalatedRisks = escalatedRisks;
  }
  
  public String getTotalIssues() {
    return this.TotalIssues;
  }
  
  public void setTotalIssues(String totalIssues) {
    this.TotalIssues = totalIssues;
  }
  
  public String getClosedIssues() {
    return this.ClosedIssues;
  }
  
  public void setClosedIssues(String closedIssues) {
    this.ClosedIssues = closedIssues;
  }
  
  public String getEscalatedIssues() {
    return this.EscalatedIssues;
  }
  
  public void setEscalatedIssues(String escalatedIssues) {
    this.EscalatedIssues = escalatedIssues;
  }
  
  public String getUpdateon() {
    return this.updateon;
  }
  
  public void setUpdateon(String updateon) {
    this.updateon = updateon;
  }
  
  public String getCreatedon() {
    return this.createdon;
  }
  
  public void setCreatedon(String createdon) {
    this.createdon = createdon;
  }
  
  public String getBillingOffice() {
    return this.BillingOffice;
  }
  
  public void setBillingOffice(String billingOffice) {
    this.BillingOffice = billingOffice;
  }
  
  public String getL() {
    return this.L;
  }
  
  public void setL(String l) {
    this.L = l;
  }
  
  public String getB() {
    return this.B;
  }
  
  public void setB(String b) {
    this.B = b;
  }
  
  public String getP() {
    return this.P;
  }
  
  public void setP(String p) {
    this.P = p;
  }
  
  public String getD() {
    return this.D;
  }
  
  public void setD(String d) {
    this.D = d;
  }
  
  public String getNB0() {
    return this.NB0;
  }
  
  public void setNB0(String nB0) {
    this.NB0 = nB0;
  }
  
  public String getNB1() {
    return this.NB1;
  }
  
  public void setNB1(String nB1) {
    this.NB1 = nB1;
  }
  
  public static String dbusername = "dbadmin";
  
  public static String dbpassword = "neqe37";
  
  public static String dbName="c1ppms";
  
  public static void main(String[] args) {
    updateProjectSO();
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
   // if (temp == null)
     // temp = "9999-12-31"; 
    if (temp.equals(""))
      temp = "9999-12-31"; 
    if (temp.isEmpty())
      temp = "9999-12-31"; 
    return temp;
  }
  
  public static String queryIDProject(String sProjectID) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT idproject from projecthealth where `ProjectID`=\"" + sProjectID + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String idproject = "";
      int i = 1;
      if (rs.next()) {
        idproject = rs.getString("idproject");
        sRslt = idproject;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return sRslt;
  }
  
  public static String queryIDProjectByIDContract(String sIDContract) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT idproject from projecthealth where `idcontract`=\"" + sIDContract + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String idproject = "";
      int i = 1;
      if (rs.next()) {
        idproject = rs.getString(1);
        sRslt = idproject;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return sRslt;
  }
  
  public static String queryIDRequestByIDContract(String sIDContract) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT idrequest from projecthealth where `idcontract`=\"" + sIDContract + "\"";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String idproject = "";
      int i = 1;
      if (rs.next()) {
        idproject = rs.getString(1);
        sRslt = idproject;
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
    return sRslt;
  }
  
  public static String queryID(String sIDProject) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT id from projecthealth where `idproject`=\"" + sIDProject + "\"";
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
  
  public static String queryIDProfile(String sIDProject) {
    String sRslt = "";
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT id from projecthealth where `idproject`=\"" + sIDProject + "\"";
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
  
  public static void updateProjectCategory() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT idproject, projectname from projecthealth where projectname like 'PRJ%'";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String idproject = "";
      String projectname = "";
      int i = 1;
      while (rs.next()) {
        idproject = rs.getString("idproject");
        projectname = rs.getString("projectname");
        String sProjectCategory = getProjectCategory(projectname);
        try {
          Statement st2 = (Statement)conn.createStatement();
          String sUpdate = "update  projecthealth set projecthealth.projectcategory='" + sProjectCategory + "' where projecthealth.idproject='" + idproject + "'";
          st2.execute(sUpdate);
          st2.close();
          System.out.println(sUpdate);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        } 
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
  }
  
  public static void updateProjectClass() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT idproject, projectname from projecthealth where projectname like '%'";
    try {
      Statement st = (Statement)conn.createStatement();
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String idproject = "";
      String projectname = "";
      int i = 1;
      while (rs.next()) {
        idproject = rs.getString("idproject");
        projectname = rs.getString("projectname");
        String sProjectClass = getProjectClass(projectname);
        try {
          Statement st2 = (Statement)conn.createStatement();
          String sUpdate = "update  projecthealth set projecthealth.projectclass='" + sProjectClass + "' where projecthealth.idproject='" + idproject + "'";
          st2.execute(sUpdate);
          st2.close();
          System.out.println(sUpdate);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        } 
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
  }
  
  public static void updateProjectSO() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String query = "SELECT idproject, idcontract, sonumber from projecthealth";
    try {
      Statement st = (Statement)conn.createStatement();
      st.execute("TRUNCATE TABLE `so`");
      ResultSet rs = (ResultSet)st.executeQuery(query);
      String idproject = "";
      String idcontract = "";
      String sonumber = "";
      int i = 1;
      while (rs.next()) {
        idproject = rs.getString("idproject");
        idcontract = rs.getString("idcontract");
        sonumber = rs.getString("sonumber");
        if (sonumber != null) {
          String[] sSo = sonumber.split("[;,]");
          Statement st2 = (Statement)conn.createStatement();
          for (int j = 0; j < sSo.length; j++) {
            try {
              String sUpdate = "insert into `so`(idproject, idcontract, sonumber) values ('" + idproject + "','" + idcontract + "','" + sSo[j] + "')";
              st2.execute(sUpdate);
              System.out.println(sUpdate);
            } catch (Exception e) {
              System.out.println(e.getMessage());
            } 
          } 
          st2.close();
        } 
      } 
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    } 
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
  
  public static String getProjectCategory(String projectName) {
    String rslt = "";
    try {
      if (!projectName.isEmpty()) {
        String[] arslt = projectName.split("-");
        if (arslt.length > 0)
          for (int i = 0; i < arslt.length; i++) {
            switch (i) {
              case 1:
                rslt = arslt[i].trim().toUpperCase();
                break;
            } 
          }  
      } 
    } catch (Exception e) {
      rslt = "";
    } 
    return rslt;
  }
  
  public static String getProjectClass(String projectName) {
    String rslt = "";
    String sClass = "General";
    try {
      if (!projectName.isEmpty()) {
        String[] arslt = projectName.split("-");
        if (arslt.length > 0)
          for (int i = 0; i < arslt.length; i++) {
            switch (i) {
              case 0:
                rslt = arslt[i].trim().toUpperCase();
                break;
            } 
          }  
      } 
      if (!rslt.equals("")) {
        String[] arslt = rslt.split(" ");
        if (arslt.length > 0)
          for (int i = 0; i < arslt.length; i++) {
            switch (i) {
              case 0:
                break;
              case 1:
                sClass = arslt[i].trim().toUpperCase();
                break;
              default:
                sClass = String.valueOf(sClass) + " " + arslt[i].trim().toUpperCase();
                break;
            } 
          }  
      } 
    } catch (Exception e) {
      sClass = "";
    } 
    return sClass;
  }
  
  public void resetstats() {
    this.L = "0";
    this.B = "0";
    this.P = "0";
    this.D = "0";
    this.NB0 = "0";
    this.NB1 = "0";
  }
  
  public void dbRefreshData() {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    PreparedStatement preparedStmt = null;
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      String sID = queryID(getIdproject());
      setId(sID);
      String sPMName = employee.queryIDEmployee(getProjectManager());
      setIdpm(sPMName);
      resetstats();
      if (this.SystemGeneratedMetrics != null) {
        String[] aHealth = this.SystemGeneratedMetrics.split(",");
        if (aHealth.length > 0)
          for (int i = 0; i < aHealth.length; i++) {
            String tempS = aHealth[i];
            if (tempS.contentEquals("L"))
              this.L = "1"; 
            if (tempS.contentEquals("B"))
              this.B = "1"; 
            if (tempS.contentEquals("P"))
              this.P = "1"; 
            if (tempS.contentEquals("D"))
              this.D = "1"; 
            if (tempS.contentEquals("NB0"))
              this.NB0 = "1"; 
            if (tempS.contentEquals("NB1"))
              this.NB1 = "1"; 
          }  
      } 
      if (sID.isEmpty()) {
        sQuery = "INSERT INTO `projecthealth`(`updateon`, `billingoffice`,  `idproject`, `idpm`, `ProjectID`,`WBSElement`, `projectname`, `ProjectStatus`, `ProjectClassification`, `ProjectType`, `Client`, `Billable`, `ProjectManagersHealthAssessment`, `SystemGeneratedHealthAssessment`, `SystemGeneratedMetrics`, `ProjectManager`, `SONumber`, `ProposedPhase`, `BaselinedEndDate`, `ProjectCreationDate`, `ProjectClosedDate`, `ContractClosedDate`, `LateDays`, `completeeffort`, `ProjectDescription`, `ReleaseToSAP`, `IncludesConsulting`, `CompanyCodeCurrency`, `ContractServiceValue`, `ContractServiceValueUSD`, `Baseline0`, `Baseline1`, `EAC`, `TotalDeliverableMilestones`, `CompletedDeliverableMilestones`, `TotalPaymentMilestones`, `BehindSchedule`, `TotalChanges`, `ClosedChanges`, `EscalatedChanges`, `TotalRisks`, `ClosedRisks`, `EscalatedRisks`, `TotalIssues`, `ClosedIssues`, `EscalatedIssues`, `L`,`B`,`P`,`D`,`NB0`,`NB1`, `projectcategory`, `projectclass`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getBillingOffice());
        preparedStmt.setString(3, getIdproject());
        preparedStmt.setString(4, getIdpm());
        preparedStmt.setString(5, getProjectID());
        preparedStmt.setString(6, getWBSElement());
        preparedStmt.setString(7, getProjectname());
        preparedStmt.setString(8, getProjectStatus());
        preparedStmt.setString(9, getProjectClassification());
        preparedStmt.setString(10, getProjectType());
        preparedStmt.setString(11, getClient());
        preparedStmt.setString(12, getBillable());
        preparedStmt.setString(13, getProjectManagersHealthAssessment());
        preparedStmt.setString(14, getSystemGeneratedHealthAssessment());
        preparedStmt.setString(15, getSystemGeneratedMetrics());
        preparedStmt.setString(16, getProjectManager());
        preparedStmt.setString(17, getSONumber());
        preparedStmt.setString(18, getProposedPhase());
        preparedStmt.setString(19, getBaselinedEndDate());
        preparedStmt.setString(20, getProjectCreationDate());
        preparedStmt.setString(21, getProjectClosedDate());
        preparedStmt.setString(22, getContractClosedDate());
        preparedStmt.setString(23, getLateDays());
        preparedStmt.setFloat(24, getFloatValue(getCompleteeffort()).floatValue());
        preparedStmt.setString(25, getProjectDescription());
        preparedStmt.setString(26, getReleaseToSAP());
        preparedStmt.setString(27, getIncludesConsulting());
        preparedStmt.setString(28, getCompanyCodeCurrency());
        preparedStmt.setFloat(29, getFloatValue(getContractServiceValue()).floatValue());
        preparedStmt.setFloat(30, getFloatValue(getContractServiceValueUSD()).floatValue());
        preparedStmt.setFloat(31, getFloatValue(getBaseline0()).floatValue());
        preparedStmt.setFloat(32, getFloatValue(getBaseline1()).floatValue());
        preparedStmt.setFloat(33, getFloatValue(getEAC()).floatValue());
        preparedStmt.setInt(34, getIntValue(getTotalDeliverableMilestones()));
        preparedStmt.setInt(35, getIntValue(getCompletedDeliverableMilestones()));
        preparedStmt.setInt(36, getIntValue(getTotalPaymentMilestones()));
        preparedStmt.setInt(37, getIntValue(getBehindSchedule()));
        preparedStmt.setInt(38, getIntValue(getTotalChanges()));
        preparedStmt.setInt(39, getIntValue(getClosedChanges()));
        preparedStmt.setInt(40, getIntValue(getEscalatedChanges()));
        preparedStmt.setInt(41, getIntValue(getTotalRisks()));
        preparedStmt.setInt(42, getIntValue(getClosedRisks()));
        preparedStmt.setInt(43, getIntValue(getEscalatedRisks()));
        preparedStmt.setInt(44, getIntValue(getTotalIssues()));
        preparedStmt.setInt(45, getIntValue(getClosedIssues()));
        preparedStmt.setInt(46, getIntValue(getEscalatedIssues()));
        preparedStmt.setInt(47, getIntValue(getL()));
        preparedStmt.setInt(48, getIntValue(getB()));
        preparedStmt.setInt(49, getIntValue(getP()));
        preparedStmt.setInt(50, getIntValue(getD()));
        preparedStmt.setInt(51, getIntValue(getNB0()));
        preparedStmt.setInt(52, getIntValue(getNB1()));
        preparedStmt.setString(53, getProjectCategory(getProjectname()));
        preparedStmt.setString(54, getProjectClass(getProjectname()));
        preparedStmt.execute();
      } else {
        sQuery = "UPDATE `projecthealth` SET `updateon`=?, `billingoffice`=?,  `idproject`=?, `idpm`=?, `ProjectID`=?,`WBSElement`=?, `projectname`=?, `ProjectStatus`=?, `ProjectClassification`=?, `ProjectType`=?, `Client`=?, `Billable`=?, `ProjectManagersHealthAssessment`=?, `SystemGeneratedHealthAssessment`=?, `SystemGeneratedMetrics`=?, `ProjectManager`=?, `SONumber`=?, `ProposedPhase`=?, `BaselinedEndDate`=?, `ProjectCreationDate`=?, `ProjectClosedDate`=?, `ContractClosedDate`=?, `LateDays`=?, `completeeffort`=?, `ProjectDescription`=?, `ReleaseToSAP`=?, `IncludesConsulting`=?, `CompanyCodeCurrency`=?, `ContractServiceValue`=?, `ContractServiceValueUSD`=?, `Baseline0`=?, `Baseline1`=?, `EAC`=?, `TotalDeliverableMilestones`=?, `CompletedDeliverableMilestones`=?, `TotalPaymentMilestones`=?, `BehindSchedule`=?, `TotalChanges`=?, `ClosedChanges`=?, `EscalatedChanges`=?, `TotalRisks`=?, `ClosedRisks`=?, `EscalatedRisks`=?, `TotalIssues`=?, `ClosedIssues`=?, `EscalatedIssues`=?,`L`=?,`B`=?,`P`=?,`D`=?,`NB0`=?,`NB1`=?, `projectcategory`=?,`projectclass`=?,  `updateon`=NOW()  WHERE `id`=?";
        String sProjectCategory = getProjectCategory(getProjectname());
        String sProjectClass = getProjectClass(getProjectname());
        if (getProjectType() != null && 
          getProjectType().equalsIgnoreCase("Opportunity Project")) {
          sProjectCategory = "Pre-sales";
          sProjectClass = "Pre-sales";
        } 
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getBillingOffice());
        preparedStmt.setString(3, getIdproject());
        preparedStmt.setString(4, getIdpm());
        preparedStmt.setString(5, getProjectID());
        preparedStmt.setString(6, getWBSElement());
        preparedStmt.setString(7, getProjectname());
        preparedStmt.setString(8, getProjectStatus());
        preparedStmt.setString(9, getProjectClassification());
        preparedStmt.setString(10, getProjectType());
        preparedStmt.setString(11, getClient());
        preparedStmt.setString(12, getBillable());
        preparedStmt.setString(13, getProjectManagersHealthAssessment());
        preparedStmt.setString(14, getSystemGeneratedHealthAssessment());
        preparedStmt.setString(15, getSystemGeneratedMetrics());
        preparedStmt.setString(16, getProjectManager());
        preparedStmt.setString(17, getSONumber());
        preparedStmt.setString(18, getProposedPhase());
        preparedStmt.setString(19, getBaselinedEndDate());
        preparedStmt.setString(20, getProjectCreationDate());
        preparedStmt.setString(21, getProjectClosedDate());
        preparedStmt.setString(22, getContractClosedDate());
        preparedStmt.setString(23, getLateDays());
        preparedStmt.setFloat(24, getFloatValue(getCompleteeffort()).floatValue());
        preparedStmt.setString(25, getProjectDescription());
        preparedStmt.setString(26, getReleaseToSAP());
        preparedStmt.setString(27, getIncludesConsulting());
        preparedStmt.setString(28, getCompanyCodeCurrency());
        preparedStmt.setFloat(29, getFloatValue(getContractServiceValue()).floatValue());
        preparedStmt.setFloat(30, getFloatValue(getContractServiceValueUSD()).floatValue());
        preparedStmt.setFloat(31, getFloatValue(getBaseline0()).floatValue());
        preparedStmt.setFloat(32, getFloatValue(getBaseline1()).floatValue());
        preparedStmt.setFloat(33, getFloatValue(getEAC()).floatValue());
        preparedStmt.setInt(34, getIntValue(getTotalDeliverableMilestones()));
        preparedStmt.setInt(35, getIntValue(getCompletedDeliverableMilestones()));
        preparedStmt.setInt(36, getIntValue(getTotalPaymentMilestones()));
        preparedStmt.setInt(37, getIntValue(getBehindSchedule()));
        preparedStmt.setInt(38, getIntValue(getTotalChanges()));
        preparedStmt.setInt(39, getIntValue(getClosedChanges()));
        preparedStmt.setInt(40, getIntValue(getEscalatedChanges()));
        preparedStmt.setInt(41, getIntValue(getTotalRisks()));
        preparedStmt.setInt(42, getIntValue(getClosedRisks()));
        preparedStmt.setInt(43, getIntValue(getEscalatedRisks()));
        preparedStmt.setInt(44, getIntValue(getTotalIssues()));
        preparedStmt.setInt(45, getIntValue(getClosedIssues()));
        preparedStmt.setInt(46, getIntValue(getEscalatedIssues()));
        preparedStmt.setInt(47, getIntValue(getL()));
        preparedStmt.setInt(48, getIntValue(getB()));
        preparedStmt.setInt(49, getIntValue(getP()));
        preparedStmt.setInt(50, getIntValue(getD()));
        preparedStmt.setInt(51, getIntValue(getNB0()));
        preparedStmt.setInt(52, getIntValue(getNB1()));
        preparedStmt.setString(53, sProjectCategory);
        preparedStmt.setString(54, sProjectClass);
        preparedStmt.setInt(55, getIntValue(sID));
        preparedStmt.execute();
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
  
  public void dbTraxRefreshData() {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    PreparedStatement preparedStmt = null;
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      String sID = queryID(getIdproject());
      setId(sID);
      if (sID.isEmpty()) {
        sQuery = "INSERT INTO `projecthealth`(`updateon`, `billingoffice`,  `idproject`,  `ProjectID`, `projectname`, `ProjectStatus`,  `Client`, `Billable`, `SONumber`, `ProjectCreationDate`, `ProjectClosedDate`, `ContractClosedDate`, `LateDays`, `ProjectDescription`, `ReleaseToSAP`,  `CompanyCodeCurrency`, `ContractServiceValue`, `ContractServiceValueUSD`, `Baseline0`, `Baseline1`, `ContractCreationDate`, `RequestCreationDate`, `RequestFinishDate`, `RequestClosedDate`,`WorkflowStatus`,`PlannedInternalCostB0`,`TotalActualCosttoDate`, `TotalDerivedRemainingCost`,`Profitabilitywithintolerance`, `idrequest`, `assignedresource` ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getBillingOffice());
        preparedStmt.setString(3, getIdproject());
        preparedStmt.setString(4, getProjectID());
        preparedStmt.setString(5, getProjectname());
        preparedStmt.setString(6, getProjectStatus());
        preparedStmt.setString(7, getClient());
        preparedStmt.setString(8, getBillable());
        preparedStmt.setString(9, getSONumber());
        preparedStmt.setString(10, setMysqDate(getProjectCreationDate()));
        preparedStmt.setString(11, setMysqDate(getProjectClosedDate()));
        preparedStmt.setString(12, setMysqDate(getContractClosedDate()));
        preparedStmt.setString(13, getLateDays());
        preparedStmt.setString(14, getProjectDescription());
        preparedStmt.setString(15, getReleaseToSAP());
        preparedStmt.setString(16, getCompanyCodeCurrency());
        preparedStmt.setFloat(17, getFloatValue(getContractServiceValue()).floatValue());
        preparedStmt.setFloat(18, getFloatValue(getContractServiceValueUSD()).floatValue());
        preparedStmt.setFloat(19, getFloatValue(getBaseline0()).floatValue());
        preparedStmt.setFloat(20, getFloatValue(getBaseline1()).floatValue());
        preparedStmt.setString(21, setMysqDate(getContractCreationDate()));
        preparedStmt.setString(22, setMysqDate(getRequestCreationDate()));
        preparedStmt.setString(23, setMysqDate(getRequestFinishDate()));
        preparedStmt.setString(24, setMysqDate(getRequestClosedDate()));
        preparedStmt.setString(25, getWorkflowStatus());
        preparedStmt.setFloat(26, getFloatValue(getPlannedInternalCostB0()).floatValue());
        preparedStmt.setFloat(27, getFloatValue(getTotalActualCosttoDate()).floatValue());
        preparedStmt.setFloat(28, getFloatValue(getTotalDerivedRemainingCost()).floatValue());
        preparedStmt.setString(29, getProfitabilitywithintolerance());
        preparedStmt.setString(30, getIdrequest());
        preparedStmt.setString(31, getAssignedresource());
        preparedStmt.execute();
      } else {
        sQuery = "UPDATE `projecthealth` set `updateon`=?, `billingoffice`=?,  `idproject`=?,  `ProjectID`=?,`projectname`=?,`ProjectStatus`=?,  `Client`=?, `Billable`=?, `SONumber`=?,`ProjectCreationDate`=?, `ProjectClosedDate`=?,`ContractClosedDate`=?, `LateDays`=?,`ProjectDescription`=?, `ReleaseToSAP`=?,  `CompanyCodeCurrency`=?,`ContractServiceValue`=?, `ContractServiceValueUSD`=?, `Baseline0`=?, `Baseline1`=?, `ContractCreationDate`=?, `RequestCreationDate`=?, `RequestFinishDate`=?, `RequestClosedDate`=?,`WorkflowStatus`=?,`PlannedInternalCostB0`=?,`TotalActualCosttoDate`=?, `TotalDerivedRemainingCost`=?,`Profitabilitywithintolerance`=?,`idrequest`=?, `assignedresource`=?   WHERE `id`=?";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getBillingOffice());
        preparedStmt.setString(3, getIdproject());
        preparedStmt.setString(4, getProjectID());
        preparedStmt.setString(5, getProjectname());
        preparedStmt.setString(6, getProjectStatus());
        preparedStmt.setString(7, getClient());
        preparedStmt.setString(8, getBillable());
        preparedStmt.setString(9, getSONumber());
        preparedStmt.setString(10, setMysqDate(getProjectCreationDate()));
        preparedStmt.setString(11, setMysqDate(getProjectClosedDate()));
        preparedStmt.setString(12, setMysqDate(getContractClosedDate()));
        preparedStmt.setString(13, getLateDays());
        preparedStmt.setString(14, getProjectDescription());
        preparedStmt.setString(15, getReleaseToSAP());
        preparedStmt.setString(16, getCompanyCodeCurrency());
        preparedStmt.setFloat(17, getFloatValue(getContractServiceValue()).floatValue());
        preparedStmt.setFloat(18, getFloatValue(getContractServiceValueUSD()).floatValue());
        preparedStmt.setFloat(19, getFloatValue(getBaseline0()).floatValue());
        preparedStmt.setFloat(20, getFloatValue(getBaseline1()).floatValue());
        preparedStmt.setString(21, setMysqDate(getContractCreationDate()));
        preparedStmt.setString(22, setMysqDate(getRequestCreationDate()));
        preparedStmt.setString(23, setMysqDate(getRequestFinishDate()));
        preparedStmt.setString(24, setMysqDate(getRequestClosedDate()));
        preparedStmt.setString(25, getWorkflowStatus());
        preparedStmt.setFloat(26, getFloatValue(getPlannedInternalCostB0()).floatValue());
        preparedStmt.setFloat(27, getFloatValue(getTotalActualCosttoDate()).floatValue());
        preparedStmt.setFloat(28, getFloatValue(getTotalDerivedRemainingCost()).floatValue());
        preparedStmt.setString(29, getProfitabilitywithintolerance());
        preparedStmt.setString(30, getIdrequest());
        preparedStmt.setString(31, getAssignedresource());
        preparedStmt.setInt(32, getIntValue(sID));
        preparedStmt.execute();
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
  
  public void dbRefreshProfile() {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    PreparedStatement preparedStmt = null;
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      String sID = queryIDProfile(getIdproject());
      setId(sID);
      if (sID.isEmpty()) {
        sQuery = "INSERT INTO `projecthealth` (`updateon`,`idproject`, `projectname`, `idpm`, `idcontract`,`contractno`, `pmname`, `idclient`, `client`, `projectstatus`, `billable`, `proposedphase`, `projecttype`, `projectid`, `projectcategory`  ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getIdproject());
        preparedStmt.setString(3, getProjectname());
        preparedStmt.setString(4, getIdpm());
        preparedStmt.setString(5, getContractid());
        preparedStmt.setString(6, getContractno());
        preparedStmt.setString(7, getProjectManager());
        preparedStmt.setString(8, getClientid());
        preparedStmt.setString(9, getClient());
        preparedStmt.setString(10, getProjectStatus());
        preparedStmt.setString(11, getBillable());
        preparedStmt.setString(12, getProposedPhase());
        preparedStmt.setString(13, getProjectType());
        preparedStmt.setString(14, getProjectID());
        preparedStmt.setString(15, getProjectCategory(getProjectname()));
        preparedStmt.execute();
        preparedStmt.close();
      } else {
        sQuery = "UPDATE `projecthealth` SET `updateon`=?, `idproject`=?,  `projectname`=?, `idpm`=?, `idcontract`=?,`contractno`=?, `pmname`=?, `idclient`=?, `client`=?, `projectstatus`=?, `billable`=?, `proposedphase`=?, `projecttype`=?, `projectid`=?, `projectcategory`=?   WHERE `id`=?";
        String sProjectCategory = getProjectCategory(getProjectname());
        if (getProjectType() != null && 
          getProjectType().equalsIgnoreCase("Opportunity Project"))
          sProjectCategory = "Pre-sales"; 
        preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setTimestamp(1, updatedAt);
        preparedStmt.setString(2, getIdproject());
        preparedStmt.setString(3, getProjectname());
        preparedStmt.setString(4, getIdpm());
        preparedStmt.setString(5, getContractid());
        preparedStmt.setString(6, getContractno());
        preparedStmt.setString(7, getProjectManager());
        preparedStmt.setString(8, getClientid());
        preparedStmt.setString(9, getClient());
        preparedStmt.setString(10, getProjectStatus());
        preparedStmt.setString(11, getBillable());
        preparedStmt.setString(12, getProposedPhase());
        preparedStmt.setString(13, getProjectType());
        preparedStmt.setString(14, getProjectID());
        preparedStmt.setString(15, sProjectCategory);
        preparedStmt.setInt(16, getIntValue(sID));
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
  
  public void dbUpdateProfitability() {
    DatabaseManager data = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)data.getConnection();
    String sQuery = "";
    try {
      Timestamp updatedAt = new Timestamp(Calendar.getInstance().getTimeInMillis());
      String sID = queryID(getIdproject());
      setId(sID);
      if (!sID.isEmpty()) {
        sQuery = "UPDATE `projecthealth` SET `POCP`=?,`TotalMaterialCost`=?,`SAPPlannedRevenue`=?,`SAPPlannedRevenueUSD`=?,`SAPPlannedExternalCost`=?,`PlannedInternalCostB0`=?,`PlannedInternalCostB1`=?,`PlannedInternalCostA`=?,`YTDActualRevRec`=?,`YTDActualRevRecP`=?,`ActualExternalCosttoDate`=?,`ActualInternalCosttoDate`=?,`TotalActualCosttoDate`=?,`TotalDerivedInternalCosttoDate`=?,`TotalDerivedActualCosttoDate`=?,`SAPDerivedGMB0`=?,`SAPDerivedGMUSDB0`=?,`SAPDerivedGMPB0`=?,`SAPDerivedGMB1`=?,`SAPDerivedGMUSDB1`=?,`SAPDerivedGMPB1`=?,`TotalDerivedRemainingCost`=?,`TotalDerivedRemainingGP`=?,`TotalDerivedRemainingGPP`=?,`TotalEstimatedGMatCompletion`=?,`TotalEstimatedGMatCompletionUSD`=?,`TotalEstimatedGMatCompletionP`=?,`Profitabilitywithintolerance`=?,`Reasonfornotonbudgetmainclassification`=?,`Reasonfornotonbudgetsubclassification`=?, `updateon`=NOW()  WHERE `id`=?";
        PreparedStatement preparedStmt = (PreparedStatement)conn.prepareStatement(sQuery);
        preparedStmt.setFloat(1, getFloatValue(getPOCP()).floatValue());
        preparedStmt.setFloat(2, getFloatValue(getTotalMaterialCost()).floatValue());
        preparedStmt.setFloat(3, getFloatValue(getSAPPlannedRevenue()).floatValue());
        preparedStmt.setFloat(4, getFloatValue(getSAPPlannedRevenueUSD()).floatValue());
        preparedStmt.setFloat(5, getFloatValue(getSAPPlannedExternalCost()).floatValue());
        preparedStmt.setFloat(6, getFloatValue(getPlannedInternalCostB0()).floatValue());
        preparedStmt.setFloat(7, getFloatValue(getPlannedInternalCostB1()).floatValue());
        preparedStmt.setFloat(8, getFloatValue(getPlannedInternalCostA()).floatValue());
        preparedStmt.setFloat(9, getFloatValue(getYTDActualRevRec()).floatValue());
        preparedStmt.setFloat(10, getFloatValue(getYTDActualRevRecP()).floatValue());
        preparedStmt.setFloat(11, getFloatValue(getActualExternalCosttoDate()).floatValue());
        preparedStmt.setFloat(12, getFloatValue(getActualInternalCosttoDate()).floatValue());
        preparedStmt.setFloat(13, getFloatValue(getTotalActualCosttoDate()).floatValue());
        preparedStmt.setFloat(14, getFloatValue(getTotalDerivedInternalCosttoDate()).floatValue());
        preparedStmt.setFloat(15, getFloatValue(getTotalDerivedActualCosttoDate()).floatValue());
        preparedStmt.setFloat(16, getFloatValue(getSAPDerivedGMB0()).floatValue());
        preparedStmt.setFloat(17, getFloatValue(getSAPDerivedGMUSDB0()).floatValue());
        preparedStmt.setFloat(18, getFloatValue(getSAPDerivedGMPB0()).floatValue());
        preparedStmt.setFloat(19, getFloatValue(getSAPDerivedGMB1()).floatValue());
        preparedStmt.setFloat(20, getFloatValue(getSAPDerivedGMUSDB1()).floatValue());
        preparedStmt.setFloat(21, getFloatValue(getSAPDerivedGMPB1()).floatValue());
        preparedStmt.setFloat(22, getFloatValue(getTotalDerivedRemainingCost()).floatValue());
        preparedStmt.setFloat(23, getFloatValue(getTotalDerivedRemainingGP()).floatValue());
        preparedStmt.setFloat(24, getFloatValue(getTotalDerivedRemainingGPP()).floatValue());
        preparedStmt.setFloat(25, getFloatValue(getTotalEstimatedGMatCompletion()).floatValue());
        preparedStmt.setFloat(26, getFloatValue(getTotalEstimatedGMatCompletionUSD()).floatValue());
        preparedStmt.setFloat(27, getFloatValue(getTotalEstimatedGMatCompletionP()).floatValue());
        preparedStmt.setString(28, getProfitabilitywithintolerance());
        preparedStmt.setString(29, getReasonfornotonbudgetmainclassification());
        preparedStmt.setString(30, getReasonfornotonbudgetsubclassification());
        preparedStmt.setInt(31, getIntValue(getId()));
        preparedStmt.execute();
      } 
      conn.close();
    } catch (Exception e) {
      System.out.println("ERROR: PROFIT: " + sQuery);
      System.out.println("ERROR: PROFIT: " + e.getMessage());
      try {
        conn.close();
      } catch (SQLException e1) {
        e1.printStackTrace();
      } 
    } 
  }
  
  public void dbCleanUp() {
    DatabaseManager db = new DatabaseManager(dbusername, dbpassword, dbName);
    Connection conn = (Connection)db.getConnection();
    String sUpdate = "";
    try {
      Statement st = (Statement)conn.createStatement();
      sUpdate = "update task INNER join projecthealth set task.projectname=projecthealth.projectname,task.projecreationdate=projecthealth.ProjectCreationDate,task.projectstatus=projecthealth.projectstatus  where projecthealth.idproject=task.idproject";
      st.execute(sUpdate);
      st.close();
      conn.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
  }
}


/* Location:              D:\Rpa\rpappms\!\project.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */