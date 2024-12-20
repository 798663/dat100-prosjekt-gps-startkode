package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import no.hvl.dat100ptc.TODO;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 600;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	private double minlon, minlat, maxlon, maxlat;

	private double xstep, ystep;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		
		xstep = scale(MAPXSIZE, minlon, maxlon);
		ystep = scale(MAPYSIZE, minlat, maxlat);
		
		showRouteMap(MARGIN + MAPYSIZE);

		replayRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	public double scale(int maxsize, double minval, double maxval) {

		double step = maxsize / (Math.abs(maxval - minval));
		System.out.println(maxsize);


		return step;
	}
	/*
	public void showRouteMap(int ybase) {


		// TODO 
		for (int i = 0; i < gpspoints.length - 1; i++) {
			double høyde = gpspoints[i].getLatitude();
		
			System.out.println(gpspoints[i]);
			
			int avstand = 3;

			if (ybase < 0) {
				ybase = 0;
			}

			double y = høyde;

			System.out.println(y);

			double a = 0;
			a ++;

			setColor(0, 0, 255);
			drawCircle(a, y, 1.2);

		}
	} */
	public void showRouteMap(int ybase) {
		
		for (int i = 0; i < gpspoints.length - 2; i++) {
			
			double latitude = gpspoints[i].getLatitude();
			double longitude = gpspoints[i].getLongitude();
	
			
			int x = MARGIN + (int)((longitude - minlon) * xstep);
			int y = ybase - (int)((latitude - minlat) * ystep); 
	
			
			setColor(50, 255, 255);
			drawCircle(x, y, 3); 
			if (i > 0) {
			double x0 = gpspoints[i+1].getLatitude();
			double y0 = gpspoints[i+1].getLongitude();
			
			int x1 = MARGIN + (int)((y0- minlon) * xstep);
			int y1 = ybase - (int)((x0 - minlat) * ystep); 
			
			
			setColor(50, 255, 255);
			drawLine(x, y, x1, y1);
		}
	}
	
		
	}
	

	public void showStatistics() {

		int TEXTDISTANCE = 20;
		final double WEIGHT = 80.0;
		int x = MARGIN;
		int y = TEXTDISTANCE;
		setColor(0,0,0);
		setFont("Courier",12);
		
		double distanse = gpscomputer.totalDistance();
		distanse = distanse / 1000;
		
		double snittFart = gpscomputer.averageSpeed();
		snittFart = snittFart *3.6;
		
		int tid = gpscomputer.totalTime();
		String tid1 = GPSUtils.formatTime(tid);
		
		double maxFart = gpscomputer.maxSpeed();
		maxFart = maxFart *3.6;
		
	String string1 = ("Total time             :         " + tid1);
	String string2 = ("Total distanse         :         " + String.format("%.2f", distanse) + " km");
	String string3 = ("Total elevation        :         " + String.format("%.2f", gpscomputer.totalElevation()) + " m");
	String string4 = ("Max Speed              :         " + String.format("%.2f", maxFart) + " km/t");
	String string5 = ("Average Speed          :         " + String.format("%.2f", snittFart) + " km/t");
	String string6 = ("Energy                 :         " + String.format("%.2f", gpscomputer.totalKcal(WEIGHT)) + " kcal");
	
	
		drawString(string1, x, y);
		drawString(string2, x, y*2);
		drawString(string3, x, y*3);
		drawString(string4, x, y*4);
		drawString(string5, x, y*5);
		drawString(string6, x, y*6);
	}

	public void replayRoute(int ybase) {
		for (int i = 0; i < gpspoints.length - 1; i++) {
		double latitude = gpspoints[i].getLatitude();
		double longitude = gpspoints[i].getLongitude();
		int circle;
		
		int x = MARGIN + (int)((longitude - minlon) * xstep);
		int y = ybase - (int)((latitude - minlat) * ystep); 

		
		setColor(0, 0, 255);
		circle = drawCircle(x, y, 3); 
		
			double x0 = gpspoints[i+1].getLatitude();
			double y0 = gpspoints[i+1].getLongitude();
			
			int x1 = MARGIN + (int)((y0- minlon) * xstep);
			int y1 = ybase - (int)((x0 - minlat) * ystep); 
		setSpeed(10);
		moveCircle(circle, x1, y1);
		
		
	}

}
}