package com.nestdigital.empApp.Dao;

import com.nestdigital.empApp.Model.EmpModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpDao extends CrudRepository<EmpModel,Integer> {

    @Modifying
    @Query (value = "DELETE FROM `employees` WHERE `id`=:id",nativeQuery = true)

    void deleteEmpById(Integer id);

    @Query(value = "SELECT `id`, `salary`, `company`, `designation`, `dob`, `doj`, `email`, `empcode`, `name`, `phone` FROM `employees` WHERE `name`=:name",nativeQuery = true)
    List<EmpModel> searchemp(String name);
}
