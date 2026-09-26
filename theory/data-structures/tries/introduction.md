# Trie introduction

A trie is a rooted tree for strings. Each edge represents a character, and the path from the root spells a prefix. A terminal marker tells us whether a path represents a complete stored word rather than only a prefix.

For example, storing `car`, `cat`, and `care` creates one shared path for `ca`; the branches only diverge where the strings differ.

## When a trie fits

- Autocomplete and search suggestions
- Prefix queries such as “does any stored word start with this text?”
- Dictionary and spell-checking features
- Word-break, word-search, and string segmentation problems

The cost of searching, inserting, or checking a prefix is `O(L)`, where `L` is the input string's length. This is independent of the number of stored words, although the trie may consume significant memory when prefixes are not shared.

## Key properties

- The root represents the empty prefix.
- A node represents the prefix formed by the path from the root to that node.
- A terminal flag distinguishes `car` from a prefix such as `ca`.
- Nodes can store extra metadata, such as word frequency or the best suggestion below that prefix.

Tries are not restricted to lowercase English letters. The alphabet and the representation determine how arbitrary characters are handled.
