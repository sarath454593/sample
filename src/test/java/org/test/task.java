package org.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/?s_kwcid=AL!739!3!582822043580!b!!g!!flipkart&gclsrc=aw.ds&&semcmpid=sem_8024046704_brand_exe_buyers_goog&gad_source=1&gclid=CjwKCAiA3Na5BhAZEiwAzrfagN_jrFdLs5HfZjMpvPhIkUsi08Uy8CI5se3DWRPOwVr0AH3o7ugA_BoCIxkQAvD_BwE");
		//sarath
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebElement searchProduct = driver.findElement(By.xpath("//input[@type='text']"));
		
		searchProduct.sendKeys("Iphone",Keys.ENTER);   //1
		
		List<WebElement> AllIphone = driver.findElements(By.xpath("//div[@class='_75nlfW']"));
		
		System.out.println("Total Iphone : "+AllIphone.size());
		
		
		System.out.println("Total Result : "+AllIphone.size() * 24);
		
		System.out.println("---------------------------------------------------");
		
		System.out.println("List Of All Iphones : ");
		
		List<WebElement> AllIphoneNames = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		
		for(WebElement w : AllIphoneNames) {
			System.out.println(w.getText());
		}
		
		System.out.println("---------------------------------------------------");
		
		List<WebElement> CostOfAllIphone = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));	
		
		System.out.println("Cost Of All Iphones : ");
		
		for(int i=0;i<CostOfAllIphone.size();i++) {
			WebElement Cost = CostOfAllIphone.get(i);
			System.out.println(Cost.getText());
		}
		
		System.out.println("---------------------------------------------------");
		
		List <Integer> l = new ArrayList<Integer>(); 
		
		for(WebElement x : CostOfAllIphone) {
			String text = x.getText();
			String replace = text.replace("₹", "");
			String replace2 = replace.replace(",", "");
			int int1 = Integer.parseInt(replace2);
			Integer CostInteger = Integer.valueOf(int1);
			l.add(CostInteger);
		}
		
		Collections.sort(l);
		
		System.out.println("Minimum Amount : "+"₹"+l.get(0));
		
		System.out.println("Maximum Amount : "+"₹"+l.get(l.size()-1));
		
		
		System.out.println("---------------------------------------------------");
		
		
		for(int i=0;i<AllIphone.size();i++) {
			System.out.println(AllIphoneNames.get(i).getText() + "  ->  " + CostOfAllIphone.get(i).getText());
		}
		
	
		
	driver.quit();
		
	}
}
