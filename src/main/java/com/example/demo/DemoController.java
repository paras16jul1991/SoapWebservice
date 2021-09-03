package com.example.demo;

import com.example.demo.model.Article;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @GetMapping("/article")
    public String call() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        ArticleClient articleClient = annotationConfigApplicationContext.getBean(ArticleClient.class);
        return articleClient.getArticle(1).getArticle().getName();
    }
}
