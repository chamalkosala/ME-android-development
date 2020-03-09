package com.example.meandroidcodechallenge.ui.activities

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity(){


    fun showAlertDialog(title: String?, message: String?) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok", defaultDialogClickListener())
        alertDialog.show()
    }

    protected fun defaultDialogClickListener(): DialogInterface.OnClickListener? {
        return DialogInterface.OnClickListener { dialog, whichButton -> }
    }
}