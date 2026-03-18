public class Ydelser {
    private String name;
    private int pris;

    public Ydelser(String name, int pris) {
        this.name = name;
        this.pris = pris;
    }

    public String toString() {
        return this.name + " " + this.pris + " dkk,-";
    }

    public String getName() {
        return this.name;
    }

    public int getPris() {
        return this.pris;
    }
}