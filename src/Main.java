import java.lang.reflect.Field;
import java.util.Scanner;
/*
git commit -m "Title" -m "Description ..........";

git add .
git reset -- somefolder_to_exclude
 */
public class Main { // мой код - мои комменты
    private static final int ProblemSolved = 3;
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Enter problem number: \n (To see full list enter zero.)");
        Scanner in = new Scanner(System.in);
        int ProblemNum = in.nextInt();
        switch (ProblemNum){
            case 0:
                PrintPrblemsList();
        }
    }
    private static void PrintPrblemsList(){
        try {
            for(int i =0;i<ProblemSolved;++i){
                String ClassName= "com.blackwell.level_"+String.format("%02d",(int)Math.floor(ProblemSolved/25)+1)+
                        ".Problem_"+String.format("%03d",i+1);
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
}
