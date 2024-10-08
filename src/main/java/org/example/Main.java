package org.example;

import com.sun.jna.Pointer;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        double value = 25.0;

        // Вызываем нативную функцию и получаем указатель на результат
        Pointer resultPtr = MathLibrary.INSTANCE.calculate_square_and_sqrt(value);

        if (resultPtr != null) {
            // Преобразуем указатель в массив double длиной 2
            double[] result = resultPtr.getDoubleArray(0, 2);

            System.out.println("Value: " + value);
            System.out.println("Square: " + result[0]);
            System.out.println("Square root: " + result[1]);

            // Освобождаем память
            MathLibrary.INSTANCE.free_memory(resultPtr);
        } else {
            System.out.println("Failed to calculate.");
        }
    }
}
