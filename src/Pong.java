/*
Created by Chrstoffer Billman on 2018-05-14.
 */

/*
    TODO: Graphics and Draw() method.
    TODO: Make .swing windows and canvas. Define variables associated with it.
    TODO: Create a clock, a method that runs every 60th of a second. (16 + 2/3)s.
    TODO: Create evenlisteners and method that alter paddlePos and paddle2Pos when user input.
 */

import javax.swing.*;
public class Pong {
    public static int p1score = 0;
    public static int p2score = 0;

    public static void main(String[] args) {
        clock();
        // Variables declared.
        boolean p1;
        boolean p2;

        int paddleWidth;
        int paddleHeight;
        int paddle2Width;
        int paddle2Height;
    }
    public static void clock() {

    }
    // Draw method; responsible for the graphics.
    public static void draw() {

    }

    // Ball method; updates the ball position and keeps the ball moving. Intended use is inside setInterval-like method.
    // Includes all collision detection.
    public static void ball() {
        int canvasWidth;
        int canvasHeight;
        // Collision detection x-axis.
        int x; // Current x-coordinate of ball.
        int Δx; // Velocity of ball. Unit of length per 60th second. l/(s/60)
        if (x == canvasWidth) {
            x = x - Δx;
            p1score++; // Score for p1!
        }
        if (x == 0) {
            x = x + Δx;
            p2score++; // Score for p2!
        }

        //Collision detection y-axis.
        int y; // Current y-coordinate of ball
        int Δy; // Velocity of ball. Unit of length per 60th second. l/(s/60)
        if (y == canvasHeight) {
            y = y - Δy;
        }
        if (y == 0) {
            y = y + Δy;
        }

        // Collision detection paddles.
        int paddlePos; // y-coordinates of the first paddle.
        int paddle2Pos; // y-coordinates of the second paddle.
        int d; // Distance from edge of canvas to paddle face.
        int l1 = d; // limit1; The x coordinate where the first paddles face is.
        int l2 = canvasWidth - d; // limit2; the x coordinate the the second paddles face is.
        if (x == l1 && y == paddlePos) {
            x =  x + Δx;
        }
        if (x == l2 && y == paddle2Pos) {
            x = x - Δx;
        }
    }

}

