package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SignupTwo extends JFrame implements ActionListener
{
	JLabel additionalDetail,religion,category,income,qualification,occupation,pan,aadhar,sencit,exisitingAccount;
	JTextField aadharTextField,panTextField;
	JComboBox<Object> religioncombobox,categorycombobox,incomecombobox,qualicombobox,occucombobox;
	JRadioButton syes,sno,eyes,eno;
	ButtonGroup seniorgroup,existinggroup;
	JButton next;
	String formno;
	public SignupTwo(String formno)
	{
		this.formno=formno; 
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		additionalDetail=new JLabel("Page 2: Additional Details");
		additionalDetail.setFont(new Font("Ralway",Font.BOLD,22));
		additionalDetail.setBounds(290,80,280,30);
		add(additionalDetail);
		
		religion=new JLabel("Religion:");
		religion.setFont(new Font("Ralway",Font.BOLD,22));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		String valreligion[]= {"Muslim","Hindu","Sikh","Christian","Other"};
		religioncombobox = new JComboBox<Object>(valreligion);
		religioncombobox.setFont(new Font("Ralway",Font.BOLD,14));
		religioncombobox.setBackground(Color.WHITE);
		religioncombobox.setBounds(300, 140, 400, 30);
		add(religioncombobox);
		
		category=new JLabel("Category:");
		category.setFont(new Font("Ralway",Font.BOLD,22));
		category.setBounds(100,190,200,30);
		add(category);
		
		String valcategory[]= {"General","OBC","ST","SC","Other"};
		categorycombobox = new JComboBox<Object>(valcategory);
		categorycombobox.setFont(new Font("Ralway",Font.BOLD,14));
		categorycombobox.setBackground(Color.WHITE);
		categorycombobox.setBounds(300, 190, 400, 30);
		add(categorycombobox);
		
		income=new JLabel("Income:");
		income.setFont(new Font("Ralway",Font.BOLD,22));
		income.setBounds(100,240,200,30);
		add(income);
		
		String valincome[]= {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
		incomecombobox = new JComboBox<Object>(valincome);
		incomecombobox.setFont(new Font("Ralway",Font.BOLD,14));
		incomecombobox.setBackground(Color.WHITE);
		incomecombobox.setBounds(300, 240, 400, 30);
		add(incomecombobox);
		
		qualification=new JLabel("Qualification:");
		qualification.setFont(new Font("Ralway",Font.BOLD,22));
		qualification.setBounds(100,290,200,30);
		add(qualification);
		
		String valquali[]= {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Other"};
		qualicombobox = new JComboBox<Object>(valquali);
		qualicombobox.setFont(new Font("Ralway",Font.BOLD,14));
		qualicombobox.setBackground(Color.WHITE);
		qualicombobox.setBounds(300, 290, 400, 30);
		add(qualicombobox);
		
		occupation=new JLabel("Occupation:");
		occupation.setFont(new Font("Ralway",Font.BOLD,22));
		occupation.setBounds(100,340,200,30);
		add(occupation);
		
		String valoccu[]= {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
		occucombobox = new JComboBox<Object>(valoccu);
		occucombobox.setFont(new Font("Ralway",Font.BOLD,14));
		occucombobox.setBackground(Color.WHITE);
		occucombobox.setBounds(300, 340, 400, 30);
		add(occucombobox);
		
		pan=new JLabel("PAN NUMBER:");
		pan.setFont(new Font("Ralway",Font.BOLD,22));
		pan.setBounds(100,390,200,30);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setFont(new Font("Ralway",Font.BOLD,14));
		panTextField.setBounds(300, 390, 400, 30);
		add(panTextField);
		
		aadhar=new JLabel("Aadhar Number:");
		aadhar.setFont(new Font("Ralway",Font.BOLD,22));
		aadhar.setBounds(100,440,200,30);
		add(aadhar);
		
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Ralway",Font.BOLD,14));
		aadharTextField.setBounds(300, 440, 400, 30);
		add(aadharTextField);
		
		sencit=new JLabel("Senior Citizen:");
		sencit.setFont(new Font("Ralway",Font.BOLD,22));
		sencit.setBounds(100,490,200,30);
		add(sencit);
		
		syes=new JRadioButton("Yes");
		syes.setBounds(310,490,100,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno=new JRadioButton("No");
		sno.setBounds(460,490,150,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		seniorgroup=new ButtonGroup();
		seniorgroup.add(syes);
		seniorgroup.add(sno);
		
		exisitingAccount=new JLabel("Exisiting Account:");
		exisitingAccount.setFont(new Font("Ralway",Font.BOLD,22));
		exisitingAccount.setBounds(100,540,200,30);
		add(exisitingAccount);
		
		eyes=new JRadioButton("Yes");
		eyes.setBounds(310,540,100,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno=new JRadioButton("No");
		eno.setBounds(460,540,150,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
        existinggroup=new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);
		
		next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.white);
		next.setFont(new Font("Ralway",Font.BOLD,14));
		next.setBounds(620,610,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850, 750);
		setLocation(350,10);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String religion=(String)religioncombobox.getSelectedItem();
		String category=(String)categorycombobox.getSelectedItem();
		String income=(String)incomecombobox.getSelectedItem();
		String qualification=(String)qualicombobox.getSelectedItem();
		String occupation=(String)occucombobox.getSelectedItem();
		String pannum=panTextField.getText();
		String aadhar=aadharTextField.getText();
		String senior="";
		if(syes.isSelected())
			senior="Yes";
		else
			senior="No";
		String existing="";
		if(eyes.isSelected())
			existing="Yes";
		else
			existing="No";
		try
		{
		if(religion.equals(""))
			JOptionPane.showMessageDialog(null,"Please select Religion");
		else if(category.equals(""))
			JOptionPane.showMessageDialog(null,"Please select Category");
		else if(income.equals(""))
			JOptionPane.showMessageDialog(null,"Please select Income");
		else if(qualification.equals(""))
			JOptionPane.showMessageDialog(null,"Please select Qualification");
		else if(occupation.equals(""))
			JOptionPane.showMessageDialog(null,"Please select Occupation");
		else if(pannum.equals(""))
			JOptionPane.showMessageDialog(null,"PAN Number is Required");
		else if(aadhar.equals(""))
			JOptionPane.showMessageDialog(null,"Aadhar Number is Required");
		else if(senior.equals(""))
			JOptionPane.showMessageDialog(null,"Please Select Senior Citizen");
		else if(existing.equals(""))
			JOptionPane.showMessageDialog(null,"Please Select Existing Account");
		else
		{
	      Connect obj=new Connect();
	      String query="INSERT INTO SIGNUP2 VALUES('"+formno+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"','"+pannum+"','"+aadhar+"','"+senior+"','"+existing+"')";
	      obj.stm.executeUpdate(query);
	      setVisible(false);
	      new Signup3(formno).setVisible(true);
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
  public static void main(String arg[])
  {
	new SignupTwo("");  
  }

}
