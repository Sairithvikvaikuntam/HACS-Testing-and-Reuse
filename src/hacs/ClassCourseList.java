package hacs;

import java.util.ArrayList;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}

	// initialize the list by reading from the file.
    public void initializeFromFile(String theFileName) {
		try {
			BufferedReader br;
			File file = new File(theFileName);
			String strCourseName;
			br = new BufferedReader(new FileReader(file));
			while ((strCourseName = br.readLine()) != null) {
				System.out.println(strCourseName);
				Course course;
				course = new Course(strCourseName, 0);
//      theCourse.CourseName= strCourseName;
				add(course);
			}
		} catch (Exception e) {
			;
		}
	}

	public Course findCourseByCourseName(String courseName) {
		int nCourseCount = size();
		for (int i = 0; i < nCourseCount; i++) {
			Course theCourse;
			theCourse = (Course) get(i);
			if (theCourse.courseName.compareTo(courseName) == 1)
				return theCourse;
		}
		return null;
	}

}
