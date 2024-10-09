package model;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface s21_model extends Library {
    s21_model INSTANCE = (s21_model) Native.load("math_library", s21_model.class);

    Pointer create_model();
    void destroy_model(Pointer model);
    void set_expression(Pointer model, String expression);

    String calculate(Pointer model);
}
