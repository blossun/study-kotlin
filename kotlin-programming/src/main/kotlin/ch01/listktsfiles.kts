package ch01

java.io.File(".")
.walk()
.filter { file -> file.extension == "kts" }
.forEach { println(it) }

//스크립트로 실행
// - 파일 확장자 : kts
// - 실행 : kotlinc-jvm -script listktsfiles.kts
// 출력 결과
//  ./listktsfiles.kts
//  ./greet.kts
