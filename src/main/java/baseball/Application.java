package baseball;

import baseball.game.Game;
import baseball.game.GameRule;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        GameRule.play(game);
    }

}
