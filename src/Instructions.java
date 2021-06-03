import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Instructions extends BorderPane{
	
	Button back;
	Application game;
	BorderPane pane;
	
	public Instructions(Application game) {
		this.game = game;
		
		VBox title = new VBox();
		title.setPadding(new Insets(20, 0, 0, 0));
		
		HBox instructionsTitle = new HBox();
        
        Text titleText = new Text("Instructions");
        titleText.setFont(Font.font(null, 30));
        titleText.setFill(Color.BLACK);
        DropShadow dropShadow = new DropShadow(5, 5, 5, Color.GRAY);
        titleText.setEffect(dropShadow);
        
       instructionsTitle.getChildren().add(titleText);
       instructionsTitle.setAlignment(Pos.CENTER);
        
        Label label = new Label("Use your mouse or arrow keys to control a paddle at the bottom of the screen."
        		+ "Move the paddle right and left to prevent the ball from touching the bottom of the screen. "
        		+ "Position your paddle to hit the ball in order to destroy floating breaks. "
        		+ "Destroy all bricks to move onto the next level."
        		+ "For every brick you destroy you score increased by 100 but "
        		+ "for everytime the ball hits the floor, your score decreases by 1000."
        		+ "If your score reaches 0, the game is over."
        		+ "The high score is determined by your highest score in any level.");
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        label.setMaxWidth(450);
        label.setTranslateX(25);
        label.setTranslateY(25);
        
        title.getChildren().addAll(instructionsTitle, label);
        
		this.setTop(title); 
		
		HBox buttons = new HBox();
		buttons.setSpacing(50);
		buttons.setAlignment(Pos.CENTER);
		back = new Button("Back");
		back.setEffect(dropShadow);
		
		OnAction onAction = new OnAction();
		back.setOnAction(onAction);
		buttons.getChildren().addAll(back);
		
		this.setCenter(buttons);
	}
	
	private class OnAction implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			if(event.getSource() == back) {
				((TopGame) game).setMainMenu();
			}
		}
	}

}
