package com.iri.training.model;


public class Statistics {

	private int first_group;
	private int second_group;
	private int third_group;
	private int fourth_group;
	private int fifth_group;
	private int sixth_group;
	private int seventh_group;

	public void setFirst_group(final int first_group) {

		this.first_group = first_group;
	}

	public void setSecond_group(final int second_group) {

		this.second_group = second_group;
	}

	public void setThird_group(final int third_group) {

		this.third_group = third_group;
	}

	public void setFourth_group(final int fourth_group) {

		this.fourth_group = fourth_group;
	}

	public void setFifth_group(final int fifth_group) {

		this.fifth_group = fifth_group;
	}

	public void setSixth_group(final int sixth_group) {

		this.sixth_group = sixth_group;
	}

	public void setSeventh_group(final int seventh_group) {

		this.seventh_group = seventh_group;
	}

	public int getFirst_group() {


		return first_group;
	}

	public int getSecond_group() {

		return second_group;
	}

	public int getThird_group() {

		return third_group;
	}

	public int getFourth_group() {

		return fourth_group;
	}

	public int getFifth_group() {

		return fifth_group;
	}

	public int getSixth_group() {

		return sixth_group;
	}

	public int getSeventh_group() {

		return seventh_group;
	}

	@Override public String toString() {

		return "Statistics{" +
			"first_group=" + first_group +
			", second_group=" + second_group +
			", third_group=" + third_group +
			", fourth_group=" + fourth_group +
			", fifth_group=" + fifth_group +
			", sixth_group=" + sixth_group +
			", seventh_group=" + seventh_group +
			'}';
	}
}
