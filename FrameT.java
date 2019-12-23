package TicTacToe;


import javax.swing.*;


public class FrameT extends JFrame {

    private final int FRAME_WIDTH = 300;
    private final int FRAME_HIGHT = 300;

    FrameT() {
        //Frame config
        setLocation(550, 200);
        //setLocationRelativeTo(null);
        setSize(FRAME_WIDTH, FRAME_HIGHT);
        setTitle("Tic-Tac-Toe");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelT panel = new PanelT(FRAME_WIDTH, FRAME_HIGHT);
        add(panel);

        setVisible(true);
    }
}



