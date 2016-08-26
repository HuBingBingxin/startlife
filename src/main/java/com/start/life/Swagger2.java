package com.start.life;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Configuration
public class Swagger2 {

  /*@Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .enableUrlTemplating(false).apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage(""))
        .paths(PathSelectors.any()).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Dev-LifeStart-backend RESTful APIs")
        .description("LifeStart后台开发团队，供前端同学和测试同学访问的API文档接口")
        .termsOfServiceUrl("http://life.start.com/api/v1")// http://xxx.com/
        .version("1.0.0").build();
  }*/

  @Bean
  public Docket testApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("www.lifestart.com/test")
            //.genericModelSubstitutes(DeferredResult.class)
//                .genericModelSubstitutes(ResponseEntity.class)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(true)
            .pathMapping("/")
            //.pathMapping("/lifestart/test/api/v1")// base，最终调用接口后会和paths拼接在一起
            .select()
            //.paths(or(regex("/api/.*")))//过滤的接口
            .build()
            .apiInfo(testApiInfo());
  }

  @Bean
  public Docket demoApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("www.lifestart.com/demo")
            //.genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
            .useDefaultResponseMessages(false)
            .forCodeGeneration(false)
            //.pathMapping("/lifestart/demo/api/v1")
            .pathMapping("/")
            .select()
            //.paths(or(regex("/demo/.*")))//过滤的接口
            .build()
            .apiInfo(demoApiInfo());
  }

  private ApiInfo testApiInfo() {
    return new ApiInfoBuilder()
        .title("Test-LifeStart-backend RESTful APIs 测试环境")
        .description("LifeStart后台开发团队，供前端同学和测试同学访问的API文档接口")
        .termsOfServiceUrl("http://life.start.com/api/v1")// http://xxx.com/
        .version("1.0.0").build();
  }

  private ApiInfo demoApiInfo() {
    return new ApiInfoBuilder()
        .title("Demo-LifeStart-backend RESTful APIs 正式环境")
        .description("LifeStart后台开发团队，供前端同学和测试同学访问的API文档接口")
        .termsOfServiceUrl("http://life.start.com/api/v1")// http://xxx.com/
        .version("1.0.0").build();
  }
}
