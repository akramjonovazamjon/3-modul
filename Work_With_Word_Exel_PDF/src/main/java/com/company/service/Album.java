package com.company.service;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Album{

	@SerializedName("userId")
	private Integer userId;

	@SerializedName("id")
	private Integer id;

	@SerializedName("title")
	private String title;


}