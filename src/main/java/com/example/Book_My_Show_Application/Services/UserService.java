package com.example.Book_My_Show_Application.Services;

import com.example.Book_My_Show_Application.Entities.UserEntity;
import com.example.Book_My_Show_Application.EntryDtos.UserEntryDto;
import com.example.Book_My_Show_Application.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserEntryDto userEntryDto){
        // Here we  need to convert in User Entity and then save
        /*

         old method: create an object and set attributes.
            we are doing something like that
         userEntity .setAge(userEntryDto.getAge());

         */

        // New Method: now using @Builder which we provide on top the class of that entity

        UserEntity userEntity=UserEntity.builder().age(userEntryDto.getAge()).mobNo(userEntryDto.getMobNo()).address(userEntryDto.getAddress()).name(userEntryDto.getName())
                .email(userEntryDto.getEmail()).build();

        userRepository.save(userEntity);
        // This is to set all the attributes in 1 go.
    }
}
