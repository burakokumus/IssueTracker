package com.ekinoks.issuetracker.controller;

import javax.swing.JOptionPane;

import com.ekinoks.issuetracker.database.DatabaseManager;
import com.ekinoks.issuetracker.model.Issue;
import com.ekinoks.issuetracker.view.AddIssueDialogView;
import com.ekinoks.issuetracker.view.Messages;
import com.ekinoks.issuetracker.view.View;


public class AddIssueDialogController
{
	private AddIssueDialogView addIssueDialogView;

	private DatabaseManager dbm;

	private View mainView;

	public AddIssueDialogController(AddIssueDialogView viewInput, View mainView)
	{
		this.addIssueDialogView = viewInput;
		this.dbm = new DatabaseManager();
		this.mainView = mainView;
	}

	public void initController()
	{
		addIssueDialogView.getAddIssueButton().addActionListener(e -> addIssue());

	}

	private void addIssue()
	{
		String title = addIssueDialogView.getIssueTitle();
		String type = addIssueDialogView.getIssueType();
		int priority = addIssueDialogView.getIssuePriority();
		String description = addIssueDialogView.getIssueDescription();

		if (priority == -1 || title.trim().length() == 0)
		{
			return;
		}

		String author = mainView.getCurrentUserName();
		boolean added = dbm.addIssue(title, type, priority, author, description);
		String message = "";
		if (added)
		{
			message = Messages.getString("issueAdded");
			dbm.addRelation(mainView.getCurrentUserName(), title);
			addToJTable(title);
		}
		else
		{
			message = Messages.getString("issueAlreadyExists");
		}

		int showOptionDialog = JOptionPane.showOptionDialog(addIssueDialogView, message, "", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);

		if (added && (showOptionDialog == 0 || showOptionDialog == -1))
		{
			addIssueDialogView.dispose();
		}
	}

	private void addToJTable(String title)
	{
		Issue issue = dbm.getIssue(title);
		mainView.addIssueToJTable(issue.getId(), issue.getTitle(), issue.getType(), issue.getPriority(),
				issue.getAuthor(), issue.getDescription(), issue.getState());

	}
}
