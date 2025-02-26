package shop.minostreet.shoppingmall.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserEnum {
    ADMIN("관리자"), CUSTOMER("고객"), SELLER("판매자") ;

    private String value;
}
