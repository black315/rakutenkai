package com.rakuten.internship.entity;

import lombok.Data;

/**
 * 位置フォーム
 */
@Data
public class ContactForm {
    
	/** 部屋ID */
	private Long roomId;
	
	/** 送信元ユーザID */
	private Long idFrom;

	/** 送信先ユーザID */
	private Long idTo;

	/**
	 * @return the roomId
	 */
	public Long getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the idFrom
	 */
	public Long getIdFrom() {
		return idFrom;
	}

	/**
	 * @param idFrom the idFrom to set
	 */
	public void setIdFrom(Long idFrom) {
		this.idFrom = idFrom;
	}

	/**
	 * @return the idTo
	 */
	public Long getIdTo() {
		return idTo;
	}

	/**
	 * @param idTo the idTo to set
	 */
	public void setIdTo(Long idTo) {
		this.idTo = idTo;
	}
}
