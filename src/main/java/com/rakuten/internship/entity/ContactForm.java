package com.rakuten.internship.entity;

import lombok.Data;

/**
 * 位置フォーム
 */
// TODO: put the Entity annotation
@Data
public class ContactForm {
    
	/** 部屋ID */
	private Long roomId;
	
	/** 送信元ユーザID */
	private Integer idFrom;

	/** 送信先ユーザID */
	private Integer idTo;
}
