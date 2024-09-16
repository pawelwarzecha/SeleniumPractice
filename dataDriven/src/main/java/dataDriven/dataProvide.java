package dataDriven;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class dataProvide {

    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting, String communication, String id){

        System.out.println(greeting+communication+id);

    }

    @DataProvider(name = "driveTest")
    public Object[][] getData() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\HP Compat\\Desktop\\Java\\Selenium\\dataDriven\\sampleData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowcount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        Object[][] data = new Object[rowcount - 1][colCount];

        for (int i = 0; i < rowcount-1; i++) {

            row = sheet.getRow(i+1);
            for (int j = 0; j < colCount; j++) {

                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        return data;
    }
}
