import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Text03 {

    public static void main(String[] args) {

        String weather = "{\"HeWeather6\":[{\"basic\":{\"cid\":\"CN101010100\",\"location\":\"北京\",\"parent_city\":\"北京\"},\"daily_forecast\":[{\"cond_code_d\":\"103\",\"cond_code_n\":\"101\",\"cond_txt_d\":\"晴间多云\"},{\"cond_code_d\":\"101\",\"cond_code_n\":\"501\",\"cond_txt_d\":\"多云\",\"cond_txt_n\":\"雾\"},{\"cond_code_d\":\"101\",\"cond_code_n\":\"101\",\"cond_txt_d\":\"多云\"}],\"status\":\"ok\",\"update\":{\"loc\":\"2017-10-26 23:09\",\"utc\":\"2017-10-26 15:09\"}}]}";
        JSONObject object = JSONObject.parseObject(weather);
        System.out.println(object);
        System.out.println("=============================================");

        List<Object> list1 = (List<Object>) object.get("HeWeather6");
        Map<String, Object> map6 = (Map<String, Object>) list1.get(0);
        Map<String, Object> map7 = (Map<String, Object>) map6.get("basic");
        map7.get("cid");
        System.out.println( map7.get("cid"));
        System.out.println("=============================================");

        //  java 转  Json
        Map<String, String> map4 = new HashMap<>();
        map4.put("cid", "CN101010100");
        map4.put("location", "北京");
        map4.put("parent_city", "北京");

        Map<String,String> basic1 = new HashMap<>();
        basic1.put("cid","CN101010100");
        basic1.put("location","北京");
        basic1.put("parent_city","北京");

        Map<String,String> map1 = new HashMap<>();
        map1.put("cond_code_d", "103");
        map1.put("cond_code_n", "101");
        map1.put("cond_txt_d", "晴间多云");

        Map<String,String> map2 = new HashMap<>();
        map2.put("cond_code_d","101");
        map2.put("cond_code_n","501");
        map2.put("cond_txt_d","多云");

        Map<String,String> map3 = new HashMap<>();
        map3.put("cond_code_d", "101");
        map3.put("cond_code_n","101");
        map3.put("cond_txt_d","多云");

        List<Map<String,String>> daily_forecast1 = new ArrayList<>();
        daily_forecast1.add(map1);
        daily_forecast1.add(map2);
        daily_forecast1.add(map3);

        Map<String,String> map5 = new HashMap<>();
        map5.put("loc","2017-10-26 23:09");
        map5.put("utc","2017-10-26 15:09");

        Map<String, Object> HeWeather61 = new HashMap<>();
        HeWeather61.put("basic", map4);
        HeWeather61.put("daily_forecast", daily_forecast1);
        HeWeather61.put("status", "ok");

        List<Object> list = new ArrayList<>();
        list.add(HeWeather61);

        Map<String, Object> map = new HashMap<>();
        map.put("HeWeather6", list);

        String str = JSONObject.toJSONString(map);
        System.out.println(str);

        //转   java
        List<Object> list2 = (List<Object>) object.get("HeWeather6");
        System.out.println(list2.get(0));


      /*  TextThree three = (TextThree) list2.get(0);
        Map<String,String> map8 = three.getUpdate();
        System.out.println(map8.get("loc"));*/

    }
}


@Data
class TextThree{

    private Map<String, String> basic;

    private List<Map<String, String>> daily_forecast;

    private String status;

    private Map<String, String> update;

}
