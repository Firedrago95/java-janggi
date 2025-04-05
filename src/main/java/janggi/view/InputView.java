package janggi.view;

import janggi.domain.PieceSetup;

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

    private static PieceSetup choiceSetup() {
        System.out.printf(
            "1. 왼상차림%n" +
                "2. 오른상차림%n" +
                "3. 안상차림%n" +
                "4. 바깥상차림%n");
        return PieceSetup.findSetup(scanner.nextLine());
    }
}
