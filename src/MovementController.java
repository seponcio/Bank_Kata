import java.util.ArrayList;
import java.util.List;

public class MovementController {
    private List<Movement> movements = new ArrayList<Movement>();
    public Movement getLastMovement() {
        return movements.get(movements.size() -1);
    }

    public void addMovement(int amount) {
        movements.add(new Movement(amount));
    }

}
