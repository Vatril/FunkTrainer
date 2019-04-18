package com.vatril.funktrainer.util

import com.vatril.funktrainer.RadioChar
import com.vatril.funktrainer.dataclass.Challenge
import kotlin.random.Random

object ChallengeGenerator {
    private val characters = ('A'..'Z') + ('A'..'Z') + ('A'..'Z') + ('0'..'9')

    fun random(): Challenge {
        val randomString = (1..6)
            .map{ Random.nextInt(0, characters.size)}
            .map(characters::get)
            .distinct()
            .joinToString ("")

        return Challenge(randomString, randomString.map{ RadioChar.byCharacter(it)!! })
    }
}