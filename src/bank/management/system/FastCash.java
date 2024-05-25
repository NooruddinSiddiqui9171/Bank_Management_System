package bank.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

@SuppressWarnings("serial")
public class FastCash extends JFrame implements ActionListener
{
	JLabel text,image;
	JButton oneTho,twoTho,fiveTho,sixTho,eightTho,tenTho,back;
	String cardnumber;
	public FastCash(String cardnumber)
	{   
		this.cardnumber=cardnumber;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(750, 850, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		image=new JLabel(i3);
		image.setBounds(0, 0, 750, 800);
		add(image);
		
		text=new JLabel("Select Withdrawl Amount");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Times New Roman",Font.BOLD,16));
		text.setBounds(190,280,300,40);
		image.add(text);
		
		oneTho=new JButton("Rs 1000");
		oneTho.setFont(new Font("Times New Roman",Font.BOLD,15));
		oneTho.setBounds(128,368,150,30);
		oneTho.addActionListener(this);
		image.add(oneTho);
		
		twoTho=new JButton("Rs 2000");
		twoTho.setFont(new Font("Times New Roman",Font.BOLD,15));
		twoTho.setBounds(128,400,150,30);
		twoTho.addActionListener(this);
		image.add(twoTho);
		
		fiveTho=new JButton("Rs 5000");
		fiveTho.setFont(new Font("Times New Roman",Font.BOLD,15));
		fiveTho.setBounds(128,432,150,30);
		fiveTho.addActionListener(this);
		image.add(fiveTho);
		
		sixTho=new JButton("Rs 6000");
		sixTho.setFont(new Font("Times New Roman",Font.BOLD,15));
		sixTho.setBounds(283,368,150,30);
		sixTho.addActionListener(this);
		image.add(sixTho);
		
		eightTho=new JButton("Rs 8000");
		eightTho.setFont(new Font("Times New Roman",Font.BOLD,15));
		eightTho.setBounds(283,400,150,30);
		eightTho.addActionListener(this);
		image.add(eightTho);
		
		tenTho=new JButton("Rs 10000");
		tenTho.setFont(new Font("Times New Roman",Font.BOLD,15));
		tenTho.setBounds(283,432,150,30);
		tenTho.addActionListener(this);
		image.add(tenTho);
		
		back=new JButton("Back");
		back.setFont(new Font("Times New Roman",Font.BOLD,15));
		back.setBounds(283,464,150,30);
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
			setVisible(false);
			new Transactions(cardnumber).setVisible(true);
		}
		else 
		{
			String amount=((JButton)e.getSource()).getText().substring(3);
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
				if(e.getSource() != back && balance < Integer.parseInt(amount))
				{
					JOptionPane.showMessageDialog(null,"Insifficient Balance");
					return;
				}
				
				Date date=new Date();
				String bankquery = "INSERT INTO BANK VALUES('"+cardnumber+"','"+date+"','Withdrawl','"+amount+"')";
				con.stm.executeUpdate(bankquery);
				JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawl Successfully");
				
				setVisible(false);
				new Transactions(cardnumber).setVisible(true);
				
			}catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		
	}
  public static void main(String arg[])
  {
	new FastCash("");  
  }
}
