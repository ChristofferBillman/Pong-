/*
Created by Chrstoffer Billman on 2018-05-14.
 */

/*
    TODO: Create evenlisteners and method that alter paddlePos and paddle2Pos when user input.
    TODO: Translate ball function logic into a ball that draws on the canvas.
 */

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Pong extends JFrame {
    // Variables declared.
    public static int p1score = 0;
    public static int p2score = 0;

    boolean p1 = true;
    boolean p2 = false;

    int paddleWidth;
    int paddleHeight;
    int paddle2Width;
    int paddle2Height;
    long fps = 16 + 2/3;
    private int width = 600;
    private int heigth = 600;

    //Double buffering
    Image dbImage;
    Graphics dbg;

    public Pong() {
        this.setSize(new Dimension(width, heigth));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.addKeyListener(new KL());
        //this.addMouseListener(new ML());
        this.setVisible(true);
        this.setResizable(false);
        update();
    }

    public static void main(String[] args) { new Pong(); }

    public void update() {
        while (true) {
            running();
            try {
                Thread.sleep(fps);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void running() {
        // what to run every long fps
        draw();
        ball();
    }

    // Draw method; responsible for the graphics.
    int b = 0;
    private int x = width/2;
    private int y = heigth/2;
    //Ball ball = new Ball(x,y);
    public void draw() {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        dbg.setColor(Color.WHITE);
        dbg.drawRect(0,0,600,600);

        dbg.setColor(Color.RED);
        int[] coord = ball();
        dbg.fillOval(coord[0],coord[1],10,10);
        System.out.println(coord[0]+ "," + coord[1]);
        getGraphics().drawImage(dbImage, 0, 0, this);
    }

    // Ball method; updates the ball position and keeps the ball moving. Intended use is inside setInterval-like method.
    // Includes all collision detection.
    int Δy = 2; // Velocity of ball. Unit of length per 60th second. l/(s/60)
    int Δx = 2; // Velocity of ball. Unit of length per 60th second. l/(s/60)
    public int[] ball() {
        int canvasWidth = width;
        int canvasHeight = heigth;

        // Collision detection x-axis.
        if (x == canvasWidth || x == 0) {
            Δx = Δx *-1;
            p1score++; // Score for p1!
        }

        //Collision detection y-axis.
        if (y == canvasHeight || y == 0 ) {
            Δy = Δy *-1;
            p2score++;
        }

        x += Δx;
        y += Δy;

        // Collision detection paddles.
        int paddlePos = heigth/2; // y-coordinates of the first paddle.
        int paddle2Pos = heigth/2; // y-coordinates of the second paddle.
        int d = 20; // Distance from edge of canvas to paddle face.
        int l1 = d; // limit1; The x coordinate where the first paddles face is.
        int l2 = canvasWidth - d; // limit2; the x coordinate the the second paddles face is.
        if (x == l1 && y == paddlePos) {
            x = x + Δx;
        }
        if (x == l2 && y == paddle2Pos) {
            Δx = Δx *-1;
        }
        int[] coords = new int[]{x,y};
        return coords;
    }
}


