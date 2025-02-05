package tim.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tim.model.Quiz;
import tim.model.Topic;

class QuizControllerTest {
    QuizController quizController;
    @BeforeEach
    void setUp(){
        quizController = new QuizController();
    }
    
    @Test
    void addAndGetQuiz(){
        Quiz quiz = new Quiz(1, "Fun facts quiz", Topic.GENERAL);
        assertAll("Add and Get quiz",
            () -> {assertTrue(quizController.addQuiz(quiz));},
            () -> {assertFalse(quizController.addQuiz(quiz));},
            () -> {assertEquals(quiz, quizController.getQuizById(1));},
            () -> {assertNull(quizController.getQuizById(2));}
        );
    }
    
    @AfterEach
    void tearDown(){
        quizController = null;
    }
    
}