fun main() {

    // Number of elves
    val elvesCalories = mutableListOf<Int>()
    // Calories per elf
    var elf = 0
    // Puzzle input
    val input = readInput("Day01").toMutableList()
    
    // Function to calculate max calories
    fun part1(input: List<String>): Int {

        // Collect each individual elf's calories
        for (i in input) {
            if (i.isBlank()) {
                elvesCalories.add(elf)
                elf = 0
                continue
            }
            elf += i.toInt()
        }
        elvesCalories.add(elf)

        // Return largest calories
        return elvesCalories.max()

    }

    // Function to find top 3 largest calories
    fun part2(input: MutableList<String>): Int {

        // Find the first largest calories
        val first = elvesCalories.max()
        elvesCalories.remove(first)
        // Find the second largest calories
        val second = elvesCalories.max()
        elvesCalories.remove(second)
        // Find the third largest calories
        val third = elvesCalories.max()

        // Get total calories
        return first + second + third

    }

    // Find max calories
    println(part1(input))
    // Find top 3 largest calories
    println(part2(input))

}
