package com.example.rou;

import Charecters.TA_Heroes.Angry;
import Charecters.TA_Heroes.Kind;
import Charecters.TA_Heroes.Useless;
import Charecters.TA_Heroes.Wise;
import Charecters.Us_Characters.Fool;
import Charecters.Us_Characters.Lazy;
import Charecters.Us_Characters.Leader;
import Charecters.Us_Characters.Nerd;
import SQL.MySQL;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;


public class MapJungleCL implements Initializable {
    public static final Object Synchronized = new Object();
    private static int X = -666;
    private static int Y = -666;
    private static int LINE = -666;


    public static Rectangle GameOverR = new Rectangle();
    @FXML
    private Rectangle YouWinR = new Rectangle();

    @FXML
    private Rectangle FoolR;

    @FXML
    private Rectangle LazyR;

    @FXML
    private Rectangle LeaderR;

    @FXML
    private Rectangle Line1BTNR;

    @FXML
    private Rectangle Line2BTNR;

    @FXML
    private Rectangle Line3BTNR;

    @FXML
    private Rectangle MenuBTNR;

    @FXML
    private AnchorPane MyMap;

    @FXML
    private Rectangle UselessR;

    @FXML
    private Rectangle WiseR;

    @FXML
    private Rectangle KindR;

    @FXML
    private Rectangle AngryR;

    @FXML
    private Rectangle NerdR;

    @FXML
    private Rectangle PlayGround;

    @FXML
    private Rectangle StartBTNR;

    Image img200 = new Image(getClass().getResource("Us_1.png").toExternalForm());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Line1BTNR.setVisible(false);
        Line2BTNR.setVisible(false);
        Line3BTNR.setVisible(false);
        LeaderR.setVisible(false);
        LazyR.setVisible(false);
        NerdR.setVisible(false);
        FoolR.setVisible(false);





        Image img1 = new Image(getClass().getResource("TA_2.png").toExternalForm());
        WiseR.setFill(new ImagePattern(img1));
        Image img2 = new Image(getClass().getResource("TA_1.png").toExternalForm());
        UselessR.setFill(new ImagePattern(img2));
        Image img3 = new Image(getClass().getResource("TA_3.png").toExternalForm());
        AngryR.setFill(new ImagePattern(img3));
        javafx.scene.image.Image img4 = new javafx.scene.image.Image(getClass().getResource("TA_4.png").toExternalForm());
        KindR.setFill(new ImagePattern(img4));

        javafx.scene.image.Image img11 = new javafx.scene.image.Image(getClass().getResource("Us_1.png").toExternalForm());
        LeaderR.setFill(new ImagePattern(img11));
        javafx.scene.image.Image img12 = new javafx.scene.image.Image(getClass().getResource("Us_2.png").toExternalForm());
        NerdR.setFill(new ImagePattern(img12));
        javafx.scene.image.Image img13 = new javafx.scene.image.Image(getClass().getResource("Us_3.png").toExternalForm());
        FoolR.setFill(new ImagePattern(img13));
        javafx.scene.image.Image img14 = new javafx.scene.image.Image(getClass().getResource("Us_4.png").toExternalForm());
        LazyR.setFill(new ImagePattern(img14));


        javafx.scene.image.Image img5 = new javafx.scene.image.Image(getClass().getResource("Line1_BTN.png").toExternalForm());
        Line1BTNR.setFill(new ImagePattern(img5));
        javafx.scene.image.Image img6 = new javafx.scene.image.Image(getClass().getResource("Line2_BTN.png").toExternalForm());
        Line2BTNR.setFill(new ImagePattern(img6));
        javafx.scene.image.Image img7 = new javafx.scene.image.Image(getClass().getResource("Line3_BTN.png").toExternalForm());
        Line3BTNR.setFill(new ImagePattern(img7));

        javafx.scene.image.Image img8 = new javafx.scene.image.Image(getClass().getResource("StartBTN_In.png").toExternalForm());
        StartBTNR.setFill(new ImagePattern(img8));
        javafx.scene.image.Image img9 = new javafx.scene.image.Image(getClass().getResource("MenuBTN.png").toExternalForm());
        MenuBTNR.setFill(new ImagePattern(img9));

        javafx.scene.image.Image img10 = new javafx.scene.image.Image(getClass().getResource("Playground.jpg").toExternalForm());
        PlayGround.setFill(new ImagePattern(img10));

        javafx.scene.image.Image img20 = new javafx.scene.image.Image(getClass().getResource("GameOverTXT.png").toExternalForm());
        MapJungleCL.GameOverR.setFill(new ImagePattern(img20));

        javafx.scene.image.Image img21 = new javafx.scene.image.Image(getClass().getResource("YouWinTXT.png").toExternalForm());
        YouWinR.setFill(new ImagePattern(img21));

    }

    @FXML
    void FoolEvent(MouseEvent event) {
        if(X!=-666)
            Fool.Fool_Us.Play(X,Y,LINE,FoolR);
    }

    @FXML
    void LazyEvent(MouseEvent event) {
        if(X!=-666)
            Lazy.Lazy_Us.Play(X,Y,LINE,LazyR);
    }

    @FXML
    void LeaderEvent(MouseEvent event) {
        if(X!=-666)
            Leader.Leader_Us.Play(X,Y,LINE,LeaderR);
    }

    @FXML
    void NerdEvent(MouseEvent event) {
        if(X!=-666)
            Nerd.Nerd_Us.Play(X,Y,LINE,NerdR);
    }


    @FXML
    void Line1Event(MouseEvent event) {
        synchronized (Synchronized) {
            X = 884;
            Y = 117;
            LINE = 0;
        }
    }

    @FXML
    void Line2Event(MouseEvent event) {
        synchronized (Synchronized) {
            X = 884;
            Y = 272;
            LINE = 1;
        }
    }

    @FXML
    void Line3Event(MouseEvent event) {
        synchronized (Synchronized) {
            X = 884;
            Y = 446;
            LINE = 2;
        }
    }

    @FXML
    void MenuEvent(MouseEvent event) throws IOException, SQLException {
        String sqlCmdRead = String.format("SELECT `Score` FROM `scoreboard` WHERE Name = '%s'", LogInMenuCL.NameLoggedIn);
        ResultSet rs = MySQL.getMySQL().ExecuteQuery(sqlCmdRead);
        rs.next();

        String SqlCmd = String.format("UPDATE scoreboard SET Score = %d WHERE Name = '%s' ", LogInMenuCL.ScoreLoggedIn + rs.getInt("Score"), LogInMenuCL.NameLoggedIn);
        MySQL.getMySQL().Execute(SqlCmd);
        Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void StartEvent(MouseEvent event) {
        StartBTNR.setVisible(false);
        Line1BTNR.setVisible(true);
        Line2BTNR.setVisible(true);
        Line3BTNR.setVisible(true);
        LeaderR.setVisible(true);
        LazyR.setVisible(true);
        NerdR.setVisible(true);
        FoolR.setVisible(true);



        Thread TAsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                double time = System.currentTimeMillis();
                while (true) {
                    Random random = new Random();
                    int RandomLineTA = random.nextInt(3);
                    int XLine;
                    int YLine;
                    if (RandomLineTA == 0) {
                        XLine = -52;
                        YLine = 114;
                    } else if (RandomLineTA == 1) {
                        XLine = -52;
                        YLine = 270;
                    } else {
                        XLine = -52;
                        YLine = 446;
                    }

                    int r = random.nextInt(4);
                    if (r == 0 && WiseR.getLayoutX() <= 0) {
                        Wise.Wise_TA.Play( XLine, YLine, RandomLineTA, WiseR);
                    }
                    else if (r == 1 && KindR.getLayoutX() <= 0) {
                        Kind.Kind_TA.Play( XLine, YLine, RandomLineTA, KindR);
                    }
                    else if (r == 2 && UselessR.getLayoutX() <= 0) {
                        Useless.Useless_TA.Play( XLine, YLine, RandomLineTA, UselessR);
                    }
                    else if (r == 3 && AngryR.getLayoutX() <= 0) {
                        Angry.Angry_TA.Play( XLine, YLine, RandomLineTA, AngryR);
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    double timeFinish = System.currentTimeMillis();

                    if((timeFinish - time) >= 60000) {
                        break;
                    }
                }
                try {
                    Thread.sleep(10000);
                    TranslateTransition transition = new TranslateTransition();
                    transition.setNode(YouWinR);
                    transition.setByY(-350);
                    transition.play();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        TAsThread.start();
    }


}
