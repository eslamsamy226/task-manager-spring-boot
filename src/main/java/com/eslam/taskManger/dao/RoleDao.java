package com.eslam.taskManger.dao;

import com.eslam.taskManger.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String name);
}
