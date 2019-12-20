package TicTacToe;

import javax.swing.*;

public class SearchWinner {
    public final int WRONG_BUTTON = 0;
    public final int FIRST_WIN = 1;
    public final int SECOND_WIN = 2;
    public final int NEXT_STEP = 3;

    private int[] resultAr = new int[9];
    private int player = 1;

    public int getPlayer(){
        return player;
    }

    public int searchCoincidence(int butNumber) {

        if (resultAr[butNumber] != 1 && resultAr[butNumber] != 2) {
            //Make array
            if (player == 1) {
                resultAr[butNumber] = 1;
                player = 2;
            } else {
                resultAr[butNumber] = 2;
                player = 1;
            }
            //Search coincidence
            if (resultAr[0] == 1 && resultAr[1] == 1 && resultAr[2] == 1 ||
                    resultAr[3] == 1 && resultAr[4] == 1 && resultAr[5] == 1 ||
                    resultAr[6] == 1 && resultAr[7] == 1 && resultAr[8] == 1 ||

                    resultAr[0] == 1 && resultAr[3] == 1 && resultAr[6] == 1 ||
                    resultAr[1] == 1 && resultAr[4] == 1 && resultAr[7] == 1 ||
                    resultAr[2] == 1 && resultAr[5] == 1 && resultAr[8] == 1 ||

                    resultAr[0] == 1 && resultAr[4] == 1 && resultAr[8] == 1 ||
                    resultAr[2] == 1 && resultAr[4] == 1 && resultAr[6] == 1) {
                ClearAll();
                return FIRST_WIN;
            } else if (resultAr[0] == 2 && resultAr[1] == 2 && resultAr[2] == 2 ||
                    resultAr[3] == 2 && resultAr[4] == 2 && resultAr[5] == 2 ||
                    resultAr[6] == 2 && resultAr[7] == 2 && resultAr[8] == 2 ||

                    resultAr[0] == 2 && resultAr[3] == 2 && resultAr[6] == 2 ||
                    resultAr[1] == 2 && resultAr[4] == 2 && resultAr[7] == 2 ||
                    resultAr[2] == 2 && resultAr[5] == 2 && resultAr[8] == 2 ||

                    resultAr[0] == 2 && resultAr[4] == 2 && resultAr[8] == 2 ||
                    resultAr[2] == 2 && resultAr[4] == 2 && resultAr[6] == 2) {
                ClearAll();
                return SECOND_WIN;
            } else {
                return NEXT_STEP;
            }
        } else {
            return WRONG_BUTTON;
        }
    }

    //Make default state
    private void ClearAll() {
        for (int i = 0; i < resultAr.length; i++)
            resultAr[i] = 0;
        player = 1;
    }
}
