package semantic
import cats.implicits._
import Validation._
import cats.{Eq, Show}


object Versioning {

  sealed trait versionComponent {
    val value:Int
    def increment: Int = value+1
    def decrement: Int = value+1
  }

  final case class Major(value: Int) extends versionComponent
  final case class Minor(value: Int) extends versionComponent
  final case class Patch(value: Int) extends versionComponent


  implicit val versionEq = Eq[Version] {
    (x: Version, y: Version) =>
      x.major == y.major && x.minor == y.minor && x.patch == y.patch
  }

  implicit val versionShow = Show[Version] {
    (x: Version) =>
      List(x.major.value, x.minor.value, x.patch.value).mkString(".")
  }

  case class Version(major: Major, minor: Minor, patch: Patch) {

    def equals(obj: Version): Boolean = this === obj
    override def toString:String = this.show
    def validate = this.valid


  }

  object Version {
    def apply(major: Int, minor: Int, patch: Int): Version = new Version(Major(major), Minor(minor), Patch(patch))
    def apply(major: Major, minor: Minor, patch: Patch): Version = new Version(major, minor, patch)
  }



}










