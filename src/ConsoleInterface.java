import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConsoleInterface {
    private static final int ProblemSolved = 3;

    public ConsoleInterface() {
        System.out.println("ConsoleInterface constructor");
        //doSomething
    }

    public void runProblem(int problemNum){
        System.out.println("Fuck!!!");
        try {
            String className="com.blackwell.level_"+String.format("%02d",(int)Math.floor(problemNum/25)+1)+
                    ".Problem_"+String.format("%03d",problemNum);
            Class problem = Class.forName(className);
            Constructor constructor = problem.getDeclaredConstructor();
            Object classObj = constructor.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void printPrblemsList(){
        try {
            for(int i =0;i<ProblemSolved;++i){
                String ClassName = getClassName(i);
                String FieldName = "NAME";
                Class<?> problem = Class.forName(ClassName);
                Object classObj = problem.newInstance();
                Field field = problem.getField(FieldName);
                System.out.println(i+1+". "+field.get(classObj));
            }
        } catch (ClassNotFoundException e) { // если что-то пошло не так... Jonny, we fucked
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    private String getClassName(int problemNum){//return full class name(level,package,number)
        return "com.blackwell.level_"+String.format("%02d",(int)Math.floor(problemNum/25)+1)+
                ".Problem_"+String.format("%03d",problemNum+1);
    }

}
