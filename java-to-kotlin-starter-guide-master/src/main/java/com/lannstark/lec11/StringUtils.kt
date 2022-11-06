package com.lannstark.lec11

//파일 최상단에 바로 유틸 함수를 작성해서 사용할 수 있다.
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}
