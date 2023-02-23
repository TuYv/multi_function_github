package com.longbig.multifunction.api;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.longbig.multifunction.model.wechat.aes.AesException;
import com.longbig.multifunction.model.wechat.aes.PKCS7Encoder;
import com.longbig.multifunction.utils.SystemProperty;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthService {

    /**
     * 服务探活接口
     * @return
     */
    @GetMapping("/checkHealth")
    public String checkHealth() {
        return "success";
    }

    @GetMapping("/")
    public String corpWechat(@RequestParam("msg_signature") String msgSign,
        @RequestParam("timestamp") Integer timestamp,
        @RequestParam("nonce") Integer nonce,
        @RequestParam("echostr") String echostr) throws AesException {
        String weComAesKey = SystemProperty.getProp("wecom.aes.key", "yhAQMPcKYljPBISkCsCfMtYmGNz6Rm6xYuailKRhVd5");
        log.info("wecomaesKey:{}", weComAesKey);

        byte[] original;
        try {
            // 设置解密模式为AES的CBC模式
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            byte[] aesKey = org.apache.commons.codec.binary.Base64.decodeBase64(weComAesKey + "=");
            SecretKeySpec key_spec = new SecretKeySpec(aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
            cipher.init(Cipher.DECRYPT_MODE, key_spec, iv);

            // 使用BASE64对密文进行解码
            byte[] encrypted = org.apache.commons.codec.binary.Base64.decodeBase64(echostr);

            // 解密
            original = cipher.doFinal(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.DecryptAESError);
        }

        String xmlContent, from_receiveid;
        try {
            // 去除补位字符
            byte[] bytes = PKCS7Encoder.decode(original);

            // 分离16位随机字符串,网络字节序和receiveid
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);

            int xmlLength = recoverNetworkBytesOrder(networkOrder);

            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), SystemProperty.CHARSET);
            from_receiveid = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length),
                SystemProperty.CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AesException(AesException.IllegalBuffer);
        }

        return xmlContent;
    }

    // 还原4个字节的网络字节序
    int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        for (int i = 0; i < 4; i++) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xff;
        }
        return sourceNumber;
    }
}
