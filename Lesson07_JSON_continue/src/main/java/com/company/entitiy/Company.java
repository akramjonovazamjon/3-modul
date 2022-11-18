package com.company.entitiy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Company{

	@SerializedName("bs")
	private String bs;

	@SerializedName("catchPhrase")
	private String catchPhrase;

	@SerializedName("name")
	private String name;
}