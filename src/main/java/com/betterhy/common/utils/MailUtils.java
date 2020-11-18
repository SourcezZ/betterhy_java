package com.betterhy.common.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mysql.jdbc.TimeUtil;
import sun.nio.ch.ThreadPool;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 邮件工具类
 *
 * @author Source
 * @date 2020-11-18 21:53
 **/
public class MailUtils {
    private static final String MY_ACCOUNT = "soci_yuan@qq.com";
    private static final String MY_PASSWORD = "pxbciafzzxzqbchc";
    private static final String SMTP = "smtp.qq.com";

    public static void sendEmail(String content) throws Exception {
        // 1. 创建一封邮件
        // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
        Properties props = new Properties();

        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "smtp");
        // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.host", SMTP);
        //设置端口
        props.setProperty("mail.smtp.port", "587");
        // 需要请求认证
        props.setProperty("mail.smtp.auth", "true");

        // 根据参数配置，创建会话对象（为了发送邮件准备的）
        Session session = Session.getInstance(props);
        // 创建邮件对象
        MimeMessage message = createMimeMessage(session, content);

        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();

        // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        //
        //    PS_01: 如果连接服务器失败, 都会在控制台输出相应失败原因的log。
        //    仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接,
        //    根据给出的错误类型到对应邮件服务器的帮助网站上查看具体失败原因。
        //
        //    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
        //           (1) 邮箱没有开启 SMTP 服务;
        //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
        //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
        //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
        //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
        //
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("sendEmail-pool-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);
        executor.execute(() ->{
            try {
                transport.connect(MY_ACCOUNT, MY_PASSWORD);
                // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
                transport.sendMessage(message, message.getAllRecipients());
                // 7. 关闭连接
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session     和服务器交互的会话
     * @return MimeMessage
     * @throws Exception 异常
     */
    private static MimeMessage createMimeMessage(Session session, String content) throws Exception {

        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);

        /*
         * 也可以根据已有的eml邮件文件创建 MimeMessage 对象
         * MimeMessage message = new MimeMessage(session, new FileInputStream("myEmail.eml"));
         */

        // 2. From: 发件人
        //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
        //    真正要发送时, 邮箱必须是真实有效的邮箱。
        message.setFrom(new InternetAddress(MY_ACCOUNT, "betterhy", "UTF-8"));

        // 3. To: 收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(MY_ACCOUNT, "betterhy", "UTF-8"));
        //    To: 增加收件人（可选）
//        message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
        //    Cc: 抄送（可选）
//        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
        //    Bcc: 密送（可选）
//        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject("有新的心情", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("有新的心情啦~\n" + content, "text/html;charset=UTF-8");

        // 6. 设置显示的发件时间
        message.setSentDate(new Date());

        // 7. 保存前面的设置
        message.saveChanges();

        // 8. 将该邮件保存到本地
//        OutputStream out = new FileOutputStream("myEmail.eml");
//        message.writeTo(out);
//        out.flush();
//        out.close();

        return message;
    }

}
