package other;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.*;
import java.nio.charset.Charset;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/7/8
 */
public class HtmlConvertToPdf {
    public static void main(String[] args) {
        String filePrefix = "/Users/luoyalan/Documents/project/ExerciseCode/src/main/java/other/";
        try {
            // 读取html文件
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePrefix + "test.html"), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String s = "";
            while ((s = in.readLine()) != null) {
                sb.append(s);
                System.out.println(s);
            }
            in.close();
            // 写入pdf文件
            parseHTML2PDFFile2(filePrefix + "test.pdf", sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void parseHTML2PDFFile2(String pdfFile, String html)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream(pdfFile));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new ByteArrayInputStream(html.getBytes("UTF-8")),
                Charset.forName("UTF-8"));
        document.close();
    }
}
