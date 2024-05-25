package bank.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Transactions extends JFrame implements ActionListener
{
	JLabel text,image;
	JButton deposit,fast_cash,pin_change,withdrawl,ministm,balance,exit;
	String cardnumber;
	public Transactions(String cardnumber)
	{   
		this.cardnumber=cardnumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(750, 850, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(0, 0, 750, 800);
		add(image);
		
		text=new JLabel("Please Select Your Transaction");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Times New Roman",Font.BOLD,13));
		text.setBounds(190,280,300,40);
		image.add(text);
		
		deposit=new JButton("Deposit");
		deposit.setFont(new Font("Times New Roman",Font.BOLD,15));
		deposit.setBounds(128,368,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		fast_cash=new JButton("Fast Cash");
		fast_cash.setFont(new Font("Times New Roman",Font.BOLD,15));
		fast_cash.setBounds(128,400,150,30);
		fast_cash.addActionListener(this);
		image.add(fast_cash);
		
		pin_change=new JButton("Pin Change");
		pin_change.setFont(new Font("Times New Roman",Font.BOLD,15));
		pin_change.setBounds(128,432,150,30);
		pin_change.addActionListener(this);
		image.add(pin_change);
		
		withdrawl=new JButton("Cash Withdrawl");
		withdrawl.setFont(new Font("Times New Roman",Font.BOLD,15));
		withdrawl.setBounds(283,368,150,30);
        withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		ministm=new JButton("Mini Statement");
		ministm.setFont(new Font("Times New Roman",Font.BOLD,15));
		ministm.setBounds(283,400,150,30);
		ministm.addActionListener(this);
		image.add(ministm);
		
		balance=new JButton("Balance");
		balance.setFont(new Font("Times New Roman",Font.BOLD,15));
		balance.setBounds(283,432,150,30);
		balance.addActionListener(this);
		image.add(balance);
		
		exit=new JButton("Exit");
		exit.setFont(new Font("Times New Roman",Font.BOLD,15));
		exit.setBounds(283,464,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(750,800);
		setLocation(400,0);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit)
		{
			System.exit(0);
		}
		else if(e.getSource()==deposit)
		{
		    this.setVisible(false);
			new Deposit(cardnumber).setVisible(true);
		}
		else if(e.getSource()==withdrawl)
		{
			this.setVisible(false);
			new Withdrawl(cardnumber).setVisible(true);
		}
		else if(e.getSource()==fast_cash)
		{
			this.setVisible(false);
			new FastCash(cardnumber).setVisible(true);
		}
		else if(e.getSource()==pin_change)
		{
			this.setVisible(false);
			new PinChange(cardnumber).setVisible(true);
		}
		else if(e.getSource()==balance)
		{
			this.setVisible(false);
			new BalanceEnquiry(cardnumber).setVisible(true);
		}
		else if(e.getSource()==ministm)
		{
			new MiniStatement(cardnumber).setVisible(true);
		}
	}
  public static void main(String arg[])
  {
	new Transactions("");  
  }
}
