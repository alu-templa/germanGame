import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JFrame implements ActionListener {
    private Student currentStudent;
    private Question currentQuestion;
    private ArrayList<Student> studentArrayList;
    private ArrayList<Question> questionArrayList;
    private Round round;

    private JPanel panel;

    private JTextArea textAreaStudent;
    private JTextArea textAreaQuestion;
    private JTextArea textAreaLeaderboard;

    private JScrollPane scrollPaneStudent;
    private JScrollPane scrollPaneQuestion;
    private JScrollPane scrollPaneLeaderboard;

    private JButton b1;
    private JButton b2;
    private JButton b3;

    public Gui(ArrayList<Student> studentArrayList, ArrayList<Question> questionArrayList, Round round){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setAlwaysOnTop(true);
        int width = dimension.width / 5;
        int height = dimension.height / 15;

        this.setLocation(width, height);
        this.panel = new JPanel();

        this.textAreaStudent = new JTextArea(10, 25);
        textAreaSettings(textAreaStudent);
        this.scrollPaneStudent = new JScrollPane(textAreaStudent);

        this.textAreaQuestion = new JTextArea(10, 25);
        textAreaSettings(textAreaQuestion);
        this.scrollPaneQuestion = new JScrollPane(textAreaQuestion);

        this.textAreaLeaderboard = new JTextArea(25, 25);
        textAreaSettings(textAreaLeaderboard);
        this.scrollPaneLeaderboard = new JScrollPane(textAreaLeaderboard);

//        width = dimension.width / 2;
//        height = dimension.height / 2;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(969, 800);

        b1 = new JButton("Eine Frage?");
        b1.addActionListener(this);
        b1.setActionCommand("b1");

        b2 = new JButton("Ja, Sehr Gut!");
        b2.addActionListener(this);
        b2.setActionCommand("b2");

        b3 = new JButton("Nein, Nicht So Gut");
        b3.addActionListener(this);
        b3.setActionCommand("b3");

//        textFieldStudent = new JTextField("");
//        textFieldStudent.setColumns(20);
//        textFieldQuestion = new JTextField("");
//        textFieldQuestion.setColumns(20);

        panel.add(scrollPaneStudent);
        panel.add(scrollPaneQuestion);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(scrollPaneLeaderboard);


        this.getContentPane().add(BorderLayout.SOUTH, panel);
        this.getContentPane().add(BorderLayout.WEST, scrollPaneStudent);
        this.getContentPane().add(BorderLayout.CENTER, scrollPaneQuestion);
        this.getContentPane().add(BorderLayout.EAST, scrollPaneLeaderboard);

        textAreaQuestion.setText("");
        textAreaStudent.setText("");
        textAreaLeaderboard.setText("");

        this.studentArrayList = studentArrayList;
        this.questionArrayList = questionArrayList;
        this.round = round;

        printLeaderboard(studentArrayList, round);
    }

    private void textAreaSettings(JTextArea textArea) {
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    public void viewGui() {
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonPress = e.getActionCommand();
        switch(buttonPress) {
            case "b1":
                currentQuestion = Question.findQuestion(questionArrayList);
                currentStudent = Student.findStudent(studentArrayList, round);
                printStudent(currentStudent);
                printQuestion(currentQuestion);
                printLeaderboard(studentArrayList, round);
                break;
            case "b2":
                if(currentStudent != null && currentQuestion != null){
                    currentStudent.studentScored(questionArrayList, currentQuestion);
                    printLeaderboard(studentArrayList, round);
                    currentQuestion = null;

                    printGG();
                } else {
                    textAreaQuestion.append("\n...Eine Frage, bitte.");
                }
                break;
            case "b3":
                if(currentStudent != null && currentQuestion != null){
                    currentStudent.studentFailed(questionArrayList, currentQuestion);
                    printLeaderboard(studentArrayList, round);
                    currentQuestion = null;

                    printFF();
                } else {
                    textAreaQuestion.append("\n...Eine Frage, bitte.");
                }
        }
    }

    private void printLeaderboard(ArrayList<Student> studentArrayList, Round round){
        textAreaLeaderboard.setText("Current Round: " + round.getRound() + "\n");
        for(Student s : studentArrayList){
            textAreaLeaderboard.append(s.getName() + " " + s.getScore() + "\n");
        }
    }

    private void printStudent(Student student){
        textAreaStudent.setText(student.getName());
    }

    private void printQuestion(Question question){
        textAreaQuestion.setText(question.getName());
    }
    private void printGG() {
        textAreaQuestion.setText("");
        textAreaQuestion.append(";ˊ ` ` ` ` ` ` ` ` ` ` ` ` ` ` `'F'¯'''''L ` ` ` ` ` ` ` ` ` ` ` ` \n");
        textAreaQuestion.append("` ` ` ` ` ` ` ` ` ` ` ` ` ` ` `'[``…'¾`` ``` ``` ``` ``` \n");
        textAreaQuestion.append("` ` ` ` ` ` ` ` ` ` ` ` ` ` ` `'[```…ʹ[` ` ` ` ``` ``` ``` \n");
        textAreaQuestion.append("` ` ` ` ` ` ` ` ` ` ` ` ` ` ` `#````ˆ[```` ``` ``` ``` ``\n");
        textAreaQuestion.append("` ` ` ` ` ` ` ` ` ` ` ` ` ` `'#``…``'[`… ` ` ` ` ` ` ` ` `\n");
        textAreaQuestion.append("` ` ` ` ` ` ` ` ` ` ` ` ` ` #…`````'F`` ` ` ` `` ``` ``` \n");
        textAreaQuestion.append("` ` ` ` ` ` ` ` ` ` ` ` ` ƒ¯```````'[__` ` ` ` ` ` ` ``` ``\n");
        textAreaQuestion.append("` ` ` ` ` ` ` ` ` ` ` ` ƒ¯````````ʹ¯¯¯¯''''''''''''¯¯¯¯¯¯™[ ` \n");
        textAreaQuestion.append("gµµµµµµµµµµµµµµ_µ™`````````````````````````'# ` \n");
        textAreaQuestion.append("'₫₫₫₫₫₫₫₫₫₫₫₫₫F¯…`````````````````````` ` ²q[¯ ` `\n");
        textAreaQuestion.append("ʹ₫₫₫₫₫₫₫₫₫₫₫₫¾````````````````````````````ʹ} … `\n");
        textAreaQuestion.append("›₫₫₫₫₫₫₫₫₫₫₫₫#`````````````````````````__µr… ` `\n");
        textAreaQuestion.append("³₫₫₫₫₫₫₫₫₫₫₫₫₫…`````````````````````````¯[ … ` `\n");
        textAreaQuestion.append("`₫₫₫₫₫₫₫₫₫₫₫₫$``````````````````````````_F … ` `\n");
        textAreaQuestion.append("`]₫₫₫₫₫₫₫₫₫₫₫#````````````````````````ʹ''''[… … ` `\n");
        textAreaQuestion.append("`'₫₫₫₫₫₫₫F''''']₫#___`````````````````````` '# … ` ` \n");
        textAreaQuestion.append("…₫₫₫₫₫₫₫bµ₫₫₫₫$¯''''¹uuuuuɷuɷuɷuɷuɷuɷµ#¯ ` ` ` ` `\n");
        textAreaQuestion.append("…'''''''™''''™'''™''''™™ … … ` ` ` ` ` ` ` ` ` ` ` ` … … ` ` ` \n");
        textAreaQuestion.append("` … ` ` ` ` ` ` ` ` … ` … ` ` ` ` ` ` ` ` ` ` ` … ` ` ` ` `.\n");
    }

    private void printFF() {
        textAreaQuestion.setText("NEIN");
    }
}