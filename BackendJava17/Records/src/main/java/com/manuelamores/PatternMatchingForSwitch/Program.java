package com.manuelamores.PatternMatchingForSwitch;

import com.manuelamores.switchexpressions.Client;

public class Program {

    public static void main(String[] args) {
        Program app = new Program();
        Client client = new Client();
        String stringValue = "Hola";
        //String valor = app.m1PatternMatch(1);
        //System.out.println(valor);
        System.out.println(app.m2NullCase("new Client()"));
    }

    private Object m2NullCase(Object param) {
        return switch (param){
            case String a -> "Case string";
            case Integer b when b>30 -> "Case integer";
            case Client c when c.getId() > 30-> "Case client";
            case null -> "Case null";
            default -> throw new ArithmeticException();
        };
    }

    private String m1PatternMatch(Object param) {

        return switch(param){
            case String a -> "Case string";
            case Client b -> "Case client";
            case Integer c -> "Case Integer";
            default -> "Opción invalida";
        };
    }
}
