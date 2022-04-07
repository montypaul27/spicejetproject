package utilityclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DatePickerUtility 
{
	public void selectyear(WebElement calendar, int year) throws Exception
	{
		while(true) //infinite loop
		{
			String temp=calendar.findElement(By.className("ui-datepicker-year")).getText();
			int cy=Integer.parseInt(temp);
			if(year<cy) // expected year belongs to past
			{
				calendar.findElement(By.xpath("descendent::a[@title='prev']")).click();
				Thread.sleep(1000);
			}
			else if(year>cy) // expected year belongs to future
			{
				calendar.findElement(By.xpath("descendent::a[@title='Next']")).click();
				Thread.sleep(1000);
			}
			else //reached the expected year from present
			{
				break; //terminate from loop
			}
		}
	}
	public void selectMonth(WebElement calendar, String month) throws Exception
	{
	//step-1: come to january
	while(true)
	{
		String cm=calendar.findElement(By.xpath("ui-datepicker-month")).getText();
		if(!cm.equalsIgnoreCase("january"))
		{
			calendar.findElement(By.xpath("descendent::a[@title='Prev']")).click();
			Thread.sleep(1000);
		}
		else
		{
			break;
		}
	}
//step-2: come to target month from january
	while(true)
	{
		String cm=calendar.findElement(By.xpath("ui-datepicker-month")).getText();
		if(!cm.equalsIgnoreCase(month))
		{
			calendar.findElement(By.xpath("descendent::a[@title='Next']")).click();
			Thread.sleep(1000);
		}
		else
		{
			break;
		}
	}
	}
	public void selectDay(WebElement calendar, int day)
	{
	try
	{
		calendar.findElement(By.xpath("child::table[@class='ui-datepicker-calendar']/tbody//a[text()='"+day+"']")).click();
	}
	catch(Exception ex)
	{
		System.out.println("No given day in that month");
	}
}
public void selectSpecialDay(WebElement calendar, String weekday, int index)
{
	int col;
	if(weekday.equals("sunday"))
	{
		col=1;
	}
	else if(weekday.equalsIgnoreCase("monday"))
	{
		col=2;
	}
	else if(weekday.equalsIgnoreCase("tuesday"))
	{
		col=3;
	}
	else if(weekday.equalsIgnoreCase("wednesday"))
	{
		col=4;
	}
	else if(weekday.equalsIgnoreCase("thursday"))
	{
		col=5;
	}
	else if(weekday.equalsIgnoreCase("friday"))
	{
		col=6;
	}
	else // saturday
	{
		col=7;
	}
	try
	{
		calendar.findElement(By.xpath("(child::table[@class='ui-datepicker-calendar']/tbody/tr/td["+col+"]/a)["+index+"]")).click();
	}
	catch(Exception ex)
	{
		System.out.println("No "+index+" th "+weekday+" in that month");
	}
}
}