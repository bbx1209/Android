package com.helloworld.sections.designmodel.factory;


public class Factory {

    public static Computer createComputer(int type) {
        Computer computer = null;
        switch (type) {
            case 1:
                computer = new LenovoComputer();
                break;
            case 2:
                computer = new HpComputer();
                break;
            default:
        }
    }

}
