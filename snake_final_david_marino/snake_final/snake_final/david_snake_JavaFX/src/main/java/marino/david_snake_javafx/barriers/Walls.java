package marino.david_snake_javafx.barriers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Map;

public class Walls {
    public boolean[][] wallPositions;


    public Walls(boolean[][] wallPositions) {
        this.wallPositions = wallPositions;
    }

    public boolean getPos(int x, int y) {
        return wallPositions[y][x];
    }

    public void setPosTrue(int x, int y) {
        wallPositions[y][x] = true;
    }

    public void setPosFalse(int x, int y) {
        wallPositions[y][x] = false;
    }

    public void setPosInverse(int x, int y) {
        boolean temp = wallPositions[y][x];
        if (temp == true) {
            wallPositions[y][x] = false;
        } else if (temp == false) {
            wallPositions[y][x] = true;
        }

    }
    public boolean[][] getWallPositions() {
        return wallPositions;
    }

    public GraphicsContext createWallGraphics(GraphicsContext gc) {
        int height = 20;
        int width = 20;




        return gc;
    }

}
