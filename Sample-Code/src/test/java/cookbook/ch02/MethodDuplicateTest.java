package cookbook.ch02;

import static cookbook.ch02.MethodDuplicateKt.addProduct;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class MethodDuplicateTest {
    /**
     * @JvmOverloads 애노테이션을 addProduct 함수에 추가하면 (컴파일 후 생성된 클래스는) 모든 함수 중복을 지원한다.
     */
    @Test
    void checkOverloads() {
        assertAll("overloads called from Java",
                  () -> System.out.println(addProduct("Solar", 5.0, "Desc")),
                  () -> System.out.println(addProduct("Solar", 5.0)),
                  () -> System.out.println(addProduct("Solar"))
        );
    }
}
