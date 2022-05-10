package com.gamecodeschool.logicsimulator;

public class ClickInterface {
    AbstractGridCell AndSelection;
    Grid grid;

    ClickInterface(){
        AbstractGridCell fakeGridNode = new EmptyGridCell(1, 1, 1, 1);
        AndSelection = new AndIcon(fakeGridNode);



    }

    public void setGrid(Grid grid){
        grid = this.grid;
    }

    public void setSelectionAnd(){
        grid.selected = AndSelection;

    }
}
