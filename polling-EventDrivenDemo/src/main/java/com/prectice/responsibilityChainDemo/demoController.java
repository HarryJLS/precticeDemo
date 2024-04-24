package com.prectice.responsibilityChainDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JLS
 * @description:
 * @since 2024-04-24 19:00
 */
@RestController
public class demoController {


    @GetMapping
    public String test() {
        BaseSlot checkSlot1 = new CheckSlot1();
        BaseSlot checkSlot2 = new CheckSlot2();
        BaseSlot checkSlot3 = new CheckSlot3();
        BaseSlot checkSlot4 = new CheckSlot4();
        checkSlot1.setNextSlot(checkSlot2);
        checkSlot2.setNextSlot(checkSlot3);
        checkSlot3.setNextSlot(checkSlot4);
        checkSlot1.checkThins();
        return "success";

    }
}
