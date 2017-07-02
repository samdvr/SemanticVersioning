package semantic

import semantic.Versioning.{Major, Minor, Patch, Version}


object Updater {

  implicit class VersionIncrementer(version: Version) {
    def incrementMajor: Version = version.copy(major = Major(version.major.increment))
    def incrementMinor: Version = version.copy(minor = Minor(version.minor.increment))
    def incrementPatch: Version = version.copy(patch = Patch(version.patch.increment))
  }


  implicit class VersionDecrementer(version: Version) {
    def decrementMajor: Version = version.copy(major = Major(version.major.decrement))
    def decrementMinor: Version = version.copy(minor = Minor(version.minor.decrement))
    def decrementPatch: Version = version.copy(patch = Patch(version.patch.decrement))
  }

}

