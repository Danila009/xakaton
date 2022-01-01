package com.example.normalhackathon.model

data class EventGet(
    val id:Int,
    var name:String,
    var description:String,
    val nominations: List<Nomination>?
)

data class Nomination(
    val id:Int,
    var name:String,
    var description:String,
    var criteries: List<Criteriy>
)

data class Criteriy(
    var name:String,
    var description:String,
    var minScore:Int,
    var maxScore:Int,
    val contestantScores: List<CntestantScores>
)

data class CntestantScores(
    val criteriaId:Int,
    val accessorId:Int,
    val contestantId:Int,
    val contestant:List<Contestant>,
    val role:String
)

data class Contestant(
    val id:Int,
    val fio:String,
    val email:String,
)