package cn.maitian.bss.modules.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * 自定义密码处理
 *
 * @author liguo
 * @since 2021-08-13
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {

    /**
     * 进行加密的方法
     *
     * @param rawPassword 未加密的密码
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return privateEncode(rawPassword);
    }

    /**
     * 进行密码比对的方法
     *
     * @param rawPassword     未加密的密码
     * @param encodedPassword 加密的密码
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return Objects.equals(privateEncode(rawPassword), encodedPassword);
    }

    /**
     * 加密方法
     *
     * @param rawPassword
     * @return
     */
    private String privateEncode(CharSequence rawPassword) {
        String algorithm = "MD5";
        String encoded = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            // 获取输入的字节数组
            byte[] input = ((String) rawPassword).getBytes();
            // 加密
            byte[] output = messageDigest.digest(input);
            // 将加密后的字节数组转成 16 进制
            encoded = new BigInteger(1, output).toString(16).toUpperCase();
            encoded = encoded.toLowerCase().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encoded;
    }

}