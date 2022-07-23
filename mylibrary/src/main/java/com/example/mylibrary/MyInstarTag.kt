package com.example.mylibrary

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat.getColor
import com.example.mylibrary.databinding.MyinstartagBinding
import java.lang.Exception

class MyInstarTag(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    private val binding: MyinstartagBinding by lazy {
        MyinstartagBinding.inflate(LayoutInflater.from(context),this,true)
    }

    fun pureumLib(max: Int) {


        var Count = 0
        var myStart = 0


        binding.myEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.myEdit.text.length == 0) {
                    Count = 0
                    myStart = 0
                }
                val myIndex = binding.myEdit.text.toString().indexOf("#", myStart)

                if (myIndex != -1 && Count <= max + 1) {
                    try {
                        binding.myEdit.text?.setSpan(
                            ForegroundColorSpan(Color.RED),
                            myIndex,
                            myIndex + Count,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                    } catch (e: Exception) {
                        println("$e")
                    }
                    Count += 1
                }

                if (Count > max + 1) {
                    println("check!!")
                    Count = 0
                    myStart = binding.myEdit.text.length
                }
            }
        })
    }
}