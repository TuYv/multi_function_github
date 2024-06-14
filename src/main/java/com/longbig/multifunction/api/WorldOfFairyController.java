package com.longbig.multifunction.api;

import com.longbig.multifunction.service.fairy.func.Arena;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description
 * @create 2023-08-28 11:20
 **/
@RestController
@Slf4j
public class WorldOfFairyController {

    @Resource Arena arena;

    @GetMapping("/fairy/arena")
    public String arena(@RequestParam("code") String code) {
        return arena.vsFairy(code);
    }
}
