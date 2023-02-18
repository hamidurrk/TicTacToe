package org.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame {
    private char currentPlayer = 'X';
    private JButton[][] board = new JButton[3][3];
    private JLabel message = new JLabel("Player " + currentPlayer + " turn");

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                board[i][j] = button;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        buttonClicked(button);
                    }
                });
                boardPanel.add(button);
            }
        }

        add(boardPanel, BorderLayout.CENTER);
        add(message, BorderLayout.SOUTH);
    }

    private void buttonClicked(JButton button) {
        if (button.getText().equals("")) {
            button.setText(Character.toString(currentPlayer));
            if (checkForWin()) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetBoard();
            } else if (checkForTie()) {
                JOptionPane.showMessageDialog(this, "It's a tie!");
                resetBoard();
            } else {
                currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
                message.setText("Player " + currentPlayer + " turn");
            }
        }
    }

    private boolean checkForWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText().equals(board[i][1].getText()) && board[i][1].getText().equals(board[i][2].getText()) && !board[i][0].getText().equals("")) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i].getText().equals(board[1][i].getText()) && board[1][i].getText().equals(board[2][i].getText()) && !board[0][i].getText().equals("")) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && !board[0][0].getText().equals("")) {
            return true;
        }
        if (board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) && !board[0][2].getText().equals("")) {
            return true;
        }

        return false;
    }

    private boolean checkForTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        currentPlayer = 'X';
        message.setText("Player " + currentPlayer + " turn");

        // Clear board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.setVisible(true);
    }
}
