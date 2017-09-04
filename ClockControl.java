/**
 * 
 * Class: ClockControl
 * Description: The class that handles all the controller functions for our Alarm clock application
 * Author: Adnan Alihodzic
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockControl implements ActionListener{
	
	ClockWindow clockWindow;
	ClockData clockData;

	
	public ClockControl(ClockWindow clockWindow, ClockData clockData){
		this.clockWindow = clockWindow;
		this.clockData = clockData;
		
		this.clockWindow.getAlarmButton().addActionListener((ActionListener) this);
		this.clockWindow.getStopAlarmButton().addActionListener((ActionListener) this);
		this.clockWindow.getSetButton().addActionListener((ActionListener) this);
				
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == clockWindow.getAlarmButton()){
			clockWindow.getAlarmSettings();
			clockData.setAlarm(true);
		}
		else if(e.getSource() == clockWindow.getStopAlarmButton()){
			clockData.getClip().stop();
			clockData.setAlarm(false);
		}
		else if(e.getSource() == clockWindow.getSetButton()){
			
			if(clockWindow.getHourMark().getText().equals("") || clockWindow.getHourMark().getText() == null) {
				clockWindow.errorHourMessage();
			}
			else if(clockWindow.getMinuteMark().getText().equals("") || clockWindow.getMinuteMark().getText() == null){
				clockWindow.errorMinuteMessage();
			}
			else {
			clockData.setAlarmHour(Integer.parseInt(clockWindow.getHourMark().getText()));
			clockData.setAlarmMinute(Integer.parseInt(clockWindow.getMinuteMark().getText()));
			}

		}
		
	}
		

}
