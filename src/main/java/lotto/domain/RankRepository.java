package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankRepository {
    private static final List<Rank> ranks = new ArrayList<>();

    public static void addRank(Rank rank) {
        ranks.add(rank);
    }

    public static List<Rank> ranks() {
        return Collections.unmodifiableList(ranks);
    }

    public static Map<Rank, Integer> createWinningResult() {
        Map<Rank, Integer> winningResult = Arrays.stream(Rank.values())
                .filter(Rank::isNotNone)
                .collect(Collectors.toMap(rank -> rank, RankRepository::count));
        return Collections.unmodifiableMap(new EnumMap<>(winningResult));
    }

    private static int count(Rank target) {
        return (int) ranks.stream()
                .filter(target::is)
                .count();
    }
}
