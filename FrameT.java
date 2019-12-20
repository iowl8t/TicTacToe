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
    private int[] resultAr = new int[9];
    int player = 1;

    private void searchCoincidence(int butNumber) {

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
            if (resultAr[0] == 1 && resultAr[1] == 1 && resultAr[2] == 1)
                JOptionPane.showMessageDialog(new JFrame(), "First player win!");

            if (resultAr[0] == 2 && resultAr[1] == 2 && resultAr[2] == 2)
                JOptionPane.showMessageDialog(new JFrame(), "Second player win!");
        } else
            JOptionPane.showMessageDialog(new JFrame(), "Try another button!");
    }

    private void NextGame(){
        for(int i = 0; i < resultAr.length; i++)
            resultAr[i] = 0;
        player = 1;

    }


    FrameT() {
        //Frame configuration
        setLocation(500, 100);
        setSize(FRAME_WIDTH, FRAME_HIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Tic-Tac-Toe");

        //Panel configuration
        JPanel panel = new JPanel();
        panel.setBounds(100,100, PANEL_WIDTH, PANEL_HIGHT);
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
                yPlus += BUTTON_HIGHT*2;
            }
            buttonsAr[i].setBounds(75 + xPlus, 75 + yPlus, BUTTON_WIDTH, BUTTON_HIGHT);
            xPlus += BUTTON_WIDTH*2;

            panel.add(buttonsAr[i]);

            buttonListenerAr[i] = new ButEventListener();
            buttonListenerAr[i].setButtonName(i);

            buttonsAr[i].addActionListener(buttonListenerAr[i]);
        }
        this.add(panel);

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
            searchCoincidence(buttonName);
        }
    }
}



