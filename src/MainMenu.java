import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainMenu extends BorderPane{
	
	Button playGame;
	Button instructions;
	Application game;
	
	public MainMenu(Application game) {
		this.game = game;
		HBox title = new HBox();
		title.setPadding(new Insets(20, 0, 0, 0));
        
        Text titleText = new Text("Aditya's Breakout!");
        titleText.setFont(Font.font(null, 30));
        titleText.setFill(Color.BLACK);
        
        title.getChildren().addAll(titleText);
        title.setAlignment(Pos.CENTER);
        
		
		this.setTop(title); 
		
		HBox buttons = new HBox();
		buttons.setSpacing(50);
		buttons.setAlignment(Pos.CENTER);
		playGame = new Button("Play Game");
		instructions = new Button("Instructions");
		
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
