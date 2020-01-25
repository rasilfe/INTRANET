package br.com.capsule.FTP.role;

import br.com.capsule.FTP.mvc.repository.UserRepository;
import br.com.capsule.FTP.util.BeanUtil;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class RoleFactory extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {


    private Object filterObject;
    private Object returnObject;
    private Object target;

    private final UserRepository userRepository;

    public RoleFactory(Authentication authentication) {
        super(authentication);
        this.userRepository = BeanUtil.getBean(UserRepository.class);
    }


    boolean isAdmin() {
        return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getProfile().equals("ADM");
    }
    boolean isColaborador() {
        return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getProfile().equals("COL");
    }

    @Override
    public void setFilterObject(Object o) {
        this.filterObject = o;
    }


    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object o) {
        this.returnObject = o;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    @Override
    public Object getThis() {
        return target;
    }

    void setThis(Object target) {
        this.target = target;
    }

}