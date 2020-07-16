import com.alibaba.fastjson.JSONObject;

public class Demo01 {

    public static void main(String[] args) {

        String weather = "{\"HeWeather6\":[{\"basic\":{\"cid\":\"CN101010100\",\"location\":\"北京\",\"parent_city\":\"北京\"},\"daily_forecast\":[{\"cond_code_d\":\"103\",\"cond_code_n\":\"101\",\"cond_txt_d\":\"晴间多云\"},{\"cond_code_d\":\"101\",\"cond_code_n\":\"501\",\"cond_txt_d\":\"多云\",\"cond_txt_n\":\"雾\"},{\"cond_code_d\":\"101\",\"cond_code_n\":\"101\",\"cond_txt_d\":\"多云\"}],\"status\":\"ok\",\"update\":{\"loc\":\"2017-10-26 23:09\",\"utc\":\"2017-10-26 15:09\"}}]}";

        // String   --》  JSONObject
        JSONObject object = JSONObject.parseObject(weather);
        System.out.println(object);

    }
}
