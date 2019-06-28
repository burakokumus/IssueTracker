package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.DatabaseManager;
import view.AddIssueDialogView;
import view.AddUserDialogView;
import view.Messages;
import view.View;
import model.Issue;

public class Controller
{
	private View view;
	private String currentUserName;
	private DatabaseManager dbm;

	public Controller(View viewInput)
	{
		this.view = viewInput;
		this.currentUserName = "";
		dbm = new DatabaseManager();
	}

	public void initController()
	{
		view.getAddIssueButton().addActionListener(e -> addIssue());
		view.getAddUserButton().addActionListener(e -> addUser());
		ArrayList<Issue> issueList = dbm.getAllIssues();
		for (Issue i : issueList)
			view.addIssueToJTable(i.getId(), i.getTitle(), i.getType(), i.getPriority(), i.getAuthor(),
					i.getDescription(), i.getState());
	}

	/**
	 * Action Listener for the Add Issue Button
	 */
	public void addIssue()
	{
		AddIssueDialogView addIssueDialogView = new AddIssueDialogView();
		addIssueDialogView.showScreen();
		AddIssueDialogController addIssueDialogController = new AddIssueDialogController(addIssueDialogView, view);
		addIssueDialogController.initController();
	}

	/**
	 * Action Listener for the Add User Button
	 */
	private void addUser()
	{
		if (dbm.getUserRank(currentUserName) > 2)
		{
			JOptionPane.showOptionDialog(view.frame, Messages.getString("cannotAddUser"), "", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, null, null);
		}
		else
		{
			AddUserDialogView addUserDialogView = new AddUserDialogView();
			addUserDialogView.showScreen();
			AddUserDialogController addUserDialogController = new AddUserDialogController(addUserDialogView);
			addUserDialogController.initController();
		}

	}

	public void setCurrentUserName(String userName)
	{
		this.currentUserName = userName;
	}

	public String getcurrentUserName()
	{
		return this.currentUserName;
	}

}
