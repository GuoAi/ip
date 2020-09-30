package duke.common;

public class Utils {

    public static boolean stringToBoolean(String str) {
        if (str.equals("0")) {
            return false;
        }
        return true;
    }

}
