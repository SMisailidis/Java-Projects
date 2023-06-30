import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class Timer {

	private LocalDateTime afterOneMinute;
	private int seconds, startedSeconds;
	private long mseconds;
	
	public Timer() {
		this.afterOneMinute = null;
		this.seconds = 0;
		this.startedSeconds = 0;
		this.mseconds = 0;
	}

	public void checkTime() {
		
		LocalDateTime currTime = LocalDateTime.now();
		this.seconds = currTime.getSecond();
		this.mseconds =  TimeUnit.NANOSECONDS.convert(currTime.getNano(), TimeUnit.MILLISECONDS);
		
		if(currTime.getMinute() == afterOneMinute.getMinute() && currTime.getSecond() == afterOneMinute.getSecond()) {
			System.out.println("Search is taking a lot of time, im shutting down!");
			System.exit(0);
		}
	}
	
	public void setStartedSeconds() {
		this.startedSeconds = LocalDateTime.now().getSecond();
	}
	
	public void setAfterOneMinute() {
		this.afterOneMinute = LocalDateTime.now().plusMinutes(1);
	}
	
	public void printTime(String algo) {
		System.out.println("The time needed to find the target with " + algo + " Algorithm was: " + (this.seconds - this.startedSeconds) + "." + this.mseconds);
	}
}
