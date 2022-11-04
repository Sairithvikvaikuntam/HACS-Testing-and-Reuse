package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 * Update to Java 8
 */

public class UserInfoItem {

	public enum UserType { Student, Instructor }
	
	public String strUserName;
	public UserType userType; // 0 : hacs.Student, 1: hacs.Instructor
}
