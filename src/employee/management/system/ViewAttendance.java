package employee.management.system;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class ViewAttendance extends JFrame implements ActionListener{
	JTable table;
	JButton tosearch,print,update,back;
	Choice choiceEmp;
	ViewAttendance()
	{
		setTitle("VIEW ATTENDANCE");
		
		JLabel label=new JLabel("Employee ID");
		label.setFont(new Font("Tahoma",Font.BOLD,15));
		label.setBounds(50,20,100,30);
		add(label); 
		
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
			ResultSet resultSet=co.statement.executeQuery("select * from attendance");
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
		
		back=new JButton("Back");
		back.setBounds(220,70,80,20);
		back.setForeground(Color.pink);
	    back.setBackground(Color.BLACK);
	    back.addActionListener(this);
		add(back);
		
		getContentPane().setBackground(new Color(235, 226, 176));
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
			String query="select * from attendance where empId='"+choiceEmp.getSelectedItem()+"'";
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
		else 
		{
				setVisible(false);
			   new Attendance(); 
		}
	}

	public static void main(String args[])
	{
		new ViewAttendance();
	}
}
