import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args){

        //  숫자 랜덤 생성
        String answer = createAnswer();

        //  게임 Start
        String readAnswer = "";
        while(answerCheck(answer, writeAnswer())){
        }
    }

    //  랜덤 수 생성
    public static String createAnswer(){

        String answer = "";
        Set<Integer> set = new HashSet<>();

        //  중복 없는 수 생성(3자리)
        while (setNum(set)){
            int randomNum = (int)(Math.random() * 9) + 1;
            set.add(randomNum);
        }

        //  String 으로 변환
        for(int randomNum : set){
            String numberStr = Integer.toString(randomNum);
            answer+=numberStr;
        }

        return answer;
    }

    public static boolean setNum(Set<Integer> set){
        if(set.size() == 3){
            return false;
        }

        return true;
    }

    //  정답 입력
    public static String writeAnswer(){

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");

        return sc.next();
    }

    //  정답 체크
    public static boolean answerCheck(String answer, String readAnswer){

        int strike = 0 ;
        int ball = 0;
        boolean nothing = true;

        for(int i = 0 ; i < 3 ; i ++){
            strike = strikeCheck(i, answer, readAnswer, strike);
            ball = ballCheck(i, answer, readAnswer, ball);
            nothing = nothingCheck(strike, ball);
        }

        printAnswer(strike, ball, nothing);

        if(strike == 3){
            System.err.println("정답입니다.");
            return false;
        }

        return true;
    }

    //  정답 체크
    public static void printAnswer(int strike, int ball, boolean nothing){
        if(nothing){
            System.out.println("낫띵");
        }

        if(!nothing){
            ball = ball - strike;
            System.out.println(makeHintAnswer(strike, ball));
        }
    }

    public static String makeHintAnswer(int strike, int ball){
        String hintAnswer = "";
        if(strike > 0){
            hintAnswer += strike + " 스트라이크 ";
        }

        if(ball > 0) {
            hintAnswer += ball + " 볼";
        }

        return hintAnswer;
    }

    public static int strikeCheck(int i, String answer, String readAnswer, int strike){
        if(answer.charAt(i) == readAnswer.charAt(i)){
            return strike+=1;
        }

        return strike;
    }

    public static int ballCheck(int i, String answer, String readAnswer, int ball){
        if(answer.indexOf(readAnswer.charAt(i)) != -1){
            return ball+=1;
        }

        return ball;
    }

    public static boolean nothingCheck(int strike, int ball){
        if(strike == 0 && ball == 0){
            return true;
        }

        return false;
    }
}
