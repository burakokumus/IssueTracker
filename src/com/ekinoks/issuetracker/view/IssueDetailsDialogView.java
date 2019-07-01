package com.ekinoks.issuetracker.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class IssueDetailsDialogView extends JDialog
{
	private JLabel issueIDLabel;
	private JLabel descriptionLabel;
	private JLabel issueTitleLabel;
	private JLabel authorLabel;
	private JLabel typeLabel;
	private JLabel currentAssigneeLabel;

	public IssueDetailsDialogView()
	{
		this.setTitle("Issue Details");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel descriptionTitleLabel = new JLabel("Description");
		descriptionTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_descriptionTitleLabel = new GridBagConstraints();
		gbc_descriptionTitleLabel.gridheight = 2;
		gbc_descriptionTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descriptionTitleLabel.gridx = 1;
		gbc_descriptionTitleLabel.gridy = 1;
		getContentPane().add(descriptionTitleLabel, gbc_descriptionTitleLabel);

		JLabel issueIDTitleLabel = new JLabel("issue ID: ");
		GridBagConstraints gbc_issueIDTitleLabel = new GridBagConstraints();
		gbc_issueIDTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_issueIDTitleLabel.fill = GridBagConstraints.VERTICAL;
		gbc_issueIDTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_issueIDTitleLabel.gridx = 11;
		gbc_issueIDTitleLabel.gridy = 2;
		getContentPane().add(issueIDTitleLabel, gbc_issueIDTitleLabel);

		issueIDLabel = new JLabel("12");
		GridBagConstraints gbc_issueIDLabel = new GridBagConstraints();
		gbc_issueIDLabel.fill = GridBagConstraints.VERTICAL;
		gbc_issueIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_issueIDLabel.gridx = 12;
		gbc_issueIDLabel.gridy = 2;
		getContentPane().add(issueIDLabel, gbc_issueIDLabel);

		descriptionLabel = new JLabel("New label");
		GridBagConstraints gbc_descriptionLabel = new GridBagConstraints();
		gbc_descriptionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descriptionLabel.gridx = 1;
		gbc_descriptionLabel.gridy = 3;
		getContentPane().add(descriptionLabel, gbc_descriptionLabel);

		JLabel issueTitleTitleLabel = new JLabel("Title: ");
		GridBagConstraints gbc_issueTitleTitleLabel = new GridBagConstraints();
		gbc_issueTitleTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_issueTitleTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_issueTitleTitleLabel.gridx = 11;
		gbc_issueTitleTitleLabel.gridy = 3;
		getContentPane().add(issueTitleTitleLabel, gbc_issueTitleTitleLabel);

		issueTitleLabel = new JLabel("New label");
		GridBagConstraints gbc_issueTitleLabel = new GridBagConstraints();
		gbc_issueTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_issueTitleLabel.gridx = 12;
		gbc_issueTitleLabel.gridy = 3;
		getContentPane().add(issueTitleLabel, gbc_issueTitleLabel);

		JLabel authorTitleLabel = new JLabel("Author: ");
		GridBagConstraints gbc_authorTitleLabel = new GridBagConstraints();
		gbc_authorTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_authorTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_authorTitleLabel.gridx = 11;
		gbc_authorTitleLabel.gridy = 4;
		getContentPane().add(authorTitleLabel, gbc_authorTitleLabel);

		authorLabel = new JLabel("New label");
		GridBagConstraints gbc_authorLabel = new GridBagConstraints();
		gbc_authorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_authorLabel.gridx = 12;
		gbc_authorLabel.gridy = 4;
		getContentPane().add(authorLabel, gbc_authorLabel);

		JLabel typeTitleLabel = new JLabel("Type: ");
		GridBagConstraints gbc_typeTitleLabel = new GridBagConstraints();
		gbc_typeTitleLabel.anchor = GridBagConstraints.EAST;
		gbc_typeTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_typeTitleLabel.gridx = 11;
		gbc_typeTitleLabel.gridy = 5;
		getContentPane().add(typeTitleLabel, gbc_typeTitleLabel);

		typeLabel = new JLabel("New label");
		GridBagConstraints gbc_typeLabel = new GridBagConstraints();
		gbc_typeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_typeLabel.gridx = 12;
		gbc_typeLabel.gridy = 5;
		getContentPane().add(typeLabel, gbc_typeLabel);

		JLabel currentAssigneeTitleLabel = new JLabel("Current Assignee(s)");
		GridBagConstraints gbc_currentAssigneeTitleLabel = new GridBagConstraints();
		gbc_currentAssigneeTitleLabel.insets = new Insets(0, 0, 0, 5);
		gbc_currentAssigneeTitleLabel.gridx = 11;
		gbc_currentAssigneeTitleLabel.gridy = 6;
		getContentPane().add(currentAssigneeTitleLabel, gbc_currentAssigneeTitleLabel);

		currentAssigneeLabel = new JLabel("New label");
		GridBagConstraints gbc_currentAssigneeLabel = new GridBagConstraints();
		gbc_currentAssigneeLabel.insets = new Insets(0, 0, 0, 5);
		gbc_currentAssigneeLabel.gridx = 12;
		gbc_currentAssigneeLabel.gridy = 6;
		getContentPane().add(currentAssigneeLabel, gbc_currentAssigneeLabel);
	}

	public void setIssueID(int newID)
	{
		this.issueIDLabel.setText(Integer.toString(newID));
	}

	public void setIssueTitle(String newTitle)
	{
		this.issueTitleLabel.setText(newTitle);
	}

	public void setIssueDescription(String newDescription)
	{
		this.descriptionLabel.setText(newDescription);
	}

	public void setIssueAuthor(String newAuthor)
	{
		this.authorLabel.setText(newAuthor);
	}

	public void setIssueType(String newType)
	{
		this.typeLabel.setText(newType);
	}

	public void SetIssueAssignees(ArrayList<String> assignees)
	{
		String result = "";
		for (String assignee : assignees)
		{
			result = result + assignee + "\n";
		}
		this.currentAssigneeLabel.setText(result);
	}

}
