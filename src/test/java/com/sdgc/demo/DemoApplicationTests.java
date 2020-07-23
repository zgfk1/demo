package com.sdgc.demo;

import com.sdgc.demo.engine.MultiExtensionEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {


    }


    public static void main(String[] args) {

        MultiExtensionEngine multiExtensionEngine = new MultiExtensionEngine();
        System.out.println(multiExtensionEngine.process("jd", "ddddddddddddddddddd"));
    }

}
