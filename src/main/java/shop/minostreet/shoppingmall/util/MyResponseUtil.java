package shop.minostreet.shoppingmall.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import shop.minostreet.shoppingmall.dto.ResponseDto;

import javax.servlet.http.HttpServletResponse;

public class MyResponseUtil {
    private static final Logger log = LoggerFactory.getLogger(MyResponseUtil.class);
    //fail로 리팩토링
//    public static void unAuthentication(HttpServletResponse response, String msg){
//        //파싱 오류가 날 경우 예외 처리
//        try{
//            //응답을 JSON으로 만들기
//            ObjectMapper objectMapper=new ObjectMapper();
////            ResponseDto<?> responseDto=new ResponseDto<>(-1, "인증되지 않은 사용자", null);
//            ResponseDto<?> responseDto=new ResponseDto<>(-1, msg, null);
//            String responseBody = objectMapper.writeValueAsString(responseDto);
//
//            response.setContentType("application/json; charset=utf-8");
//            response.setStatus(401);
//            //response.getWriter().println("error");
//            response.getWriter().println(responseBody);
//            //공통적인 응답 DTO 작성 필요
//        }catch (Exception e){
//            log.error("서버 파싱 에러");
//
//        }
//    }
    public static void unAuthorization(HttpServletResponse response, String msg){
        //파싱 오류가 날 경우 예외 처리
        try{
            //응답을 JSON으로 만들기
            ObjectMapper objectMapper=new ObjectMapper();
//            ResponseDto<?> responseDto=new ResponseDto<>(-1, "권한이 없는 사용자", null);
            ResponseDto<?> responseDto=new ResponseDto<>(-1, msg, null);
            String responseBody = objectMapper.writeValueAsString(responseDto);

            response.setContentType("application/json; charset=utf-8");
            response.setStatus(403);
            //response.getWriter().println("error");
            response.getWriter().println(responseBody);
            //공통적인 응답 DTO 작성 필요
        }catch (Exception e){
            log.error("서버 파싱 에러");

        }
    }

    public static void success(HttpServletResponse response, Object dto){
        //파싱 오류가 날 경우 예외 처리
        try{
            //응답을 JSON으로 만들기
            ObjectMapper objectMapper=new ObjectMapper();
            ResponseDto<?> responseDto=new ResponseDto<>(1,  "로그인 완료", dto);
            String responseBody = objectMapper.writeValueAsString(responseDto);

            response.setContentType("application/json; charset=utf-8");
            response.setStatus(200);
            //response.getWriter().println("error");
            response.getWriter().println(responseBody);
            //공통적인 응답 DTO 작성 필요
        }catch (Exception e){
            log.error("서버 파싱 에러");

        }
    }

    public static void fail(HttpServletResponse response, String msg, HttpStatus httpStatus){
        //파싱 오류가 날 경우 예외 처리
        try{
            //응답을 JSON으로 만들기
            ObjectMapper objectMapper=new ObjectMapper();
//            ResponseDto<?> responseDto=new ResponseDto<>(-1, "인증되지 않은 사용자", null);
            ResponseDto<?> responseDto=new ResponseDto<>(-1, msg, null);
            String responseBody = objectMapper.writeValueAsString(responseDto);

            response.setContentType("application/json; charset=utf-8");
            response.setStatus(httpStatus.value());    //권한 없음 에러
            //response.getWriter().println("error");
            response.getWriter().println(responseBody);
            //공통적인 응답 DTO 작성 필요
        }catch (Exception e){
            log.error("서버 파싱 에러");

        }
    }
}
