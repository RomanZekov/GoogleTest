package conf.report;

import org.apache.log4j.Layout;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;



/**
 * Created by User on 24.11.2015.
 */
public class ReportNGAppender extends AppenderSkeleton{

    protected void append(LoggingEvent loggingEvent) {
        final Layout layout = getLayout();
        final String valueToLog;
        if (layout != null) {
            valueToLog = layout.format(loggingEvent);
        } else {
            valueToLog = loggingEvent.getMessage().toString();
        }

        Logger.log(valueToLog);
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return true;
    }
}