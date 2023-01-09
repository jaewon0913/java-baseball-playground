import solution.AnswerCheck;
import solution.MakeAnswer;
import solution.WriteAnswer;

import java.util.Scanner;


public class Solution {

    public static void main(String[] args){

        do {
            String answer = new MakeAnswer().getAnswerNum();
            System.out.println(answer);
            playGame(answer);
        } while (reset());
    }

    public static void playGame(String answer) {
        while(new AnswerCheck().check(answer, WriteAnswer.write())){
        }
    }

    public static boolean reset() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int resetNum = sc.nextInt();

        if (resetNum == 1) {
            return true;
        }
        return false;
    }
}
