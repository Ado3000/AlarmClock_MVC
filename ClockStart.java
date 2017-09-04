/**
 * 
 *  Class: ClockStart
 *  Description: Class that starts the Alarm clock application
 *  Author: Adnan Alihodzic
 *
 */

public class ClockStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClockWindow clockWindow = new ClockWindow();
		ClockData clockData = new ClockData();
		
		ClockControl controller = new ClockControl(clockWindow, clockData);	
		
	}

}
