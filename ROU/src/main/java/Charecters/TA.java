package Charecters;

import com.example.rou.MapJungleCL;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;

public abstract class TA extends Hero{
    public static double RamezaniOfficeHP = 300;
    public TA(int power, int speed, int health) {
        super(power, speed, health);
    }

    public void Play(int x, int y, int Line, Rectangle TA_Character)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                double StartX;
                double StartY;
                synchronized (MapJungleCL.Synchronized) {
                    StartX = TA_Character.getLayoutX();
                    StartY = TA_Character.getLayoutY();

                    Character_Hero = TA_Character;
                    Hero.TAHeroesLine[Line].add(TA.this);

                    TA_Character.setLayoutX(x);
                    TA_Character.setLayoutY(y);
                }
                double Time = (double) System.currentTimeMillis() / 1000;
                boolean t = true;
                while (true) {
                    double CurrentTime = (double) System.currentTimeMillis() / 1000;
                    if (TA_Character.getLayoutX() <= 907 && t)
                    {
                        synchronized (MapJungleCL.Synchronized) {
                            TA_Character.setLayoutX(TA_Character.getLayoutX() + ((CurrentTime - Time) * getSpeed()));
                        }
                    }
                    else if (TA_Character.getLayoutX() >= 907) {
                        synchronized (MapJungleCL.Synchronized) {
                            TA_Character.setY(0);
                            TA_Character.setY(Math.sin(6 * CurrentTime) * 10);
                            RamezaniOfficeHP -= getPower() * (CurrentTime - Time);
                            if (RamezaniOfficeHP <= 0)
                            {
                                TranslateTransition transition = new TranslateTransition();
                                transition.setNode(MapJungleCL.GameOverR);
                                transition.setByY(350);
                                transition.play();
                                break;
                            }
                        }
                    }

                    synchronized (MapJungleCL.Synchronized) {
                        t = true;
                        for (int i = 0; i < Hero.UsHeroesLine[Line].size(); i++) {
                            if (Math.abs(TA_Character.getLayoutX() - Hero.UsHeroesLine[Line].get(i).Character_Hero.getLayoutX()) <= 50) {
                                TA_Character.setY(Math.sin(6 * CurrentTime) * 10);
                                Hero.UsHeroesLine[Line].get(i).HealthInBattle -= getPower() * (CurrentTime - Time);
                                if (Hero.UsHeroesLine[Line].get(i).HealthInBattle > 0)
                                    t = false;
                            }
                        }

                        if (HealthInBattle <= 0)
                        {
                            Character_Hero.setLayoutY(StartY);
                            Character_Hero.setLayoutX(StartX);
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Time = CurrentTime;
    }
                synchronized (MapJungleCL.Synchronized) {
                    TA_Character.setY(0);
                    for (int i = 0; i < TAHeroesLine[Line].size(); i++) {
                        if (TAHeroesLine[Line].get(i) == TA.this) {
                            TAHeroesLine[Line].get(i).HealthInBattle = TAHeroesLine[Line].get(i).Health;
                            TAHeroesLine[Line].remove(i);
                        }
                    }
                }
            }
        });
        thread.start();

    }
}
