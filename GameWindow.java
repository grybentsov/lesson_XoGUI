package ru.geekbrains.XoGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    public static final int WIN_WIDTH = 507;
    public static final int WIN_HEIGHT = 555;
    public static final int WIN_POSX = 650;
    public static final int WIN_POSY = 250;

    public Map map;                 // сделал public
    public Settings settings;        // сделал public

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic tac toe game");
        setLocation(WIN_POSX, WIN_POSY);
        setSize(WIN_WIDTH, WIN_HEIGHT);

        JButton btnStart = new JButton("Start");
        JButton btnExit = new JButton("Exit");
        JPanel panelButtons = new JPanel(new GridLayout(1, 2));
        panelButtons.add(btnStart);
        panelButtons.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        map = new Map();
        settings = new Settings(this);

        add(map, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);

        setVisible(true);
    }

    void start(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}
