- list 去重 [ListDuplicate](/src/main/java/com/muc/guide/list/ListDuplicate.java)
- 版本号工具 
  - [VersionUtil](/src/main/java/com/muc/guide/version/VersionUtil.java)
  - [VersionUtilTest](/src/main/java/com/muc/guide/version/VersionUtilTest.java)
    ```java
      // 版本转数字
      String versionStr = "2.3.44.55";
      System.out.println(VersionUtil.convertToDecimal(versionStr)); // 2.000300440055
      // 数字转版本号
      BigDecimal version = new BigDecimal("1.0002000300040005");
      System.out.println(VersionUtil.convertString(version)); // 1.2.3.4.5
    ```
