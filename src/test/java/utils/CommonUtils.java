package utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {

    public static int getRandomNumber() {
        final Random rand = new Random();
        return rand.nextInt(10000) + 1;
    }

    public String getTimeStamp() {
        final String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(Calendar.getInstance().getTime());
        return timeStamp;
    }
}
