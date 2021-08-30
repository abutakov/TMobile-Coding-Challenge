package io.butakov.composeAPI.util

import android.util.Log
import io.butakov.composeAPI.util.Constants.Companion.DEBUG
import io.butakov.composeAPI.util.Constants.Companion.ERROR

class Logger {
    companion object{
        fun logError(error: String){
            Log.e(ERROR, error)
        }
        fun logMessage(message: String){
            Log.d(DEBUG, message)
        }
    }
}