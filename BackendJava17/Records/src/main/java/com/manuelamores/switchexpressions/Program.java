package com.manuelamores.switchexpressions;

public class Program {

    public static void main(String[] args) {
        Program program =  new Program();

        program.m1Basic("A");
        program.m2Arrow("B");
    }

    private void m2Arrow(String param) {

        switch (param){
            case "A" -> System.out.println("Case A");
            case "B" -> System.out.println("Case B");
            default -> System.out.println("Default case");
        }
    }

    private void m1Basic(String param) {

        switch (param) {
            case "A":
                System.out.println("Case A");
                break;
            case "B":
                System.out.println("Case B");
                break;
            default:
                System.out.println("Default case");
        }
    }
    
    
}
