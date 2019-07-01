package com.ekinoks.issuetracker.controller;

import javax.swing.JOptionPane;

import com.ekinoks.issuetracker.database.DatabaseManager;
import com.ekinoks.issuetracker.view.LoginView;
import com.ekinoks.issuetracker.view.Messages;
import com.ekinoks.issuetracker.view.SignupView;
import com.ekinoks.issuetracker.view.View;

public class LoginController
{
	private View mainView;
	private LoginView loginView;
	private Controller mainController;
	private DatabaseManager dbm;

	public LoginController(LoginView loginViewInput, View mainViewInput, Controller mainControllerInput)
	{
		this.loginView = loginViewInput;
		this.mainView = mainViewInput;
		this.mainController = mainControllerInput;
		this.dbm = new DatabaseManager();
	}

	public void initController()
	{
		loginView.getLoginButton().addActionListener(e -> login());
		loginView.getSignUpButton().addActionListener(e -> signup());
	}

	/**
	 * Action listener for login button
	 */
	private void login()
	{
		String userName = loginView.getUserName();
		String password = loginView.getPassword();

		if (dbm.login(userName, password))
		{
			mainController.setCurrentUserName(loginView.getUserName());
			mainView.setCurrentUserName(loginView.getUserName());
			loginView.dispose();
			mainView.showScreen();
		}
		else
		{
			JOptionPane.showOptionDialog(loginView, Messages.getString("loginFailed"), "", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, null, null);
		}

	}

	/**
	 * Action listener for sign up button
	 */
	private void signup()
	{
		SignupView signupView = new SignupView();
		signupView.showScreen();
		SignupController signupController = new SignupController(signupView);
		signupController.initController();

	}
}
