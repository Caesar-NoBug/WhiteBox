package org.caesar.model;

import org.caesar.domain.user.vo.UserPreferVO;
import org.caesar.model.entity.UserExtra;
import org.caesar.model.po.UserExtraPO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MsUserExtraStruct {

    UserExtra POtoDO(UserExtraPO userExtraPO);

    UserExtraPO DOtoPO(UserExtra userExtra);

    UserPreferVO DOtoPreferVO(UserExtra userExtra);
}
