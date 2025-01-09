package lineWell.demo02;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/10/12  17:27
 */

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Value;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class WordTemplateFiller {


    @Value("${archives.packageTemp.path}")
    private static String packageTempPath;


    @Value("${archives.template.name}")
    private static String templateName;

    public static String fillWordTemplate(String filePath, Map<String, String> data) throws Exception {

        // 打开 DOCX 文件
        //FileInputStream fis = new FileInputStream(templatePath);
        //XWPFDocument document = new XWPFDocument(fis);


        //InputStream templateStream = WordTemplateFiller.class.getClassLoader().getResourceAsStream("templateFile/归档登记表.docx");
        InputStream templateStream = WordTemplateFiller.class
                .getClassLoader()
                .getResourceAsStream("归档登记表.docx");
        if (templateStream == null) {
            throw new Exception("模板文件未找到");
        }
        XWPFDocument document = new XWPFDocument(templateStream);

        // 遍历文档的段落
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            replaceTextInParagraph(paragraph, data);
        }

        // 遍历文档中的所有表格
        for (XWPFTable table : document.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        replaceTextInParagraph(paragraph, data);
                    }
                }
            }
        }

        // 保存填充后的文件
        //String catalogPath = packageTempPath + File.separator+"登记表"+File.separator;
        String catalogPath=packageTempPath+File.separator;
        //File catalogDir = new File(catalogPath);
        //if (!catalogDir.exists()) {
        //    catalogDir.mkdirs(); // 创建目录
        //}

        //String outputPath = catalogPath+File.separator+filePath;  // 输出文件路径
        String outputPath = "D:\\temporary\\归档登记表.docx";  // 输出文件路径

        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            document.write(fos);
        }
        document.close();
        return outputPath;
    }


    // 辅助方法：在段落中替换占位符
    //private static void replaceTextInParagraph(XWPFParagraph paragraph, Map<String, String> data) {
    //    for (XWPFRun run : paragraph.getRuns()) {
    //        String text = run.getText(0);
    //        if (text != null) {
    //            for (Map.Entry<String, String> entry : data.entrySet()) {
    //                if (text.contains(entry.getKey())) {
    //                    text = text.replace(entry.getKey(), entry.getValue());
    //                    run.setText(text, 0);
    //                }
    //            }
    //        }
    //    }
    //}
    private static void replaceTextInParagraph(XWPFParagraph paragraph, Map<String, String> data) {
        for (XWPFRun run : paragraph.getRuns()) {
            String text = run.getText(0);
            if (text != null && data.containsKey(text)) {
                String replacement = data.get(text);

                // 判断是否是复选框占位符
                if ("{onlineCheck}".equals(text) || "{offlineCheck}".equals(text)) {
                    run.setText(replacement, 0);     // 填充复选框字符
                    run.setFontFamily("Wingdings 2"); // 设置字体为 Wingdings 2
                } else {
                    run.setText(replacement, 0);     // 普通文本替换
                }
            }
        }
    }


    public static void main(String[] args) {

        String filePath = "归档登记表.docx";  // 输出文件路径

        //InputStream templateStream = WordTemplateFiller.class.getClassLoader().getResourceAsStream("templateFileName/归档登记表.docx");


        // 准备填充数据
        Map<String, String> data = new HashMap<>();
        data.put("{workname}", "某某公司");
        data.put("{time}", "2024年10月12日");
        data.put("{check}", "通过");
        // 可以继续添加更多键值对

        try {
            String path = WordTemplateFiller.fillWordTemplate( filePath, data);
            System.out.println("文档填充完成，生成文件：" + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
