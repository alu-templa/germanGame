import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Student currentStudent;
        Question currentQuestion;
        ArrayList<Student> studentArrayList;
        ArrayList<Question> questionArrayList;
        Scanner input;

        Round round = new Round();

        studentArrayList = new ArrayList<>();
        try{
            File studentFile = new File("students.txt");
            input = new Scanner(studentFile);
            while(input.hasNextLine()){
                String studentToAdd = input.nextLine();
                Student student = new Student(studentToAdd, 0);
                studentArrayList.add(student);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        questionArrayList = new ArrayList<>();
        try{
            File questionFile = new File("questions.txt");
            input = new Scanner(questionFile);
            while(input.hasNextLine()){
                String questionToAdd = input.nextLine();
                Question question = new Question(questionToAdd, 1);
                questionArrayList.add(question);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

//        currentStudent = Student.findStudent(studentArrayList, round);
//        currentQuestion = Question.findQuestion(questionArrayList);

//        currentStudent.studentFailed(questionArrayList, currentQuestion);
//        currentStudent.studentScored(questionArrayList, currentQuestion);

        Gui gui = new Gui(studentArrayList, questionArrayList, round);
        gui.viewGui();
    }
}
