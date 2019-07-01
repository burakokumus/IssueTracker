package com.ekinoks.issuetracker.main;

import java.awt.EventQueue;

import com.ekinoks.issuetracker.controller.Controller;
import com.ekinoks.issuetracker.controller.LoginController;
import com.ekinoks.issuetracker.view.LoginView;
import com.ekinoks.issuetracker.view.View;

// TODO https://stackoverflow.com/questions/14814492/how-to-create-right-click-menu-in-jtable

public class Main
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					View mainView = new View();
					LoginView loginView = new LoginView();
					Controller controller = new Controller(mainView);
					LoginController loginController = new LoginController(loginView, mainView, controller);
					loginController.initController();
					controller.initController();
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		
		
		);
	}
}
