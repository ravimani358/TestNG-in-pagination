package Pages; // Use lowercase for package names

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DB {

    @DataProvider(name = "getdata")
    public Object[][] dpMethod(Method m) throws IOException {
        String filePath = "C:\\Users\\RavishankarN\\eclips_respace\\Singletone_driver\\datafile\\excel.xlsx";
        	
        	File file = new File(filePath);        
        	FileInputStream fis = new FileInputStream(file); 
        	XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(m.getName());
            int rowCount = sheet.getLastRowNum();
            int cellCount = sheet.getRow(0).getLastCellNum(); // assuming row 0 has headers

            String[][] data = new String[rowCount][cellCount];

            for (int i = 1; i <= rowCount; i++) { // start from 1 to skip headers
                for (int j = 0; j < cellCount; j++) {
                	XSSFCell cell = sheet.getRow(i).getCell(j);
                	data[i - 1][j] = cell.getStringCellValue();
                }
            }
            wb.close();
            return data;
    }
}
