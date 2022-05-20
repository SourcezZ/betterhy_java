package com.betterhy.common.utils;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Subdivision;

import java.io.File;
import java.net.InetAddress;

/**
 * ip工具类
 *
 * @author Source
 * @date 2022-05-20 15:18:41
 */
public class GetIpUtils {
    private static DatabaseReader reader;
    private static void init() {
        try {
            // 创建 GeoLite2 数据库 Reader
            // 这里可以放在本地磁盘，也可以随项目放在resource目录下
            File database = new File("/root/prod/GeoLite2-City.mmdb");
            // 读取数据库内容
            reader = new DatabaseReader.Builder(database).build();
        } catch (Exception ex) {
        }
    }

    public static String getCityByIp(String ip) throws Exception {
        if (null == reader) {
            init();
        }

        InetAddress ipAddress = InetAddress.getByName(ip);

        // 获取查询结果
        CityResponse response = reader.city(ipAddress);

        // 获取国家信息
        Country country = response.getCountry();
        String ctry = country.getNames().get("zh-CN");

        // 获取省份
        Subdivision subdivision = response.getMostSpecificSubdivision();
        String province = subdivision.getNames().get("zh-CN");

        //城市
        City city = response.getCity();
        String ct = city.getNames().get("zh-CN");

        // 获取城市
        Location location = response.getLocation();
        String loc = "lon " + location.getLongitude() + ",lat " + location.getLatitude();

        return "ipInfo: " + ip + "," + ctry + "," + province + "," + ct + "," + loc;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getCityByIp("x"));
    }
}
