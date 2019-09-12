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
	public Integer getIdFrom() {
		return idFrom;
	}

	/**
	 * @param idFrom the idFrom to set
	 */
	public void setIdFrom(Integer idFrom) {
		this.idFrom = idFrom;
	}

	/**
	 * @return the idTo
	 */
	public Integer getIdTo() {
		return idTo;
	}

	/**
	 * @param idTo the idTo to set
	 */
	public void setIdTo(Integer idTo) {
		this.idTo = idTo;
	}
}
