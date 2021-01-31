package com.pht.cust.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false) //重写hashcode 和 equal方法 只比对属性值 username 和 password
public class AdminLoginParam {
  @NotEmpty
  private  String username;
  @NotEmpty
  private String password;
}
