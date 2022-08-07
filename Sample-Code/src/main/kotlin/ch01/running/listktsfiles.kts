package ch01.running

java.io.File(".")
.walk()
.filter { file -> file.extension == "kts" }
.forEach { println(it) }

//스크립트로 실행
// - 파일 확장자 : kts
// - 실행 : kotlinc-jvm -script listktsfiles.kts
