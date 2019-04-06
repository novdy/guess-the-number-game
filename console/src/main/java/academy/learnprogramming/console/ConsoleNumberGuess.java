package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess { //implements ApplicationListener<ContextRefreshedEvent> {
    // == constants ==
    //private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == fields ==
    // Setter dependency injection
//    @Autowired
    private Game game;

//    @Autowired
    private MessageGenerator messageGenerator;

    // == constructors ==
    // Constructor dependency injection
    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator){
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == events ==
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        log.info("IMPLEMENTING ApplicationListener<ContextRefreshedEvent>");
//    }

//    @EventListener
//    public void start(ContextRefreshedEvent contextRefreshedEvent) {
//        log.info("start() -> Container ready for use.");
//    }

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again? y/n");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }

                game.reset();
            }
        }
        log.info("start() -> Container ready for use.");
    }
}
