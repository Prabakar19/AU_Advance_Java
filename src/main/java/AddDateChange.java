import java.lang.reflect.Field;
import java.time.LocalDate;

public class AddDateChange {
    public static void addDate(Object object) throws IllegalArgumentException, IllegalAccessException {
        Class<?> objectClass = object.getClass();

        for(Field field : objectClass.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(AddDate.class)){
                AddDate addDate = field.getAnnotation(AddDate.class);
                if(addDate.addDate())
                    field.set(object, LocalDate.now());
            }
        }
    }
}
