package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		
		GPSPoint k1 = new GPSPoint(1, 2.0, 3.0, 5.0);

		
		System.out.println("Time: " + k1.getTime());
		System.out.println();
	
		k1.setTime(2);
		System.out.println("New time: " + k1.getTime());
		System.out.println();

		

		System.out.println("Latitude: " + k1.getLatitude());
		System.out.println();

		k1.setLatitude(10);
		System.out.println("New latitude: " + k1.getLatitude());
		System.out.println();
		


		System.out.println("Longitude: " + k1.getLongitude());
		System.out.println();

		k1.setLongitude(25);
		System.out.println("New longitude: " + k1.getLongitude());
		System.out.println();


		
		System.out.println("Elevation: " + k1.getElevation());
		System.out.println();
		
		k1.setElevation(30);
		System.out.println("New elevation: " + k1.getElevation());
		System.out.println();

			
		System.out.println(k1.toString());
			
	}

}
