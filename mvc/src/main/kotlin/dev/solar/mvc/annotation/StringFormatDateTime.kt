package dev.solar.mvc.annotation

import dev.solar.mvc.validator.StringFormatDateTimeValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [StringFormatDateTimeValidator::class])// 검증에 사용할 Validator 지정
@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
) //어노테이션 선언 가능한 위치 지정
@Retention(AnnotationRetention.RUNTIME) //런타임시에만 사용
@MustBeDocumented
annotation class StringFormatDateTime (
    val pattern: String = "yyyy-MM-dd HH:mm:ss",
    val message: String = "시간 형식이 유효하지 않습니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
