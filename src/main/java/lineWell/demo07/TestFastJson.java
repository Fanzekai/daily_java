package lineWell.demo07;

/**
 * @author fzk aaaa
 * @version 1.0
 * @date 2024/12/17  18:35
 */
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;

import java.util.Date;

public class TestFastJson {
    public static void main(String[] args) {
        // JSON 数据
        String jsonString = "{ \"transactTime\": \"2022-07-02 10:00:00\" }";

        // 转换为 JSON 对象
        JSONObject jsonBody = JSON.parseObject(jsonString);

        // 反序列化到实体类
        GovserviceCodeAcceptPO codeAcceptPO = jsonBody.toJavaObject(GovserviceCodeAcceptPO.class);

        // 打印结果
        System.out.println("Transact Time: " + codeAcceptPO.getTransactTime());
    }
}

class GovserviceCodeAcceptPO {
    /**
     * 办结日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date transactTime;

    public Date getTransactTime() {
        return transactTime;
    }

    public void setTransactTime(Date transactTime) {
        this.transactTime = transactTime;
    }
}
