package com.manuelamores.switchexpressions;

public class Program {

    public static void main(String[] args) {
        Program program =  new Program();

        program.m1Basic("A");
        program.m2Arrow("B");
        String result = program.m3Yield("C");
        System.out.println(result);
        program.m4ArrowReturn("B");
        program.m5MultipleCase("A");
    }

    private void m5MultipleCase(String param) {
        switch (param){
            case "A", "B" -> System.out.println("Caso a y b");
            case "C", "D" -> System.out.println("Caso c y d");
            default -> System.out.println("Ningun otro");
        }
    }

    private String m4ArrowReturn(String param) {
        return switch (param){
            case "A" -> "Case A";
            case "B" -> {
                System.out.println("Case B");
                yield "Case B";
            }
            default -> "Default case";
        };
    }

    private String m3Yield(String param) {

        return switch (param){
            case "A": yield "Case A";
            case "B": yield "Case B";
            default:  yield "Default case";
        };
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
