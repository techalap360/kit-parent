package com.kit.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.model.entity.CodeType;
import com.kit.model.entity.pk.CodeTypePK;

/**
 * @author Zubayer Ahamed
 * @since Apr 19, 2021
 */
@Repository
public interface CodeTypeRepository extends JpaRepository<CodeType, CodeTypePK>{

}
