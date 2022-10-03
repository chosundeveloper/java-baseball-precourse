package baseball.game;

public class Game {
    private GameStatus status;

    public Game() {
        this.status = GameStatus.STOP;
    }

    public void start() {
        this.status = GameStatus.PLAYING;
    }

    public boolean isPlaying() {
        return this.status.equals(GameStatus.PLAYING);
    }

    public boolean isEnd() {
        return this.status == GameStatus.STOP;
    }

    public void end() {
        this.status = GameStatus.STOP;
        System.out.println("게임 종료");
    }

    public GameStatus getStatus() {
        return this.status;
    }
}
