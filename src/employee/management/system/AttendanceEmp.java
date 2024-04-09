package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AttendanceEmp extends JFrame implements ActionListener{
	Choice choiceEmpid;
	JLabel tname,tphone,tfirsthalf,tsecondhalf;
	JDateChooser tdate;
	JButton submit,back;
	JComboBox Boxfirsthalf,Boxsecondhalf;
	String number;
	AttendanceEmp()
   {
	setTitle("TAKING ATTENDANCE");
	JLabel jlabel=new JLabel("Employee ID");
	jlabel.setFont(new Font("Tahoma",Font.BOLD,15));
	jlabel.setBounds(50,50,100,30);
	add(jlabel);
	
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
	
	tname=new JLabel();
	tname.setFont(new Font("Tahoma",Font.BOLD,15));
	tname.setBounds(200,100,100,30);
	add(tname);
	
	JLabel labelphone=new JLabel("Phone no.");
	labelphone.setFont(new Font("Tahoma",Font.BOLD,15));
	labelphone.setBounds(50,150,100,30);
	add(labelphone);
	
	tphone=new JLabel();
	tphone.setFont(new Font("Tahoma",Font.BOLD,15));
	tphone.setBounds(200,150,100,30);
	add(tphone);
	
	JLabel date=new JLabel("Date");
	date.setBounds(50,200,100,30);
	date.setFont(new Font("SAN_SERIF",Font.BOLD,15));
	add(date);

	tdate=new JDateChooser();
	tdate.setBounds(200,200,100,30);
	tdate.setBackground(new Color(177,252,197));
	add(tdate);
	
	try{
		connect c=new connect();
		ResultSet resultSet=c.statement.executeQuery("select * from employees where empid = '"+choiceEmpid.getSelectedItem()+"'");
		while(resultSet.next())
		{
			tname.setText(resultSet.getString("name"));
			tphone.setText(resultSet.getString("phone"));
		
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
				
				
				}
			}
			catch(Exception E){E.printStackTrace();}
		}
	});
	
	JLabel tfirsthalf=new JLabel("First Half");
	tfirsthalf.setFont(new Font("Tahoma",Font.BOLD,15));
	tfirsthalf.setBounds(50,250,100,30);
	add(tfirsthalf);
	
	String items[]={"Present","Absent"};
	Boxfirsthalf =new JComboBox(items);
	Boxfirsthalf.setBounds(200,250,100,30);
	add(Boxfirsthalf);
	
	JLabel tsecondhalf=new JLabel("Second Half");
	tsecondhalf.setFont(new Font("Tahoma",Font.BOLD,15));
	tsecondhalf.setBounds(50,300,100,30);
	add(tsecondhalf);
	
	String itemss[]={"Present","Absent"};
	Boxsecondhalf =new JComboBox(items);
	Boxsecondhalf.setBounds(200,300,100,30);
	add(Boxsecondhalf);
	
	submit=new JButton("SUBMIT");
    submit.setBounds(150,400,100,30);
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.RED);
    submit.addActionListener(this);
	add(submit);
		
	back=new JButton("BACK");
	back.setBounds(300,400,100,30);
	back.setBackground(Color.BLACK);
	back.setForeground(Color.RED);
	back.addActionListener(this);
	add(back);  
		
	getContentPane().setBackground(new Color(192, 181, 232));
	setSize(600,500);
	setLocation(300,150);
	setLayout(null);
	setVisible(true);}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==submit)
		{
			String empid=(String)choiceEmpid.getSelectedItem();
			String name=tname.getText();			
			String phone=tphone.getText();
			String date=((JTextField)tdate.getDateEditor().getUiComponent()).getText();
			String firsthalf=(String)Boxfirsthalf.getSelectedItem();
			String secondhalf=(String)Boxsecondhalf.getSelectedItem();
			
			try{
			connect c=new connect();
			String query="insert into attendance values('"+empid+"','"+name+"','"+phone+"','"+date+"','"+firsthalf+"','"+secondhalf+"')";
			   c.statement.executeUpdate(query);
			   JOptionPane.showMessageDialog(null,"Employee attendance successfully added");
				setVisible(false);
				new Attendance();
			  
			}catch(Exception E){
				E.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
			new Attendance();
		}
	}
	public static void main (String args[])
	{
		new AttendanceEmp();
	}

}
