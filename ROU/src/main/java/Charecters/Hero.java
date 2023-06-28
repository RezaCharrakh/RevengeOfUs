package Charecters;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class Hero extends Node {
    final int Power;
    final int Speed;
    final int Health;
    int HealthInBattle;

    Rectangle Character_Hero;
    static ArrayList<Us>[] UsHeroesLine = new ArrayList[] { new ArrayList<Us>(), new ArrayList<Us>(), new ArrayList<Us>() };
    static ArrayList<TA>[] TAHeroesLine = new ArrayList[] { new ArrayList<TA>(), new ArrayList<TA>(), new ArrayList<TA>()};

    public Hero(int power, int speed, int health) {
        Power = power;
        Speed = speed;
        Health = health;
        HealthInBattle = health;
    }

    public int getPower() {
        return Power;
    }

    public int getSpeed() {
        return Speed;
    }


}
