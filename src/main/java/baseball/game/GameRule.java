package baseball.game;

import baseball.ball.Ball;
import baseball.ball.BallLocation;
import baseball.ball.BallNumber;
import baseball.machine.input.InputMachine;
import baseball.machine.output.OutputMachine;
import baseball.pitching.Pitching;
import baseball.referee.Referee;
import baseball.zone.Zone;

import java.math.BigDecimal;

public class GameRule {

    public static void play(Game game) {
        Zone zone = new Zone();
        zone.generate();
        do {
            Referee referee = new Referee(zone, createPitching());
            OutputMachine outputMachine = new OutputMachine(referee.judgeBallCount(), referee.judgeStrikeCount());
            outputMachine.print();
            referee.judgeGame(game);
            restart(game, zone);
        } while (game.isPlaying());
    }

    private static Pitching createPitching() {
        char[] array = InputMachine.read();
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
        if (game.isEnd() && InputMachine.askRestart()) {
            game.start();
            zone.generate();
        }
    }

}
