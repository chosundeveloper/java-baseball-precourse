package baseball.machine.output;

import baseball.output.OutputMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("투구 영역 판정")
class OutputMachineTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @DisplayName("낫싱")
    @ParameterizedTest
    @CsvSource({"0, 0"})
    void nothing(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("낫싱");
    }

    @DisplayName("1 스트라이크")
    @ParameterizedTest
    @CsvSource({"0, 1"})
    void oneStrike(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1스트라이크");
    }

    @DisplayName("2 스트라이크")
    @ParameterizedTest
    @CsvSource({"0, 2"})
    void twoStrike(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2스트라이크");
    }

    @DisplayName("3스트라이크")
    @ParameterizedTest
    @CsvSource({"0, 3"})
    void out(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3스트라이크");
    }

    @DisplayName("1볼")
    @ParameterizedTest
    @CsvSource({"1, 0"})
    void oneBall(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1볼");
    }

    @DisplayName("1볼 1스트라이크")
    @ParameterizedTest
    @CsvSource({"1, 1"})
    void oneBallOneStrike(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("1볼 2스트라이크")
    @ParameterizedTest
    @CsvSource({"1, 2"})
    void oneBall_twoStrike(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1볼 2스트라이크");
    }

    @DisplayName("2볼")
    @ParameterizedTest
    @CsvSource({"2, 0"})
    void twoBall(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼");
    }

    @DisplayName("2볼 1스트라이크")
    @ParameterizedTest
    @CsvSource({"2, 1"})
    void twoBallOneStrike(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼 1스트라이크");
    }

    @DisplayName("3볼")
    @ParameterizedTest
    @CsvSource({"3, 0"})
    void threeBall(int ballCount, int strikeCount) {
        OutputMachine outputMachine = OutputMachine.create(ballCount, strikeCount);
        outputMachine.print();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3볼");
    }

}
