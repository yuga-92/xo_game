package game;

/**
 * Created by YuGa on 1/24/16.
 */
public class Field {
    private static final int FIELD_SIZE = 3;
    private static char[][] cells = new char[FIELD_SIZE][FIELD_SIZE];
    final char CLEAN_CELL_MARKER = '*';
    final char X_CELL_MARKER = 'X';
    final char O_CELL_MARKER = 'O';

    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    public char getO_CELL_MARKER() {
        return O_CELL_MARKER;
    }

    public char getX_CELL_MARKER() {
        return X_CELL_MARKER;
    }

    void initField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = CLEAN_CELL_MARKER;
            }

        }

    }

    void showField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] getCells() {
        return cells;
    }

    void placeMoveOnField(int x, int y, char cellMarker){
        cells[y][x] = cellMarker;
    }

    boolean isCanSetPoint(Point point){
        if (cells[point.getY()][point.getX()] == 'X' ||cells[point.getY()][point.getX()] == 'O') return false;
        else return true;
    }

    boolean isGameOver(){
        boolean isGameOverVal = true;
        for (int i = 0; i <FIELD_SIZE ; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
             if (cells[i][j] == '*') isGameOverVal = false;
            }
        }
        isGameOverVal = isWin();

        return isGameOverVal;
        // 0 1 2
        // 1
        // 2
    }
    boolean isWin(){
        boolean isWinVal = false;
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (cells[i][0] == 'X' && cells[i][1] == 'X' && cells[i][2] == 'X') isWinVal =true;
            if (cells[i][0] == 'O' && cells[i][1] == 'O' && cells[i][2] == 'O') isWinVal =true;
            if (cells[0][i] == 'X' && cells[1][i] == 'X' && cells[2][i] == 'X') isWinVal =true;
            if (cells[0][i] == 'O' && cells[1][i] == 'O' && cells[2][i] == 'O') isWinVal =true;
        }
        if(cells[0][0] == 'X' && cells[1][1] == 'X' && cells[2][2] == 'X') isWinVal =true;
        if(cells[0][0] == 'O' && cells[1][1] == 'O' && cells[2][2] == 'O') isWinVal =true;
        if(cells[2][0] == 'X' && cells[1][1] == 'X' && cells[0][2] == 'X') isWinVal =true;
        if(cells[2][0] == 'O' && cells[1][1] == 'O' && cells[0][2] == 'O') isWinVal =true;
        return  isWinVal;
    }
}
