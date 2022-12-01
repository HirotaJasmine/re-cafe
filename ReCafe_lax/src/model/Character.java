package model;

import java.io.Serializable;

public class Character implements Serializable{
	private int num;
	private String name;
	private int emotionPoint;

	public Character() {

	}

	public Character(int num, String name) {
		super();
		this.num = num;
		this.name = name;

	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public int getEmotionPoint() {
		return emotionPoint;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmotionPoint(int emotionPoint) {
		this.emotionPoint = emotionPoint;
	}

}
