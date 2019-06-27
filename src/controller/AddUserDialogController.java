package controller;

import database.DatabaseManager;
import view.AddUserDialogView;

public class AddUserDialogController
{
	private AddUserDialogView addUserDialogView;

	private DatabaseManager dbm;

	public AddUserDialogController(AddUserDialogView viewInput)
	{
		this.addUserDialogView = viewInput;
		this.dbm = new DatabaseManager();
	}

	public void initController()
	{
		addUserDialogView.getAddUserButton().addActionListener(e -> addUser());

	}

	private void addUser()
	{
		String userName = addUserDialogView.getUserName();
		String password = addUserDialogView.getPassword();
		dbm.addUser(password, userName);
	}
}
