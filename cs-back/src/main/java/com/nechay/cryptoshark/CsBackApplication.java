package com.nechay.cryptoshark;

import com.nechay.cryptoshark.app.CsBackBeansConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author anechaev
 * @since 27.08.2023
 */
@SpringBootApplication
@EnableScheduling
@Import(CsBackBeansConfiguration.class)
public class CsBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsBackApplication.class, args);
    }
}
