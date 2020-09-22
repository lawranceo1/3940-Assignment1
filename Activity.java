/**
 * @author Brian Duong
 * @version 2020
 */
import java.io.*;

public class Activity {

	private String dirName = null;
	public static void main(String[] args) throws IOException {
		new Activity(args[0]).onCreate();
	}

	public Activity(String dirName) {
		this.dirName = dirName + "\n";
	}

	public void onCreate() {
		System.out.println(new DirClient(this.dirName).getListing());
	}

}