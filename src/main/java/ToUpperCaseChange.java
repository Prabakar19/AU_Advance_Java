import java.lang.reflect.Field;
import java.time.LocalDate;

public class ToUpperCaseChange {

    public static void toUpper(Object object) throws IllegalArgumentException, IllegalAccessException{
        Class<?> objectClass = object.getClass();
        for(Field field : objectClass.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(ToUpper.class)){
                ToUpper addDate = field.getAnnotation(ToUpper.class);
                if(addDate.toUpper())
                    field.set(object, field.get(object).toString().toUpperCase());
            }
        }
    }
}