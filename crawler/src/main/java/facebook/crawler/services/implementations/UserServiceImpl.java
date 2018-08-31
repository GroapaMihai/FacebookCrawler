package facebook.crawler.services.implementations;

import facebook.crawler.domain.User;
import facebook.crawler.repositories.UserRepository;
import facebook.crawler.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public User find(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }
}
