package covidTest;
import java.util.*;


//Date picker examples:
// https://examples.javacodegeeks.com/desktop-java/swing/java-swing-date-picker-example/
// https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component
// https://www.roseindia.net/tutorial/java/swing/datePicker.html

public class Main {
	private HashSet<Registration> regUsers;
	private int regNumCount=0;
	
	public Main() {
		regUsers = new HashSet<Registration>();
	}
	
	
	public void addReg(String fn, String ln, String email, long num, boolean hasCOVID) {
		int currentRegID = regNumCount++;
		regUsers.add(new Registration(fn,ln,email,num,hasCOVID, currentRegID));
	}
	
	
}
