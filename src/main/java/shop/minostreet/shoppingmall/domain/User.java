package shop.minostreet.shoppingmall.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import shop.minostreet.shoppingmall.handler.exception.MyApiException;

import javax.persistence.*;
import java.time.LocalDateTime;

//Audit 기능 사용하기 위한 어노테이션 1
@EntityListeners(AuditingEntityListener.class)
//Spring이 User 객체 생성시 빈생성자로 생성하기 때문에
@NoArgsConstructor
@Getter
@Table(name = "user_tb")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false, length =20)
    private String username;

    @Column(unique = false, length =60)
    //BCrypt로 인코딩시 늘어나기 때문에
    private String password;

    @Column(unique = false, length =20)

    private String email;

    //Audit 기능 사용하기 위한 어노테이션 2
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserEnum role; // USER(고객), SELLER(판매자), ADMIN(관리자)

    //사용자의 활성여부
    @Column(nullable = false, length = 10)
    private Boolean status; //true 활성, false 비활성계정


    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    //User와 관련된 메서드 작성 - 객체 상태 변경


    //권한 변경 (관리자)
    //: 관리자 권한 설정하는 메서드로 setter를 사용하지 않고, 의미있는 메서드를 작성한다.
    public void updateRole(UserEnum role){
        if(this.role.equals(role)){
            //checkpoint : throw 동일한 권한으로 변경할 수 없습니다.
            throw new MyApiException("동일한 권한으로 변경할 수 없습니다.");
        }
        this.role=role;
    }

    //활성상태 변경 (관리자)
    //: 관리자 권한 설정하는 메서드로 setter를 사용하지 않고, 의미있는 메서드를 작성한다.
    public void updateStatus(boolean status){
        if(this.status.equals(status)){
            //checkpoint : throw 동일한 상태로 변경할 수 없습니다.
            throw new MyApiException("이미 동일한 상태입니다.");
        }
        this.status=status;
    }

    //회원 탈퇴
    public void delete(){
        this.status=false;
    }


    @Builder
    public User(Long id, String username, String password, String email, UserEnum role, Boolean status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
