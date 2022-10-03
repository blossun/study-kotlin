var factor = 2 //var보다 val을 사용해야한다.
fun doubleIt(number: Int) = number * factor //호출할 때 factor의 값으로 사용된다.
var message = "The factor is $factor" //message를 만들 시점의 factor의 값은 2
factor = 0

println(doubleIt(2))    //0
println(message)    //The factor is 2
