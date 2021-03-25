package com.fred.authshiro.response.user;

import com.fred.authshiro.model.TbMenu;
import lombok.Data;

import java.util.List;

/**
 * @author Fred
 * @date 2021/3/25 20:29
 */
@Data
public class UserInfoResponse {
    private List<String> roles;
    private List<TbMenu> menus;
    private String name = "Super Admin";
    private String avatar = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif";
    private String introduction = "I am a super administrator";
}
