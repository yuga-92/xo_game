package game;

/**
 * Created by YuGa on 1/24/16.
 */
public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.initField();
        field.showField();
        Player player = new Player(field);
        player.getPlayerName();
        player.greetThePlayer(player);
        player.setPlayerMarkerType(player.playerRequestToChooseMarker());
        AI comp = new AI(field, player);

        do {
            player.setShootPoint();
            //field.showField();
            comp.setAiShootPoint();
            field.showField();
        }while (!field.isGameOver());

    }
}
