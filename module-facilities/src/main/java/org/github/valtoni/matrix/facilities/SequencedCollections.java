package org.github.valtoni.matrix.facilities;

import java.util.*;

public class SequencedCollections {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Map<String, SequencedCollection<Integer>> sequencedCollections = new HashMap<>();
        sequencedCollections.put("List", list);
        sequencedCollections.put("Deque", new ArrayDeque<>(list));
        sequencedCollections.put("SortedSet", new TreeSet<>(list));
        sequencedCollections.put("Set", new LinkedHashSet<>(list));

        sequencedCollections.forEach((structure, sequencedCollection) -> {
            System.out.format("%s: First %d, Last %d\n", structure, sequencedCollection.getFirst(), sequencedCollection.getLast());
        });

    }

}
