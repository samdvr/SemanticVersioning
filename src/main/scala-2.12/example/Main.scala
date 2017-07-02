package example

import semantic.Versioning._
import semantic.Updater._

object Main extends App {

  override def main(args: Array[String]): Unit = {
    println(Version(1 ,2, 3) equals Version(Major(1),Minor(2),Patch(3))) // true

    println(Version(Major(1), Minor(2), Patch(3)).toString) // 1.2.3

    println(Version(1, 2, 3).validate)  // Right(1.2.3)

    println(Version(2, 1, -4).validate)  // Left(semantic.Semantic$Patch must be non negative)

    println(Version(1, 2, 3).incrementMajor) // 2.2.3
  }
}
