abstract class Book(val name: String)
class Fiction(name: String): Book(name)
class NonFiction(name: String): Book(name)

val books: List<Book> = listOf(
    Fiction("Moby Dick"), NonFiction("Learn to Code"), Fiction("LOTR")
)

// 1. Java에서 작성하던 방식
// 원하는 객체의 타입을 파라미터로 던진다. - ofClass: Class<T>
fun <T> findFirst(books: List<Book>, ofClass: Class<T>): T {
    val selected = books.filter { book -> ofClass.isInstance(book)} //타입체크
    if (selected.size == 0) {
        throw java.lang.RuntimeException("Not Found")
    }
    return ofClass.cast(selected[0]) //타입 캐스팅
}

println(findFirst(books, NonFiction::class.java).name) //Learn to Code

// 2. 코틀린에서 구체화된(reified) 타입 파라미터를 사용하기
inline fun <reified  T> findFirst(books: List<Book>): T {
    val selected = books.filter { book -> book is T } //T를 타입 체크로 사용
    if (selected.size == 0) {
        throw RuntimeException("Not Found")
    }

    return selected[0] as T //T를 타입 캐스팅용으로 사용
}

println(findFirst<Fiction>(books).name) //Moby Dick
