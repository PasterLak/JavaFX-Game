package com.game;

import com.Main;
import com.basic.ResourcesLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;

public class Cell extends HBox
{
    private Label name = new Label();
    private Label kg = new Label();
    private Label price = new Label();
    private Button button = new Button();
    private Button buttonInfo = new Button();
    private ImageView icon;
    private ImageView coinIcon = new ImageView(ResourcesLoader.getImage("sprites/UI/money.png"));
    private Slot slot;
    private Handler handler;


    private String redButton = "-fx-background-color: #f57171;";
    private String greenButton = "-fx-background-color: #9cfc8b;";
    private String yellowButton = "-fx-background-color: #eaf28f;";

    Cell(Slot slot, Mode mode)
    {
        super();

        this.slot = slot;
        handler = GameController.getInstance().spieler.getCurrentOrt().getHandler();

        icon = new ImageView(ResourcesLoader.getImage("sprites/items/" + slot.ware.name + ".png"));
        icon.setFitHeight(25);
        icon.setFitWidth(25);
        icon.setEffect(new DropShadow());

        coinIcon.setFitHeight(15);
        coinIcon.setFitWidth(15);

        name.setText("  " + slot.ware.name + " (" + slot.count + ")");
        name.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(name, Priority.ALWAYS);

        if (mode == Mode.SELL)
        {
            button.setText("sell");
            price.setText(" " + handler.getVerkaufsPreis(slot.ware.preis) + "   ");

            if (GameController.getInstance().spieler.getCurrentOrt() instanceof Dorf)
            {
                if (slot.ware instanceof Lebensmittel)
                {
                    button.setStyle(redButton);
                } else
                {

                    if(handler.getInteresse() == Handler.Interesse.keinInteresse)
                    {
                        button.setStyle(redButton);

                    }
                    else if(handler.getInteresse() == Handler.Interesse.geringesInteresse)
                    {
                        setButton(yellowButton, Mode.SELL);
                    }
                    else
                    {
                        setButton(greenButton, Mode.SELL);
                    }

                }
            } else
            {
                if (slot.ware instanceof Lebensmittel)
                {

                    if(slot.ware.name == "Speck")
                    {
                        price.setText(" " + slot.ware.preis + "   ");
                    }

                    if(handler.getInteresse() == Handler.Interesse.keinInteresse)
                    {
                        button.setStyle(redButton);
                    }
                    else if(handler.getInteresse() == Handler.Interesse.geringesInteresse)
                    {
                        setButton(yellowButton, Mode.SELL);
                    }
                    else
                    {
                        setButton(greenButton, Mode.SELL);
                    }


                } else
                {
                    button.setStyle(redButton);
                }
            }

        }
        else
        {
            button.setText("buy");
            price.setText(" " + slot.ware.preis + "   ");

            if(GameController.getInstance().spieler.getBeutel().hasEnoughMoney(slot.ware.preis))
            {
                if(GameController.getInstance().spieler.getEsel().canAddItem(slot.ware))
                {
                    setButton(greenButton, Mode.BUY);
                }
                else
                {
                    button.setStyle(redButton);
                }
            }
            else
            {
                button.setStyle(redButton);
            }

        }


        buttonInfo.setText("?");
        buttonInfo.setOnMouseEntered(e -> onMouseEntered());
        buttonInfo.setOnMouseExited(e -> onMouseExited());

        kg.setText(String.format("%.1f", slot.gewicht()) + " kg   ");
        kg.setAlignment(Pos.CENTER);
        kg.setTextAlignment(TextAlignment.CENTER);


        price.setAlignment(Pos.CENTER_LEFT);
        price.setTextAlignment(TextAlignment.LEFT);
        this.getChildren().addAll(icon, name, kg, coinIcon, price, buttonInfo, button);

        StackPane.setAlignment(kg, Pos.CENTER_LEFT);
    }

    public void buy()
    {
        AudioController.getInstance().playBuy();
        int count = 1;

        if (Main.shiftPressed)
        {
            if(slot.count >= 5)
            {
                for(int i = 5; i > 0; i--)
                {
                    if(GameController.getInstance().spieler.getBeutel().hasEnoughMoney(slot.ware.preis * i))
                    {
                        if(GameController.getInstance().spieler.getEsel().getGewicht() + i * slot.ware.gewicht <= Esel.MAX_LOAD)
                        {
                            count = i;
                            break;
                        }

                    }
                }
            }
            else
                count = slot.count;
        }

        if (GameController.getInstance().spieler.getBeutel().hasEnoughMoney(slot.ware.preis * count))
        {
            GameController.getInstance().spieler.getBeutel().removeMoney(slot.ware.preis * count);

            for(int i = 0; i < count; i++)
            GameController.getInstance().spieler.getEsel().addItem(slot.ware);

            slot.count = slot.count - count;

            if (slot.count <= 0)
                UIController.INSTANCE.inventory2.getItems().remove(this);

            GameController.getInstance().spieler.getEsel().showInventory();
            GameController.getInstance().spieler.getCurrentOrt().showInventory();

        }
    }

    public void sell()
    {
        AudioController.getInstance().playMoney();

        int count = 1;

        if (Main.shiftPressed)
        {
            if(slot.count >= 5)
            {
                count = 5;
            }
            if(slot.count > 1 & slot.count < 5)
            {
                count = slot.count;
            }
        }

        if(slot.ware.name == "Speck" && GameController.getInstance().spieler.getCurrentOrt() instanceof Stadt)
        {
            GameController.getInstance().spieler.getBeutel().addMoney(slot.ware.preis * count);
        }
        else
            GameController.getInstance().spieler.getBeutel().addMoney(handler.getVerkaufsPreis(slot.ware.preis * count));

        for(int i = 0; i < count; i++)
        GameController.getInstance().spieler.getEsel().removeItem(slot.ware);

        GameController.getInstance().spieler.getEsel().showInventory();
        GameController.getInstance().spieler.getCurrentOrt().showInventory();

    }

    private void setButton(String color, Mode mode)
    {
        if(mode == Mode.BUY)
            button.setOnAction(e -> buy());
        else
            button.setOnAction(e -> sell());

        button.setStyle(color);
    }

    private void onMouseEntered()
    {
        UIController.INSTANCE.itemInfo.setVisible(true);
        UIController.INSTANCE.itemInfo.setText(slot.ware.getDescription());
    }

    private void onMouseExited()
    {
        UIController.INSTANCE.itemInfo.setVisible(false);
    }

    enum Mode
    {
        SELL,
        BUY
    }
}