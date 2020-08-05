package gawron.b.catancalculatorjava.model;

public class Player {

    public String name;
    public String lastName;
    public int color;
    public int score=0;

    public Player(String name, String lastName, int color, int score) {
        this.name = name;
        this.lastName = lastName;
        this.color = color;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
