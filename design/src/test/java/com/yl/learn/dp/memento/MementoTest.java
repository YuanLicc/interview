package com.yl.learn.dp.memento;

import com.yl.learn.dp.memento.imp.Caretaker;
import com.yl.learn.dp.memento.imp.Originator;
import com.yl.learn.util.util.PrintUtil;
import junit.framework.TestCase;

public class MementoTest extends TestCase {

    public void testMemento() {
        Originator o = new Originator();
        o.setState("AA");
        PrintUtil.println(o);

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(o.createMemento());

        o.setState("BB");
        PrintUtil.println(o);

        o.restoreMemento(caretaker.getMemento());
        PrintUtil.println(o);
    }
}
