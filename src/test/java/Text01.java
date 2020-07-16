import com.alibaba.fastjson.JSONObject;
import com.dj.ssm.pojo.ResultModel;
import lombok.Data;

import java.util.Map;

public class Text01 {

    public static void main(String[] args) {
       String str = "{\"code\":200,\"msg\":\"success\",\"data\":{\"id\":1,\"userName\":\"zs\",\"userPwd\":\"113\",\"userAge\":12,\"userSex\":2,\"userNumberId\":\"12\",\"createTime\":null,\"updateTime\":null}}";

        JSONObject obj = JSONObject.parseObject(str);
        System.out.println("Json对象格式字符串   转   json对象");
        System.out.println(obj);
        System.out.println(obj.get("msg")+"--"+obj.get("code")+"--"+obj.get("data"));
        JSONObject obj1 = (JSONObject) obj.get("data");
        System.out.println(obj1.get("userSex")+"--"+obj1.get("userName"));

        System.out.println("-----------------------------------------------------------");

        ResultModel result = JSONObject.parseObject(str, ResultModel.class);
        System.out.println(result.getMsg()+"--"+result.getCode()+"--"+result.getData());
        JSONObject obj2 = (JSONObject) result.getData();
        System.out.println(obj2.get("userSex"));

        System.out.println("-----------------------------------------------------------");

        TextOne one = JSONObject.parseObject(str, TextOne.class);
        System.out.println(result.getMsg()+"--"+result.getCode()+"--"+result.getData());
        Map<String,Object> map = (Map<String, Object>) result.getData();
        map.get("userSex");
        map.get("userNumberId");
        map.get("userName");
        System.out.println( map.get("userSex")+"--"+map.get("userNumberId")+"--"+map.get("userName"));


    }
}


@Data
class TextOne{
 private String msg;

 private Integer code;

 private Map<String,Object> data;
}