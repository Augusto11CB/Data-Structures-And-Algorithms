# Trie operations

The basic operations all follow characters from the root. Each takes `O(L)` time for an input of length `L`.

## Insert

```text
insert(word):
    node = root
    for character in word:
        node = node.children.getOrCreate(character)
    node.isTerminal = true
```

## Search for a complete word

```text
search(word):
    node = follow(word)
    return node exists and node.isTerminal
```

Checking the terminal marker matters: if `car` was inserted, searching for `ca` must return false even though that prefix exists.

## Check a prefix

```text
startsWith(prefix):
    return follow(prefix) exists
```

## Delete

Deletion first verifies that the whole word exists, then clears its terminal marker. A node can be pruned only when it is no longer terminal and has no children; otherwise it is still needed by another word sharing the prefix.

```text
delete(node, word, index):
    if index equals word.length:
        clear node.isTerminal
    else:
        recurse into the child for word[index]
        prune that child only if it became non-terminal and childless
```

The space used by a trie is proportional to the number of stored nodes. In the worst case, that is the sum of all word lengths; prefix sharing reduces it in practice.
