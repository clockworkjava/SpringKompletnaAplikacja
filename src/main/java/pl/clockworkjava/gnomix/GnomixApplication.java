package pl.clockworkjava.gnomix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public final class GnomixApplication {

    private GnomixApplication() { }

    public static void main(String[] args) {
       SpringApplication.run(GnomixApplication.class, args);
    }

}
