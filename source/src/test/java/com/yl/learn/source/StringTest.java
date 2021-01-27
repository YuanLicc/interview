package com.yl.learn.source;

import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;

public class StringTest extends TestCase {
    
    private static Logger logger = LoggerFactory.getLogger(StringTest.class);
    
    public void testIntStream() {
        CharSequence charSequence = "1234";
        charSequence.chars().forEach(PrintUtil::println);
    }
    
    public void testReflect() {
        String s = "1234";
        try {
            logger.info(s);
            Field field = String.class.getDeclaredField("value");
            Field modifiers = field.getClass().getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.set(field, Modifier.PUBLIC);
            char[] value = (char[]) field.get(s);
            value[0] = 'a';
            logger.info(s);
        }
        catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    public void testCode()  {
        String s = "1234a";
        
        Character c = '中';
        PrintUtil.println(s.codePointAt(0));
        PrintUtil.println(s.codePointAt(1));
        PrintUtil.println(s.codePointAt(4));
        
        PrintUtil.println("1".getBytes().length);
        PrintUtil.println("1".getBytes(StandardCharsets.UTF_8).length);
        PrintUtil.println("1".getBytes(StandardCharsets.ISO_8859_1).length);
        PrintUtil.println("1".getBytes(StandardCharsets.US_ASCII).length);
        PrintUtil.println("1".getBytes(StandardCharsets.UTF_16).length);
        
        PrintUtil.println("中".getBytes().length);
        PrintUtil.println("中".getBytes(StandardCharsets.UTF_8).length);
        PrintUtil.println("中".getBytes(StandardCharsets.ISO_8859_1).length);
        PrintUtil.println("中".getBytes(StandardCharsets.US_ASCII).length);
        PrintUtil.println("中".getBytes(StandardCharsets.UTF_16).length);
    }
    
    public void testIntern() {
        String s = "1111";
        PrintUtil.println(s == "1111");
        String s1 = new String("1111");
        PrintUtil.println(s == s1);
        PrintUtil.println(s == s1.intern());
        PrintUtil.println(s == new String("1111"));
        
        String a = "a", b = "b", c = a + b;
        
        PrintUtil.println(c == "ab");
    }
}
