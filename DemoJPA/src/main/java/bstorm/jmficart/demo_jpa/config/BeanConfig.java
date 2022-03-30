package bstorm.jmficart.demo_jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Scanner;

@Configuration
public class BeanConfig {
    @Bean
    public Scanner sc(){
        return new Scanner(System.in);
    }

//    @Bean
//    public Boite<String> boite(){
//        return new Boite<>();
//    }
//
//    @Bean
//    public Predicate<Integer> isEven(){
//        return integer -> integer % 2 == 0;
//    }
}
