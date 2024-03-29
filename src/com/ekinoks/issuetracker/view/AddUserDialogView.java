package com.ekinoks.issuetracker.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddUserDialogView extends JDialog
{
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	private JButton addUserButton;
	private GridBagLayout gridBagLayout;
	private JLabel userNameLabel;
	private GridBagConstraints gbc_userNameLabel;
	private GridBagConstraints gbc_userNameTextField;
	private JLabel passwordLabel;
	private GridBagConstraints gbc_passwordLabel;
	private GridBagConstraints gbc_passwordField;
	private GridBagConstraints gbc_addUserButton;

	public AddUserDialogView()
	{
		initialize();
	}

	private void initialize()
	{

		setMinimumSize(new Dimension(500, 500));
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 0, 0, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		userNameLabel = new JLabel("User Name:");
		gbc_userNameLabel = new GridBagConstraints();
		gbc_userNameLabel.insets = new Insets(5, 5, 5, 5);
		gbc_userNameLabel.anchor = GridBagConstraints.EAST;
		gbc_userNameLabel.gridx = 0;
		gbc_userNameLabel.gridy = 0;
		getContentPane().add(userNameLabel, gbc_userNameLabel);

		userNameTextField = new JTextField();
		gbc_userNameTextField = new GridBagConstraints();
		gbc_userNameTextField.insets = new Insets(5, 5, 5, 5);
		gbc_userNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNameTextField.gridx = 1;
		gbc_userNameTextField.gridy = 0;
		getContentPane().add(userNameTextField, gbc_userNameTextField);
		userNameTextField.setColumns(10);

		passwordLabel = new JLabel("Password:");
		gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.EAST;
		gbc_passwordLabel.insets = new Insets(5, 5, 0, 5);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 1;
		getContentPane().add(passwordLabel, gbc_passwordLabel);

		passwordField = new JPasswordField();
		gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(5, 5, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 1;
		getContentPane().add(passwordField, gbc_passwordField);

		addUserButton = new JButton("Add");
		gbc_addUserButton = new GridBagConstraints();
		gbc_addUserButton.gridx = 2;
		gbc_addUserButton.gridy = 1;
		getContentPane().add(addUserButton, gbc_addUserButton);

		this.getRootPane().setDefaultButton(addUserButton);
	}

	public void showScreen()
	{
		this.setVisible(true);
	}

	public JButton getAddUserButton()
	{
		return addUserButton;
	}

	public String getUserName()
	{
		return userNameTextField.getText();
	}

	public String getPassword()
	{
		String result = new String(passwordField.getPassword());
		return result;
	}

}
