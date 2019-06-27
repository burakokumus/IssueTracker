package controller;

import javax.swing.JOptionPane;

import database.DatabaseManager;
import view.AddUserDialogView;
import view.Messages;

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
		if(userName.trim().length() == 0 || password.trim().length() == 0)
		{
			return;
		}
		boolean added = dbm.addUser(password, userName);
//		(addUserDialogView, Messages.getString("userAdded"));
		String message = "";
		
		if(added)
		{
			message = Messages.getString("issueAdded");
		}
		else
		{
			message = Messages.getString("issueAlreadyExists");
		}
		int showOptionDialog = JOptionPane.showOptionDialog(addUserDialogView, message, "",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

		if (added && (showOptionDialog == 0 || showOptionDialog == -1))
		{
			addUserDialogView.dispose();
			
		}
	}
}
