class City(val name: String) {
    var degrees: Int = if(name == "Moscow") 5 else if(name == "Hanoi") 20 else 30
        set(value){
            field = if(value < -92 || value > 57) field else value
        }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third
    // println("${firstCity.degrees} ${secondCity.degrees} ${thirdCity.degrees}")
    //implement comparing here
    var list : MutableList<City> = mutableListOf(firstCity,secondCity,thirdCity)
    list = list.sortedWith( compareBy { it.degrees }).toMutableList()
    /* list.forEach{
        println(it.name)
    }*/
    println(if(list[0].degrees == list[1].degrees) "neither" else list[0].name)
}
