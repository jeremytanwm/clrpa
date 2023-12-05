import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOIExcelRead {
  private static final String FILE_NAME = "c:\\ppms\\files\\Organization_Members.xlsx";
  
  public static void loadfile() {
    try {
      FileInputStream excelFile = new FileInputStream(new File("c:\\ppms\\files\\Organization_Members.xlsx"));
      XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(excelFile);
      Sheet datatypeSheet = xSSFWorkbook.getSheetAt(0);
      Iterator<Row> iterator = datatypeSheet.iterator();
      while (iterator.hasNext()) {
        Row currentRow = iterator.next();
        int iColumn = currentRow.getPhysicalNumberOfCells();
        Iterator<Cell> cellIterator = currentRow.iterator();
        int i = 0;
        String sWorkdayname = "";
        String sPosition = "";
        String sSupervisor = "";
        String sSupervisorEmail = "";
        String sPhone = "";
        String sEmail = "";
        while (cellIterator.hasNext()) {
          String sValue = "";
          Cell currentCell = cellIterator.next();
          if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) {
            sValue = currentCell.getStringCellValue();
          } else if (currentCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            sValue = (new StringBuilder(String.valueOf(currentCell.getNumericCellValue()))).toString();
          } 
          if (iColumn == 7) {
            switch (i) {
              case 0:
                try {
                  sWorkdayname = sValue.substring(0, sValue.indexOf("("));
                  sWorkdayname = sWorkdayname.trim();
                } catch (Exception exception) {}
                break;
              case 1:
                try {
                  sPosition = sValue.trim();
                  String[] lines = sPosition.split(" ");
                  for (int j = 0; j < lines.length; j++) {
                    String jData = lines[j];
                    if (j == 0) {
                      sPosition = "";
                    } else {
                      sPosition = String.valueOf(sPosition) + " " + jData;
                    } 
                  } 
                  sPosition = sPosition.trim();
                } catch (Exception exception) {}
                break;
              case 2:
                try {
                  sSupervisor = sValue.trim();
                  if (sSupervisor.length() > 0) {
                    String[] lines = sSupervisor.split("\\(");
                    if (lines.length > 0) {
                      sSupervisor = lines[1];
                      sSupervisor = sSupervisor.trim();
                    } 
                  } 
                  if (sSupervisor.length() > 0) {
                    String[] lines = sSupervisor.split(" ");
                    sSupervisorEmail = "";
                    for (int j = 0; j < lines.length; j++) {
                      String jData = lines[j];
                      if (j == 0) {
                        sSupervisorEmail = jData;
                      } else if (j == lines.length - 1) {
                        sSupervisorEmail = String.valueOf(sSupervisorEmail) + "." + jData;
                      } else {
                        sSupervisorEmail = String.valueOf(sSupervisorEmail) + "-" + jData;
                      } 
                    } 
                    sSupervisorEmail = String.valueOf(sSupervisorEmail) + "@global.ntt";
                    sSupervisorEmail = sSupervisorEmail.toLowerCase();
                  } 
                } catch (Exception exception) {}
                break;
              case 3:
                try {
                  String[] lines = sValue.trim().split("\\r?\\n");
                  for (int j = 0; j < lines.length; j++) {
                    String jData = lines[j];
                    if (jData.indexOf("Mobile") > 0) {
                      sPhone = jData.substring(0, jData.indexOf(" ("));
                      sPhone = sPhone.trim();
                      sPhone = sPhone.replaceAll(" ", "");
                      if (sPhone.charAt(0) != '+')
                        sPhone = "+65" + sPhone; 
                    } 
                  } 
                } catch (Exception exception) {}
                break;
              case 4:
                try {
                  String[] lines = sValue.trim().split("\\r?\\n");
                  for (int j = 0; j < lines.length; j++) {
                    String jData = lines[j];
                    if (jData.indexOf("global.ntt") > 0)
                      sEmail = jData.trim().toLowerCase(); 
                  } 
                } catch (Exception exception) {}
                break;
            } 
            i++;
            continue;
          } 
          if (iColumn == 9) {
            switch (i) {
              case 0:
                try {
                  sWorkdayname = sValue.substring(0, sValue.indexOf("("));
                  sWorkdayname = sWorkdayname.trim();
                } catch (Exception exception) {}
                break;
              case 1:
                try {
                  sPosition = sValue.trim();
                  String[] lines = sPosition.split(" ");
                  for (int j = 0; j < lines.length; j++) {
                    String jData = lines[j];
                    if (j == 0) {
                      sPosition = "";
                    } else {
                      sPosition = String.valueOf(sPosition) + " " + jData;
                    } 
                  } 
                  sPosition = sPosition.trim();
                } catch (Exception exception) {}
                break;
              case 4:
                try {
                  sSupervisor = sValue.trim();
                  if (sSupervisor.length() > 0) {
                    String[] lines = sSupervisor.split("\\(");
                    if (lines.length > 0) {
                      sSupervisor = lines[1];
                      sSupervisor = sSupervisor.trim();
                    } 
                  } 
                  if (sSupervisor.length() > 0) {
                    String[] lines = sSupervisor.split(" ");
                    sSupervisorEmail = "";
                    for (int j = 0; j < lines.length; j++) {
                      String jData = lines[j];
                      if (j == 0) {
                        sSupervisorEmail = jData;
                      } else if (j == lines.length - 1) {
                        sSupervisorEmail = String.valueOf(sSupervisorEmail) + "." + jData;
                      } else {
                        sSupervisorEmail = String.valueOf(sSupervisorEmail) + "-" + jData;
                      } 
                    } 
                    sSupervisorEmail = String.valueOf(sSupervisorEmail) + "@global.ntt";
                    sSupervisorEmail = sSupervisorEmail.toLowerCase();
                  } 
                } catch (Exception exception) {}
                break;
              case 5:
                try {
                  String[] lines = sValue.trim().split("\\r?\\n");
                  for (int j = 0; j < lines.length; j++) {
                    String jData = lines[j];
                    if (jData.indexOf("Mobile") > 0) {
                      sPhone = jData.substring(0, jData.indexOf(" ("));
                      sPhone = sPhone.trim();
                      sPhone = sPhone.replaceAll(" ", "");
                      if (sPhone.charAt(0) != '+')
                        sPhone = "+65" + sPhone; 
                    } 
                  } 
                } catch (Exception exception) {}
                break;
              case 6:
                try {
                  String[] lines = sValue.trim().split("\\r?\\n");
                  for (int j = 0; j < lines.length; j++) {
                    String jData = lines[j];
                    if (jData.indexOf("global.ntt") > 0)
                      sEmail = jData.trim().toLowerCase(); 
                  } 
                } catch (Exception exception) {}
                break;
            } 
            i++;
          } 
        } 
        System.out.println("sWorkdayname=" + sWorkdayname + "," + 
            "sPosition=" + sPosition + "," + 
            "sSupervisor=" + sSupervisor + "," + 
            "sSupervisorEmail=" + sSupervisorEmail + "," + 
            "sPhone=" + sPhone + "," + 
            "sEmail=" + sEmail);
        if (!sEmail.contentEquals("")) {
          workday wd = new workday();
          workday.setEmployeename(sWorkdayname);
          workday.setPosition(sPosition);
          workday.setManagername(sSupervisor);
          workday.setManageremail(sSupervisorEmail);
          workday.setIdmanager(employee.queryIDEmployeeByEmail(sSupervisorEmail));
          workday.setMobilenumber(sPhone);
          workday.setEmail(sEmail);
          workday.setIdemployee(employee.queryIDEmployeeByEmail(sEmail));
          workday.setEname(employee.queryEnameByEmail(sEmail));
          wd.dbUpdateWorkdayEmployee();
          employee.updateEmployeeByEmail(sEmail, sPhone, workday.getIdmanager(), sSupervisor);
        } 
      } 
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public static void main(String[] args) {
    loadfile();
  }
}


/* Location:              D:\Rpa\rpappms\!\ApachePOIExcelRead.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */