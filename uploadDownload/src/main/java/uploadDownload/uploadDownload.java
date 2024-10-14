package uploadDownload;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

public class uploadDownload {

    public static void main(String[] args) throws IOException {

        String fruitName = "Apple";
        String updatedValue = "598";
        String fileName = "C:\\Users\\HP Compat\\Downloads\\download.xlsx";
        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Chrome Driver\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(co);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        driver.findElement(By.cssSelector("#downloadButton")).click();
        
        int col = getColumnNumber(fileName, "price");
        int row = getRowNumber(fileName, "Apple");
        Assert.assertTrue(updateCell(fileName,row,col,updatedValue));

        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys("C:\\Users\\HP Compat\\Downloads\\download.xlsx");

        WebElement toastLocator = driver.findElement(By.cssSelector(
                ".Toastify__toast-body div:nth-child(2)"));

        wait.until(ExpectedConditions.visibilityOf(toastLocator));
        String toastText = toastLocator.getText();
        System.out.println(toastText);
        assertEquals("Updated Excel Data Successfully.", toastText);

        wait.until(ExpectedConditions.invisibilityOf(toastLocator));

        String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
        String actualPrice = driver.findElement(By.xpath(
                "//div[text()='" + fruitName + "']/parent::div/parent::div/div[@id='cell-" + priceColumn + "-undefined']/child::div")).getText();
        System.out.println(actualPrice);
        assertEquals(updatedValue, actualPrice);

        driver.close();
    }



    private static boolean updateCell(String fileName, int row, int col, String updatedValue) throws IOException {

        ArrayList<String> a = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row rowField = sheet.getRow(row-1);
        Cell cellField = rowField.getCell(col-1);
        cellField.setCellValue(updatedValue);
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        workbook.close();
        fis.close();
        return true;
    }

    private static int getRowNumber(String fileName, String text) throws IOException {

        ArrayList<String> a = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rows = sheet.iterator();
        int k = 1;
        int rowIndex = -1;
        while(rows.hasNext()){
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();

            while(cells.hasNext()){

                Cell cell = cells.next();
                if(cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(text)){
                    rowIndex = k;
                }
            }
            k++;
        }
        return rowIndex;
    }

    private static int getColumnNumber(String fileName, String colName) throws IOException {

        ArrayList<String> a = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> rows = sheet.iterator();
        Row firstRow = rows.next();
        Iterator<Cell> ce = firstRow.cellIterator();
        int k = 1;
        int column = 0;
        while (ce.hasNext()) {
            Cell value = ce.next();
            if (value.getStringCellValue().equalsIgnoreCase(colName)) {
                column = k;
            }
            k++;
        }
        System.out.println(column);

        return column;
    }
}
