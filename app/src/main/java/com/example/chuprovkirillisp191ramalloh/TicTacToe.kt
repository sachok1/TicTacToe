package com.example.chuprovkirillisp191ramalloh

import kotlin.random.Random

//fun Boolean?.toMark(): String = when(this) {
//    true -> "X"
//    false -> "O"
//    null -> "-"
//}

interface Game {
    val isFinished: Boolean
    val winner: Boolean?
    val field: Field
    fun act(row: Int, col: Int) : Boolean
}

interface Field {
    val size: Int
    fun get(row: Int, col: Int): Boolean?
}

interface MutableField : Field {
    fun set(row: Int, col: Int, value: Boolean)
}

class GameImp : Game {

    override var isFinished: Boolean = false
    override val winner: Boolean? = null
    override val field: MutableField = ArrayField(3)

    private val userMark = Random.nextBoolean()

    init {
        if (!userMark) {
            actAi()
        }
    }

    override fun act(row: Int, col: Int): Boolean {
        if (field.get(row, col) != null) {
            return false
        }
        field.set(row, col, userMark)
        checkEnd()
        if (!isFinished){
            actAi()
            checkEnd()
        }
        return true
    }

    private fun checkEnd() {
        field.forEach { _, _, value ->
            if (value == null) {
                return
            }
        }
        isFinished = true

        //...
        val winnerCombination = mutableListOf<Sequence<Pair<Int, Int>>>().apply {
            val n = field.size
            // d 1
            add(
                sequence { repeat(n) { yield(it to it) } }
            )
            // d 2
            add(
                sequence { repeat(n) { yield(it to n - 1 - it) } }
            )
            // rows
            // ...
            // cols
        }
    }


    private fun actAi() {
        field.forEach { row, col, value ->
            if (value == null) {
                field.set(row, col, !userMark)
                return
            }
        }
    }
}

inline fun Field.forEach(action: (row: Int, col: Int, value: Boolean?) -> Unit) {
    repeat(size) { row ->
        repeat(size) { col ->
            action(row, col, get(row, col))
        }

    }
}

class ArrayField(override val size: Int) : MutableField {

    private val points: Array<Array<Boolean?>> = Array(size) { arrayOfNulls(size) }
    override fun set(row: Int, col: Int, value: Boolean) {
        points[row][col] = value
    }

    override fun get(row: Int, col: Int): Boolean? = points[row][col]
}
