package com.game;

import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public abstract class Ort
{
    public final Text text;

    private final String name;
    private final Handler handler = new Handler(this);
    private Taetigkeit taetigkeit;
    private final Text inventoryText;

    private final ArrayList<Weg> wegs = new ArrayList<>();
    private final ListView<Cell> inventory;


    public Ort(String name, Text textObject)
    {
        this.name = name;
        text = textObject;
        text.setText(name);

        if(this instanceof Stadt) taetigkeit = new Taetigkeit("Arbeit im Laden", 5);
        if(this instanceof Dorf) taetigkeit = new Taetigkeit("Feldarbeit", 4);

        inventory = UIController.INSTANCE.inventory2;
        inventoryText = UIController.INSTANCE.inventory2Text;
    }


    public void addWeg(Ort nextOrt, int distance)
    {
        if(nextOrt == this) return;
        if(distance <= 0) return;

        if(!this.isConnectedTo(nextOrt))
        {
            wegs.add(new Weg(nextOrt, distance));

            if(!nextOrt.isConnectedTo(this))
            nextOrt.addWeg(this, distance);
        }
        else
            System.out.println("This way already exists!");
    }

    public void onClicked()
    {

        GameController.getInstance().spieler.moveTo(this);
    }

    public boolean isConnectedTo(Ort ort)
    {
        for (Weg w : wegs)
        {
            if(w.nextOrt == ort)
            {
                return true;
            }
        }
        return false;
    }

    public int getDistanceTo(Ort ort)
    {
        if(isConnectedTo(ort))
        {
            for (Weg w : wegs)
            {
                if(w.nextOrt == ort)
                {
                    return w.distance;
                }
            }
        }
        return 0;
    }

    public void showDistanceToOther(boolean show)
    {
        for (Weg w : wegs)
        {
            Ort next = w.nextOrt;

            if(show)
            {
                if(w.distance == 1)
                {
                    next.text.setText(next.name + " (" + w.distance + " Tag)");
                }
                else
                    next.text.setText(next.name + " (" + w.distance + " Tage)");
            }
            else
                next.text.setText(next.name);
        }
    }

    public void showInventory()
    {
        inventory.setDisable(false);
        inventory.getItems().clear();
        inventory.setVisible(true);

        inventoryText.setVisible(true);
        inventoryText.setText("Markt:       " + handler.getInteresse());
        inventoryText.setTextAlignment(TextAlignment.CENTER);
        inventoryText.setStyle("-fx-font-weight: bold");
        inventoryText.setStyle("-fx-font-weight: bold");

        for(int i = 0; i < handler.getWaren().length; i++)
        {
            if(handler.getWaren()[i].count > 0)
            {
                Cell cell = new Cell(handler.getWaren()[i], Cell.Mode.BUY);
                inventory.getItems().add(cell);
            }
        }

    }

    public void closeInventory()
    {
        UIController.INSTANCE.inventory2.setDisable(true);
        UIController.INSTANCE.inventory2.setVisible(false);
        inventoryText.setVisible(false);
    }

    public Handler getHandler()
    {
        return handler;
    }

    public void updateWorkButton()
    {
        UIController.INSTANCE.workButton.setText("Arbeit: " + taetigkeit.name + "\nLohn: " + taetigkeit.lohn);
    }
    public void workButton()
    {
        AudioController.click2.play();
        GameController.getInstance().spieler.getBeutel().addMoney(taetigkeit.lohn);
        GameController.getInstance().updateDays(1);
        GameController.getInstance().spieler.removeHp(1);
    }



}
