package com.pht.base.role.service;

import com.pht.base.role.dao.SysRoleLnkMenuDao;
import com.pht.base.role.dto.MenuParam;
import com.pht.base.role.entity.SysMenu;
import com.pht.base.role.entity.SysRoleType;
import com.pht.base.system.constant.SysParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysRoleLnkMenuService {
    @Autowired
    private SysRoleLnkMenuDao sysRoleLnkMenuDao;
    /**
     * 获取角色关联菜单
     * @return
     */
    public List<MenuParam> queryRoleMenus(List<SysRoleType> roleList){
        List<String> collect = roleList.stream().map(role -> {
            return role.getType();
        }).collect(Collectors.toList());
        List<SysMenu> sysMenus = sysRoleLnkMenuDao.queryRoleMenus(collect);
        Map<String,MenuParam> paramMap =new HashMap<>();
        for (SysMenu sysMenu : sysMenus) {
            if(StringUtils.isBlank(sysMenu.getParentUrl())){
                MenuParam menuParam =new MenuParam();
                BeanUtils.copyProperties(sysMenu,menuParam);
                paramMap.put(sysMenu.getUrl(),menuParam);
            }else{
                MenuParam menuParam = paramMap.get(sysMenu.getParentUrl());
                menuParam.getSub().add(sysMenu);
            }
        }
        List<MenuParam> list = new ArrayList<>(paramMap.values());
        Collections.sort(list, new Comparator<MenuParam>() {
            @Override
            public int compare(MenuParam o1, MenuParam o2) {
                return Integer.valueOf(o1.getSortNo()) - Integer.valueOf(o2.getSortNo());
            }
        });
        return list;
    }

}
