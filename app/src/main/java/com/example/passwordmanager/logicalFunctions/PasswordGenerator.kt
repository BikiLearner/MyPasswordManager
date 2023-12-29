package com.example.passwordmanager.logicalFunctions

import kotlin.random.Random

class PasswordGenerator(
   private val lengthOfPassword:Int,
   private val checkedState: List<Boolean>

) {
    fun giveMePassword():String{
        var pasword=""

        if(checkTheSequence().isEmpty()){
            val characterSet="abcdijklmABCDENOPQRSnopqrstuvwxyzTUVWefghFGHIJKLMXYZ"

            for (i in 1..lengthOfPassword){
                val randomNumber = Random.nextInt(1,characterSet.length)
                pasword+= characterSet[randomNumber]
            }
            return pasword
        }
        for (i in 1..lengthOfPassword){
            val randomNumber = Random.nextInt(1,checkTheSequence().length)
            pasword+=checkTheSequence()[randomNumber]
        }
        return pasword
    }
    private fun checkTheSequence():String{
        var characterSet=""
        val categoriesSet= listOf(
            "0123456789",
            "!@#\$%^&*()-_=+[]{}|;:'\",.<>?/`~",
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        )
        checkedState.forEachIndexed {index,isChecked->
            if(isChecked){
                characterSet+=categoriesSet[index]
            }
        }
        return characterSet
    }

}
fun evaluatePasswordStrength(password: String): Int {
    var strength = 0

    // Criteria for password strength
    val minLength = 8
    val minUpperCase = 1
    val minLowerCase = 1
    val minDigits = 1
    val minSpecialChars = 1

    // Check password length
    if (password.length >= minLength) {
        strength++

        // Check for uppercase letters
        if (password.any { it.isUpperCase() }) {
            strength++
        }

        // Check for lowercase letters
        if (password.any { it.isLowerCase() }) {
            strength++
        }

        // Check for digits
        if (password.any { it.isDigit() }) {
            strength++
        }

        // Check for special characters
        val specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~"
        if (password.any { specialChars.contains(it) }) {
            strength++
        }
    }

    return strength
}