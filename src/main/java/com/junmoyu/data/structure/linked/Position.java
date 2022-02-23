package com.junmoyu.data.structure.linked;

/**
 * @author moyu.jun
 * @date 2021/12/26
 */
public interface Position {
    /**
     * 获取元素
     *
     * @return Object
     */
    Object getElement();

    /**
     * 设置新元素
     *
     * @param element 要存入的新元素
     * @return old Object
     */
    Object setElement(Object element);
}
