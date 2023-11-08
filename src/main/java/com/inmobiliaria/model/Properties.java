package com.inmobiliaria.model;

import lombok.Data;

@Data
public class Properties {

	int id;
	String reference;
	double price;
	int bathrooms;
	int bedrooms;
	int meters;
	int term;
	int property_owner;
	int location;
	int category;
}
