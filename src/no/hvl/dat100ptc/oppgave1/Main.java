package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		
		GPSPoint k1 = new GPSPoint(5, 6, 8, 9);

		
		System.out.println("Time: " + k1.getTime());
		System.out.println();
		
		k1.setTime(0);
		System.out.println("New time: " + k1.getTime());
		System.out.println();


		
		

		k1.setLongitude(25);
		System.out.println("New longitude: " + k1.getLongitude());
		System.out.println();

		
		System.out.println("Elevation: " + k1.getElevation());
		System.out.println();
		
		k1.setElevation(30);
		System.out.println("New elevation: " + k1.getElevation());
		System.out.println();


		k1.setLongitude(25);
		System.out.println("New longitude: " + k1.getLongitude());
		System.out.println();
			
		System.out.println(k1.toString());
			
		
		
		
		
		
		
		
		
	}

}
