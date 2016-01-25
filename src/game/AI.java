package game;

import java.util.Random;

/**
 * Created by YuGa on 1/25/16.
 */
public class AI {
    Field field;
    char aiMarkerType;
    Player player;
    Point aiShootPoint = new Point();


    public AI(Field field, Player player) {
        this.field = field;
        this.player = player;
        setAiMarkerType(player);
    }

    void setAiMarkerType(Player player) {
        switch (player.getPlayerMarkerType()){
            case 'X':
                aiMarkerType = field.getO_CELL_MARKER();
                break;
            case 'O':
                aiMarkerType = field.getX_CELL_MARKER();
                break;
            default:
                System.out.println("Error in setting AI marker type");
        }
    }
    void setAiShootPoint(){
        do {
            aiShootPoint = generateRandomPoint();
        } while (!field.isCanSetPoint(aiShootPoint));
        field.placeMoveOnField(aiShootPoint.getX(),aiShootPoint.getY(),aiMarkerType);
    }

    Point generateRandomPoint(){
        Point randompoint = new Point();
        Random random = new Random();
        randompoint.setX(random.nextInt(Field.getFieldSize()));
        randompoint.setY(random.nextInt(Field.getFieldSize()));
        return randompoint;
    }


}
