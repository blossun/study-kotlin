fun whatToDo(dayOfWeek: Any) = when (dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard"
    in 2..4 -> "Work hard"
    "Friday" -> "Party"
    is String -> "What, you provided a string of length ${dayOfWeek.length}" //스마트캐스
    else -> "No Clue"
}

println(whatToDo("Sunday"))
println(whatToDo("Wednesday"))
println(whatToDo(3))
println(whatToDo("Friday"))
println(whatToDo("Munday"))
println(whatToDo(8))
