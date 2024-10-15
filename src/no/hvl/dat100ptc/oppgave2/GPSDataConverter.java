package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		String timepart = timestr.substring(TIME_STARTINDEX);		
		
		int hr= 8;
		int min=52; 
		int sec=26;
		int secs= (hr * 3600) + (min *60) + sec ;
		
		return secs;
	}
		
		public static void main(String[] args) {
	      
	        String timeString = "2024-10-14T08:52:26";

	      
	        int totalSekunder = toSeconds(timeString);

	       
	        System.out.println("Totalt antall sekunder: " + totalSekunder);
	    
	}	
		
	
	

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		

		int time1 = toSeconds(timeStr);
		double latitude1 = Double.parseDouble(latitudeStr);
		double longitude1 = Double.parseDouble(longitudeStr);
		double elevation1 = Double.parseDouble(elevationStr);
		
		GPSPoint gpspoint = new GPSPoint (time1, latitude1, longitude1, elevation1);
		
		return gpspoint;
		
	}
}
