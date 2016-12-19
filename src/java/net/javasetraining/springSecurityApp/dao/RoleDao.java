package net.javasetraining.springSecurityApp.dao;

import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by MaRV on 12/18/2016.
 */
public interface RoleDao extends JpaRepository <Role, Long >{
}
