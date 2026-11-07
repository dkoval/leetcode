# leetcode

[![CI/CD](https://github.com/dkoval/leetcode/actions/workflows/ci.yml/badge.svg)](https://github.com/dkoval/leetcode/actions/workflows/ci.yml)
[![Codecov](https://codecov.io/gh/dkoval/leetcode/branch/master/graph/badge.svg)](https://codecov.io/gh/dkoval/leetcode)
![Java 25](https://img.shields.io/badge/Java-25-orange)
![Kotlin 2.4](https://img.shields.io/badge/Kotlin-2.4-7F52FF)
[![License: MIT-0](https://img.shields.io/badge/license-MIT--0-blue)](LICENSE)

Solutions to 1,300+ [LeetCode](https://leetcode.com/) algorithmic problems in Java and Kotlin, each one backed by tests.
Written for anyone studying data structures and algorithms.

## How to read a solution

Every problem is a single interface named after the problem. Its Javadoc carries the problem statement, a link to
LeetCode and the constraints. Nested classes `Rev1`, `Rev2`, … are alternative approaches to the same problem, and
many of them note their time and space complexity.

```java
/**
 * <a href="https://leetcode.com/problems/process-tasks-using-servers/">Process Tasks Using Servers</a>
 * <p>
 * You are given two 0-indexed integer arrays servers and tasks ...
 * <p>
 * Constraints: ...
 */
public interface ProcessTasksUsingServers {

    int[] assignTasks(int[] servers, int[] tasks);

    class ProcessTasksUsingServersRev1 implements ProcessTasksUsingServers {
        // two priority queues: free servers by (weight, index), busy servers by release time
    }
}
```

Each solution has a Kotlin test next to it under `src/test`, written as a parameterized
JUnit test with AssertJ assertions. Read the test cases to see the example inputs.

## Finding a solution

Class names are problem titles in CamelCase, e.g. *Two Sum II - Input Array Is Sorted* → `TwoSum2InputArrayIsSorted`.

- On GitHub: press `t` and type the name.
- In IntelliJ IDEA: press `Shift` twice.
- In a terminal: `find src -name 'TwoSum*'`

## Running the tests

You need any JDK to start Gradle. The build uses a JDK 25 toolchain, and Gradle downloads it if it isn't installed.

```sh
./gradlew test                                          # all tests
./gradlew test --tests '*ProcessTasksUsingServersTest*' # one problem
```

The test run also produces a JaCoCo coverage report at `build/reports/jacoco/test/html/index.html`.

## License

The source code is available under the [MIT No Attribution License](LICENSE). You are free to use, copy, modify and
distribute it for any purpose, including commercially, without asking permission or giving credit.
