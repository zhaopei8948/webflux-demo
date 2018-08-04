package online.zhaopei.webfluxdemo.handler;

import online.zhaopei.webfluxdemo.UserService;
import online.zhaopei.webfluxdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> save(ServerRequest request) {
        User user = null;
        return ok().contentType(MediaType.APPLICATION_JSON).body(this.userService.save(user), User.class);
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON).body(this.userService.findAll(), User.class);
    }
}
