package org.example;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface MathLibrary extends Library {
    MathLibrary INSTANCE = (MathLibrary) Native.load("math_library", MathLibrary.class);

    Pointer create_model();
    void destroy_model(Pointer model);
    void set_expression(Pointer model, String expression);

    String calculate(Pointer model);
}
