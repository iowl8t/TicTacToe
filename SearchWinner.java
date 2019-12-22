package TicTacToe;

import javax.swing.*;

public class SearchWinner {
    public static final int WRONG_BUTTON = 0;
    public static final int FIRST_WIN = 1;
    public static final int SECOND_WIN = 2;
    public static final int NEXT_STEP = 3;
    public static final int NO_ONE_WINS = 4;
    public static final int START = 5;
    public static final int STOP = 6;
    private static final int START_BUTTON_NAME = 9;


    private int[] resultAr = new int[9];
    private int player;
    private boolean startFlag;

    SearchWinner() {
        ClearAll();
        startFlag = false;
    }

    public int getPlayer() {
        return player;
    }

    public void setStart() {
        startFlag = true;
    }

    public int searchCoincidence(int butNumber) {

        if (startFlag)
        {
            if (butNumber == START_BUTTON_NAME) {
                startFlag = true;
                ClearAll();
                return START;
            }
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
                    startFlag = false;
                    return FIRST_WIN;
                } else if (resultAr[0] == 2 && resultAr[1] == 2 && resultAr[2] == 2 ||
                        resultAr[3] == 2 && resultAr[4] == 2 && resultAr[5] == 2 ||
                        resultAr[6] == 2 && resultAr[7] == 2 && resultAr[8] == 2 ||

                        resultAr[0] == 2 && resultAr[3] == 2 && resultAr[6] == 2 ||
                        resultAr[1] == 2 && resultAr[4] == 2 && resultAr[7] == 2 ||
                        resultAr[2] == 2 && resultAr[5] == 2 && resultAr[8] == 2 ||

                        resultAr[0] == 2 && resultAr[4] == 2 && resultAr[8] == 2 ||
                        resultAr[2] == 2 && resultAr[4] == 2 && resultAr[6] == 2) {
                    startFlag = false;
                    return SECOND_WIN;
                } else if (resultAr[0] == 0 || resultAr[1] == 0 || resultAr[2] == 0 ||
                        resultAr[3] == 0 || resultAr[4] == 0 || resultAr[5] == 0 ||
                        resultAr[6] == 0 || resultAr[7] == 0 || resultAr[8] == 0) {
                    return NEXT_STEP;
                } else {
                    startFlag = false;
                    return NO_ONE_WINS;
                }
            } else {
                return WRONG_BUTTON;
            }
        } else {
            if (butNumber == START_BUTTON_NAME) {
                startFlag = true;
                ClearAll();
                return START;
            }
            return STOP;
        }


    }


    //Make default state
    private void ClearAll() {
        for (int i = 0; i < resultAr.length; i++)
            resultAr[i] = 0;
        player = 1;
    }
}
