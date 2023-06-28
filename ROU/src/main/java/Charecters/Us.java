package Charecters;

import com.example.rou.LogInMenuCL;
import com.example.rou.MapJungleCL;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public abstract class Us extends Hero {
    int RefreshTime;

    public Us(int power, int speed, int health, int refreshTime) {
        super(power, speed, health);
        RefreshTime = refreshTime;
    }

    public void Play(int x, int y, int Line, Rectangle Us_Character) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                Rectangle Temp = new Rectangle();
//                Temp.setHeight(Us_Character.getHeight());
//                Temp.setWidth(Us_Character.getWidth());
//                Temp.setFill(new ImagePattern(image));


                double StartX;
                double StartY;
                synchronized (MapJungleCL.Synchronized) {
                    Character_Hero = Us_Character;
                    StartX = Us_Character.getLayoutX();
                    StartY = Us_Character.getLayoutY();

                    Hero.UsHeroesLine[Line].add(Us.this);

                    Us_Character.setLayoutX(x);
                    Us_Character.setLayoutY(y);
                }
                boolean t = true;
                double Time = (double) System.currentTimeMillis() / 1000;
                while (true) {
                    double CurrentTime = (double) System.currentTimeMillis() / 1000;
                    if (t) {
                        synchronized (MapJungleCL.Synchronized) {
                            Us_Character.setY(0);
                            Us_Character.setLayoutX(Us_Character.getLayoutX() - ((CurrentTime - Time) * getSpeed()));
                        }
                    }

                    synchronized (MapJungleCL.Synchronized) {
                        t = true;
                        for (int i = 0; i < Hero.TAHeroesLine[Line].size(); i++) {
                            RotateTransition transition = new RotateTransition();
                            if (Math.abs(Us_Character.getLayoutX() - Hero.TAHeroesLine[Line].get(i).Character_Hero.getLayoutX()) <= 50) {
                                Us_Character.setY(Math.sin(6 * CurrentTime) * 10);
                                Hero.TAHeroesLine[Line].get(i).HealthInBattle -= getPower() * (CurrentTime - Time);
                                LogInMenuCL.ScoreLoggedIn += ((CurrentTime - Time) * 10);
                                if (Hero.TAHeroesLine[Line].get(i).HealthInBattle > 0)
                                    t = false;
                            }
                            transition.pause();
                        }
                        if (HealthInBattle <= 0 || Us_Character.getLayoutX() <= 10) {
                            Character_Hero.setLayoutX(StartX);
                            Character_Hero.setLayoutY(StartY);
                            break;
                        }
                    }

                    Time = CurrentTime;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (MapJungleCL.Synchronized) {
                    Us_Character.setY(0);
                    for (int i = 0; i < UsHeroesLine[Line].size(); i++) {
                        if (UsHeroesLine[Line].get(i) == Us.this) {
                            UsHeroesLine[Line].get(i).HealthInBattle = UsHeroesLine[Line].get(i).Health;
                            UsHeroesLine[Line].remove(i);
                        }
                    }
                }
            }
        });

        thread.start();
    }
}