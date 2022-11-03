package dev.solar.todo.config

import dev.solar.todo.database.TodoDataBase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

// 어플리케이션이 구동될 때 참조해서 만들 빈 설정을 정의하고 빈을 만든다.
@Configuration
class AppConfig {

    // TodoDataBase를 빈으로 등록
    @Bean(initMethod = "init") //initMethod : 빈을 생성할 떄 참조할 메서드명을 지정 //객체가 만들어지고 init메소드가 실행된다.
    fun todoDataBase(): TodoDataBase {
        return TodoDataBase()
    }
}
