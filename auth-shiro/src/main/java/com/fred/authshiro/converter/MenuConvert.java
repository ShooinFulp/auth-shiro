package com.fred.authshiro.converter;

import com.fred.authshiro.model.TbMenu;
import com.fred.authshiro.request.menu.AddRequest;
import com.fred.authshiro.request.menu.UpdateRequest;
import org.springframework.beans.BeanUtils;

/**
 * @author Fred
 * @date 2021/3/27 20:55
 */
public class MenuConvert {

    public static TbMenu addRequest2Model(AddRequest addRequest) {
        TbMenu menu = new TbMenu();
        BeanUtils.copyProperties(addRequest, menu);
        return menu;
    }

    public static TbMenu updateRequest2Model(UpdateRequest updateRequest) {
        TbMenu menu = new TbMenu();
        BeanUtils.copyProperties(updateRequest, menu);
        //menu.setHidden(updateRequest.getHidden());
        return menu;
    }
}
