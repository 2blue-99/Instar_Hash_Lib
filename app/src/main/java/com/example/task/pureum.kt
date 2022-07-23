package com.example.task

fun main(){
//    val str1 = "apple likes banana"
//    val str2 = "kiwi likes blueberry"
//    val regex = Regex("(apple|kiwi) likes (banana|blueberry)")
//
//    val matchResult1 = regex.matches(str1)
//    println("matchResult1: ${matchResult1}")




    val regex = Regex("#[\\w]{1,3}")
    val my = "#aa #ab #ac #aa"
//    val data = regex.findAll(my)
//    val data = regex.findAll(my)
    val matchResult : Sequence<MatchResult> = regex.findAll(my)
    for(i in matchResult.toList()){println("${i.value}")}

//    println("${matchResult.all {  }}")
//    if(matchResult )
//    matchResult.forEach {
//        if(it.value.isBlank()) println("empty")
//        else println("@@@@@@@ ${it.value}") }

//    val myData = data.map { it.groupValues[1] }.joinToString()
//    println("${data.}")
//    val regex = Regex("^#.{1,3}$")
//    val my = "# saddas # #dd asdsdas"

//    val matchResult: MatchResult? = regex.find(my)
//
//    println("${matchResult?.value}")
//    println("${my.split(" ")}")
//    println("${gap.matchEntire(my)}")
}

