// 스타 프로젝션
fun printValue(values: Array<*>) {
    for (value in values) {
        println(value)
    }
//    values[0] = values[1] // error -  Array<*> 를 파라미터로 받았기 때문에 함수 내에서 어떠한 변경도 허용되지 않는다.
}

printValue(arrayOf(1, 2))
