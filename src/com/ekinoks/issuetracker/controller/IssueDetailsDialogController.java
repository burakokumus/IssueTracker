package com.ekinoks.issuetracker.controller;

import java.util.ArrayList;

import com.ekinoks.issuetracker.database.DatabaseManager;
import com.ekinoks.issuetracker.view.IssueDetailsDialogView;

public class IssueDetailsDialogController
{
	private IssueDetailsDialogView issueDetailsDialogView;
	private DatabaseManager dbm;
	private int ID;
	private String title;
	private String author;
	private String type;
	private ArrayList<String> assignees;

	public IssueDetailsDialogController(IssueDetailsDialogView issueDetailsDialogView, int ID,
			String title, String author, String type, ArrayList<String> assignees)
	{
		this.dbm = new DatabaseManager();
		this.issueDetailsDialogView = issueDetailsDialogView;
		this.ID = ID;
		this.title = title;
		this.author = author;
		this.type = type;
		this.assignees = assignees;
	}

}
