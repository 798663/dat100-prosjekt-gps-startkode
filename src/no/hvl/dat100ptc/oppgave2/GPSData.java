package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	
	
	public GPSData(int n) {
        gpspoints = new GPSPoint[n];
		this.antall = 0;
		
	}

	

	
	public GPSPoint[] getGPSPoints() {
	    return this.gpspoints;
	}
	
	

	
	protected boolean insertGPS(GPSPoint gpspoint) {
      	
    if (antall < gpspoints.length) {
        		gpspoints[antall] = gpspoint;
        		antall++;
        	
        return true; 
         }
    else {
	    return false;
         }
}

	
	

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		int time1 = Integer.parseInt(time);
		double latitude1 = Double.parseDouble(latitude);
		double longitude1 = Double.parseDouble(longitude);
		double elevation1 = Double.parseDouble(elevation);
	
		 GPSPoint nyttGPSPunkt = new GPSPoint(time1, latitude1, longitude1, elevation1);
		 
		 return insertGPS(nyttGPSPunkt);
		
	}

	public void print() {

		System.out.println("====== GPS Data - START ======");
		for (int i = 0; i < antall; i++) {
			System.out.println((i + 1) + " " + gpspoints[i].toString());
		}
		
		
		System.out.println("====== GPS Data - SLUTT ======");
	}
}
