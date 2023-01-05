import java.util.Random;

public class Item {
    private int magnitude;
    private int position;

    public Item(){
        Random randomNum = new Random();
        // for array access
        setPosition(1 + randomNum.nextInt(99));
    }

    public int getMagnitude(){
        return magnitude;
    }

    public void setMagnitude(int magnitude){
        this.magnitude = magnitude;
    }

    public void generateMagnitude(){
        Random randomNum = new Random();
        magnitude =  1 + randomNum.nextInt(4);
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    @Override
    public String toString(){
        return String.format("! You've encountered a");
    }
}

