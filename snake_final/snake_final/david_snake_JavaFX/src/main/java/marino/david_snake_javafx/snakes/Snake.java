package marino.david_snake_javafx.snakes;

import marino.david_snake_javafx.Corner;

import java.util.ArrayList;

public class Snake {

    ArrayList<Corner> parts = new ArrayList<Corner>();
    int dir = 0;


    public Snake() {
        parts.add(new Corner(0, 0));
        parts.add(new Corner(0, 0));
    }

    public void move() {
        for (int i = parts.size() - 1; i >= 1; i--) {
            parts.get(i).x = parts.get(i - 1).x;
            parts.get(i).y = parts.get(i - 1).y;
        }

        //boundary end condition
        switch (dir) {
            case 90:
                parts.get(0).y--;
                break;
            case 270:
                parts.get(0).y++;
                break;
            case 180:
                parts.get(0).x--;
                break;
            case 0:
                parts.get(0).x++;
                break;
        }
    }
    public void setDir(int dir) {
        System.out.println(dir);
        if (dir == 360) {
            dir = 0;
        } else if (dir == -90) {
            dir = 270;
        }
        this.dir = dir;

    }
    public int getDir() {
        return dir;
    }
    public ArrayList<Corner> getParts() {
        return parts;
    }
}
