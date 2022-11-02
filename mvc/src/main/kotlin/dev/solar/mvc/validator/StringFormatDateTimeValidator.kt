package dev.solar.mvc.validator

import dev.solar.mvc.annotation.StringFormatDateTime
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class StringFormatDateTimeValidator: ConstraintValidator<StringFormatDateTime, String> {

    private var pattern: String? = null

    override fun initialize(constraintAnnotation: StringFormatDateTime?) {
        this.pattern = constraintAnnotation?.pattern //어노테이션에 정의한 패턴을 담아준다.
    }

    // 정상이면 true, 비정상이면 false
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return try {
            LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern))
            true
        } catch (e: Exception) {
            false
        }

    }
}

/**
 * Validator 구현
 * ConstraintValidator를 상속받아서 구현해야 한다.
 * <커스텀하게 만든 Validation 어노테이션, 입력받을 데이터 타입>
 * isValid() 메소드를 이용해서 검증하게 된다.
 *
 */
