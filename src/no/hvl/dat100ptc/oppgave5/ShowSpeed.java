package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;
import no.hvl.dat100ptc.TODO;

public class ShowSpeed extends EasyGraphics {
			
	private static int MARGIN = 50;
	private static int BARHEIGHT = 50; 

	private GPSComputer gpscomputer;
	
	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Speed profile", 
				2 * MARGIN + 
				2 * gpscomputer.speeds().length, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT);
	}
	
	public void showSpeedProfile(int ybase) {
		
		int x = MARGIN,y;
		int avstand = 2;
		int z;
		double fart [] = gpscomputer.speeds();
		for (int i = 0; i < gpscomputer.speeds().length; i++) {
			double høyde = fart[i];
		
			int høyde1 = (int)høyde;
			z = ybase - høyde1;
			
			setColor(0, 0, 255);
		    drawLine(x, ybase, x, z);
		    x += avstand;
		
		
		double høyd = gpscomputer.averageSpeed();
		int høy = (int)(ybase - høyd);
		setColor(0, 255, 255);
		int xEND = gpscomputer.speeds().length;
		drawLine(x, høy, xEND, høy);
		
		
	
}
}
}