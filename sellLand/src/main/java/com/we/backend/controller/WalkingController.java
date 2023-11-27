package monthsago.travel16.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")

public class WalkingController {
    @GetMapping("/getwalking1")
    public String getwalking1() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/Durunubi/courseList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("6", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("travel16", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("crsKorNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*검색하고자 하는 코스명 (인코딩 필요)*/
        urlBuilder.append("&" + URLEncoder.encode("routeIdx","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*코스에 해당하는 길번호*/
        urlBuilder.append("&" + URLEncoder.encode("crsLevel","UTF-8") + "=" + URLEncoder.encode("2", "UTF-8")); /*코스 난이도(1:하/2:중/3:상)*/
        urlBuilder.append("&" + URLEncoder.encode("brdDiv","UTF-8") + "=" + URLEncoder.encode("DNWW", "UTF-8")); /*걷기/자전거 구분(DNWW : 걷기길, DNBW : 자전거길)*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));  //json리턴

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //url 오픈해라
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        return sb.toString();
    }
    @GetMapping("/getwalking2")
    public String getwalking2() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/Durunubi/courseList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("15", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("travel16", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("crsKorNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*검색하고자 하는 코스명 (인코딩 필요)*/
        urlBuilder.append("&" + URLEncoder.encode("routeIdx","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*코스에 해당하는 길번호*/
        urlBuilder.append("&" + URLEncoder.encode("crsLevel","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*코스 난이도(1:하/2:중/3:상)*/
        urlBuilder.append("&" + URLEncoder.encode("brdDiv","UTF-8") + "=" + URLEncoder.encode("DNWW", "UTF-8")); /*걷기/자전거 구분(DNWW : 걷기길, DNBW : 자전거길)*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));  //json리턴

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //url 오픈해라
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        return sb.toString();
    }
    @GetMapping("/getwalking3")
    public String getwalking3() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/Durunubi/courseList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("travel16", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("crsKorNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*검색하고자 하는 코스명 (인코딩 필요)*/
        urlBuilder.append("&" + URLEncoder.encode("routeIdx","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*코스에 해당하는 길번호*/
        urlBuilder.append("&" + URLEncoder.encode("crsLevel","UTF-8") + "=" + URLEncoder.encode("2", "UTF-8")); /*코스 난이도(1:하/2:중/3:상)*/
        urlBuilder.append("&" + URLEncoder.encode("brdDiv","UTF-8") + "=" + URLEncoder.encode("DNWW", "UTF-8")); /*걷기/자전거 구분(DNWW : 걷기길, DNBW : 자전거길)*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));  //json리턴

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //url 오픈해라
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        return sb.toString();
    }
    @GetMapping("/getwalking4")
    public String getwalking4() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/Durunubi/courseList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("15", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("travel16", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("crsKorNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*검색하고자 하는 코스명 (인코딩 필요)*/
        urlBuilder.append("&" + URLEncoder.encode("routeIdx","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*코스에 해당하는 길번호*/
        urlBuilder.append("&" + URLEncoder.encode("crsLevel","UTF-8") + "=" + URLEncoder.encode("2", "UTF-8")); /*코스 난이도(1:하/2:중/3:상)*/
        urlBuilder.append("&" + URLEncoder.encode("brdDiv","UTF-8") + "=" + URLEncoder.encode("DNWW", "UTF-8")); /*걷기/자전거 구분(DNWW : 걷기길, DNBW : 자전거길)*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));  //json리턴

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //url 오픈해라
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        return sb.toString();
    }
    @GetMapping("/getwalking5")
    public String getwalking5() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/Durunubi/courseList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("travel16", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("crsKorNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*검색하고자 하는 코스명 (인코딩 필요)*/
        urlBuilder.append("&" + URLEncoder.encode("routeIdx","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*코스에 해당하는 길번호*/
        urlBuilder.append("&" + URLEncoder.encode("crsLevel","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*코스 난이도(1:하/2:중/3:상)*/
        urlBuilder.append("&" + URLEncoder.encode("brdDiv","UTF-8") + "=" + URLEncoder.encode("DNWW", "UTF-8")); /*걷기/자전거 구분(DNWW : 걷기길, DNBW : 자전거길)*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));  //json리턴

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //url 오픈해라
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        return sb.toString();
    }
}
