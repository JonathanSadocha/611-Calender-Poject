package Project;

import javax.swing.*;
import java.awt.*;
//import javax.swing.text.html.ImageView;
import java.awt.event.ActionListener;


/***********************************************************************
*
* Calendar View Class
*
* @author Jonathan Sadocha
* @version 1.0
*
**********************************************************************/
public class CalendarView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblDateIn = new JLabel("Enter Date:");
	private JTextField txtDateTextIn = new JTextField(10);
	
	private JButton butEnterDate = new JButton("Enter");
	private JButton butClear = new JButton("Clear");
	
	private JLabel lblDateTextOut = new JLabel("Day Entered:");
	private JTextField txtDateTextOut = new JTextField(10);

	private JLabel lblNextDateTextOut = new JLabel("Next Day:");
	private JTextField txtNextDateTextOut = new JTextField(10);
	
	private JLabel lblPrevoiusDateTextOut = new JLabel("Previous Day:");
	private JTextField txtPrevoiusDateTextOut = new JTextField(10);
	
	private JLabel lblDayOfTheWeekOut = new JLabel("Day of the Week:");
	private JTextField txtDayOfTheWeekOut = new JTextField(10);
	
	private JLabel lblShoppingDays = new JLabel("Shopping Days:");
	private JTextField txtShoppingDays = new JTextField(10);
	
	private JLabel lblZodiacSignOut = new JLabel("Zodiac Sign:");
	private JTextField txtZodiacSignOut = new JTextField(10);
	
	private JLabel lblZodiacPic = new JLabel();
	
	
	
	/***********************************************************************
	 *
	 * Constructor for the view
	 *
	 **********************************************************************/
	CalendarView(){
		
		JPanel calendarPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		calendarPanel.add(lblDateIn);
		calendarPanel.add(txtDateTextIn);
		
		calendarPanel.add(butEnterDate);
		calendarPanel.add(butClear);
		 
		calendarPanel.add(lblDateTextOut);
		calendarPanel.add(txtDateTextOut);
		txtDateTextOut.setEditable(false);
		
		calendarPanel.add(lblNextDateTextOut);
		calendarPanel.add(txtNextDateTextOut);
		txtNextDateTextOut.setEditable(false);
		
		calendarPanel.add(lblPrevoiusDateTextOut);
		calendarPanel.add(txtPrevoiusDateTextOut);
		txtPrevoiusDateTextOut.setEditable(false);
		
		calendarPanel.add(lblDayOfTheWeekOut);
		calendarPanel.add(txtDayOfTheWeekOut);
		txtDayOfTheWeekOut.setEditable(false);
		
		calendarPanel.add(lblShoppingDays);
		calendarPanel.add(txtShoppingDays);
		txtShoppingDays.setEditable(false);
		
		calendarPanel.add(lblZodiacSignOut);
		calendarPanel.add(txtZodiacSignOut);
		txtZodiacSignOut.setEditable(false);
		
		calendarPanel.add(lblZodiacPic);

		this.add(calendarPanel);
		this.setLayout(new GridLayout(1,2));
		this.setSize(170,500);  
		this.setVisible(true);  
	}
	
	/***********************************************************************
	 *
	 * View method for getting the date from the text box
	 *
	 **********************************************************************/
	public String getDate() {
		return txtDateTextIn.getText();
	}
	
	/***********************************************************************
	 *
	 * Method to print current date to text box
	 * 
	 * @param DateOut is the date to be printed
	 *
	 **********************************************************************/
	public void settxtDateTextOut(String DateOut) {
		txtDateTextOut.setText(DateOut.toString());
	}
	
	/***********************************************************************
	 *
	 * Method to print next date to text box
	 * 
	 * @param DateOut is the next date to be printed
	 *
	 **********************************************************************/
	public void settxtNextDateTextOut(String DateOut) {
		txtNextDateTextOut.setText(DateOut.toString());
	}
	
	/***********************************************************************
	 *
	 * Method to print previous date to text box
	 * 
	 * @param DateOut is the previous date to be printed
	 *
	 **********************************************************************/
	public void settxtPrevoiusDateTextOut(String DateOut) {
		txtPrevoiusDateTextOut.setText(DateOut.toString());
	}
	
	/***********************************************************************
	 *
	 * Method to print day of the week to text box
	 * 
	 * @param DateOut is the day of the week to be printed
	 *
	 **********************************************************************/
	public void settxtDayOfTheWeekOut(String DateOut) {
		txtDayOfTheWeekOut.setText(DateOut.toString());
	}
	
	/***********************************************************************
	 *
	 * Method to print shopping days till Christmas to text box
	 * 
	 * @param DateOut is is the shopping days till Christmas to be printed
	 *
	 **********************************************************************/
	public void settxtShoppingDays(int ShopingDaysOut) {
		txtShoppingDays.setText(Integer.toString(ShopingDaysOut));
	}
	
	/***********************************************************************
	 *
	 * Method to print zodiac sign to text box
	 * 
	 * @param DateOut is is the zodiac sign to be printed
	 *
	 **********************************************************************/
	public void settxtZodiacSignOut(String SignOut) {
		txtZodiacSignOut.setText(SignOut.toString());
	}
	
	/***********************************************************************
	 *
	 * Adds the listener for the enter button for the calendar calculator
	 * 
	 * @param listenerForEnterDateButton is the button listener in 
	 *
	 **********************************************************************/
	void addCalenderListener(ActionListener listenerForEnterDateButton) {
		butEnterDate.addActionListener(listenerForEnterDateButton);
	}
	
	/***********************************************************************
	 *
	 * Adds the listener for the clear button for the calendar calculator
	 * 
	 * @param listenerForEnterDateButton is the button listener in 
	 *
	 **********************************************************************/
	void addClearListener(ActionListener listenerForClearButton) {
		butClear.addActionListener(listenerForClearButton);
	}
	
	/***********************************************************************
	 *
	 * Displays the view of the error message alert
	 * 
	 * @param string  of the error message that is to be printed in the alert box
	 *
	 **********************************************************************/
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	/***********************************************************************
	 *
	 * Displays the image of the zodiac sign
	 * 
	 * @param string is the zodiac sign sign in word form because I can use that to get the picture address
	 *
	 **********************************************************************/
	void displayImage(String SignOut) {
		String picURL = SignOut + ".jpg";
		this.lblZodiacPic.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(picURL)).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
	}
	
	/***********************************************************************
	 *
	 * Clears the text boxes
	 *
	 **********************************************************************/
	void clear() {
		this.settxtDateTextOut("");
		this.settxtNextDateTextOut("");
		this.settxtPrevoiusDateTextOut("");
		this.settxtDayOfTheWeekOut("");
		this.settxtShoppingDays(0);
		this.settxtZodiacSignOut("");
		this.lblZodiacPic.setIcon(null);
	}
}



