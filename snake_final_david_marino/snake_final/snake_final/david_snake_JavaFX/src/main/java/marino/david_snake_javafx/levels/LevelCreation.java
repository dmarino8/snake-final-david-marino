package marino.david_snake_javafx.levels;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LevelCreation {
    int height = 20;
    int width = 20;
    public Map<Integer, ArrayList<int[]>> layout = new HashMap<>();
    BufferedImage image;
    File file;

    public LevelCreation(File f) {
        this.file = f;
        loadLayout(this.file);
    }


    public void loadLayout(File f) {
        try {
            image = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println("failed to load image");
            e.printStackTrace();

        }
        for (int y = 0; y < height; y++) {
            ArrayList<int[]> row = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                int[] pixel = new int[3];
                int pix = image.getRGB(x, y);
                Color color = new Color(pix, true);
                pixel[0] = (color.getRed());
                pixel[1] = (color.getGreen());
                pixel[2] = (color.getBlue());
                row.add(pixel);
            }
            layout.put(y, row);
        }

    }

    public Map<Integer, ArrayList<int[]>> getLayout() {
        return layout;
    }
    public boolean[][] getWallLayout() {
        boolean[][] walls = new boolean[20][20];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (getPixelString(y, x).equalsIgnoreCase("BLACK")) {
                    walls[y][x] = true;
                    System.out.println("true");
                } else {
                    walls[y][x] = false;
                    System.out.println("false");
                }
            }
        }


        return walls;
    }
    public String getLayoutString() {
        return layout.toString();
    }
    public ArrayList<int[]> getRow(int row) {
        return layout.get(row);
    }

    public void getRowString (int row) {
        for (int[] pixels : layout.get(row)) {
            System.out.println(Arrays.toString(pixels));
        }
    }
    public int[] getPixel(int row, int column) {
        return layout.get(row).get(column);
    }
    public String getPixelString(int row, int column) {
        String pixelString = "";
        int[] pixel = getPixel(row, column);
        if (pixel[0] <= 5 && pixel[1] <= 5 && pixel[2] <= 5) {
            pixelString = "BLACK";
            System.out.println(pixelString);
            return pixelString;
        } else if (pixel[0] >= 250 && pixel[1] <= 5 && pixel[2] <= 5) {
            pixelString = "RED";
            System.out.println(pixelString);
            return pixelString;
        } else if (pixel[0] <= 5 && pixel[1] >= 250 && pixel[2] <= 5) {
            pixelString = "GREEN";
            System.out.println(pixelString);
            return pixelString;
        } else if (pixel[0] <= 5 && pixel[1] <= 5 && pixel[2] >= 250) {
            pixelString = "BLUE";
            System.out.println(pixelString);
            return pixelString;
        } else if (pixel[0] >= 250 && pixel[1] >= 255 && pixel[2] <= 5) {
            pixelString = "YELLOW";
            System.out.println(pixelString);
            return pixelString;
        } else if (pixel[0] >= 255 && pixel[1] >= 255 && pixel[2] <= 5) {
            pixelString = "PURPLE";
            System.out.println(pixelString);
            return pixelString;
        }
        System.out.println(pixelString);
        return pixelString;
    }

    //red -> enemy start
    //green -> snake start
    //dark grey -> wall
    //yellow -> ladder
    //blue -> fruit


}
