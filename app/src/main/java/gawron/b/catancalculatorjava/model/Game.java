package gawron.b.catancalculatorjava.model;

import java.util.List;

public class Game {

    public int village=0;
    public int city=0;
    public int road=0;
    public int pointsFromSpecialCard=0;
    List<Player> player;

    public Game(int village, int city, int road, int pointsFromSpecialCard, List<Player> player) {
        this.village = village;
        this.city = city;
        this.road = road;
        this.pointsFromSpecialCard = pointsFromSpecialCard;
        this.player = player;
    }

    public int getVillage() {
        return village;
    }

    public void setVillage(int village) {
        this.village = village;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getRoad() {
        return road;
    }

    public void setRoad(int road) {
        this.road = road;
    }

    public int getPointsFromSpecialCard() {
        return pointsFromSpecialCard;
    }

    public void setPointsFromSpecialCard(int pointsFromSpecialCard) {
        this.pointsFromSpecialCard = pointsFromSpecialCard;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}
