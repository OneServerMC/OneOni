package io.github.oneservermc.oneoni.game

class GameManager {

    companion object {
        private var instance: GameManager? = null
        private var gamemode: Int = 0 // 1 = おにごっこ, 2 = かくれんぼ

        fun getInstance(): GameManager {
            if (instance == null)
                instance = GameManager()

            return instance!!
        }

        fun getGameMode(): Int {
            return gamemode
        }
    }

    fun startGame() {
        when (getGameMode()) {
            0 -> {

            }
        }
    }

    fun finishGame() {

    }

    fun resetGame() {

    }
}