package com.leoao.test.tool;

/**
 * 安全异常
 * 加解密异常
 * 
 * @author jinma
 * @Date 2014年10月30日
 */
public class SecurityEncryptException extends Exception {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -6053817844679185438L;

    /**
     * @param message 异常消息
     */
    public SecurityEncryptException(String message) {
        super(message);
    }

    /**
     * @param message 异常消息
     */
    public SecurityEncryptException(String message, Throwable cause) {
        super(message, cause);
    }

}
