package syb.lq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import syb.lq.dao.UserDao;
import syb.lq.model.Tree;
import syb.lq.model.UserInfo;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public List<UserInfo> selectuser(Integer start, Integer pageSize) {
        return userDao.selectuser(start,pageSize);
    }

    @Override
    public List<Tree> findTree(Integer id) {
        return userDao.findTree(id);
    }

}
