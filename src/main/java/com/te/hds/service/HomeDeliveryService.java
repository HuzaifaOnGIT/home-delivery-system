package com.te.hds.service;

import com.te.hds.dto.UserDto;
import com.te.hds.entity.User;

public interface HomeDeliveryService {

	User addUser(UserDto userDto);

	void deleteUser(Long id);

	User updateUser(UserDto userDto);

	User getUser(UserDto userDto);

}
