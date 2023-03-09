import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserInterface {

	private JFrame frame;
	private JTextField textyear;
	private JComboBox cmonth,cday;
	private JLabel showday;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 255));
		frame.setResizable(false);
		frame.setBounds(100, 100, 994, 603);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(67, 85, 853, 405);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 192));
		panel_1.setBounds(143, 178, 554, 138);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWeekDayOf = new JLabel("Week Day of the Date");
		lblWeekDayOf.setForeground(new Color(0, 0, 0));
		lblWeekDayOf.setBackground(Color.PINK);
		lblWeekDayOf.setBounds(0, 0, 554, 65);
		panel_1.add(lblWeekDayOf);
		lblWeekDayOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeekDayOf.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		showday = new JLabel("");
		showday.setForeground(new Color(153, 0, 204));
		showday.setHorizontalAlignment(SwingConstants.CENTER);
		showday.setFont(new Font("Tahoma", Font.BOLD, 26));
		showday.setBounds(0, 73, 554, 65);
		panel_1.add(showday);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setForeground(Color.BLACK);
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDay.setBackground(Color.PINK);
		lblDay.setBounds(33, 46, 75, 43);
		panel.add(lblDay);
		
		cday = new JComboBox();
		cday.setBackground(Color.WHITE);
		cday.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cday.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cday.setBounds(113, 46, 112, 43);
		panel.add(cday);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setForeground(Color.BLACK);
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblMonth.setBackground(Color.PINK);
		lblMonth.setBounds(316, 46, 91, 43);
		panel.add(lblMonth);
		
		cmonth = new JComboBox();
		cmonth.setBackground(Color.WHITE);
		cmonth.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cmonth.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmonth.setBounds(411, 46, 112, 43);
		panel.add(cmonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(Color.BLACK);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblYear.setBackground(Color.PINK);
		lblYear.setBounds(606, 46, 91, 43);
		panel.add(lblYear);
		
		textyear = new JTextField();
		textyear.setBackground(Color.WHITE);
		textyear.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textyear.setBounds(690, 46, 112, 43);
		panel.add(textyear);
		textyear.setColumns(10);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ind=-1,day=0,month=0,year=0;
				ind = cday.getSelectedIndex();
				day=ind;
				ind = cmonth.getSelectedIndex();
				month=ind;
				boolean r=true;
				year = Integer.parseInt(textyear.getText());
				String syear = textyear.getText();
				if(year<1701 || year>2100)
					r=false;
				if(day==0 || month==0 || syear.isEmpty() || r==false)
				{
					clear();
					JOptionPane.showMessageDialog(null, "Please enter valid details!");
				}
				else
				{
					int lasttwodigit = Integer.parseInt(syear.substring(2,4));
					int addon=0;
					//System.out.println(lasttwodigit);
					//System.out.println(firsttwodigit);
					boolean leap=false;
					
					if(year%4 == 0) 
					{
					      if(year%100 == 0) 
					      {
					    	  if(year%400 == 0)
					    		  leap=true;
					    	  else
					    		  leap=false;
					      }
					      else
					    	  leap=true;
					}
					else
						leap=false;
					
					
					if(year>2000 && year<=2100)
						addon=0;
					else if(year>1900 && year<=2000)
						addon=1;
					else if(year>1800 && year<=1900)
						addon=3;
					else if(year>1700 && year<=1800)
						addon=5;
					BackEnd be = new BackEnd();
					int result = be.convert(lasttwodigit,day,month,leap,addon);
					String d = "";
					if(result==0)
						d="SUNDAY";
					else if(result==1)
						d="MONDAY";
					else if(result==2)
						d="TUESDAY";
					else if(result==3)
						d="WEDNESDAY";
					else if(result==4)
						d="THURSDAY";
					else if(result==5)
						d="FRIDAY";
					else if(result==6)
						d="SATURDAY";
					cday.setSelectedIndex(0);
					cmonth.setSelectedIndex(0);
					textyear.setText("");
					showday.setText(day+"/"+month+"/"+year+" = "+d);
				}
			}
		});
		btnConvert.setBackground(new Color(255, 204, 204));
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnConvert.setBounds(340, 340, 166, 42);
		panel.add(btnConvert);
		
		JLabel lblNewLabel = new JLabel("Date to Week Day Converter from 1701 to 2100");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 10, 960, 65);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("clear");
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(290, 508, 166, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 204, 204));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnExit.setBounds(523, 508, 166, 42);
		frame.getContentPane().add(btnExit);
	}
	public void clear()
	{
		cday.setSelectedIndex(0);
		cmonth.setSelectedIndex(0);
		textyear.setText("");
		showday.setText("");
	}
}
