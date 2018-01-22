package syb.lq.service;

import syb.lq.model.Tree;
import syb.lq.model.UserInfo;

import java.util.List;

public interface UserService{

    public List<UserInfo> selectuser(Integer start, Integer pageSize);

    List<Tree> findTree(Integer id);
}
