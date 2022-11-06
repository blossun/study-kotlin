package com.lannstark.lec11

class Car(
    internal val name: String, //name에 대한 getter를 internal로
    private var owner: String, //owner에 대한 getter, setter를 private으로
    _price: Int
) {
    var price = _price //var 앞에 생략된 기본값이 public 이기 때문에 getter는 그대로 public이다.
        private set //price의 setter만 private으로
}
