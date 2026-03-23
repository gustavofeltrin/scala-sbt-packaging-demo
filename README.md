# scala-sbt-packaging-demo

A minimalist demonstration of how to compile, test, and package a **Scala 3** application into a standalone **Uber JAR** (Fat JAR) using `sbt` and `sbt-assembly`.

This project serves as a template for developers who want to distribute Scala applications as single, executable files that run on any system with a JVM, without requiring Scala to be pre-installed.

## 🚀 Quick Start

Ensure you have [sbt](https://www.scala-sbt.org/) and [Java 21+](https://adoptium.net/) installed.

```bash
# Clone the repository
git clone https://github.com/gustavofeltrin/scala-sbt-packaging-demo.git
cd scala-sbt-packaging-demo

# Build and run the Uber JAR in one command
make run-jar
```

---

## 🛠 Features

- **Scala 3.8.2**: Leveraging the latest features of the Scala 3 language.
- **sbt-assembly**: Configured to merge dependencies and handle Scala 3 library conflicts.
- **Simplified Workflow**: A `Makefile` is provided to wrap complex `sbt` commands into simple, memorable tasks.
- **MIT Licensed**: Free to use, modify, and distribute.

---

## 📋 Available Commands

Use the provided `Makefile` to manage the project lifecycle:

| Command | Action |
| :--- | :--- |
| `make compile` | Compiles the Scala source code. |
| `make test` | Runs the MUnit test suite. |
| `make run` | Runs the application directly via `sbt`. |
| `make package` | Generates the **Uber JAR** in `target/scala-3.8.2/`. |
| `make run-jar` | Builds the package and executes it using `java -jar`. |
| `make clean` | Removes all build artifacts and the `target` folder. |

---

## 📦 How Packaging Works
By default, `sbt package` creates a "thin" JAR containing only your code. This project uses the `sbt-assembly` plugin to create an **Uber JAR**.

The Uber JAR includes:

1. Your compiled `.class` files.
2. The Scala Standard Library (necessary for the JVM to understand Scala code).
3. All third-party dependencies defined in `libraryDependencies`.

### Running the JAR
Once packaged, you can move the `.jar` file to any server and run it using only the Java Runtime Environment:

```bash
java -jar target/scala-3.8.2/scala-sbt-packaging-demo-assembly-0.1.0-SNAPSHOT.jar
```

--- 

## 📝 Project Structure

```plaintext
.
├── LICENSE             # MIT License
├── Makefile            # Command shortcuts (run, test, package)
├── build.sbt           # Main build configuration & assembly strategy
├── project
│   └── plugins.sbt     # Includes sbt-assembly plugin
└── src
    └── main
        └── scala
            └── Main.scala # Entry point with @main annotation
```

--- 

## ⚖️ License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.