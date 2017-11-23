data class Person(
    val Koerpergewicht:Double,
    val Koerpergroesse:Double,
    val Geschlecht:Boolean,
    var Bmi:Double=0.0
)
fun main(args: Array<String>) {
    val person = Person(
            Koerpergroesse = abfrageGewichtOderGroesse("Körpergrösse? in cm"),
            Koerpergewicht = abfrageGewichtOderGroesse("Körpergewicht? in kg"),
            Geschlecht = abfrageGeschlecht("Welches Geschlecht bist Du? m oder w")            )
    person.Bmi = berechnung(person)
    println("Du hast "+berechnungAusgabe(person)+" ("+person.Bmi+")")
}

fun abfrageGewichtOderGroesse(frage:String):Double{
    println(frage)
    val result = readLine()
    if (result != null)
    try{
        return result.toDouble()
    }
    catch (e: Exception){
        println("Fehleingabe: $e")
    }
    return 0.0
}

fun berechnung(person:Person):Double{
    return person.Koerpergewicht / (Math.pow(person.Koerpergroesse/100,2.0))
}

fun abfrageGeschlecht(frage:String):Boolean{
    println(frage)
    val result = readLine()
    if (result != null && result == "m") {
        return false
    }
    else if (result != null && result == "w"){
        return true
    }
    else
    {
        println("Fehleingabe Geschlecht")
        return true
    }
}

fun berechnungAusgabe(person:Person):String{
    if (person.Geschlecht==false){
        return berechnungBmiM(person.Bmi)
    }
    else if (person.Geschlecht==true){
       return berechnungBmiW(person.Bmi)
    }
    else {
        return "Fehler Berechnung BMI"
    }
}
fun berechnungBmiM(bmi:Double):String{
    when (bmi){
        in 0..19 -> return "Untergewicht"
        in 20..24 -> return "Normalgewicht"
        in 25..29 -> return "leichtes bis mittleres üUbergweicht"
        in 30..39 -> return "schweres Übergewicht"
        in 40..1000 -> return "massive gefährdendes Übergewicht"
        else -> return "Fehler Ausgabe String"
    }
}
fun berechnungBmiW(bmi:Double):String{
    when (bmi){
        in 0..18 -> return "Untergewicht"
        in 19..23 -> return "Normalgewicht"
        in 24..29 -> return "leichtes bis mittleres üUbergweicht"
        in 30..39 -> return "schweres Übergewicht"
        in 40..1000 -> return "massive gefährdendes Übergewicht"
        else -> return "Fehler Ausgabe String"
    }
}
