# Java Features Demo (Java 10-25)

This repository demonstrates modern Java features from Java 10 through Java 25.

## Repository Structure

- `trail/src/Main25.java` - Java 25 features demonstration
- `trail/src/StreamGatherers25.java` - Java 25 Stream Gatherers API examples
- `trail/src/Main21.java` - Java 21 features demonstration
- `trail/src/Main.java` - Java 17 and earlier features
- `trail/src/Letters.java` - Sealed class example
- `trail/src/Hash.java` - Sealed interface example
- `trail/src/English.java` - Text blocks and sealed types

## Features by Version

### Java 25
- **Flexible constructor bodies (JEP 482)** - Statements before super() in constructors
- **Primitive type patterns (JEP 455)** - Pattern matching with primitive types in switch and instanceof
- **Stream Gatherers** - Custom intermediate stream operations (windowFixed, windowSliding, fold, mapConcurrent)
- **Enhanced pattern matching** - Primitive patterns in switch expressions with guards

### Java 21
- **Record patterns in switch** - Pattern matching with records in switch expressions
- **Sequenced collections** - New collection interfaces with defined ordering (addFirst, addLast, reversed)
- **Virtual threads** - Lightweight threads for high-throughput concurrent applications

### Java 17
- **Sealed classes** - Control which classes can extend a class
- **Sealed interfaces** - Control which classes can implement an interface
- **Switch expressions** - Enhanced switch with arrow syntax
- **Pattern matching with instanceof** - Type patterns in instanceof
- **var-args** - Variable-length argument lists

### Java 15
- **Text blocks** - Multi-line string literals with proper formatting

### Java 10
- **Type inference (var)** - Local variable type inference

## Compilation Requirements

- Java 21 examples require Java 21 or later
- Java 25 examples require Java 25 or later (or a compatible early-access build)
