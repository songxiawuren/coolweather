package com.coolweather.util;

import android.text.TextUtils;
import android.view.TextureView;

import com.coolweather.model.City;
import com.coolweather.model.CoolWeatherDB;
import com.coolweather.model.County;
import com.coolweather.model.Province;

/**
 * Created by byn on 2015/5/29.
 */
public class Utility {
    /**
     * �����ʹ�����������ڵ�ʡ������
     */
    public synchronized static boolean handleProvincesResponse(CoolWeatherDB
           coolWeatherDdB,String response){
        if (!TextUtils.isEmpty (response)){
            String[] allProvinces = response.split (",");
            if (allProvinces != null && allProvinces.length >0){
                for (String p:allProvinces){
                    String[] array = p.split ("\\|");
                    Province province = new Province ();
                    province.setProvinceCode (array[0]);
                    province.setProvinceName (array[1]);
                    //���������������ݴ洢��Province��
                    coolWeatherDdB.saveProvince (province);
                }
                return true;
            }
        }
        return  false;
    }
    /**
     * �����ʹ�����������ص��м�����
     */
    public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDdB,
                                               String response,int provinceId){
        if (!TextUtils.isEmpty (response)){
            String[] allCities = response.split (",");
            if (allCities != null && allCities.length > 0){
                for (String c:allCities){
                    String[] array = c.split ("\\|");
                    City city = new City ();
                    city.setCityCode (array[0]);
                    city.setCityName (array[1]);
                    //���������������ݴ洢��City��
                    city.setProvinceId (provinceId);
                    coolWeatherDdB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }
    /**
     * �����ʹ�����������ڵ��ؼ�����
     */
    public static boolean handleCountiesReponse(CoolWeatherDB coolWeatherDB,
                                                String response,int cityId){
        if (!TextUtils.isEmpty (response)){
            String[] allCounties = response.split (",");
            if (allCounties != null && allCounties.length > 0){
                for (String c:allCounties){
                    String[] array = c.split ("\\|");
                    County county = new County ();
                    county.setCountyCode (array[0]);
                    county.setCountyName (array[1]);
                    county.setCityId (cityId);
                    //���������������ݴ洢��County��
                    coolWeatherDB.saveCounty (county);
                }
                return true;
            }
        }
        return false;
    }
}


















