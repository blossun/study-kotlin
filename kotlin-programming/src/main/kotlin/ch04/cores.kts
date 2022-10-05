fun systemInformation(): String {
    val numberOfCores = Runtime.getRuntime().availableProcessors()
    return when (numberOfCores) {
        1 -> "1 core, packing this one to the museum"
        in 2..16 -> "You have $numberOfCores cores"
        else -> "$numberOfCores cores!, I want you machine"
    }
}

fun systemInformationRefactor(): String =
    when (val numberOfCores = Runtime.getRuntime().availableProcessors()) { //변수의 스코프 제한
        1 -> "1 core, packing this one to the museum"
        in 2..16 -> "You have $numberOfCores cores"
        else -> "$numberOfCores cores!, I want you machine"
    }


println(systemInformation())
println(systemInformationRefactor())
