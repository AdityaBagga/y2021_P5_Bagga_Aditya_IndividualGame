import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TopGame extends Application {
	
	Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	this.stage = stage;
        stage.setTitle("Aditya's Breakout");

        MainMenu rootNode = new MainMenu(this);
        
        Scene scene = new Scene(rootNode, 500, 500);
        stage.setScene(scene);
        stage.show();

    }
    
    public void setLevelOne() {
    	System.out.println("Level One Started");
    	
    	LevelOne level1 = new LevelOne(this);
        //level1.setPrefSize(500, 500);
    	Scene scene = new Scene(level1, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    
    public void setLevelTwo() {
    	System.out.println("Level Two Started");
    	
    	LevelTwo level2 = new LevelTwo(this);
        //level1.setPrefSize(500, 500);
    	Scene scene = new Scene(level2, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

}
