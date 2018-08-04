package online.zhaopei.webfluxdemo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class TimeHandler {

    public Mono<ServerResponse> getTime(ServerRequest request) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Now is " +
            new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);
    }

    public Mono<ServerResponse> getDate(ServerRequest request) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Today is " +
            new SimpleDateFormat("yyyy-MM-dd").format(new Date())), String.class);
    }

    /**
     * 每秒发送一次时间,content-type: text/event-stream 也就是SSE
     * @param serverRequest
     * @return
     */
    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(  // 1
                Flux.interval(Duration.ofSeconds(1)).   // 2
                        map(l -> new SimpleDateFormat("HH:mm:ss").format(new Date())),
                String.class);
    }
}
