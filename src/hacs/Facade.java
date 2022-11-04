package hacs;

import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 *          Update to Jave 8
 */

public class Facade {
	public int UserType;
	private Course selectedCourse = null;
	private int nCourseLevel = 0;
	ClassCourseList courseList;
	public Person person;

	public Facade() {
	}

	static public boolean Login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.show();
		userinfoItem.strUserName = login.GetUserName();
		userinfoItem.userType = login.GetUserType();
		return login.isExit();
	}

//  functions for CourseMenu
	/*
	 * When click the add button of the hacs.CourseMenu , call this function this
	 * function will new an assignment fill the required infomation this function
	 * will call hacs.InstructorAssignmentMenu or hacs.StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the coursemenu need to
	 * refreshed outside the function
	 */

	public void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (person.type == UserInfoItem.UserType.Student.ordinal())/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, person);
		theCourse.addAssignment(theAssignment);
	}

	/*
	 * When click the view button of the hacs.CourseMenu , call this function and pass
	 * the pointer of the hacs.Assignment and the person pointer to this function this
	 * function will new an assignment fill the required infomation this function
	 * will call hacs.InstructorAssignmentMenu or hacs.StudentAssignmentMenu according to the
	 * type of the user
	 */
	void ViewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (person.type == UserInfoItem.UserType.Student.ordinal())/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}

		theAssignmentMenu.showMenu(theAssignment, person);
	}

//functions for InstructorAssignmentMenu
	/*
	 * this function will grade the give Solution: theSolution this function calls
	 */

	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.showMenu(theSolution);
	}

	void reportSolutions(Assignment theAssignment) {
		Solution solution;
		SolutionIterator solutionIterator;
		solutionIterator = theAssignment.getSolutionIterator();
		solution = (Solution) solutionIterator.next();
		while (solution != null) {
			solution.setReported(true);
			solution = (Solution) solutionIterator.next();
		}
	}
////////////////////

//functions for StudentAssignmentMenu
	void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

//////////
	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(person.getCourseList());
	}

	public void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.userType == UserInfoItem.UserType.Student) {
			/// student
			person = new Student();
		} else {
			/// instructor
			person = new Instructor();
		}
		person.userName = userinfoitem.strUserName;
	}

	/*
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	void createCourseList() {
		courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");
	}

	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user hacs.Facade.thePerson.CourseList
	 */
	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserCourse.txt"));
			String aline, strUserName, strCourseName;
			while ((aline = file.readLine()) != null) // not the EOF
			{
				strUserName = getUserName(aline);
				strCourseName = getCourseName(aline);
				if (strUserName.compareTo(person.userName) == 0) /// the UserName mateches
				{
					selectedCourse = findCourseByCourseName(strCourseName);
					if (selectedCourse != null) /// Find the hacs.Course in the CourseList--->attach
					{
						person.addCourse(selectedCourse);
					}
				}
			}
		} catch (Exception ee) {
			;
		}
	}

	/*
	 * get the user name from aline UserName:CourseName
	 */
	private String getUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/*
	 * get the CourseName from aline UserName:CourseName
	 */
	private String getCourseName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}

	/*
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelecteCourse, the hacs.Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		selectedCourse = theDlg.showDlg(person.courseList);
		person.currentCourse = selectedCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean courseOperation() {
		person.createCourseMenu(selectedCourse, nCourseLevel);
		return person.showMenu();//// 0: logout 1 select an other course
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * hacs.CourseIterator for the List 2 Find the hacs.Course with the Iterator return the
	 * pointer of the hacs.Course if not fine, return null;
	 */
	private Course findCourseByCourseName(String strCourseName) {
		CourseIterator iterator = new CourseIterator(courseList);
		return (Course) iterator.next(strCourseName);
	}

}
