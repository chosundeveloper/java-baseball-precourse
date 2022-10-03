package baseball.game.controller;

import baseball.ball.domain.Ball;
import baseball.ball.domain.BallLocation;
import baseball.ball.domain.BallNumber;
import baseball.common.CharUtils;
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
        Pitching pitching = new Pitching();
        for (char number : array) {
            pitching.add(new Ball(new BallNumber(CharUtils.convertBigDecimal(number)), new BallLocation(BigDecimal.valueOf(pitching.pitchingBalls().size() + 1))));
        }
        return pitching;
    }

    private static void restart(Game game, Zone zone) {
        if (game.isEnd() && InputConsole.askRestart()) {
            game.start();
            zone.generate();
        }
    }

}
