package monthsago.travel16.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONObject;
import org.json.XML;
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
public class LocationController {

    @GetMapping("/daejeon") //대전
    public String daejeon() throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6300000/tourDataService/tourDataListJson"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("dcode","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*서비스분류코드표관광자원분류탭참조*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
       return sb.toString();
    }
    @GetMapping("/busan") //busan
    public String busan() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/AttractionService/getAttractionKr"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
       // urlBuilder.append("&" + URLEncoder.encode("UC_SEQ","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 ID*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        //System.out.println(sb.toString());
        return sb.toString();
    }

//    @GetMapping("/daegu") //busan
//    public String daegu() throws IOException {
//        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6270000/getTourKorAttract/getTourKorAttractList?pageNo=1&numOfRows=10&ServiceKey=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*URL*/
//        //urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
//        //urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
//        //urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//       // urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
//        //urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
//        URL url = new URL(urlBuilder.toString());
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        System.out.println("Response code: " + conn.getResponseCode());
//        BufferedReader rd;
//        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        } else {
//            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//        }
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = rd.readLine()) != null) {
//            sb.append(line);
//        }
//        rd.close();
//        conn.disconnect();
//        return sb.toString();
//    }
    @GetMapping("/kyoungsang") //busan
    public String kyoungsang() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6480000/gyeongnamtouristspot/gyeongnamtouristspotlist"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
    }
    @GetMapping("/ulsan") //json이 아닌 xml로 넘어옴
    public String ulsan() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://data.ulsan.go.kr/rest/ulsantravelbusiness/getUlsanTravelBusinessList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        //urlBuilder.append("&" + URLEncoder.encode("entId","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*고유번호*/
        //urlBuilder.append("&" + URLEncoder.encode("title","UTF-8") + "=" + URLEncoder.encode("(주)평화관광", "UTF-8")); /*상호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        JSONObject jObject = XML.toJSONObject(sb.toString());
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(jObject.toString(), Object.class);
        String output = mapper.writeValueAsString(json);
        System.out.println(output);

        return output;
    }
   @GetMapping("/incheon") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String incheon() throws IOException {
       StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15089786/v1/uddi:a4e95abe-cd5b-46da-a92b-b15270103a6b?page=1&perPage=10&serviceKey=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*URL*/
       /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
        */
       URL url = new URL(urlBuilder.toString());
       HttpURLConnection conn = (HttpURLConnection) url.openConnection();
       conn.setRequestMethod("GET");
       conn.setRequestProperty("Content-type", "application/json");
       System.out.println("Response code: " + conn.getResponseCode());
       BufferedReader rd;
       if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
       return sb.toString();
    }
    @GetMapping("/Jeonnam") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String Jeonnam() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15041996/v1/uddi:4b00bc2c-6382-467b-92b4-927a2221eee5?page=1&perPage=10&serviceKey=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*URL*/
        /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
        }
    @GetMapping("/Gyeongbug") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String Gyeongbug() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15069224/v1/uddi:4085d9b8-1519-442d-992a-8de02ab3b8b7?page=1&perPage=10&serviceKey=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*URL*/
        /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
    }
    @GetMapping("/gyounggi") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String gyounggi() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://openapi.gg.go.kr/TouristResort"); /*URL*/
        /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
    }

    @GetMapping("/gangwon_chuncheon") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String gangwon_chuncheon() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/3034556/v1/uddi:6f124007-79f5-4031-a398-985b5c058028?page=1&perPage=100&serviceKey=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*URL*/
        /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
    }
    @GetMapping("/gangwon_donghae") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String gangwon_donghae() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15029894/v1/uddi:b3fca087-3350-452a-8c91-8cd3991db152_201907241629?page=1&perPage=100&serviceKey=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*URL*/
        /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
    }
    //http://openapi.seoul.go.kr:8088/(인증키)/xml/TbVwAttractions/1/5/
    @GetMapping("/seoul") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String seoul() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088/6a50724c517768673131396d4645584c/xml/SebcTourStreetKor/1/5/"); /*URL*/
        /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        JSONObject jObject = XML.toJSONObject(sb.toString());
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(jObject.toString(), Object.class);
        String output = mapper.writeValueAsString(json);
        System.out.println(output);

        return output;
    }

    //http://api.kcisa.kr/openapi/service/rest/other/getGWAN4301
    @GetMapping("/Gwangju") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String Gwangju() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://api.kcisa.kr/openapi/service/rest/other/getGWAN4301?numOfRows=100&pageNo=1&serviceKey=4ae3e433-92cb-4167-b639-ed9ee680e5d4"); /*URL*/
        /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        JSONObject jObject = XML.toJSONObject(sb.toString());
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Object json = mapper.readValue(jObject.toString(), Object.class);
        String output = mapper.writeValueAsString(json);
        System.out.println(output);

        return output;
    }

//https://tour.chungbuk.go.kr/openapi/tourInfo/attr.do
    @GetMapping("/Chungbug") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String Chungbug() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://tour.chungbuk.go.kr/openapi/tourInfo/attr.do"); /*URL*/
        /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
    }
    @GetMapping("/Jeonbug") //json이 아닌 xml로 넘어옴 // xml to json으로
    public String Jeonbug() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/3081273/v1/uddi:515a102d-e35c-4505-8f80-e03e7b640456?page=1&perPage=100&serviceKey=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); /*URL*/
        /* urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=ZyXbs3ggoxjvBgNnPZIbqucXxkimzEhCbTUf2TCX6PoRp%2BTOPYloYNtCYjVBaZzDEm8tpcfCZJW6RVoIRejKpg%3D%3D"); *//*Service Key*//*
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); *//*공공데이터포털에서 받은 인증키*//*
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); *//*페이지번호*//*
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); *//*한 페이지 결과 수*//*
        urlBuilder.append("&" + URLEncoder.encode("","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); *//**//*
         */
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
    }
}
