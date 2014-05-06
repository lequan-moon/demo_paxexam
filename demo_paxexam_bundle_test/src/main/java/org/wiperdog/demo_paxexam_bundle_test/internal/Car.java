package org.wiperdog.demo_paxexam_bundle_test.internal;

import org.wiperdog.demo_paxexam_bundle_test.Vehicle;

public class Car implements Vehicle {
	private String model;

	public Car(String model) {
		this.model = model;
	}

	public String goLeft() {
		return "Go to left";
	}

	public String goRight() {
		return "Go to right";
	}

	public String goBack() {
		return "Go back";
	}

	public String goFoward() {
		return "Go forward";
	}

	public String stop() {
		return "Stop";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}
