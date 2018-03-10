import java.util.Scanner;
// TODO history of cmd activity
public class Main { // мой код - мои комменты
    public static void main(String[] args) {
        ConsoleInterface ci=new ConsoleInterface();
        boolean isExit = false;
        //ci.runProblem(24);
        while (!isExit){
            System.out.print("cmd: ");
            Scanner in = new Scanner(System.in); // ты пидор
            String cmdLine = in.nextLine();
            String[] cmd = cmdLine.split(" ");

            if (cmd[0].equals("print") && cmd[1].equals("problems")){
                ci.printPrblemsList();
            }
            else if(cmd[0].equals("info"))
                ci.printProblemInfo(Integer.parseInt(cmd[1]));
            else if(cmd[0].equals("run")) {
                ci.runProblem(Integer.parseInt(cmd[1]));
            }
            else if(cmd[0].equals("help"))
                System.out.println("To run problem enter: run %ProblemNumber%" +
                        "\nTo print all problems list enter: print problems" +
                        "\nTo print problem info enter: info %ProblemNumber%" +
                        "\nTo get help enter: help"+
                        "\nTo exit enter: exit");
            else if(cmd[0].equals("exit"))
                isExit=true;
            else
                System.out.println("Not a command.");
        }
    }
}