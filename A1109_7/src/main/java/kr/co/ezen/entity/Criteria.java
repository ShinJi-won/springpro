package kr.co.ezen.entity;

import lombok.Data;

@Data
public class Criteria {
	private int page; //현재 페이지 번호
	private int perPageNum; //한 페이지에 보여줄 게시글 수
	
	//검색기능에 필요한 변수
	private String type;
	private String keyword;

	public Criteria() {
		this.page=1;
		this.perPageNum=10; //조정
		
	}
	//현재 페이지의 게시글의 시작번호
	public int getPageStart() {     //1페이지 2페이지 3페이지 
		return (page-1)*perPageNum; //0~    10~    20~ :limit 0,10
	}
	//1~10 1
	//11~20 2
	//21~30 3
	
	

}
