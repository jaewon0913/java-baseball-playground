package solution;

public class AnswerCheck {

    //  정답 확인
    public boolean check(String answer, String readAnswer){

        int strike = 0 ;
        int ball = 0;
        boolean nothing = true;

        for(int i = 0 ; i < 3 ; i ++){
            strike = strikeCheck(i, answer, readAnswer, strike);
            ball = ballCheck(i, answer, readAnswer, ball);
            nothing = nothingCheck(strike, ball);
        }

        //  결과 출력
        printAnswer(strike, ball, nothing);

        //  3스트라이크면 게임 종료
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        return true;
    }

    private void printAnswer(int strike, int ball, boolean nothing){
        if(nothing){
            System.out.println("낫띵");
        }

        if(!nothing){
            ball = ball - strike;
            System.out.println(makeHintAnswer(strike, ball));
        }
    }

    private String makeHintAnswer(int strike, int ball){
        String hintAnswer = "";
        if(strike > 0){
            hintAnswer += strike + " 스트라이크 ";
        }

        if(ball > 0) {
            hintAnswer += ball + " 볼";
        }

        return hintAnswer;
    }

    private int strikeCheck(int i, String answer, String readAnswer, int strike){
        if(answer.charAt(i) == readAnswer.charAt(i)){
            return strike += 1;
        }

        return strike;
    }

    private int ballCheck(int i, String answer, String readAnswer, int ball){
        if(answer.indexOf(readAnswer.charAt(i)) != -1){
            return ball += 1;
        }

        return ball;
    }

    private boolean nothingCheck(int strike, int ball){
        if(strike == 0 && ball == 0){
            return true;
        }

        return false;
    }
}
