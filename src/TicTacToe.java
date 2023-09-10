public class TicTacToe {
    private Board board;
    private Player computer;
    private Player human;

    public TicTacToe() {
        board = new Board(this);
        human = new HumanPlayer(board);
        computer = new ComputerPlayer(board);
    }

    public void playerMadeMove() {
        if (!board.isGameOver()) {
            computer.makeMove();
            board.isGameOver();
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
