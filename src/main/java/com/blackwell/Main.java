package com.blackwell;

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

            switch (cmd[0]) {
                case "info":
                    ci.printProblemInfo(Integer.parseInt(cmd[1]));
                    break;
                case "run":
                    ci.runProblem(Integer.parseInt(cmd[1]));
                    break;
                case "help":
                    System.out.println("To run problem enter: run %ProblemNumber%" +
                            "\nTo print problem info enter: info %ProblemNumber%" +
                            "\nTo get help enter: help" +
                            "\nTo exit enter: exit");
                    break;
                case "exit":
                    isExit = true;
                    break;
                default:
                    System.out.println("Not a command.");
                    break;
            }
        }
    }
}