package syb.lq.action;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import syb.lq.model.Tree;
import syb.lq.model.UserInfo;
import syb.lq.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;




    @RequestMapping("selectuser")
    @ResponseBody
    public String selectuser(Integer start, Integer pageSize){
        List<UserInfo> list = userService.selectuser(start,pageSize);
        JSONObject json=new JSONObject();
        json.put("rows", list);
        return json.toString();
    }

    @RequestMapping("findTree")
    @ResponseBody
    public  List<Tree>  findTree(){
        List<Tree> list=userService.findTree(0);


        List<Tree> parentTree = parentTree(list);
        return parentTree;
    }


    public  List<Tree> parentTree(List<Tree> list){
        List<Tree>  childList=new ArrayList<Tree>();
        for (int i = 0; i < list.size(); i++) {
            Tree menus = list.get(i);

            List<Tree> findTree = userService.findTree(menus.getId());
            //  判断他有没有子节点
            if(findTree.size()>0){   //  true
                //  当前 子节点的集合
                List<Tree> getchirdMenu = getchirdMenu(findTree);
                //  将子节点 数据装进  list
                menus.setNodes(getchirdMenu);
                childList.add(menus);
            }else{
                childList.add(menus);
            }
        }

        return  childList;
    }


    public  List<Tree> getchirdMenu(List<Tree> list){
        List<Tree>  childList=new ArrayList<Tree>();
        for (int i = 0; i < list.size(); i++) {
            Tree menus = list.get(i);
            List<Tree> findTree = userService.findTree(menus.getId());

            //  判断他有没有子节点
            if(findTree.size()>0){
                List<Tree> getchirdMenu = getchirdMenu(findTree);
                //  将子节点 数据装进  list
                menus.setNodes(getchirdMenu);
                childList.add(menus);
            }else{

                childList.add(menus);
            }
        }

        return   childList;
    };

}
