public class Guest {

    private String name;
    private int antalPaddleboard;
    private int antalMorgenmad;

    //constructor
    public Guest(String name, int antalPaddleboard, int antalMorgenmad) {
        this.name = name;
        this.antalPaddleboard = antalPaddleboard;
        this.antalMorgenmad = antalMorgenmad;

    }

    public String toString() {
        String s = this.name +": Paddelboard brugt ";
        s += this.antalPaddleboard + " gange, morgenmad bestilt ";
        s += this.antalMorgenmad + " gange.";
        return s;
    }

    //getters
    public String getName(){
        return this.name;
    }
    public int getAntalPaddleboard(){
        return this.antalPaddleboard;
    }
    public int getAntalMorgenmad(){
        return this.antalMorgenmad;
    }

}
