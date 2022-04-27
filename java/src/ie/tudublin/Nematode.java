package tudublin.ie;
import processing.core.PApplet;
import processing.data.TableRow;
public class Nematode {
    private String name;
    private float length;
    private boolean legs;
    private char gender;
    private boolean eyes;


    public Nematode(String name, float length, boolean legs, char gender, boolean eyes) {
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
            tr.getChar("gender"),
            tr.getInt("eyes") == 1
        );
    }

    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }
    public float getLength() {
        return length;
    }
    public void setLength() {
        this.length = length;
    }
    public boolean isLegs() {
        return legs;
    }
    public void setLegs() {
        this.legs = legs;
    }
    public char getGender() {
        return gender;
    }
    public void setGender() {
        this.gender = gender;
    }
    public boolean isEyes() {
        return eyes;
    }
    public void setEyes() {
        this.eyes = eyes;
    }
}
