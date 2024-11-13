package com.muc.guide.version;

import com.muc.guide.util.StringUtil;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 版本号工具类
 *  将版本号转换为浮点数，存储数据库，方便排序 {@link #convertToDecimal(String)}
 *  将浮点数转换为版本号 {@link #convertString(BigDecimal)}
 *  e.g.
 *    convertToDecimal("2.31.44") => 2.00310044
 *    convertString("2.00310044000000010012") => 2.31.44.0.1.12
 */
public class VersionUtil {

    private VersionUtil() {}

    public static final String VERSION_SPLIT = ".";
    public static final String VERSION_SPLIT_REGEX = "\\.";

    /**
     * 版本号转换为 BigDecimal e.g.
     *  convertToDecimal("1.0.1") => 1.00000001
     *  convertToDecimal("2.31.44") => 2.00310044
     *  convertToDecimal("2.31") => 2.0031
     * @param
     * @return
     * @author yangzl
     * @date 2022/12/14 16:07
     */
    public static BigDecimal convertToDecimal(String version) {
        if (StringUtil.isBlank(version)) {
            return null;
        }
        String[] versionArr = version.split(VERSION_SPLIT_REGEX);
        StringBuilder result = new StringBuilder(versionArr[0] + VERSION_SPLIT);
        for (int i = 1; i < versionArr.length; i++) {
            result.append(digitSuppleZero(versionArr[i], 4));
        }
        return new BigDecimal(result.toString());
    }

    /**
     * BigDecimal 版本号，转换为字符串版本号， e.g.
     *  convertString("1.00000001") => 1.0.1
     *  convertString("2.00310044000000010012") => 2.31.44.0.1.12
     *  convertString("2.0031") => 2.31
     * @param version 版本号
     * @return
     * @author yangzl
     * @date 2022/12/14 16:30
     */
    public static String convertString(BigDecimal version) {
        if (Objects.isNull(version)) {
            return null;
        }
        String versionStr = version.toString();
        String[] versionArr = versionStr.split(VERSION_SPLIT_REGEX);
        int subVersionNum = versionArr[1].length() / 4;
        String result = versionArr[0];
        for (int i = 0; i < subVersionNum; i++) {
            String digit = versionArr[1].substring(i * 4, i * 4 + 4);
            result += (VERSION_SPLIT + Integer.parseInt(digit));
        }
        return result;
    }

    /**
     * 数字前面补0 e.g.
     *  digitSuppleZero(1, 4) => 0001
     * @param digit 数字
     * @param digitsNums 数字的位数
     * @return 补0后的数字字符串
     * @author yangzl
     * @date 2022/12/14 15:55
     */
    private static String digitSuppleZero(String digit, int digitsNums) {
        if (StringUtil.isBlank(digit)) {
            return "0";
        }
        if (digit.length() >= digitsNums) {
            return digit;
        }
        // 补0的数量
        int zeroNums = digitsNums - digit.length();
        String zeroStr = "";
        for (int i = 0; i < zeroNums; i++) {
            zeroStr += "0";
        }
        return zeroStr + digit;
    }
}
