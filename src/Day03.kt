fun main() {

    // Read input
    val input = readInput("Day03")
    // Assign priority to each letter
    val priorities = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

    // Part 1
    fun part1(input: List<String>): Int{
        // Sum of all common item priorities
        var sumOfPriorities = 0
        // Find and sum all common items
        input.forEach { string ->
            val midpoint = string.length / 2
            val first = string.toCharArray().slice(0 until midpoint)
            val second = string.toCharArray().slice(midpoint until string.length)
            val commonItem = first.intersect(second.toSet()).first()
            sumOfPriorities += priorities.indexOf(commonItem)
        }

        return sumOfPriorities

    }

    // Part 2
    fun part2(input: List<String>): Int {
        // Sum of all elf-badges
        var sumOfBadges = 0
        // Seperate rucksacks into groups of 3
        val groups = input.chunked(3)

        // Calculate the sum of each group badge ie common item
        groups.forEach { group ->
            val first = group.component1().toList()
            val second = group.component2().toList()
            val third = group.component3().toList()
            val badge = third.intersect(first.intersect(second.toSet())).first()
            sumOfBadges += priorities.indexOf(badge)
        }

        return sumOfBadges

    }

    // Implementation of part 1
    println(part1(input))
    // Implementation of part 2
    println(part2(input))

}
