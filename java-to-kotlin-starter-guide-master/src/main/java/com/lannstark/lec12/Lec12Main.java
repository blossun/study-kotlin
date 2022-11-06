package com.lannstark.lec12;

import com.lannstark.lec12.kotlin.Person;

public class Lec12Main {

  public static void main(String[] args) {
    //Java에서 Kotlin companion object를 사용하려면 3가지 방법이 있다.
    // 1. companion object에 이름이 없는 경우 - Companion을 직접 명시
//    Person.Companion.newBaby("Solar");
    // 2.  companion object에 이름이 없는 경우 - companion object에 @JvmStatic 을 붙여준다.
    Person.newBaby("Solar");
    // 3. companion object에 이름이 있는 경우
    Person.Factory.newBaby("Solar");
  }
}
