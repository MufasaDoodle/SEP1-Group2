import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ExamPlanner extends Application
{
  public void start(Stage window) throws IOException
  {
    window.setTitle("Exam Planner");
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("ks.fxml"));
    Scene scene = new Scene(loader.load());
    window.setScene(scene);
    window.setResizable(false);
    window.show();
  }
}

