package com.test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1059
public class Test_220510_01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> collect = Arrays.stream(br.readLine().split(" "))
                                .map(Integer::parseInt)
                                .sorted()
                                .collect(Collectors.toList());
        collect.add(1001);
        collect.add(0, 0);
        int lastNum = Integer.parseInt(br.readLine());
        int index = -1;
        if (collect.size() >= 1) {
            for (int i = 0; i < collect.size() - 1; i++) {
                if (lastNum > collect.get(i) && lastNum < collect.get(i + 1)) {
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.println("0");
            return;
        }

        int count = 0;
        for (int i = collect.get(index) + 1; i < collect.get(index+1); i++) {
            for (int j = i + 1; j < collect.get(index+1); j++) {
                if (lastNum >= i && lastNum <= j) count++;
            }
        }
        System.out.println(count);
    }
}
