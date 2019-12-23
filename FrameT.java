package TicTacToe;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class FrameT extends JFrame {

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HIGHT = 500;
    private final int PANEL_WIDTH = 150;
    private final int PANEL_HIGHT = 150;
    private final int BUTTON_WIDTH = 30;
    private final int BUTTON_HIGHT = 30;

    JPanel panel;
    JButton[] buttonsAr;
    ButEventListener[] buttonListenerAr;
    SearchWinner searchWinner;
    JLabel labelScore;

    FrameT() {
        searchWinner = new SearchWinner();

        //Frame config
        setLocation(500, 100);
        setSize(FRAME_WIDTH, FRAME_HIGHT);
        setTitle("Tic-Tac-Toe");

        //Buttons panel config
        panel = new JPanel();
        panel.setBounds(175, 175, PANEL_WIDTH, PANEL_HIGHT);
        panel.setBackground(Color.yellow);
        //panel.setLayout(null);
        add(panel);


        //Label panel config
        JPanel panelMainLabel = new JPanel();
        panelMainLabel.setBounds(200, 300, 150, 100);
        panelMainLabel.setBackground(Color.green);
        //panelMainLabel.setLayout(null);
        add(panelMainLabel);

        //Main label config
        JLabel labelMain = new JLabel("Гра хрестики-нулики");
        labelMain.setBounds(100, 100, 0, 0);
        panelMainLabel.add(labelMain, BorderLayout.SOUTH);

        labelScore = new JLabel("Рахунок: 0 : 0");


        //Buttons config
        buttonsAr = new JButton[9];
        buttonListenerAr = new ButEventListener[9];
        buttonsConfig();

        //Start button config
        JButton startButton = new JButton("START");
        startButton.setBounds(400, 400, 50, 50);

        ButEventListener buttonListenerStart = new ButEventListener();
        buttonListenerStart.setButtonName(9);
        startButton.addActionListener(buttonListenerStart);

        panel.add(startButton);
        panel.add(labelScore);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Buttons configuration
    private void buttonsConfig() {
        //Buttons configuration
        int xPlus = 0;
        int yPlus = 0;

        for (int i = 0; i < 9; i++) {

            if (i == 3 || i == 6) {
                xPlus = 0;
                yPlus += BUTTON_HIGHT * 2;
            }

            buttonsAr[i] = new JButton(".");
            buttonsAr[i].setBounds(xPlus, yPlus, BUTTON_WIDTH, BUTTON_HIGHT);
            panel.add(buttonsAr[i]);

            buttonListenerAr[i] = new ButEventListener();
            buttonListenerAr[i].setButtonName(i);
            buttonsAr[i].addActionListener(buttonListenerAr[i]);

            xPlus += BUTTON_WIDTH * 2;
        }
    }

    private int playerOneWins = 0;
    private int playerTwoWins = 0;
    private int draw = 0;

    //Analyzing of game
    private void analyzeOfState(int butNumber) {
        int player = searchWinner.getPlayer();
        int state = searchWinner.searchCoincidence(butNumber);
        switch (state) {
            case SearchWinner.WRONG_BUTTON:
                JOptionPane.showMessageDialog(new JFrame(), "This is not a free field", "Дідько лисий", JOptionPane.WARNING_MESSAGE);
                break;
            case SearchWinner.FIRST_WIN:
                JOptionPane.showMessageDialog(new JFrame(), "First player win! Play more");
                playerOneWins++;
                makeIcon(player, butNumber);
                break;
            case SearchWinner.SECOND_WIN:
                JOptionPane.showMessageDialog(new JFrame(), "Second player win! Play more");
                playerTwoWins++;
                makeIcon(player, butNumber);
                break;
            case SearchWinner.NEXT_STEP:
                //JOptionPane.showMessageDialog(new JFrame(), "Next step player" + player);
                makeIcon(player, butNumber);
                break;
            case SearchWinner.DRAW:
                JOptionPane.showMessageDialog(new JFrame(), "No one wins! Play more");
                draw++;
                makeIcon(player, butNumber);
                break;
            case SearchWinner.START:
                //JOptionPane.showMessageDialog(new JFrame(), "GO!");
                clearIcons();
                break;
            case SearchWinner.STOP:
                JOptionPane.showMessageDialog(new JFrame(), "To play press 'START' button");
                break;
        }
    }

    //Changing game`s field
    private void makeIcon(int player, int butNumber) {
        if (player == 1)
            buttonsAr[butNumber].setText("X");
        else
            buttonsAr[butNumber].setText("O");
        labelScore.setText("Рахунок: " + playerOneWins + " : " + playerTwoWins);
    }

    //Make default game`s field
    private void clearIcons() {
        for (int i = 0; i < buttonsAr.length; i++)
            buttonsAr[i].setText(".");
    }

    //Handling of actions
    class ButEventListener implements ActionListener {
        private int buttonName;

        ButEventListener() {
        }

        public void setButtonName(int nButton) {
            this.buttonName = nButton;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //JOptionPane.showMessageDialog(new JFrame(), "You pressed button " + (buttonName + 1));
            analyzeOfState(buttonName);

        }
    }
}



