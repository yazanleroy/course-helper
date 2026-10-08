# Course Helper

A small Java console project for checking which courses a student can take based on completed prerequisites.

## Features

- View seven example courses and their prerequisites.
- Mark courses as completed, or undo a selection.
- See eligible courses and the exact prerequisites still missing.
- Handle unknown course codes, duplicate entries and invalid menu choices.

## Run

Install a JDK (Java 8 or newer). Open a terminal in this folder:

```sh
javac Course.java CourseHelper.java
java CourseHelper
```

In a Java IDE, open both source files and run `CourseHelper.main`.

## Example

Choose `2`, enter `CS101`, then choose `4`.

```text
CS101 - Already completed
MATH101 - Discrete Mathematics | Eligible
CS102 - Programming 2 | Eligible
CS201 - Data Structures | Missing: CS102
CS202 - Databases | Missing: CS102
SE201 - Software Engineering | Missing: CS102
CS301 - Algorithms | Missing: CS201, MATH101
```

For Algorithms, both Data Structures and Discrete Mathematics must be completed.

## How it works

`Course.java` stores a course code, name and prerequisite codes.
`CourseHelper.java` contains the sample catalog and menu. An `ArrayList` holds completed courses. The program loops over each course's prerequisites and lists any that are missing.

## Limits

These are fictional course codes and requirements, not Al Ain University's official curriculum. Eligibility here checks prerequisites only; it does not check timetables, seats, grades, credits or registration rules. Completed courses exist only during the current run. A student can enter any past completed course without reconstructing their full academic history.

## Possible next improvements

- Save completed courses to a file.
- Load the course catalog from a file.
- Add a maximum credit limit for a semester.

For an Arabic walkthrough, see [EXPLANATION_AR.md](EXPLANATION_AR.md).
