package com.exam.examportal.service.impl;

import com.exam.examportal.model.exam.Question;
import com.exam.examportal.model.exam.Quiz;
import com.exam.examportal.repository.QuestionRepository;
import com.exam.examportal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>( this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public void deleteQuestion(Long questionId) {
        Question question = new Question();
        question.setQuesId(questionId);
         this.questionRepository.delete(question);
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public Question get(Long questionId) {
        return this.questionRepository.getOne(questionId);
    }

}
