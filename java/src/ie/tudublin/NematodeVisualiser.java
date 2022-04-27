package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	// Create array list composed of only nematode-classed objects
	ArrayLife<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();				
	}
	

	public void loadNematodes() {
		Table file = loadTable("nematodes.csv", "header");
		for (TableRow r:file.rows()) {
			Nematode n = new Nematode(r);
			nematodes.add(s);
		}
	}


	public void draw()
	{	
	}
}
