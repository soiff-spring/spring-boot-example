package xyz.cloorc.example.springboot;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import xyz.cloorc.example.springboot.po.Example;
import xyz.cloorc.example.springboot.service.ServiceExample;

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
        Example e = new Example();
        e.setId(1l);
        e.setName("foo");
        e.setAge(1);
        final boolean result = example.insert(e);
        System.out.println(result);
        e = example.select(1l);
        System.out.println(e.toString());
    }
    
    @Bean
    @ConditionalOnMissingBean
    public final SqlSessionFactory getSqlSessionFactory() throws Exception {
    	final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    	bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
    	return bean.getObject();
    }
}
