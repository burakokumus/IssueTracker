package controller;

import javax.swing.JOptionPane;

import database.DatabaseManager;
import view.AddIssueDialogView;
import view.Messages;

public class AddIssueDialogController
{
	private AddIssueDialogView addIssueDialogView;

	private DatabaseManager dbm;

	public AddIssueDialogController(AddIssueDialogView viewInput)
	{
		this.addIssueDialogView = viewInput;
		this.dbm = new DatabaseManager();
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
		String author = addIssueDialogView.getIssueAuthor();
		String description = addIssueDialogView.getIssueDescription();

		if (priority == -1 || title.trim().length() == 0)
		{
			System.out.println(priority + "  " + title);
			return;
		}
			

		boolean added = dbm.addIssue(title, type, priority, author, description);
		String message = "";
		if (added)
		{
			message = Messages.getString("issueAdded");
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
}
