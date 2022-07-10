package com.game;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class Spieler
{
    private static final byte MAX_HP  = 100;
    private static final byte HUNGER  = 20;

    private final Ort startOrt;
    private Ort currentOrt;

    private byte hp = MAX_HP;

    private Beutel beutel = new Beutel();
    private Esel esel = new Esel();

    private boolean amHandeln = false;

    public Spieler(Ort startOrt)
    {
        this.startOrt = startOrt;

        moveTo(startOrt);

        if(!esel.hasFood())
        {
            UIController.INSTANCE.eatButton.setDisable(true);
        }
    }
    public void moveTo(Ort ortToTravel)
    {
        if(currentOrt == null)
        {
            currentOrt = ortToTravel;
            ortToTravel.text.setEffect(new DropShadow());
            currentOrt.text.setFill(Color.RED);
            currentOrt.showDistanceToOther(true);
        }

        if(currentOrt.isConnectedTo(ortToTravel))
        {
            AudioController.getInstance().playJump();
            GameController.getInstance().updateDays(currentOrt.getDistanceTo(ortToTravel));
            removeHp((byte) currentOrt.getDistanceTo(ortToTravel));

            currentOrt.text.setFill(ortToTravel.text.getFill());
            ortToTravel.text.setFill(Color.RED);
            currentOrt.text.setEffect(null);
            ortToTravel.text.setEffect(new DropShadow());
            currentOrt.showDistanceToOther(false);
            ortToTravel.showDistanceToOther(true);
            currentOrt = ortToTravel;

            UIController.INSTANCE.movePlayerSprite(currentOrt.text.getLayoutX() + 80, currentOrt.text.getLayoutY()+ 50);

        }
        currentOrt.updateWorkButton();
        UIController.INSTANCE.workButton.setOnAction(e -> currentOrt.workButton());

    }

    public void warten()
    {
        AudioController.click2.play();
        removeHp(1);
        GameController.getInstance().updateDays(1);
    }

    private void eat(Lebensmittel food)
    {
        esel.removeItem(food);
        hp += Lebensmittel.HP_RESTORE;

        UIController.INSTANCE.foodText.setText(hp + "");
        GameController.getInstance().updateDays(1);

        if(hp > MAX_HP)
        {
            GameController.getInstance().endGame();
            AudioController.directed.play();
            UIController.INSTANCE.resultLabel.setText("Du bist gestorben");
        }
    }

    public void eatButton()
    {

        if(esel.hasFood())
        {
            AudioController.getInstance().playEat();
            Lebensmittel food = esel.getLebensmittel();

            if(food != null)
                eat(food);

            if(!esel.hasFood())
                UIController.INSTANCE.eatButton.setDisable(true);

        }

    }

    public void handeln()
    {
        if(currentOrt == null) return;

        if(!amHandeln)
        {
            esel.showInventory();
            currentOrt.showInventory();
            UIController.INSTANCE.ortButtonSetDisable(true);
            UIController.INSTANCE.workButton.setDisable(true);
            UIController.INSTANCE.waitButton.setDisable(true);
            AudioController.chest.play();
            amHandeln = true;
        }
        else
        {
            esel.closeInventory();
            currentOrt.closeInventory();
            UIController.INSTANCE.ortButtonSetDisable(false);
            UIController.INSTANCE.workButton.setDisable(false);
            UIController.INSTANCE.waitButton.setDisable(false);
            AudioController.villager.play();
            removeHp(1);
            GameController.getInstance().updateDays(1);

            UIController.INSTANCE.eatButton.setDisable(!esel.hasFood());

            amHandeln = false;
        }

    }

    public void removeHp(int days)
    {
        hp -= (byte)(HUNGER * days);

        if(hp <= 0)
        {
            hp = 0;
            GameController.getInstance().endGame();
            AudioController.directed.play();
            UIController.INSTANCE.resultLabel.setText("Du bist gestorben");
        }

        updateUI();
    }

    public Esel getEsel()
    {
        return esel;
    }
    public Beutel getBeutel()
    {
        return beutel;
    }
    public Ort getCurrentOrt()
    {
        return currentOrt;
    }

    public void updateUI()
    {
        UIController.INSTANCE.updateHp(hp);
    }

    public void restart()
    {
        AudioController.directed.stop();
        beutel = new Beutel();
        hp = MAX_HP;
        esel = new Esel();

        moveTo(startOrt);
        hp = MAX_HP;
        updateUI();

        UIController.INSTANCE.eatButton.setDisable(true);

        UIController.INSTANCE.resultLabel.setText("Ergebnis");
    }

}
