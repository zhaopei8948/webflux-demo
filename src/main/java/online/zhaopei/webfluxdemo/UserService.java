package online.zhaopei.webfluxdemo;

import online.zhaopei.webfluxdemo.domain.User;
import online.zhaopei.webfluxdemo.reposity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Mono<User> save(User user) {
        return this.userRepository.save(user);
    }

    public Flux<User> findAll() {
        return this.userRepository.findAll();
    }
}
