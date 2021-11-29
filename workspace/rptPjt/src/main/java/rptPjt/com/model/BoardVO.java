package rptPjt.com.model;

import java.util.Date;

public class BoardVO {
int idx;
String title;
String content;
String writer;
Date regdate;
Date updatedate;
int viewcnt;
public int getIdx() {
	return idx;
}
public void setIdx(int idx) {
	this.idx = idx;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public Date getUpdatedate() {
	return updatedate;
}
public void setUpdatedate(Date updatedate) {
	this.updatedate = updatedate;
}
public int getViewcnt() {
	return viewcnt;
}
public void setViewcnt(int viewcnt) {
	this.viewcnt = viewcnt;
}
@Override
public String toString() {
	return "BoardVO [idx=" + idx + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
			+ regdate + ", updatedate=" + updatedate + ", viewcnt=" + viewcnt + "]";
}


}
