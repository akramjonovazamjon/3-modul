package com.company.entitiy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Album{

	@SerializedName("id")
	private Integer id;

	@SerializedName("title")
	private String title;

	@SerializedName("userId")
	private Integer userId;
}