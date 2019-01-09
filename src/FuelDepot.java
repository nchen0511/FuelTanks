import java.util.List;

public class FuelDepot {
    private FuelRobot filler;

    private List<FuelTank> tanks;

    public int nextTankToFill(int threshold){
        for (int i=0;i<tanks.size();i++) {
            if (tanks.get(i).getFuelLevel() <= threshold) {
                return i;
            }
        }
        return filler.getCurrentIndex();
    }

    public void movetoLocation(int locIndex){
        if(filler.getCurrentIndex()!=locIndex){
            if(filler.getCurrentIndex()>locIndex){
                if(filler.isFacingRight()){
                    filler.changeDirection();
                }
                filler.moveForward(locIndex-filler.getCurrentIndex());
            } else {
                if(!filler.isFacingRight()){
                    filler.changeDirection();
                }
                filler.moveForward(filler.getCurrentIndex()-locIndex);
            }
        }
    }
}
