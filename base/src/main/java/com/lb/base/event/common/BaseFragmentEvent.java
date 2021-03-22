package com.lb.base.event.common;

import com.lb.base.event.BaseEvent;

/**
 * Create by liub on 2021/3/2
 * Describe:
 */
public class BaseFragmentEvent<T> extends BaseEvent<T> {
    public BaseFragmentEvent(int code) {
        super(code);
    }
}
