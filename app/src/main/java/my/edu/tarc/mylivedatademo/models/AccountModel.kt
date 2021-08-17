package my.edu.tarc.mylivedatademo.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountModel(accNo:String, owner:String, balance:Double) :ViewModel(){
    var accNo : String = ""
    //: Sting (data type) , "" assign value
    var owner : String = ""
    //var balance: Double = 0.0
    //change to live data, if live data means change once only
     //var balance = MutableLiveData<Double>()
    //use private to encapsulate
    private var _balance = MutableLiveData<Double>()
    //val only can read cant write
    val balance : LiveData<Double>
    get() = _balance

    //when this acc is initiated, init will assign all value (same as constructor in java)
    init {
        this.accNo = accNo
        this.owner = owner
        //this.balance = balance, change to
        //this.balance.value = balance

        this._balance.value = balance
    }

    fun deposit(amount: Double) {
        //live data cannot use balance += amount, must use value.plus
        // since value.plus only return value, need variable to store the data
        //balance.value = (_balance).value?.plus(amount)
        _balance.value = (_balance).value?.plus(amount)
    }

    fun withdraw(amount: Double) {
        //balance.value = balance.value?.minus(amount)
        _balance.value = (_balance).value?.minus(amount)
    }

}
