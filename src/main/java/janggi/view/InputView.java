package janggi.view;

import janggi.domain.PieceSetup;
import janggi.domain.path.Position;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static PieceSetup readHanSetup() {
        System.out.println("한나라 배치를 선택해주세요");
        return choiceSetup();
    }

    public static PieceSetup readChoSetup() {
        System.out.println("초나라 배치를 선택해주세요");
        return choiceSetup();
    }

    public static Position readStart() {
        System.out.println("움직일 기물을 선택해주세요 예)2,3");
        return toPosition();
    }

    public static Position readDestination() {
        System.out.println("움직일 위치를 선택해주세요 예)3,4");
        return toPosition();
    }

    private static Position toPosition() {
        String input = scanner.nextLine();
        String[] split = input.split(",");
        try {
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            return new Position(x, y);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식을 입력하셨습니다. 예)3,4");
        }
    }

    private static PieceSetup choiceSetup() {
        System.out.printf(
            "1. 왼상차림%n" +
                "2. 오른상차림%n" +
                "3. 안상차림%n" +
                "4. 바깥상차림%n");
        return PieceSetup.findSetup(scanner.nextLine());
    }
}
