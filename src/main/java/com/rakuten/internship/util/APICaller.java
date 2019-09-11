package com.rakuten.internship.util;

import kong.unirest.Unirest; //Use this class to call APIs easily

public class APICaller {
	
	/** API利用に必要 */
	final private static String key = "c3ddba73a4bec65aecdd6acaa626c7c0ff0c2289f45062545dfb7ff520e02f10";

	/**
	 * IPアドレスを送り位置情報を取得します
	 * @param ipAddress IPアドレス
	 * @return 位置情報
	 */
   public static String getLocationInfoFromIpAddress(String ipAddress) {
   	return Unirest.get("http://api.ipinfodb.com/v3/ip-city/?key={key}&ip={ip}")
   			.routeParam("key", key)
   			.routeParam("ip", ipAddress)
   			.asString()
   			.getBody();
   }
}
