package theta.ramadan.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main2.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        signinbutton.setOnClickListener{
            if(ValidateEmail(emailbutton.text.toString()) and ValidatePassword(password.text.toString()) )
            {
            //    Toast.makeText(this,"LoggedIn",Toast.LENGTH_SHORT).show()
            //moving to home activity
                moveToHomeActivity()

            }
            else
            {
                emailbutton.error="Something is wrong password or email"
            }
labelforforgetpassword.setOnClickListener {
        moveToForgotPasswordActivity()

}



        }
        labelforemail.setOnClickListener{

            Toast.makeText(this,emailbutton.text.toString(),Toast.LENGTH_SHORT).show()

        }


    }
    private  fun moveToForgotPasswordActivity()
    {
        val forgotPasswordActivity=Intent(this,ForgotPasswordActivity2::class.java)
        //forgotPasswordActivity.putExtra("email",forgotEmail.text.toString())
        startActivity(forgotPasswordActivity)
    }
    private  fun moveToHomeActivity()
    {//to move from one activity to other
        val homeActivity=Intent(this,HomeActivity::class.java);
        //to put extra information
        homeActivity.putExtra("email",emailbutton.text.toString())
        //to clear previous page excess
        homeActivity.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.finish()
        //final step to step to redirected activity
        startActivity(homeActivity)
    }
    private fun ValidateEmail(string: String):Boolean
    {
        if(!string.isBlank())
        {

            return android.util.Patterns.EMAIL_ADDRESS.matcher(string).matches()
        }
        return  false;
    }
    private  fun ValidatePassword(str:String):Boolean
    {
        if(!str.isBlank())
        {

            return true
        }

        return false
    }
}