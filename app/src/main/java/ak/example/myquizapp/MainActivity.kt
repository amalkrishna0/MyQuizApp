package ak.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnstart: Button =findViewById(R.id.btnstart)
        val edit: EditText=findViewById(R.id.edittext)
        btnstart.setOnClickListener{
            if (edit.text.isEmpty())
            {
                Toast.makeText(this,"Please Enter Your Namme",Toast.LENGTH_LONG).show()

            }
            else
            {
                val intent= Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USERNAME,edit.text.toString())
                startActivity(intent)
                finish()
            }
        }


    }
}