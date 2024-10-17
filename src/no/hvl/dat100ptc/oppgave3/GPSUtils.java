package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	
	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double m : da) {
			if (m < min) {
				min = m;
			}
		}
		return min;
	}
	

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
double [] latTab = new double[gpspoints.length]; 
	


for (int i = 0; i < gpspoints.length; i++) {
	latTab[i] = gpspoints[i].getLatitude();
}
return latTab;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

double [] longTab = new double[gpspoints.length];

for (int i = 0; i < gpspoints.length; i ++) {
	longTab[i] = gpspoints[i].getLongitude();
}
return longTab;

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		// splitte opp gpspoint1 og 2 i lat og long, burk meotde ^ 
		
		
		
		double d;
		double latitude1, longitude1, latitude2, longitude2;
        latitude1 = gpspoint1.getLatitude();
        longitude1 = gpspoint1.getLongitude();
        latitude2 = gpspoint2.getLatitude();
        longitude2 = gpspoint2.getLongitude();
        
        double latitude1R = Math.toRadians(latitude1);
        double longitude1R = Math.toRadians(longitude1);
        double latitude2R = Math.toRadians(latitude2);
        double longitude2R = Math.toRadians(longitude2);
        double endringLat = latitude2R - latitude1R;
        double endringLong = longitude2R - longitude1R;
        double a = compute_a(latitude1R, latitude2R, endringLat, endringLong);
        double c = compute_c(a);
		
		d = R * c;
		
		return d;
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		
		double a = (Math.sin(deltaphi/2)) * (Math.sin(deltaphi/2)) + Math.cos(phi1) * Math.cos(phi2) * (Math.sin(deltadelta/2)) * (Math.sin(deltadelta/2));
		
return a;
	}

	private static double compute_c(double a) {

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 -a));	
		
return c;
	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
<<<<<<< HEAD
		
	
		
	
=======
		double distance;
		int secs1 = gpspoint1.getTime();
		int secs2 = gpspoint2.getTime();
        secs = secs2 - secs1;
        distance = distance(gpspoint1, gpspoint2);
>>>>>>> e8040c4964bd2d0653c3f43c68568b4be07666cc

		
		
		speed = distance/secs;
		
return speed;
	}

	public static String formatTime(int secs) {
//få delt opp i timer min sec ved rest
		String timestr;
		String TIMESEP = ":";
int timer = secs/3600;
secs = secs%3600;

<<<<<<< HEAD
	 int timer = 03;
	 int minutter = 02;
	 int sekunder = 22;
		
		String tid = String.format("%02d:%02d:%02d" , timer,TIMESEP,minutter,TIMESEP ,sekunder);
		
		System.out.println(tid);
		int totaltSekunder = (timer * 3600) + (minutter * 60) + sekunder;
		return tid;
		}
=======
int minutter = secs/60;
secs = secs%60;

int sekunder = secs;
		
		timestr = String.format("%10s", timer, TIMESEP, minutter, TIMESEP, sekunder);
		
		return timestr;
	}
>>>>>>> e8040c4964bd2d0653c3f43c68568b4be07666cc
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		
		str = String.format("%10s", d);
		
		
		
		return str;
	}
}
