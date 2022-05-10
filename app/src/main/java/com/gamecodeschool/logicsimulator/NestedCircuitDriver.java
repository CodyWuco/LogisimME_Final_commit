package com.gamecodeschool.logicsimulator;

public class NestedCircuitDriver {

    NestedCircuitDriver(){
        AbstractGridCell fakeGridNode = new EmptyGridCell(1, 1, 1, 1);
        LogicNode and1 = new AndNode(fakeGridNode);
        LogicNode and2 = new AndNode(fakeGridNode);
        LogicNode not1 = new NotNode(fakeGridNode);
        LogicNode or1 = new OrNode(fakeGridNode);
        LogicNode switch1 = new SwitchNode(fakeGridNode);
        LogicNode switch2 = new SwitchNode(fakeGridNode);
        LogicNode switch3 = new SwitchNode(fakeGridNode);
        LogicNode switch4 = new SwitchNode(fakeGridNode);
        LogicNode LED1 = new LightNode(fakeGridNode);

        // set up basic circuit
        and1.setInput(switch1); and1.setInput(switch2);
        or1.setInput(switch3); or1.setInput(switch4);
        not1.setInput(or1);
        and2.setInput(and1); and2.setInput(or1);
        LED1.setInput(and2);


        // copy the circuit into a nested circuit logic
        NestedCircuitLogic ncl = new NestedCircuitLogic("test Node", and2);


    }
}
