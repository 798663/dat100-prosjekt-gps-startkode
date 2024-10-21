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
		for (int i = 0; i < speed.length-1; i++) {
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

		double met = 0;		
		double speedmph = speed * MS;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

}
