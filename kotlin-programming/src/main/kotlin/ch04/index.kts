val names = listOf("Solar", "Rachel", "Anne")

fun nameIndices() {
    for (index in names.indices) { //indices 속성으로부터 인덱스값을 얻을 수 있다.
        println("Position of ${names.get(index)} is $index")
    }
}

fun nameWithIndex() {
    for ((index, name) in names.withIndex()) { //withIndex()함수로 인덱스와 위치를 한번에 얻을 수 있다.
        println("Position of $name is $index")
    }
}

nameIndices()
nameWithIndex()
