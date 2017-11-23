/**
 * Created by admin on 19.11.2017.
 */
data class Person(
        val Koerpergewicht: Double,
        val Koerpergroesse: Double,
        val Geschlecht: Boolean,
        var Bmi: Double = 0.0
)

fun main(args: Array<String>) {
    val person = Person(
            Koerpergroesse = abfrageGewichtOderGroesse("Körpergrösse? in cm"),
            Koerpergewicht = abfrageGewichtOderGroesse("Körpergewicht? in kg"),
            Geschlecht = abfrageGeschlecht("Welches Geschlecht bist Du? m oder w"))
    person.Bmi = berechnung(person)
    println("Du hast " + berechnungBmi(person) + " (" + person.Bmi + ")")
}

fun abfrageGewichtOderGroesse(frage: String): Double {
    println(frage)
    val result = readLine()
    if (result != null)
        try {
            return result.toDouble()
        } catch (e: Exception) {
            println("Fehleingabe: $e")
        }
    return 0.0
}

fun berechnung(person: Person): Double {
    return person.Koerpergewicht / (Math.pow(person.Koerpergroesse / 100, 2.0))
}

fun abfrageGeschlecht(frage: String): Boolean {
    println(frage)
    val result = readLine()
    if (result != null && result == "m") {
        return false
    } else if (result != null && result == "w") {
        return true
    } else {
        println("Fehleingabe Geschlecht")
        return true
    }
}

fun berechnungBmi(person: Person): String {
    var result: String = "Fehler berechnungBmi"
    if (person.Geschlecht == false) {
        when (person.Bmi) {
            in 0..19 -> result = "Untergewicht"
            in 20..24 -> result = "Normalgewicht"
            in 25..29 -> result = "leichtes bis mittleres üUbergweicht"
        }
    } else {
        when (person.Bmi) {
            in 0..18 -> result = "Untergewicht"
            in 19..23 -> result = "Normalgewicht"
            in 24..29 -> result = "leichtes bis mittleres üUbergweicht"
        }
    }
    when (person.Bmi) {
        in 30..39 -> result = "schweres Übergewicht"
        in 40..1000 -> result = "massive gefährdendes Übergewicht"
    }
    return result
}
