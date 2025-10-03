import java.util.*;

class Question {
    String question;
    List<String> options;
    String answer;

    Question(String question, List<String> options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> quiz = new ArrayList<>();

        quiz.add(new Question("What are Java loops?",
                Arrays.asList("1. Control flow", "2. Variables", "3. Methods", "4. Classes"), "1"));
        quiz.add(new Question("What is enhanced for-loop?",
                Arrays.asList("1. For int only", "2. For collections", "3. For while", "4. None"), "2"));
        quiz.add(new Question("How do you handle multiple user inputs?",
                Arrays.asList("1. Loops", "2. Switch", "3. Scanner", "4. All of these"), "4"));
        quiz.add(new Question("How is switch-case different from if-else?",
                Arrays.asList("1. Faster", "2. Slower", "3. Equal", "4. None"), "1"));
        quiz.add(new Question("What are collections in Java?",
                Arrays.asList("1. Data structure framework", "2. Only arrays", "3. Operators", "4. None"), "1"));
        quiz.add(new Question("What is ArrayList?",
                Arrays.asList("1. Fixed array", "2. Dynamic array", "3. HashMap", "4. Iterator"), "2"));
        quiz.add(new Question("How to iterate using iterators?",
                Arrays.asList("1. next()", "2. hasNext()", "3. Both 1 and 2", "4. None"), "3"));
        quiz.add(new Question("What is a Map?", Arrays.asList("1. Key-Value pair", "2. List", "3. Array", "4. None"),
                "1"));
        quiz.add(new Question("How to sort a list?",
                Arrays.asList("1. Collections.sort()", "2. Arrays.sort()", "3. Both", "4. None"), "3"));
        quiz.add(new Question("How to shuffle elements?",
                Arrays.asList("1. Random", "2. Collections.shuffle()", "3. Sort", "4. None"), "2"));

        Collections.shuffle(quiz);

        int score = 0;
        int qno = 1;

        for (Question q : quiz) {
            System.out.println("Q" + qno + ": " + q.question);
            for (String opt : q.options) {
                System.out.println(opt);
            }
            System.out.print("Enter your answer: ");
            String ans = sc.next();
            if (ans.equals(q.answer)) {
                score++;
            }
            qno++;
            System.out.println();
        }

        System.out.println("Quiz Over! Your Score: " + score + "/" + quiz.size());

        Map<String, Integer> result = new HashMap<>();
        result.put("Your Score", score);
        System.out.println("Result Map: " + result);

        List<Integer> marks = new ArrayList<>();
        marks.add(2);
        marks.add(5);
        marks.add(1);
        Collections.sort(marks);
        System.out.println("Sorted Marks: " + marks);
    }
}
