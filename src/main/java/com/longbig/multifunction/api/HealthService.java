package com.longbig.multifunction.api;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.longbig.multifunction.utils.SystemProperty;
import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        @RequestParam("echostr") String echostr) {
        byte[] aesKey = Base64.decode(
            SystemProperty.getProp("wecom.aes.key", "yhAQMPcKYljPBISkCsCfMtYmGNz6Rm6xYuailKRhVd5"));
        AES aes = SecureUtil.aes(aesKey);
        byte[] msgBody = Base64.decode(echostr);
        byte[] decrypt = aes.decrypt(msgBody);

        // 分离16位随机字符串,网络字节序和receiveid
        byte[] networkOrder = Arrays.copyOfRange(decrypt, 16, 20);

        int xmlLength = recoverNetworkBytesOrder(networkOrder);

        String xmlContent = new String(Arrays.copyOfRange(decrypt, 20, 20 + xmlLength), SystemProperty.CHARSET);
        String from_receiveid = new String(Arrays.copyOfRange(decrypt, 20 + xmlLength, decrypt.length),
            SystemProperty.CHARSET);

        return from_receiveid;
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
