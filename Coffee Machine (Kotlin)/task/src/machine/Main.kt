package machine

import java.lang.Exception

class CoffeeMachine(private var water : Int = 400, private var milk : Int = 540, private var coffee : Int = 120, private var cups : Int = 9, private var money : Int = 550){

    private fun resources(expectedWater : Int, expectedMilk : Int, expectedCoffee : Int) : String{
        if(water >= expectedWater && milk >= expectedMilk && coffee >= expectedCoffee && cups > 0){
            return "I have enough resources, making you a coffee!"
        }
        else{
            throw  Exception("Sorry, not enough ${if(water < expectedWater) "water" else if(milk < expectedMilk) "milk" else if(coffee < expectedCoffee) "coffee" else "cups"}!")
        }
    }

    private fun remaining(){
        println("\nThe coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffee g of coffee beans")
        println("$cups disposable cups")
        println("\$$money of money")
    }

    private fun buying(){
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val coffeeType = readln()
        when (coffeeType) {
            "1" -> {
                try{
                    println(resources(250,0,16))
                    water -= 250
                    coffee -= 16
                    money += 4
                    cups--
                }
                catch (e : Exception){
                    println(e.message)
                }
            }

            "2" -> {
                try{
                    println(resources(350,75,20))
                    water -= 350
                    milk -= 75
                    coffee -= 20
                    money += 7
                    cups--
                }
                catch(e : Exception){
                    println(e.message)
                }
            }

            "3" -> {
                try{
                    println(resources(200,100,12))
                    water -= 200
                    milk -= 100
                    coffee -= 12
                    money += 6
                    cups--
                }
                catch (e : Exception){
                    println(e.message)
                }
            }
            else ->{}
        }
    }
    private fun fill(){
        println("\nWrite how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffee += readln().toInt()
        println("Write how many disposable cups you want to add:")
        cups += readln().toInt()
    }

    private fun take(){
        println("\nI gave you \$$money")
        money = 0
    }

    fun action(action : String){
        when(action){
            "remaining" -> remaining()
            "buy" -> buying()
            "fill"-> fill()
            "take"-> take()
        }
    }
}


fun main(){

    val machine = CoffeeMachine()
    while(true){
        println("\nWrite action (buy, fill, take, remaining, exit)")
        val op = readln()
        when(op){
            "remaining" -> machine.action(op)
            "buy"-> machine.action(op)
            "fill"->machine.action(op)
            "take"->machine.action(op)
            "exit"->break
        }
    }
}
