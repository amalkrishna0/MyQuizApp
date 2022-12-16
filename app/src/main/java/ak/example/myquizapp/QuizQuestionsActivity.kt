package ak.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener  {
    private var progress_bar:ProgressBar?=null
    private var textprogress:TextView?=null
    private var questions:TextView?=null
    private var image_new:ImageView?=null

    private var optionone1:TextView?=null
    private var optiontwo2:TextView?=null
    private var optionthree3:TextView?=null
    private var optionfour4:TextView?=null
    private var button:Button?=null

    private var username:String?=null

    private var totalcorrectanswers:Int=0;
    private var mcurrentposition:Int=1
    private var mquestionList:ArrayList<Questions>?=null
    private var mselectoptionposition:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username=intent.getStringExtra(Constants.USERNAME)

        setContentView(R.layout.activity_quiz_questions)
        progress_bar=findViewById(R.id.progressbar)
        textprogress=findViewById(R.id.progress)
        questions=findViewById(R.id.question)
        image_new=findViewById(R.id.image1)
        optionone1=findViewById(R.id.option_one)
        optiontwo2=findViewById(R.id.option_two)
        optionthree3=findViewById(R.id.option_three)
        optionfour4=findViewById(R.id.option_four)
        button=findViewById(R.id.buttonsubmit)


        mquestionList=Constants.getQuestion()
        Setquestions()
        optionone1?.setOnClickListener(this)
        optiontwo2?.setOnClickListener(this)
        optionthree3?.setOnClickListener(this)
        optionfour4?.setOnClickListener(this)
        button?.setOnClickListener(this)


    }

    private fun Setquestions() {
        val question: Questions = mquestionList!![mcurrentposition - 1]
        defaultOptionsView()
        progress_bar?.progress = mcurrentposition
        image_new?.setImageResource(question.image)
        textprogress?.text = "$mcurrentposition/${progress_bar?.max}"
        questions?.text = question.question
        optionone1?.text = question.optionone
        optiontwo2?.text = question.optiontwo
        optionthree3?.text = question.optionthree
        optionfour4?.text = question.optionfour
        if (mcurrentposition==mquestionList!!.size)
        {
            button?.text="FINISH"

        }
        else
        {
            button?.text="SUBMIT"
        }

        }

    private fun selectedoption( text:TextView,selectedoptionum:Int)
    {
        defaultOptionsView()
        mselectoptionposition=selectedoptionum
        text.setTextColor(Color.parseColor("#363A43"))
        text.setTypeface(text.typeface,Typeface.BOLD)
        text.background=ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_background
        )
    }

    private fun defaultOptionsView(){
        val options =ArrayList<TextView>()
        optionone1?.let {
            options.add(0,it)
        }
        optiontwo2?.let {
            options.add(1,it)
        }
        optionthree3?.let {
            options.add(2,it)
        }
        optionfour4?.let {
            options.add(3,it)
        }

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.selected_option_border_background
            )
        }

    }

    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.option_one->{
                optionone1?.let {
                    selectedoption( it,1)
                }
            }
            R.id.option_two->{
                optiontwo2?.let {
                    selectedoption( it,2)
                }
            }
            R.id.option_three->{
                optionthree3?.let {
                    selectedoption( it,3)
                }
            }
            R.id.option_four->{
                optionfour4?.let {
                    selectedoption( it,4)
                }
            }
            R.id.buttonsubmit->{
                if(mselectoptionposition==0)
                {
                    mcurrentposition++

                    when{
                            mcurrentposition<=mquestionList!!.size->{
                                Setquestions()
                        }
                        else->{
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USERNAME,username)
                            intent.putExtra(Constants.CORRECT_ANSWERS,totalcorrectanswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mquestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val questions=mquestionList?.get(mcurrentposition-1)
                    if (questions!!.correctanswer!=mselectoptionposition)
                    {
                        answerview(mselectoptionposition,R.drawable.wrong_anwer_color)
                    }
                    else
                    {
                        totalcorrectanswers++;
                    }
                    answerview(questions.correctanswer,R.drawable.correct_answer_color)

                    if (mcurrentposition==mquestionList!!.size)
                    {
                        button?.text="FINISH"
                    }
                    else
                    {
                        button?.text="GO TO NEXT QUESTION"
                    }
                    mselectoptionposition=0
                }
            }
        }
    }
    private fun answerview(answer: Int,drawableView:Int)
    {
        when(answer){
            1->{
                optionone1?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            2->{
                optiontwo2?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3->{
                optionthree3?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            4->{
                optionfour4?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
        }
    }


}