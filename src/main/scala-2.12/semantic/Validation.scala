package semantic

import semantic.Versioning.{Version, versionComponent}
import cats.implicits._

/**
  * Created by sam on 7/2/17.
  */
object Validation {

  implicit class ComponentValidation(versionComponent: versionComponent) {
    def validate: Either[String, Int] = {
      if (versionComponent.value >= 0)
        versionComponent.value.asRight
      else
        s"${versionComponent.getClass.getName} must be non negative".asLeft
    }
  }
  implicit class VersionValidation(version: Version) {
    def valid: Either[String, Version] = {
      for {
        _ <- version.major.validate
        _ <- version.minor.validate
        _ <- version.patch.validate
      } yield Version(version.major, version.minor, version.patch)
    }
  }

}
