package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class BalanceEnquiry extends JFrame implements ActionListener
{
	String cardnumber;
	JLabel image,text;
	JButton back;
	public BalanceEnquiry(String cardnumber)
	{
		this.cardnumber=cardnumber;
	    setLayout(null);
	
	    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
	    Image i2=i1.getImage().getScaledInstance(750, 850, Image.SCALE_DEFAULT);
	    ImageIcon i3=new ImageIcon(i2);
	    image=new JLabel(i3);
	    image.setBounds(0, 0, 750, 800);
	    add(image);
	    
	    back=new JButton("Back");
		back.setFont(new Font("Times New Roman",Font.BOLD,15));
		back.setBounds(280,464,150,30);
		back.addActionListener(this);
		image.add(back);
		
		int balance=0;
		try
		{
			Connect con=new Connect();
			String query="SELECT * FROM BANK WHERE AccountNumber='"+cardnumber+"'";
			ResultSet rs=con.stm.executeQuery(query);
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
		}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		text=new JLabel("Current Account Balance Is Rs: "+balance);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway",Font.BOLD,14));
		text.setBounds(130,255,300,40);
		image.add(text);
		
		
	    setSize(750,800);
		setLocation(400,0);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==back)
		{
			setVisible(false);
			new Transactions(cardnumber).setVisible(true);
		}
		
	}
	public static void main(String arg[])
	{
		new BalanceEnquiry("");
	}
}
