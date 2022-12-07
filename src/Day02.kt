fun main() {

    // Read input
    val input = readInput("Day02").toMutableList()

    // Calculate Scores of each round
    fun calculateRoundScore(round: List<String>): Int {

        val opponentMove = round.first()
        val yourMove = round.component2()
        var score = 0

        if (
            yourMove == "X" && opponentMove == "C" ||
            yourMove == "Y" && opponentMove == "A" ||
            yourMove == "Z" && opponentMove == "B"
        ) score = 6

        if (
            yourMove == "X" && opponentMove == "A" ||
            yourMove == "Y" && opponentMove == "B" ||
            yourMove == "Z" && opponentMove == "C"
        ) score = 3

        if (
            yourMove == "X" && opponentMove == "B" ||
            yourMove == "Y" && opponentMove == "C" ||
            yourMove == "Z" && opponentMove == "A"
        ) score = 0

        return score
    }

    // Calculate Move score
    fun calculateMoveScore(move: String): Int = when (move) {
        "X" -> 1
        "Y" -> 2
        "Z" -> 3
        else -> 0
    }

    fun roundScores(result: String) : Int = when (result) {
        "X" -> 0
        "Y" -> 3
        "Z" -> 6
        else -> 0
    }

    fun predictedMoveScores(round: List<String>): Int {

        val movePlayed = round.first()
        val result = round.component2()
        var score = 0

        if (movePlayed == "A") {
            when(result) {
                "X" -> score = 3
                "Y" -> score = 1
                "Z" -> score = 2
            }
        }

        if (movePlayed == "B") {
            when(result) {
                "X" -> score = 1
                "Y" -> score = 2
                "Z" -> score = 3
            }
        }

        if (movePlayed == "C") {
            when(result) {
                "X" -> score = 2
                "Y" -> score = 3
                "Z" -> score = 1
            }
        }

        return score

    }

    // Part 1
    fun part1(input: List<String>): Int {

        val rounds = input.map { it.split(" ") }
        val totalRoundScores = rounds.sumOf { round -> calculateRoundScore(round) }
        val totalMoveScores = rounds.sumOf { round -> calculateMoveScore(round.component2()) }

        return totalRoundScores + totalMoveScores

    }

    // Part 2
    fun part2(input: MutableList<String>): Int {

        val rounds = input.map { it.split(" ") }
        val totalRoundScores = rounds.sumOf { round -> roundScores(round.component2()) }
        val totalMoveScores = rounds.sumOf { round -> predictedMoveScores(round) }

        return totalRoundScores + totalMoveScores
    }

//    // Implementation of part 1
    println(part1(input))
    // Implementation of part 2
    println(part2(input))

}
