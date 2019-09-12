package com.rakuten.internship.service;

import com.rakuten.internship.entity.LocationForm;
import com.rakuten.internship.util.APICaller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.TEXT_HTML;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocationService {
	
	/**
	 * IPアドレスを位置フォームに変換します
	 * @param ipAddress IPアドレス
	 * @return 位置フォーム
	 */
    public LocationForm convertIpAddressToLocationForm(String ipAddress) {
    	String locationInfo =  APICaller.getLocationInfoFromIpAddress(ipAddress);
    	return convertResponseToForm(locationInfo);
    }
    
    /**
     * レスポンスを位置フォームに変換します
     * @param response レスポンス
     * @return 位置フォーム
     */
    private LocationForm convertResponseToForm(String response) {
    	LocationForm locationForm = new LocationForm();
    	List<String> datas = Arrays.asList(response.split(";"));
    	locationForm.setStatusCode(datas.get(0));
    	locationForm.setStatusMessage(datas.get(1));
    	locationForm.setIp(datas.get(2));
    	locationForm.setCountryCode(datas.get(3));
    	locationForm.setCountryName(datas.get(4));
    	locationForm.setRegion(datas.get(5));
    	locationForm.setCity(datas.get(6));
    	locationForm.setZipCode(datas.get(7));
    	locationForm.setLatitude(datas.get(8));
    	locationForm.setLongitude(datas.get(9));
    	return locationForm;
    }

}