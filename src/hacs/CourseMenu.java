package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

import static hacs.Hacs.facade;


/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class CourseMenu extends JDialog
{
  Course course;
  boolean bLogout=true;

  JRadioButton assignmentRadio = new JRadioButton();
  JComboBox assignmentCombox = new JComboBox();
  JButton assignmentViewButton = new JButton();
  JButton assignmentAddButton = new JButton();
  JRadioButton optionRadio = new JRadioButton();
  JLabel assignmentContentLabel = new JLabel();
  JComboBox optionCombo = new JComboBox();
  JButton optionViewButton = new JButton();
  JButton optionAddButton = new JButton();
  JButton buttonChangeCourse = new JButton();
  JButton buttonLogout = new JButton();

  public CourseMenu()
  {

    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    setModal(true);
    setSize(503,294);
  }

  private void jbInit() throws Exception
  {
    buttonChangeCourse.setText("ChangeCourse");
    buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
    buttonChangeCourse.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonChangeCourseActionPerformed(e);
      }
    });
    this.getContentPane().setLayout(null);
    this.setTitle("");
    buttonLogout.setText("Logout");
    buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
    buttonLogout.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonLogoutActionPerformed(e);
      }
    });
    this.getContentPane().add(buttonChangeCourse, null);
    this.getContentPane().add(buttonLogout, null);
  }

  /* when the add button is pressed, call add assignment
  function of facade, after that refresh window
  */

  /* when the add button is pressed, call ViewAssignment
  function of facade, after that refresh window
  */

  abstract void showMenu(Course theCourse);
  abstract void showAddButtons();
  abstract void showViewButtons();
  abstract void showRadios();
  abstract void showComboxes();
  abstract void showLabel();

  void assignmentAddButtonActionPerformed(ActionEvent e)
  {
    facade.addAssignment(course);
    refresh();
  }
  void assignmentViewButtonActionPerformed(ActionEvent e)
  {
    Assignment assignment=(Assignment)assignmentCombox.getSelectedItem() ;
    facade.ViewAssignment(assignment);
  }
  void refresh()
  {
    assignmentCombox.removeAllItems() ;
    Iterator Iter=course.assignmentList.iterator() ;
    while(Iter.hasNext() )
    {
      assignmentCombox.addItem(Iter.next() );
    }
  }

  void buttonChangeCourseActionPerformed(ActionEvent e)
  {
    bLogout=false;
    hide();
  }

  void buttonLogoutActionPerformed(ActionEvent e)
  {
    bLogout=true;
    hide();
  }
  boolean ifLogout()
  {
    return bLogout;
  }
}
