import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainMenu extends BorderPane{
	
	Button playGame;
	Button instructions;
	Application game;
	int highScore = 0;
	
	public MainMenu(Application game) {
		this.game = game;
		HBox title = new HBox();
		title.setPadding(new Insets(20, 0, 0, 0));
		
		HBox score = new HBox();
		score.setPadding(new Insets(5, 0, 0, 0));
		
		VBox titleV = new VBox();
        
        Text titleText = new Text("Aditya's Breakout!");
        titleText.setFont(Font.font(null, 30));
        titleText.setFill(Color.BLACK);
        DropShadow dropShadow = new DropShadow(5, 5, 5, Color.GRAY);
        titleText.setEffect(dropShadow);
        
        Text highScore = new Text("High score: ");
        highScore.setFont(Font.font(null, 20));
        highScore.setFill(Color.BLACK);
        DropShadow dropShadow1 = new DropShadow(5, 5, 5, Color.GRAY);
        highScore.setEffect(dropShadow1);
  
        title.getChildren().addAll(titleText);
        title.setAlignment(Pos.CENTER);
        
        score.getChildren().addAll(highScore);
        score.setAlignment(Pos.CENTER);
        
        titleV.getChildren().addAll(title, score);
        
		this.setTop(titleV);
		
		HBox buttons = new HBox();
		buttons.setSpacing(50);
		buttons.setAlignment(Pos.CENTER);
		playGame = new Button("Play Game");
		playGame.setEffect(dropShadow);
		instructions = new Button("Instructions");
		instructions.setEffect(dropShadow);
		
		OnAction onAction = new OnAction();
		playGame.setOnAction(onAction);
		instructions.setOnAction(onAction);
		buttons.getChildren().addAll(playGame, instructions);
		
		this.setCenter(buttons);
	}
	
	private class OnAction implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			if(event.getSource() == playGame) {
				((TopGame) game).setLevelOne();
			}
			if(event.getSource() == instructions) {
				((TopGame) game).setInstructions();
			}
		}
	}

}
