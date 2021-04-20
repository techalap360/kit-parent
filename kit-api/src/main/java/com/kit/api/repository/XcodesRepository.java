package com.kit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.model.entity.Xcodes;
import com.kit.model.entity.pk.XcodesPK;

/**
 * @author Zubayer Ahamed
 * @since Apr 20, 2021
 */
@Repository
public interface XcodesRepository extends JpaRepository<Xcodes, XcodesPK>{

}
