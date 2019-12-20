package TicTacToe;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameT extends JFrame {

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HIGHT = 500;
    private final int PANEL_WIDTH = 300;
    private final int PANEL_HIGHT = 300;
    private final int BUTTON_WIDTH = 30;
    private final int BUTTON_HIGHT = 30;
    SearchWinner searchWinner = new SearchWinner();

    FrameT() {

        //Frame configuration
        setLocation(500, 100);
        setSize(FRAME_WIDTH, FRAME_HIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Tic-Tac-Toe");

        //Panel configuration
        JPanel panel = new JPanel();
        panel.setBounds(100, 100, PANEL_WIDTH, PANEL_HIGHT);
        panel.setBackground(Color.yellow);
        panel.setLayout(new FlowLayout());


        //Buttons configuration
        Icon icon = new ImageIcon("1.jpg");

        JButton[] buttonsAr = new JButton[9];
        ButEventListener[] buttonListenerAr = new ButEventListener[9];
        int xPlus = 0;
        int yPlus = 0;

        for (int i = 0; i < 9; i++) {
            buttonsAr[i] = new JButton(icon);

            if (i == 3 || i == 6) {
                xPlus = 0;
                yPlus += BUTTON_HIGHT * 2;
            }
            buttonsAr[i].setBounds(75 + xPlus, 75 + yPlus, BUTTON_WIDTH, BUTTON_HIGHT);
            xPlus += BUTTON_WIDTH * 2;

            panel.add(buttonsAr[i]);

            buttonListenerAr[i] = new ButEventListener();
            buttonListenerAr[i].setButtonName(i);

            buttonsAr[i].addActionListener(buttonListenerAr[i]);
        }
        this.add(panel);
    }

    private void analyzeOfState(int butNumber) {
        int player = searchWinner.getPlayer();
        int state = searchWinner.searchCoincidence(butNumber);
        switch (state) {
            case 0:
                JOptionPane.showMessageDialog(new JFrame(), "Try another button.");
                break;
            case 1:
                JOptionPane.showMessageDialog(new JFrame(), "First player win! Play more");
                clearIcons();
                break;
            case 2:
                JOptionPane.showMessageDialog(new JFrame(), "Second player win! Play more");
                clearIcons();
                break;
            case 3:
                JOptionPane.showMessageDialog(new JFrame(), "Next step..");
                makeIcon(player, butNumber);
                break;
        }
    }

    private void makeIcon(int player, int butNumber){

    }
    private void clearIcons(){

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



