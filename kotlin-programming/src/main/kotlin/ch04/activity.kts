fun whatToDo(dayOfWeek: Any) = when (dayOfWeek) {
    "Saturday", "Sunday" -> "Relax"
    in listOf("Monday", "Tuesday", "Wednesday", "Thursday") -> "Work hard"
    in 2..4 -> "Work hard"
    "Friday" -> "Party"
    is String -> "What?"
    else -> "No Clue"
}

println(whatToDo("Sunday"))
println(whatToDo("Wednesday"))
println(whatToDo(3))
println(whatToDo("Friday"))
println(whatToDo("Munday"))
println(whatToDo(8))