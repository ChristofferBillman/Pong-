import java.awt.*;

public class Ball {
    public Rectangle rectangle;
    public Ball(int x, int y) {
        rectangle = new Rectangle(x,y,25,25);
    }
    public void draw() {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        dbg.setColor(Color.WHITE);
        dbg.drawRect(0,0,600,600);

        dbg.setColor(Color.RED);



        getGraphics().drawImage(dbImage, 0, 0, this);
    }

}
