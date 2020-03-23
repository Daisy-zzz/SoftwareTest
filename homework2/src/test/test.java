package test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.poi.ss.usermodel.*;

public class test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    public List<String> excel() throws Exception {
        //用流的方式先读取到你想要的excel的文件
        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir") + "/src/resources/Selenium+Lab2020.xlsx"));
        //获取整个excel
        XSSFWorkbook hb = new XSSFWorkbook(fis);
        //获取第一个表单sheet
        XSSFSheet sheet = hb.getSheetAt(0);
        //获取第一行
        int firstrow = sheet.getFirstRowNum();
        //获取最后一行
        int lastrow = sheet.getLastRowNum();
        //创建一个集合，用处将每一行的每一列数据都存入集合中
        List<String> list = new ArrayList<>();
        //循环行数依次获取列数
        for (int i = firstrow; i < lastrow + 1; i++) {
            //获取哪一行i
            Row row = sheet.getRow(i);
            if (row != null) {
                //获取这一行的第一列
                int firstcell = row.getFirstCellNum();
                //获取这一行的最后一列
                int lastcell = row.getLastCellNum();

                for (int j = firstcell; j < lastcell; j++) {
                    //获取第j列
                    Cell cell = row.getCell(j);

                    if (cell != null) {
                        list.add(cell.toString());
                    }
                }

            }
        }
        fis.close();
        return list;
    }


    @Before
    public void setUp() {
        String driverPath = System.getProperty("user.dir") + "/src/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testBD() throws Exception {
        List<String> list = new ArrayList<>();
        list = excel();
        driver.get("http://103.120.226.190/selenium-demo/git-repo");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        for (int i = 0; i < list.size(); i += 2) {
            String username = list.get(i);
            String password = list.get(i + 1);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[1]/input")).click();
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(username);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[2]/input")).click();
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(password);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input")).click();
            assertThat(driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code")).getText(), is(password));
        }

    }
}
