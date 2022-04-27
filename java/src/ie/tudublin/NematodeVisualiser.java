package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {

	// Create array list composed of only nematode-classed objects
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed() {	
		int count = 0;	
		if (keyCode == LEFT) {
			count--;
			if (count < 0) {
                count = count % nematodes.size();
            }
			draw(count);
		}		
		if (keyCode == RIGHT) {
			count++;
			if (count > nematodes.size()) {
            	count = count % nematodes.size();
            }
			draw(count);
		}
	}


	public void settings() {
		size(800, 800);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();				
	}
	

	public void loadNematodes() {
		Table file = loadTable("nematodes.csv", "header");
		for (TableRow r:file.rows()) {
			Nematode n = new Nematode(r);
			nematodes.add(n);
		}
	}

	public void draw(int count) {
		drawNematode(count);
	}

	public void drawNematode(int count) {
		nematodes.get(count).render(this);
	}
}
