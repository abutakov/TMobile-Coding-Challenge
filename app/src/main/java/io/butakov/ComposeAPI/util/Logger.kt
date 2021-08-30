package io.butakov.ComposeAPI.util

import android.util.Log
import io.butakov.ComposeAPI.util.Constants.Companion.DEBUG
import io.butakov.ComposeAPI.util.Constants.Companion.ERROR

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