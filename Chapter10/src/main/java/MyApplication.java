import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author yuanbao
 */
@SpringBootApplication
@ComponentScan("com.course.server")
public class MyApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyApplication.class,args);

    }

}
