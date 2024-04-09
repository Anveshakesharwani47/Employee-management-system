package employee.management.system;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.JFrame;

public class DeleteEmployee extends JFrame implements ActionListener{
	Choice choiceEmpid;
	JButton delete,back;
	DeleteEmployee()
	{
		setTitle("DELETE EMPLOYEE");
		
		JLabel label=new JLabel("Employee ID");
		label.setFont(new Font("Tahoma",Font.BOLD,15));
		label.setBounds(50,50,100,30);
		add(label);
		
		choiceEmpid=new Choice();
		choiceEmpid.setBounds(200,50,150,30);
		add(choiceEmpid);
		
		try{
			connect c=new connect();
			ResultSet resultSet=c.statement.executeQuery("select * from employees");
			while(resultSet.next())
			{
				choiceEmpid.add(resultSet.getString("empid"));	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		JLabel labelname=new JLabel("Name");
		labelname.setFont(new Font("Tahoma",Font.BOLD,15));
		labelname.setBounds(50,100,100,30);
		add(labelname);
		
		final JLabel tname=new JLabel();
		tname.setFont(new Font("Tahoma",Font.BOLD,15));
		tname.setBounds(200,100,150,30);
		add(tname);
		
		JLabel labelphone=new JLabel("Phone no.");
		labelphone.setFont(new Font("Tahoma",Font.BOLD,15));
		labelphone.setBounds(50,150,100,30);
		add(labelphone);
		
		final JLabel tphone=new JLabel();
		tphone.setFont(new Font("Tahoma",Font.BOLD,15));
		tphone.setBounds(200,150,100,30);
		add(tphone);
		
		JLabel labelemail=new JLabel("Email");
		labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
		labelemail.setBounds(50,200,100,30);
		add(labelemail);
		
		final JLabel temail=new JLabel();
		temail.setFont(new Font("Tahoma",Font.BOLD,15));
		temail.setBounds(200,200,200,30);
		add(temail);
		
		try{
			connect c=new connect();
			ResultSet resultSet=c.statement.executeQuery("select * from employees where empid = '"+choiceEmpid.getSelectedItem()+"'");
			while(resultSet.next())
			{
				tname.setText(resultSet.getString("name"));
				tphone.setText(resultSet.getString("phone"));
				temail.setText(resultSet.getString("email"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		choiceEmpid.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				try{
					connect c=new connect();
					ResultSet resultSet=c.statement.executeQuery("select * from employees where empid = '"+choiceEmpid.getSelectedItem()+"'");
					while(resultSet.next())
					{
						tname.setText(resultSet.getString("name"));
						tphone.setText(resultSet.getString("phone"));
						temail.setText(resultSet.getString("email"));
					}
				}
				catch(Exception E){E.printStackTrace();}
			}
		});
		
		delete=new JButton("DELETE");
		delete.setBounds(80,300,100,30);
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.RED);
		delete.addActionListener(this);
		add(delete);
		
		back=new JButton("BACK");
		back.setBounds(220,300,100,30);
	    back.setBackground(Color.BLACK);
		back.setForeground(Color.RED);
		back.addActionListener(this);
		add(back);
		
		getContentPane().setBackground(new Color(211,235,212));
		setSize(500,400);
		setLocation(300,150);
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==delete)
		{
			try{
				connect c=new connect();
				String query="delete from employees where empid='"+choiceEmpid.getSelectedItem()+"'";
			    c.statement.executeUpdate(query);
			    JOptionPane.showMessageDialog(null,"Employee detail successfully deleted");
			    setVisible(false);
			    new Home();
			}catch(Exception E){
				E.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
			new Home();
		}
	}
		
   public static void main(String[] args)
   {
	   new DeleteEmployee();
   }
}
