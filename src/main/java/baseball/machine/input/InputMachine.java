package baseball.machine.input;

import camp.nextstep.edu.missionutils.Console;

public class InputMachine {
    public static char[] read() {
        System.out.println("숫자를 입력해주세요");
        String input = Console.readLine();
        char[] array = input.toCharArray();
        if (array.length > 3) {
            throw new IllegalArgumentException();
        }
        return array;
    }

    public static boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1 종료하려면 2를 입력하세요");
        String answer = Console.readLine();
        return Integer.parseInt(answer) == 1;
    }
}
