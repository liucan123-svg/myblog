package com.xsh.dao;
import com.xsh.pojo.FriendLink;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FriendLinkRespository extends JpaRepository<FriendLink,Long> {

    FriendLink findByBlogname(String blogname);
}
