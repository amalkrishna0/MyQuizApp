package ak.example.myquizapp

object Constants {

    const val USERNAME:String="user_name"
    const val TOTAL_QUESTIONS:String="Total_Questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestion():ArrayList<Questions>  {
        val questionlist=ArrayList<Questions>()

        val ques1= Questions(
            1,"What country does this flag belong to?",
            R.drawable.ukraine,
            "Chile",
            "Switzerland",
            "Cameroon",
            "Ukraine",
            4
        )
        questionlist.add(ques1)

        val ques2= Questions(
            1,"What country does this flag belong to?",
            R.drawable.cameroon,
            "Chile",
            "Cameroon",
            "Nigeria",
            "Chad",
            2
        )
        questionlist.add(ques2)

        val ques3= Questions(
            1,"What country does this flag belong to?",
            R.drawable.chile,
            "Chile",
            "Egypt",
            "Uganda",
            "Congo",
            1
        )
        questionlist.add(ques3)

        val ques4= Questions(
            1,"What country does this flag belong to?",
            R.drawable.costarica,
            "Algeria",
            "Morocco",
            "Qatar",
            "Costa Rica",
            4
        )
        questionlist.add(ques4)

        val ques5= Questions(
            1,"What country does this flag belong to?",
            R.drawable.tagjikistan,
            "Angola",
            "Afganistan",
            "Tajikistan",
            "Azerbaijan",
            3
        )
        questionlist.add(ques5)

        val ques6= Questions(
            1,"What country does this flag belong to?",
            R.drawable.slovakia,
            "Slovakia",
            "Hungary",
            "Ghana",
            "Poland",
            1
        )
        questionlist.add(ques6)

        val ques7= Questions(
            1,"What country does this flag belong to?",
            R.drawable.poland,
            "Singapore",
            "Japan",
            "Poland",
            "Bahrain",
            3
        )
        questionlist.add(ques7)

        val ques8= Questions(
            1,"What country does this flag belong to?",
            R.drawable.venezuela,
            "Venezuela",
            "Columbia",
            "Philippines",
            "Belgium",
            1
        )
        questionlist.add(ques8)

        val ques9= Questions(
            1,"What country does this flag belong to?",
            R.drawable.senegal,
            "Algeria",
            "Senegal",
            "Ghana",
            "Singapore",
            3
        )
        questionlist.add(ques9)

        val ques10= Questions(
            1,"What country does this flag belong to?",
            R.drawable.panama,
            "Panama",
            "Morocco",
            "France",
            "Costa Rica",
            1
        )
        questionlist.add(ques10)
        return questionlist



    }
}