package com.example.demo.repository;

import com.example.demo.domain.User;
import com.example.demo.domain.UserDetail;
import com.example.demo.domain.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserRepositoryTests {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserDetailRepository userDetailRepository;

    @Test
    public void testSave() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

//        userRepository.save(new User("aa", "aa123456","aa@126.com", "aa",  formattedDate));
//        userRepository.save(new User("bb", "bb123456","bb@126.com", "bb",  formattedDate));
//        userRepository.save(new User("cc", "cc123456","cc@126.com", "cc",  formattedDate));

        Assert.assertEquals(2, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
        // userRepository.delete(userRepository.findByUserName("aa"));
    }

    @Test
    public void testPageQuery() {
        int page=1, size=2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        userRepository.findALL(pageable);
        userRepository.findByNickName("aa", pageable);
    }

    @Test
    public void testUserInfo() {
//        userDetailRepository.save(new UserDetail("bb", "address1", "daqiu"));
//        userDetailRepository.save(new UserDetail("cc", "address2", "daqiu"));
//        userDetailRepository.save(new UserDetail("dd", "address3", "hello"));

        List<UserInfo> userInfos = userDetailRepository.findUserInfo("daqiu");
        for (UserInfo userInfo: userInfos) {
            System.out.println("address: " + userInfo.getAddress());
        }
    }
}
