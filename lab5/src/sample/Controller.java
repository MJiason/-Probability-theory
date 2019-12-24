package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    private float firstNodIntensity;
    private float secondNodIntensity;
    @FXML
    private TextField Intensity1;
    @FXML
    private TextField Intensity2;
    @FXML
    private Button Calculate;
    @FXML
    private TextArea outputArea;

    public void countValues() throws IOException {
        if (Intensity1.getText().isEmpty() || Intensity2.getText().isEmpty())
            return;
        firstNodIntensity = Float.parseFloat(Intensity1.getText());
        secondNodIntensity = Float.parseFloat(Intensity2.getText());
        Model model = new Model(1, firstNodIntensity, secondNodIntensity);
        TheoreticProb tp= new TheoreticProb(firstNodIntensity, secondNodIntensity);
        showNewDialog(model.getFirstImagNodeTime(), model.getSecondImagNodeTime(), model.getThirdImagNodeTime(),
                model.getFourthImagNodeTime(), tp.getTheoreticProbability1(), tp.getTheoreticProbability2());
//        outputArea.appendText(String.valueOf(model.getFirstNodProbability()));
//        outputArea.insertText(2, String.valueOf(model.getSecondNodProbability()));

    }

    public void showNewDialog(double result1, double result2, double result3, double result4, double result5, double result6) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DialogPane.fxml"));
        Parent parent = fxmlLoader.load();
        Controller dialogController = fxmlLoader.<Controller>getController();

        dialogController.outputArea.appendText(String.format("Практичне значення\nУявна вершина 1: %s" +
                        "\nУявна вершина 2: %s\nВершина 1: %s:\nУявна вершина 3: %s\nУявна вершина 4: %s" +
                        "\nВершина 2: %s\n\nТеоретичне значення\nВершина 1: %s\nВершина 2: %s",
                String.valueOf(result1), String.valueOf(result2),String.valueOf(result1 + result2),
                String.valueOf(result3), String.valueOf(result4),String.valueOf(result3 + result4), String.valueOf(result5),
                String.valueOf(result6)));

        Scene scene = new Scene(parent, 300, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}




