import java.util.Scanner;
/*
git commit -m "Title" -m "Description ..........";

git add .
git reset -- somefolder_to_exclude
 */
public class Main { // мой код - мои комменты
    public static void main(String[] args) {
        ConsoleInterface ci=new ConsoleInterface();

        System.out.println("Enter problem number: \n(To see full list enter zero.)");
        Scanner in = new Scanner(System.in);
        int ProblemNum = in.nextInt();

        if (ProblemNum == 0)
            ci.printPrblemsList();
        else
            ci.runProblem(ProblemNum);
    }
}