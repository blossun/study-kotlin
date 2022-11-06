package com.lannstark.lec03;

public class Lec03Main {

  public static void main(String[] args) {
    //자바에서 문자열의 특정 index의 문자 가져오기
    String str = "ABCDE";
    System.out.println("2번쨰 문자 : " + str.charAt(2));
  }

  public static void printAgeIfPerson(Object obj) {
    if (obj instanceof Person) {
      Person person = (Person) obj;
      System.out.println(person.getAge());
    }
  }

}
