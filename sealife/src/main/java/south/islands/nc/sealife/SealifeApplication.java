package south.islands.nc.sealife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SealifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SealifeApplication.class, args);
	}

}
