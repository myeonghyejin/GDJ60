package com.mhj.s1.util;

public class Pagination {
	
	//Client가 보고 싶은 페이지 번호 (Parameter)
	private Long page;
	//한 페이지에 출력할 row의 개수
	private Long perPage;
	
	//DB에서 받아오는 번호
	private Long startRow;
	private Long lastRow;
	
	//JSP에서 출력할 번호
	private Long startNum;
	private Long lastNum;
	
	private boolean before;
	private boolean after;
	
	//생성자
	//한 페이지에 출력될 row 개수 지정
	//생성자 만들어서 선언하거나 Getter 이용하거나
	public Pagination() {
		this.perPage = 10L;
	}
	
	//Getter, Setter
	//Getter에 page, perPage 초기화
	
		//1보다 낮은 숫자가 들어와도 1페이지로 보일 수 있도록 초기화
		//높은 숫자의 경우 row의 값에 따라 얼마나 큰 숫자가 들어올지 알 수 없기 때문에..
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}
	
	public void setPage(Long page) {
		this.page = page;
	}
	
		//한 페이지에 출력될 row 개수 지정해 주기 위해 초기화
		//생성자 만들어서 선언하거나 Getter 이용하거나
	public Long getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		return perPage;
	}
	
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public boolean isBefore() {
		return before;
	}
	public void setBefore(boolean before) {
		this.before = before;
	}
	public boolean isAfter() {
		return after;
	}
	public void setAfter(boolean after) {
		this.after = after;
	}
	
	//--------------------------------------------------------------
	
	//startRow, lastRow 구하기
	public void makeRow() {
		this.startRow = 
		this.lastRow = this.page * this.perPage;
	}
	
	//startNum, lastNum 구하기
		//1. 전체 row 개수 구하기
		//2. 총 페이지의 개수
		//3. 한 블럭에 출력할 번호의 개수
		//4. 총 블럭의 개수 구하기
		//5. 페이지 번호로 현재 블럭 번호 구하기
		//6. 현재 블럭의 시작 번호와 끝 번호 계산
}
