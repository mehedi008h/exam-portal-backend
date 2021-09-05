package com.exam.examportal.service;

import com.exam.examportal.model.exam.Category;
import com.exam.examportal.model.exam.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes();
    public Quiz getQuiz(Long quizId);
    public void deleteQuiz(Long quizId);
    public List<Quiz> getQuizOfCategory(Category category);
    public List<Quiz> getActiveQuizzes();
    public List<Quiz> getActiveQuizzesOfCategory(Category c);
}
