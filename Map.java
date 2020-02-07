package ru.geekbrains.XoGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Map extends JPanel {
    public static final int GAME_MODE_HVH = 1;
    public static final int GAME_MODE_HVA = 0;

    public String[][] field;

    Map(){
        setBackground(Color.BLACK);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("game mode: %d\nfieldSize: %d\nwinLength: %d\n", gameMode, fieldSizeX, winLength);
        JFrame.setDefaultLookAndFeelDecorated(true);   // добавил
        createGameField(fieldSizeX, fieldSizeY);       // добавил
    }
// Добавил метод создания игрового поля в виде таблицы
    public static void createGameField(int fieldSizeX, int fieldSizeY) {
        GameWindow gameField = new GameWindow();
        gameField.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[][] field = new String[fieldSizeX][fieldSizeY];
        JScrollPane jScrollPane = new JScrollPane(gameField);

        gameField.getContentPane().add(jScrollPane);
        gameField.setPreferredSize(new Dimension(500, 500));
        gameField.pack();
        gameField.setLocationRelativeTo(null);
        gameField.setVisible(true);

    }

}

// У меня вопрос о том, какой вариант решения задачи об "умной"
// игре компьютера в TicTacToe предложили бы Вы?
// На вебинаре именно этот пункт мы не разбирали.  
// Вот он:
// 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
