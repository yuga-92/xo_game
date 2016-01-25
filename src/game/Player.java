package game;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by YuGa on 1/24/16.
 */
public class Player {
    String playerName;
    Field field;
    char playerMarkerType;
    Scanner scanner = new Scanner(System.in);
    int playerMarkerChoice;
    Point shootPoint = new Point();

    void getPlayerName(){
        System.out.println("Please, enter your name (nickname): ");
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.nextLine();
    }
    Player(Field field){
        this.field = field;
    }

    void greetThePlayer(Player player){
        System.out.println("Hi, "+ player.playerName);
    }

    void setPlayerMarkerType(int choice){
        playerMarkerChoice = choice;
       switch (playerMarkerChoice){
            case 1:
                playerMarkerType = field.X_CELL_MARKER;
                break;
            case 2:
                playerMarkerType = field.O_CELL_MARKER;
                break;
            case 3:
                setPlayerMarkerType(generateRandomMarker());
                break;
            default:
                System.out.println("Wrong choice!");
                System.out.println(playerMarkerChoice);
                setPlayerMarkerType(playerRequestToChooseMarker());

        }
    }

    int playerRequestToChooseMarker() {
        System.out.println("Please, choose X or O you want to play");
        System.out.println("1) X");
        System.out.println("2) O");
        System.out.println("3) Random choose");
        return scanner.nextInt();
    }

    public char getPlayerMarkerType() {
        return playerMarkerType;
    }

    void doMove (){
        System.out.println("Enter X coordinate: ");
        shootPoint.setX(scanner.nextInt());
        System.out.println("Enter Y coordinate: ");
        shootPoint.setY(scanner.nextInt());
       // field.placeMoveOnField(shootPoint.getX(),shootPoint.getY(),playerMarkerType);
    }

    int generateRandomMarker(){
        Random rand = new Random();
        int r = rand.nextInt(2)+1;
        return r;
    }

    void setShootPoint(){
        do {
            doMove();
        } while (!field.isCanSetPoint(shootPoint));
        field.placeMoveOnField(shootPoint.getX(),shootPoint.getY(),playerMarkerType);
    }
}
