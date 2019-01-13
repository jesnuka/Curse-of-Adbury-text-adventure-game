package o1.adventure.ui

import o1.adventure._
import scala.io.StdIn._

object AdventureTextUI extends App {

  val game = new Adventure
  
  println(this.game.welcomeMessage)
  while (!this.game.isOver) {
    println("\n" + this.game.executeCommand(readLine("\nWhat will you do? ")))
  }
}