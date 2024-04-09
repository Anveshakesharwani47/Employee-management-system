package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{
	JTextField txtname,txtfname,txtdob,txtaddress,txtphone,txtadhar,txtemail,txtsalary,txtdesignation;
	JDateChooser tdob;
	JLabel tempid;
	JButton add,back;
	JComboBox Boxeducation;
	Random rand=new Random();
	int number= rand.nextInt(999999);
	AddEmployee()
	{
		setTitle("ADD EMPLOYEE");

		JLabel labelhead=new JLabel("Add employee details");
		labelhead.setForeground(Color.WHITE);
		labelhead.setFont(new Font("Raleway",Font.BOLD,20));
		labelhead.setBounds(320,30,500,50);
		add(labelhead);
		
		JLabel name=new JLabel("Name");
		name.setBounds(50,150,150,30);
		name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(name);
	
		txtname=new JTextField();
		txtname.setBounds(200,150,150,30);
		add(txtname);
		
    	JLabel fname=new JLabel("Fathers's Name");
		fname.setBounds(400,150,150,30);
		fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(fname);
	
		txtfname=new JTextField();
		txtfname.setBounds(600,150,150,30);
		add(txtfname);
		
		JLabel dob=new JLabel("DOB");
		dob.setBounds(50,200,150,30);
		dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(dob);
	
		tdob=new JDateChooser();
		tdob.setBounds(200,200,150,30);
		tdob.setBackground(new Color(177,252,197));
		add(tdob);
				
		
		
		JLabel educ=new JLabel("Education");
		educ.setBounds(400,200,150,30);
		educ.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		add(educ);
		
		String items[]={"BA","BSc","B.Tech","BBA","B.COM","BCA","M.Tech","MBA","MCA","MA","Msc","Phd","Other"};
		Boxeducation =new JComboBox(items);
		Boxeducation.setBackground(new Color(177,252,197));
		Boxeducation.setBounds(600,200,150,30);
		add(Boxeducation);
		
			
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
	
		txtadhar=new JTextField();
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
	
		tempid=new JLabel(""+number);
		tempid.setBounds(200,400,150,30);
		tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
		tempid.setForeground(Color.RED);
		add(tempid);
		
		add=new JButton("ADD");
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
			    String name=txtname.getText();
			    String fname=txtfname.getText();
				String dob=((JTextField)tdob.getDateEditor().getUiComponent()).getText();
				String education=(String)Boxeducation.getSelectedItem();
				String address=txtaddress.getText();
				String adhar=txtadhar.getText();
				String phone=txtphone.getText();
				String email=txtemail.getText();
				String salary=txtsalary.getText();
				String desg=txtdesignation.getText();
				String empID=tempid.getText();

				try{
				connect co=new connect();
				String query="insert into employees values('"+name+"','"+fname+"','"+dob+"','"+education+"','"+address+"','"+adhar+"','"+phone+"','"+email+"','"+salary+"','"+desg+"','"+empID+"')";
				co.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Employee details are successfully added");
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
		new AddEmployee();	
	}
}
