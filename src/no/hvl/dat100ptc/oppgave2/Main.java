package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;


public class Main {

	public static void main(String[] args) {
        
		//GPSPoint gpspoint1 = new GPSPoint(35000, 387990, 5.255000, 60);
	    GPSPoint gpspoint2 = new GPSPoint(40000, 400000, 5.280000, 70);
	
		GPSData gpsData = new GPSData(2);

		GPSPoint gpspoint = GPSDataConverter.convert("2017-08-13T08:52:26.000Z","60.385390","5.217217","61.9");

		
        System.out.println("GPS-punktet er: " + gpspoint.toString());

		

		gpsData.insertGPS(gpspoint);
		gpsData.insertGPS(gpspoint2);

		
		gpsData.print();

	}
}
