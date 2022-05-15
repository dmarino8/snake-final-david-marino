package marino.david_snake_javafx.fruits;

public class SlowFruit implements Fruit {

    //properties
    public int posX;
    public int posY;
    public String color;
    public int speed;
    public String name;

    //constructors//s
    SlowFruit () {
        posX = 0;
        posY = 0;
        color = "purple";
        speed = 3;
        name = "slow";
    }

    //getters
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public int getSpeed() {
        return speed;
    }
    @Override
    public String getName() {return name;}

    //setters
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }



}
