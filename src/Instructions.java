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

public class Instructions extends BorderPane{
	
	Button back;
	Application game;
	BorderPane pane;
	
	public Instructions(Application game, BorderPane pane) {
		this.game = game;
		HBox title = new HBox();
		title.setPadding(new Insets(20, 0, 0, 0));
        
        Text titleText = new Text("Instructions");
        titleText.setFont(Font.font(null, 30));
        titleText.setFill(Color.BLACK);
        
        title.getChildren().addAll(titleText);
        title.setAlignment(Pos.CENTER);
        
		
		this.setTop(title); 
		
		HBox buttons = new HBox();
		buttons.setSpacing(50);
		buttons.setAlignment(Pos.CENTER);
		back = new Button("Back");
		
		OnAction onAction = new OnAction();
		back.setOnAction(onAction);
		buttons.getChildren().addAll(back);
		
		this.setCenter(buttons);
	}
	
	private class OnAction implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			if(event.getSource() == back) {
				((TopGame) game).setLevelOne();
			}
		}
	}

}
