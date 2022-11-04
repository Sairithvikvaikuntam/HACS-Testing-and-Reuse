package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class InstructorAssignmentMenu extends AssignmentMenu
{
////  class AssignmentMenu
  private boolean bSubmit=false;
  private Solution theSolution;
  private Assignment theAssignment;
  JComboBox CombSolutionList = new JComboBox();
  JTextField tbAssignmentName = new JTextField();
  JTextField tbDueDate = new JTextField();
  JTextField tbSuggestedSolution = new JTextField();

  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JButton buttonGrade = new JButton();
  JButton buttonReport = new JButton();
  JButton buttonClose = new JButton();

  public InstructorAssignmentMenu()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception
  {
    jLabel1.setText("hacs.Assignment Name");
    jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
    this.getContentPane().setLayout(null);
    tbAssignmentName.setText("jTextField1");
    tbAssignmentName.setBounds(new Rectangle(192, 31, 341, 22));
    jLabel2.setText("Due Date");
    jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
    tbDueDate.setText("tbDueDate");
    tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
    jLabel3.setText("Suggested Solution");
    jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
    tbSuggestedSolution.setText("jTextField2");
    tbSuggestedSolution.setBounds(new Rectangle(197, 149, 339, 22));
    buttonGrade.setText("Grade");
    buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
    buttonGrade.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonGradeActionPerformed(e);
      }
    });
    buttonReport.setText("Report");
    buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
    buttonReport.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonReportActionPerformed(e);
      }
    });
    buttonClose.setText("Close");
    buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
    buttonClose.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        buttonCloseActionPerformed(e);
      }
    });
    CombSolutionList.setBounds(new Rectangle(32, 204, 413, 22));
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(tbAssignmentName, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(tbDueDate, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(tbSuggestedSolution, null);
    this.getContentPane().add(buttonClose, null);
    this.getContentPane().add(CombSolutionList, null);
    this.getContentPane().add(buttonGrade, null);
    this.getContentPane().add(buttonReport, null);
  }
  public void showMenu(Assignment assignment, Person person)
  {
    theAssignment=assignment;
    Solution theSolution;
    tbAssignmentName.setText(theAssignment.assName );

    DateFormat theDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
    tbDueDate.setText(theDateFormat.format(theAssignment.dueDate));
    tbSuggestedSolution.setText(theAssignment.suggestSolution.solutionFileName );
    refreshSolutionList();
    show();
  }

  void buttonCloseActionPerformed(ActionEvent e)
  {
    theAssignment.assName = tbAssignmentName.getText() ;
    DateFormat tempDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
    try
    {
      theAssignment.dueDate=tempDateFormat.parse(tbDueDate.getText() );
    }catch (Exception ee){};
    theAssignment.suggestSolution.solutionFileName =tbSuggestedSolution.getText() ;
    hide();
  }

  void buttonGradeActionPerformed(ActionEvent e)
  {
    Solution theSolution=(Solution)CombSolutionList.getSelectedItem() ;
    if (theSolution==null)
       return;
    SolutionGradingDlg dlg=new SolutionGradingDlg();
    dlg.show(theSolution);
    refreshSolutionList();
  }

  void buttonReportActionPerformed(ActionEvent e)
  {
    SolutionIterator iter=new SolutionIterator(theAssignment.solutionList );
    while(iter.hasNext() )
    {
      Solution asolution=(Solution)iter.next();
      asolution.setReported(true);
    }
    refreshSolutionList();
  }
  private void refreshSolutionList()
  {
    CombSolutionList.removeAllItems() ;
    SolutionIterator SolIter=new SolutionIterator(theAssignment.solutionList );
    while(SolIter.hasNext() )
    {
      theSolution=(Solution)SolIter.next();
      CombSolutionList.addItem(theSolution);
    }
  }
}