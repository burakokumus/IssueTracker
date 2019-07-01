package com.ekinoks.issuetracker.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.ekinoks.issuetracker.database.DatabaseManager;
import com.ekinoks.issuetracker.model.Issue;
import com.ekinoks.issuetracker.view.AddIssueDialogView;
import com.ekinoks.issuetracker.view.AddUserDialogView;
import com.ekinoks.issuetracker.view.Messages;
import com.ekinoks.issuetracker.view.View;

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

	public String getCurrentUserName()
	{
		return this.currentUserName;
	}

}
