val sites = mapOf("solar" to "http://blog.naver.com/solar", "Backend developer" to "http://github.com/solar")
println(sites.size)
println(sites.containsKey("Backend developer"))
println(sites.containsValue("http://blog.naver.com/solar"))
println(sites.contains("Backend developer"))
println("Backend developer" in sites)

//val blog: String = sites.get("Solar") //오류
val blog: String? = sites.get("Solar")
val myBlog: String? = sites["Solar"]
val backendDeveloper = sites.getOrDefault("Backend developer", "http://blog.naver.com/Solar")
val sitesWithGitHub = sites + ("GitHub" to "http://github.com")
val withoutBackendDeveloper = sites - "Backend developer"

for (entry in sites) {
    println("${entry.key} --- ${entry.value}")
}

for ((key, value) in sites) {
    println("$key --- $value")
}
