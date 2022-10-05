val numberRanges: IntRange = 1..10
val charRanges: CharRange = 'a'..'z'
val seekHelp: ClosedRange<String> = "Hela".."Help"

println(seekHelp.contains("Helm"))
println(seekHelp.contains("Helz"))

for (i in numberRanges) {
    print("$i, ")
}

for (ch in charRanges) {
    print("$ch, ")
}

for (i in 1..5) {
    print("$i, ")
} //1, 2, 3, 4, 5,
for (ch in 'a'..'e') {
    print(ch)
} //abcde
//for (word in "hell".."help") { print("$word, ") } //ERROR - For-loop range must have an 'iterator()' method

