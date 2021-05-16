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

public class GameOver extends BorderPane{
	
	Button playGame;
	Button mainMenu;
	Application game;
	
	public GameOver(Application game) {
		this.game = game;
		HBox title = new HBox();
		title.setPadding(new Insets(20, 0, 0, 0));
        
        Text titleText = new Text("Game Over!");
        titleText.setFont(Font.font(null, 30));
        titleText.setFill(Color.BLACK);
        
        title.getChildren().addAll(titleText);
        title.setAlignment(Pos.CENTER);
        
		
		this.setTop(title); 
		
		HBox buttons = new HBox();
		buttons.setSpacing(50);
		buttons.setAlignment(Pos.CENTER);
		playGame = new Button("Play Again");
		mainMenu = new Button("Main Menu");
		
		OnAction onAction = new OnAction();
		playGame.setOnAction(onAction);
		mainMenu.setOnAction(onAction);
		buttons.getChildren().addAll(playGame, mainMenu);
		
		this.setCenter(buttons);
	}
	
	private class OnAction implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			if(event.getSource() == playGame) {
				((TopGame) game).setLevelOne();
			}
			if(event.getSource() == mainMenu) {
				((TopGame) game).setMainMenu();
			}
		}
	}

}
