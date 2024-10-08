#include <cmath>   // Для функции sqrt
#include <cstdlib> // Для функции malloc и free

extern "C" {
    double* calculate_square_and_sqrt(double number) {
        // Выделяем память под массив из двух элементов
        double* result = (double*)malloc(2 * sizeof(double));

        // Если память не выделена, возвращаем NULL
        if (result == NULL) {
            return NULL;
        }

        // Первый элемент массива - квадрат числа
        result[0] = number * number;

        // Второй элемент массива - квадратный корень числа
        result[1] = sqrt(number);

        return result;
    }

    // Функция для освобождения памяти, выделенной под массив
    void free_memory(double* array) {
        free(array);
    }
}
