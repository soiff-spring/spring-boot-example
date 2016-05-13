package xyz.cloorc.example.springboot;

import java.util.List;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import xyz.cloorc.example.springboot.po.Example;
import xyz.cloorc.example.springboot.service.ServiceExample;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
public class StartupApplication implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(StartupApplication.class, args);
    }

    @Autowired
    ServiceExample example;
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");
        Example e = new Example(Long.valueOf(1),"foo", 1);
        final boolean result = example.insert(e);
        System.out.println(result);
        List<Example> examples = example.select();
        System.out.println(examples.get(0));
        System.out.println(example.select(1l));
    }
    
    @Autowired
    @Bean
    @ConditionalOnMissingBean
    public static SqlSessionFactory getSqlSessionFactory(DataSource source, @Value("${logback.password}") String password) throws Exception {
        log.info("password = " + password);
    	final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    	bean.setDataSource(source);
    	bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
    	return bean.getObject();
    }
}
