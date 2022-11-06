package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {

    //Kotlin에서는 Checked Exception과 Uchecked Exception을 구분하지 않습니다.
    //모두 Uncehcekd Exception 입니다.
    fun readFile(){
        val currentFile: File = File(".")
        val file: File = File(currentFile.absolutePath + "/a.txt")
        val bufferedReader: BufferedReader = BufferedReader(FileReader(file))
        println(bufferedReader.readLine())
        bufferedReader.close()
    }

    // 코틀린에는 try with resources 구문이 없다.
    fun readFile(path: String?) {
        BufferedReader(FileReader(path)).use { reader -> println(reader.readLine()) } //BufferedReader의 inline 확장함수 use를 사용한다.
    }

}
