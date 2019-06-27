package main;

import java.awt.EventQueue;

import controller.Controller;
import controller.LoginController;
import view.LoginView;
import view.View;

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
