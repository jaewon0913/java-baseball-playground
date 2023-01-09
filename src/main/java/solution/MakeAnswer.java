package solution;

import java.util.HashSet;
import java.util.Set;

public class MakeAnswer {

    private String answerNum;

    public MakeAnswer() {
        makeNum();
    }

    public String getAnswerNum() {
        return this.answerNum;
    }

    //  정답 만들기
    private void makeNum(){

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

        this.answerNum = answer;
    }

    private boolean setNum(Set<Integer> set){
        if(set.size() == 3){
            return false;
        }

        return true;
    }
}
