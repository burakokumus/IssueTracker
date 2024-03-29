package com.ekinoks.issuetracker.view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

// https://stackoverflow.com/questions/27815400/retrieving-data-from-jdbc-database-into-jtable

public class View
{
	private String currentUserName;

	public JFrame frame;
	public JDialog addIssueDialog;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private JPanel panel;
	private JButton addIssueButton;
	private JButton addUserButton;

	public View()
	{
		this.currentUserName = "";
		initialize();
	}

	public void showScreen()
	{
		frame.setVisible(true);
	}

	private void initialize()
	{
		frame = new JFrame(Messages.getString("mainFrameTitle"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]
		{ 0, 0 };
		gridBagLayout.rowHeights = new int[]
		{ 36, 0, 0 };
		gridBagLayout.columnWeights = new double[]
		{ 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[]
		{ 0.0, 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 5, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);

		addUserButton = new JButton("Add User");
		panel.add(addUserButton);

		addIssueButton = new JButton("Add Issue");
		panel.add(addIssueButton);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);

//		table = new Listtab
		table = new JTable();
		defaultTableModel = new DefaultTableModel(new String[]
		{ "Issue Id", "Title", "Type", "Priority", "Author", "Description", "State" }, 0);
		table.setModel(defaultTableModel);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, centerRenderer);

		// Make table not editable
		JTextField tf = new JTextField();
		tf.setEditable(false);
		DefaultCellEditor editor = new DefaultCellEditor(tf);
		table.setDefaultEditor(Object.class, editor);

		scrollPane.setViewportView(table);

		frame.pack();
	}

	public JButton getAddIssueButton()
	{
		return addIssueButton;
	}

	public JButton getAddUserButton()
	{
		return addUserButton;
	}

	public DefaultTableModel getDefaultTableModel()
	{
		return defaultTableModel;
	}

	public void setCurrentUserName(String userName)
	{
		this.currentUserName = userName;
	}

	public String getCurrentUserName()
	{
		return this.currentUserName;
	}

	public JTable getTable()
	{
		return table;
	}

	public void addIssueToJTable(int issueID, String title, String type, int priority, String author,
			String description, String state)
	{
		defaultTableModel.addRow(new String[]
		{ Integer.toString(issueID), title, type, Integer.toString(priority), author, description, state });
	}
}
