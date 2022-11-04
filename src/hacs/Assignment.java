package hacs; /**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

import java.util.*;
import java.text.DateFormat;

public class Assignment {

  public String assName;
  public Date dueDate = new Date();
  public String assSpec;
  public SolutionList solutionList = new SolutionList();
  protected Solution suggestSolution = new Solution();



  public Assignment() {
  }

  public void setDueDate(Date dueDate){
    this.dueDate = dueDate;
  }

  public void setAssSpec(String spec){
    this.assSpec = spec;
  }

  public boolean isOverDue(){
    Date today;
    today = new Date();
    if (today.after(this.dueDate)) {
      return true;
    } else {
      return false;
    }
  }

  public Solution addSolution(){
    Solution mySolution = new Solution();
    return mySolution;
  }

  ////add the theSolution to the Solutionlist
  public void addSolution(Solution solution)
  {
    solutionList.add(solution);
  }

  public void submitSolution(){
  }

  public void getSolutionList(){
  }

  /* return the solution of the give name
  */
  public Solution getSolution(String studentName)
  {
    SolutionIterator iterator = (SolutionIterator)solutionList.iterator();
    return (Solution)iterator.next(studentName);
  }

  public Solution getSugSolution(){
    return suggestSolution;
  }

  public SolutionIterator getSolutionIterator()
  {
    SolutionIterator solutionIterator = new SolutionIterator(solutionList);
    return solutionIterator;
  }

  public String toString()
  {
    return assName;
  }

  public String getDueDateString()
  {
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
    return  dateFormat.format(dueDate);
  }

  public void accept(NodeVisitor visitor)
  {
    visitor.visitAssignment(this);
  }
}
