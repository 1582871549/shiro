package com.meng.user.repository.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolePermssion implements Serializable {

    private Long roleId;
    private Long permissionId;

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (this == o) {
            return true;
        }

        RolePermssion other = (RolePermssion) o;

        if (permissionId != null ? !permissionId.equals(other.permissionId) : other.permissionId != null) {
            return false;
        }

        if (roleId != null ? !roleId.equals(other.roleId) : other.roleId != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
        return result;
    }
}
