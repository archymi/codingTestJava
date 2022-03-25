package com.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42576
public class Test_220325_01 {

    private static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> participantMap = new HashMap<>();
        Arrays.stream(participant).forEach(p -> {
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        });
        for (String completeMan : completion) {
            if (participantMap.containsKey(completeMan)) {
                participantMap.put(completeMan, participantMap.get(completeMan) - 1);
            }
        }
        for (String man : participantMap.keySet()) {
            if (participantMap.get(man) > 0) {
                answer = man;
                break;
            }
        }

        return answer;
    }

    @Test
    public void Test01() {
        Assertions.assertThat(solution(new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"})).isEqualTo("leo");
        Assertions.assertThat(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"})).isEqualTo("vinko");
        Assertions.assertThat(solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"})).isEqualTo("mislav");
    }
}
