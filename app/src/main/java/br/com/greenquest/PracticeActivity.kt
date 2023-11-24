package br.com.greenquest

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog



class PracticeActivity : AppCompatActivity(), View.OnClickListener {

    private val questionAnswer = QuestionAnswerActivity()

    private var totalQuestionsTextView: TextView? = null
    private var questionTextView: TextView? = null
    private var ansA: Button? = null
    private var ansB:android.widget.Button? = null
    private var ansC:android.widget.Button? = null
    private var ansD:android.widget.Button? = null
    private var submitBtn: Button? = null

    var score = 0
    var totalQuestion: Int = questionAnswer.question.size
    var currentQuestionIndex = 0
    var selectedAnswer = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(br.com.greenquest.R.layout.activity_practice)
        totalQuestionsTextView = findViewById<TextView>(br.com.greenquest.R.id.total_question)
        questionTextView = findViewById<TextView>(br.com.greenquest.R.id.question)
        ansA = findViewById<Button>(br.com.greenquest.R.id.ans_A)
        ansB = findViewById<Button>(br.com.greenquest.R.id.ans_B)
        ansC = findViewById<Button>(br.com.greenquest.R.id.ans_C)
        ansD = findViewById<Button>(br.com.greenquest.R.id.ans_D)
        submitBtn = findViewById<Button>(br.com.greenquest.R.id.submit_btn)
        ansA?.setOnClickListener(this)
        ansB?.setOnClickListener(this)
        ansC?.setOnClickListener(this)
        ansD?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)
        totalQuestionsTextView?.setText("Total questions : $totalQuestion")
        loadNewQuestion()
    }

    override fun onClick(view: View) {
        ansA?.setBackgroundColor(Color.WHITE)
        ansB?.setBackgroundColor(Color.WHITE)
        ansC?.setBackgroundColor(Color.WHITE)
        ansD?.setBackgroundColor(Color.WHITE)
        val clickedButton = view as Button
        if (clickedButton.id == br.com.greenquest.R.id.submit_btn) {
            if (selectedAnswer == questionAnswer.correctAnswers[currentQuestionIndex]) {
                score++
            }
            currentQuestionIndex++
            loadNewQuestion()
        } else {
            //choices button clicked
            selectedAnswer = clickedButton.text.toString()
            clickedButton.setBackgroundColor(Color.argb(188, 92, 146, 73,))
        }
    }

    fun loadNewQuestion() {
        if (currentQuestionIndex == totalQuestion) {
            finishQuiz()
            return
        }
        questionTextView?.setText(questionAnswer.question[currentQuestionIndex])
        ansA?.setText(questionAnswer.choices[currentQuestionIndex][0])
        ansB?.setText(questionAnswer.choices[currentQuestionIndex][1])
        ansC?.setText(questionAnswer.choices[currentQuestionIndex][2])
        ansD?.setText(questionAnswer.choices[currentQuestionIndex][3])
    }

    fun finishQuiz() {
        var passStatus = ""
        passStatus = if (score > totalQuestion * 0.60) {
            "               Parabéns!"
        } else {
            "           Não foi dessa vez :("
        }
        AlertDialog.Builder(this)
            .setTitle(passStatus)
            .setMessage("\n                 Você acertou $score de $totalQuestion")
            .setPositiveButton("Refazer") { dialogInterface, i -> restartQuiz() }
            .setCancelable(false)
            .show()
    }

    fun restartQuiz() {
        score = 0
        currentQuestionIndex = 0
        loadNewQuestion()
    }
}