package com.kjgs.功能;

import javax.annotation.PostConstruct;

//词语顶级接口，词的功能包括自身功能、作用其他词的（主动）、被其他词作用给的（被动）
public interface 功能接口 {
    void 初始化记录内置功能属性();
    void 功能();
}
