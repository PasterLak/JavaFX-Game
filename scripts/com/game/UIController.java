package com.game;

import com.basic.ResourcesLoader;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class UIController
{

    public static UIController INSTANCE;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView background;
    @FXML
    public Text moneyText;

    @FXML
    public Button button1;

    @FXML
    public Text daysText;

    @FXML
    private ImageView moneyIcon;

    @FXML
    private ImageView daysIcon;

    @FXML
    private ImageView foodIcon;

    @FXML
    public Text foodText;

    public UIController()
    {
        if(INSTANCE == null)
        INSTANCE = this;

    }

    @FXML
    private void initialize()
    {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'UI.fxml'.";

        button1.setOnAction(event -> GameController.getInstance().nextDay());

        daysText.setFont(ResourcesLoader.getFont("fonts/new.ttf", daysText.getFont().getSize()));
        moneyText.setFont(ResourcesLoader.getFont("fonts/new.ttf", moneyText.getFont().getSize()));
        foodText.setFont(ResourcesLoader.getFont("fonts/new.ttf", foodText.getFont().getSize()));
        button1.setFont(ResourcesLoader.getFont("fonts/new.ttf", button1.getFont().getSize()));

        daysText.setText("1");

        loadResources();

    }

    private void loadResources()
    {
        moneyIcon.setImage(ResourcesLoader.getImage("sprites/UI/money.png"));
        daysIcon.setImage(ResourcesLoader.getImage("sprites/UI/day.png"));
        foodIcon.setImage(ResourcesLoader.getImage("sprites/UI/apple.png"));
        background.setImage(ResourcesLoader.getImage("sprites/map/background.png"));
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
