package com.iri.training.model;


public class Metrics {


	private double height;
	private double weight;
	private String nationality;
	private String place_of_birth;
	private  String education;
	private Long userId;



	public void setUserId(final Long userId) {

		this.userId = userId;
	}

	public Long getUserId() {


		return userId;
	}


	public void setHeight(final double height) {

		this.height = height;
	}

	public void setWeight(final double weight) {

		this.weight = weight;
	}

	public void setNationality(final String nationality) {

		this.nationality = nationality;
	}

	public void setPlace_of_birth(final String place_of_birth) {

		this.place_of_birth = place_of_birth;
	}
	public void setEducation(final String education) {

		this.education = education;
	}

	public double getHeight() {


		return height;
	}

	public double getWeight() {

		return weight;
	}

	public String getNationality() {

		return nationality;
	}

	public String getPlace_of_birth() {

		return place_of_birth;
	}
	public String getEducation() {

		return education;
	}

	@Override
	public String toString() {

		return "Metrics{" +
			"height=" + height +
			", weight=" + weight +
			", nationality='" + nationality + '\'' +
			", place_of_birth='" + place_of_birth + '\'' +
			", education='" + education + '\'' +
			", userId=" + userId +
			'}';
	}
}
