package com.example.semana_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>;

    var positionOfQuestions = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createQuestions();
        loadQuestion();
        setUpEventOfButtons();
    }

    fun setUpEventOfButtons() {
        btnYes.setOnClickListener() {
            evaluateQuestion(true);
        }

        btnNo.setOnClickListener() {
            evaluateQuestion(false);
        }

        btnNext.setOnClickListener() {
            if (positionOfQuestions < (questions.size - 1)) {
                positionOfQuestions++;
                loadQuestion();
            }
        }

        btnBack.setOnClickListener() {
            if (positionOfQuestions > 0) {
                positionOfQuestions--;
                loadQuestion();
            }
        }
    }

    fun createQuestions() {
        questions = ArrayList();
        lateinit var question: Question;
        question = Question("Es lima la capital de Chile", false);
        questions.add(question)
        question = Question("Es lima la capital de Hungria", false);
        questions.add(question);
    }

    fun loadQuestion() {
        var question = questions[positionOfQuestions];
        txtQuestion.setText(question.sentence);
    }

    fun evaluateQuestion(response: Boolean) {
        var question = questions[positionOfQuestions];
        if (question.answer == response) {
            Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show();
        }
    }
}