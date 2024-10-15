package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		
		GPSPoint k1 = new GPSPoint(5, 6, 8, 9);

		
		
		System.out.println("Time: " + k1.getTime());
		System.out.println();
	
		
	k1.setTime(0);
		System.out.println(k1.getTime());
		
	}

}
