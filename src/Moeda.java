public class Moeda{
    private int id;
    private String name;
    private String acronym;
    private double value;

    public Moeda(int id, String name, String acronym, double value) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
        this.value = value;
    }

    public int getId(){
        return id;
    }

    public int setId(){
        return this.id = id;
    }

    public String getName(){
        return name;
    }

    public String setName(){
        return this.name = name;
    }

    public String getAcronym(){
        return acronym;
    }

    public String setAcronym(){
        return this.acronym = acronym;
    }

    public double getValue(){
        return value;
    }

    public double setValue(){
        return this.value = value;
    }
}
