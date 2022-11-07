package com.lannstark.lec15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lec15Main {

  public static void main(String[] args) {
    // 배열
    int[] array = {100, 200};

    for (int i = 0; i < array.length; i++) {
      System.out.printf("%s %s", i, array[i]);
    }

    // 컬렉션
    //1. List
    final List<Integer> numbers = Arrays.asList(100, 200);

    // 하나를 가져오기
    System.out.println(numbers.get(0));

    // For Each
    for(int number : numbers) {
      System.out.println(number);
    }

    // 전통적인 For문
    for (int i = 0; i < numbers.size(); i++) {
      System.out.printf("%s %s", i, numbers.get(i));
    }

    //3. Map
    //(1) JDK 8 까지
    final HashMap<Integer, String> map = new HashMap<>();
    map.put(1, "MONDAY");
    map.put(2, "TUESDAY");

    //(2) JDK 9 부터
    Map.of(1, "MONDAY", 2, "TUESDAY");

    // Map 활용
    for (int key : map.keySet()) { //(1) key를 가져와서 접근
      System.out.println(key);
      System.out.println(map.get(key));
    }

    for (Map.Entry<Integer, String> entry : map.entrySet()) { //Entry라는 key와 value가 들어있는 객체를 활용
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }
  }

}
