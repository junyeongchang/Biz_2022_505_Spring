package com.callor.naver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookUserVO {

	private String isbn;// VARCHAR2(13) primary key,
	private String title;// NVARCHAR2(50) not null,
	private String author;// NVARCHAR2(50) not null,
	private String publisher;// NVARCHAR2(50) not null,
	private int price;// NUMBER,
	private int discount;// NUMBER,
	private String description;// NVARCHAR2(2000),
	private String pubdate;// VARCHAR2(10),
	private String link;// VARCHAR2(120),
	private String image;// VARCHAR2(120)

}
