package com.example.task

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.text.set
import androidx.core.widget.addTextChangedListener
import com.example.task.databinding.ActivityMainBinding
import java.lang.Exception
import java.lang.NullPointerException

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

    }

    fun pureumLib(max: Int){
        val regex = Regex("#[\\w]{1,${max}}")
        val result = ""
        var startPoint = 0


        binding.myEdit.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                println("${s.toString()}")
                val myText = binding.myEdit.text
                val matchResult:Sequence<MatchResult> = regex.findAll(myText)
//                binding.myEdit.setTextColor(Color.BLUE)
//                println("@@@@ ${binding.myEdit.text}")
//                println("selectionStart : ${binding.myEdit.selectionStart}")
//                println("selectionEnd : ${binding.myEdit.selectionEnd}")
                println("\n")
//                println("start : ${start}")
//                println("before : ${before}")
//                println("count : ${count}")

                myText.setSpan(
                    ForegroundColorSpan(Color.BLACK),
                    0,
                    myText.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )

                if(matchResult.toList().isNotEmpty()) {
//                    println(" \n\n")
                    Count = 0
                    for (i in matchResult.toList()) {
                        nowGap = i.value
                        println("\n")
//                        Count = binding.myEdit.text.length - Count
                        println("before Count : ${Count}")

                        println("gap i : ${i.value}")
                        val myStartLoation = myText.indexOf(i.value, Count)
                        println("myStartLoation : $myStartLoation")
                        println("myendLoation : ${myStartLoation + i.value.length}")
                        try {
                            myText.setSpan(
                                ForegroundColorSpan(Color.RED),
                                myStartLoation,
                                myStartLoation + i.value.length,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            Count = myStartLoation + i.value.length
                            println("after Count : ${Count}")
//                            Count = Count + binding.myEdit.text.length
//                            Count = binding.myEdit.text.length
//                            println("nowCount : $Count")
                        }catch (e:Exception){
                            println("e : $e")
                        }

                    }
                }
                else{
                    println("no")
//                    Count+=1
//                    println("nowCount $Count")
                }













//                    println("inList")
////                    Count = 1
////                    val myListSize = matchResult.toList().size
//                    for(i in matchResult.toList()){
//                        if(Count > max+1) {
//                            Count = 1
//                            startPoint += Count
//                        }
//                        val myGap = i.value
//                        val myLoation = binding.myEdit.text.indexOf(myGap,startPoint)
//
//                        try {
//                            binding.myEdit.text.setSpan(
//                                ForegroundColorSpan(Color.RED),
//                                myLoation,
//                                myLoation + Count,
//                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                            )
//                        }catch (e:Exception) {println("E")}
//                        Count+=1
//                    }
//                    binding.myEdit.setTextColor(Color.BLUE)






//                    if(Count == max+2){
//                        startPoint = binding.myEdit.text.length
//                        println("startPoint : $startPoint")
//                        Count = 1
//                    }
//
//                    val nowLocation = binding.myEdit.text.indexOf("#", startPoint)
//
//                    println("nowLocation : $nowLocation")
//                    println("Count : $Count")
//
//                    try {
//                        binding.myEdit.text?.setSpan(
//                            ForegroundColorSpan(Color.RED),
//                            nowLocation,
//                            nowLocation + Count,
//                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                        )
//                        Count += 1
//                        startPoint
//                    }catch (e :Exception){println(e)}

//                matchResult.forEach {
//                    println("match value: ${it.value}")


//                    if (Count <= max){
//                        println("match value: ${it.value}")
//                        val startIndex = binding.myEdit.text.indexOf(it.value)
//                        println("startIndex : $startIndex")
//                        println("Count : $Count")
//                        try {
//                            binding.myEdit.text?.setSpan(
//                                ForegroundColorSpan(Color.RED),
//                                startIndex,
//                                startIndex+Count+1,
//                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//                            )
//                        }catch (e : Exception){
//                            println("$e")
//                        }
//                        Count+=1
//                    }else Count=0
//                }
            }

        })
    }
}