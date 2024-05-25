package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

@SuppressWarnings("serial")
public class Withdrawl extends JFrame implements ActionListener 
{
	JTextField amount;
	JLabel image,text;
	JButton withdrawl,back;
	String cardnumber;
  public Withdrawl(String cardnumber)
  {
	    this.cardnumber=cardnumber;
	    setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(750, 850, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(0, 0, 750, 800);
		add(image); 
		
		text=new JLabel("Enter The Amount You Want To Withdrawl");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Times New Roman",Font.BOLD,13));
		text.setBounds(175,280,300,40);
		image.add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,15));
		amount.setBounds(135,330,290,30);
		image.add(amount);
		
		withdrawl=new JButton("Withdrawl");
		withdrawl.setFont(new Font("Times New Roman",Font.BOLD,15));
		withdrawl.setBounds(283,432,150,25);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		back=new JButton("Back");
		back.setFont(new Font("Times New Roman",Font.BOLD,15));
		back.setBounds(283,464,150,25);
		back.addActionListener(this);
		image.add(back);
		
		setSize(750,800);
		setLocation(400,0);
		setVisible(true);
  }
  @Override
  public void actionPerformed(ActionEvent e) {
  	if(e.getSource()==back)
  	{
  		this.setVisible(false);
		new Transactions(cardnumber);
  	}
  	else if(e.getSource()==withdrawl)
  	{
  		String withdrawlAmt=amount.getText();
  		if(withdrawlAmt.equals(""))
  		{
  			JOptionPane.showMessageDialog(null,"Please Enter A Amount To Withdrawl");
  		}
  		try
  		{
  		Connect con=new Connect();
		String query="SELECT * FROM BANK WHERE AccountNumber='"+cardnumber+"'";
		ResultSet rs=con.stm.executeQuery(query);
		int balance=0;
		while(rs.next())
		{
			if(rs.getString("type").equals("Deposit"))
			{
				balance += Integer.parseInt(rs.getString("amount"));
			}
			else
			{
				balance -= Integer.parseInt(rs.getString("amount"));
			}
		}
		if(Integer.parseInt(withdrawlAmt) > balance)
		{
			JOptionPane.showMessageDialog(null,"Insificient Balance");
			setVisible(false);
			new Transactions(cardnumber).setVisible(true);
		}
		else if(Integer.parseInt(withdrawlAmt) < 0)
		{
			JOptionPane.showMessageDialog(null,"Enter Positive Number");
			setVisible(false);
			new Transactions(cardnumber).setVisible(true);
		}
		else
		{
		  Date date=new Date();
		  String insertquery = "INSERT INTO BANK VALUES('"+cardnumber+"','"+date+"','Withdrawl','"+withdrawlAmt+"')";
		  con.stm.executeUpdate(insertquery);
		  JOptionPane.showMessageDialog(null,"Rs "+withdrawlAmt+" Withdrawl Successfully");

		  setVisible(false);
		  new Transactions(cardnumber).setVisible(true);
		}
  		}
  		catch(Exception ex)
  		{
  			System.out.println(ex);
  		}
  	}
  }
  public static void main(String arg[])
  {
	  new Withdrawl("");
  }
}
