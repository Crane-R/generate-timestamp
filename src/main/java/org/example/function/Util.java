package org.example.function;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description ：
 * @Author ：ZhouXingxue
 * @Date ：2022/9/23 21:15
 */
public class Util {

    /**
     * 生成指定日期格式字符串
     *
     * @Author Crane Resigned
     * @Date 2022-09-23 21:15:53
     */
    public static String generateTime(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 将结果复制到粘贴板
     *
     * @Author Crane Resigned
     * @Date 2022-09-23 21:18:26
     */
    public static void stick(String result) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(result);
        clip.setContents(tText, null);
    }
}
