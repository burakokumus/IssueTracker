package com.ekinoks.issuetracker.controller;

import javax.swing.JOptionPane;

import com.ekinoks.issuetracker.database.DatabaseManager;
import com.ekinoks.issuetracker.view.Messages;
import com.ekinoks.issuetracker.view.SignupView;

public class SignupController
{
	private SignupView signupView;
	private DatabaseManager dbm;

	public SignupController(SignupView viewInput)
	{
		this.signupView = viewInput;
		this.dbm = new DatabaseManager();
	}

	public void initController()
	{
		signupView.getSignupButton().addActionListener(e -> signup());
	}

	/*
	 * Action listener for sign up button
	 */
	private void signup()
	{
		String userName = signupView.getUserName();
		String password = signupView.getPassword();

		String message = "";
		boolean userExists = dbm.checkUserExists(userName);
		if (userExists)
		{
			message = Messages.getString("userAlreadyExists");
		}
		else
		{
			dbm.addUser(userName, password);
			message = Messages.getString("signupSuccessful");
		}

		int showOptionDialog = JOptionPane.showOptionDialog(signupView, message, "", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);
		if (!userExists && (showOptionDialog == 0 || showOptionDialog == -1))
		{
			signupView.dispose();

		}
	}
}
