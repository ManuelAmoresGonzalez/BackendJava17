package app;

import model.Car;
import model.Subaru;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Program {

    //T = Type of class
    //K = Key
    //V = Value
    //E = Element
    //? wilcard inknown // extends Object

    //Upper-bounded
    //Algo tiewne que ser menor o igual que "Car"

    //Lower-bounded
    //Algo tiewne que ser mayor o igual que "Car"

    public void m1(List<? extends Car> list){

    }
    public void m2(List<? super Car> list){

    }

    public static void main(String[] args) {

        Program app = new Program();
        List<Subaru> list = new ArrayList<>();
        List<Vehicle> list1 = new ArrayList<>();
        app.m1(list);

        app.m2(list1);
    }
}
