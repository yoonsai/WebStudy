package com.sist.manager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sist.vo.*;
import java.util.*;
public class NewsManager {
	public static void main(String[] args) {
		newsSearchData("맛집");
	}
	public static List<NewsVO> newsSearchData(String fd) {
		List<NewsVO> list=new ArrayList<NewsVO>();
        String clientId = "y3gGxXM0gEarmXWs8jCv"; //애플리케이션 클라이언트 아이디
        String clientSecret = "wBuCGuR5Qf"; //애플리케이션 클라이언트 시크릿


        String text = null;
        try {
            text = URLEncoder.encode(fd, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/blog?display=100&query=" + text;    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);


        //System.out.println(responseBody);
        try {
        	JSONParser jp=new JSONParser();
        	JSONObject root=(JSONObject)jp.parse(responseBody);
        	JSONArray arr=(JSONArray)root.get("items");
        	//System.out.println(arr.toJSONString());
        	
        	for(int i=0;i<arr.size();i++)
        	{
        		NewsVO vo=new NewsVO();
        		JSONObject obj=(JSONObject)arr.get(i);
        		String title=(String)obj.get("title");
        		String content=(String)obj.get("description");
        		String link=(String)obj.get("link");
        		String date=(String)obj.get("postdate");
        		vo.setTitle(title);
        		vo.setContent(content);
        		vo.setLink(link);
        		vo.setDate(date);
        		list.add(vo);
        		
        	}
        }catch(Exception e) {}
        
        return list;
    }


    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 오류 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
        }
    }
}
