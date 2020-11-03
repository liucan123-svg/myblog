/**
 * Copyright (C), 2015-2020, LSTAR
 * FileName: FriendsShowController
 * Author:   OneStar
 * Date:     2020/2/23 16:18
 * Description: 友人帐页面
 * History:
 * <author>          <time>          <version>          <desc>
 * oneStar           修改时间           版本号              描述
 */
package com.xsh.web;

import com.xsh.dao.FriendLinkRespository;
import com.xsh.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FriendsShowController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public String friends(Model model) {
        model.addAttribute("friendlinks",friendLinkService.listFriendlinks());
        return "friends";
    }
}