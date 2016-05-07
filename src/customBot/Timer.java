/**
 * created by takayush on May 3, 2016
 */
package customBot;

/**
 * @author takay
 *
 */
public class Timer {
	long lStartTime;
	
	public void start(){
		Timer object = new Timer();
		lStartTime = System.currentTimeMillis();
		object.setlStartTime(lStartTime);
	}
	
	
	/**
	 * @return the lStartTime
	 */
	public long getlStartTime() {
		return lStartTime;
	}


	/**
	 * @param lStartTime the lStartTime to set
	 */
	public void setlStartTime(long lStartTime) {
		this.lStartTime = lStartTime;
	}


	public long stop(){
		
		long lEndTime = System.currentTimeMillis();
		long difference = lEndTime - lStartTime;

		System.out.println("Elapsed milliseconds: " + difference);
		
		return difference;
		
	}
}
