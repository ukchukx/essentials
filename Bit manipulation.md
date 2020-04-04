## Bit manipulation


#### Operator
| Operator  | Description         |
| --------- | ------------------- |
| &         | AND                 |
| |         | OR                  |
| ^         | XOR                 |
| ~         | NOT (1's complement)|
| <<        | shift left          |
| >>        | shift right         |

#### Identity
Since `x + ~x = -1`, it follows that `-x = ~x + 1`

Example:
```
x  = 0b011011000
~x = 0b100100111
-x = 0b100101000
```

## Common idioms

**Problem**

Set kth bit in a word x to 1

Idea

Shift and OR

`y = x | (1 << k)`

Example

`k = 7`

|                   |  |
| ----------------- | ---------------------- | 
| `x`               | 10111101**0**1101101   |
| `1 << k`          | 00000000**1**0000000   |
| `x | (1 << k) `   | 10111101**1**1101101   |


**Problem**

Set kth bit in a word x to 0

Idea

Shift, complement and AND

`y = x & ~(1 << k)`

Example

`k = 7`

|                   |  |
| ----------------- | ---------------------- | 
| `x`               | 10111101**1**1101101   |
| `1 << k`          | 00000000**1**0000000   |
| `~(1 << k)`       | 11111111**0**1111111   |
| `x & ~(1 << k)`   | 10111101**0**1101101   |


**Problem**

Toggle the kth bit in a word x

Idea

Shift and XOR

`y = x ^ (1 << k)`

Example

`k = 7`

|                   |  |
| ----------------- | ---------------------- | 
| `x`               | 10111101**0**1101101   |
| `1 << k`          | 00000000**1**0000000   |
| `x & ~(1 << k)`   | 10111101**1**1101101   |


**Problem**

Extract a bit field from a word x

Idea

Mask and shift

`y = x & mask >> shift`

Example

`shift = 7`

|                     |  |
| -----------------   | ---------------------- | 
| `x`                 | 10111**1010**1101101   |
| `mask`              | 00000**1111**0000000   |
| `x & mask`          | 00000**1010**0000000   |
| `x & mask >> shift` | 000000000000**1010**   |


**Problem**

Set a bit field in a word x to a value y

Idea

Invert mask to clear, and OR the shifted value.

`x = (x & ~mask) | (y << shift)`

For safety, first `(y << shift) & mask` to clear unwanted values in the higher bits before OR-ing

Example

`shift = 7`

|                             |  |
| -----------------           | ---------------------- | 
| `x`                         | 10111**1010**1101101   |
| `y`                         | 000000000000**0011**   |
| `mask`                      | 00000**1111**0000000   |
| `x & ~mask`                 | 10111**0000**1101101   |
| `(x & ~mask) | (y << shift)`| 10111**0011**1101101   |


**Problem**

Swap x and y without using a temporary

Solution

`x = x ^ y` - Mask with 1's where bits differ

`y = x ^ y` - Flip bits in `y` that differ from `x`

`x = x ^ y` - Flip bits in `x` that differ from `y`

_NB: This is poor at exploiting instruction-level parallelism_

Example

|     |           |  `x = x ^ y`  |  `y = x ^ y`  |  `x = x ^ y`  |
| --- | --------- | ------------- | ------------- | ------------- | 
| `x` | 10111101  | **10010011**  | 10010011      | **00101110**  |
| `y` | 00101110  | 00101110      | **10111101**  | 10111101      |

This works because XOR is its own inverse
`(x ^ y) ^ y = x`

| `x` | `y` | `x ^ y` | `(x ^ y) ^ y` |
| --- | --- | ------- | ------------- |
| 0   | 0   |    0    |      0        |
| 0   | 1   |    1    |      0        |
| 1   | 0   |    1    |      1        |
| 1   | 1   |    0    |      1        |


**Problem**

Find the minimum r of two integers x and y without using a branch

Solution

`r = y ^ ((x ^ y) & -(x < y))`

NB: This works for languages that represent booleans with 1 and 0.

When `x < y`, 

`-(x < y)` = -1 which is all 1's in 2's complement representation

`r = y ^ (x ^ y) = x`

When `x >= y`, 

`-(x < y)` = 0

`r = y ^ 0 = y`


**Problem**

Compute (x + y) mod n, assuming that 0 <= x < n and 0 <= y < n


`r = (x + y) % n` is the normal way to do this, but division is expensive, unless by a power of 2

Using the same trick as minimum,
```
z = x + y
r = z - (n & -(z >= n))
```

When `z < n`, 

`-(z >= n)` = 0

`r = z - (0) = z`

When `z >= n`, 

`-(z >= n)` = -1

`r = z - n`

For comparison, here's the same solution using branches:
```
z = x + y
r = (z < n) ? z : z-n
```


**Problem**

Round up to a power of 2

Idea

Compute 2<sup>(log<sub>2</sub> n)</sup>

Solution

```c
uint64_t n;  // 0010000001010000
// flip the rightmost 1 bit to 0 and fills in all the 0's with 1's after 1. 
// Guarantees that bit (log(2)n) - 1 must be set and also makes this word
// if n is already a power of 2.
--n;         // 0010000001001111
// propagate the 1's bit x position to the right and OR them with n.
// This populates all the bits to the right with 1's
n |= n >> 1; // 0011000001101111 
n |= n >> 2; // 0011110001111111
n |= n >> 4; // 0011111111111111
n |= n >> 8; // ...
n |= n >> 16; // ...
n |= n >> 32; // ...
// At this point, n is one less than a power of 2
// Set bit log(2)n and clear all other bits
++n;          // 010000000000000
```


**Problem**

Compute the mask of the least-significant 1 in word x

Solution

`r = x & (-x)`

Example

|             |                     |
| ----------- | ------------------  | 
| `x`         | 0010000001010000    |
| `-x`        | 1101111110110000    |
| `x & (-x)`  | 00000000000**1**0000|

This works because the binary representation of `-x` is `~x + 1`


**Problem**

Find the index of a bit ie the log<sub>2</sub> of a power of 2

Idea

Compute log<sub>2</sub>x, where x is a power of 2

Solution I (for k=8)

```c
const unint64_t deBruijn = 0x022fdd63cc95386d;
const int convert[64] = {
  0,   1, 2,  53,  3,  7, 54, 27,
  4,  38, 41,  8, 34, 55, 48, 28,
  62,  5, 39, 46, 44, 42, 22,  9,
  24, 35, 59, 56, 49, 18, 29, 11,
  63, 52,  6, 26, 37, 40, 33, 47,
  61, 45, 43, 21, 23, 58, 17, 10,
  51, 25, 36, 32, 60, 20, 57, 16,
  50, 31, 19, 15, 30, 14, 13, 12
};
r = convert[(x * deBruijn) >> 58];
```
A deBruijn sequence s of length 2<sup>k</sup> is a cyclic 0-1 sequence such that each of the 2<sup>k</sup> 0-1 strings of length k occurs exactly once as a substring of s.

NB: The sequence should start with all 0's.

A deBruijn sequence of k=3
```
   0001101
0  000
1   001
2    011
3     111
4      110
5       101
6        010
7         100
```
And a covert table for the above sequence is
```c
const int convert[8] = {0,1,6,2,7,5,4,3};
```
Using the table above to compute log<sub>2</sub>16, where 16 = 2<sup>4</sup>:
```
0b00011101 * 16 = 0b11010000 (right-shifting 4 times)
0b11010000 >> 5 = 6
convert[6] = 4
```

Solution II (using popcount)
Substract 1 from the power of 2 (populates all the lower bits with 1's)

Then do a popcount to count the 1's which is the log<sub>2</sub> of the power of 2


**Problem**

Population count: Count the number of 1's in a word x

Solution I
```c
for (r = 0; x != 0; ++r) x &= x - 1; repeatedly eliminate the least-significant 1
```
Example

|               |                       |
| -----------   | ------------------    | 
| `x`           | 00101101110**1**0000  |
| `x - 1`       | 00101101110**0**1111  |
| `x & (x - 1)` | 00101101110**0**0000  |

This is fast is the popcount is small, but has a time complexity of O(n), where n = number of bits

Solution II
```c
// Stores the number of 1's for each 8-bit word
static const int count[256] = {0,1,1,2,1,2,2,3,1,/*...*/,8};

// For every 8-bit word in x,
// look up the number of 1's in the count table and add it to r
// then right-shift x by 8 to get the next word
for (int r = 0; x != 0; x >>= 8) r += count[x & 0xFF];
```
Performance depends on the size of x, with the cost of memory operations being the major bottleneck.

Solution III
```c
// Masks
M5 = ~((-1) << 32); // 32 0's followed by 32 1's
M4 = M5 ^ (M5 << 16); // (16 0's followed by 16 1's) repeated 2 times
M3 = M4 ^ (M4 << 8); // (8 0's followed by 8 1's) repeated 4 times
// 
M2 = M3 ^ (M3 << 4); // (4 0's followed by 4 1's) repeated 8 times
// mask to produce the bottom 2 bits in every group of 4 bits
M1 = M2 ^ (M2 << 2); // (2 0's followed by 2 1's) repeated 16 times
// even bits mask
M0 = M1 ^ (M1 << 1); (01) repeated 32 times
// Compute popcount
// The separate ANDs for M0 and M1 is to avoid overflow
x = ((x >> 1) & M0) /* odd bits */ + (x & M0); // count of 1 bits in every bit pair
x = ((x >> 2) & M1) /* top two bits */ + (x & M1); // count of 1 bits in every bit group of size 4

x = ((x >> 4) + x) & M2; // count of 1 bits in every group of size 8
x = ((x >> 8) + x) & M3; // count of 1 bits in every group of size 16
x = ((x >> 16) + x) & M4; // count of 1 bits in every group of size 32
x = ((x >> 32) + x) & M5;
```
The time complexity of this is O(log<sub>2</sub> w), where w = word bits

Example
```
1 1 0 0 0 0 1 0 0 1 0 1 1 0 1 1 1 1 1 1 0 1 0 0 0 1 1 1 1 0 0 0     x

  1   0   0   0   1   1   0   1   1   1   1   0   1   1   0   0     x & M0
+ 
  1   0   0   1   0   0   1   1   1   1   0   0   0   1   1   0     (x >> 1) & M0
---------------------------------------------------------------
    0 0     0 1     0 1     1 0     1 0     0 0     1 0     0 0      x & M1
+                                                        
    1 0     0 0     0 1     0 1     1 0     0 1     0 1     0 1      (x >> 2) & M1
---------------------------------------------------------------
        0 0 0 1         0 0 1 1         0 0 0 1         0 0 0 1      x & M2
+   
        0 0 1 0         0 0 1 0         0 1 0 0         0 0 1 1      (x >> 4) & M2
---------------------------------------------------------------
                0 1 0 1 1 0 1 1                 0 0 0 0 0 1 0 0      x & M3
+
                1 1 0 0 0 0 1 0                 0 0 0 0 0 1 0 1      (x >> 8) & M3
---------------------------------------------------------------
                                0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1      x & M4
+
                                0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0      (x >> 16) & M4
---------------------------------------------------------------
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1        17
```