# Practice

Executable solutions for data-structure and algorithm problems, organized by topic rather than by source platform. Use the [practice index](INDEX.md) to locate a problem and track later reimplementations.

This project uses Gradle with Kotlin/JVM support, using a Java 27 toolchain and Kotlin 2.4.20. The mixed Java/Kotlin bytecode target is JVM 25, the newest target exposed by Kotlin 2.4.20. Java and Kotlin sources currently live under `src/main/java` and are compiled together.

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
