package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

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
      distance += calculateDistance(p1,p2);
      
     }

		return distance;

	}
	
	private double calculateDistance(GPSPoint p1, GPSPoint p2) {
		
		final int R = 6371_000;
		double latDistance = Math.toRadians(p2.getLatitude() - p1.getLatitude());
		double lonDistance = Math.toRadians(p2.getLongitude() - p1.getLongitude());
		
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
	               Math.cos(Math.toRadians(p1.getLatitude())) * Math.cos(Math.toRadians(p2.getLatitude())) *
	               Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

	    return R * c;
	}

	public double totalElevation1() {

		double Elevation = 0;

		for (int i = 0; i < gpspoints.length - 1; i++) {
			GPSPoint p1 = gpspoints[i];
			GPSPoint p2 = gpspoints[i + 1];
		 
			double elevationChange = p2.getElevation() - p1.getElevation();
	
			if (elevationChange > 0) {
				Elevation += elevationChange;
	
			} 
		}	
	
		return Elevation; 
	
	}

	public int totalTime() {

		// TODO
		throw new UnsupportedOperationException(TODO.method());
		
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		
		// TODO
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO 
		throw new UnsupportedOperationException(TODO.method());
	
	}

	public double averageSpeed() {

		double average = 0;
		
		// TODO
		throw new UnsupportedOperationException(TODO.method());
		
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
