import java.util.Calendar;
import java.util.Timer;

/**
 * Created by EvanKing on 7/8/16.
 */
public class Main {
    public static void main(String[] args){
        scheduler();
    }

    public static void scheduler(){
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        date.set(
                Calendar.DAY_OF_WEEK,
                Calendar.SUNDAY
        );
        date.set(Calendar.HOUR, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        // Schedule to run every Sunday in midnight
        timer.schedule(
                new SendMail(),
                date.getTime(),
                1000 * 60 * 60 * 5
        );
    }
}
