package com.xsh.dao;

import com.xsh.pojo.Comment;
import com.xsh.pojo.Message;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface MessageRepository  extends JpaRepository<Message,Long>, JpaSpecificationExecutor<Message> {

}
