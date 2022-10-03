fun tryExpression(blowup: Boolean): Int {
    return try {
        if (blowup) {
            throw RuntimeException("fail!!!!!")
        }
        2
    } catch (e: Exception) {
        4
    } finally {

    }
}

println(tryExpression(false)) //2
println(tryExpression(true)) //4
