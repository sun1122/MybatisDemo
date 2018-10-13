package com.zzu.ssm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OrdersExt extends Orders {
	

	private static final long serialVersionUID = -2698531674181924541L;
//	private String username;
//    private String address;
    private User user;
}
