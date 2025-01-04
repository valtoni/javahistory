# Java History

This project show ups the differences between each java major versions.

## Legends

- :heavy_exclamation_mark: Contributions are welcome!
- :heavy_check_mark: You can see in this feature in that project.
- :ok: Only informational.

## Java 9
- :heavy_check_mark: Module System (Project Jigsaw)
  - Break project in modules (Added [module-info](src/main/java/module-info.java) in each project).
  - Maven compiler plugin was changed to reflect [maven.compiler.release](pom.xml) property in as central pom.
- :heavy_exclamation_mark: JShell can be called in cmdline to be used as REPL (Read Evaluate Print Loop) tool.
  - ```jshell PRINTING``` will call jshell with command ```print```.
- :heavy_exclamation_mark: Javadoc can be generated with html5 output.
- :heavy_exclamation_mark: Stream API new methods: `takeWhile`, `dropWhile` and `iterate`.
- :heavy_check_mark: Private Method Interfaces are now allowed.
- :heavy_check_mark: Collection Factory Methods was introduced: `List.of`, `Set.of` and `Map.of`.
- :heavy_exclamation_mark: Process API provide more control and information about operating system processes.
- :heavy_exclamation_mark: HTTP/2 client that supports WebSocket too.
- :heavy_exclamation_mark: JAR files are now multi-release: it can contain different versions of classes for different versions of the Java runtime.
- :heavy_exclamation_mark: Stack frames was introduced as a flexible tool to navigate and analise stack frames. 
- Performance Improvements
  - :heavy_exclamation_mark: G1 Garbage Collector became the default one. It's the best for applications with large heaps.
  - :heavy_exclamation_mark: Ahead-of-time Compilation (AOT): allows java code to be compiled into native code before being executed.
  - :heavy_exclamation_mark: Improved JIT Compiler (Graal): includes experimental just-in0time compiler designed to optimize performance, especially for applications with a lot of dynamic code.
  - :heavy_exclamation_mark: Compact Strings: use less memory by storing strings as byte arrays instead of character arrays when possible. When applications use a lot of strings this can be a great significant memory saving.
- Added Tools
  - :heavy_exclamation_mark: Java Flight Recorder (JFR) - allows developers to collect detailed diagnostic and profiling data from a running java application.
  - :heavy_exclamation_mark: Java Mission Control (JMC) - suite of tools for monitoring and managing Java applications, specifically designed to analyze the data collected by the Java Flight Recorder.
  - :heavy_exclamation_mark: jcmd Enhancements - includes additional commands and options for gathering performance-related information from runnings JVMs.
  - :heavy_exclamation_mark: Stack-Walking API - traverse and analyze stack traces, inspect the call stack with fine-grained control.

## [Java 10](https://www.oracle.com/java/technologies/javase/10-relnote-issues.html)
- :heavy_check_mark: Local-variable type inference (var)
- :heavy_check_mark: Unmodifiable collections (List.copyOf, Set.copyOf, Map.copyOf) 
- :heavy_check_mark: Optional.orElseThrow() as a replacement for Optional.get()
- :heavy_check_mark: Application Class-Data Sharing (CDS) - applied onto maven
- :ok: Garbage-Collector interface - only to note, not necessary to make any changes in project
- Tricks
  - Run Source Files: java source file can be run calling directly `java TheWonderfulClass.java`.

## [Java 11](https://www.oracle.com/java/technologies/javase/11-relnote-issues.html)
- :heavy_check_mark: Strings - methods repeat, lines, strip, stripLeading, stripTrailing and isBlank
- :heavy_check_mark: Files - methods readString and writeString

## [Java 12](https://www.oracle.com/java/technologies/javase/12-relnote-issues.html)
- :heavy_check_mark: Strings - transform and indent

## [Java 13](https://www.oracle.com/java/technologies/javase/13-relnote-issues.html)
:neckbeard: Anything meaningful can be added. Contributes are welcome !

## [Java 14](https://www.oracle.com/java/technologies/javase/14-relnote-issues.html)
- :heavy_check_mark: Improved switch statements
- :heavy_check_mark: Multiline Strings
- :heavy_check_mark: Helpful NullPointerExceptions

## [Java 15](https://www.oracle.com/java/technologies/javase/15-relnote-issues.html)
- :heavy_check_mark: Text-Blocks / Multiline Strings
- :heavy_check_mark: Removed Nashorn JavaScript Engine
- :heavy_check_mark: [Z Garbage Collector](https://wiki.openjdk.org/display/zgc/Main) is production ready

## [Java 16](https://www.oracle.com/java/technologies/javase/16-relnote-issues.html)
- :heavy_check_mark: Pattern Matching for instanceof
- :heavy_check_mark: Unix Domain Sockets are now supported (note: UDS was introduced in Windows [starting at version 10 insider build 17063](https://devblogs.microsoft.com/commandline/af_unix-comes-to-windows/?form=MG0AV3))
- :heavy_exclamation_mark: An incubating package tool called `jpackage` was included and and the Java application can be turned into platform-specific packages, including all necessary dependencies. (TO-DO: add [maven plugin](https://akman.github.io/jpackage-maven-plugin/examples/from-application-image.html)). To Linux: deb and rpm, macOS: pkg and dmg and Windows: msi and exe.
