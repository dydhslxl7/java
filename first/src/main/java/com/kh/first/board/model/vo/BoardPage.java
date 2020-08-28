package com.kh.first.board.model.vo;

import java.io.Serializable;

public class BoardPage implements Serializable{
	private static final long serialVersionUID = 8888L;
	
	private int startRow;
	private int endRow;
	
	public BoardPage() {}

	public BoardPage(int startRow, int endRow) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	@Override
	public String toString() {
		return "BoardPage [startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
}
