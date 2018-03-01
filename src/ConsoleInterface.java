import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
// мне так стыдно за этот код
// простите меня пожалуйста
public class ConsoleInterface {
    private static final int ProblemSolved = 3;

    public void runProblem(int problemNum){
        String className=getClassName(problemNum);
        Class problem = getClass(className);

        Constructor constructor = getConstructor(problem);
        Object classObj = getObject(constructor);
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

    // если что-то пошло не так... Jonny, we fucked
    /*private Object getFieldValue(Class myClass, Object obj,String fieldName){
        try {
            Field field = myClass.getField(fieldName);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Object getObject(Class myClass){
        try {
            return myClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }*/
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
        return "com.blackwell.level_"+String.format("%02d",(int)Math.floor(problemNum/25)+1)+
                ".Problem_"+String.format("%03d",problemNum);
    }

}
