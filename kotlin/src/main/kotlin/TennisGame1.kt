class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var player1Score: Int = 0
    private var player2Score: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === "player1") {
            player1Score += 1
        } else {
            player2Score += 1
        }
    }

    override fun getScore(): String {
        return if (player1Score == player2Score) {
            getScoreForEven()
        } else {
            getScoreForUneven()
        }
    }

    private fun getScoreForUneven(): String {
        return if (player1Score >= 4 || player2Score >= 4) {
            val minusResult = player1Score - player2Score
            if (minusResult == 1) {
                "Advantage player1"
            } else if (minusResult == -1) {
                "Advantage player2"
            } else if (minusResult >= 2) {
                "Win for player1"
            } else {
                "Win for player2"
            }
        } else {
            getScoreForRunningGame()
        }
    }

    private fun getScoreForRunningGame(): String {
        var tempScore1: Int
        var score1 = ""
        for (i in 1..2) {
            if (i == 1) {
                tempScore1 = player1Score
            } else {
                score1 += "-"
                tempScore1 = player2Score
            }
            when (tempScore1) {
                0 -> score1 += "Love"
                1 -> score1 += "Fifteen"
                2 -> score1 += "Thirty"
                3 -> score1 += "Forty"
            }
        }
        return score1
    }

    private fun getScoreForEven() = when (player1Score) {
        0 -> "Love-All"
        1 -> "Fifteen-All"
        2 -> "Thirty-All"
        else -> "Deuce"
    }
}
