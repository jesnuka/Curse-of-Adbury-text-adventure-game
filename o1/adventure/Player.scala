package o1.adventure

import scala.collection.mutable.Map

class Player(startingArea: Area, val adventure: Adventure) {
  var location = startingArea
  var inventory = Map[String, Item]()

  def go(direction: String) = {
    if (this.location.links.contains(direction)) {
      this.location.links(direction).arrive(direction, adventure)
    } else {
      s"You can't go ${direction}."
    }
  }

  def examine(itemName: String): String = {
    if (this.inventory.contains(itemName)) {
      s"You look closely at the ${itemName}.\n${this.inventory(itemName).examine(this.adventure)}"
    } else if (this.location.interests.contains(itemName)) {
      s"You look closely at the ${itemName}.\n${this.location.interests(itemName).examine(this.adventure)}"
    } else {
      s"There's no ${itemName} here."
    }
  }

  def use(itemName: String): String = {
    if (this.inventory.contains(itemName)) {
      this.inventory(itemName).use(this.adventure)
    } else {
      "You don't have that!"
    }
  }

  def combine(modifiers: String): String = {
    val arguments = modifiers.split(" ")
    if (arguments.size == 2 && arguments.contains("lantern") && arguments.contains("candle")) {
      if (this.inventory.contains("lantern") && this.inventory.contains("candle")) {
        this.inventory -= "candle"
        this.inventory("lantern").descriptionIndex += 1
        "You light the candle and place it firmly inside the lantern."
      } else {
        "You don't manage to do that."
      }
    } else {
      "You don't manage to do that."
    }
  }

  def get(itemName: String): String = {
    if (this.location.items.contains(itemName)) {
      this.inventory += itemName -> this.location.items(itemName)
      this.location.items -= itemName
      this.inventory(itemName).get(this.adventure)
    } else {
      s"There is no ${itemName} here to pick up."
    }
  }

  def fall(adventure: Adventure): String = {
    val cliffareas = Vector("lighthouse street", "lighthouse hill 1", "lighthouse hill 2", "lighthouse hill 3", "stone path end", "cave balcony")
    if (this.location.name.contains("ladder")) {
      adventure.quitted = true
      "You let go of the ladder and let gravity pull your body downwards. \nYou fall for some time when suddenly, everything goes dark. \nThe mystery of the town of Adbury was never solved and you were never heard from again.\n-- STUPID ENDING -- "
    } else if (cliffareas.contains(this.location.name)) {
      adventure.quitted = true
      "For some insane reason, you decide to jump down the cliff. \nYou fall for some time until suddenly, you hit the ground below. \nThe mystery of the town of Adbury was never solved and you were never heard from again.\n-- STUPID ENDING -- "
    } else if (this.location.name.equals("pier")) {
      adventure.quitted = true
      "For some insane reason you decide to jump into the cold storming sea. \nYou weren't as good of a swimmer as you thought and get pulled underwater immediately by the sea currents.\nThe mystery of the town of Adbury was never solved and you were never heard from again.\n-- STUPID ENDING -- "
    } else if (this.location.name.equals("lighthouse top")) {
      adventure.quitted = true
      "You decide to jump down the staircase. \nYou start rolling down the spiraling stairs, hitting your head on the stone ground repeatedly, which can't be healthy. \nYou lose consciousness before you reach the bottom floor.\nThe mystery of the town of Adbury was never solved and you were never heard from again. \n-- STUPID ENDING -- "
    } else {
      "You can't see a place to jump down from."
    }
  }

  def showInventory: String = {
    if (inventory.size != 0) {
      "Your inventory: " + this.inventory.keys.mkString(", ")
    } else {
      "Your inventory is empty."
    }
  }

  def look: String = this.location.fullDescription
}


