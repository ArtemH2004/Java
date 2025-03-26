package com.app;

import com.app.core.Injector;
import com.app.example.SomeBean;

public class App {
    public static void main(String[] args) {
        SomeBean sb = new Injector("injector-bc.properties").inject(new SomeBean());
        sb.foo();
    }
}
