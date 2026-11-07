# leetcode

[![CI/CD](https://github.com/dkoval/leetcode/actions/workflows/ci.yml/badge.svg)](https://github.com/dkoval/leetcode/actions/workflows/ci.yml)
[![Codecov](https://codecov.io/gh/dkoval/leetcode/branch/master/graph/badge.svg)](https://codecov.io/gh/dkoval/leetcode)
![Java 25](https://img.shields.io/badge/Java-25-orange)
![Kotlin 2.4](https://img.shields.io/badge/Kotlin-2.4-7F52FF)
[![License: MIT-0](https://img.shields.io/badge/license-MIT--0-blue)](LICENSE)

Solutions to 1,300+ [LeetCode](https://leetcode.com/) algorithmic problems in Java and Kotlin, each one backed by tests.
Written for anyone studying data structures and algorithms or preparing for a coding interview.

## How to read a solution

Most problems are a single interface named after the problem. Its Javadoc carries the problem statement, a link to
LeetCode and the constraints. Nested classes `Rev1`, `Rev2`, … are alternative approaches to the same problem, and
many of them note their time and space complexity, e.g. `// O(N) time | O(1) space`.

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

Older solutions are plain classes, and an alternative approach may live in its own file with a suffix such as `DP`
or `BottomUp` (e.g. `UniquePathsDPBottomUp`).

Nearly every solution has a matching `<ProblemName>Test` under `src/test`, mostly a parameterized JUnit 5+ test written
in Kotlin. Its test cases list inputs with expected outputs, so it is a good place to start reading.

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
