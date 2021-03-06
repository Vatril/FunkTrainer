package com.vatril.funktrainer

enum class RadioChar(val text: String, val character:Char) {
    A("alpha", 'A'),
    B("bravo", 'B'),
    C("charlie", 'C'),
    D("delta", 'D'),
    E("echo", 'E'),
    F("foxtrot", 'F'),
    G("golf", 'G'),
    H("hotel", 'H'),
    I("india", 'I'),
    J("juliet", 'J'),
    K("kilo", 'K'),
    L("lima", 'L'),
    M("mike", 'M'),
    N("november", 'N'),
    O("oscar", 'O'),
    P("papa", 'P'),
    Q("quebec", 'Q'),
    R("romeo", 'R'),
    S("sierra", 'S'),
    T("tango", 'T'),
    U("uniform", 'U'),
    V("victor", 'V'),
    W("whiskey", 'W'),
    X("x-ray", 'X'),
    Y("yankee", 'Y'),
    Z("zulu", 'Z'),
    N0("zero", '0'),
    N1("one", '1'),
    N2("two", '2'),
    N3("three", '3'),
    N4("four", '4'),
    N5("five", '5'),
    N6("six", '6'),
    N7("seven", '7'),
    N8("eight", '8'),
    N9("nine", '9');

    companion object {
        fun byCharacter(c:Char) = values().find { it.character == c  }
    }
}