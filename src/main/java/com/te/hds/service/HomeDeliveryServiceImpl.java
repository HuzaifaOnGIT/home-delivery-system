package com.te.hds.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.hds.dto.DeliveryPersonDto;
import com.te.hds.dto.UserDto;
import com.te.hds.entity.DeliveryPerson;
import com.te.hds.entity.User;
import com.te.hds.repository.DeliveryGuyRepository;
import com.te.hds.repository.HomeDeliveryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HomeDeliveryServiceImpl implements HomeDeliveryService {
	
	@Autowired
	private HomeDeliveryRepository homeDeliveryRepository;
	
	private DeliveryGuyRepository deliveryGuyRepository;

	@Override
	public User addUser(UserDto userDto) {
		String methodName = "addUser";
		User entity = null;
		try {

			entity = new User();
			BeanUtils.copyProperties(userDto, entity);
			Optional<User> findById = homeDeliveryRepository.findById(entity.getUserId());
			if (findById.isPresent()) {

				log.error(methodName, "Batch already exists with this Id", entity);
				throw new RuntimeException("Batch already exists with this Id");
			}

			entity = homeDeliveryRepository.save(entity);
			if (entity == null) {
				log.info(methodName, " Null value received ", entity);
				throw new RuntimeException("Batch not saved");

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(methodName + e.getMessage());
		}
		return entity;
	}

	@Override
	public void deleteUser(Integer id) {
		try {
			Optional<User> findById = homeDeliveryRepository.findById(id);
			if (!findById.isPresent()) {
				throw new RuntimeException("Batch Details Not Present On This ID");
			} else {
				homeDeliveryRepository.delete(findById.get());
				;
			}

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public User updateUser(UserDto userDto) {
		String methodName = "updateUser";
		User save = null;

		Optional<User> findById = homeDeliveryRepository.findById(userDto.getUserId());
		try {
			if (!findById.isPresent()) {
				throw new RuntimeException("Batch Not Found Select Correct BatchID");
			} else {

				findById.get().setUserName(userDto.getUserName());
				findById.get().setAddress(userDto.getAddress());
				

				save = homeDeliveryRepository.save(findById.get());
			}
		} catch (RuntimeException e) {
			log.error(methodName + e.getMessage());
			throw e;
		}
		return save;
	}

	@Override
	public User getUser(Integer id) {
		String methodName = "getUser";
		User search = null;
		try {
			 Optional<User> findById = homeDeliveryRepository.findById(id);
			if (findById.isEmpty()) {
				throw new RuntimeException("user Not Found");
			}
			search=findById.get();
		} catch (Exception e) {
			log.error(methodName + "==========>" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return search;
	}

	@Override
	public DeliveryPerson addDeliveryPerson(DeliveryPersonDto dto) {
		String methodName = "addDeliveryPerson";
		DeliveryPerson entity = null;
		try {

			entity = new DeliveryPerson();
			BeanUtils.copyProperties(dto, entity);
			Optional<DeliveryPerson> findById = deliveryGuyRepository.findById(dto.getDeliveryPersonId());
			if (findById.isPresent()) {

				log.error(methodName, "DeliveryPerson already exists with this Id", entity);
				throw new RuntimeException("DeliveryPerson already exists with this Id");
			}

			entity = deliveryGuyRepository.save(entity);
			if (entity == null) {
				log.info(methodName, " Null value received ", entity);
				throw new RuntimeException("Batch not saved");

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(methodName + e.getMessage());
		}
		return entity;
	}

	@Override
	public void deleteDeliveryPerson(Integer id) {
		try {
			Optional<DeliveryPerson> findById = deliveryGuyRepository.findById(id);
			if (!findById.isPresent()) {
				throw new RuntimeException("DeliveryPerson Details Not Present On This ID");
			} else {
				deliveryGuyRepository.delete(findById.get());
				;
			}

		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public DeliveryPerson updateDeliveryPerson(DeliveryPersonDto dto) {
		String methodName = "updateDeliveryPerson";
		DeliveryPerson entity = null;
		try {

			
			Optional<DeliveryPerson> findById = deliveryGuyRepository.findById(dto.getDeliveryPersonId());
			if (findById.isEmpty()) {

				log.error(methodName, "DeliveryPerson Does not exists with this Id", entity);
				throw new RuntimeException("DeliveryPerson Does not exists with this Id");
			}
			findById.get().setDeliveryGuyName(dto.getDeliveryGuyName());
			findById.get().setAvailableFrom(dto.getAvailableFrom());
			findById.get().setAvailableTo(dto.getAvailableTo());
			findById.get().setLocation(dto.getLocation());
			findById.get().setAvailability(dto.isAvailability());
			
			

			entity = deliveryGuyRepository.save(findById.get());
			if (entity == null) {
				log.info(methodName, " Null value received ", entity);
				throw new RuntimeException("DeliveryPerson not Updated");

			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(methodName + e.getMessage());
		}
		return entity;
	}

	@Override
	public DeliveryPerson getDeliveryPerson(Integer id) {
		String methodName = "getDeliveryPerson";
		DeliveryPerson search = null;
		try {
			 Optional<DeliveryPerson> findById = deliveryGuyRepository.findById(id);
			if (findById.isEmpty()) {
				throw new RuntimeException("user Not Found");
			}
			search=findById.get();
		} catch (Exception e) {
			log.error(methodName + "==========>" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return search;
	}

}
