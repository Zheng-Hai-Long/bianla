package com.bianla.admin.repostory;

import com.bianla.admin.entity.ActionUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 2018/10/28.
 */
public interface ActionUserRepostory extends JpaRepository<ActionUser, Integer> {

    ActionUser findByActionNameAndActionPwd(String userName, String password);
}
