package com.gamecodeschool.logicsimulator;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import static android.content.Context.MODE_PRIVATE;

public class AbstractGridCellSaves {

    AbstractGridCellSaves(){ }


    //``````````````````````````````````````````````````````````````````````````````````````````````
    // Save and Load need to be separated into a saves class to be reused in Nested circuit
    public void Save(Context context, Vector Cells, String fileName) {
        try {
            FileOutputStream fos = context.openFileOutput(fileName, MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Cells);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // This code does not properly pass vectors around
    public void Load(Context context, Vector<AbstractGridCell> cells, String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cells = (Vector<AbstractGridCell>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }
    }
}
