package com.buenosdev.companiesquestions.uber.stoneGameII;

public class ProblemSolutionTwo {
    public int stoneGameII(int[] piles) {
        if (piles == null || piles.length == 0) return 0;

        // cache[i][j] is the max number of stones a player can get when the first pile is piles[i] and M == j.
        int[][] cache = new int[piles.length][piles.length];

        // Calculate the suffix sums to quickly get the total stones from any index to the end.
        int[] suffixSum = new int[piles.length];
        suffixSum[suffixSum.length - 1] = piles[piles.length - 1];
        for (int i = piles.length - 2; i >= 0; --i)
            suffixSum[i] = piles[i] + suffixSum[i + 1];

        // Start the recursion with the first pile and M = 1
        return helper(piles, suffixSum, cache, 0, 1);
    }

    // dfs with memoization
    private int helper(int[] piles, int[] suffixSum, int[][] cache, int firstPile, int M) {
        // Base case: No more piles left to take
        if (firstPile == piles.length) return 0;

        // Base case: The remaining piles are fewer than or equal to 2 * M, take all remaining piles
        if (piles.length - firstPile <= 2 * M) return suffixSum[firstPile];

        // If the result is already in cache, return it
        if (cache[firstPile][M] != 0) return cache[firstPile][M];

        int result = 0;
        // Try all possible moves from taking 1 to 2 * M piles
        for (int x = 1; x <= 2 * M; ++x) {
            // Calculate the optimal stones Alice can get by taking x piles
            // We subtract the result of the next player to maximize Alice's gain
            result = Math.max(result, suffixSum[firstPile] - helper(piles, suffixSum, cache, firstPile + x, Math.max(M, x)));
        }

        // Store the result in cache
        cache[firstPile][M] = result;
        return result;
    }

}

/*

Certainly! I'll illustrate the example step-by-step with a simple diagram to help visualize the recursive process and how the algorithm decides the optimal moves for Alice and Bob.

### Example: Piles = [2, 7, 9, 4, 4]

#### Step 1: Initialization
1. **Suffix Sum Calculation**:
   - `suffixSum[4] = 4`
   - `suffixSum[3] = 4 + 4 = 8`
   - `suffixSum[2] = 9 + 8 = 17`
   - `suffixSum[1] = 7 + 17 = 24`
   - `suffixSum[0] = 2 + 24 = 26`

   So, `suffixSum` array becomes `[26, 24, 17, 8, 4]`.

2. **Cache Initialization**:
   - Initialize a cache matrix with all zeros: `cache = new int[5][5]`.

### Step 2: Recursive Function Call

We start by calling `helper(piles, suffixSum, cache, 0, 1)`.

#### First Call: `helper(piles, suffixSum, cache, 0, 1)`

- **Try all possible moves (x = 1 to 2 * M)**:

  **For x = 1**:
  - Alice takes the first pile (`2` stones).
  - Remaining piles are `[7, 9, 4, 4]`.
  - Call `helper(piles, suffixSum, cache, 1, 1)` for Bob.

  **For x = 2**:
  - Alice takes the first two piles (`2 + 7 = 9` stones).
  - Remaining piles are `[9, 4, 4]`.
  - Call `helper(piles, suffixSum, cache, 2, 2)` for Bob.

#### Second Call: `helper(piles, suffixSum, cache, 1, 1)`

- **Try all possible moves (x = 1 to 2 * M)**:

  **For x = 1**:
  - Bob takes the first pile (`7` stones).
  - Remaining piles are `[9, 4, 4]`.
  - Call `helper(piles, suffixSum, cache, 2, 1)` for Alice.

  **For x = 2**:
  - Bob takes the first two piles (`7 + 9 = 16` stones).
  - Remaining piles are `[4, 4]`.
  - Call `helper(piles, suffixSum, cache, 3, 2)` for Alice.

#### Third Call: `helper(piles, suffixSum, cache, 2, 2)`

- **Base Case**:
  - `piles.length - firstPile <= 2 * M` (3 - 2 <= 2 * 2).
  - Bob takes all remaining piles:
    - `suffixSum[2] = 17`

  Bob collects `17` stones.

#### Combine Results

Back to the second call: `helper(piles, suffixSum, cache, 1, 1)`:

**For x = 1**:
- Bob takes `7` stones.
- Alice can get up to `helper(piles, suffixSum, cache, 2, 1)` which is calculated next.

#### Fourth Call: `helper(piles, suffixSum, cache, 2, 1)`

- **Try all possible moves (x = 1 to 2 * M)**:

  **For x = 1**:
  - Alice takes the first pile (`9` stones).
  - Remaining piles are `[4, 4]`.
  - Call `helper(piles, suffixSum, cache, 3, 1)` for Bob.

  **For x = 2**:
  - Alice takes the first two piles (`9 + 4 = 13` stones).
  - Remaining pile is `[4]`.
  - Call `helper(piles, suffixSum, cache, 4, 2)` for Bob.

#### Fifth Call: `helper(piles, suffixSum, cache, 3, 1)`

- **Base Case**:
  - `piles.length - firstPile <= 2 * M` (2 <= 2).
  - Alice takes all remaining piles:
    - `suffixSum[3] = 8`

  Alice collects `8` stones.

Back to the fourth call: `helper(piles, suffixSum, cache, 2, 1)`:

**For x = 1**:
- Alice takes `9` stones.
- Bob can get up to `helper(piles, suffixSum, cache, 3, 1)` which is `8`.

**For x = 2**:
- Alice takes `13` stones.
- Bob can get up to `helper(piles, suffixSum, cache, 4, 2)` which is next.

#### Sixth Call: `helper(piles, suffixSum, cache, 4, 2)`

- **Base Case**:
  - `piles.length - firstPile <= 2 * M` (1 <= 4).
  - Bob takes the remaining pile:
    - `suffixSum[4] = 4`

  Bob collects `4` stones.

Back to the fourth call: `helper(piles, suffixSum, cache, 2, 1)`:

**For x = 2**:
- Alice takes `13` stones.
- Bob can get up to `helper(piles, suffixSum, cache, 4, 2)` which is `4`.

Combine results for `helper(piles, suffixSum, cache, 2, 1)`:
- `max(17 - 8, 17 - 4) = 9`

Back to the second call: `helper(piles, suffixSum, cache, 1, 1)`:

**For x = 1**:
- Bob takes `7` stones.
- Alice can get up to `9`.

**For x = 2**:
- Bob takes `16` stones.
- Alice can get up to `8`.

Combine results for `helper(piles, suffixSum, cache, 1, 1)`:
- `max(24 - 9, 24 - 8) = 15`

Back to the first call: `helper(piles, suffixSum, cache, 0, 1)`:

**For x = 1**:
- Alice takes `2` stones.
- Bob can get up to `15`.

**For x = 2**:
- Alice takes `9` stones.
- Bob can get up to `17`.

Combine results for `helper(piles, suffixSum, cache, 0, 1)`:
- `max(26 - 15, 26 - 17) = 11`

### Final Result
Alice can collect a maximum of `11` stones if both play optimally.

### Visualization

```
Piles: [2, 7, 9, 4, 4]

Initial Call: helper(0, 1)

  ├── Move 1: Take 1 pile (2 stones)
  │   └── helper(1, 1)
  │        ├── Move 1: Take 1 pile (7 stones)
  │        │   └── helper(2, 1)
  │        │        ├── Move 1: Take 1 pile (9 stones)
  │        │        │   └── helper(3, 1) -> 8 (remaining piles: [4, 4])
  │        │        └── Move 2: Take 2 piles (13 stones)
  │        │            └── helper(4, 2) -> 4 (remaining pile: [4])
  │        └── Move 2: Take 2 piles (16 stones)
  │            └── helper(3, 2) -> 8 (remaining piles: [4, 4])
  └── Move 2: Take 2 piles (9 stones)
      └── helper(2, 2) -> 17 (remaining piles: [9, 4, 4])
```

Alice will choose the optimal moves based on minimizing Bob's gain and maximizing her own gain, leading to the final result of collecting `11` stones.

Piles: [2, 7, 9, 4, 4]

Initial Call: helper(0, 1)

  ├── Move 1: Take 1 pile (2 stones)
  │   └── helper(1, 1)
  │        ├── Move 1: Take 1 pile (7 stones)
  │        │   └── helper(2, 1)
  │        │        ├── Move 1: Take 1 pile (9 stones)
  │        │        │   └── helper(3, 1) -> 8 (remaining piles: [4, 4])
  │        │        └── Move 2: Take 2 piles (13 stones)
  │        │            └── helper(4, 2) -> 4 (remaining pile: [4])
  │        └── Move 2: Take 2 piles (16 stones)
  │            └── helper(3, 2) -> 8 (remaining piles: [4, 4])
  └── Move 2: Take 2 piles (9 stones)
      └── helper(2, 2) -> 17 (remaining piles: [9, 4, 4])

Alice will choose the optimal moves based on minimizing Bob's gain and maximizing her own gain, leading to the final result of collecting 11 stones.

 */