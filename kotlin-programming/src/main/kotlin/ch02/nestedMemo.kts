fun createMemoFor(name: String): String {
    if (name == "Solar") {
        val memo = """Dear $name, a quick reminder about the 
            party we have scheduled next Tuesday at
            the 'Low Ceremony Cafe' at Noon. | Please plan to..."""
        return memo
    }

    return ""
}

println(createMemoFor("Solar"))
