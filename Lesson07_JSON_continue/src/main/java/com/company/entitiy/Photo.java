package com.company.entitiy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Photo{

	@SerializedName("albumId")
	private Integer albumId;

	@SerializedName("id")
	private Integer id;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("thumbnailUrl")
	private String thumbnailUrl;
}