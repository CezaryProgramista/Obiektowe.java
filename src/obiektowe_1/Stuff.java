package obiektowe_1;

public class Stuff {

    String name;
    int weight;

    public Stuff(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "przedmiot nazywa sie : " + this.name + " ma wagê : " + this.weight;
    }


}
