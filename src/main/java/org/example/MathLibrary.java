package org.example;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface MathLibrary extends Library {
    MathLibrary INSTANCE = (MathLibrary) Native.load("math_library", MathLibrary.class);

    // Функция для вычисления квадрата и корня числа
    Pointer calculate_square_and_sqrt(double number);

    // Функция для освобождения памяти
    void free_memory(Pointer array);
}
