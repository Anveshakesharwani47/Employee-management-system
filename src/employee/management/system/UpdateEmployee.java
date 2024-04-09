package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;

public class UpdateEmployee extends JFrame implements ActionListener{
	JTextField txtaddress,txtphone,txtadhar,txtemail,txtsalary,txtdesignation;
    JLabel tempid;
	JButton add,back;
	String number;
	UpdateEmployee(String number)
	{
		setTitle("UPDATE EMPLOYEE");
		this.number=number;
		JLabel labelhead=new JLabel("Update employee details");
		labelhead.setForeground(Color.WHITE);
		labelhead.setFont(new Font("Raleway",Font.BOLD,20));
		labelhead.setBounds(320,30,500,50);
		add(labelhead);
		
		JLabel name=new JLabel("Name");
		name.setBounds(50,150,150,30);
		name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(name);
	
		JLabel txtname=new JLabel();
		txtname.setBounds(200,150,150,30);
		add(txtname);
		
	    JLabel fname=new JLabel("Fathers's Name");
		fname.setBounds(400,150,150,30);
		fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(fname);
	
		JLabel txtfname=new JLabel();
		txtfname.setBounds(600,150,150,30);
		add(txtfname);
		
		JLabel dob=new JLabel("DOB");
		dob.setBounds(50,200,150,30);
		dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(dob);
	
		JLabel tdob=new JLabel();
		tdob.setBounds(200,200,150,30);
		add(tdob);
		
		JLabel educ=new JLabel("Education");
		educ.setBounds(400,200,150,30);
		educ.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(educ);
		
		JLabel txteduc=new JLabel();
		txteduc.setBounds(600,200,150,30);
		add(txteduc);
			
		JLabel  addr=new JLabel("Address");
		addr.setBounds(50,250,150,30);
		addr.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(addr);
	
		txtaddress=new JTextField();
		txtaddress.setBounds(200,250,150,30);
		add(txtaddress);
		
		JLabel adhar=new JLabel("Adhar no.");
		 adhar.setBounds(400,250,150,30);
		 adhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(adhar);
	
		JLabel txtadhar=new JLabel();
		txtadhar.setBounds(600,250,150,30);
		add(txtadhar);
		
		JLabel phone=new JLabel("Phone no.");
		phone.setBounds(50,300,150,30);
		phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(phone);
	
		txtphone=new JTextField();
		txtphone.setBounds(200,300,150,30);
		add(txtphone);
		
		JLabel email=new JLabel("Email id");
		email.setBounds(400,300,150,30);
		email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(email);
		
		txtemail=new JTextField();
		txtemail.setBounds(600,300,150,30);
		add(txtemail);
		
		JLabel salary=new JLabel("Salary");
		salary.setBounds(50,350,150,30);
	    salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(salary);
	
		txtsalary=new JTextField();
		txtsalary.setBounds(200,350,150,30);
		add(txtsalary);
		
		JLabel desg=new JLabel("Designation");
		desg.setBounds(400,350,150,30);
		desg.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(desg);
	
		txtdesignation=new JTextField();
		txtdesignation.setBounds(600,350,150,30);
		add(txtdesignation);
		
		JLabel empid=new JLabel("Employee ID");
		empid.setBounds(50,400,150,30);
		empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(empid);
	
		tempid=new JLabel();
		tempid.setBounds(200,400,150,30);
		tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		tempid.setForeground(Color.RED);
		add(tempid);
		
		try{
			connect c=new connect();
			String query="select * from employees where empid='"+number+"'";
			ResultSet resultSet=c.statement.executeQuery(query);
			while(resultSet.next())
			{
				txtname.setText(resultSet.getString("name"));
				txtfname.setText(resultSet.getString("father_name"));
				tdob.setText(resultSet.getString("dob"));
				txteduc.setText(resultSet.getString("education"));
				txtaddress.setText(resultSet.getString("address"));
				txtadhar.setText(resultSet.getString("aadhar"));
				txtphone.setText(resultSet.getString("phone"));
				txtemail.setText(resultSet.getString("email"));
				txtsalary.setText(resultSet.getString("salary"));
				txtdesignation.setText(resultSet.getString("designation"));
				tempid.setText(resultSet.getString("empid"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		add=new JButton("UPDATE");
		add.setBounds(450,550,150,40);
	    add.setBackground(Color.BLACK);
		add.setForeground(Color.RED);
		add.addActionListener(this);
		add(add);
		
		back=new JButton("BACK");
		back.setBounds(250,550,150,40);
	    back.setBackground(Color.BLACK);
		back.setForeground(Color.RED);
		back.addActionListener(this);
		add(back);
		
		getContentPane().setBackground(new Color(143, 198, 235));
		setSize(900,700);
		setLocation(300,50);
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==add)
		{
			
			String address=txtaddress.getText();
			String phone=txtphone.getText();
			String email=txtemail.getText();
			String salary=txtsalary.getText();
			String desg=txtdesignation.getText();
			
			try{
				connect c=new connect();
				String query="update employees set address='"+address+"',phone='"+phone+"',email='"+email+"',salary='"+salary+"',designation='"+desg+"' where empid='"+number+"'";
			    c.statement.executeUpdate(query);
			    JOptionPane.showMessageDialog(null,"Employee details are successfully updated");
			    setVisible(false);
			   new Home();
			}catch(Exception E){
				E.printStackTrace();
			}
		}
		else 
		{	
				setVisible(false);
			    new ShowEmployee(); 
		}
		
	 }
	
	public static void main(String[] args)
	{
		new UpdateEmployee("");
	}
}
