import java.util.ArrayList;
import java.util.Random;

public class Student {
    private String name;
    private int score;
    private int round;

    public int getRound() {
        return round;
    }

    private void setRound(int round) {
        this.round = round;
    }


    public String getName() {
        return name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void tickRound(){
        setRound(round + 1);
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        this.round = 0;
    }

    public void studentScored(ArrayList<Question> questionArrayList, Question question){
        this.setScore(this.getScore() + question.getPointsWorth());
        questionArrayList.remove(question);
        this.tickRound();
    }

    public void studentFailed(ArrayList<Question> questionArrayList, Question question){
        questionArrayList.remove(question);
        this.tickRound();
    }

    private static void studentSpinner(ArrayList<Student> studentArrayList, int studentIndex){
        for(int i = 0; i <= studentIndex; i++){
//            TODO: use this to cycle through the names of students before selecting one
            System.out.println("name " + studentArrayList.get(i).getName());
        }
    }

    public static Student findStudent(ArrayList<Student> studentArrayList, Round round){
        Random rand = new Random();
        ArrayList<Student> temp = new ArrayList<>();
        for(Student student : studentArrayList){
            if(student.getRound() < round.getRound()){
                temp.add(student);
            }
        }
        if(temp.size() > 0){
            int studentIndex = rand.nextInt(temp.size());
            return temp.get(studentIndex);
//            studentSpinner(studentArrayList, studentIndex);
//            return currentStudent;
        }
        round.tickRound();
        return findStudent(studentArrayList, round);
    }
}