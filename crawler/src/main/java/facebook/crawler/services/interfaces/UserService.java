package facebook.crawler.services.interfaces;

import facebook.crawler.domain.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User find(Integer id);

    List<User> findAll();

    User update(User user);

    void delete(User user);
}
