package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;
public class Nematode {
    private String name;
    private float length;
    private boolean legs;
    private int gender;
    private boolean eyes;

    @Override
    public String toString() {
        return "Name =" +name+", length =" +length+", legs ="+legs+ ", gender ="+gender+", eyes ="+eyes;
    }


    public Nematode(String name, float length, boolean legs, int gender, boolean eyes) {
        this.name = name;
        this.length = length;
        this.legs = legs;
        this.gender = gender;
        this.eyes = eyes;
    }

    // Take input from cvs file from visualiser file (tr)
    public Nematode(TableRow tr) {
        this(
            tr.getString("name"),
            tr.getFloat("length"),
            tr.getInt("legs") == 1,
            tr.getInt("gender"),
            tr.getInt("eyes") == 1
        );
    }

    // Encapsulation
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public boolean isLegs() {
        return legs;
    }
    public void setLegs(boolean legs) {
        this.legs = legs;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public boolean isEyes() {
        return eyes;
    }
    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser pa) {
        // Original scale
        float x = pa.width/2;
        float y = pa.height/2;
        float longboi = length;
        float size = 30;

        while(longboi > 0) {
            float nY = PApplet.map(x, x, y, x, (y*longboi)*0.5f);

            pa.stroke(255,255,255);
            pa.circle(x, nY, size);
            if (eyes && longboi == length) {
                pa.stroke(255,255,255);
                pa.line(x+size, nY, x, nY+size);
                pa.line(x-size, nY, x, nY-size);
                pa.circle(x-size, nY, size-10);
                pa.circle(x+size, nY, size-10);
            }
            if (longboi == 1) {
                if ((char)gender == 'm') {
                    pa.stroke(255,255,255);
                    pa.line(x, nY+size, x, nY+(size*2));
                    pa.circle(x, nY+(size*2), size-10);
                }
                if ((char)gender == 'f') {
                    pa.circle(x, nY, size-10);
                }
                if ((char)gender == 'h') {
                    pa.stroke(255,255,255);
                    pa.line(x, nY+size, x, nY+(size*2));
                    pa.circle(x, nY+(size*2), size-10);
                    pa.circle(x, nY, size-10);
                }
            }
            if (legs) {
                pa.stroke(255,255,255);
                pa.line(x+(size*2), nY, x+(size*3), nY);
                pa.line(x-(size*2), nY, x-(size*3), nY);
            }

            longboi--;
        }
    }
}
