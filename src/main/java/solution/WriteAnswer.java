package solution;

import java.util.Scanner;

public class WriteAnswer {

    public static String write(){

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");

        int writeNum = sc.nextInt();

        //  TODO : 입력 값도 중복값 안되도록 해야함
        //  TODO : 4자리 이상 입력 안되도록 해야함

        return String.valueOf(writeNum);
    }
}
