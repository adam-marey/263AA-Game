import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board {
    private JFrame frame;
    private JButton[][] grid;
    private TicTacToe game;
    private int size; // new variable for board size

    // Default constructor (3x3 board)
    public Board(TicTacToe game) {
        this(game, 3);  // using overloaded constructor
    }

    // Overloaded constructor for custom size
    public Board(TicTacToe game, int size) {
        this.game = game;
        this.size = size;
        frame = new JFrame("Tic Tac Toe");
        grid = new JButton[size][size];  // creating grid of custom size
        initialize();
    }

    private void initialize() {
        frame.setSize(100 * size, 100 * size);  // set frame size based on board size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new JButton("");
                frame.add(grid[i][j]);
                grid[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton clickedButton = (JButton) e.getSource();
                        if (clickedButton.getText().equals("")) {
                            clickedButton.setText("X");
                            game.playerMadeMove();
                        }
                    }
                });
            }
        }
        frame.setVisible(true);
    }

    public boolean isGameOver() {
        if (checkWinner("X")) {
            JOptionPane.showMessageDialog(frame, "You win!");
            resetGame();
            return true;
        }
        if (checkWinner("O")) {
            JOptionPane.showMessageDialog(frame, "Computer wins!");
            resetGame();
            return true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(frame, "It's a draw!");
        resetGame();
        return true;
    }

    private boolean checkWinner(String player) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0].getText().equals(player) && grid[i][1].getText().equals(player) && grid[i][2].getText().equals(player)) {
                return true;
            }
            if (grid[0][i].getText().equals(player) && grid[1][i].getText().equals(player) && grid[2][i].getText().equals(player)) {
                return true;
            }
        }
        if (grid[0][0].getText().equals(player) && grid[1][1].getText().equals(player) && grid[2][2].getText().equals(player)) {
            return true;
        }
        return grid[0][2].getText().equals(player) && grid[1][1].getText().equals(player) && grid[2][0].getText().equals(player);
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j].setText("");
            }
        }
    }

    public JButton[][] getGrid() {
        return grid;
    }
}
