package viewmodel;

import com.sun.jna.Pointer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.s21_model;

public class s21_viewmodel {

    @FXML
    private TextField expressionEdit;

    @FXML
    private TextField xInputField;

    @FXML
    private TextArea resultArea;

    @FXML
    private LineChart<Number, Number> lineChart;

    private Pointer model;

    public void setModel(Pointer model) {
        this.model = model;
    }

    public Pointer getModel() {
        return model;
    }

    // Метод, который будет вызываться по нажатию кнопки "="
    @FXML
    private void calculate() {
        String expression = expressionEdit.getText();
        s21_model.INSTANCE.set_expression(model, expression);
        try {
            String result = s21_model.INSTANCE.calculate(model);
            resultArea.appendText(result + "\n"); // Отображаем результат
        } catch (Exception e) {
            resultArea.setText("Ошибка: " + e.getMessage()); // Обработка ошибок
        }
    }

    @FXML
    private void onButtonClick(ActionEvent event) {
        // Получаем текст кнопки
        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();
        appendExpression(buttonText);
    }

    @FXML
    private void onButtonClear() {
        expressionEdit.clear();
    }

    @FXML
    private void onButtonMod() {
        expressionEdit.appendText("%");
    }

    @FXML
    private void onButtonPow() {
        expressionEdit.appendText("^");
    }

    @FXML
    private void onButtonDivide() {
        expressionEdit.appendText("/");
    }

    @FXML
    private void onButtonLog() {
        expressionEdit.appendText("log(");
    }

    @FXML
    private void onButtonLn() {
        expressionEdit.appendText("ln(");
    }

    @FXML
    private void onButtonSqrt() {
        expressionEdit.appendText("sqrt(");
    }

    @FXML
    private void onButtonMultiply() {
        expressionEdit.appendText("*");
    }

    @FXML
    private void onButtonPlus() {
        expressionEdit.appendText("+");
    }

    @FXML
    private void onButtonMinus() {
        expressionEdit.appendText("-");
    }

    @FXML
    private void onButtonSin() {
        expressionEdit.appendText("sin(");
    }

    @FXML
    private void onButtonAsin() {
        expressionEdit.appendText("asin(");
    }

    @FXML
    private void onButtonCos() {
        expressionEdit.appendText("cos(");
    }

    @FXML
    private void onButtonAcos() {
        expressionEdit.appendText("acos(");
    }

    @FXML
    private void onButtonTan() {
        expressionEdit.appendText("tan(");
    }

    @FXML
    private void onButtonAtan() {
        expressionEdit.appendText("atan(");
    }

    @FXML
    private void onButtonX() {
        expressionEdit.appendText("x");
    }

    @FXML
    private void onButtonPlusMinus() {
        String currentExpression = expressionEdit.getText();

        if (currentExpression.isEmpty()) {
            return; // Если ничего нет в поле ввода, ничего не делаем
        }

        // Найдем позицию последнего числа
        int lastNumberStartIndex = findLastNumberStartIndex(currentExpression);
        if (lastNumberStartIndex == -1) {
            return; // Нет числа для изменения
        }

        String beforeNumber = currentExpression.substring(0, lastNumberStartIndex);
        String lastNumber = currentExpression.substring(lastNumberStartIndex);

        // Проверяем, является ли последнее число отрицательным
        if (lastNumber.startsWith("-")) {
            // Убираем минус
            lastNumber = lastNumber.substring(1);
        } else {
            // Добавляем минус
            lastNumber = "-" + lastNumber;
        }

        // Обновляем текст в поле
        expressionEdit.setText(beforeNumber + lastNumber);
    }

    private int findLastNumberStartIndex(String expression) {
        // Поиск индекса начала последнего числа в выражении
        int index = expression.length() - 1;

        // Пропускаем все не числовые символы (операции, пробелы и т.д.)
        while (index >= 0 && !Character.isDigit(expression.charAt(index)) && expression.charAt(index) != '-') {
            index--;
        }

        // Пропускаем цифры для нахождения начала числа
        while (index >= 0 && (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
            index--;
        }

        // Вернем индекс начала числа (следующий символ после нецифрового)
        return index + 1;
    }


    @FXML
    private void handleNumericInput(KeyEvent event) {
        String input = xInputField.getText();
        String character = event.getCharacter();

        // Разрешаем ввод только цифр, десятичной точки
        if (!input.matches("[-]?\\d*(\\.\\d*)?") && !isControlKey(event.getCode())) {
            // Если текущее значение не соответствует числовому формату, откатить на один символ
            xInputField.setText(input.substring(0, input.length() - 1));
            xInputField.positionCaret(input.length() - 1); // Установить курсор на конец строки
        }
    }

    // Метод для проверки, является ли нажатая клавиша управляющей (например, Backspace)
    private boolean isControlKey(KeyCode code) {
        return code.isFunctionKey() || code.isNavigationKey() || code == KeyCode.BACK_SPACE || code == KeyCode.DELETE || code == KeyCode.ENTER;
    }

    @FXML
    private void onButtonRemove() {
        String expression = expressionEdit.getText();
        if (!expression.isEmpty()) {
            expressionEdit.setText(expression.substring(0, expression.length() - 1));
        }
    }


    private void appendExpression(String value) {
        expressionEdit.appendText(value);
    }
}
