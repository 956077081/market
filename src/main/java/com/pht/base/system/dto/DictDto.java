package com.pht.base.system.dto;

import com.pht.base.system.entity.SysDict;

import java.util.List;

public class DictDto extends SysDict {

    private List<SysDict> subList;

    public List<SysDict> getSubList() {
        return subList;
    }

    public void setSubList(List<SysDict> subList) {
        this.subList = subList;
    }
}
