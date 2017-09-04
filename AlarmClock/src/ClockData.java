/**
 * 
 * Class: ClockData
 * Description: A class that holds all the variables necessary for our Alarm clock application
 * Author: Adnan Alihodzic
 * 
 */
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class ClockData {
	
	private Calendar currentTime = Calendar.getInstance();
	private int hour;
	private int minute;
	private int second;
	private static boolean isAlarmSet = false;
	private static int alarmHour;
	private static int alarmMinute;
	File yourFile = new File("bells005.wav");
	AudioInputStream stream;
	AudioFormat format;
	DataLine.Info info;
	private static Clip clip;
	
	
	public ClockData(){
		this.hour = currentTime.get(Calendar.HOUR_OF_DAY);
		this.minute = currentTime.get(Calendar.MINUTE);
		this.second = currentTime.get(Calendar.SECOND);
		
		try {
			stream = AudioSystem.getAudioInputStream(yourFile);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	public int getHour(){
		return this.hour;
	}
	
	public int getMinute(){
		return this.minute;
	}
	
	public int getSecond(){
		return this.second;
	}
	
	public void setAlarmHour(int theHour){
		alarmHour = theHour;
	}
	
	public void setAlarmMinute(int theMinute){
		alarmMinute = theMinute;
	}
	
	public int getAlarmHour(){
		return alarmHour;
	}
	
	public int getAlarmMinute(){
		return alarmMinute;
	}
	
	public boolean getAlarm(){
		return isAlarmSet;
	}
	
	public void setAlarm(boolean alarm){
		isAlarmSet = alarm;
	}
	
	public Clip getClip(){
		return clip;
	}
	
}
