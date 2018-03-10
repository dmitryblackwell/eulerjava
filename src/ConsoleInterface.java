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

    public void printPrblemsList(){ // print full problems list
        ConnectionToDatabase connection = new ConnectionToDatabase();
        for(int i =1;i<=ProblemSolved;++i){
            System.out.println(i+". "+connection.getCell(ConnectionToDatabase.COLUMN_TITLE,i));
        }
        connection.closeDB();
    }
    public void printProblemInfo(int id){
        ConnectionToDatabase connection = new ConnectionToDatabase();

        System.out.println("Id: "+connection.getCell(ConnectionToDatabase.COLUMN_ID,id)
                            +"\nTitle: "+connection.getCell(ConnectionToDatabase.COLUMN_TITLE,id)
                            +"\nDescription: "+connection.getCell(ConnectionToDatabase.COLUMN_DESCRIPTION,id));

        connection.closeDB();
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
        return "com.blackwell.level_"+String.format("%02d",LevelNum)+
                ".Problem_"+String.format("%03d",problemNum);
    }

}
