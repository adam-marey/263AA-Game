import javax.swing.*;
import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(Board board) {
        super(board);
        this.random = new Random();
    }

    @Override
    public void makeMove() {
        JButton[][] grid = board.getGrid();
        int row;
        int col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!grid[row][col].getText().equals(""));
        grid[row][col].setText("O");
    }
}
