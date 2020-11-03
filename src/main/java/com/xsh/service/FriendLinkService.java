
package com.xsh.service;

import com.xsh.pojo.FriendLink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FriendLinkService {

    List<FriendLink> listFriendlinks();

    FriendLink saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLink(Long id);

    Page<FriendLink> listFriendLink(Pageable pageable);

    FriendLink updateFriendLink(Long id,FriendLink friendLink);

    void deleteFriendLink(Long id);

}