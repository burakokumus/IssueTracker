package view;

import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class AddIssueDialogView extends JDialog
{
	private JTextField textField;

	public AddIssueDialogView()
	{
		setMinimumSize(new Dimension(500, 500));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 0, 0, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 0, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel issueNameLabel = new JLabel(Messages.getString("AddIssueDialog.lblIssueName.text")); //$NON-NLS-1$
		GridBagConstraints gbc_issueNameLabel = new GridBagConstraints();
		gbc_issueNameLabel.anchor = GridBagConstraints.EAST;
		gbc_issueNameLabel.insets = new Insets(5, 5, 0, 5);
		gbc_issueNameLabel.gridx = 0;
		gbc_issueNameLabel.gridy = 0;
		getContentPane().add(issueNameLabel, gbc_issueNameLabel);

		textField = new JTextField();
		textField.setText(Messages.getString("AddIssueDialog.textField.text")); //$NON-NLS-1$
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(5, 5, 0, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		this.pack();
	}

}
