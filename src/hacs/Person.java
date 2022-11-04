package hacs;

import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

abstract public class Person {
	int type = 0; // type=0 : student, type=1 instructor
	public String userName;
	public ClassCourseList courseList;
	CourseMenu courseMenu;
	Course currentCourse;
	Assignment currentAssignment;

	public Person() {
		courseList = new ClassCourseList();
	}

	abstract public CourseMenu createCourseMenu(Course theCourse, int theLevel);

	public void showAddButton() {
		courseMenu.showAddButtons();
	}

	public void showViewButtons() {
		courseMenu.showViewButtons();
	}

	public void showComboxes() {
		courseMenu.showComboxes();
	}

	public void showRadios() {
		courseMenu.showRadios();
	}

	public void show() {
		courseMenu.show();
	}

	public boolean ifLogout() {
		return courseMenu.ifLogout();
	}

	// show the assignment list
	public boolean showMenu() {
		// create a iterator for the assignment list
//    Iterator theIter=new hacs.ListIterator(CurrentCourse.AssList );
		Iterator theIter = currentCourse.assignmentList.iterator();
		courseMenu.course = currentCourse;
		Assignment assignment;
		while (theIter.hasNext()) {
			assignment = (Assignment) theIter.next();
			courseMenu.assignmentCombox.addItem(assignment);
		}
		return false;
	}

	public ClassCourseList getCourseList() {
		return courseList;
	}

	public void addCourse(Course theCourse) {
		courseList.add(theCourse);
	}
}