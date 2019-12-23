package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelT extends JPanel {

    JLabel lMain = new JLabel();
    JLabel lScore = new JLabel();

    JButton[] bAr = new JButton[9];
    ButEventListener[] bListenerAr = new ButEventListener[9];
    JButton bStart = new JButton();
    ButEventListener bListenerStart = new ButEventListener();

    SearchWinner searchWinner = new SearchWinner();

    PanelT(int FRAME_WIDTH, int FRAME_HIGHT) {
        //Content panel config
        setBounds(25, 25, FRAME_WIDTH - 50, FRAME_HIGHT - 50);
        setBackground(Color.green);
        setLayout(null);

        //Main label config
        lMain.setText("Гра хрестики-нулики");
        lMain.setBounds(80, 5, 150, 20);
        lMain.setBackground(Color.yellow);
        add(lMain);

        //Score label config
        lScore.setText("Рахунок: 0 : 0");
        lScore.setBounds(200, 240, 150, 20);
        lScore.setBackground(Color.blue);
        lScore.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(lScore);

        //Field's buttons config
        buttonsConfig();

        //Start button config
        bStart.setText("СТАРТ");
        bStart.setBounds(0, 240, 80, 25);
        bListenerStart.setButtonName(9);
        bStart.addActionListener(bListenerStart);
        add(bStart);
    }

    //Field's buttons config
    private void buttonsConfig() {
        int xPos = 67;
        int yPos = 50;
        final int BUTTON_WIDTH = 50;
        final int BUTTON_HIGHT = 50;

        for (int i = 0; i < 9; i++) {

            if (i == 3 || i == 6) {
                xPos = 67;
                yPos += BUTTON_HIGHT + 5;
            }

            bAr[i] = new JButton();

            bAr[i].setBounds(xPos, yPos, BUTTON_WIDTH, BUTTON_HIGHT);
            add(bAr[i]);

            bListenerAr[i] = new ButEventListener();
            bListenerAr[i].setButtonName(i);
            bAr[i].addActionListener(bListenerAr[i]);

            xPos += BUTTON_WIDTH + 5;
        }
    }

    //Analyzing of game
    private int playerOneWins = 0;
    private int playerTwoWins = 0;
    //private int draw = 0;

    private void analyzeOfState(int butNumber) {
        int player = searchWinner.getPlayer();
        int state = searchWinner.searchCoincidence(butNumber);
        switch (state) {
            case SearchWinner.WRONG_BUTTON:
                JOptionPane.showMessageDialog(new JFrame(), "Це поле зайняте.", "Дідько лисий ;)", JOptionPane.WARNING_MESSAGE);
                break;
            case SearchWinner.FIRST_WIN:
                playerOneWins++;
                makeIcon(player, butNumber);
                JOptionPane.showMessageDialog(new JFrame(), "Перший гравець виграв!", "Дідько лисий ;)", JOptionPane.INFORMATION_MESSAGE);
                break;
            case SearchWinner.SECOND_WIN:
                playerTwoWins++;
                makeIcon(player, butNumber);
                JOptionPane.showMessageDialog(new JFrame(), "Другий гравець виграв!", "Дідько лисий ;)", JOptionPane.INFORMATION_MESSAGE);
                break;
            case SearchWinner.NEXT_STEP:
                //JOptionPane.showMessageDialog(new JFrame(), "Наступний ходить гравець" + player);
                makeIcon(player, butNumber);
                break;
            case SearchWinner.DRAW:
                //draw++;
                makeIcon(player, butNumber);
                JOptionPane.showMessageDialog(new JFrame(), "Ніхто не програв :|", "Дідько лисий ;)", JOptionPane.INFORMATION_MESSAGE);
                break;
            case SearchWinner.START:
                //JOptionPane.showMessageDialog(new JFrame(), "Вперід!");
                clearIcons();
                break;
            case SearchWinner.STOP:
                JOptionPane.showMessageDialog(new JFrame(), "Клікай 'START' щоб почати.", "Дідько лисий ;)", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    //Change game field
    private void makeIcon(int player, int butNumber) {
        if (player == 1)
            bAr[butNumber].setText("X");
        else
            bAr[butNumber].setText("O");
        lScore.setText("Рахунок: " + playerOneWins + " : " + playerTwoWins);
    }

    //Make default game field
    private void clearIcons() {
        for (JButton jButton : bAr) jButton.setText(".");
    }

    //Handling of actions
    private class ButEventListener implements ActionListener {
        private int buttonName;

        public void setButtonName(int nButton) {
            this.buttonName = nButton;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            analyzeOfState(buttonName);
        }
    }
}
