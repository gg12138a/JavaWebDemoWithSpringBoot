package zjou.gxy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjou.gxy.demo.bean.User;
import zjou.gxy.demo.mapper.UserMapper;
import zjou.gxy.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;

	public  User validate(User u) {
		return userMapper.getByUsernameAndPassword(u);
	}
}
