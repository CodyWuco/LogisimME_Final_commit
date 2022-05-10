//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// This is the class is used to create a node on the grid using Nested Circuit Logic
package com.gamecodeschool.logicsimulator;

public class NestedCircuit extends LogicNode{
    private NestedCircuitLogic logicTree;

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // Nested circuit has to load in a
    public NestedCircuit(AbstractGridCell mycell, String saveName){
        super(mycell);
        loadLogic(saveName);
    }

    //``````````````````````````````````````````````````````````````````````````````````````````````
    // This needs to test if logic is loaded or return an error that doesn't allow node to be placed
    private void loadLogic(String saveName){
        logicTree.loadLogicCircuit(saveName);
    }

    boolean eval() {
        return logicTree.eval();
    }
}


