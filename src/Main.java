import java.util.Scanner;

public class Main { // мой код - мои комменты
    public static void main(String[] args) {
        ConsoleInterface ci=new ConsoleInterface();
        boolean isExit = false;
        while (!isExit){
            System.out.print("cmd: ");
            Scanner in = new Scanner(System.in);
            String cmdLine = in.nextLine();
            String[] cmd = cmdLine.split(" ");
            if (cmd[0].equals("print")){
                if(cmd[1].equals("problems"))
                    ci.printPrblemsList();
                if(cmd[1].equals("problem"))
                    ci.printProblemInfo(Integer.parseInt(cmd[2]));
            }
            if(cmd[0].equals("run"))
                ci.runProblem(Integer.parseInt(cmd[1]));
            if(cmd[0].equals("help"))
                System.out.println("To run problem enter: run *ProblemNumber*" +
                        "\nTo print all problems list enter: print problems" +
                        "\nTo print problem info enter: print problem *ProblemNumber*" +
                        "\nTo exit enter: exit");
            if(cmd[0].equals("exit"))
                isExit=true;
        }
    }
}
// run 1
// print problems
// print problem 1
// help
//exit
