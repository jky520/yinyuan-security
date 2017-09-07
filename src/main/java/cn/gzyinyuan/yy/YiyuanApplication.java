package cn.gzyinyuan.yy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 快速查找替换：ctrl+shift+r
 */
@SpringBootApplication
public class YiyuanApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(YiyuanApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YiyuanApplication.class);
	}
}
