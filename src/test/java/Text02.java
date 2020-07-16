import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text02 {


    public static void main(String[] args) {

        String str="{name:'李俊',age:25,address:{description:'北京 回龙观 新龙城',floor:10},like:['唱歌','画画','旅游']}";

        JSONObject object = JSONObject.parseObject(str);
        System.out.println(object);

        TextTwo two = object.toJavaObject(TextTwo.class);
        System.out.println(two.getName()+"--"+two.getAge());
        Map<String,Object> address = two.getAddress();
        System.out.println( address.get("description")+"---"+address.get("floor"));
        List<String> like = two.getLike();
        for (String li : like){
            System.out.println(li);
        }
        /*System.out.println(two.);*/


        System.out.println("============================");
        Map<String,Object> address1 = new HashMap<>();
        address1.put("description","北京 回龙观 新龙城");
        address1.put("floor",10);

        List<String> like1 = new ArrayList<>();
        like1.add("唱歌");
        like1.add("画画");
        like1.add("旅游");

        Map<String,Object> map =new HashMap<>();
        map.put("name","李俊");
        map.put("age",25);
        map.put("like",like1);
        map.put("address",address1);;

        String object1 = JSONObject.toJSONString(map);

        System.out.println(object1);

    }
}

@Data
class TextTwo{
    private String name;

    private Integer age;

    private Map<String, Object> address;

    private List<String> like;
}