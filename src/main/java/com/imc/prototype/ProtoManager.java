package com.imc.prototype;

import java.util.ArrayList;

/**
 * @author luoly
 * @date 2018/12/11 11:38
 * @description
 */
public class ProtoManager {

    ArrayList arrayList = new ArrayList();

    public void add(Object object) {
        arrayList.add(object);
    }

    public int getSize() {
        return arrayList.size();
    }
}
