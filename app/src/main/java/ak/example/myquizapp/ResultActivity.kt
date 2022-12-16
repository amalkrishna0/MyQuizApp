package ak.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val name:TextView=findViewById(R.id.result3)
        val score:TextView=findViewById(R.id.result4)
        val btn:Button=findViewById(R.id.btnstart)

        name.text=intent.getStringExtra(Constants.USERNAME)

        val totalquestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctanswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        score.text="Your Score Is $correctanswers/$totalquestions"

        btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}