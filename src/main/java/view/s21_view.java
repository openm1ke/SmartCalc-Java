package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.s21_model;
import viewmodel.s21_viewmodel;

import java.io.IOException;

public class s21_view extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/calculator.fxml"));
        Parent root = loader.load();

        s21_viewmodel viewModel = loader.getController();
        viewModel.setModel(s21_model.INSTANCE.create_model());

        primaryStage.setTitle("Calculator v3.0");
        primaryStage.setScene(new Scene(root, 890, 360));
        primaryStage.setOnCloseRequest(event -> {
            // Вызываем уничтожение модели перед закрытием
            s21_model.INSTANCE.destroy_model(viewModel.getModel());
        });
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
