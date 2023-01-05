public class Current extends Item{

    public Current(){
        super();
    }

    @Override
    public String toString(){
        return String.format("%s current (+%d)\n", super.toString(), super.getMagnitude());
    }
}