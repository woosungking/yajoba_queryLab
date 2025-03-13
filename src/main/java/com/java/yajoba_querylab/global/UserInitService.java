package com.java.yajoba_querylab.global;


import com.java.yajoba_querylab.domain.user.UserRepository;
import com.java.yajoba_querylab.domain.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserInitService {

    private final UserRepository userRepository;

    public UserInitService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createDummyUser(){

        int phoneNum=10;
        String email = "aasd";
        String nickName = "jhon";
        String password = "pass";
        for(int i=0; i<3000; i++ ){
            User user = User.builder()
                    .nickname(nickName + String.valueOf(phoneNum))
                    .build();
            phoneNum ++;
            userRepository.save(user);
        }
    }
}
