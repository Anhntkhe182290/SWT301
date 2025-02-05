package tim.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tim.model.Quiz;
import tim.model.Topic;

class InputValidatorTest {
    private ArrayList<Quiz> existingQuizzes;
    
    @BeforeEach
    void setUp(){
        existingQuizzes = new ArrayList<>();
        existingQuizzes.add(new Quiz(1, "FUN QUIZ", Topic.GENERAL));
    }
    
    @AfterEach
    void tearDown(){
        existingQuizzes.clear();
    }
    
    @Test
    void validateQuizId(){
        InputValidator inputValidator = new InputValidator();
        assertAll("Validate quiz IDs",
            () -> {assertTrue(inputValidator.validateQuizId(2, existingQuizzes));},
            () -> {assertFalse(inputValidator.validateQuizId(1, existingQuizzes));},
            () -> {assertFalse(inputValidator.validateQuizId(-1, existingQuizzes));}
        );
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void validateNumberOfOptions(int numberOfOptions){
        InputValidator inputValidator = new InputValidator();
        if(numberOfOptions < 2){
            assertFalse(inputValidator.validateNumberOfOptions(numberOfOptions));
        }else {
            assertTrue(inputValidator.validateNumberOfOptions(numberOfOptions));
        }
    }

}