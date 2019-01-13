package o1.adventure

import scala.util.Random
import scala.collection.mutable.Map

class Adventure {
  var quitted = false
  val title = "The Curse of Adbury"
  val areas = LoadAreas()
  val player = new Player(areas("adbury gates"), this)
  val welcomeMessage = "You are a journalist who has come to investigate mysterious disappearings in the town of Adbury. \nThe road to the town goes through a huge forest of which not many maps exists, which is why only a few trading caravans visit the town.\nNot much is known about the town, but that never stopped you before.\n\n" + player.location.fullDescription
  //This countdown starts counting down once you reach cave start room. If you stay there too long without finishing the game or escaping, you die.
  var turnCountdown = 20
  var countdownEnabled = false
  val rng = new Random
  var grueLocation: Option[Area] = None
  var isComplete = false

  def isOver = this.isComplete || this.quitted

  def executeCommand(input: String): String = {
    if (this.countdownEnabled) {
      this.turnCountdown -= 1
    }
    val command = input.trim.toLowerCase
    val verb = command.takeWhile(_ != ' ')
    val modifiers = command.drop(verb.size).trim
    var output = ""

    if (verb == "go") {
      output = this.player.go(modifiers)
    } else if (verb == "quit") {
      this.quitted = true
      output = "You decide to end your investigation in the town of Adbury. The mystery was never solved."
    } else if (verb == "help") {
      output = "Available commands: \ngo (direction) \nget (itemname) \nexamine (itemname) \nexamine (object) \nquit \ninventory \nuse (itemname) \ncombine (itemname) (itemname)"
    } else if (verb == "look") {
      output = this.player.look
    } else if (verb == "get") {
      output = this.player.get(modifiers)
    } else if (verb == "use") {
      output = this.player.use(modifiers)
    } else if (verb == "combine") {
      output = this.player.combine(modifiers)
    } else if (verb == "think" || verb == "wonder") {
      output = "You wonder the mysteries of life for a bit, then continue on."
    } else if (verb == "xyzzy") {
      output = "You say the word out loud for some reason. You facepalm for the sheer stupidity of it."
    } else if (verb == "cry") {
      output = "Don't be such a crybaby."
    } else if (verb == "hi" || verb == "hello") {
      output = "You shouldn't be talking to yourself. What would your colleagues think?"
    } else if (verb == "pray") {
      output = "You pray for a moment. If you pray hard enough, your prayers might be answered."
    } else if (verb == "goodbye") {
      output = "Are you going somewhere?"
    } else if (verb == "dance") {
      output = "There is no time to be dancing around!"
    } else if (verb == "rest" || verb == "sleep") {
      output = "You have a job to do!"
    } else if (verb == "examine") {
      output = this.player.examine(modifiers)
    } else if (verb == "inventory") {
      output = this.player.showInventory
    } else if (verb == "combine") {
      output = "Implement this. If too difficult, just allow to use combine on empty lantern. If candle is in inventory, remove both and add Lantern"
    } else if (verb == "fall" || verb == "jump") {
      output = this.player.fall(this)
    }/* else if (verb == "w") {
      if (this.areas.contains(modifiers)) {
        this.player.location = this.areas(modifiers)
        output = "teleported poof"
      } else {
        output = "no such poof"
      }
    } */ else {
      if (this.countdownEnabled) {
        this.turnCountdown += 1
      }
      output = "You don't know how to " + command + "."
    }
    
    if (!this.quitted) {
      if (this.turnCountdown == 0) {
        this.quitted = true
        output += "\n\nSuddenly someone grabs you from behind. \nYou turn around to see a horrifying squidlike face with deep black eyes staring at you from under a black hood. \nThe creature yells at you in a strange language and knocks you unconscious.\nYou were never heard from again and the mystery of the town of Adbury was never solved. \n-- BAD ENDING --"
      } else if (this.turnCountdown == 4) {
        output += "\n\nYou feel as if someone is following you. You need to hurry up."
      } else if (this.turnCountdown == 9) {
        output += "\n\nYou get the feeling that someone will find you soon. It gets you nervous."
      }
    }

    if (this.grueLocation.isDefined && !this.quitted) {
      val links = this.grueLocation.get.links.values.toVector
      this.grueLocation = Some(links(this.rng.nextInt(links.size)))
      println(s"grue is at ${this.grueLocation.get.name}") // debug
      val immunity = this.player.inventory.contains("lantern") && this.player.inventory("lantern").descriptionIndex == 1
      if (this.grueLocation.get == this.player.location) {
        if (immunity) {
          output += "\n\nYou shudder. Did something just go past you?"
        } else {
          output += "\n\nYou have been eaten by a grue. \n-- HIDDEN ENDING --"
          this.isComplete = true
        }
      } else if (this.grueLocation.get.links.values.toVector.contains(this.player.location)) {
        if (!immunity) {
          output += "\n\nYou are likely to be eaten by a grue."
        }
      }
    }

    output
  }
}