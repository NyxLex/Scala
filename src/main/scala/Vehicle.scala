
class Vehicle(vin: String, manufacturer: String, model: String, modelYear: Int, finalAssemblyCountry: String) {
//  private Object createTs = System.currentTimeMillis()

  def start(): Unit = {
    println("Starting...")
  }

  def stop(): Unit = {
    println("Stopping...")
  }
}


class SportsUtilityVehicle(vin: String, manufacturer: String, model: String, modelYear: Int, finalAssemblyCountry: String, fourWheelDrive: Boolean)
  extends Vehicle(vin, manufacturer, model, modelYear, finalAssemblyCountry) { // inheritance example
  def enableFourWheelDrive(): Unit = {
    if (fourWheelDrive) println("Enabling 4 wheel drive")
  }

  override def start(): Unit = {
    enableFourWheelDrive()
    println("Starting SUV...")
  }
}

object InheritanceExample {
  def main(args: Array[String]): Unit = {
    val theAuto = new Vehicle("WAUZZZ8K6AA123456", "Audi", "A4", 2009, "Germany") // object creation is an example of abstraction
    theAuto.start()
    theAuto.stop()
    val anotherAuto: Vehicle = new SportsUtilityVehicle("WAUZZZ8K6A654321", "Audi", "Q7", 2019, "Germany", true)
    anotherAuto.start() // polymorphism
  }
}