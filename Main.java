package covidTest;
import java.util.*;


public class Main {
	private HashSet<Registration> regUsers;
	private int regNumCount=0;
	
	public Main() {
		regUsers = new HashSet<Registration>();
	}
	
	
	public void addReg(String fn, String ln, String email, String num, String hasCOVID) {
		int currentRegID = regNumCount++;
		regUsers.add(new Registration(fn,ln,email,num,hasCOVID, currentRegID));
	
	}
	
	public boolean containsNumber(String num) {
//		if(regUsers == null) {
//			return false;
//		}
		for(Registration r : regUsers) {
			if(r.getNum().equals(num)) {
				return true;
			}
		}
		return false;
	}	
	
	public boolean containsEmail(String email) {
		for(Registration r: regUsers) {
			if(r.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
}
