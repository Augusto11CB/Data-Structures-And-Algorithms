# Data Structures and Algorithms Problems

This project uses Gradle with Kotlin/JVM support. Java and Kotlin sources currently live under `src/main/java` and are compiled together.

## IntelliJ IDEA

Open the directory containing `settings.gradle.kts` and import it as a Gradle project. IntelliJ will configure the Java and Kotlin modules from the Gradle build instead of relying on checked-in IDE metadata.

Run either example directly from IntelliJ:

- `com.buenosdev.arraymatrix.containsduplicate.ProblemSolution` (Java)
- `com.buenosdev.trie.TrieKotlinKt` (Kotlin)

## Command line

```bash
./gradlew build
./gradlew runContainsDuplicate
./gradlew runTrieKotlin
```

The Gradle wrapper downloads the pinned Gradle version automatically.
