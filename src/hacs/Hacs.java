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

public class Hacs {

	static Facade facade = new Facade();

	public Hacs() {
	}

	public static void main(String[] args) {
//		String strUsername;
//		String strUserType = null;
		UserInfoItem userinfoitem = new UserInfoItem();
		facade.createCourseList();
		while (true) {
			boolean bExit = false;
			bExit = facade.Login(userinfoitem);
			if (bExit)
				break;
			// userinfoitem.strUserName = "Inst1";
			// userinfoitem.UserType = 1;
			facade.createUser(userinfoitem);
			facade.attachCourseToUser();
			if (userinfoitem.userType == UserInfoItem.UserType.Student) // if is a student remind him of the due date
				facade.remind();
			boolean bLogout = false;
			while (!bLogout) {
				bLogout = facade.selectCourse();
				if (bLogout)
					break;
				bLogout = facade.courseOperation();
			}
		}
//    System.out.println(userinfoitem.strUserName +userinfoitem.UserType );
	}
}
