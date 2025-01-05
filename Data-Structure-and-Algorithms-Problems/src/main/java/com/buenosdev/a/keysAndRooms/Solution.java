package com.buenosdev.a.keysAndRooms;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

class Solution {
    //  [[1],[2],[3],[]]

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seenRoom = new boolean[rooms.size()];
        var stackOfKeys = new ArrayDeque<Integer>();
        stackOfKeys.push(0);
        seenRoom[0] = true;

        while (!stackOfKeys.isEmpty()) {
            int node = stackOfKeys.pop();
            for (int key : rooms.get(node)) // For every key in room # 'node'...
                if (!seenRoom[key]) { // ...that hasn't been used yet
                    seenRoom[key] = true; // mark that we've entered the room
                    stackOfKeys.push(key); // add the key to the stack
                }
        }

        for (boolean v : seenRoom)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }

    public boolean canVisitAllRoomsII(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) return true;
        var visited = new HashSet<Integer>();
        var keys = new TreeSet<Integer>();

        visited.add(0);
        keys.addAll(rooms.get(0));
        while (!keys.isEmpty()) {
            var roomNextKey = keys.pollFirst();
            if (!visited.contains(roomNextKey)) continue;
            keys.addAll(rooms.get(roomNextKey));
            visited.add(roomNextKey);
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (!visited.contains(i)) return false;
        }
        return true;
    }
}