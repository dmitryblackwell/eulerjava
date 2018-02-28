import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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

    public void printPrblemsList(){
        for(int i =1;i<=ProblemSolved;++i){
            String className = getClassName(i);
            Class<?> problem = getClass(className);
            Object classObj = getObject(problem);
            System.out.println(i+". "+getFieldValue(problem,classObj));
        }
    }

    // если что-то пошло не так... Jonny, we fucked
    private Object getFieldValue(Class myClass, Object obj){
        try {
            Field field = myClass.getField("NAME");
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
        return "com.blackwell.level_"+String.format("%02d",(int)Math.floor(problemNum/25)+1)+
                ".Problem_"+String.format("%03d",problemNum);
    }

}
