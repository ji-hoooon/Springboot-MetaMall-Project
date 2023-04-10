package shop.mtcoding.metamall.config.dummy;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.mtcoding.metamall.domain.User;
import shop.mtcoding.metamall.domain.UserEnum;

import java.time.LocalDateTime;

public class DummyObject {
    //모두 스태틱 메서드
    protected User newUser(String username){
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String encPassword = passwordEncoder.encode("1234");
        return User.builder()
                .username(username)
//                .password("1234")
                .password(encPassword)
                .email(username+"@nate.com")
                .role(UserEnum.CUSTOMER)
                .build();
    }
    protected static User newMockUser(Long id,String username){
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String encPassword = passwordEncoder.encode("1234");
        return User.builder()
                .id(id)
                .username(username)
//                .password("1234")
                .password(encPassword)
                .email(username+"@nate.com")
                .role(UserEnum.CUSTOMER)
                .build();
    }


}
