package com.game;

import com.basic.ResourcesLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class UIController
{

    public static UIController INSTANCE;

    @FXML
    private AnchorPane basic;
    @FXML
    private ImageView player;
    @FXML
    public Text moneyText;
    @FXML
    public Text daysText;
    @FXML
    public Text cityText;
    @FXML
    public Text villageText1;
    @FXML
    public Text villageText2;
    @FXML
    public Text villageText3;
    @FXML
    public Text villageText4;
    @FXML
    private Button buttonCity;
    @FXML
    private Button buttonVillage1;
    @FXML
    private Button buttonVillage2;
    @FXML
    private Button buttonVillage3;
    @FXML
    private Button buttonVillage4;
    @FXML
    public Text foodText;
    @FXML
    public Button musicButton;
    @FXML
    public Button eatButton;
    @FXML
    public ListView<Cell> inventory;
    @FXML
    public ListView<Cell> inventory2;
    @FXML
    public Text inventory1Text;
    @FXML
    public Text inventory2Text;
    @FXML
    public TextArea itemInfo;
    @FXML
    public Button tradeButton;
    @FXML
    public Button workButton;
    @FXML
    public Button restartButton;
    @FXML
    public Button waitButton;
    @FXML
    public Pane resultPane;
    @FXML
    public Label resultLabel;
    @FXML
    public Label resultText;
    @FXML
    public Button buttonBiene;

    private final ImageView musicOn = new ImageView(ResourcesLoader.getImage("sprites/UI/on.png"));
    private final ImageView musicOff = new ImageView(ResourcesLoader.getImage("sprites/UI/off.png"));

    public UIController()
    {
        if(INSTANCE == null)
        INSTANCE = this;
    }
    @FXML
    private void initialize()
    {

        buttonCity.setOnAction(e -> Map.erfurt.onClicked());
        buttonVillage1.setOnAction(e -> Map.schmalkalden.onClicked());
        buttonVillage2.setOnAction(e -> Map.eisenach.onClicked());
        buttonVillage3.setOnAction(e -> Map.weimar.onClicked());
        buttonVillage4.setOnAction(e -> Map.ilmenau.onClicked());
        eatButton.setOnAction(e -> GameController.getInstance().spieler.eatButton());
        waitButton.setOnAction(e -> GameController.getInstance().spieler.warten());
        tradeButton.setOnAction(e -> GameController.getInstance().spieler.handeln());
        musicButton.setOnAction(e -> AudioController.getInstance().musicButton());
        buttonBiene.setOnAction(e -> AudioController.getInstance().biene());

        ImageView tradeIcon = new ImageView(ResourcesLoader.getImage("sprites/UI/markt.png"));
        tradeIcon.setFitWidth(25);
        tradeIcon.setFitHeight(25);
        tradeButton.setGraphic(tradeIcon);

        musicOn.setFitWidth(25);
        musicOn.setFitHeight(25);
        musicOff.setFitWidth(25);
        musicOff.setFitHeight(25);

        ImageView eatIcon = new ImageView(ResourcesLoader.getImage("sprites/UI/essen.png"));
        eatIcon.setFitWidth(25);
        eatIcon.setFitHeight(25);
        eatButton.setGraphic(eatIcon);

        ImageView workIcon = new ImageView(ResourcesLoader.getImage("sprites/UI/arbeit.png"));
        workIcon.setFitWidth(25);
        workIcon.setFitHeight(25);
        workButton.setGraphic(workIcon);

        ImageView wartenIcon = new ImageView(ResourcesLoader.getImage("sprites/UI/warten.png"));
        wartenIcon.setFitWidth(25);
        wartenIcon.setFitHeight(25);
        waitButton.setGraphic(wartenIcon);

        inventory.setDisable(true);
        inventory.setVisible(false);
        inventory2.setDisable(true);
        inventory2.setVisible(false);
        inventory1Text.setFill(Color.BISQUE);
        inventory2Text.setFill(Color.BISQUE);

        inventory1Text.setVisible(false);
        inventory2Text.setVisible(false);

        resultPane.setDisable(true);
        resultPane.setVisible(false);

        daysText.setText("1");
        ResourcesLoader.setFontSize(workButton, 12);
        ResourcesLoader.setFontSize(musicButton, 14);

        itemInfo.setText(WarenData.lebensmitteln[0].getDescription());
        itemInfo.setVisible(false);
        setFonts();
        setUIColor(" #B6C454"); //orig

    }

    public void movePlayerSprite(double x, double y)
    {
        player.setLayoutX(x);
        player.setLayoutY(y);
    }

    private void setUIColor(String color)
    {
        waitButton.setEffect(new DropShadow());
        tradeButton.setEffect(new DropShadow());
        eatButton.setEffect(new DropShadow());
        workButton.setEffect(new DropShadow());
        musicButton.setEffect(new DropShadow());

        basic.setStyle("-fx-background-color:" + color);
        tradeButton.setStyle("-fx-background-color:" + color);
        waitButton.setStyle("-fx-background-color:" + color);
        musicButton.setStyle("-fx-background-color:" + color);
        workButton.setStyle("-fx-background-color:" + color);
        eatButton.setStyle("-fx-background-color:" + color);

        inventory1Text.setEffect(new DropShadow());
        inventory2Text.setEffect(new DropShadow());

        BackgroundImage backgroundImage = new BackgroundImage(
                ResourcesLoader.getImage("sprites/UI/button2.png", 178, 48) , BackgroundRepeat.SPACE,
                BackgroundRepeat.SPACE, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background b = new Background(backgroundImage);
        waitButton.setBackground(b);
        eatButton.setBackground(b);
        tradeButton.setBackground(b);

    }

    private void setFonts()
    {
        ResourcesLoader.setFont(daysText);
        ResourcesLoader.setFont(moneyText);
        ResourcesLoader.setFont(foodText);

        ResourcesLoader.setFont(cityText);

        ResourcesLoader.setFont(villageText1);
        ResourcesLoader.setFont(villageText2);
        ResourcesLoader.setFont(villageText3);
        ResourcesLoader.setFont(villageText4);
    }

    public void showResult()
    {
        resultPane.setDisable(false);
        resultPane.setVisible(true);
        tradeButton.setDisable(true);
        eatButton.setDisable(true);
        waitButton.setDisable(true);

        ortButtonSetDisable(true);

        UIController.INSTANCE.workButton.setDisable(true);

        restartButton.setOnAction(e -> GameController.getInstance().restart());

        resultText.setText("Tag: " + GameController.getInstance().currentDay()
        + "\nGeld: " + GameController.getInstance().spieler.getBeutel().getMoney());
    }

    public void closeResult()
    {
        resultPane.setDisable(true);
        resultPane.setVisible(false);
        tradeButton.setDisable(false);
        waitButton.setDisable(false);

        ortButtonSetDisable(false);

        UIController.INSTANCE.workButton.setDisable(false);
    }

    public void ortButtonSetDisable(boolean state)
    {
        buttonCity.setDisable(state);
        buttonVillage1.setDisable(state);
        buttonVillage2.setDisable(state);
        buttonVillage3.setDisable(state);
        buttonVillage4.setDisable(state);
    }

    public void setMusicButton(boolean state)
    {
        if(state)
            musicButton.setGraphic(musicOn);
        else
            musicButton.setGraphic(musicOff);
    }

    public void updateDays(int days)
    {
        daysText.setText(Integer.toString(days));
    }
    public void updateHp(int hp)
    {
        foodText.setText(Integer.toString(hp));
    }
    public void updateMoney(int money)
    {
        moneyText.setText(Integer.toString(money));
    }
}
