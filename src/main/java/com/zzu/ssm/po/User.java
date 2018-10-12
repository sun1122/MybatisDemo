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
public class User implements Serializable{

	private static final long serialVersionUID = 6332714412375544790L;
	//private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
}
