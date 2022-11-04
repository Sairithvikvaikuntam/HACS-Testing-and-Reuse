package hacs;

import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 * update to Java 8
 */

public class Solution {
	public String author = "";
	public String solutionFileName = "";
	Date submitData = new Date();
	public int grade;
	public boolean reported = false;

	public Solution() {
	}

	@Override
	public String toString() {
		String string;
		string = author + "  " + solutionFileName + " Grade=" + getGradeInt() + "  ";
		if (isReported()) {
			string += "reported";
		} else {
			string += "not reported";
		}

		return (string);
	}

	public String getGradeString() {
		if (isReported()) {
			return "" + grade;
		} else {
			return "-1";
		}
	}

	public int getGradeInt() {
		return grade;
	}

	public void setReported(boolean reported) {
		this.reported = reported;
	}

	public boolean isReported() {
		return reported;
	}
}
