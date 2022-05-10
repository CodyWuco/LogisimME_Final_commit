package com.gamecodeschool.logicsimulator;


import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

import static android.content.Context.MODE_PRIVATE;

public class NestedCircuitLogic {
    private Context context;
    // head is used to find the output and to keep track of the starting point of the circuit
    private LogicNode head;
    // this list is used to save and load the tree without excessive logic
    private List<LogicNode> tree;
    // this vector is used to keep track of the open input slots
    private Vector<AbstractGridCell> inputs;

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This takes in a save name and loads the correct circuit
    public NestedCircuitLogic(String saveName, LogicNode head) {
        createCopyFromCircuit(head);
        // passes in name of the circuit for file storage
        loadLogicCircuit(saveName);
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This creates a copy of a circuits logic. Then is removes the switches and LED nodes, and
    // creates a vector of the avaibable inputs.
    private boolean createCopyFromHead(LogicNode head) {
        // if not LED and not switch create circuit
        if (head instanceof LightNode) {
            // passes in the input of the lightnode to be turned into the head of the circuit
            return createCopyFromHead(head.getA());
        }
        else if (head instanceof SwitchNode) {
            return false;
        }
        else {
            createCopyFromCircuit(head);
            return true;
        }

    }
    private boolean createCopyFromCircuit(LogicNode logicNode) {
        // if null or switch add to inputs
        if((logicNode == null) || (logicNode instanceof SwitchNode)){
            return false;
        }
        if(head == null){ head = tree.get(0);}

        tree.add(new LightNode(logicNode));

        checkAndContinue(logicNode.getA());
        checkAndContinue(logicNode.getB());

        return true;
    }

    // check if leaf is null while continuing traversal
    private void checkAndContinue(LogicNode logicNode){
        if(!createCopyFromCircuit(logicNode.getA())){ setLeafToInput(logicNode);}
    }

    private void setLeafToInput(LogicNode logicNode){
        //add empty node to inputs
        LogicNode temp = new SwitchNode((new EmptyGridCell(-1,-1,-1,-1)));
        inputs.add(temp);
        //point logic node input A to it
        logicNode.setA(temp);
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This save the circuit to a file using a string
    // function that saves tree to a file as a List. This will work since the Logic nodes keep
    // track of their own tree.
    private void saveLogicCurcuit(Context context, Vector Cells, String fileName) {
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

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This loads a previously saved CircuitTree and sets head to the head of the tree
    public void loadLogicCircuit(String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            inputs = (Vector<AbstractGridCell>) ois.readObject();
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
    // create a function to keep track of the the tree on loads

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // Starts the eval of the logic tree
    public boolean eval() {
        return head.eval();
    }
}

