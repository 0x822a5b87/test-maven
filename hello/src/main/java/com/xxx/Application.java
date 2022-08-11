package com.xxx;

import java.util.Map;

/**
 * @author 0x822a5b87
 */
public class Application {
    public static void main(String[] args) {
        ShadeApplication shade = new ShadeApplication();
        Map<String, String> ret = shade.shadeCaseFormat("k1=v1&k2=v2&k3=v3");
        System.out.println(ret);
    }
}
