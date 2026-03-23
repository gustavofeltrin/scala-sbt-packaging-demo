# Variables
SBT = sbt
VERSION = 0.1.0-SNAPSHOT
NAME = scala-sbt-packaging-demo
SCALA3_VERSION = 3.8.2

.PHONY: all compile test run package clean

# Default target
all: compile

## Compile the project
compile:
	$(SBT) compile

## Run the unit tests
test:
	$(SBT) test

## Run the application
run:
	$(SBT) run

## Package the application as a Fat JAR (Uber-JAR)
package:
	$(SBT) assembly
	@echo "Fat JAR created in target/scala-$(SCALA3_VERSION)/"

## Run the packaged JAR directly via Java (The ultimate test)
run-jar: package
	java -jar target/scala-$(SCALA3_VERSION)/$(NAME)-assembly-$(VERSION).jar

## Remove build artifacts
clean:
	$(SBT) clean