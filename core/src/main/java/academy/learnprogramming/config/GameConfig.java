package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "academy.learnprogramming")
public class GameConfig {

    // == fields ==
    // The colon represents a default value if one can't be found
    @Value("${game.minNumber:-100}")
    private int minNumber;

    @Value("${game.maxNumber:100}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    // == bean methods ==
    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
}
