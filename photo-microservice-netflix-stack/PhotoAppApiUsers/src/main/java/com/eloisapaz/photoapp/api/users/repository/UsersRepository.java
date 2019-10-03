package com.eloisapaz.photoapp.api.users.repository;

import org.springframework.data.repository.CrudRepository;
import com.eloisapaz.photoapp.api.users.entity.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long>{

}
