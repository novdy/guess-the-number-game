package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator{
    // == fields ==
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

//    Setter dependency injection
//    @Autowired
//    @MinNumber
    private final int minNumber;

//    Setter dependency injection
//    @Autowired
//    @MaxNumber
    private final int maxNumber;

    // == constructors ==
    //Constructor dependency injection
    @Autowired
    public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber){
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

//    @Override
//    public int getMaxNumber() {
//        return maxNumber;
//    }
//
//    @Override
//    public int getMinNumber() {
//        return minNumber;
//    }
}
