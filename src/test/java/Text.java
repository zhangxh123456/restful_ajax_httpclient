import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dj.ssm.pojo.User;
import lombok.Data;
import lombok.var;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


public class Text {

    public static void main(String[] args) {

        // Json对象格式字符串
        String strObject = "{'userName':'zs','userPwd':'123456','userNumber':'12'}";

        // Json对象格式字符串   转   json对象
        JSONObject obj = JSONObject.parseObject(strObject);
        System.out.println("Json对象格式字符串   转   json对象");
        System.out.println(obj);


        //Json对象格式字符串   转   java对象
        User user = JSONObject.parseObject(strObject, User.class);
        System.out.println("Json对象格式字符串   转   java对象");
        System.out.println(user.getUserName()+"--"+user.getUserPwd()+"--"+user.getUserNumber());




        // Json数组格式字符串
        String strArray = "[{'userName':'zs','userPwd':'123456','userNumber':'12'},{'userName':'zs','userNumber':'12'},{'userPwd':'123456','userNumber':'12'}]";

        // Json数组格式字符串   转   json数组
        JSONArray arr = JSONArray.parseArray(strArray);
        System.out.println("Json数组格式字符串   转   json数组");
        System.out.println(arr);

        // Json数组格式字符串   转   java对象数组
        List<User> list = JSONArray.parseArray(strArray, User.class);
        System.out.println("Json数组格式字符串   转   java对象数组");
        for(User li :list){
            System.out.println(li.getUserName()+"--"+li.getUserPwd()+"--"+li.getUserNumber());
        }



    }



}

