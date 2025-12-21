package api.trade.magic.magic_trade_api;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MagicTradeApiApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MagicTradeApiApplication.class);
		builder.bannerMode(Banner.Mode.OFF);

		ConfigurableApplicationContext appContext = builder.context();

		builder.run(args);
	}
}
