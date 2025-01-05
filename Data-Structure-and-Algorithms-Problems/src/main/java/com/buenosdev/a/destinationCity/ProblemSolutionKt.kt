package com.buenosdev.a.destinationCity

class ProblemSolutionKt {
    fun destCityI(paths: List<List<String>>): String {
        var hashmap = HashMap<String, ArrayList<String>>();

        for (path in paths) {
            var origin = path[0]
            var destination = path[1]

            if (!hashmap.contains(destination)) {
                hashmap[destination] = ArrayList()
            }
            if (!hashmap.contains(origin)) {
                hashmap[origin] = ArrayList()
            }

            hashmap[path[0]]?.add(destination)
        }

        var sb = StringBuilder()

        for (entry in hashmap) {
            if (entry.value.isEmpty()) {
                sb.append(entry.key)
                break
            }
        }

        return sb.toString()
    }

    fun destCity(paths: List<List<String>>): String {
        var hashmap = HashSet<String>();

        for (path in paths) {
            hashmap.add(path[0])

        }

        for (path in paths) {
            if (!hashmap.contains(path[1])) return path[1]
        }

        return ""
    }
}