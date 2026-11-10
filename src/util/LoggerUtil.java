//@author Knobs
package util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerUtil {
    private static final String LOG_FILE = "meridian_audit.log";
    public static void log(String action,String user){
        try(FileWriter writer = new FileWriter("meridian_audit.log",true)){
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format
            (new Date());

            writer.write(timestamp + " | " + action + " | User: " + user + System.lineSeparator());

        }catch(IOException e){
            e.printStackTrace();
        }//end catch
    }//end log method
}//end class
