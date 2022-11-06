package com.lannstark.lec08;

public class Lec08Main {

    public static void main(String[] args) {
        //4. 가변인자 활용할 때는
        // (1) 배열을 직접 넣거나
        // (2) comma를 이용해 여러 파라미터를 넣으면 된다.
        final String[] array = { "A", "B", "C" };
        printAll(array);
        printAll("ha", "hi", "ho");
    }

    //1. 함수 선언 문법
    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    //2. default parameter
    //자바는 OverLoading을 이용해서 기본값을 사용한다.
    public static void repeatJava(String str, int num, boolean useNewLine) {
        for (int i = 1; i < num; i++) {
            if (useNewLine) {
                System.out.println(str);
            } else {
                System.out.print(str);
            }
        }
    }

    public void repeatJava(String str, int num) {
        repeatJava(str, num, true);
    }

    public void repeatJava(String str) {
        repeatJava(str, 3, true);
    }

    //4. 같은 타입의 여러 파라미터 받기 (가변인자)
    //문자열을 N개 받아 출력하는 예제
    public static void printAll(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }

}
