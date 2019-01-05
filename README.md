# plainid-test

My solution to PlainID programming test

## Overview, structure

The solution includes a running program and some additional features that I thought completed the game.<br>
The solution is a maven project that produces an executable jar and includes some partial unit tests.<br>
The solution uses no 3rd party libraries (apart from junit).<br>

The solution is comprised of three main components separated to packages:<br>
* data - the data sctructure that holds the game board. it includes an interface and one implementation. this package includes unit tests.
* io - everything concerning input/output. includes interfaces and implementations
* game - the engine that drives the flow of the user interaction and game progress

The solution uses a "naive" constructor-based dependency injection. 
The game engine is constructed with an input and output instances so it is possible to bootstrap the engine with different implementations.
The main class acts as dependencies injector.

## Prerequisites

* [Java JDK](https://www.oracle.com/technetwork/java/javase/overview/index.html) - version 8 or higher (solution was built and tested with version 11)
* [Maven](https://maven.apache.org/) - version 3 or higher (solution was built with version 3.2.1)

## Build, Tests

from the base directory, run

```
mvn clean package
```
alternatively, invoke `build.cmd` from the base directory. This also runs the unit tests before producing the artifact.

## Run

from the base directory, run 

```
java -jar .\target\puzzle-1.0.jar
```
alternatively, invoke `run.cmd` from the base directory.
