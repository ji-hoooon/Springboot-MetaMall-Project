package shop.mtcoding.metamall.dto.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.mtcoding.metamall.domain.Product;
import shop.mtcoding.metamall.domain.User;
import shop.mtcoding.metamall.domain.UserEnum;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ProductReqDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name; // 상품 이름
//    private Integer price; // 상품 가격
//    private Integer qty; // 상품 재고
    @Getter
    @Setter
    public static class ProductRegisterReqDto{
        //한글, 영문, 숫자만 가능하고, 길이는 2~20자만 가능하도록, 공백도 불가능
        @Pattern(regexp = "^[ㄱ-힣A-Za-z0-9]{2,20}$",message = "한글/영문/숫자 2~20자 이내로 작성해 주세요.")
        @NotEmpty
        private String name;

        @Digits(integer = 3, fraction = 8)   //: 숫자의 길이 체크 최소 3자 최대 8자
        //최소 100원부터 ~ 9000만원까지
        private Integer price;

        @Digits(integer = 1, fraction = 4)   //: 숫자의 길이 체크 최소 3자 최대 8자
        //최소 1개부터 ~ 9999개까지
        private Integer qty;

        public Product toEntity(){
            return Product.builder()
                    .name(name)
                    .price(price)
                    .qty(qty)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class ProductUpdateReqDto{
        //한글, 영문, 숫자만 가능하고, 길이는 2~20자만 가능하도록, 공백도 불가능
        @Pattern(regexp = "^[ㄱ-힣A-Za-z0-9]{2,20}$",message = "한글/영문/숫자 2~20자 이내로 작성해 주세요.")
        @NotEmpty
        private String name;

        @Digits(integer = 3, fraction = 8)   //: 숫자의 길이 체크 최소 3자 최대 8자
        //최소 100원부터 ~ 9000만원까지
        private Integer price;

        @Digits(integer = 1, fraction = 4)   //: 숫자의 길이 체크 최소 3자 최대 8자
        //최소 1개부터 ~ 9999개까지
        private Integer qty;

        public Product toEntity(){
            return Product.builder()
                    .name(name)
                    .price(price)
                    .qty(qty)
                    .build();
        }
    }
}
