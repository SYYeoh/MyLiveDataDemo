package my.edu.tarc.mylivedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import my.edu.tarc.mylivedatademo.databinding.ActivityMainBinding
import my.edu.tarc.mylivedatademo.models.AccountModel

class MainActivity : AppCompatActivity() {
    private val myAccout = AccountModel("A1234566","John", 500.00)
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.myAccount = myAccout
        binding.lifecycleOwner = this
        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)

        //display()
        //tell the android which textview to update
        //no need to use display() and manually show it
        //myAccout.balance.observe(this, Observer { newBalance -> binding.tvBalance.text = newBalance.toString() })
        //if have many observer, can use data binding

        binding.btnDeposit.setOnClickListener(){
            //get value from text view and put inside account
            val amount:Double  = binding.tfAmount.text.toString().toDouble()

            //myAccout.deposit(amount)
            //2 ways to update the view model
            //display()
            //binding.tvBalance.text = myAccout.balance.toString()

            //cannot assign value , can only read
            myAccout.deposit(amount)

        }

        binding.btnWitdraw.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()
            myAccout.withdraw(amount)
            //display()
        }
    }

//    fun display(){
//
//        binding.tvAccNo.text = myAccout.accNo
//        binding.tvName.text = myAccout.owner
//        //binding.tvBalance.text = myAccout.balance.toString()
//        //if use back will only return address
//        binding.tvBalance.text = myAccout.balance.value.toString()
//
//    }
}