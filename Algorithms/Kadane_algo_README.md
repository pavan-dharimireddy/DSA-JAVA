# Kadane's Algorithm

## Description

This program implements **Kadane's Algorithm** to find the contiguous subarray within a one-dimensional array of numbers that has the largest sum. It prints the elements of the maximum sum subarray and the sum itself.

## Problem Statement

Given an integer array `arr` of size `n`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum and the subarray indices.

## Complexity

- **Time Complexity:** O(N) - The algorithm iterates through the array exactly once.
- **Space Complexity:** O(1) - It uses a constant amount of extra space for variables.

## Input/Output Format

### Input

1. An integer `n` representing the size of the array.
2. `n` integers representing the elements of the array.

### Output

1. The elements of the subarray with the maximum sum, each printed on a new line.
2. The maximum sum value printed at the end.

## Example

**Input:**

```text
8
-2 -3 4 -1 -2 1 5 -3
```

**Output:**

```text
4
-1
-2
1
5
7
```

_(Explanation: The subarray `[4, -1, -2, 1, 5]` has the maximum sum of `7`)_

## Usage

Compile and run the Java file:

```bash
javac Kadane_algo.java
java kadane_algo
```
