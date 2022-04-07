package com.example.learning.controller;

import com.example.learning.LearningApplicationTests;
import com.example.learning.controllers.TestController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestControllerTest extends LearningApplicationTests {

    @Test
    void testFindMaxLogic() {
        assertEquals(4, TestController.findMax(new int[]{1,3,4,2}));
        assertEquals(-1,TestController.findMax(new int[]{-12,-1,-3,-4,-2}));
    }
}
