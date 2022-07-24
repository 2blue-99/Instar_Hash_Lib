package com.example.mylibrary

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mylibrary.databinding.MyinstartagBinding
import java.lang.Exception

class MyInstarTag @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs,defStyleAttr) {
    private val binding: MyinstartagBinding by lazy {
        MyinstartagBinding.inflate(LayoutInflater.from(context),this,true)
    }

    fun pureumLib(max: Int){
        var Count = 1
        var nowGap = ""
        val regex = Regex("#[\\w]{1,${max}}")

        binding.myEdit.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val myText = binding.myEdit.text
                val matchResult:Sequence<MatchResult> = regex.findAll(myText)

                myText.setSpan(
                    ForegroundColorSpan(Color.BLACK),
                    0,
                    myText.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )

                if(matchResult.toList().isNotEmpty()) {
                    Count = 0
                    for (i in matchResult.toList()) {
                        nowGap = i.value
                        val myStartLoation = myText.indexOf(i.value, Count)
                        try {
                            myText.setSpan(
                                ForegroundColorSpan(Color.RED),
                                myStartLoation,
                                myStartLoation + i.value.length,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            Count = myStartLoation + i.value.length
                            println("after Count : ${Count}")

                        }catch (e:Exception){
                            println("e : $e")
                        }
                    }
                }
                else{
                    println("no")
                }
            }
        })
    }
}