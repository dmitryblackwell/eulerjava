import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main { // мой код - мои комменты
    private static final double MEGABYTE = 1024L * 1024L;

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory());
        ConsoleInterface ci=new ConsoleInterface();
        boolean isExit = false;
        //ci.runProblem(12);
        while (!isExit){
            System.out.print("cmd: ");
            Scanner in = new Scanner(System.in);
            String cmdLine = "run 13"; //in.nextLine();
            String[] cmd = cmdLine.split(" ");
            if (cmd[0].equals("print")){
                if(cmd[1].equals("problems"))
                    ci.printPrblemsList();
                if(cmd[1].equals("problem"))
                    ci.printProblemInfo(Integer.parseInt(cmd[2]));
            }
            if(cmd[0].equals("run")) {
                DecimalFormat df = new DecimalFormat("#.###");
                df.setRoundingMode(RoundingMode.CEILING);
                long startTime=System.nanoTime();
                long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

                ci.runProblem(Integer.parseInt(cmd[1]));

                long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
                long endTime=System.nanoTime();
                String actualUsedMem=df.format((afterUsedMem-beforeUsedMem)/MEGABYTE);
                String timeAtWork = df.format((endTime - startTime)*Math.pow(10,-9));

                System.out.println("Memory: "+actualUsedMem+" mb;");
                System.out.println("Time: "+ timeAtWork +" sec;");
            }
            if(cmd[0].equals("help"))
                System.out.println("To run problem enter: run %ProblemNumber%" +
                        "\nTo print all problems list enter: print problems" +
                        "\nTo print problem info enter: print problem %ProblemNumber%" +
                        "\nTo get help enter: help"+
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
