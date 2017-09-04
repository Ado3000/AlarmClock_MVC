/**
 * 
 * Class: ClockWindow
 * Description: A JFrame that represtens the view for an alarm clock application
 * Author: Adnan Alihodzic
 * 
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;



public class ClockWindow extends JFrame implements ActionListener {

	private JTextField timeWindow;
	private JButton setAlarmButton;
	private JButton stopAlarm;
	private JTextField hourField;
	private JTextField minuteField;
	private JButton setButton;
	private JFrame alarmSettings;
	private JLabel hourLabel;
	private JLabel minuteLabel;
	ClockData data = new ClockData();
	private Timer clockTimer = new Timer(1000, this);


	public ClockWindow(){

		timeWindow = new JTextField(10);
		timeWindow.setEditable(false);
		timeWindow.setVisible(true);
		add(timeWindow);

		alarmSettings = new JFrame();
		alarmSettings.setLayout(new FlowLayout());
		alarmSettings.getContentPane().setBackground(Color.LIGHT_GRAY);
		alarmSettings.setSize(175,135);
		alarmSettings.setVisible(false);
		alarmSettings.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		hourLabel = new JLabel("Set Hour:");
		alarmSettings.add(hourLabel);
		
		hourField = new JTextField(10);
		hourField.setEditable(true);
		hourField.setVisible(true);
		alarmSettings.add(hourField);

		minuteLabel = new JLabel("Set Minute:");
		alarmSettings.add(minuteLabel);
		
		minuteField = new JTextField(10);
		minuteField.setEditable(true);
		minuteField.setVisible(true);
		alarmSettings.add(minuteField);

		setButton = new JButton();
		setButton.setText("Set");
		alarmSettings.add(setButton);

		setAlarmButton = new JButton();
		setAlarmButton.setText("Set Alarm");
		add(setAlarmButton);

		stopAlarm = new JButton();
		stopAlarm.setText("Stop Alarm");
		add(stopAlarm);
		
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(475,275);
		setResizable(false);

		clockTimer.start();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Calendar currentTime = Calendar.getInstance();
	
		//Keeps setting the time window with the current time
		timeWindow.setText(new ClockData().getHour() + ":" + new ClockData().getMinute() + ":" + new ClockData().getSecond());

		//If alarm is set and the current time matches with the current hour and current minute then the alarm goes on
		if(data.getAlarm() && data.getAlarmHour() ==  currentTime.get(Calendar.HOUR_OF_DAY) && data.getAlarmMinute() == currentTime.get(Calendar.MINUTE))	{
				data.getClip().start();
		}
	}

	public JButton getAlarmButton(){
		return setAlarmButton;
	}

	public JButton getStopAlarmButton(){
		return stopAlarm;
	}

	public JFrame getAlarmSettings(){
		alarmSettings.setVisible(true);
		return alarmSettings;
	}

	public JButton getSetButton(){
		return setButton;
	}

	public JTextField getHourMark(){
		return hourField;
	}

	public JTextField getMinuteMark(){
		return minuteField;
	}
	
	public void errorHourMessage(){
		JOptionPane.showMessageDialog(null, "Please enter hour");
	}
	
	public void errorMinuteMessage(){
		JOptionPane.showMessageDialog(null, "Please enter minute");
	}

}




