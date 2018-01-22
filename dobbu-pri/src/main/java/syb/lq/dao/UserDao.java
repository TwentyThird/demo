package syb.lq.dao;

import org.apache.ibatis.annotations.Param;
import syb.lq.model.Tree;
import syb.lq.model.UserInfo;

import java.util.List;

public interface UserDao {


    public List<UserInfo> selectuser(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    List<Tree> findTree(@Param("id") Integer id);
}
