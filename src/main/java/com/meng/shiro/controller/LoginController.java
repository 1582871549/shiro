/**
 * FileName: LoginController
 * Author:   大橙子
 * Date:     2019/3/25 22:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.meng.shiro.controller;

import com.meng.shiro.base.BaseController;
import com.meng.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 * 登陆接口
 * </p>
 *
 * @author 大橙子
 * @date 2019/3/25
 * @RequiresPermissions(value={"permission:view","permission:aix"}, logical= Logical.AND) 同时具有
 * @RequiresPermissions(value={"permission:view","permission:aix"}, logical= Logical.OR)  一个就行
 * @since 1.0.0
 */
@Controller
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 跳转登陆页
     * 已通过验证的用户跳转主页(不包含 记住我 的用户)
     * 未通过验证的用户重定向到登陆页
     *
     * @return path
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (SecurityUtils.getSubject() != null && SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    // UserDTO userDTO = new UserDTO();
    // BeanUtils.copyProperties(userVO, userDTO);
    // success(ReturnCodeEnum.SUCCESS.getCode(), "");

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) {

        log.info("into the login method ...");
        // 登录失败从request中获取shiro处理的异常信息。shiroLoginFailure:就是shiro异常类的全类名.
        Object exception = request.getAttribute("shiroLoginFailure");
        String msg;
        if (exception != null) {
            if (UnknownAccountException.class.isInstance(exception)) {
                msg = "用户名不正确，请重新输入";
            } else if (IncorrectCredentialsException.class.isInstance(exception)) {
                msg = "密码错误，请重新输入";
            } else {
                msg = "发生未知错误，请联系管理员。";
            }
            map.put("username", request.getParameter("username"));
            map.put("password", request.getParameter("password"));
            map.put("msg", msg);
            return "login";
        }
        //如果已经登录，直接跳转主页面
        return "index";
    }

    @RequestMapping(value = "/logOut", method = RequestMethod.GET)
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }

    /**
     * 主页
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(HttpSession session, Model model) {

        if (SecurityUtils.getSubject() != null && SecurityUtils.getSubject().hasRole("")) {

            session.setAttribute("toket", "111");
        }
        return "index";
    }

    /**
     * 欢迎页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request, Model model) {
        return "welcome";
    }

}
