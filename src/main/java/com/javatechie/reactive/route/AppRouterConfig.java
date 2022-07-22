package com.javatechie.reactive.route;

import com.javatechie.reactive.handler.BookHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AppRouterConfig {

    @Autowired
    private BookHandler bookHandler;

    @Bean
    public WebProperties.Resources resources(){
        return new WebProperties.Resources();
    }


    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/route/books", bookHandler::getBooks)
                .GET("/route/book/{bookId}",bookHandler::getBookById)
                .build();
    }
}
