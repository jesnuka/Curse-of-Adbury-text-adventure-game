package o1.adventure

import scala.collection.mutable.Buffer
import scala.collection.mutable.Map

class KeyExistsException(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)

class Item(val name: String, val descriptions: Buffer[String]) {
  var descriptionIndex = 0
  var itemInInterest: Option[Item] = None

  def description = this.descriptions(this.descriptionIndex)

  def get(adventure: Adventure) = {
    s"You pick up ${this.name}."
  }

  def use(adventure: Adventure) = {
    "There seems to be no use for that."
  }

  def examine(adventure: Adventure): String = {
    if (this.itemInInterest.isDefined) {
      val itemName = this.itemInInterest.get.name
      adventure.player.location.addItem(this.itemInInterest.get)
      this.itemInInterest = None
      val result = this.description
      this.descriptionIndex += 1
      result + "\n" + adventure.player.get(itemName)
    } else {
      this.description
    }
  }
}

object Item {
  def apply(name: String, description: String) = {
    new Item(name, Buffer(description))
  }
  
  def apply(name: String, descriptions: Buffer[String]) = {
    new Item(name, descriptions)
  }
}

class Area(val name: String, var title: String, val descriptions: Buffer[String]) {

  val opposites = Map("north" -> "south", "west" -> "east", "up" -> "down")
  opposites.foreach(p => opposites += p._2 -> p._1) // append each link reversed
  var descriptionIndex = 0
  val links = Map[String, Area]()
  val items = Map[String, Item]()
  val interests = Map[String, Item]()

  def description = this.descriptions(this.descriptionIndex)

  def addItem(item: Item) = {
    if (this.items.contains(item.name)) {
      throw new KeyExistsException(item.name + " already in items of " + this.name)
    }
    this.items += item.name -> item
  }

  def addInterest(interest: Item) = {
    if (this.interests.contains(interest.name)) {
      throw new KeyExistsException(interest.name + " already in interests of " + this.name)
    }
    this.interests += interest.name -> interest
  }

  def link(area: Area, directionTo: String, directionFrom: String = "") = {
    this.addSingleLink(area, directionTo)
    var directionFrom_ = directionFrom // awkward helper to escape scope of if-block
    if (directionFrom_ == "") {
      directionFrom_ = opposites(directionTo)
    }
    area.addSingleLink(this, directionFrom_)
  }

  def addSingleLink(area: Area, direction: String) = {
    if (this.links.contains(direction)) {
      throw new KeyExistsException("Link direction " + direction + " already exists in links of " + this.name + ". Attempted target: " + area.name)
    }
    this.links += direction -> area
  }

  def arrive(direction: String, adventure: Adventure): String = {
    adventure.player.location = this
    s"You go ${direction}\n\n" + adventure.player.look
  }

  def fullDescription = this.title + "\n" + this.description
}

object Area {
  def apply(name: String, title: String, descriptions: Buffer[String]) = {
    new Area(name, title, descriptions)
  }
  
  def apply(name: String, title: String, description: String) = {
    new Area(name, title, Buffer(description))
  }
}