package com.fred.authshiro.converter;

import com.fred.authshiro.model.TbUser;
import com.fred.authshiro.request.user.AddRequest;
import com.fred.authshiro.request.user.QueryRequest;
import com.fred.authshiro.request.user.UpdateRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author Fred
 * @date 2021/3/13 11:51
 */
public class UserConvert {
    public static TbUser addRequest2Model(AddRequest addRequest) {
        TbUser user = new TbUser();
        BeanUtils.copyProperties(addRequest, user);
        return user;
    }

    public static TbUser updateRequest2Model(UpdateRequest updateRequest) {
        TbUser user = new TbUser();
        BeanUtils.copyProperties(updateRequest, user);
        return user;
    }

    public static TbUser queryRequest2Model(QueryRequest queryRequest) {
        if (ObjectUtils.isEmpty(queryRequest)) {
            return null;
        }
        TbUser user = new TbUser();
        BeanUtils.copyProperties(queryRequest, user);
        return user;
    }
}
