#ifndef MATH_LIBRARY_H
#define MATH_LIBRARY_H

#ifdef __cplusplus
extern "C" {
#endif
// Функция для вычисления квадрата и корня числа
double* calculate_square_and_sqrt(double number);

// Функция для освобождения памяти
void free_memory(double* array);
#ifdef __cplusplus
}
#endif
#endif // MATH_LIBRARY_H
