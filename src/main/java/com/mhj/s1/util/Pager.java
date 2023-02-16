package com.mhj.s1.util;

public class Pager {
	
	//검색 종류(사용할 Column명)
	private String kind;
	
	//검색어
	private String search;
	
	//Getter, Setter
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
	//--------------------------------
	

	//한 페이지에 출력할 row의 개수
	private Long perPage;
	
	//한 Block당 출력할 번호의 개수
	private Long perBlock;
	
	//전체 Page 개수
	private Long totalPage;
	
	//Client가 보고 싶은 페이지 번호 (Parameter)
	private Long page;
	
	//DB에서 조회할 시작 번호
	private Long startRow;
	//DB에서 조회할 끝 번호
	private Long lastRow;
	
	//JSP에서 출력할 시작 번호
	private Long startNum;
	//JSP에서 출력할 끝 번호
	private Long lastNum;
	
	private boolean before;
	private boolean after;
	
	//전체 row의 개수를 담을 변수
//	private Long totalCount;
//	
//	public Long getTotalCount() {
//		return totalCount;
//	}
//
//	public void setTotalCount(Long totalCount) {
//		this.totalCount = totalCount;
//	}
	
	//생성자
	public Pager() {
		this.perPage = 10L;
	}
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	//startNum, lastNum
	public void makeNum(Long totalCount) {
		
		//1. 전체 row의 개수 구하기
		//2. 총 페이지의 개수
		totalPage = totalCount / this.getPerPage();
		if (totalCount%this.getPerPage() != 0) {
			//totalPage=totalPage+1;
			//totalPage+= 1;
			totalPage++;
		}
		//3. 한 블럭에 출력할 번호의 개수
		
		//4. 총 블럭의 개수 구하기
		Long totalBlock = totalPage / this.getPerBlock();
		if (totalPage%this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//마지막 페이지 초기화
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		
		//5. 페이지 번호로 현재 블럭 번호 구하기
		// page 1-5 curBlock 1
		// page 6-10 curBlock 2
		// page 11-15 curBlock 3
		Long curBlock = this.getPage() / this.getPerBlock();
		if (this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//6. curBlock의 시작 번호와 끝 번호 계산
		/**		curBlock	startNum	lastNum
		 * 		1			1			5
		 * 		2			6			10
		 * 		3			11			15
		 */
		
		this.startNum = this.getPerBlock()*(curBlock-1)+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		this.after = true;
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
			this.after = false;
		}
		
		if(curBlock == 1) {
			this.before = true;
		}
		
	}

	
	//Getter, Setter
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
	public Long getPerPage() {
		if(this.perPage == null || this.perPage == 0) {
			this.perPage = 10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if (this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
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
	public boolean isAfter() {
		return after;
	}
	public void setAfter(boolean after) {
		this.after = after;
	}
	public boolean isBefore() {
		return before;
	}
	public void setBefore(boolean before) {
		this.before = before;
	}
	public Long getPerBlock() {
		if(this.perBlock == null || this.perBlock < 1) {
			this.perBlock = 5L;
		}
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	
}
