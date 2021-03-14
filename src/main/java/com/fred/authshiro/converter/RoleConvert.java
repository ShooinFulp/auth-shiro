package com.fred.authshiro.converter;

import com.fred.authshiro.model.TbRole;
import com.fred.authshiro.model.TbUser;
import com.fred.authshiro.request.role.AddRequest;
import com.fred.authshiro.request.role.UpdateRequest;
import org.springframework.beans.BeanUtils;

/**
 * 〈功能概述〉
 *
 * @author: Fred
 * @date: 2021/3/14 9:59 下午
 */
public class RoleConvert {
    public static TbRole addRequest2Model(AddRequest addRequest) {
        TbRole role = new TbRole();
        BeanUtils.copyProperties(addRequest, role);
        return role;
    }

    public static TbRole updateRequest2Model(UpdateRequest updateRequest) {
        TbRole role = new TbRole();
        BeanUtils.copyProperties(updateRequest, role);
        return role;
    }

}
