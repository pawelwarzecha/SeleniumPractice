package dataDriven;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class dataProvide {


    @Test(dataProvider = "driveTest")
    public void testCaseData(String greeting, String communication, String id){

        System.out.println(greeting+communication+id);

    }

    @DataProvider(name = "driveTest")
    public Object[][] getData() throws IOException {

        //Object[][] data = {{"a","b","1"},{"z","x","2"},{"q","w","3"}};
        //return data;

        FileInputStream fis = new FileInputStream("");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowcount = sheet.getPhysicalNumberOfRows();
        XSSFRow rows = sheet.getRow(0);
    }

}
