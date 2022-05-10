package com.example.chuprovkirillisp191ramalloh

fun main() {
    play(GameImp())
}

fun play(game: Game) {
    while (!game.isFinished) {
        render(game.field)
        println("Your turn: ")
        val input = readLine() ?: error("Can't read line")
        val points = input.split(" ").map { it.toInt() } // todo validate
        game.act(points[0], points[1])
    }
    // render
    // get input
    // act
    // render

}

fun render(field: Field) {
    repeat(field.size) { row ->
        repeat(field.size) { col ->

        }
    }
}

interface Game {
    val isFinished: Boolean
    val field: Field
    fun act(row: Int, col: Int)
}

interface Field {
    val size: Int
    fun get(row: Int, col: Int): Boolean?
}

class GameImp : Game {
    override val isFinished: Boolean = false
    override val field: Field = ArrayField(3)

    override fun act(row: Int, col: Int) {

    }
}

class ArrayField(override val size: Int) : Field {

    private val points: Array<Array<Boolean?>> = Array(size) { arrayOfNulls(size) }

    override fun get(row: Int, col: Int): Boolean? = points[row][col]
}
