package com.me.dto;

/**
 * @ClassName EmailMessage
 * @Description TODO
 * @Author noname
 * @Data
 * @Version 1.0
 **/
public class EmailMessage {
    private static final String SENDNAME="XFSurvey";
    private static final String SENDTEMP="smtp.qq.com";
    private static final String SENDFROM="695978952@qq.com";
    private static final String QQNUMBER="695978952";
    private static final String PASSWORD="psveqwlifayibchg";
    private static final String EmailBody="欢迎注册本问卷系统,下面是你的验证码,3分钟内有效。\n";

    public static String getSENDTEMP() {
        return SENDTEMP;
    }

    public static String getSENDFROM() {
        return SENDFROM;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getSENDNAME() {
        return SENDNAME;
    }

    public static String getQQNUMBER() {
        return QQNUMBER;
    }

    public static String getEmailBody() {
        return EmailBody;
    }
}
