package com.example.flagquizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var questions:ArrayList<Flags>
    private lateinit var falseOptions:ArrayList<Flags>
    private lateinit var trueQuestion:Flags
    private lateinit var allOptions:HashSet<Flags>
    private lateinit var dh:DatabaseHelper

    private  var questionCount = 0
    private  var trueCount = 0
    private var falseCount=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        dh = DatabaseHelper(this)
        val flgdao = FlagsDao()

        questions = flgdao.getRandomFiveFlags(dh)
        loadQuestion()

        buttonA.setOnClickListener{
            checkTrue(buttonA)
            controlQuestionCount()

        }
        buttonB.setOnClickListener{
            checkTrue(buttonB)
            controlQuestionCount()

        }
        buttonC.setOnClickListener{
            checkTrue(buttonC)
            controlQuestionCount()

        }
        buttonD.setOnClickListener{
            checkTrue(buttonD)
            controlQuestionCount()

        }
    }

    @SuppressLint("DiscouragedApi", "SetTextI18n")
    fun loadQuestion(){
        textViewQuestionCount.text = "${questionCount+1}. Soru"

        trueQuestion = questions[questionCount]
        imageViewFlag.setImageResource(resources.getIdentifier(trueQuestion.flag_image,"drawable",packageName))

        falseOptions = FlagsDao().getRandomFalseThreeFlags(dh,trueQuestion.flag_id)

        allOptions = HashSet()
        allOptions.add(trueQuestion)
        allOptions.add(falseOptions.get(0))
        allOptions.add(falseOptions.get(1))
        allOptions.add(falseOptions.get(2))

        buttonA.text = allOptions.elementAt(0).flag_name
        buttonB.text = allOptions.elementAt(1).flag_name
        buttonC.text = allOptions.elementAt(2).flag_name
        buttonD.text = allOptions.elementAt(3).flag_name

    }

    fun controlQuestionCount(){
        questionCount++
        if(questionCount!=5){
            loadQuestion()
        }else{
            val intent = Intent(this@QuizActivity,ResultActivity::class.java)
            intent.putExtra("trueCount",trueCount)
            startActivity(intent)
            finish()
        }
    }

    fun checkTrue(button: Button){
        val buttonText = button.text.toString()
        val trueAnswer = trueQuestion.flag_name

        if(buttonText == trueAnswer){
            trueCount++
        }else{

            falseCount++
        }

        textViewTrue.text = "True: $trueCount"
        textViewFalse.text= "False:$falseCount"

    }

}