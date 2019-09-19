/**
 * FileName: ResourceServiceImpl
 * Author:   大橙子
 * Date:     2019/8/8 10:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.service.impl;

import com.meng.shiro.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 大橙子
 * @create 2019/8/8
 * @since 1.0.0
 */

@Transactional(transactionManager = "dataSourceTransactionManager", rollbackFor = Exception.class)
@Service
public class ResourceServiceImpl implements ResourceService {
}
