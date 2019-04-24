import java.util.ArrayList;
import java.util.Random;

public class Question {
    private String name;
    private int pointsWorth;

    public String getName() {
        return name;
    }

    public int getPointsWorth() {
        return pointsWorth;
    }

    public Question(String name, int pointsWorth) {
        this.name = name;
        this.pointsWorth = pointsWorth;
    }
    public Question(){
        this.name = "Out of Questions";
        this.pointsWorth = 0;
    }
    public static Question findQuestion(ArrayList<Question> questionArrayList){
        Random rand = new Random();

        if(questionArrayList.size() > 0) {
            int questionIndex = rand.nextInt(questionArrayList.size());
            return questionArrayList.get(questionIndex);
        }
        return new Question();
    }
}
