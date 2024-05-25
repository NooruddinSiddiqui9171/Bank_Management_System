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
import java.util.Date;

@SuppressWarnings("serial")
public class Deposit extends JFrame implements ActionListener 
{
	JTextField amount;
	JLabel image,text;
	JButton deposit,back;
	String cardnumber;
  public Deposit(String cardnumber)
  {
	    this.cardnumber=cardnumber;
	    setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(750, 850, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(0, 0, 750, 800);
		add(image); 
		
		text=new JLabel("Enter The Amount You Want To Deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Times New Roman",Font.BOLD,13));
		text.setBounds(175,280,300,40);
		image.add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,15));
		amount.setBounds(135,330,290,30);
		image.add(amount);
		
		deposit=new JButton("Deposit");
		deposit.setFont(new Font("Times New Roman",Font.BOLD,15));
		deposit.setBounds(283,432,150,25);
		deposit.addActionListener(this);
		image.add(deposit);
		
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
  	else if(e.getSource()==deposit)
  	{
  		String depositAmt=amount.getText();
  		if(depositAmt.equals(""))
  		{
  			JOptionPane.showMessageDialog(null,"Please Enter a Amount To Deposit");
  		}
  		else if (!depositAmt.matches("\\d+")) {
  		    JOptionPane.showMessageDialog(null, "Please enter a valid positive number for deposit");
  		}
  		else 
  		{
  			try 
  			{
  			  Connect con=new Connect();
  			  Date date=new Date();
  			  String query = "INSERT INTO BANK VALUES('"+cardnumber+"','"+date+"','Deposit','"+depositAmt+"')";
  			  con.stm.executeUpdate(query);
  			  JOptionPane.showMessageDialog(null,"Rs "+depositAmt+" Deposited Successfully");
  
  			  setVisible(false);
  			  new Transactions(cardnumber).setVisible(true);
  			}
  			catch(Exception ex)
  			{
  				System.out.println(ex);
  			}
  		}
  	}
  }
  public static void main(String arg[])
  {
	  new Deposit("");
  }
}
