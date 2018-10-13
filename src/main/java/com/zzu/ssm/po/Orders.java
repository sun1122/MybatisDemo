package com.zzu.ssm.po;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Orders implements Serializable{
	
	private static final long serialVersionUID = 3466367695259266547L;
	private Integer id;
	private Integer userid;
	private String number;
	private Date createtime;
	private String note;
	
}
