package com.yl.learn.nio.buffer;

import com.yl.learn.util.util.PrintUtil;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferPrinter {

    public static void print(ByteBuffer byteBuffer, String prefix, String suffix) {

        if(byteBuffer == null) {
            return;
        }

        PrintUtil.println(prefix);

        while (byteBuffer.hasRemaining()) {
            PrintUtil.println(byteBuffer.get());
        }

        PrintUtil.println(suffix);
    }

    public static void println(ByteBuffer byteBuffer, String prefix, String suffix) {

        print(byteBuffer, prefix, suffix + "\n");
    }

    public static void print(CharBuffer charBuffer, String prefix, String delimiter, String suffix) {

        if(charBuffer == null) {
            return;
        }

        PrintUtil.println(prefix);

        while (charBuffer.hasRemaining()) {
            PrintUtil.println(charBuffer.get() + delimiter);
        }

        PrintUtil.println(suffix);
    }

    public static void println(CharBuffer charBuffer, String prefix, String delimiter, String suffix) {

        print(charBuffer , prefix, delimiter, suffix + "\n");
    }

}
