import javafx.scene.image.Image;

public class Brick extends Actor{
    public Brick(String name){
        String path = getClass().getClassLoader().getResource(name).toString();
        Image img = new Image(path);
        this.setImage(img);
    }

    @Override
    public void act(long now) {

    }
}
