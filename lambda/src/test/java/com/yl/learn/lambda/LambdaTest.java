package com.yl.learn.lambda;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LambdaTest extends TestCase {
    public void testLambda() {

        JButton button = new JButton("click me");
        button.addActionListener(event -> PrintUtil.println("clicked"));

        String name = "aaa";

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrintUtil.println("clicked" + name);
            }
        });
    }
}
