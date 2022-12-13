fun main() {

    // Read input
    val input = readInput("Day04")


    // Part 1
    fun part1(input: List<String>): Int {

        val pairs = mutableListOf<List<String>>()
        var pairsWithFullyContainedSections = 0

        input.forEach { line ->
            pairs.add(line.split(","))
        }

        pairs.forEach { pair ->

            val (one, two) = pair
            val elfOne =
                ((one.split("-").first().toInt())..(one.split("-").last().toInt()))
            val elfTwo =
                ((two.split("-").first().toInt())..(two.split("-").last().toInt()))


            if (elfOne.all { elfTwo.contains(it) } || elfTwo.all { elfOne.contains(it) })
                pairsWithFullyContainedSections++

        }


        return pairsWithFullyContainedSections

    }

    // Part 2
    fun part2(input: List<String>): Int {

        val pairs = mutableListOf<List<String>>()
        var pairsWithOverlappingSections = 0

        input.forEach { line ->
            pairs.add(line.split(","))
        }

        pairs.forEach { pair ->

            val (one, two) = pair
            val elfOne =
                ((one.split("-").first().toInt())..(one.split("-").last().toInt()))
            val elfTwo =
                ((two.split("-").first().toInt())..(two.split("-").last().toInt()))


            if (elfOne.any { elfTwo.contains(it) } || elfTwo.any { elfOne.contains(it) })
                pairsWithOverlappingSections++

        }


        return pairsWithOverlappingSections

    }

    // Implement part 1
    println(part1(input))

    // Implement part 2
    println(part2(input))

}
