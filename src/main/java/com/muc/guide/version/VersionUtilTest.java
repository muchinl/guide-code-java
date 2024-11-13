package com.muc.guide.version;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 版本号工具测试
 */
public class VersionUtilTest {

    @Test
    public void stringToVersion() {
        String versionStr = "2.3.44.55"; // 2.000300440055
        System.out.println(VersionUtil.convertToDecimal(versionStr));
    }

    @Test
    public void versionToString() {
        BigDecimal version = new BigDecimal("1.0002000300040005");
        System.out.println(VersionUtil.convertString(version)); // 1.2.3.4.5
    }
}
