package controller;

import view.LoginView;
import view.View;

public class LoginController
{
	private View mainView;
	private LoginView loginView;
	private Controller mainController;

	public LoginController(LoginView loginViewInput, View mainViewInput, Controller mainControllerInput)
	{
		this.loginView = loginViewInput;
		this.mainView = mainViewInput;
		this.mainController = mainControllerInput;
	}

	public void initController()
	{
		loginView.getLoginButton().addActionListener(e -> login());
	}

	private void login()
	{ // TODO
		
		mainController.setCurrentUserName(loginView.getUserName());
		mainView.setCurrentUserName(loginView.getUserName());
		loginView.dispose();
		mainView.showScreen();
	}
}
