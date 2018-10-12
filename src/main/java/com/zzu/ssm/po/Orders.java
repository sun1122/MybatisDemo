package com.zzu.ssm.po;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Orders {
	private Integer id;
	private Integer user_id;
	private String number;
	private Date createtime;
	private String note;
	
}
