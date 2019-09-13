package com.blackwell;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

// мне так стыдно за этот код
// простите меня пожалуйста
public class ConsoleInterface {

    private static final int ProblemSolved = 3;
    private static final double MEGABYTE = 1024L * 1024L;

    public void runProblem(int problemNum){
        String className=getClassName(problemNum);
        Class problem = getClass(className);

        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);
        long startTime=System.nanoTime();
        //long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

        Constructor constructor = getConstructor(problem);
        Object classObj = getObject(constructor);


        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long endTime=System.nanoTime();
        //String actualUsedMem=df.format((afterUsedMem-beforeUsedMem)/MEGABYTE);
        String timeAtWork = df.format((endTime - startTime)*Math.pow(10,-9));

        //System.out.println("Memory: "+actualUsedMem+" mb;");
        System.out.println("Time: "+ timeAtWork +" sec;");
    }

    public void printProblemInfo(int id){
        EulerProblemHelper eulerProblemHelper = new EulerProblemHelper();
        try {
            System.out.println("Id: " + id
                                +"\nTitle: " + eulerProblemHelper.getTitle(id)
                                +"\nDescription\n: " + eulerProblemHelper.getDescription(id));
        } catch (IOException e) {
            System.out.println("Something went wrong (maybe internet connection).");
        };
    }

    private Object getObject(Constructor constructor){
        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Class getClass(String className){
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Constructor getConstructor(Class myClass){
        try {
            return myClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
    private String getClassName(int problemNum){//return full class name(level,package,number)
        int LevelNum = (int)Math.floor(problemNum/25) + (problemNum%25 == 0 ? 0 : 1);
        return "com.blackwell.level"+String.format("%02d",LevelNum)+
                ".Problem"+String.format("%03d",problemNum);
    }

}
