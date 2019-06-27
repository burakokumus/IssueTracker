package controller;


import database.DatabaseManager;
import view.AddUserDialogView;
import view.View;

public class Controller
{
	private View view;
	private String currentUserName;

	public Controller(View viewInput)
	{
		this.view = viewInput;
		this.currentUserName = "";
	}

	public void initController()
	{
		//view.getAddIssueButton().addActionListener(e -> addIssue());
		view.getAddUserButton().addActionListener(e -> addUser());
	}

	public void addIssue()
	{
		view.getDefaultTableModel().addRow(new Object[]
		{ 1, "Task 1" });
	}

	/**
	 * Action Listener for the Add User Button
	 */
	private void addUser()
	{
		AddUserDialogView addUserDialogView = new AddUserDialogView();
		addUserDialogView.showScreen();
		AddUserDialogController addUserDialogController = new AddUserDialogController(addUserDialogView);
		addUserDialogController.initController();
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
