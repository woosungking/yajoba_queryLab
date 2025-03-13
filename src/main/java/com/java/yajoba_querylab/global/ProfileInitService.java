package com.java.yajoba_querylab.global;


import com.java.yajoba_querylab.domain.profile.ProfileRepository;
import com.java.yajoba_querylab.domain.profile.entity.Profile;
import com.java.yajoba_querylab.domain.user.UserRepository;
import com.java.yajoba_querylab.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileInitService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public void initProfile() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            String intro = user.getNickname() + "님의 프로필입니다.";

            Profile profile = Profile.builder()
                    .intro(intro)
                    .user(user)
                    .build();

            profileRepository.save(profile);
        }
    }
}


