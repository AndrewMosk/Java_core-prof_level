package Lesson_6;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class m {
    private static final Logger logger  = Logger.getLogger("");
    public static void main(String[] args) throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");

        Handler handler = new FileHandler("mylog.log", true);
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" +  dateFormat.format( new Date() ) + "\n";
            }
        });

        logger.addHandler(handler);
        logger.log(Level.INFO, "Java2");
    }
}
