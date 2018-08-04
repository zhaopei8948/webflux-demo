package online.zhaopei.webfluxdemo.reposity;

import online.zhaopei.webfluxdemo.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

}
