package de.fhpotsdam.unfolding.examples.distance;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.utils.GeoUtils;
import de.fhpotsdam.unfolding.utils.MapUtils;





public class GetDistanceApp extends PApplet {
	
	UnfoldingMap map;
	
	
	public void setup() {
		size(600, 600);
		
		map = new UnfoldingMap(this);
		map.zoomAndPanTo(new Location(52.5f, 13.4f), 10);
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	
	public void draw() {
		background(255);
		
		map.draw();
		
		Location mainLocation = new Location(52.52f, 13.42f);
		float[] p1 = map.getScreenPositionFromLocation(mainLocation);
		float tempSize = getDistance(mainLocation, 5f);
		
		fill(255, 255, 0, 127);
		ellipse(p1[0], p1[1], tempSize, tempSize);
	}
	
	
	public float getDistance(Location mainLocation, float size){
		Location tempLocation = GeoUtils.getDestinationLocation(mainLocation, 90, size);
		float[] p1 = map.getScreenPositionFromLocation(mainLocation);
		float[] p2 = map.getScreenPositionFromLocation(tempLocation);
		return dist(p1[0], p1[1], p2[0], p2[1]);
	}
	
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"de.fhpotsdam.unfolding.examples.animation.GetDistanceApp"});
	}
	
}