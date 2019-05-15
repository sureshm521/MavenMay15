package MavenGIT.MavenMay15;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Testngg {
	FirefoxDriver driver;
	@Test
	public void sample() throws IOException
	{
		FileInputStream fs=new FileInputStream("");
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row> it=ws.iterator();
		it.next();
		while(it.hasNext())
		{
			Row r=it.next();
			driver.findElement(By.xpath(""));
		}
	}

}
