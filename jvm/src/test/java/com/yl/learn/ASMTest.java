package com.yl.learn;

import com.yl.learn.util.util.PrintUtil;
import jdk.internal.org.objectweb.asm.*;
import junit.framework.TestCase;

import java.io.IOException;

public class ASMTest extends TestCase {
    
    public void test() throws IOException {
    
        ClassReader classReader = new ClassReader(ASMTest.class.getResourceAsStream("App.class"));
        classReader.accept(new Visitor(Opcodes.ASM5), ClassReader.SKIP_DEBUG);
        
        ClassWriter classWriter = new ClassWriter(classReader, ClassReader.SKIP_DEBUG);
        
        classWriter.newField("own", "name", "I");
        
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Appli", null, null, null);
        byte[] bytes = classWriter.toByteArray();
        
        OwnLoader ownLoader = new OwnLoader();
        
        Class clazz = ownLoader.loadClass(bytes);
        
        PrintUtil.print(clazz);
    }
    
    class OwnLoader extends ClassLoader {
    
        public Class<?> loadClass(byte[] bytes) {
            return defineClass(null, bytes, 1, bytes.length);
        }
        
    }
    
    class Visitor extends ClassVisitor {
    
        public Visitor(int i) {
            super(i);
        }
    
        public Visitor(int i, ClassVisitor classVisitor) {
            super(i, classVisitor);
        }
    
        @Override
        public MethodVisitor visitMethod(int var1, String var2, String var3, String var4, String[] var5) {
            return this.cv != null ? this.cv.visitMethod(var1, var2, var3, var4, var5) : null;
        }
    }
    
    
}
