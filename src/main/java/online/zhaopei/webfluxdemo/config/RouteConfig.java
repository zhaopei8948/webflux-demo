package online.zhaopei.webfluxdemo.config;

import online.zhaopei.webfluxdemo.handler.TimeHandler;
import online.zhaopei.webfluxdemo.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouteConfig {

    @Autowired
    private TimeHandler timeHandler;

    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> timeRouter() {
        return route(GET("/time"), req -> timeHandler.getTime(req))
                // 另一种路由写法
                .andRoute(GET("/date"), timeHandler::getDate)
                // 每秒发一次时间
                .andRoute(GET("/times"), timeHandler::sendTimePerSec);
    }

    @Bean
    public RouterFunction<ServerResponse> userRouter() {
        return route(GET("/users"), userHandler::findAll);
    }
}
