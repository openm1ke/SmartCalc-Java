package org.example;

import com.sun.jna.Pointer;

public class Main {
    public static void main(String[] args) {
        Pointer model = MathLibrary.INSTANCE.create_model();

        MathLibrary.INSTANCE.set_expression(model, "2^3^2");
        String result = MathLibrary.INSTANCE.calculate(model);
        System.out.println("Calculation result: " + result);

        MathLibrary.INSTANCE.destroy_model(model);
    }
}
