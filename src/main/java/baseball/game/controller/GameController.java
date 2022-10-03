package baseball.game.controller;

import baseball.ball.domain.Ball;
import baseball.ball.domain.BallLocation;
import baseball.ball.domain.BallNumber;
import baseball.game.domain.Game;
import baseball.game.ui.console.input.InputConsole;
import baseball.game.ui.console.output.OutputConsole;
import baseball.pitching.domain.Pitching;
import baseball.referee.domain.Referee;
import baseball.zone.domain.Zone;

import java.math.BigDecimal;

public class GameController {

    public static void run(Game game) {
        Zone zone = new Zone();
        zone.generate();
        do {
            Referee referee = new Referee(zone, createPitching());
            OutputConsole outputConsole = new OutputConsole(referee.judgeBallCount(), referee.judgeStrikeCount());
            outputConsole.print();
            referee.judgeGame(game);
            restart(game, zone);
        } while (game.isPlaying());
    }

    private static Pitching createPitching() {
        char[] array = InputConsole.read();
        Ball firstPitching = new Ball(new BallNumber(BigDecimal.valueOf(Integer.parseInt(String.valueOf(array[0])))), new BallLocation(BigDecimal.ONE));
        Ball secondPitching = new Ball(new BallNumber(BigDecimal.valueOf(Integer.parseInt(String.valueOf(array[1])))), new BallLocation(BigDecimal.valueOf(2)));
        Ball thirdPitching = new Ball(new BallNumber(BigDecimal.valueOf(Integer.parseInt(String.valueOf(array[2])))), new BallLocation(BigDecimal.valueOf(3)));
        Pitching pitching = new Pitching();
        pitching.add(firstPitching);
        pitching.add(secondPitching);
        pitching.add(thirdPitching);
        return pitching;
    }

    private static void restart(Game game, Zone zone) {
        if (game.isEnd() && InputConsole.askRestart()) {
            game.start();
            zone.generate();
        }
    }

}
