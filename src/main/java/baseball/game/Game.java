package baseball.game;

public class Game {

    private GameStatus status;

    public void start() {
        this.status = GameStatus.PLAYING;
    }

    public void end() {
        this.status = GameStatus.STOP;
    }

    public GameStatus getStatus() {
        return status;
    }

    public boolean isEnd() {
        return this.status == GameStatus.STOP;
    }
}
