package com.helloworld.sections.designmodel.factory;

public class GDComputerFactory extends AbstractFactory{
    @Override
    public <T extends Computer> T createComputer(Class<T> clz) {

        Computer computer = null;
        String className = clz.getName();

        try {
            computer = (Computer) Class.forName(className).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) computer;

    }
}
