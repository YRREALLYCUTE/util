package com.zhazhapan.util.office;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2018/2/28
 */
public class MsWordUtilsTest {

    private final String path = "/Users/pantao/Desktop/test.docx";

    public MsWordUtilsTest() throws IOException {
        MsWordUtils.setXwpfDocument(path);
    }

    @Test
    public void test() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Map<String, Object> styles = new HashMap<>();

        XWPFRun run = MsWordUtils.getNewRun(ParagraphAlignment.CENTER);
        styles.put("text", "市政府第25次常务会议议题报批单");
        styles.put("bold", Boolean.TRUE);
        styles.put("fontFamily", "宋体");
        styles.put("fontSize", 18);
        MsWordUtils.setStyle(run, styles);

        run = MsWordUtils.getNewRun(ParagraphAlignment.LEFT);
        styles.put("text", "时间：");
        styles.put("bold", false);
        styles.put("fontSize", 12);
        MsWordUtils.setStyle(run, styles);

        MsWordUtils.writeAndClose(path);
    }


    @Test
    public void appendImage() throws IOException, InvalidFormatException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException {
        MsWordUtils.appendImage("/Users/pantao/Documents/images/portrait/avator.png", XWPFDocument.PICTURE_TYPE_PNG,
                200, 200, ParagraphAlignment.CENTER);
        XWPFRun run = MsWordUtils.getNewRun(ParagraphAlignment.CENTER);
        run.setText("图1");
        run.setBold(true);
        run.setColor("8d64e7");
        MsWordUtils.writeAndClose(path);
    }

    @Test
    public void getNewRun() {
    }

    @Test
    public void getNewRunOfParagraph() {
    }

    @Test
    public void getRun() {
    }

    @Test
    public void getRunSize() {
    }

    @Test
    public void getParagraph() {
    }

    @Test
    public void getParagraphSize() {
    }

    @Test
    public void appendTable() throws IOException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {
        MsWordUtils.createXwpfDocument();
        String[][] values = new String[][]{{"编号", "姓名", "性别"}, {"1", "小明", "男"}, {"2", "小红", "女"}};
        MsWordUtils.appendTable(ParagraphAlignment.CENTER, 3, 3, values, 200, 3000, null, null);
        MsWordUtils.writeAndClose(path);
    }
}