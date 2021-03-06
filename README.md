# Semantic Versioning
Simple library to generate and validate semantic versioning

## Usage
after importing core classes
```Scala
  import semantic.Versioning._
```

Version case class can be instantiated either using:
```Scala
Version(Major(1), Minor(3), Patch(3))
```
or simply:
```Scala
Version(1, 3, 3)
```

### Validation
Version supports validate: 
```Either[String, Version]```
example:

```Scala
Version(2, 1, -4).validate  // Left(semantic.Semantic$Patch must be non negative)
```
### Equality

```Scala
Version(2, 1, 2).equals Version(2, 1, 8) // false
```

### String Representation

```Scala
Version(2, 1, 2).toString // 2.1.2
```

### Incrementing/Decrementing

import Updater typeclasses

```Scala
import semantic.Updater._
```
then you can increment or decrement each section of the Version
```Scala
Version(1, 3, 3).incrementMajor // Version(2, 3, 3)
```
More examples are in the examples directory.


