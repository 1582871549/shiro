package com.meng.user.shiro.permission;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.Permission;
import org.thymeleaf.expression.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 规则
 * +资源字符串+权限位+实例ID
 * <p>
 * 以+开头 中间通过+分割
 * <p>
 * 权限：
 * 0 表示所有权限
 * 1 新增 0001
 * 2 修改 0010
 * 4 删除 0100
 * 8 查看 1000
 * <p>
 * 如 +user+10 表示对资源user拥有修改/查看权限
 * <p>
 * 不考虑一些异常情况
 *
 * <p>UserDO: Zhang Kaitao
 * <p>Date: 14-1-26
 * <p>Version: 1.0
 */
public class BitPermission implements Permission {

    private static final String PART_DIVIDER_TOKEN = ":";
    private static final String SUBPART_DIVIDER_TOKEN = ",";

    private List<Set<String>> parts;

    private String resourceId;
    private int permissionBit;
    private String instanceId;

    public BitPermission(String bitString) {

        String[] array = bitString.split("\\+");

        if (array.length > 1) {
            resourceId = array[1];
        }

        if (StringUtils.isEmpty(resourceId)) {
            resourceId = "*";
        }

        if (array.length > 2) {
            permissionBit = Integer.valueOf(array[2]);
        }

        if (array.length > 3) {
            instanceId = array[3];
        }

        if (StringUtils.isEmpty(instanceId)) {
            instanceId = "*";
        }

    }

    protected void setParts(String bitString) {

        String clean = StringUtils.trim(bitString);

        if (StringUtils.isBlank(clean)) {
            throw new IllegalArgumentException("bit string cannot be null or empty. Make sure permission strings are properly formatted.");
        }

        String[] parts = bitString.split(PART_DIVIDER_TOKEN);

        this.parts = new ArrayList<>();

        for (String part : parts) {

            String[] split = part.split(SUBPART_DIVIDER_TOKEN);

            Set<String> subparts = new HashSet<>();

            if (subparts.isEmpty()) {
                throw new IllegalArgumentException("bit string cannot contain parts with only dividers. Make sure permission strings are properly formatted.");
            }
            this.parts.add(subparts);
        }

        if (this.parts.isEmpty()) {
            throw new IllegalArgumentException("bit string cannot contain only dividers. Make sure permission strings are properly formatted.");
        }
    }



    @Override
    public boolean implies(Permission p) {

        if (!(p instanceof BitPermission)) {
            return false;
        }

        BitPermission other = (BitPermission) p;

        if (!("*".equals(this.resourceId) || this.resourceId.equals(other.resourceId))) {
            return false;
        }

        if (!(this.permissionBit == 0 || (this.permissionBit & other.permissionBit) != 0)) {
            return false;
        }

        if (!("*".equals(this.instanceId) || this.instanceId.equals(other.instanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BitPermission{" +
                "resourceId='" + resourceId + '\'' +
                ", permissionBit=" + permissionBit +
                ", instanceId='" + instanceId + '\'' +
                '}';
    }
}
