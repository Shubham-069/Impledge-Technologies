# Impledge-Technologies

Word Composition Problem - Recursive Memoization Approach
Approach Explanation
1. Problem Understanding
We need to find the longest and second longest compounded words from a given sorted list of words.
A compounded word is a word that can be formed by concatenating other words from the list.
Performance is critical since Input_02.txt contains 100,000+ words.
2. Recursive Memoization Approach
We use recursion to check if a word can be formed from other words and memoization (HashMap) to store already computed results, reducing redundant calculations.

Step-by-Step Implementation
1️⃣ Read words from file and store them in a List (words) and a Set (wordSet) for fast lookups (O(1)).
2️⃣ Sort words by length to ensure smaller words are processed first, making compound word checking more efficient.
3️⃣ Iterate through each word and use the canBeFormed() function to check if it is a compounded word.
4️⃣ canBeFormed() function (Recursive with Memoization):

Try splitting the word into a prefix and suffix at every index.
If the prefix exists in the set and the suffix is either in the set or can be formed recursively, mark it as a compounded word.
Store results in a memoization map (Map<String, Boolean> memo) to avoid redundant recursive calls.
5️⃣ Track the longest and second-longest compounded words during iteration.
6️⃣ Calculate time taken and display results.


