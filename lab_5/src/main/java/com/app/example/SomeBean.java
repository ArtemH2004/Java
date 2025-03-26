package com.app.example;

import com.app.annotation.AutoInjectable;
import com.app.example.interfaces.SomeInterface;
import com.app.example.interfaces.SomeOtherInterface;

public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;
    
    @AutoInjectable
    private SomeOtherInterface field2;
    
    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }
}