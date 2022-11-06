package com.lannstark.lec02;

public class Lec02Main {

  public static void main(String[] args) {

  }

  //자바에서 null을 처리하는 3가지 방법
  //1. null이면 exception 발생
  public boolean startsWithA1(String str) {
    if (str == null) {
      throw new IllegalArgumentException("null이 들어왔습니다");
    }
    return str.startsWith("A");
  }


  //2. null이면 null반환. 반환 타입은 null이 가능한 reference타입
  public Boolean startsWithA2(String str) {
    if (str == null) {
      return null;
    }
    return str.startsWith("A");
  }


  //3. null이면 false를 반환
  public boolean startsWithA3(String str) {
    if (str == null) {
      return false;
    }
    return str.startsWith("A");
  }

}
