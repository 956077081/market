package com.pht.base.role.dto;

import com.pht.base.role.entity.SysMenu;

import java.util.ArrayList;
import java.util.List;

public class MenuParam  extends SysMenu {
    private List<SysMenu> sub =new ArrayList<>();

    public List<SysMenu> getSub() {
        return sub;
    }

    public void setSub(List<SysMenu> sub) {
        this.sub = sub;
    }
}
