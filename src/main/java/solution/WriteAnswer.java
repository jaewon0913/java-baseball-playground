package solution;

import java.util.Scanner;

public class WriteAnswer {

    public static String write(){

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");

        int writeNum = sc.nextInt();

        return String.valueOf(writeNum);
    }
}
