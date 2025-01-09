package demo17;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/9/18  14:45
 */
public class test {

    public static void main(String[] args) {
        //int year;
        //try {
        //    Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-02 10:00:00");
        //    DateTime.of(date).year()
        //    year = DateUtil.year(date);
        //} catch (ParseException e) {
        //    throw new RuntimeException("日期转化异常");
        //}

        //String codeNumberCheck="43510000-ZY·ZW·2024-D30-000-0001";
        //String[] parts = codeNumberCheck.split("-");
        //for (int i = 0; i < parts.length; i++) {
        //    System.out.println(parts[i]);
        //}
        String localFileUrl="D:\\myfile\\简历\\20240917\\个人简历.pdf";
        File file = new File(localFileUrl);
        System.out.println(file.exists());
    }
}
