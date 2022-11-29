package com.te.hds.service;

import com.te.hds.dto.DeliveryPersonDto;
import com.te.hds.dto.UserDto;
import com.te.hds.entity.DeliveryPerson;
import com.te.hds.entity.User;

public interface HomeDeliveryService {

	User addUser(UserDto userDto);

	void deleteUser(Integer id);

	User updateUser(UserDto userDto);

	User getUser(Integer id);
	
	DeliveryPerson addDeliveryPerson(DeliveryPersonDto dto);
	
	void deleteDeliveryPerson(Integer id);
	
	DeliveryPerson updateDeliveryPerson(DeliveryPersonDto dto);
	
	DeliveryPerson getDeliveryPerson(Integer id);

}
