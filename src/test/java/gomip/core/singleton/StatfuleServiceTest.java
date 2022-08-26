package gomip.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatfuleServiceTest {
    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatfuleService service1 = ac.getBean(StatfuleService.class);
        StatfuleService service2 = ac.getBean(StatfuleService.class);

        int userAPrice = service1.order("userA", 1000);
        int userBPrice = service2.order("userB", 2000);

//        int price = service1.getPrice();
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(service1.getPrice()).isEqualTo(2000);
    }

    static class TestConfig {
        @Bean
        public StatfuleService statfuleService(){
            return new StatfuleService();
        }
    }
}