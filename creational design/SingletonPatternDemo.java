// Singleton Logger Class
class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Main Class
public class SingletonPatternDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("This is a singleton logger instance.");
        
        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("This is the same singleton logger instance.");
        
        System.out.println("Are both loggers the same instance? " + (logger == anotherLogger));
    }
}
