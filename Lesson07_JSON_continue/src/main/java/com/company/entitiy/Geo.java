package com.company.entitiy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Geo{

	@SerializedName("lng")
	private String lng;

	@SerializedName("lat")
	private String lat;
}