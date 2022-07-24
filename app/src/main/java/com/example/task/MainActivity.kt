package com.example.task

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import com.example.mylibrary.MyInstarTag
import com.example.task.databinding.ActivityMainBinding
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    var Count = 1
    var nowGap = ""

    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val a = pureumLib(5)

//        this.pureumLib(5)
        binding.editQuery.apply {
            this.pureumLib(5)
        }





    }

    fun pureumLib(max: Int){
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