package com.zzu.ssm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OrdersExt extends Orders {
	
	private String username;
    private String address;
}
