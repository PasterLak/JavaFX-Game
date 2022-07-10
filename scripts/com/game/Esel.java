package com.game;

import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.text.DecimalFormat;

public class Esel
{
    private final static byte INVENTORY_SIZE = (byte)(WarenData.waren.length + WarenData.lebensmitteln.length);
    public final static float MAX_LOAD = 100f;


    private final Slot[] waren = new Slot[INVENTORY_SIZE];
    private float warenGewicht = 0;

    private final ListView<Cell> inventory;
    private final Text inventoryText;

    public Esel()
    {
        inventory = UIController.INSTANCE.inventory;
        inventoryText = UIController.INSTANCE.inventory1Text;

        for (int i = 0; i < INVENTORY_SIZE; i++)
        {
            waren[i] = new Slot();
        }

    }

    public boolean isInventoryFull()
    {
        for (Slot slot : waren)
        {
            if (slot.count <= 0)
                return false;
        }
        return true;
    }
    public boolean isInventoryEmpty()
    {
        for (Slot slot : waren)
        {
            if (slot.count > 0)
                return false;
        }
        return true;
    }

    public void showInventory()
    {
        inventory.setDisable(false);
        inventory.setVisible(true);
        inventory.getItems().clear();

        UIController.INSTANCE.eatButton.setDisable(true);

        inventoryText.setVisible(true);
        inventoryText.setTextAlignment(TextAlignment.CENTER);
        inventoryText.setText("Inventar  " + warenGewicht + " / " + (int)MAX_LOAD + " kg");

        for (Slot slot : waren)
        {
            if (slot.count > 0)
            {
                Cell cell = new Cell(slot, Cell.Mode.SELL);

                inventory.getItems().add(cell);
            }
        }
    }

    public boolean hasFood()
    {
        if(isInventoryEmpty()) return false;

        for (Slot slot : waren)
        {
            if (slot.count > 0)
            {
                if (slot.ware instanceof Lebensmittel)
                    return true;
            }

        }
        return false;
    }

    public Lebensmittel getLebensmittel()
    {
        if(isInventoryEmpty()) return null;

        for (Slot slot : waren)
        {
            if (slot.ware instanceof Lebensmittel)
                return (Lebensmittel) slot.ware;
        }
        return null;
    }

    public void closeInventory()
    {
        inventory.setDisable(true);
        inventory.setVisible(false);
        inventoryText.setVisible(false);

    }

    public void addItem(Ware ware)
    {
        if(!canAddItem(ware)) return;
        DecimalFormat f = new DecimalFormat("#.##");

        warenGewicht = Float.parseFloat( f.format(warenGewicht + ware.gewicht));

        int slot = findSlotWithSameItem(ware);

        if(slot != -1)
            waren[slot].count++;
        else
            waren[findEmptySlot()] = new Slot(ware, 1);
    }

    public void removeItem(Ware ware)
    {
        int slot = findSlotWithSameItem(ware);

        if(slot != -1)
        {
            if(waren[slot].count > 1)
                waren[slot].count--;
            else
                waren[slot].count = 0;

            DecimalFormat f = new DecimalFormat("#.##");

            warenGewicht = Float.parseFloat( f.format(warenGewicht - ware.gewicht));
        }
    }

    public boolean canAddItem(Ware ware)
    {
        if(isInventoryFull()) return false;
        if(!enoughSpace(ware)) return false;
        if(findSlotWithSameItem(ware) != -1) return true;
        return findEmptySlot() != -1;
    }

    private boolean enoughSpace(Ware wareToAdd)
    {
        return (warenGewicht + wareToAdd.gewicht) <= MAX_LOAD;
    }

    private byte findSlotWithSameItem(Ware ware)
    {
        for (byte i = 0; i < waren.length; i++)
        {
            if(waren[i].ware == null) continue;
            if(waren[i].ware.equal(ware))
                return i;
        }
        return -1;
    }

    private byte findEmptySlot()
    {
        if(isInventoryFull()) return -1;

        for (byte i = 0; i < waren.length; i++)
        {
            if(waren[i].count <= 0)
                return i;
        }
        return -1;
    }

    public float getGewicht()
    {
        return warenGewicht;
    }

}
