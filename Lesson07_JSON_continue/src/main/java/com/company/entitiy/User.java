package com.company.entitiy;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class User{

	@SerializedName("website")
	private String website;

	@SerializedName("address")
	private Address address;

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("company")
	private Company company;

	@SerializedName("id")
	private Integer id;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;
}