package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double distance = 0;
    	for (int i= 0; i< gpspoints.length - 1;i++) {
      		GPSPoint p1 = gpspoints[i];
      		GPSPoint p2 = gpspoints[i+1];
      		distance += GPSUtils.distance(p1,p2);
     }

		return distance;

	}
	

	public double totalElevation() {

		double totalElevation = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			GPSPoint p1 = gpspoints[i];
			GPSPoint p2 = gpspoints[i + 1];
		 
			double elevationChange = (p2.getElevation() - p1.getElevation());
	
			if (elevationChange < 0) {
				totalElevation += 0;
			} 
			else
				totalElevation += elevationChange;
		}	
	
		return totalElevation; 
	
	}

	public int totalTime() {
		int tid = 0;
		for (int i = 0; i < gpspoints.length-1; i++) {
		
			GPSPoint gpspoint1 = gpspoints[i];
			GPSPoint gpspoint2 = gpspoints[i+1];
			
			int time1 = gpspoint1.getTime();
			int time2 = gpspoint2.getTime();
			
		    tid += (time2 - time1);
		}
		    return tid;
	}
	
	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
	   
		for (int i = 0; i < gpspoints.length - 1;i++) {
		GPSPoint p1 = gpspoints[i];
		GPSPoint p2 = gpspoints[i+1];
		
		double Distance = GPSUtils.distance(p1, p2);
		
		int timeDifference = p2.getTime() - p1.getTime();
		
		double speed = Distance / timeDifference;
		
		speeds[i] = speed; 
		
		}
		
		return speeds;
	
	}
	
	public double maxSpeed() {
		
		double maxSpeed = 0;
		double [] speed = speeds();
		for (int i = 0; i < speed.length; i++) {
			double p1 = speed[i];
			if (p1 > maxSpeed) {
				maxSpeed = p1;
			}
		}
	
	return maxSpeed;
	}

	public double averageSpeed() {
        double distanse = totalDistance();
        double tid = totalTime();
		double average;
	
	
		average = distanse / tid;
		return average;
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;
        double t = secs/3600.0;

		double met = 0;		
		double speedmph = speed * MS;
		
		
		
		
		if (speedmph < 10) {
			met = 4.0;
		}
		else if (12 > speedmph && speedmph > 10) {
			met = 6.0;
		}
		else if (14 > speedmph && speedmph > 12) {
			met = 8.0;
		}
		else if (16 > speedmph && speedmph > 14) {
			met = 10.0;
		}
		else if (20 > speedmph && speedmph > 16) {
			met = 12.0;
		}
		else if (speedmph > 20) {
			met = 16.0;	
		}
		kcal = met * weight * t;
		
		
		
		return kcal;	
	}

	public double totalKcal(double weight) {

		double totalKcal = 0;
		int time;
		double speed;
		// distance;
		for (int i = 0; i < gpspoints.length-1; i++) {
			GPSPoint p1 = gpspoints[i];
			GPSPoint p2 = gpspoints[i+1];
			//distance = GPSUtils.distance( p1, p2);
			time = p2.getTime() - p1.getTime();
			speed = GPSUtils.speed(p1, p2);
			
			totalKcal += kcal(weight, time, speed);
		}
		
		return totalKcal;
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {
		double distanse = totalDistance();
		distanse = distanse / 1000;
		
		double gjsnitt = averageSpeed();
		gjsnitt = gjsnitt /1000;
		
	System.out.println("==============================================");
	System.out.println("Total time             :         " + totalTime());
	System.out.println("Total distanse         :         " + totalDistance());
	System.out.println("Total elevation        :         " + distanse);
	System.out.println("Max Speed              :         " + maxSpeed());
	System.out.println("Average Speed          :         " + gjsnitt);
	System.out.println("Energy                 :         " + totalKcal(WEIGHT));
	System.out.println("==============================================");
		
	}

}
