package baseball;

import baseball.game.domain.Game;
import baseball.game.controller.GameController;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        GameController.run(game);
    }

}
