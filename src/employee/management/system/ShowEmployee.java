package employee.management.system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class ShowEmployee extends JFrame implements ActionListener {

	JTable table;
	JButton tosearch,print,update,back;
	Choice choiceEmp;
	ShowEmployee()
	{
		setTitle("SHOW EMPLOYEE");
		
		JLabel search=new JLabel("Search by employee id");
		search.setBounds(20,20,150,20);
		add(search);
		
		choiceEmp =new Choice();
		choiceEmp.setBounds(180,20,150,20);
		add(choiceEmp);
		
		try{
			connect c=new connect();
			ResultSet result=c.statement.executeQuery("select * from employees");
			while(result.next())
			{
				choiceEmp.add(result.getString("empid"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		table=new JTable();
		try{
			connect co=new connect();
			ResultSet resultSet=co.statement.executeQuery("select * from employees");
			table.setModel(DbUtils.resultSetToTableModel(resultSet));
		}catch(Exception E){
			E.printStackTrace();
		}
		
		JScrollPane jscp=new JScrollPane(table);
		jscp.setBounds(0,100,900,600);
		add(jscp);
		
		tosearch=new JButton("Search");
		tosearch.setBounds(20,70,80,20);
		tosearch.setForeground(Color.green);
	    tosearch.setBackground(Color.BLACK);
	    tosearch.addActionListener(this);
		add(tosearch);
		
		print=new JButton("Print");
		print.setBounds(120,70,80,20);
		print.setForeground(Color.cyan);
	    print.setBackground(Color.BLACK);
	    print.addActionListener(this);
		add(print);
		
		update=new JButton("Update");
		update.setBounds(220,70,80,20);
		update.setForeground(Color.magenta);
	    update.setBackground(Color.BLACK);
	    update.addActionListener(this);
		add(update);
		
		back=new JButton("Back");
		back.setBounds(320,70,80,20);
		back.setForeground(Color.pink);
	    back.setBackground(Color.BLACK);
	    back.addActionListener(this);
		add(back);
		
		getContentPane().setBackground(new Color(166, 222, 224));
		setSize(900,700);
		setLocation(300,100);
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==tosearch)
		{
			String query="select * from employees where empId='"+choiceEmp.getSelectedItem()+"'";
			try{
				connect c=new connect();
				ResultSet resultSet=c.statement.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(resultSet));
			}catch(Exception E){
				E.printStackTrace();
			}
		}
		else if(e.getSource()==print)
		{
			try{
				table.print();
			}catch(Exception E){
				E.printStackTrace();
			}
		}
		else if(e.getSource()==update)
		{
			setVisible(false);
			new UpdateEmployee(choiceEmp.getSelectedItem());	
		}
		else 
		{
		       setVisible(false);
			   new Home();
		}
	 }
	public static void main(String[] args)
			{
		new ShowEmployee();
			}
}
