package academy.learnprogramming.console;

import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    //Deleted because we're using Lombock
    //private static final Logger log = LoggerFactory.getLogger(Main.class);

    //private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        //create context (container)
//        ConfigurableApplicationContext context
//                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);

//        // get numberGenerator bean from context (container)
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//
//        //call method next() to get random number
//        int number = numberGenerator.next();
//
//        //log generated number
//        log.info("number = {}", number);
//
//        // get game bean from context (container)
//        Game game = context.getBean(Game.class);
//
//        // get the messageGenerator bean from context (container)
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.info(messageGenerator.getMainMessage());
//        log.info(messageGenerator.getResultMessage());

        //close context (container)
        context.close();
    }
}
